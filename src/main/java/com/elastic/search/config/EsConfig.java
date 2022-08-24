package com.elastic.search.config;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class EsConfig {

    // elasticsearch 8+ 부터는 RestHighLevelClient를 제대로 지원하지 않는다.
    // 헤더 등의 설정을 수동으로 적용해야한다.
    // https://stackoverflow.com/questions/48842352/elasticsearch-java-resthighlevelclient-unable-to-parse-response-body-illegalar

    @Bean
    public RestHighLevelClient client() {

        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"))
                .setDefaultHeaders(compatibilityHeaders());

        return new RestHighLevelClient(builder);

        // ClientConfiguration clientConfiguration 
        //     = ClientConfiguration.builder()
        //         .connectedTo("localhost:9200")
        //         .build();
 
        // return RestClients.create(clientConfiguration).rest();
    }

    private Header[] compatibilityHeaders() {
        return new Header[]{new BasicHeader(HttpHeaders.ACCEPT, "application/vnd.elasticsearch+json;compatible-with=7"), new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.elasticsearch+json;compatible-with=7")};
    }
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
