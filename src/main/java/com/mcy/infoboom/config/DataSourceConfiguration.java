package com.mcy.infoboom.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2019/12/22 5:32 下午
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DataSourceConfiguration {

    private String url;

    private String username;

    private String password;

    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(getUrl());
        dataSource.setUsername(getUsername());
        dataSource.setPassword(getPassword());
        return dataSource;
    }

}
