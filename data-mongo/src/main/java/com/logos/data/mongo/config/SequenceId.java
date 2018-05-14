package com.logos.data.mongo.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {
	
	
	private String name;
	
	private Integer seq;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public SequenceId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SequenceId [name=" + name + ", seq=" + seq + "]";
	}
	
	

}
