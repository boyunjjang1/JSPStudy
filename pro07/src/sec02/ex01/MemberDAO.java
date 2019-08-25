package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 확장 패키지 javax
// javax.naming ? 네임 서베스에 액세스하기 위한 클래스 및 인터페이스를 제공
import javax.naming.Context;
import javax.naming.InitialContext;
// ConnectionPool 객체에 접근하기 위한 JNDI
// Key / Value 쌍 형태로 저장
import javax.sql.DataSource; // COnnectionPool 객체를 구현하기 위한 클래스


public class MemberDAO {
	/*
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "triger";
	*/
	// ==> 더 이상 사용되지 않으므로 주석!
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			// lookup("java:/comp/env") 를 통해 로컬리소스에 접근 
			// JNDI에 접근
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			// ==> 톰켓 context.xml에 설정한 name값 미리 연결한 DataSource를 받아옴
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// connDB();
			con = dataFactory.getConnection(); // DataSource를 이용해 데이터베이스에 연결
			String query = "select * from t_member";
			System.out.println("prepareSatement:" + query);
			
			pstmt = con.prepareStatement(query); 
			//prepareStatement 메서드에 sql문을 전달하여 prepareStatement 객체를 생성
			ResultSet rs = pstmt.executeQuery();
			// executeQuery() 메서드를 호출해 미리 설정한 sql문을 실행
			
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
	
	
	// DAO에서 직접 데이터베이스를 연결하는 기능은 이제 필요 없음!
	
//	private void connDB()
//	{
//		try
//		{
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	

}
