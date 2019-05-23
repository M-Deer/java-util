package com.deer.controller;

import com.deer.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Author: Mr_Deer
 * @Date: 2019/5/23 16:37
 * @Description:
 */
@RestController
@RequestMapping(path = "/test")
public class TestController {

    private final TestServiceImpl testService;

    @Autowired
    public TestController(TestServiceImpl testService) {
        this.testService = testService;
    }

    @GetMapping
    public String testEx() {
        return testService.testEx();
    }
}
