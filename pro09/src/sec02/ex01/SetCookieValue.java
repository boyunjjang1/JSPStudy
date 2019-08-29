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
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP ���α׷��� �Դϴ�.", "utf-8"));
		// ==> Cookie ��ü�� ������ �� cookieTest �̸����� �ѱ� ������ ���ڵ��ؼ� ��Ű�� ���� ��!!
		
		// c.setMaxAge(24*60*60); // ��ȿ�Ⱓ ����
		// ��ȿ�ð��� ������ �����Ͽ� session ��Ű�� ���� �� ����
		// session ��Ű ? �������� ����ϴ� �޸𸮿� �����ϴ� ��Ű
		c.setMaxAge(-1);
		response.addCookie(c); // ������ ��Ű�� �������� ������. ���� -> Ŭ��
		
		out.println("����ð� : " + d);
		out.println("<br> ���ڿ��� Cookie�� �����մϴ�.");
		
	}

}
