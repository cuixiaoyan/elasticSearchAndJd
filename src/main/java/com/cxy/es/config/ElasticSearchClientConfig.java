package com.cxy.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: elasticSearch
 * @description: 配置类
 * @author: cuixy
 * @create: 2020-07-15 17:50
 **/
@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        //ES集群的相关信息，如果有多个就配置多个
                        new HttpHost("192.168.106.129", 9200, "http")
                )
        );
        return client;
    }


}