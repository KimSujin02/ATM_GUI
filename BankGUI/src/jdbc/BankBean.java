package jdbc;

public class BankBean {
	private String name;
	private String account_num;
	private String pw;
	private int balance;
	private String record;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
	public BankBean(String account_num, String pw) {
		this.account_num = account_num;
		this.pw = pw;
	}
	
	public BankBean() {
	}
	
	
}
