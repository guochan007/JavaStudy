//绑定县
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

public class Test2 {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// Map 表示sqlserver中旧的Id 和 oracle中新的Id 的对应关系

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ct.setAutoCommit(false);

			String cityName = " 晋中市 ";
			cityName = cityName.trim();
			ps = ct
					.prepareStatement("select no_area from SYSDICTAREA where areaname='"
							+ cityName + "'");
			rs = ps.executeQuery();
			rs.next();
			int no_area = rs.getInt("no_area");

			
			ps = ct
					.prepareStatement("select * from SYSDICTAREA where pno_area="
							+ no_area + " order by areaname");
			rs = ps.executeQuery();

			while (rs.next()) {
				String xianName = rs.getString("areaname");
				String chosname = xianName.trim() + "卫生局";
				int no_areaNew=rs.getInt("no_area");
				ps = ct.prepareStatement("update SYSDICTHOSPITAL set no_area="
						+ no_areaNew + " where chosname='"
						+ chosname + "'");
				try {
					ps.executeQuery();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("有问题的县：" + xianName);
				}

			}

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
