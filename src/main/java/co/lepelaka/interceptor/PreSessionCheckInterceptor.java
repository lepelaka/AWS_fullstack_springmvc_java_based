package co.lepelaka.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import co.lepelaka.domain.MemberVO;
import co.lepelaka.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
public class PreSessionCheckInterceptor implements HandlerInterceptor{
	@Autowired
	private MemberService memberService; 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie cookie = WebUtils.getCookie(request, "id");
		log.warn(cookie);
		if(cookie != null) {
			String id = cookie.getValue();
			log.warn(id);
			//MemberVO vo = memberService.read(id);
//			log.warn(vo);
//			if(vo != null) {
//				request.getSession().setAttribute("member", vo);
//			}
		}
		return true;
	}
	
}
