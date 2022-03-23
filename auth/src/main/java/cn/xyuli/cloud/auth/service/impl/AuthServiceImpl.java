package cn.xyuli.cloud.auth.service.impl;

import cn.xyuli.cloud.auth.dto.PhoneLoginDto;
import cn.xyuli.cloud.auth.dto.RegisterDto;
import cn.xyuli.cloud.auth.dto.UsernameLoginDto;
import cn.xyuli.cloud.auth.dto.VerificationCodeLoginDto;
import cn.xyuli.cloud.auth.service.AuthService;
import cn.xyuli.cloud.auth.service.TokenService;
import cn.xyuli.cloud.auth.service.UserService;
import cn.xyuli.cloud.auth.vo.LoginVo;
import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.entity.User;
import cn.xyuli.cloud.common.exception.BusinessException;
import cn.xyuli.cloud.common.util.TokenUtil;
import cn.xyuli.cloud.web.util.WebServerContext;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthServiceImpl
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 5:16 PM
 * @Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserService userService;
    @Resource
    private TokenService tokenService;

    @Override
    public LoginVo usernameLogin(UsernameLoginDto usernameLoginDto) {
        User user = userService.findByUsername(usernameLoginDto.getName());
        if (user == null || !user.getPwd().equals(usernameLoginDto.getPwd())){
            throw new BusinessException("用户名或密码错误");
        }
        Token token = tokenService.generateToken(user);
        if (token == null){
            throw new BusinessException("用户未登录");
        }
        return new LoginVo(token);
    }

    @Override
    public LoginVo phoneLogin(PhoneLoginDto phoneLoginDto) {
        User user = userService.findByPhone(phoneLoginDto.getPhone());
        if (user == null || !user.getPwd().equals(phoneLoginDto.getPwd())){
            throw new BusinessException("用户名或密码错误");
        }
        Token token = tokenService.generateToken(user);
        return new LoginVo(token);
    }

    @Override
    public LoginVo verificationCodeLogin(VerificationCodeLoginDto verificationCodeLoginDto) {
        throw new BusinessException("功能暂未开放");
    }

    @Override
    public void logout(HttpServletRequest serverHttpRequest) {
        tokenService.remove(WebServerContext.getToken().getToken());
    }

    @Override
    public LoginVo refresh(HttpServletRequest serverHttpRequest) {
        User user = userService.findByUserId(WebServerContext.getUserId());
        if (user == null){
            throw new BusinessException("用户不存在或已注销");
        }
        Token refresh = tokenService.refresh(user, WebServerContext.getToken());
        return new LoginVo(refresh);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginVo register(RegisterDto registerDto) {
        if (userService.findByUsername(registerDto.getName()) != null){
            throw new BusinessException("用户名已被注册，请重新选择用户名");
        }
        userService.addUser(registerDto.getName(),registerDto.getPwd());
        User user = userService.findByUsername(registerDto.getName());
        Token token = tokenService.generateToken(user);
        return new LoginVo(token);
    }
}
