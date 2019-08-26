package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" }, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;
	
	@Override // Override �ֳ����̼��� ��ӹ��� ��ü�� ������ �������̵� �������
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig�� init �޼��� ȣ��");
		context = config.getServletContext(); // init() �޼��忡�� ServletContext ��ü�� ��´�
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		// getInitParameter() �޼���� Web.xml�� �޴� ������ �о� ����
		context.setAttribute("menu_member", menu_member); // menu ������ ServletContext ��ü�� ���ε�
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// init���� ServletContext ��ü�� ������Ƿ� �ּ�!!
		String menu_member = (String) context.getAttribute("menu_member");
		String menu_order = (String) context.getAttribute("menu_order");
		String menu_goods = (String) context.getAttribute("menu_goods");
		// ���������� ��û �� ServletContext ��ü�� ���ε� �� �޴� �׸��� �����ɴϴ�.
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>�޴� �̸�</tr>");
		out.print("<tr><td>" + menu_member + "</td></tr>");
		out.print("<tr><td>" + menu_order + "</td></tr>");
		out.print("<tr><td>" + menu_goods + "</td></tr>");
		out.print("</tr></table></body></html>");
		
	}

}
