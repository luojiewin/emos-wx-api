package com.landx.emos.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@ServletComponentScan
public class EmosWxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmosWxApiApplication.class, args);
    }

}
