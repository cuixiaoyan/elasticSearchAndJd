package com.cxy.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: elasticSearch
 * @description: 京东商品实体类
 * @author: cuixy
 * @create: 2020-07-18 11:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String img;

    private String title;

    private String price;


}