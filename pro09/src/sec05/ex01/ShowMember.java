package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 사용자가 로그인 할 때 회원 정보 표시 창
@WebServlet("/show")
public class ShowMember extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id="", pwd="";
        Boolean isLogon=false;
        
        // 이미 세션이 존재하면 세션을 반환하고 없으면 null을 반환함
        HttpSession session = request.getSession(false);
        
        // 먼저 세션이 생성되어있는지를 본다.
        if(session != null) {
        	// isLogon 속성을 가져와 로그인 상태를 확인한다.
        	isLogon=(Boolean)session.getAttribute("isLogon");
        	if(isLogon == true) {
        		id = (String)session.getAttribute("login.id");
    	        pwd = (String)session.getAttribute("login.pwd");
       	        out.print("<html><body>");
    	        out.print("아이디: " + id+"<br>");
    	        out.print("비밀번호: " + pwd+"<br>");
    	        out.print("</body></html>");
        	} else {
        		response.sendRedirect("login3.html");
        	}
        } else {
        	response.sendRedirect("login3.html");
        }
	}
}
