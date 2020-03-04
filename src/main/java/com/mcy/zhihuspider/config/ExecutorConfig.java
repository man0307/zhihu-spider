package com.mcy.zhihuspider.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/15 5:28 下午
 */
@Configuration
@ConfigurationProperties(prefix = "spring.task.execution.pool")
@Data
public class ExecutorConfig {

    private Boolean allowCoreThreadTimeout;

    private Integer keepAlive;

    private Integer coreSize;

    private Integer maxSize;

    private Integer queueCapacity;


    @Bean
    public Executor asyncProcessEventExecutor() {
        ThreadFactory eventTaskThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("event-task-pool-%d").build();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(coreSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);

        executor.setKeepAliveSeconds(keepAlive);
        //配置线程池中的线程的名称前缀
        executor.setThreadFactory(eventTaskThreadFactory);
        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化执行器
        executor.initialize();
        return executor;
    }

}
