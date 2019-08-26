package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address = (String)request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("주소:" + address);
		out.println("<br>");
		out.println("dispatch를 이용한 바인딩 실습입니다."); // 브라우저를 거치지 않고 바로 전달돼서 
		// 첫 번쨰 서블릿의 request에 바인딩 된 데이터가 그대로 전달 됨
		out.println("</body></html>");
	}
}
