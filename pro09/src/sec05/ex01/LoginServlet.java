package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doHandle(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		MemberVO memberVO = new MemberVO();
		// MemberVO ��ü�� �����ϰ� �Ӽ��� ID�� ��й�ȣ ����
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		// MemberDAO�� isExisted() �޼��带 ȣ���ϸ鼭 memberVO�� �����Ѵ�.
		boolean result = dao.isExisted(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			// ��ȸ�� ����� true�� isLogOn �Ӽ��� true�� ���ǿ� ����
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			
			out.print("<html><body>");
			out.print("�ȳ��ϼ���" + user_id + "��!!!<br>");
			out.print("<a href='show'>ȸ������ ����</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>ȸ�� ���̵� Ʋ���ϴ�.");
			out.print("<a href='login3.html'> �ٽ� �α����ϱ�</a>");
			out.print("</body></html>");
		}
		
	}
}
