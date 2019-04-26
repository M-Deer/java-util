package com.deer.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Author: Mr_Deer
 * @Date: 2019/3/27
 * @Describe: User Model
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4684388349695971750L;

    private Integer id;
    private String name;
}
