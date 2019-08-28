package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SessionTest extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session =  request.getSession(); 
		// getSession()을 호출하여 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환
		out.println("세션 아이디: " + session.getId() + "<br>");
		out.println("최초 세션 생성 시각:" + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시각:" + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("세션 유효 시간:" + session.getMaxInactiveInterval() + "<br>");
		// getMaxInactiveInterval() 은 세션 유지 시간을 int 타입으로 변환함
		if(session.isNew()) {
			out.println("새 세션이 만들어졌습니다.");
		}
	}
}
