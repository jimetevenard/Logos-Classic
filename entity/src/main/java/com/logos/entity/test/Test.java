package com.logos.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name="testounet")
@Document
public class Test {

	@Id
	@Column(name="id_test")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTest;

	@Column(name="titre_test", nullable=false, length=50)
	private String titre;


	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
