package com.logos.data.mongo.messagerie.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.data.api.messagerie.IDaoMessage;
import com.logos.data.mongo.config.NextSequenceService;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

@Repository
public class DaoMessage implements IDaoMessage {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "message";
	
	public DaoMessage(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Message addMessage(Message message, Conversation conversation) {
		message.setIdMessage(sequence.getNextSequence(COLLECTION));
		conversation = mongoOps.findById(conversation.getIdConversation(), Conversation.class);
		conversation.getMessages().size();
		message.setDateEnvoi(new Date());
		message.setConversation(conversation);
		mongoOps.insert(message);
		return message;
	}

	@Override
	public List<Message> getAllMessages(Conversation conversation) {
		if(conversation != null) {
		Query q = new Query(Criteria.where("conversation._id").is(conversation.getIdConversation()));
		return mongoOps.find(q,Message.class);
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Message getMessageById(Integer id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(id, Message.class);
	}

	@Override
	public Boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateDateLectureMessage(Message message) {
		// TODO Auto-generated method stub
		message.setDateLecture(new Date());
		mongoOps.save(message);
		return message;
	}

}
