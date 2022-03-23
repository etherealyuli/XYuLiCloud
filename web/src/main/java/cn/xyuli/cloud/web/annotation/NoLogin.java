package cn.xyuli.cloud.web.annotation;

import java.lang.annotation.*;

/**
 * @ClassName NoLogin
 * @Description TODO 定义不需要登录的接口（不校验token）
 * @Author xyuli
 * @Date 2022/3/18 4:54 PM
 * @Version 1.0
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLogin {

}
