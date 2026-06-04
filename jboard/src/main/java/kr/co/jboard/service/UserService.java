package kr.co.jboard.service;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import kr.co.jboard.dao.UserDAO;
import kr.co.jboard.dto.UserDTO;

public enum UserService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private UserDAO dao = UserDAO.getInstance();

	// 회원가입
	public void register(UserDTO dto) {
		dao.insert(dto);
	}

	// 로그인
	public UserDTO login(String userid, String pass) {
		return dao.selectUser(userid, pass);
	}
	
	// 이메일 인증코드 전송
	public String sendEmailCode(String receiver) {
		
		// 인증코드 생성(6자리 랜덤 숫자)
		int code = ThreadLocalRandom.current().nextInt(100_000, 1_000_000);
				
		// 이메일 내용 정보
		String sender = "heocoding@gmail.com";
		String title = "jboard 인증코드 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		
		// Gmail SMTP 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Gmail SMTP 세션 생성
		Session sess = Session.getInstance(props, new Authenticator(){
			
			protected PasswordAuthentication getPasswordAuthentication(){
				
				final String APP_PASS = "rvem zjds wqde wscb";
				return new PasswordAuthentication(sender, APP_PASS);
			}
		});
		
		// 이메일 전송을 위한 마임메세지 작성
		Message message = new MimeMessage(sess);
		
		try{
			message.setFrom(new InternetAddress(sender, "보내는사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=UTF-8");
			
			// 최종 전송
			Transport.send(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(code);
	}

	// 중복체크 (존재하면 1, 없으면 0 반환)
	public int countUser(String type, String value) {
		return dao.selectCount(type, value);
	}
}