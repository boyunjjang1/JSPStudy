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

// WebFilter �������̼��� �̿��� ��� ��û�� ���͸� ��ġ�� �ؾ���
@WebFilter("/*")
public class EncoderFilter implements Filter { // ����� ���� ���ʹ� �ݵ�� Filter �������̽��� �����ؾ� ��
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 ���ڵ�....................");
		context = fConfig.getServletContext();
	}
	
	
	/*
	 <ServletRequest�� HttpServletRequest�� ��
	 	#ServletRequest�� Ŭ���̾�Ʈ ��ü�� ���� ����, Ŭ���̾�Ʈ�� ������ ������ ����
	 	#HttpServletRequest�� request��ü�� ��û �Ķ���Ϳ� ���� request��ü�� �� ���̳� ������..
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		// �ѱ� ���ڵ� ���� �۾��� ����
		request.setCharacterEncoding("utf-8");
		
		// �� ���ø����̼��� ���ؽ�Ʈ �̸��� �����´�.
		String context = ((HttpServletRequest)request).getContextPath();
		// �� ���������� ��û�� ��û URI�� ������
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		// ��û URI�� ���� ��θ� ������
		String realPath = ((HttpServletRequest) request).getSession().getServletContext().getRealPath(pathinfo);
		
		String mesg = " Context  ����:" + context + "\n URI ���� : " + pathinfo + "\n ������ ���:  " + realPath;
		System.out.println(mesg);
		
		// ��û ���Ϳ��� ��û ó�� ���� �ð��� ����
		long begin = System.currentTimeMillis();
		
		// ���� ���ͷ� �ѱ�� �۾��� �����մϴ�.
		chain.doFilter(request, response); // ���� ���� ����
		
		// ���� ���Ϳ��� ��û ó�� ���� �ð��� ����
		long end = System.currentTimeMillis();
		System.out.println("�۾� �ð�:" + (end-begin) + "ms");
		
		// ��û ���� ����� ������ �� ���� doFilter()�� ���� ��
	}
	
	public void destroy() {
		System.out.println("destroy ȣ��");
	}



}
