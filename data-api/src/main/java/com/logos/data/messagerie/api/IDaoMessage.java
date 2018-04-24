package com.logos.data.messagerie.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

public interface IDaoMessage {
	
	Message addMessage(Message message, Conversation conversation);
	List<Message> getAllMessages(Conversation conversation);
	Message getMessageById(Integer id);
	Boolean deleteMessage(Message message);
	public Message updateDateLectureMessage(Message message);
}
