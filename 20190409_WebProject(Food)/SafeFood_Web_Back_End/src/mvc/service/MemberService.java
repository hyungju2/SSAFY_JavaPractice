package mvc.service;

import mvc.vo.Member;

public interface MemberService
{
	void add(Member newMember);
	Member search(String email);
	void correction(Member newMember);
	void delete(String email);
	Member login(String email, String password);
}
