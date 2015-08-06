//oracle  jdbc
package com.jdbc;

import java.sql.*;

public class JdbcMysql {

	public static void main(String[] args) {

		Connection ct = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 得到连接 数据源
			ct = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "000000");
			// 创建对象 statemenyt preparedstatement callablestatement
			sm = ct.createStatement();
			// 通过statement向数据库发出sql指令
			// executeUpdate执行dml语句insert update delete
			rs = sm.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println("ID: " + rs.getString(1) + " name: "
						+ rs.getString("name") + " email: " + rs.getString(3)
						+ " hireDate: " + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;// 使用垃圾回收
			}
			if (sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sm = null;
			}
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ct = null;
			}
		}
	}

}
