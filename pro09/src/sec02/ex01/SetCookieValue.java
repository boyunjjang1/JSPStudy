package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/set")
public class SetCookieValue extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍 입니다.", "utf-8"));
		// ==> Cookie 객체를 생성한 후 cookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장 함!!
		
		// c.setMaxAge(24*60*60); // 유효기간 설정
		// 유효시간을 음수로 지정하여 session 쿠키를 만들 수 있음
		// session 쿠키 ? 브라우저가 사용하는 메모리에 저장하는 쿠키
		c.setMaxAge(-1);
		response.addCookie(c); // 생성된 쿠키를 브라우저로 전송함. 서버 -> 클라
		
		out.println("현재시간 : " + d);
		out.println("<br> 문자열을 Cookie에 저장합니다.");
		
	}

}
