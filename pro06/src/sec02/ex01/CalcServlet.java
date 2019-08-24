package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

	private static final float USD_RATE = 1;
	private static final float JPY_RATE = 1;
	private static final float CNY_RATE = 1;
	private static final float GBP_RATE = 1;
	private static final float EUR_RATE = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate"))
		{
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><fontsize=10>변환결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계싼기</a>");
			return;
		}
		
		pw.print("<html><title>환율계산기</title>");
		pw.print("<font size=5>환율계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action'/pro06/calc' />");
		pw.print("원화: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator' >");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'>");
		pw.println("<input type='submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
		
	}
	
	private static String calculate(float won, String operator) {
		String result =  null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		return result;
		
	}
	
	

}
