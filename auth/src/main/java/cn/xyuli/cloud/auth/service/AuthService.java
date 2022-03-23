package cn.xyuli.cloud.auth.service;

import cn.xyuli.cloud.auth.dto.PhoneLoginDto;
import cn.xyuli.cloud.auth.dto.RegisterDto;
import cn.xyuli.cloud.auth.dto.UsernameLoginDto;
import cn.xyuli.cloud.auth.dto.VerificationCodeLoginDto;
import cn.xyuli.cloud.auth.vo.LoginVo;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 5:13 PM
 * @Version 1.0
 **/
@Service
public interface AuthService {
    /**
     * 登录
     * @param usernameLoginDto 用户名-密码登录信息
     */
    LoginVo usernameLogin(UsernameLoginDto usernameLoginDto);
    /**
     * 登录
     * @param phoneLoginDto 手机-密码登录信息
     */
    LoginVo phoneLogin(PhoneLoginDto phoneLoginDto);
    /**
     * 登录
     * @param verificationCodeLoginDto 验证码登录信息
     */
    LoginVo verificationCodeLogin(VerificationCodeLoginDto verificationCodeLoginDto);

    /**
     * 登出
     * @param serverHttpRequest 请求服务
     */
    void logout(HttpServletRequest serverHttpRequest);

    /**
     * 刷新token
     * @param serverHttpRequest 请求服务
     */
    LoginVo refresh(HttpServletRequest serverHttpRequest);

    /**
     * 注册
     * @param registerDto 注册请求体
     */
    LoginVo register(RegisterDto registerDto);
}
