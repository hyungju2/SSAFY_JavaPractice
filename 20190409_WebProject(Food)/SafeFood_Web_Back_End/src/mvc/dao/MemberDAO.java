package mvc.dao;

import java.util.ArrayList;

import mvc.service.MemberService;
import mvc.vo.Member;

public class MemberDAO implements MemberService
{
	ArrayList<Member> members;
	
	public MemberDAO() {
		members = new ArrayList<Member>();
	}
	
	@Override
	public void add(Member newMember)
	{
		members.add(newMember);
	}

	@Override
	public Member search(String email)
	{
		Member result = null;
		for(Member temp : members) {
			if (temp.getEmail().equals(email)) {
				result = temp;
				break;
			}
		}
		return result;
	}

	@Override
	public void correction(Member newMember)
	{
		for(int i = 0; i < members.size(); i++) {
			if (members.get(i).getEmail().equals(newMember.getEmail())) {
				members.set(i, newMember);
				break;
			}
		}
	}

	@Override
	public void delete(String email)
	{
		for(int i = 0; i < members.size(); i++) {
			if (members.get(i).getEmail().equals(email)) {
				members.remove(i);
				break;
			}
		}
	}

	@Override
	public Member login(String email, String password)
	{
		for(Member temp : members) {
			if (temp.getEmail().equals(email)) {
				if (temp.getPassword().equals(password)) 
					return temp;
				else 
					return null;
			}
		}
		
		return null;
	}
}
