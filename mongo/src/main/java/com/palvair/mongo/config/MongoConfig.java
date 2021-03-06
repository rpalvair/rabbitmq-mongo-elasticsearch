package com.palvair.mongo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by widdy on 28/11/2015.
 */
@Configuration
@EnableMongoRepositories("com.palvair.mongo.config")
@ComponentScan("com.palvair.mongo.config")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "rpalvair";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}
