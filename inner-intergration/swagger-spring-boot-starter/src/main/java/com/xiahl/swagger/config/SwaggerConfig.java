package com.xiahl.swagger.config;

import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.xiahl.apicommon.constant.ResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DoyuTu
 * <p>
 * http://localhost:8080/doc.html
 * </p>
 */
@Configuration
//@EnableSwaggerBootstrapUI
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnWebApplication
@EnableAutoConfiguration
public class SwaggerConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public Docket createRestApi(TypeResolver typeResolver) throws UnknownHostException {
        List<Response> responses = Arrays.stream(ResultCode.values())
                .map(e -> new Response(e.getCode(), e.getMessage(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()))
                .collect(Collectors.toList());
        HttpMethod[] httpMethods = HttpMethod.values();
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        for (HttpMethod httpMethod : httpMethods) {
            docket.globalResponses(httpMethod, responses);
        }
        return docket
                .apiInfo(apiInfo())
                .host(InetAddress.getLocalHost().getHostAddress() + ":" + serverPort)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiahl"))
                .paths(PathSelectors.any()).build()
//                .alternateTypeRules(
//                        AlternateTypeRules.newRule(typeResolver.resolve(Callable.class,
//                                typeResolver.resolve(R.class, WildcardType.class)
//                                ),
//                                typeResolver.resolve(WildcardType.class)
//                        )
//                )
            ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java模板平台")
                .description("Java SpringBoot 模板项目")
                .termsOfServiceUrl("https://www.yczcjk.com/")
                .contact(new Contact("xiahl", "https://github.com/xiaQ", "1169555812@qq.com"))
                .version("1.0.0")
                .build();
    }

}
