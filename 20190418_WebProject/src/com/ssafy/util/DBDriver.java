package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDriver {
	private static DBDriver instance;
	private Connection conn; // 데이터베이스와 통신하기위한 객체

	public DBDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1/" + "mydb"; // 데이터베이스명
			url += "?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbName = "";
			String user = "";
			String password = "";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(!conn.isClosed() + " : DB 연결 성공여부");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBDriver getInstance() {
		if (instance == null) {
			instance = new DBDriver();
		}
		return instance;
	}

	public Connection getConn() {
		return conn;
	}
	
}
