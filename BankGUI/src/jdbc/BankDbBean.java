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
			System.out.println("드라이버 로딩 및 connection 오류");
		}
	}
	
	//새로운 계좌를 생성하는 메소드
	public int CreateUser(String name, String account_num, String pw, String balanceIN) { //계좌생성하기
		int result=1; //성공하면 1 실패하면 0
		sql = "INSERT INTO bankuser VALUES (?, ?, ?, ?, ?)";
		
		//문자열로 받아버린 balance(잔액)을 실수형으로 형변환
		int balance = Integer.parseInt(balanceIN);
		//계좌의 내역(record)에 계좌 생성이 되었다는 내용을 더한다.
		String record = "계좌 생성 \n입금 : " + balance + "\n";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, account_num);
			pstmt.setString(3, pw);
			pstmt.setInt(4, balance);
			pstmt.setString(5, record);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("계좌생성 실패입니다." + e);
			result = 0; //실패했을때 0
		}
		return result; //성공하면 1 실패하면 0
	}
	
	//지금까지 추가된 내역을 데이터베이스에서 가져와서 확인할 수 있는 메소드
	public String CheckRecord(String account_num, String pw) { //내역 확인하기
		//account_num에 해당하는 행의 데이터를 모두 가져온다는 sql문
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
					record = "결과를 가져오지 못했습니다.";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("내역 불러오기 실패");
		}
		return record;
	}
	
	//계좌번호와 비밀번호를 받아서 데이터베이스에 해당 계좌가 있고, 비밀번호가 맞았는지 확인하는 메소드
	public int selectAccount(String account_num, String pw) {
		int result = 1;
		//성공하면 1, 실패하면 0
		sql = "SELECT * FROM bankuser where account_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//비밀번호 확인
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
	
	public int Send(String takeAccount, String giveAccount, String account_pw, String moneyIn) { //송금
		int result = 0;
		//성공하면 1, 실패하면 0
		//보내는 계좌가 확인이 안되거나 비밀번호가 틀리면 2
		//보내는 계좌의 잔액이 송금 금액보다 작으면 3
		//받는 계좌가 존재하지 않으면 4
		int money = Integer.parseInt(moneyIn);
		
		result = selectAccount(giveAccount, account_pw);
	
		if(result == 1) {
			result = WithDraw(giveAccount, account_pw, money);
			if(result == 1) {
				result = Deposit(takeAccount, money);
				if(result == 1) {
					result = 1;
				} else {
					System.out.println("받는 계좌가 존재하지 않습니다.");
					result = 4;
				}
			} else {
				System.out.println("잔액부족입니다.");
				result = 3;
			}
		} else {
			System.out.println("보내는 계좌가 데이터베이스에 존재하지 않거나 비밀번호가 틀렸습니다.");
			result = 2;
		}
		return result;
	}
	
	//입금하고 현재 잔액에서 입금받은 금액을 더하고 내역에 입금 내역을 추가하여 데이터를 업데이트하는 메소드
	public int Deposit(String account_num, int money) {
		int result = 1;
		//성공하면 1, 실패하면 0
		sql = "SELECT * FROM bankuser where account_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt("balance");
				String record = rs.getString("record");
				
				balance += money;
				record += ("입금 : " + money + "원\t잔액 : " + balance + "\n");
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
	
	//계좌번호와 비밀번호와 금액을 입력받아, 계좌에 있는 잔액이 출금하려는 잔액보다 작으면 실패고, 크면 현재 있는 잔액에서 출금할 금액을 뺀 뒤 내역에 출금내역을 추가하는 메소드이다.
	public int WithDraw(String account_num, String pw, int money) { //출금
		int result = 1;
		//성공하면 1, 실패하면 0
		sql = "SELECT * FROM bankuser where account_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt("balance");
				String record = rs.getString("record");
				
				balance -= money;
				record += ("출금 : " + money + "원\t잔액 : " + balance + "\n");
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
