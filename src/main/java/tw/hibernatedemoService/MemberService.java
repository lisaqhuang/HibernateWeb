package tw.hibernatedemoService;

import tw.hibernatedemo.model.Member;
import tw.hibernatedemo.model.MemberDao;

public class MemberService {
	private MemberDao mDao;
	
	public MemberService() {
		
		this.mDao = new MemberDao();//此處不用session因為filter處開session
	}

	public Member checkLogin(String loginName,String loginPwd) {
		
		Member member = mDao.findByNameAndPassword(loginName, loginPwd);
		
		if(member != null) {
			return member;
		}
		return null;
	}
}
