package com.itclub.ssh.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itclub.ssh.dao.MemberDao;
import com.itclub.ssh.domain.AdminGroup;
import com.itclub.ssh.domain.AdminMember;
import com.itclub.ssh.domain.Member;
import com.itclub.ssh.domain.MemberActionLog;

public class MemberDaoImpl extends HibernateDaoSupport implements MemberDao {

	@Override
	public Member login(String username, String password) {
		List list =this.getHibernateTemplate().find("from Member where username=? and password= ?", username,password);
		if(list.size()>0){
			return (Member) list.get(0);
		}
		return null;
	}

	@Override
	public AdminGroup getGroup(Integer id) {
		List list =this.getHibernateTemplate().find("from AdminGroup where id=? ", id);
		if(list.size()>0){
			return (AdminGroup) list.get(0);
		}
		return null;
	}

	@Override
	public Member findByUsernamAndPassword(String username, String password) {
		List list =this.getHibernateTemplate().find("from Member where username=? and password= ?", username,password);
		if(list.size()>0){
			return (Member) list.get(0);
		}
		return null;
	}

	@Override
	public Member findByUsername(String username) {
		List list =this.getHibernateTemplate().find("from Member where username=? ", username);
		if(list.size()>0){
			return (Member) list.get(0);
		}
		return null;
	}

	@Override
	public AdminMember getAdminMember(Integer id) {
		List list =this.getHibernateTemplate().find("from AdminMember where id=? ", id);
		if(list.size()>0){
			return (AdminMember) list.get(0);
		}
		return null;
	}

	@Override
	public List<Member> findAll(boolean b) {
		List list =this.getHibernateTemplate().find("from Member where status=? order by id desc", b);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Member findByID(Integer id) {
		List list =this.getHibernateTemplate().find("from Member where id=? ", id);
		if(list.size()>0){
			return (Member) list.get(0);
		}
		return null;
	}

	@Override
	public void updateOrSave(Member member) {
		this.getHibernateTemplate().saveOrUpdate(member);
	}

	@Override
	public Member findByAutoToken(String token) {
		List list=getHibernateTemplate().find("from Member where token=?", token);
		if(list.size()>0 ){
			Member member=(Member) list.get(0);
			if(new Date().getTime()<member.getLastLoginTime()+604800000)
			return member;
		}
		return null;
	}

	@Override
	public void saveLog(MemberActionLog memberActionLog) {
		
		getHibernateTemplate().save(memberActionLog);
		
	}






}
