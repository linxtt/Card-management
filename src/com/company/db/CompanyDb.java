package com.company.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CompanyDb {

	private static Connection conn=null;
	private final static String Url="jdbc:mysql://127.0.0.1:3306/lin_company";
	private final static String User="root";
	private final static String PassWord="linxtt";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		if(conn==null) {
			try {
				conn=DriverManager.getConnection(Url, User, PassWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConn() {
		if(conn!=null) {
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
