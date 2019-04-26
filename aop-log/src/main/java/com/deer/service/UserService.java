package com.deer.service;

import com.deer.component.annotation.OtherLog;
import com.deer.model.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName: User
 * @Author: Mr_Deer
 * @Date: 2019/3/27
 * @Describe: User Service
 */
@Service
public class UserService {

    @OtherLog
    public String getItemById(Integer id) {
        String str = "收到请求！学生ID：" + id;
        System.out.println(str);
        return str;
    }

    public String insertItem(User user) {
        String str = "学生信息如下：" + user.toString();
        System.out.println(str);
        return str;
    }

    public User updateItemByNam(String name) {
        User user = new User();
        user.setId(1);
        user.setName(name);
        String str = "学生信息如下：" + user.toString();
        return user;
    }
}
