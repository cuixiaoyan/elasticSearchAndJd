package com.cxy.es;

import com.cxy.es.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 创建文档对象，使用jackson转换
     *
     * @throws IOException
     */
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

    /**
     * 判断文档是否存在
     */
    @Test
    public void existDocument() throws IOException {
        //获取索引中的id值是否存在
        GetRequest user_index = new GetRequest("user_index", "1");
        System.out.println(restHighLevelClient.exists(user_index, RequestOptions.DEFAULT));
    }

    /**
     * 获取文档内容
     *
     * @throws IOException
     */
    @Test
    public void getDocument() throws IOException {
        GetRequest user_iddex = new GetRequest("user_index", "1");
        GetResponse documentFields = restHighLevelClient.get(user_iddex, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSource());
        System.out.println(documentFields);
    }

    /**
     * 修改文档。
     *
     * @throws IOException
     */
    @Test
    public void updateDocument() throws IOException {
        UpdateRequest user_index = new UpdateRequest("user_index", "2");
        User user = new User();
        user.setName("cuixiaoyan");
        user.setAge(18);
        ObjectMapper objectMapper = new ObjectMapper();
        user_index.doc(objectMapper.writeValueAsString(user), XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(user_index, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    /**
     * 删除文档
     *
     * @throws IOException
     */
    @Test
    public void deleteDocument() throws IOException {
        DeleteRequest user_index = new DeleteRequest("user_index", "1");
        System.out.println(restHighLevelClient.delete(user_index, RequestOptions.DEFAULT).status());
    }

    /**
     * 查询文档信息
     * Hits对象中包含的是所有的查询结果信息，我们可以通过遍历想要的参数获得具体的信息。
     * 对于复杂查询的各种操作都可以在searchSourceBuilder对象的方法中找到对应的方法：
     *
     * @throws IOException
     */
    @Test
    public void search() throws IOException {
        SearchRequest user_index = new SearchRequest("user_index");
        //构造搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //使用工具类构造搜索信息
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "崔笑颜");
        searchSourceBuilder.query(matchQueryBuilder);
        //高亮
        searchSourceBuilder.highlighter();
        //分页
//        searchSourceBuilder.from();
        user_index.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(user_index, RequestOptions.DEFAULT);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(search.getHits()));
    }

    /**
     * 批量新增，批量删除也同理。
     *
     * @throws IOException
     */
    @Test
    public void bulkDocument() throws IOException {
        //创建批量操作对象
        BulkRequest bulkRequest = new BulkRequest();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("崔笑颜" + i);
            user.setAge(i);
            userList.add(user);
        }
        for (int j = 0; j < userList.size(); j++) {
            ObjectMapper objectMapper = new ObjectMapper();
            bulkRequest.add(new IndexRequest("user_index").id("" + j + 1).source(objectMapper.writeValueAsString(userList.get(j))
                    , XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());


    }


}