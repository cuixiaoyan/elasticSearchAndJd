package com.cxy.es.service;

import com.cxy.es.entity.Content;
import com.cxy.es.utils.HtmlParseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @program: elasticSearch
 * @description:
 * @author: cuixy
 * @create: 2020-07-18 11:19
 **/
@Service
public class JdService {


    @Autowired
    RestHighLevelClient restHighLevelClient;

    //批量插入使用jsoup查询到的数据
    public Boolean insertToEs(String keyword) throws IOException {
        List<Content> contents = HtmlParseUtils.parseJD(keyword);
        //创建批量插入对象
        BulkRequest bulkRequest = new BulkRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        //封装数据
        for (int i = 0; i < contents.size(); i++) {

            bulkRequest.add(
                    new IndexRequest("jd_index")
                            .source(objectMapper.writeValueAsString(contents.get(i)), XContentType.JSON)
            );
        }
        //发送请求进行数据插入
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();  //返回结果是是否出现错误，插入成功则返回false，所以在此要取反
    }
}