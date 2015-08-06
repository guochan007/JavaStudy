//从sql server向oracle 导sysdictarea表
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

public class SqlserverToOracle {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection ct1 = null;
		Statement sm1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		// String cityArray[] = new String[20];
		// String xianArray[] = new String[500];
		// String zhenArray[] = new String[5000];
		// Map 表示sqlserver中旧的Id 和 oracle中新的Id 的对应关系

		Map cityMap = new LinkedHashMap<String, String>();
		Map xianMap = new LinkedHashMap<String, String>();
		Map zhenMap = new LinkedHashMap<String, String>();
		Map cunMap = new LinkedHashMap<String, String>();

		try {
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("加载数据库驱动成功");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:sqlserver://127.0.0.1:1433;databaseName=wstsjsb0228",
					"sa", "000000");
			ct1 = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ct1.setAutoCommit(false);
			ps = ct
					.prepareStatement("select * from SysDictArea where levelcode=?");
			ps1 = ct1
					.prepareStatement("insert into SysDictArea(no_area,areaname,pno_area,pycode,inineffect,iexecutivelevel,CADMINIDIVISIONCODE) values(?,?,?,?,?,?,?)");

			// 循环2-4 市 县 乡
			ps.setInt(1, 2);
			rs = ps.executeQuery();
			// int icity = 0;
			// String AreaCodeCity = "1001";// 实际插入表
			String AreaCodeXian = Integer.toString(getMaxIndex() + 1);
			// 将市写入
			while (rs.next()) {
				String AreaCode = rs.getString("AreaCode");
				String AreaName = rs.getString("AreaName");
				String pycode = rs.getString("pycode").toUpperCase();
				// String PareAreaCode = rs.getString("PareAreaCode");
				String PareAreaCodeCity = "100";
				int isEffect = rs.getInt("isEffect");
				int levelcode = rs.getInt("levelcode");
				if (AreaName.trim().equals("太原市")) {
					continue;
				}
				// int AreaCodeCityInt=Integer.parseInt(AreaCodeCity);
				int AreaCodeXianInt = Integer.parseInt(AreaCodeXian);

				// ps1.setString(1, Integer.toString(AreaCodeCityInt+1));
				ps1.setString(1, Integer.toString(AreaCodeXianInt));
				ps1.setString(2, AreaName);
				ps1.setString(3, PareAreaCodeCity);
				ps1.setString(4, pycode);
				ps1.setInt(5, isEffect);
				ps1.setInt(6, levelcode);
				ps1.setString(7, AreaCode);
				ps1.executeQuery();
				// cityArray[icity] = AreaCode;
				// cityMap.put(AreaCode, Integer.toString(AreaCodeCityInt+1));
				cityMap.put(AreaCode, Integer.toString(AreaCodeXianInt));
				// icity++;

				// AreaCodeCityInt++;
				AreaCodeXianInt++;
				// AreaCodeCity=Integer.toString(AreaCodeCityInt);
				AreaCodeXian = Integer.toString(AreaCodeXianInt);
			}

			// 将县写入
			// int ixian = 0;
			// String AreaCodeXian = Integer.toString(getMaxIndex()+1);
			// for (int j = 0; j <= cityArray.length - 1; j++) {
			// ps = ct
			// .prepareStatement("select * from SysDictArea where PareAreaCode= '"
			// + cityArray[j] + "'");

