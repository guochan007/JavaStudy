//将市下面所有的县里的镇   绑定
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

public class Test3 {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// Map 表示sqlserver中旧的Id 和 oracle中新的Id 的对应关系

		Map cityMap = new LinkedHashMap<Object, Object>();
		Map xianMap = new LinkedHashMap<Object, Object>();
		Map zhenMap = new LinkedHashMap<Object, Object>();
		String cityArray[] = new String[20];
		String xianArray[] = new String[500];
		String zhenArray[] = new String[5000];

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ct.setAutoCommit(false);

			String cityName = "  晋中市  ";
			cityName = cityName.trim();
			ps = ct
					.prepareStatement("select no_area from SYSDICTAREA where areaname='"
							+ cityName + "'");
			rs = ps.executeQuery();
			rs.next();
			int no_area1 = rs.getInt("no_area");

			ps = ct
					.prepareStatement("select * from SYSDICTAREA where pno_area="
							+ no_area1 + " order by areaname");
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				xianArray[i] = rs.getString("areaname");
				i++;
			}

			for (int j = 0; j < xianArray.length; j++) {

				String xianName = xianArray[j];// 行政机构的县
				if(xianName==null){
					break;
				}
				xianName = xianName.trim();
				ps = ct
						.prepareStatement("select no_area from SYSDICTAREA where areaname='"
								+ xianName + "'");
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
						+ choscode + "'");
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
				// rs1.close();
				// ps1.close();
				// ct1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

//java.sql.SQLException: 结果集已耗尽 
//为啥已经报这个错了，但是我commit之后，还是得到了我想要的数据库结果，奇怪了？？？？？