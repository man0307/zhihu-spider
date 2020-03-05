package com.mcy.zhihuspider.controller;

import com.mcy.zhihuspider.domain.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/5 5:00 下午
 */
@RestController
@RequestMapping("/test")
@Api(tags = {"Swagger的测试模块"})
public class TestController {


    @RequestMapping(value = "/swagger_test", method = RequestMethod.GET)
    @ApiOperation("Swagger的测试接口")
    public ResultModel<String> testSwagger(@RequestParam(value = "age") Integer age,
                                           @RequestParam(value = "name") Integer name) {
        return ResultModel.success("you are right.");
    }


}
