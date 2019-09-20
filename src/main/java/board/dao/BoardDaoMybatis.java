package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import board.domain.BoardVO;
import board.domain.ReplyVO;
import member.domain.MemberVO;

@Repository
public class BoardDaoMybatis implements BoardDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSeeSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSeeSessionTemplate(SqlSessionTemplate sqlSeeSessionTemplate) {
		this.sqlSessionTemplate = sqlSeeSessionTemplate;
	}

	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("delete", boardVO);
	}

	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("update", boardVO);

	}

	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert", boardVO);
	}

	@Override
	public BoardVO select(int num) {
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", num);
		return vo;
	}

	@Override
	public List<String> searchFriend(String email) {
		return sqlSessionTemplate.selectList("friendId", email);
	}

	@Override
	public List<ReplyVO> replyList() {

		return sqlSessionTemplate.selectList("replyList");
	}

	@Override
	public List<MemberVO> memberSearch(String Search) {
		return sqlSessionTemplate.selectList("memberSearch", Search);
	}

}
