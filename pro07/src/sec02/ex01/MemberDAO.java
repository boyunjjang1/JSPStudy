package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Ȯ�� ��Ű�� javax
// javax.naming ? ���� �������� �׼����ϱ� ���� Ŭ���� �� �������̽��� ����
import javax.naming.Context;
import javax.naming.InitialContext;
// ConnectionPool ��ü�� �����ϱ� ���� JNDI
// Key / Value �� ���·� ����
import javax.sql.DataSource; // COnnectionPool ��ü�� �����ϱ� ���� Ŭ����


public class MemberDAO {
	/*
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "triger";
	*/
	// ==> �� �̻� ������ �����Ƿ� �ּ�!
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			// lookup("java:/comp/env") �� ���� ���ø��ҽ��� ���� 
			// JNDI�� ����
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			// ==> ���� context.xml�� ������ name�� �̸� ������ DataSource�� �޾ƿ�
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// connDB();
			con = dataFactory.getConnection(); // DataSource�� �̿��� �����ͺ��̽��� ����
			String query = "select * from t_member";
			System.out.println("prepareSatement:" + query);
			
			pstmt = con.prepareStatement(query); 
			//prepareStatement �޼��忡 sql���� �����Ͽ� prepareStatement ��ü�� ����
			ResultSet rs = pstmt.executeQuery();
			// executeQuery() �޼��带 ȣ���� �̸� ������ sql���� ����
			
			while(rs.next())
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("emial");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	// DAO���� ���� �����ͺ��̽��� �����ϴ� ����� ���� �ʿ� ����!
	
//	private void connDB()
//	{
//		try
//		{
//			Class.forName(driver);
//			System.out.println("Oracle ����̹� �ε� ����");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection ���� ����");
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	

}
