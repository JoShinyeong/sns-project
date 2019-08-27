package member.contoller;

import member.service.MemberService;

public class MemberController {
	private MemberService memberService; 
	// 로그인 버튼 submit시에 피드/ 메인창으로 넘겼을 시 보드 list 쿼리 실행하면서 들고 오기 위해 

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
