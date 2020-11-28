package com.mcy.infoboom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yehuo
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.mcy.infoboom.dao")
@EnableTransactionManagement
public class InfoBoomSpiderApplication {

    public static void main(String[] args) {
        //@EnableTransactionManagement 通过这个注解开启事务支持
        //@MapperScan 定义MyBatis的接口扫描路径
        //@EnableSwagger2 开启项目的Swagger扫描
        SpringApplication.run(InfoBoomSpiderApplication.class, args);
    }

}
