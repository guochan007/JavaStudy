package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnServer {

	/*
	 * 通过jdbc连接远程数据库，进行相应的操作
	 */
	public static void main(String[] args) {

		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@183.203.16.185:1521:ORCL", "dbo_tyggws",
					"dbo_tyggws");
			ct.setAutoCommit(false);
			String sql = "undate sysdicthospital set logincode=1401060499 where no_hospital=910050";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			ct.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				ct.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
