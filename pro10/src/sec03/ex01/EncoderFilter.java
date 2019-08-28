package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// WebFilter 에너테이션을 이용해 모든 요청이 필터를 거치게 해야함
@WebFilter("/*")
public class EncoderFilter implements Filter { // 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 함
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩....................");
		context = fConfig.getServletContext();
	}
	
	
	/*
	 <ServletRequest와 HttpServletRequest의 비교
	 	#ServletRequest는 클라이언트 자체에 대한 정보, 클라이언트가 전송한 정보를 추출
	 	#HttpServletRequest는 request객체의 요청 파라미터와 같이 request객체가 한 일이나 정보들..
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		// 한글 인코딩 설정 작업을 해줌
		request.setCharacterEncoding("utf-8");
		
		// 웹 애플리케이션의 컨텍스트 이름을 가져온다.
		String context = ((HttpServletRequest)request).getContextPath();
		// 웹 브라우저에서 요청한 요청 URI를 가져옴
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		// 요청 URI의 실제 경로를 가져옴
		String realPath = ((HttpServletRequest) request).getSession().getServletContext().getRealPath(pathinfo);
		
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);
		
		// 요청 필터에서 요청 처리 전의 시각을 구함
		long begin = System.currentTimeMillis();
		
		// 다음 필터로 넘기는 작업을 수행합니다.
		chain.doFilter(request, response); // 응답 필터 시작
		
		// 응답 필터에서 요청 처리 후의 시각을 구함
		long end = System.currentTimeMillis();
		System.out.println("작업 시간:" + (end-begin) + "ms");
		
		// 요청 필터 기능을 수행할 떄 마다 doFilter()가 수행 됨
	}
	
	public void destroy() {
		System.out.println("destroy 호출");
	}



}
