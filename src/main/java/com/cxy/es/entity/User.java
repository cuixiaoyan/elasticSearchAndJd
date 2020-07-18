package com.cxy.es.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: elasticSearch
 * @description: 用户测试类
 * @author: cuixy
 * @create: 2020-07-16 14:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;


}