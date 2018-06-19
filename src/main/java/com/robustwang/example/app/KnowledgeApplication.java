package com.robustwang.example.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author wangjun
 * @Date 2018/6/7 18:45
 */
@ComponentScan(basePackages = {"com.robustwang"})
public class KnowledgeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(KnowledgeApplication.class).web(true).run(args);
    }
}
