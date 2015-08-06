//鉴于有些机构名称和拼音简写不对应
package com.dataTransform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.PingYinUtil;

public class Test4 {

	public static void main(String[] args) {
		transXZJG();
		transYLJG();
	}

//	将行政机构表的机构名转为拼音首字母
	public static void transXZJG() {
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

			ps = ct.prepareStatement("select * from SYSDICTAREA");
			rs = ps.executeQuery();

			while (rs.next()) {
				int no_area = rs.getInt("no_area");
				String areaname = rs.getString("areaname");
				PreparedStatement ps1 = null;
				if (areaname != null) {
					String pycode = PingYinUtil.getFirstSpell(areaname)
							.toUpperCase();
					ps1 = ct
							.prepareStatement("update SYSDICTAREA set pycode='"
									+ pycode + "' where no_area=" + no_area);
				}

				try {
					ps1.executeQuery();
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("有问题的行政机构（县）：" + areaname);
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
	
//	将医疗机构表的机构名转为拼音首字母
	public static void transYLJG() {
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
			
			ps = ct.prepareStatement("select * from SYSDICTHOSPITAL");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int no_hospital = rs.getInt("no_hospital");
				String chosname = rs.getString("chosname");
				PreparedStatement ps1 = null;
				if (chosname != null) {
					String chelpcode = PingYinUtil.getFirstSpell(chosname)
					.toUpperCase();
					ps1 = ct
					.prepareStatement("update SYSDICTHOSPITAL set chelpcode='"
							+ chelpcode + "' where no_hospital=" + no_hospital);
				}
				
				try {
					ps1.executeQuery();
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("有问题的医疗机构：" + chosname);
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
