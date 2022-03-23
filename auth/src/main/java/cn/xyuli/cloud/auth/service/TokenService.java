package cn.xyuli.cloud.auth.service;

import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.entity.User;

/**
 * @ClassName TokenService
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 6:01 PM
 * @Version 1.0
 **/
public interface TokenService {
    /**
     * 用户token key
     * token:{token}
     */
    String USER_TOKEN_KEY_PREFIX = "token:{}";

    Token generateToken(User user);

    Token findToken(String token);

    void remove(String token);

    Token refresh(User user,Token token);

}
