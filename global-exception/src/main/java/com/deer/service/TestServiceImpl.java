package com.deer.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: TestServiceImpl
 * @Author: Mr_Deer
 * @Date: 2019/5/23 16:40
 * @Description:
 */
@Service
public class TestServiceImpl {

    public String testEx(){
        int a = 0/0;
        return "测试异常";
    }
}
