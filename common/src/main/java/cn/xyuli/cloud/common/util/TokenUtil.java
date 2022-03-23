package cn.xyuli.cloud.common.util;

import cn.hutool.core.util.StrUtil;

/**
 * @ClassName TokenUtil
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/16 12:03 PM
 * @Version 1.0
 **/
public class TokenUtil {
    public static String getTokenHeaderKey(){
        return "authorization";
    }

    public static String getRedisKey(String token){
        return StrUtil.format("token:{}",token);
    }
}
