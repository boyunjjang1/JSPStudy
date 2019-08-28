package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/login")
public class SessionTest4 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//�α��� â���� ���۵� ID�� ��й�ȣ�� ������
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) {
			// �α���â���� �������� ��û�ߴٸ� ID �� null�� �ƴϹǷ� ���ǿ� ID�� ���ε� �Ѵ�.
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				out.println("<a href='login'>�α��� ���� Ȯ��</a>");
			} else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		} else {
			user_id = (String) session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("�ȳ��ϼ��� " + user_id + "��!!!");
			} else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		}
	}

}
