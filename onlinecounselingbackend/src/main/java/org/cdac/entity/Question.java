package org.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questionnaire")
public class Question {
	
	@Id
	@Column(name="qno")
	int questNo;
	@Column(name="q_description")
	String questDesc;
	@Column(name="q_option1")
	String questOption1;
	@Column(name="q_option2")
	String questOption2;
	@Column(name="q_option3")
	String questOption3;
	@Column(name="q_option4")
	String questOption4;
	@Column(name="q_answer")
	String questAnswer;
	public int getQuestNo() {
		return questNo;
	}
	public void setQuestNo(int questNo) {
		this.questNo = questNo;
	}
	public String getQuestDesc() {
		return questDesc;
	}
	public void setQuestDesc(String questDesc) {
		this.questDesc = questDesc;
	}
	public String getQuestOption1() {
		return questOption1;
	}
	public void setQuestOption1(String questOption1) {
		this.questOption1 = questOption1;
	}
	public String getQuestOption2() {
		return questOption2;
	}
	public void setQuestOption2(String questOption2) {
		this.questOption2 = questOption2;
	}
	public String getQuestOption3() {
		return questOption3;
	}
	public void setQuestOption3(String questOption3) {
		this.questOption3 = questOption3;
	}
	public String getQuestOption4() {
		return questOption4;
	}
	public void setQuestOption4(String questOption4) {
		this.questOption4 = questOption4;
	}
	public String getQuestAnswer() {
		return questAnswer;
	}
	public void setQuestAnswer(String questAnswer) {
		this.questAnswer = questAnswer;
	}
	

}
