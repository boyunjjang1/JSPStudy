package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get")
public class GetAttribute extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();
		
		// 각 서블릿 API에서 바인딩 된 속성의 값을 가져옴
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) sess.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("context값 : " + ctxMesg + "<br>");
		// 다른 브라우저에서 출력하면 null 이 출력됨 ==> session은 브라우저 하나에서만 공유하기 떄문에
		out.print("session값 : " + sesMesg + "<br>");
		// request가 null이 출력됨 ==> set에서 요청한 request와는 다르기 떄문에
		out.print("request값 : " + reqMesg + "<br>");

	}
	

}
