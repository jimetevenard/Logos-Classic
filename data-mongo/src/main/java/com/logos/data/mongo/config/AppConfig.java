package com.logos.data.mongo.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class AppConfig {
	
	@Bean 
	public MongoClient mongoClient() throws UnknownHostException {
	       return new MongoClient("localhost");
	   }
	
	 @Bean 
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient(), "logos");
	}
	
	/*@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongoDbFactory());
	}*/
	
	@Bean
	public MongoOperations mongoOp(Mongo mongo) {
		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "logos_core");
		return mongoTemplate;
	}

}
