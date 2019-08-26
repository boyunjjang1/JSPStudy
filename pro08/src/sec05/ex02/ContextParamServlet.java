package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		/* Web.xml <param-name> 태그의 이름으로 <param-value>의 값을 받아옴
			web.xml ? Web.xml 파일의 설정들은 Web Application 시작시 메모리에 로딩됨
		 */
		 
		String menu_member = context.getInitParameter("menu_member");
		String menu_order= context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		out.print("<html><body>");
	    out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
	    out.print("<tr><td>" + menu_member + "</td></tr>");
	    out.print("<tr><td>" + menu_order + "</td></tr>");
	    out.print("<tr><td>" + menu_goods + "</td></tr>");
	    out.print("</tr></table></body></html>");	
	}

}
