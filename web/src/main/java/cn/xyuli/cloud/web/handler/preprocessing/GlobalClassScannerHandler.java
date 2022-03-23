package cn.xyuli.cloud.web.handler.preprocessing;

import cn.hutool.core.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName GlobalClassScannerHandler
 * @Description TODO 全局类扫描程序
 * @Author xyuli
 * @Date 2022/3/22 11:06 AM
 * @Version 1.0
 **/
@Component
public class GlobalClassScannerHandler {

    private Set<Class<?>> classes = new HashSet<>();

    @Resource
    private List<ClassPreprocess> classPreprocesses = new ArrayList<>();
    @Resource
    private List<MethodPreprocess> methodPreprocesses = new ArrayList<>();

    @PostConstruct
    public void globalClassScannerPreprocessing(){
        classes = ClassUtil.scanPackage("cn.xyuli.cloud");
        classes.forEach(clazz ->{
            classPreprocesses.forEach(classPreprocess -> classPreprocess.action(clazz));
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                methodPreprocesses.forEach(methodPreprocess -> methodPreprocess.action(method));
            }
        });
    }
}
