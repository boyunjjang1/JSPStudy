package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest1")
public class AjaxTest1 extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}
	
	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// getParameter()로 ajax로 전송된 매개변수를 가져 옴
		String param = (String) request.getParameter("param");
		System.out.println("param = " + param);
		
		// PrintWriter의 print() 메서드를 이용해 브라우저에 응답 메시지를 보냄
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요! 서버입니다.");
		
	}
	
}