			Set set = cityMap.keySet();
			for (Iterator iter = set.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) cityMap.get(key);
				ps = ct
						.prepareStatement("select * from SysDictArea where PareAreaCode=?");
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					String AreaCode = rs.getString("AreaCode");
					String AreaName = rs.getString("AreaName");
					if (AreaName.trim().equals("市辖区")) {// 市辖区下头没东西
						continue;
					}
					String pycode = rs.getString("pycode").toUpperCase();
					// String PareAreaCode = rs.getString("PareAreaCode");
					int isEffect = rs.getInt("isEffect");
					int levelcode = rs.getInt("levelcode");
					ps1.setString(1, AreaCodeXian);
					ps1.setString(2, AreaName);
					ps1.setString(3, value);
					ps1.setString(4, pycode);
					ps1.setInt(5, isEffect);
					ps1.setInt(6, levelcode);
					ps1.setString(7, AreaCode);
					ps1.executeQuery();
					// xianArray[ixian] = AreaCode;
					xianMap.put(AreaCode, AreaCodeXian);
					// ixian++;
					int AreaCodeXianInt = Integer.parseInt(AreaCodeXian);
					AreaCodeXianInt++;
					AreaCodeXian = Integer.toString(AreaCodeXianInt);
				}
			}

			// 将镇写入
			// int izhen = 0;
			// for (int j = 0; j <= xianArray.length - 1; j++) {
			// ps = ct
			// .prepareStatement("select * from SysDictArea where PareAreaCode= '"
			// + xianArray[j] + "'");
			Set xianset = xianMap.keySet();
			for (Iterator iter = xianset.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) xianMap.get(key);
				ps = ct
						.prepareStatement("select * from SysDictArea where PareAreaCode=?");
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					String AreaCode = rs.getString("AreaCode");
					String AreaName = rs.getString("AreaName");
					String pycode = rs.getString("pycode").toUpperCase();
					String PareAreaCode = rs.getString("PareAreaCode");
					int isEffect = rs.getInt("isEffect");
					int levelcode = rs.getInt("levelcode");
					ps1.setString(1, AreaCodeXian);
					ps1.setString(2, AreaName);
					ps1.setString(3, value);
					ps1.setString(4, pycode);
					ps1.setInt(5, isEffect);
					ps1.setInt(6, levelcode);
					ps1.setString(7, AreaCode);
					ps1.executeQuery();
					// zhenArray[izhen] = AreaCode;
					zhenMap.put(AreaCode, AreaCodeXian);
					// izhen++;
					int AreaCodeXianInt = Integer.parseInt(AreaCodeXian);
					AreaCodeXianInt++;
					AreaCodeXian = Integer.toString(AreaCodeXianInt);
				}
			}

//			System.out.println("AreaCodeXian===========" + AreaCodeXian);
			// 12676
			// 将村写入
			Set zhenset = zhenMap.keySet();
			for (Iterator iter = zhenset.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) zhenMap.get(key);
				ps = ct
						.prepareStatement("select * from SysDictArea where PareAreaCode=?");
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					String AreaCode = rs.getString("AreaCode");
					String AreaName = rs.getString("AreaName");
					AreaName=AreaName.trim();
					String pycode = rs.getString("pycode").toUpperCase();
					// String PareAreaCode = rs.getString("PareAreaCode");
					int isEffect = rs.getInt("isEffect");
					int levelcode = rs.getInt("levelcode");
//					if (AreaCode == null || AreaName == null || pycode == null) {
//						System.out.println("areacode============" + AreaCode);
//					}
					if (AreaName.equals("")||AreaName==null) {
						System.out.println("areacode============" + AreaCode);
						continue;
					}
					ps1.setString(1, AreaCodeXian);
					ps1.setString(2, AreaName);
					ps1.setString(3, value);
					ps1.setString(4, pycode);
					ps1.setInt(5, isEffect);
					ps1.setInt(6, levelcode);
					ps1.setString(7, AreaCode);
					try {
						ps1.executeQuery();
					} catch (Exception e) {
						System.out.println("areacode============" + AreaCode);
						e.printStackTrace();
					}
					// zhenArray[izhen] = AreaCode;
					cunMap.put(AreaCode, AreaCodeXian);
					// izhen++;
					int AreaCodeXianInt = Integer.parseInt(AreaCodeXian);
					AreaCodeXianInt++;
					AreaCodeXian = Integer.toString(AreaCodeXianInt);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ct1.commit();

				rs.close();
				ps.close();
				ct.close();
				// rs1.close();
				ps1.close();
				ct1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static int getMaxIndex() throws SQLException {
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int AreaCode = 0;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ps = ct
					.prepareStatement("select max(no_area) as AreaCode from SysDictArea");
			rs = ps.executeQuery();
			if (rs.next()) {
				AreaCode = Integer.parseInt(rs.getString("AreaCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			ct.close();
		}
		return AreaCode;
	}
}
