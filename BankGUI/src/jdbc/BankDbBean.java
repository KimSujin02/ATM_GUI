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
			System.out.println("����̹� �ε� �� connection ����");
		}
	}
	
	public static BankDbBean bd = new BankDbBean();
	
	public static BankDbBean getInstance() {
		if(bd == null) {
			bd = new BankDbBean();
		}
		return bd;
	}
	
	public int CreateUser(BankBean bb) { //���»����ϱ�
		int success=1; //�����ϸ� 1 �����ϸ� 0
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
			System.out.println("���»��� �����Դϴ�.");
			success = 0; //���������� 0
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return success; //�����ϸ� 1 �����ϸ� 0
	}
	
	public String CheckRecord(String account_num, String pw) { //���� Ȯ���ϱ�
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
					result = "����� �������� ���߽��ϴ�. �˼��մϴ�.";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� �ҷ����� ����");
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
	
	public void Send() { //�۱�
		
	}
	
	public void Deposit(String account_num, String pw, String money) { //�Ա�
		sql = "";
		
	}
	
	public void WithDraw() { //���
		
	}
	
}
