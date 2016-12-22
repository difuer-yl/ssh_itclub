package com.itclub.ssh.service.impl;

import java.util.Date;
import java.util.List;

import com.itclub.ssh.dao.MemberDao;
import com.itclub.ssh.domain.AdminMember;
import com.itclub.ssh.domain.Member;
import com.itclub.ssh.domain.MemberActionLog;
import com.itclub.ssh.service.MemberService;
import com.itclub.ssh.util.MD5;
import com.itclub.ssh.util.SecurityCodeUtil;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public Member adminlogin(String username, String password) {
		
		Member member=memberDao.findByUsername(username);
		if(member==null || !member.getPassword().equals(MD5.stringMD5(MD5.stringMD5(password+member.getSalt())+member.getSalt()))){
			return null;
		}
		AdminMember adminMember=memberDao.getAdminMember(member.getId());
		if(adminMember ==null){
			return null;
		}
		member.setLastLoginTime(new Date().getTime());
		memberDao.updateOrSave(member);
		return member;
	}

	@Override
	public List<Member> list(boolean b) {
		List<Member> list=memberDao.findAll(b);
		return list;
	}

	@Override
	public Member edit(Integer id) {
		Member member=memberDao.findByID(id);
		if(member!=null){
			return member;
		}
		return null;
	}

	@Override
	public boolean edit_success(Member member) {
		Member mb=memberDao.findByID(member.getId());
		String salt = SecurityCodeUtil.getSecurityCode(6, SecurityCodeUtil.SecurityCodeLevel.Hard, true);
        mb.setSalt(salt);
        mb.setPassword(MD5.stringMD5(MD5.stringMD5(member.getPassword() + salt) + salt));
        mb.setSex(member.getSex());
        mb.setMobil(member.getMobil());
        mb.setEmail(member.getEmail());
        
		memberDao.updateOrSave(mb);
		return true;
	}

	@Override
	public String updateStatus(Integer id,boolean b) {
		Member member=memberDao.findByID(id);
		member.setStatus(b);
		memberDao.updateOrSave(member);
		return "true";
	}

	@Override
	public Member login(String username, String password) {
		Member member=memberDao.findByUsername(username);
		if(member==null || !member.getPassword().equals(MD5.stringMD5(MD5.stringMD5(password+member.getSalt())+member.getSalt()))){
			return null;
		}
		MemberActionLog memberActionLog=new MemberActionLog();
		memberActionLog.setUid(member.getId());
		memberActionLog.setAction("login");
		memberActionLog.setDateline(true);
		memberDao.saveLog(memberActionLog);
		return member;
	}

	@Override
	public Member autoLogin(String token) {
		Member member=memberDao.findByAutoToken(token);
		MemberActionLog memberActionLog=new MemberActionLog();
		memberActionLog.setUid(member.getId());
		memberActionLog.setAction("auto_login");
		memberActionLog.setDateline(true);
		memberActionLog.setTime(new Date().getTime());
		memberActionLog.setIp(" ");
		memberDao.saveLog(memberActionLog);
		return member;
		
	}

	@Override
	public String UpdateToken(Member member) {
		String token=MD5.stringMD5("ITCLUB_AUTO_"+new Date().getTime()+member.getPassword());
		member.setToken(token);
		member.setTokenCreateTime(new Date().getTime());
		memberDao.updateOrSave(member);
		return token;
	}
	
}
