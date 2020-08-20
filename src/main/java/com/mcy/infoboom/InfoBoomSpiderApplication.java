package com.mcy.infoboom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yehuo
 */
@SpringBootApplication
@EnableSwagger2
public class InfoBoomSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoBoomSpiderApplication.class, args);
    }

}
