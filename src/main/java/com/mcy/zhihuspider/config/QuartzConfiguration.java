package com.mcy.zhihuspider.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/23 4:52 下午
 */
@Configuration
public class QuartzConfiguration {

//    @Bean
//    public JobDetail chapterContentCompletionJob() {
//        //使用JobDetail包装job
//        return JobBuilder.newJob(ChapterContentCompletionJob.class)
//                //可以给该JobDetail起一个id
//                .withIdentity("ChapterContentCompletionJob")
//                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
//                .storeDurably()
//                .build();
//    }

//    @Bean
//    public Trigger chapterContentCompletionTrigger() {
//        // 把jobDetail注册到Cron表达式的trigger上去
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 23 ? * * *");
//
//        return TriggerBuilder.newTrigger()
//                .forJob(chapterContentCompletionJob())
//                .withIdentity("chapterContentCompletionTrigger")
//                .withSchedule(cronScheduleBuilder)
//                .build();
//    }

}

