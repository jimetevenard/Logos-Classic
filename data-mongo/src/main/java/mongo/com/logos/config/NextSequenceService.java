package mongo.com.logos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class NextSequenceService {
	
	@Autowired
	private MongoOperations mongops;
	
	
	public Integer getNextSequence(String key) {
		
		//get sequence id
		Query query =  new Query(Criteria.where("name").is(key));
		
		//increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);
		
		//return new increased
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		
		//new sequence id
		SequenceId seqId = mongops.findAndModify(query, update, options, SequenceId.class);
		
		//throws exception when no id found
		if(seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		}
		
		return seqId.getSeq();
	}

}
