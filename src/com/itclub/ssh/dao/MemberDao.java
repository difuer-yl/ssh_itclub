package com.itclub.ssh.dao;

import java.util.List;

import com.itclub.ssh.domain.AdminGroup;
import com.itclub.ssh.domain.AdminMember;
import com.itclub.ssh.domain.Invitation;
import com.itclub.ssh.domain.Member;
import com.itclub.ssh.domain.MemberActionLog;

public interface MemberDao {

	Member login(String username, String password);

	AdminGroup getGroup(Integer id);

	Member findByUsernamAndPassword(String username, String password);

	Member findByUsername(String username);

	AdminMember getAdminMember(Integer id);

	List<Member> findAll(boolean b);

	Member findByID(Integer id);

	void updateOrSave(Member member);

	Member findByAutoToken(String token);


	void saveLog(MemberActionLog memberActionLog);

	Invitation findInvitationCode(String invitationCode);

	void saveMember(Member member);

	void deleteInvitation(Invitation invitation);

	void saveInvite(Invitation ii);

	List findAllInvitation();


	

}
