package com.deer.controller;

import com.deer.model.User;
import com.deer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: User
 * @Author: Mr_Deer
 * @Date: 2019/3/27
 * @Describe: User Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET 请求
     *
     * @param id 学生 ID
     * @return 响应信息
     */
    @GetMapping
    public String getItemById(@RequestParam(value = "id") Integer id) {
        return userService.getItemById(id);
    }

    /**
     * POST 请求
     *
     * @param user user 对象
     * @return 响应信息
     */
    @PostMapping
    public String insertItem(@RequestBody User user) {
        return userService.insertItem(user);
    }

    /**
     * PUT 请求
     *
     * @param name 学生 name
     * @return 响应信息
     */
    @PutMapping
    public User updateItemByNam(@RequestParam(value = "name") String name) throws Exception {
        int a = 0 / 0;
        return userService.updateItemByNam(name);
    }
}
