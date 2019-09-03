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
		// getParameter()�� ajax�� ���۵� �Ű������� ���� ��
		String param = (String) request.getParameter("param");
		System.out.println("param = " + param);
		
		// PrintWriter�� print() �޼��带 �̿��� �������� ���� �޽����� ����
		PrintWriter writer = response.getWriter();
		writer.print("�ȳ��ϼ���! �����Դϴ�.");
		
	}
	
}
