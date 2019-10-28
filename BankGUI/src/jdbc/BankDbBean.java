package jdbc;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jdbc.DBConnection;

public class BankDbBean {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public BankDbBean() {	
		try {
			conn = DBConnection.getConnection();
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("드라이버 로딩 및 connection 오류");
		}
	}
	
	public static BankDbBean bd = new BankDbBean();
	
	public static BankDbBean getInstance() {
		if(bd == null) {
			bd = new BankDbBean();
		}
		return bd;
	}
	
	public int CreateUser(BankBean bb) { //계좌생성하기
		int success=1; //성공하면 1 실패하면 0
		sql = "INSERT INTO bankuser VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getName());
			pstmt.setString(2, bb.getAccount_num());
			pstmt.setString(3, bb.getPw());
			pstmt.setInt(4, bb.getBalance());
			pstmt.setString(5, bb.getRecord());

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("계좌생성 실패입니다.");
			success = 0; //실패했을때 0
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return success; //성공하면 1 실패하면 0
	}
	
	public String CheckRecord(String account_num, String pw) { //내역 확인하기
		sql = "SELECT record FROM bankuser where account_num=?";
		String result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String bbpw = rs.getString("pw");
				if(bbpw.equals(pw)) {
					result = rs.getString("record");
				} else {
					result = "결과를 가져오지 못했습니다. 죄송합니다.";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("내역 불러오기 실패");
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void Send() { //송금
		
	}
	
	public void Deposit(String account_num, String pw, String money) { //입금
		sql = "";
		
	}
	
	public void WithDraw() { //출금
		
	}
	
}
