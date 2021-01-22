package com.example.gxy;

import com.example.gxy.model.ModelImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(value="com") //扫描整个父类包
@Import(ModelImportSelector.class)
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})//exclude不加载某个类
public class SpringBoot1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot1Application.class, args);
//        new SpringApplicationBuilder(SpringBoot1Application.class)
//                .listeners(event -> {
//                    System.err.println("接收到事件：" + event.getClass().getSimpleName());
//                })
//                .run()
//                .close();
    }

}
