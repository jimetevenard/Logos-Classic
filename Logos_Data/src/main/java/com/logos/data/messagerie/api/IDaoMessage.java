package com.logos.data.messagerie.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

public interface IDaoMessage {
	
	Message addMessage(Message message);
	List<Message> getAllMessages(Conversation conversation);
	Message getMessageById(Integer id);
	Boolean deleteMessage(Message message);
	Message updateMessage(Message message);



}
