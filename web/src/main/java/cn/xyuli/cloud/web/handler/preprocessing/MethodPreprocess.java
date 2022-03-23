package cn.xyuli.cloud.web.handler.preprocessing;

import java.lang.reflect.Method;

/**
 * @InterfaceName MethodPreprocess
 * @Description TODO 方法预处理程序
 * @Author xyuli
 * @Date 2022/3/22 11:18 AM
 * @Version 1.0
 **/
public interface MethodPreprocess {
    void action(Method method);
}
