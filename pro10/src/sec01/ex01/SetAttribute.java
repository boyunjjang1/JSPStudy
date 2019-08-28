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

@WebServlet("/set")
public class SetAttribute extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMesg = "context�� ���ε��˴ϴ�.";
		String sesMesg = "session�� ���ε��˴ϴ�.";
		String reqMesg = "request�� ���ε��˴ϴ�.";
		
		// HttpServletContext ��ü, HttpSession ��ü, HttpServletRequest ��ü�� ���� ��
		// �Ӽ��� ���ε� �Ѵ�.
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		request.setAttribute("request", reqMesg);
		out.print("���ε��� �����մϴ�.");
		

	}
}
