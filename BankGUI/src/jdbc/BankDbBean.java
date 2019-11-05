package jdbc;

import java.sql.*;

import com.mysql.fabric.xmlrpc.base.Data;

public class BankDbBean {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost:3306/bankgui?useSSL=false";
	final String USER = "root";
	final String PASS = "mirim2";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public BankDbBean() {	
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("����̹� �ε� �� connection ����");
		}
	}
	
	public int CreateUser(String name, String account_num, String pw, String balanceIN) { //���»����ϱ�
		int result=1; //�����ϸ� 1 �����ϸ� 0
		sql = "INSERT INTO bankuser VALUES (?, ?, ?, ?, ?)";
		
		int balance = Integer.parseInt(balanceIN);
		String record = "���� ���� \n�Ա� : " + balance + "\n";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, account_num);
			pstmt.setString(3, pw);
			pstmt.setInt(4, balance);
			pstmt.setString(5, record);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("���»��� �����Դϴ�." + e);
			result = 0; //���������� 0
		}
		return result; //�����ϸ� 1 �����ϸ� 0
	}
	
	
	public String CheckRecord(String account_num, String pw) { //���� Ȯ���ϱ�
		sql = "SELECT * FROM bankuser where account_num=?";
		String record = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String bbpw = rs.getString("pw");
				if(bbpw.equals(pw)) {
					record = rs.getString("record");
				} else {
					record = "����� �������� ���߽��ϴ�.";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� �ҷ����� ����");
		}
		return record;
	}
	
	public int selectAccount(String account_num, String pw) {
		int result = 1;
		//�����ϸ� 1, �����ϸ� 0
		sql = "SELECT * FROM bankuser where account_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString("pw");
				if(pwd.equals(pw)) {
					result = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	public int Send(String takeAccount, String giveAccount, String account_pw, String moneyIn) { //�۱�
		int result = 0;
		//�����ϸ� 1, �����ϸ� 0
		//������ ���°� Ȯ���� �ȵǰų� ��й�ȣ�� Ʋ���� 2
		//������ ������ �ܾ��� �۱� �ݾ׺��� ������ 3
		//�޴� ���°� �������� ������ 4
		int money = Integer.parseInt(moneyIn);
		
		result = selectAccount(giveAccount, account_pw);
	
		if(result == 1) {
			result = WithDraw(giveAccount, account_pw, money);
			if(result == 1) {
				result = Deposit(takeAccount, money);
				if(result == 1) {
					result = 1;
				} else {
					System.out.println("�޴� ���°� �������� �ʽ��ϴ�.");
					result = 4;
				}
			} else {
				System.out.println("�ܾ׺����Դϴ�.");
				result = 3;
			}
		} else {
			System.out.println("������ ���°� �����ͺ��̽��� �������� �ʰų� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			result = 2;
		}
		return result;
	}
	
	public int Deposit(String account_num, int money) { //�Ա�
		int result = 1;
		//�����ϸ� 1, �����ϸ� 0
		sql = "SELECT * FROM bankuser where account_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt("balance");
				String record = rs.getString("record");
				
				balance += money;
				record += ("�Ա� : " + money + "��\t�ܾ� : " + balance + "\n");
				sql = "UPDATE bankuser SET balance=?, record=? WHERE account_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, record);
				pstmt.setString(3, account_num);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	public int WithDraw(String account_num, String pw, int money) { //���
		int result = 1;
		//�����ϸ� 1, �����ϸ� 0
		sql = "SELECT * FROM bankuser where account_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt("balance");
				String record = rs.getString("record");
				
				balance -= money;
				record += ("��� : " + money + "��\t�ܾ� : " + balance + "\n");
				sql = "UPDATE bankuser SET balance=?, record=? WHERE account_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, record);
				pstmt.setString(3, account_num);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
