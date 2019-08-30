package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter pw = response.getWriter();
		// session 객체를 가져옴
		HttpSession session = request.getSession();
		// session 객체에 name에 바인딩
		session.setAttribute("name", "보유미");
		
		pw.println("<html><body>");
		pw.println("<h1>세션에 이름일 바인딩합니다. </h1>");
		pw.println("<a href='/pro12/test01/session1/jsp'>첫번째 페이지로 이동하기 </a>");
		pw.println("</body></html>");
		
		
	}

}
