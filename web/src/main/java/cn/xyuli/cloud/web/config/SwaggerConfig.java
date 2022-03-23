package cn.xyuli.cloud.web.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 集成swagger2  解决前后端分离 弊端：不能及时协商+尽早解决的问题
 * 使用swagger总结:
 * 通过swagger 给一些比基奥难理解的接口或属性，增加注释信息
 * 接口文档实时更新
 * 可以在线测试
 * 安全问题:
 * 正式上线的时候  记得关闭swagger
 */
@Data
@Configuration
@EnableOpenApi
@EnableKnife4j
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig implements WebMvcConfigurer {

    private String name;
    private String email;
    private String url;
    private String description;
    private String version;
    private Boolean enable;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName(description)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                /**
                 * RequestHandlerSelectors配置扫描接口的方式
                 *      basePackage 配置要扫描的包
                 *      any 扫描全部
                 *      none 不扫描
                 *      withClassAnnotation 扫描类上的注解
                 *      withMethodAnnotation 扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.any())
                /**
                 * paths() 扫描过滤方式
                 *      any过滤全部
                 *      none不过滤
                 *      regex正则过滤
                 *      ant过滤指定路径
                 */
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成接口信息，包括标题，联系人等
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description(description)
                .contact(new Contact("xyuli", "http://www.xyuli.com/", "etherealyuli@gmail.com"))
                .version("1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true).maxAge(3600);
    }

}