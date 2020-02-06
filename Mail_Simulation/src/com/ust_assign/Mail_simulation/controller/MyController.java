package com.ust_assign.Mail_simulation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ust_assign.Mail_simulation.model.MailInfo;
import com.ust_assign.Mail_simulation.model.UserInfo;
import com.ust_assign.Mail_simulation.service.MyService;




@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;
	
	  @Autowired 
	  HttpSession session;
	 
	
	@RequestMapping("/rigistration")
	public String m1() {
		return "rigistration";
	}
	@RequestMapping("/login")
	public String m2() {
		return "login";
	}
	
	@RequestMapping("/forget")
	public String forgetp() {
		return "forget";
	}
	

	
	@RequestMapping(value="/rigistration",method=RequestMethod.POST)
	public ModelAndView rigistration(@ModelAttribute UserInfo dto) {
		boolean b=ms.rigistration(dto);
		if(b) {
		return new ModelAndView("login","m","<h3>Registration successfull</h3>");
		}else {
			return new ModelAndView("rigistration","m","Registration Failed");
		}
	}
	
	  @RequestMapping(value="/login",method=RequestMethod.POST) 
	  public ModelAndView login(@RequestParam String email,String password) { 
		  UserInfo udto=ms.login(email, password); 
		  if(udto!=null) {
	  session.setAttribute("email1", udto.getEmail()); 
	  return new ModelAndView("home","udto",udto); 
	  }else { 
		  return new ModelAndView("login","msg","Login Failed");
		  }
		  }
	  
	  @RequestMapping("/inbox") 
	  public ModelAndView inbox() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.inbox();
		  return new ModelAndView("inbox","list",list);
		  }else {
			  return new ModelAndView("login","msg1","Login First");
		  }
		  }
	  @RequestMapping("/message") 
	  public ModelAndView message(HttpServletRequest request) {
		  
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.message(request);
		  return new ModelAndView("message","list",list);
		  }else {
			  return new ModelAndView("message","masg","Login First");
		  }
		  }
	
	  @RequestMapping("/sent") 
	  public ModelAndView sent() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.sent();
		  return new ModelAndView("sent","list",list); 
		  }else {
			  return new ModelAndView("login","masg","Login First");
		  }
		  }
	  @RequestMapping("/draft")
		public ModelAndView draft() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.draft();
		  return new ModelAndView("draft","list",list);
	  }else {
		  return new ModelAndView("login","masg","Login First");
	  }
		}
	  @RequestMapping("/compose")
		public ModelAndView m5() {
		  if(session.getAttribute("email1")!=null) {
		  String email=(String) session.getAttribute("email1");
			return new ModelAndView("compose","msg",email);
		  }else {
			  return new ModelAndView("login","masg","Login First");
		  }
		}
	  
	  @RequestMapping("/compose1") 
	  public ModelAndView compose(@RequestParam String to,String sub,String body) {
		  String from=(String) session.getAttribute("email1");
		  UserInfo b=ms.compose(from,to,sub,body);
		 if(b!=null) {
		  return new ModelAndView("menu","msg","Mail Sent Successfully"); 
		 }else {
			 return new ModelAndView("home","msg","Sending Failed,Save in Draft");
		 }
		 
	  }
	  

	  
	  @RequestMapping("/composeDraft")
		public ModelAndView composeDraft(@RequestParam int id, MailInfo dto) {

			MailInfo adto = ms.draftCompose(id, dto);

			if (adto != null) {
				return new ModelAndView("composeDraft", "adto", adto);
			} else {
				return new ModelAndView("home", "msg", "message not display");
			}
		}
	  
	  
	  
	  @RequestMapping("/logout")
	  public ModelAndView logout() {
		  if(session.getAttribute("email1")!=null) {
		  session.invalidate();
		  return new ModelAndView("login","msg","Logout Success");
		  }else {
			  return new ModelAndView("login","msg","Login First");
		  }
	  }
	  @RequestMapping("/draftdelete")
	  public ModelAndView draftdelete(@RequestParam int id) {
		  
		  boolean b=ms.draftDelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Deleted Successfully");
		  }else {
			  return new ModelAndView("home","msg","Delete Failed");
		  }
	  }
	  
	  @RequestMapping("/inboxdelete")
	  public ModelAndView inboxdelete(@RequestParam int id) {
		  
		  boolean b=ms.inboxDelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Deleted Successfully");
		  }else {
			  return new ModelAndView("home","msg","Delete Failed");
		  }
	  }
	  
	  @RequestMapping("/sentdelete")
	  public ModelAndView sentdelete(@RequestParam int id) {
		  
		  boolean b=ms.sentDelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Deleted Successfully");
		  }else {
			  return new ModelAndView("home","msg","Delete Failed");
		  }
	  }
	 
	  @RequestMapping(value="/forgetPass",method=RequestMethod.POST)
	  public ModelAndView forgetPassword(@RequestParam String email,String password,String security_answer,String password1) {
		  boolean b=ms.forgetPass(email, password, security_answer, password1);
		  if(b) {
		  return new ModelAndView("login","msg","Password Changed Successfully");
		  }else {
			  return new ModelAndView("forget","msg","<h3>Invalid Details or Wrong Password</h3>");
		  }
	  }
	  @RequestMapping("/changepass")
	  public ModelAndView changepass() {
		  if (session.getAttribute("email1") != null) {
				return new ModelAndView("changepass");
			} else {
				return new ModelAndView("login", "msg", "Login First");
			}
		 
	  }
	  @RequestMapping(value="/changepass",method=RequestMethod.POST)
	  public ModelAndView change(@RequestParam String password,String password1) {
		  boolean b=ms.change( password,password1);
		  if(b) {
		  return new ModelAndView("home","msg","Password Changed Successfully");
		  }else {
			  return new ModelAndView("login","msg","login first");
		  }
	  }
	  
	  @RequestMapping("/deleteMail")
	  public ModelAndView deleted() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.deletedMail();
		  return new ModelAndView("deletedMail","list",list);
	  }else {
		  return new ModelAndView("login","masg","Login First");
	  }
		}
	  
	  @RequestMapping("/finalDelete")
	  public ModelAndView PermanentDeleted(@RequestParam int id) 
	  { 
		  boolean b=ms.finalDelete(id);
	  if(b) {
	  return new ModelAndView("home","msg1","mail deleted permanently");
	  }else {
		  return new ModelAndView("home","msg2","mail not deleted permanently");
	  }
	  }
	  
	  
		 
	  
	 

}
