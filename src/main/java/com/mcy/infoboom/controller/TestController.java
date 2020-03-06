package com.mcy.infoboom.controller;

import com.mcy.infoboom.mq.KafkaTestService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/8 11:01 下午
 */
@RestController
@Api(tags = {"测试模块"})
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private KafkaTestService kafkaTestService;


    @RequestMapping(value = "/test_kafka", method = RequestMethod.GET)
    public String testCrawlChapterLink(@RequestParam("topic") String topic,
                                       @RequestParam("data") String data) {
        kafkaTestService.sendMessage(topic, data);
        return "true";
    }

}
