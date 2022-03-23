package cn.xyuli.cloud.web.handler.preprocessing;

import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultClassPreprocess
 * @Description TODO 默认类预处理器（如有具体实现可删除，用于防止注入为空）
 * @Author xyuli
 * @Date 2022/3/22 11:32 AM
 * @Version 1.0
 **/
@Component
public class DefaultClassPreprocess implements ClassPreprocess{
    @Override
    public void action(Class clazz) {

    }
}
