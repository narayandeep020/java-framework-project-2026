package com.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tm_answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "and_id")
	private int ansId;

	@Column(name = "ans_name")
	private String ansName;

	@Column(name = "posted_by")
	private String postedBy;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_answer", joinColumns = @JoinColumn(name = "ans_id"), inverseJoinColumns = @JoinColumn(name = "q_id"))
	private List<Question> questions = new ArrayList<>();

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public String getAnsName() {
		return ansName;
	}

	public void setAnsName(String ansName) {
		this.ansName = ansName;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
