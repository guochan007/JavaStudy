//绑定镇级医疗机构和其对应的行政机构
package com.dataTransform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.util.PingYinUtil;

public class Test1DaoTong {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ct.setAutoCommit(false);
			String xianName = " 盂县 ";//行政机构的县
			xianName=xianName.trim();
			ps = ct
					.prepareStatement("select no_area from SYSDICTAREA where areaname='"
							+ xianName+"'");
			rs = ps.executeQuery();
			rs.next();
			int no_area = rs.getInt("no_area");

			ps = ct
					.prepareStatement("select choscode from SYSDICTHOSPITAL where chosname='"
							+ xianName + "卫生局'");
			rs = ps.executeQuery();
			rs.next();
			String choscode = rs.getString("choscode");

			ps = ct.prepareStatement("update SYSDICTHOSPITAL set no_area="
					+ no_area + ",is_certi_children=1 where pchoscode='"
					+ choscode+"'");
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ct.commit();
				// 事务没起作用？
				rs.close();
				ps.close();
				ct.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
