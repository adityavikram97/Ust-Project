package com.ust_assign.Mail_simulation.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust_assign.Mail_simulation.model.MailInfo;
import com.ust_assign.Mail_simulation.model.UserInfo;




@Component
public class MyDAOImp1 implements Mail_infoDAO{
	
	  @Autowired 
	  HttpSession session;
	 @Autowired
	 SessionFactory sf;
	 
	 
	 @Override
	 public boolean rigistration(UserInfo rdto) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(UserInfo.class);
			cr.add(Restrictions.eq("email", rdto.getEmail()));
			UserInfo udto=(UserInfo) cr.uniqueResult();
			if(udto!=null) {
				return false;
				}else {
					
					ss.save(rdto);
					ss.beginTransaction().commit();
					ss.close();
					return true;
				}
		}
	 

	

	@Override
	public UserInfo login(String email, String password) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", password));
		UserInfo uidto=(UserInfo) cr.uniqueResult();
		return uidto;
		
	}

	@Override
	public List<MailInfo> inbox() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("toId",email1));
		cr.add(Restrictions.eq("status", "MailSent"));
		//cr.add(Restrictions.isNull(""));
		//cr.add(Restrictions.isNull("status"));
		cr.add(Restrictions.isNotNull("status"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}
	
	@Override
	public List<MailInfo> message(HttpServletRequest request) {
		String id=request.getParameter("id");
		  int mid=Integer.parseInt(id);
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("id",mid));
		cr.add(Restrictions.eq("status", "MailSent"));
		//cr.add(Restrictions.isNotNull("status"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> sent() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> draft() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email));
		cr.add(Restrictions.eq("status", "DraftMail"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", from));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", to));
		UserInfo udto=(UserInfo) cr.uniqueResult();
		List<MailInfo> list;
		
		if(udto!=null) {
		MailInfo mdto=new MailInfo();
		mdto.setFromId(from);
		mdto.setToId(to);
		mdto.setSubject(sub);
		mdto.setMessage(body);
		mdto.setStatus("MailSent");
		list=dto.getMlist();
		list.add(mdto);
		dto.setMlist(list);
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();
		return dto;
		}else {
			MailInfo mdto=new MailInfo();
			mdto.setToId(to);
			mdto.setFromId(from);
			mdto.setSubject(sub);
			mdto.setMessage(body);
			mdto.setStatus("DraftMail");
			list=dto.getMlist();
			list.add(mdto);
			dto.setMlist(list);
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return null;
		}
	}
	


	@Override
	public boolean forgetPass(String email, String password, String security_answer, String password1) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("security_answer", security_answer));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(password1)) {
				dto.setPassword(password1);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}else {
			ss.close();
			return false;
			}
		}else {
		ss.close();
		return false;
   }
	}

	@Override
	public boolean change(String password, String password1) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("email", email));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(password1)) {
				dto.setPassword(password1);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
				ss.close();
				return false;
			}
		}else {
			ss.close();
			return false;
		}
		
	}


	@Override
	public boolean sentDelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setStatus("deletedMail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		return false;
		}
	}
	
	@Override
	public boolean inboxDelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setStatus("deletedMail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		return false;
		}
	}
	
	@Override
	public boolean draftDelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setStatus("deletedMail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		return false;
		}
	}


	@Override
	public List<MailInfo> deletedMail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email));
		cr.add(Restrictions.eq("status", "deletedMail"));
		List<MailInfo> mlist=cr.list();
		return mlist;
				
	}
	@Override
	public MailInfo draftCompose(int id, MailInfo dto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id",id));
		MailInfo dto1=(MailInfo)cr.uniqueResult();
		ss.delete(dto1);
		ss.beginTransaction().commit();
		return dto1;
	}

	@Override
	public boolean finalDelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id",id));
		
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			
			ss.save(dto);
			ss.delete(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else 
		return false;
		
	}


	
	

	

	
	
}
