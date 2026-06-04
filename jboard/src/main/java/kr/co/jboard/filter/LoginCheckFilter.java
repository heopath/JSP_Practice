package kr.co.jboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;

@WebFilter(urlPatterns = {"/article/*"})
public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		// 1. 기본 ServletRequest, ServletResponse를 Http 전용으로 변환
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp; // 리다이렉트를 위해 response도 변환 필요!
				
			// 2. 현재 사용자 세션 구하기 (req가 아닌 request에서 꺼내야 합니다!)
			HttpSession session = request.getSession();
			UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
				
			// 3. 로그인 상태 확인
			if(sessUser == null) {
				// 비로그인 상태인 경우: 글쓰기, 목록 보기를 막고 로그인 페이지로 강제 쫓아냄
				response.sendRedirect("/jboard/user/login.do?login=required"); 
		} else {
			// 로그인 상태인 경우: 멈추지 않고 원래 가려던 곳(다음 필터나 서블릿)으로 통과!
			chain.doFilter(req, resp);			
		}
	}
	
}
