//oracle  jdbc 存储过程
package com.jdbc;

import java.sql.*;

public class JdbcOracleProcedure {

	public static void main(String[] args) {

		Connection ct = null;
		Statement sm = null;
		ResultSet rs = null;
		String sql = "{call stuProc11()}";
		// String sql = "call stuProc()";

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 得到连接 数据源
			ct = DriverManager
					.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL",
							"system", "000000");

			CallableStatement cs = ct.prepareCall(sql);
			cs.execute();
			
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
