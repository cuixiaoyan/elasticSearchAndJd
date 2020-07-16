package com.cxy.es;

import com.cxy.es.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @program: elasticSearch
 * @description: es文档测试类
 * @author: cuixy
 * @create: 2020-07-16 14:27
 **/
@SpringBootTest
public class esDocumentTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void addDocument() throws IOException {
        //创建对象
        User user = new User();
        user.setName("崔笑颜1");
        user.setAge(18);
        //创建请求
        IndexRequest user_index = new IndexRequest("user_index");
        //文档编号
        user_index.id("2");
        //将对象转换成json放入请求中
        ObjectMapper objectMapper = new ObjectMapper();
        user_index.source(objectMapper.writeValueAsString(user), XContentType.JSON);
        //客户端发送请求，接收响应结果
        IndexResponse index = restHighLevelClient.index(user_index, RequestOptions.DEFAULT);
        //打印响应结果
        System.out.println(index.toString());  //查看返回的具体json信息
        System.out.println(index.status());  //查看操作的状态

    }


}