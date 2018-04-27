package mongo.com.logos.messagerie.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.user.Utilisateur;

import api.com.logos.data.messagerie.IDaoConversation;

public class DaoConversation implements IDaoConversation {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoConversation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public List<Conversation> getAllConversation(Utilisateur user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation addConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation addConversation(Conversation conversation, Utilisateur... utilisateurs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation getConversationById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conversation updateConversation(Conversation chawa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Utilisateur> getUsersByConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

}
