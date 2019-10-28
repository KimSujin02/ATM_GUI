package jdbc;

import javax.naming.*;
import java.sql.*;
import javax.sql.*;

public class DBConnection {
	public static Connection getConnection() throws SQLException,
		NamingException, ClassNotFoundException {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/bankgui");
			Connection conn = ds.getConnection();
			return conn;
		}

	}