package com.search.practice.search.elastic;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.search.practice.search.repository")
@ComponentScan(basePackages = {"com.search.practice.search"})
public class ElasticClientConfiguration extends AbstractElasticsearchConfiguration {


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        //	Use the builder to provide cluster addresses, set default HttpHeaders or enable SSL.
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        //Create the RestHighLevelClient
        return RestClients.create(clientConfiguration).rest();
    }

    @Autowired
    RestHighLevelClient restHighLevelClient;

//    RestClient lowLevelClient = restHighLevelClient.getLowLevelClient();


}