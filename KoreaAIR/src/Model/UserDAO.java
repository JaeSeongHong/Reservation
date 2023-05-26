// 작성자 : 홍재성
// 최근작성일자 : 23.05.01
// 유저정보 관련기능(회원정보 ,예약 및 조회)
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private String userName;
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	UserDTO dto = null;

//DB 연결
public void getConn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "KoreaAIR";
			String pw = "12345";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

//DB 해제
public void close() {
	
	try {
		if(rs != null) {
			rs.close();
		}
		if(pstm != null) {
			pstm.close();
		}
		if(conn != null) {
			conn.close();
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

//회원가입 메소드
public void SignUp(String newId, String newPw, String newName, String cellNum) {
	
	getConn();
	int result = 0;
	
	try {
		String sql = "insert into KoreaAIR Values(?,?,?,?)";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, newId);
		pstm.setString(2, newPw);
		pstm.setString(3, newName);
		pstm.setString(4, cellNum);
		
		result = pstm.executeUpdate();
		System.out.println(result);
		
		
	} catch (SQLException e) {
		System.out.println("쿼리문 오류");
		e.printStackTrace();
	}
	
		
}

// 로그인 메소드
public String login(String InputId, String InputPw) {
	
	getConn();
	
	
	try {
		String sql = "select * from USER_INFO where USER_ID =? and USER_PW =?";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, InputId);
		pstm.setString(2, InputPw);
		rs = pstm.executeQuery();
		System.out.println(rs);
		
		if(rs.next()) {
			userName = rs.getString("USER_NAME");
		}
		
	} catch (SQLException e) {
		System.out.println("쿼리문 오류");
		
		e.printStackTrace();
	}
	
	return userName;
	
}


	
	
}
