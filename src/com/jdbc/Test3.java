//oracle  jdbc-odbc  都是连接到本地的数据库    要想远程连接 用jdbc
package com.jdbc;

import java.sql.*;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
//			加载驱动
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			得到连接  数据源
			Connection ct=DriverManager.getConnection("jdbc:odbc:TestOracle","scott","000000");
			Statement sm=ct.createStatement();
			ResultSet rs=sm.executeQuery("select * from emp");
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
//			关闭资源
			rs.close();
			sm.close();
			ct.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
