package com.cxy.es;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @program: elasticSearch
 * @description: 索引测试类
 * @author: cuixy
 * @create: 2020-07-15 17:59
 **/
@SpringBootTest
public class esIndexTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    //测试索引的创建
    @Test
    public void createIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest java_index = new CreateIndexRequest("cxy1_index");
        //客户端执行请求创建索引
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(java_index, RequestOptions.DEFAULT);
    }

    //判断索引是否存在
    @Test
    void existIndex() throws IOException {
        GetIndexRequest cxy1_index = new GetIndexRequest("cxy1_index");
        System.out.println(restHighLevelClient.indices().exists(cxy1_index, RequestOptions.DEFAULT));
    }

    //删除索引
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest java_index = new DeleteIndexRequest("cxy_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(java_index, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }


}