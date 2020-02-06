package com.ust_assign.Mail_simulation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class UserInfo {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int id;
	private String userName;
	@Column(unique=true)
	private String email;
	private String security_question;
	private String security_answer;
	private String password;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id")
	private List<MailInfo> mlist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<MailInfo> getMlist() {
		return mlist;
	}
	public void setMlist(List<MailInfo> mlist) {
		this.mlist = mlist;
	}
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	public String getSecurity_answer() {
		return security_answer;
	}
	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

}
