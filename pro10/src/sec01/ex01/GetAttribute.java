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
		
		// �� ���� API���� ���ε� �� �Ӽ��� ���� ������
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) sess.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("context�� : " + ctxMesg + "<br>");
		// �ٸ� ���������� ����ϸ� null �� ��µ� ==> session�� ������ �ϳ������� �����ϱ� ������
		out.print("session�� : " + sesMesg + "<br>");
		// request�� null�� ��µ� ==> set���� ��û�� request�ʹ� �ٸ��� ������
		out.print("request�� : " + reqMesg + "<br>");

	}
	

}
