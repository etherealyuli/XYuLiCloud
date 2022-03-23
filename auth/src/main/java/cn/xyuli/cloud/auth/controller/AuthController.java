package cn.xyuli.cloud.auth.controller;

import cn.xyuli.cloud.auth.dto.PhoneLoginDto;
import cn.xyuli.cloud.auth.dto.RegisterDto;
import cn.xyuli.cloud.auth.dto.UsernameLoginDto;
import cn.xyuli.cloud.auth.dto.VerificationCodeLoginDto;
import cn.xyuli.cloud.auth.service.AuthService;
import cn.xyuli.cloud.common.vo.R;
import cn.xyuli.cloud.web.annotation.NoLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthController
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 3:52 PM
 * @Version 1.0
 **/
@Slf4j
@RestController
@Api(tags = "授权相关接口")
@RequestMapping("auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @NoLogin
    @ApiOperation("用户名密码登录接口")
    @PostMapping("login/username")
    public R<?> userNameLogin(@Validated @RequestBody UsernameLoginDto usernameLoginDto){
        return R.success(authService.usernameLogin(usernameLoginDto));
    }
    @NoLogin
    @ApiOperation("手机号码密码登录接口")
    @PostMapping("login/phone")
    public R<?> phoneLogin(@Validated @RequestBody PhoneLoginDto phoneLoginDto){
        return R.success(authService.phoneLogin(phoneLoginDto));
    }
    @NoLogin
    @ApiOperation("验证码登录接口")
    @PostMapping("login/code")
    public R<?> verificationCodeLogin(@Validated @RequestBody VerificationCodeLoginDto verificationCodeLoginDto){
        return R.success(authService.verificationCodeLogin(verificationCodeLoginDto));
    }
    @ApiOperation("登出")
    @DeleteMapping("logout")
    public R<?> logout(HttpServletRequest httpRequest){
        authService.logout(httpRequest);
        return R.success();
    }
    @ApiOperation("刷新token")
    @PostMapping("refresh")
    public R<?> refresh(HttpServletRequest httpRequest){
        return R.success(authService.refresh(httpRequest));
    }

    @NoLogin
    @ApiOperation("注册")
    @PostMapping("register")
    public R<?> register(@RequestBody RegisterDto registerDto){
        return R.success(authService.register(registerDto));
    }

}
