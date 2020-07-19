package com.cxy.es.service;

import com.cxy.es.entity.Content;
import com.cxy.es.utils.HtmlParseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    //分页查询，高亮效果。
    public List<Map<String, Object>> search(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo == 0) {
            pageNo = 1;
        }
        //创建搜索对象
        SearchRequest jd_index = new SearchRequest("jd_index");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //配置分页信息
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);

        //封装高亮显示条件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");  //对哪个字段进行高亮
        highlightBuilder.requireFieldMatch(true);//多个关键字高亮？
        highlightBuilder.preTags("<span style='color:red'>");  //设置高亮前缀
        highlightBuilder.postTags("</span>");  //高亮后缀


        //构建搜索条件
        TermQueryBuilder query = QueryBuilders.termQuery("title", keyword);
        //封装搜索条件
        searchSourceBuilder.query(query);
        //封装高亮搜索条件
        searchSourceBuilder.highlighter(highlightBuilder);

        //封装搜索对象
        jd_index.source(searchSourceBuilder);
        //发送请求
        SearchResponse search = restHighLevelClient.search(jd_index, RequestOptions.DEFAULT);
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : search.getHits().getHits()) {

            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("title");  //高亮之后的title
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();  //未高亮之前的结果集
            //接下来就是将高亮的title与结果集中未高亮的title进行替换
            if (title != null) {
                Text[] fragments = title.fragments();
                String newTitle = "";
                for (Text text : fragments) {
                    newTitle += text;
                }
                sourceAsMap.put("title", newTitle);  //替换掉未高亮的title
            }
            list.add(sourceAsMap);


        }

        return list;

    }

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