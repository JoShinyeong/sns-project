package member.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value = "/member/signup", method = RequestMethod.POST)
	 public String signUp2(Model model,String email, MemberVO memberVO, HttpServletRequest req) {
		 model.addAttribute("memberVO", new MemberVO());
		 email = req.getParameter("email");
		 System.out.println(memberVO.getEmail());
		 System.out.println(memberVO.getName());
		 System.out.println(memberVO.getPassword());
		 System.out.println(email); 
		 int check = memberService.matchID(email);
		 System.out.println(memberVO.getEmail());
		 System.out.println(check);
		 if(check ==1) {
			 System.out.println("이미 존재하는 아이디입니다.");
			 return "redirect:/member/signup";
		 }
		 else {
			 memberService.memberInsert(memberVO);
			 System.out.println(memberVO.getEmail());
			 System.out.println(memberVO.getName());
			 System.out.println(memberVO.getPassword());
			 System.out.println(email); 
			 return "/member/main";
		 }
	 }
	@RequestMapping(value="/user/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("userId")String email) {
		return memberService.userIdCheck(email);
	}
	@RequestMapping(value = "/member/matchPw", method = RequestMethod.GET)
	public String matchPW(Model model, HttpServletRequest req) {
	 HttpSession session =req.getSession();
	 MemberVO memberVO =(MemberVO) session.getAttribute("member");
	 return "/member/matchPW";
	}
	
	public String matchPW2(Model model, MemberVO memberVO, HttpServletRequest req) {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("name", name);
		System.out.println(map);
		memberVO =memberService.matchPW(map);
		System.out.println(memberVO.getPassword());
		if(memberVO.getPassword()!=null) {
			model.addAttribute("memberVO", memberService.matchPW(map));
			System.out.println("비밀번호 찾기 성ㅇ공");
			System.out.println();
			return "/member/matchPW2";
		}
		else { 
			System.out.println("비번찾기 실패");
			return "/member/signup";
		}
	}
	
	
	
	
}
