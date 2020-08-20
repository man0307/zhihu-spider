//package com.mcy.infoboom.web.controller;
//
//import com.mcy.infoboom.enums.InfoBoomErrorCode;
//import com.mcy.infoboom.exception.AtomicOperateException;
//import com.mcy.infoboom.mq.KafkaTestService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @author chaoyang.man
// * @version 1.0
// * @date 2020/2/8 11:01 下午
// */
//@RestController
//@Api(tags = {"测试模块"})
//@RequestMapping("/test")
//@Slf4j
//public class TestController {
//
//    @Resource
//    private KafkaTestService kafkaTestService;
//
//
//    @RequestMapping(value = "/test_kafka", method = RequestMethod.GET)
//    @ApiOperation("Kafka测试")
//    public String testKafka(@RequestParam("topic") String topic,
//                            @RequestParam("data") String data) {
//        kafkaTestService.sendMessage(topic, data);
//        return "true";
//    }
//
//    @RequestMapping(value = "/test_exception", method = RequestMethod.GET)
//    @ApiOperation("统一测Controller层错误处理测试")
//    public String testException() throws AtomicOperateException {
//        throw new AtomicOperateException(InfoBoomErrorCode.DATABASE_QUERY_ERROR);
//    }
//
//}
