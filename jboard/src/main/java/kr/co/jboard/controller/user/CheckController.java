package kr.co.jboard.controller.user;

import java.io.IOException;

import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.service.ArticleService;
import kr.co.jboard.service.UserService;

@WebServlet("/user/check.do")
public class CheckController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String type = req.getParameter("type");
		String value = req.getParameter("value");
		
		// 아이디 중복여부 조회
		int count = service.countUser(type, value);
		
		// 결과물 JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count); // 0: 사용가능, 1: 존재하는 아이디
		
		// JSON 전송
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(json.toString());		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
