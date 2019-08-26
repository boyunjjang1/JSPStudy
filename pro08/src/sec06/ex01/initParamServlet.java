package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2" 
		}, // 매핑을 주소 2개로 할 수 있음, 동일한 결과 출력
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
		})
// initParams ? @WebInitParam 애너테이션 이용해 매개변수를 추가하는 기능
public class initParamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email"); // 설정한 매개변수의 name으로 값을 가져 옴
		String tel = getInitParameter("tel");
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>email: </td><td>" + email + "</td></tr>");
		out.print("<tr><td>휴대전화: </td><td>" + tel + "</td>");
		out.print("</tr></table></body></html>");
	}

}
