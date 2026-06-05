package controller.user1;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 서비스 가져오기
	private User1Service service = User1Service.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user1/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String userid = req.getParameter("userid");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		String mode = req.getParameter("mode");
		System.out.println("mode : " + mode);
		
		
		// 서비스 전송 객체 생성
		User1DTO dto = new User1DTO();
		dto.setUserid(userid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		
		System.out.println(dto);
		
		// 등록 서비스 메서드 호출
		service.register(dto);
		
		if(mode == null) {
			// 목록 리다이렉트
			resp.sendRedirect("/ch09/user1/list.do?register=success");	
		}else if(mode.equals("json")) {
			
			// JSON 생성(List를 Json으로 변환)
			Gson gson = new Gson();
			String strJson = gson.toJson(dto);
			
			// 사용자에게 JSON 응답
			resp.setContentType("application/json;charset=UTF-8");
			resp.getWriter().write(strJson);
			
		}
		
		
	}
	

}