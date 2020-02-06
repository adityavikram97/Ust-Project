package com.ust_assign.Mail_simulation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust_assign.Mail_simulation.dao.Mail_infoDAO;
import com.ust_assign.Mail_simulation.model.MailInfo;
import com.ust_assign.Mail_simulation.model.UserInfo;



@Component
public class MyServiceImp1 implements MyService{
	@Autowired
	Mail_infoDAO md;

	@Override
	public boolean rigistration(UserInfo dto) {
		boolean b=md.rigistration(dto);
		return b;
	}

	@Override
	public UserInfo login(String email, String password) {
		UserInfo dto=md.login(email, password);
		return dto;
	}

	@Override
	public List<MailInfo> inbox() {
		List<MailInfo> list=md.inbox();
		return list;
	}

	@Override
	public List<MailInfo> sent() {
		List<MailInfo> list=md.sent();
		return list;
	}

	@Override
	public List<MailInfo> draft() {
		List<MailInfo> list=md.draft();
		return list;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		UserInfo dto=md.compose(from, to, sub, body);
		return dto;
	}

	@Override
	public boolean forgetPass(String email, String password, String security_answer, String password1) {
		boolean b=md.forgetPass(email, password, security_answer, password1);
		return b;
	}

	@Override
	public boolean change(String password, String password1) {
		boolean b=md.change(password, password1);
		return b;
	}

	@Override
	public boolean draftDelete(int id) {
		boolean b=md.draftDelete(id);
		return b;
	}
	
	@Override
	public boolean inboxDelete(int id) {
		boolean b=md.inboxDelete(id);
		return b;
	}
	
	@Override
	public boolean sentDelete(int id) {
		boolean b=md.sentDelete(id);
		return b;
	}

	@Override
	public List<MailInfo> deletedMail() {
		List<MailInfo> list=md.deletedMail();
		return list;
	}

	@Override
	public List<MailInfo> message(HttpServletRequest request) {
		List<MailInfo> list=md.message(request);
		return list;
	}

	@Override
	public boolean finalDelete(int id) {
		boolean b=md.finalDelete(id);
		return b;
	}


	
	@Override
	public MailInfo draftCompose(int id, MailInfo dto) {
		MailInfo adto=md.draftCompose(id,dto);
		return adto;
	}

	
	

}
