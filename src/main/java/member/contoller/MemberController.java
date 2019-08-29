package member.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.domain.MemberVO;
import member.service.MemberService;

public class MemberController {
	private MemberService memberService; 
	// 로그인 버튼 submit시에 피드/ 메인창으로 넘겼을 시 보드 list 쿼리 실행하면서 들고 오기 위해 

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main(Model model) {
		return "/member/main";
	}
	@RequestMapping(value = "/member/main", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest req, HttpSession session)throws Exception{
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", pass);
		MemberVO memberVO = memberService.memberLogin(map);
		if (memberVO == null) {
			return "redirect:/member/main";
		} else {
			session.setAttribute("member", memberVO);
			return "redirect:/board/list";
		}
	}
	@RequestMapping(value = "/member/signup", method = RequestMethod.GET)
	public String signUp1(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		return "/member/signup";
	}

}
