package com.itclub.ssh.service;

import java.util.List;

import com.itclub.ssh.domain.Member;

public interface MemberService {

	Member adminlogin(String username, String password);

	List<Member> list(boolean b);

	Member edit(Integer id);

	boolean edit_success(Member member);


	String updateStatus(Integer id, boolean b);

	Member login(String username, String password);

	Member autoLogin(String m);

	String UpdateToken(Member memberInfo);

}
