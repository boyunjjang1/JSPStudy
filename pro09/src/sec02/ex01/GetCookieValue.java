package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/get")
public class GetCookieValue extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    Cookie[] allValues = request.getCookies(); // request의 getCookies() 메서드를 호출해 브라우저에게 쿠키정보를 요청한 후 쿠키 정보를 배열로 가져옴
	    for(int i =0;i<allValues.length;i++) {
	    	if(allValues[i].getName().equals("cookieTest")) {
	    		out.println("<h2>Cookie값 가져오기 : " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
	    	}
	    }
	    		
	}

}
