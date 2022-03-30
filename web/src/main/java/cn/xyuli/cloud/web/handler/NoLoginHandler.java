package cn.xyuli.cloud.web.handler;

import cn.xyuli.cloud.web.annotation.NoLogin;
import cn.xyuli.cloud.web.handler.preprocessing.ClassPreprocess;
import cn.xyuli.cloud.web.handler.preprocessing.MethodPreprocess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NoLoginHandler
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/22 11:28 AM
 * @Version 1.0
 **/
@Slf4j
@Component
public class NoLoginHandler implements MethodPreprocess , ClassPreprocess {

    private static Set<String> noLoginUrlSet = new HashSet<>();

    public static Set<String> getNoLoginUrlSet() {
        return noLoginUrlSet;
    }

    @Override
    public void action(Method method) {
        if (method.isAnnotationPresent(NoLogin.class)){
            saveNoLoginUrl(method.getDeclaringClass(),method, noLoginUrlSet);
        }
    }

    @Override
    public void action(Class clazz) {
        if (clazz.isAnnotationPresent(NoLogin.class)){
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                saveNoLoginUrl(clazz,method, noLoginUrlSet);
            }
        }
    }

    private void saveNoLoginUrl(Class clazz,Method method, Set<String> noLoginUrlSet) {
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        String classMapping = null;
        //判断类上面有没有使用RequestMapping注解
        if (clazz.isAnnotationPresent(RequestMapping.class)){
            RequestMapping annotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            classMapping = annotation.value()[0];
        }
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if (declaredAnnotation.annotationType().isAnnotationPresent(RequestMapping.class)){
                try {
                    Method value = declaredAnnotation.annotationType().getMethod("value");
                    String[] invoke = (String[]) value.invoke(declaredAnnotation);
                    for (String uri : invoke) {
                        if (classMapping != null && classMapping.length() != 0){
                            uri =  "/"+(classMapping.indexOf("/") == 0 ? classMapping.substring(1) : classMapping)+"/"+(uri.indexOf("/") == 0 ? uri.substring(1) : uri);
                            noLoginUrlSet.add(uri);
                            log.info("NoLogin:{}",uri);
                            continue;
                        }
                        uri =  "/"+(uri.indexOf("/") == 0 ? uri.substring(1) : uri);
                        noLoginUrlSet.add(uri);
                        log.info("NoLogin:{}",uri);
                    }
                } catch (Exception e) {
                    log.error("预处理NoLogin程序中，在{}方法出错", method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

}
