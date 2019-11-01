package com.arep.webpage.config;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class appMongoConfiguration {
    @Bean
    public MongoDbFactory mongoDbFactoryConf() throws Exception {

        MongoClientURI uri = new MongoClientURI(
                "mongodb://AdminTask:admin@clustertask-shard-00-00-1f2s8.mongodb.net:27017,clustertask-shard-00-01-1f2s8.mongodb.net:27017,clustertask-shard-00-02-1f2s8.mongodb.net:27017/test?ssl=true&replicaSet=ClusterTask-shard-0&authSource=admin&retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        return new SimpleMongoDbFactory( mongoClient, "test");

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactoryConf());

        return mongoTemplate;

    }
}
