package sec02.ex02;

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
	
	public void addMember(MemberVO memberVO)
	{
		try
		{
			con = dataFactory.getConnection(); // DB와 연동
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += " (id,pwd,name,emial)";
			query += " values(?, ?, ?, ?)";
			// sql 문 query에 넣기
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query); // insert문의 각 ? 에 순서대로 회원 정보를 세팅합니다.
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name); 
			pstmt.setString(4, email);
			pstmt.executeUpdate(); // 회원 정보를 테이블에 추가합니다.
			pstmt.close(); 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void delMember(String id)
	{
		try
		{
			con = dataFactory.getConnection();
			String query = "delete from t_member" + " where id=?";
			System.out.println("prepareStatement:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id); // 첫번쨰 전달된 ?에 ID를 인자로 넣는다
			pstmt.executeUpdate(); // delete문을 사용해서 회원 정보 삭제!
			pstmt.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
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
