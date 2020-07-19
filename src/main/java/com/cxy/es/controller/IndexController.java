package com.cxy.es.controller;

import com.cxy.es.service.JdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: elasticSearch
 * @description: 控制层
 * @author: cuixy
 * @create: 2020-07-18 10:20
 **/
@Controller
public class IndexController {

    @Autowired
    JdService jdService;

    //分页查询数据接口
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws IOException {

        return jdService.search(keyword, pageNo, pageSize);
    }


    //添加数据到es接口
    @GetMapping("/insert/{keyword}")
    @ResponseBody
    public Boolean insertToEs(@PathVariable("keyword") String keyword) throws IOException {
        return jdService.insertToEs(keyword);
    }

    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

}