package com.example.gxy.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author GXY
 * @Package com.example.gxy.config
 * @date 2020/11/30 0:11
 * @Copyright © 2020-2021 新流通
 * @Description:SpringBoot集成Swagger-Bootstrap-UI，页面更清爽！
 * https://mp.weixin.qq.com/s?fontRatio=1&__biz=MzAxNjk4ODE4OQ==&mid=2247495825&idx=1&sn=cf7d2ac0856c9143b6feca62856e8673&scene=94&subscene=315&passparam=searchid%3D12040964746409245461&clicktime=1606625383&enterid=1606625383&ascene=64&devicetype=android-28&version=27000a5e&nettype=WIFI&abtest_cookie=AAACAA%3D%3D&lang=zh_CN&exportkey=AeQlOjQrtVqWUV%2Bv4jPXtmU%3D&pass_ticket=LXcAoz%2FjWrBGfInYTWteLV7wQwz9NNzHEqBES%2Bpm0fOm2AvZ2Q65rCWN98nGguDL&wx_header=1
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.gxy"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("https://blog.csdn.net/ysk_xh_521")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }
}
