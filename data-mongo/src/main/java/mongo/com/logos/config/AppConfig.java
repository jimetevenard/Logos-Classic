package mongo.com.logos.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class AppConfig {
	
	public @Bean MongoClient mongoClient() throws UnknownHostException {
	       return new MongoClient("localhost");
	   }
	
	public @Bean MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient(), "logos");
	}
	
	public @Bean MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongoDbFactory());
	}

}
