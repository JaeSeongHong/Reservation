package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
		

public class AirportDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String cityName;
	String price;
	
public void getConn() {//DB연결
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "KoreaAIR";
			String pw = "12345"
					+ "";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void close() {//DB 해제
		
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
	
	public String portName(String arrive) {//공항 검색
		
		getConn();
		
		try {
			String sql = "select * from Airport_INFO where PORT_NAME = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,arrive);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				cityName = rs.getString("PORT_NAME");
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 오류!");
			e.printStackTrace();
		}
		
		return cityName;
		
		
		
	}
	
	
}
