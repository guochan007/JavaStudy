//分别读取sql server和oracle 的sysdicthospital1表  按古交市  及下属机构 的顺序 分别写入到两个txt中，用于人工比对
package com.dataTransform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class SqlserverToOracle4 {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Map 表示sqlserver中旧的Id 和 oracle中新的Id 的对应关系
		// Map cityMap = new LinkedHashMap<Object, Object>();
		Map xianMap = new LinkedHashMap<Object, Object>();
		Map zhenMap = new LinkedHashMap<Object, Object>();

		File f = new File("e:\\TY_SYSDICTHOSPITAL1.txt");
		FileOutputStream fos = null;// 字节输出流

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			// 将县写入
			ps = ct
					.prepareStatement("select * from SYSDICTHOSPITAL  where no_hostyoe=2 and pchoscode='14010000' order by chosname");
			rs = ps.executeQuery();
			while (rs.next()) {
//				读取机构名称
//				String chosname = rs.getString("chosname");
//				读取机构主键id
				String chosname = Integer.toString(rs.getInt("no_hospital"));
				String choscode = rs.getString("choscode");
				xianMap.put(chosname, choscode);
			}

			// 将镇写入
			fos = new FileOutputStream(f);
			Set xianset = xianMap.keySet();
			for (Iterator iter = xianset.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) xianMap.get(key);
				ps = ct
						.prepareStatement("select * from SYSDICTHOSPITAL  where pchoscode=? order by chosname");
				ps.setString(1, value);

				fos.write(key.getBytes());
				String s = "\r\n\r\n\r\n";
				fos.write(s.getBytes());

				rs = ps.executeQuery();
				while (rs.next()) {
//					String cHosName = rs.getString("cHosName");
					String cHosName = Integer.toString(rs.getInt("no_hospital"));
					fos.write(cHosName.getBytes());
					String s1 = "\r\n";
					fos.write(s1.getBytes());
				}
				fos.write(s.getBytes());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				ct.close();
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
