package mongo.com.logos.messagerie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

import api.com.logos.data.messagerie.IDaoMessage;

public class DaoMessage implements IDaoMessage {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoMessage(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Message addMessage(Message message, Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessages(Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getMessageById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateDateLectureMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
