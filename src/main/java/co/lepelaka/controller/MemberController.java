package co.lepelaka.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.lepelaka.domain.MemberVO;
import co.lepelaka.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("member")
@Log4j
@AllArgsConstructor
public class MemberController {
	private MemberService memberService;
	
	@GetMapping("login")
	public void login() {}
	
//	@GetMapping("chkId/{id}") @ResponseBody
//	public boolean chkId(@PathVariable String id) throws Exception{
//		Thread.sleep(500);
//		return memberService.get(id) != null ;
//	}
//	
//	
//	@GetMapping("join")
//	public void join() {}
//	@PostMapping("join")
//	public void join(MemberVO vo) {}
//	
//	@GetMapping("chat")
//	public void chat() {}
//	@GetMapping("login")
//	public void login() {}
//	
//	@PostMapping("login")
//	public String login(MemberVO vo, HttpSession session,
//			RedirectAttributes rttr, @RequestParam(defaultValue="false", value="remember-me") Boolean remember, HttpServletResponse resp) {
//		log.info(vo);
//		MemberVO memberVO = memberService.get(vo);
//		log.info(session);
//		if(memberVO == null) {
//			rttr.addFlashAttribute("msg", "로그인 실패");
//		}
//		else {
//			session.setAttribute("member", memberVO);
//			log.info("로그인 성공");
//			
//			// 로그인 성공 시 remember-me여부 확인
//			log.info(remember);
////			log.info(cookie);
//			if(remember) {
//				Cookie cookie = new Cookie("id", memberVO.getId());
//				cookie.setMaxAge(60 * 60 * 24 * 30);
//				cookie.setPath("/");
//				resp.addCookie(cookie);
//			}
//			
//			// 자동로그인 여부를 저장할 장소(cookie or DB or Both), 에 저장
//		}
//		return "redirect:/member/login";
//	}
//	@RequestMapping("logout")
//	public String logout(HttpSession session) {
//		log.info("로그아웃 처리");
//		session.invalidate();
//		return "redirect:/member/login";
//	}
//	@GetMapping("getList")
//	@ResponseBody
//	public List<MemberVO> getList() {
//		return memberService.getList();
//	}
}
