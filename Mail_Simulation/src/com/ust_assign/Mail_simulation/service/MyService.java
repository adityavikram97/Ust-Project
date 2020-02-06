package com.ust_assign.Mail_simulation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust_assign.Mail_simulation.model.MailInfo;
import com.ust_assign.Mail_simulation.model.UserInfo;




public interface MyService {
	public boolean rigistration(UserInfo dto);
	public UserInfo login(String email,String password);
	public List<MailInfo> inbox();
	public List<MailInfo> message(HttpServletRequest request);
	public List<MailInfo> sent();
	public List<MailInfo> draft();
	public UserInfo compose(String from,String to,String sub,String body);

	public MailInfo draftCompose(int id, MailInfo dto);
	public boolean forgetPass(String email,String password,String security_answer,String password1);
	public boolean change(String password,String password1);
	public boolean sentDelete(int id);
	public boolean inboxDelete(int id);
	public boolean draftDelete(int id);
	public List<MailInfo> deletedMail();
	public boolean finalDelete(int id);
}
