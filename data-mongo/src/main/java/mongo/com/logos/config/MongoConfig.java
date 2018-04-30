package mongo.com.logos.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {
	
	@Bean 
	public MongoClient mongo() throws UnknownHostException {
		return new MongoClient("localhost");
	}
	
	@Bean
	MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongo(), "logos-core-mongo");
	}

}
