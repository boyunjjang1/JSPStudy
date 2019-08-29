package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


// HttpSessionBindingListener�� ������ Listener�� ������ ��� �̺�Ʈ �ڵ鷯��
// �ݵ�� �ֳ����̼��� �̿��ؼ� Listener�� ����ؾ� ��
@WebListener
public class LoginImpl implements HttpSessionListener {

	String user_id;
	String user_pw;
	static int total_user =0;
	
    public LoginImpl() {
       
    }
    
    public LoginImpl(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // ���� ���� �� �̺�Ʈ�� ó����
    	System.out.println("���� ����");
    	++total_user;
    }

	@Override
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("���� �Ҹ�");
         --total_user;
    }
	
}
