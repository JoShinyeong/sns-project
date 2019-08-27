package member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	private SqlSessionTemplate memberSqlSession;

	// 아이디 중복 체크
	public int userldCheck(String user_id) {
		memberDao = memberSqlSession.getMapper(MemberDao.class);
		return memberDao.checkOverId(user_id);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<MemberVO> memberlist() {
		return memberDao.memberlist();
	}

	@Override
	public void memberInsert(MemberVO memberVO) {
		memberDao.memberInsert(memberVO);
	}

	@Override
	public MemberVO memberLogin(Map map) {
		return memberDao.memberLogin(map);
	}

	@Override
	public MemberVO matchPW(Map map) {
		return memberDao.matchPW(map);
	}

	@Override
	public int matchID(String email) {
		return memberDao.matchID(email);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		memberDao.memberUpdate(memberVO);
	}

	@Override
	public int userIdCheck(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
