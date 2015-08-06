//从sql server向oracle 导sysdicthospital表
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

public class SqlserverToOracle2 {

	public static void main(String[] args) {

		// 定义需要的对象
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection ct1 = null;
		Statement sm1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
//		Map 表示sqlserver中旧的Id 和 oracle中新的Id 的对应关系
		
		Map cityMap = new LinkedHashMap<Object, Object>();
		Map xianMap = new LinkedHashMap<Object, Object>();
		Map zhenMap = new LinkedHashMap<Object, Object>();

		try {
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("加载数据库驱动成功");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:sqlserver://127.0.0.1:1433;databaseName=childshaicha2009",
					"sa", "000000");
			ct1 = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ct1.setAutoCommit(false);
			ps = ct
					.prepareStatement("select * from SCsysdicthospital where No_HosTyoe=1 and chelpcode is not null order by city");
			ps1 = ct1
					.prepareStatement("insert into SYSDICTHOSPITAL(NO_HOSPITAL,CHOSNAME,CHOSCODE,NO_HOSTYOE,ISINEFFECT,PCHOSCODE,CHELPCODE,LOGINCODE) values(?,?,?,?,?,?,?,?)");
			
			rs = ps.executeQuery();
			int noHospital = getMaxNoHospital()+1;
			String cHosCode=getMaxChoscode();
			int cHosCodeInt=Integer.parseInt(cHosCode)+1;
			// 将市写入
//			int icity=0;
			while (rs.next()) {
				String cHosName = rs.getString("cHosName");
//				String cHosCode = rs.getString("cHosCode");
				int No_Area = rs.getInt("No_Area");
				int No_HosTyoe = rs.getInt("No_HosTyoe");
				int IsInEffect = rs.getInt("IsInEffect");
				String PcHoscode = rs.getString("PcHoscode");				
				String chelpcode = rs.getString("chelpcode").toUpperCase();
				String city = rs.getString("city");;
//				System.out.println(cHosName.trim().substring(0, 3));
				if (cHosName.trim().substring(0, 3).equals("太原市")) {
					continue;
				}
				ps1.setInt(1, noHospital);
				cHosName=changeName(cHosName);
				ps1.setString(2, cHosName);
				ps1.setString(3, Integer.toString(cHosCodeInt));
				if(No_HosTyoe==1){
					ps1.setInt(4, No_HosTyoe);
				}else{
					System.out.println(cHosName+"没有级别 或级别不对");
					ps1.setInt(4, 1);
				}
				ps1.setInt(5, IsInEffect);
				ps1.setString(6, "19");
				ps1.setString(7, chelpcode);
				ps1.setString(8, Integer.toString(cHosCodeInt));
				ps1.executeQuery();
				cityMap.put(city, Integer.toString(cHosCodeInt));
//				cityArray[icity] = city;
				noHospital++;
//				icity++;
				cHosCodeInt++;
			}

			// 将县写入
//			int ixian = 0;
//			 for (int j = 0; j <= cityArray.length - 1; j++) {
			Set set = cityMap.keySet();
			for (Iterator iter = set.iterator(); iter.hasNext();) {
//				int key = (Integer) iter.next();
				String key = (String) iter.next();
				String value = (String) cityMap.get(key);
				ps = ct
						.prepareStatement("select * from SCsysdicthospital where No_HosTyoe=2 and city=?");
//				ps.setString(1, Integer.toString(key));
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					String cHosName = rs.getString("cHosName");
//					String cHosCodeSqlserver = rs.getString("cHosCode");
					int No_Area = rs.getInt("No_Area");
					int No_HosTyoe = rs.getInt("No_HosTyoe");
					int IsInEffect = rs.getInt("IsInEffect");
					String PcHoscode = rs.getString("PcHoscode");
					String chelpcode=null;
					if(rs.getString("chelpcode")==null){
//						System.out.println(cHosName);
						chelpcode=PingYinUtil.getFirstSpell(cHosName).toUpperCase();
					}else{
						chelpcode = rs.getString("chelpcode").toUpperCase();
					}
					String city = rs.getString("city");;
					ps1.setInt(1, noHospital);
					cHosName=changeName(cHosName);
					ps1.setString(2, cHosName);
					ps1.setString(3, Integer.toString(cHosCodeInt));
					if(No_HosTyoe==2){
						ps1.setInt(4, No_HosTyoe);
					}else{
						System.out.println(cHosName+"没有级别 或级别不对");
						ps1.setInt(4, 2);
					}
					ps1.setInt(5, IsInEffect);
					ps1.setString(6, value);
					ps1.setString(7, chelpcode);
					ps1.setString(8, Integer.toString(cHosCodeInt));
					ps1.executeQuery();
//					xianArray[ixian] = No_Area;
					xianMap.put(No_Area, Integer.toString(cHosCodeInt));
					noHospital++;
//					ixian++;
					cHosCodeInt++;
				}
			}

			// 将镇写入
//			int izhen = 0;
			Set xianset = xianMap.keySet();
			for (Iterator iter = xianset.iterator(); iter.hasNext();) {
				int key = (Integer) iter.next();
				String value = (String) xianMap.get(key);
				ps = ct
						.prepareStatement("select * from SCsysdicthospital where No_Area=?");
				ps.setInt(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					String cHosName = rs.getString("cHosName");
//					String cHosCodeSqlserver = rs.getString("cHosCode");
					int No_Area = rs.getInt("No_Area");
					int No_HosTyoe = rs.getInt("No_HosTyoe");
					int IsInEffect = rs.getInt("IsInEffect");
					String PcHoscode = rs.getString("PcHoscode");				
					String chelpcode=null;
					if(rs.getString("chelpcode")==null){
						System.out.println(cHosName);
						if(cHosName==null){
							System.out.println(rs.getInt("No_hospital"));
							continue;
						}
						chelpcode=PingYinUtil.getFirstSpell(cHosName).toUpperCase();
					}else{
						chelpcode = rs.getString("chelpcode").toUpperCase();
					}
					String city = rs.getString("city");;
					ps1.setInt(1, noHospital);
					ps1.setString(2, cHosName);
					ps1.setString(3, Integer.toString(cHosCodeInt));
					if(No_HosTyoe==3){
						ps1.setInt(4, No_HosTyoe);
					}else{
						System.out.println(cHosName+"没有级别 或级别不对");
						ps1.setInt(4, 3);
					}
					ps1.setInt(5, IsInEffect);
					ps1.setString(6, value);
					ps1.setString(7, chelpcode);
					ps1.setString(8, Integer.toString(cHosCodeInt));
					ps1.executeQuery();
//					xianArray[ixian] = No_Area;
					zhenMap.put(No_Area, Integer.toString(cHosCodeInt));
					noHospital++;
//					ixian++;
					cHosCodeInt++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ct1.commit();
//				事务没起作用？
				rs.close();
				ps.close();
				ct.close();
//				rs1.close();
				ps1.close();
				ct1.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static int getMaxNoHospital() throws SQLException {
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int NO_HOSPITAL = 0;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ps = ct.prepareStatement("select max(NO_HOSPITAL) as NO_HOSPITAL from SYSDICTHOSPITAL");
			rs = ps.executeQuery();
			if (rs.next()) {
				NO_HOSPITAL = rs.getInt("NO_HOSPITAL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			ct.close();
		}
		return NO_HOSPITAL;
	}
	
	public static String getMaxChoscode() throws SQLException {
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String CHOSCODE=null;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			ps = ct.prepareStatement("select max(CHOSCODE) as CHOSCODE from SYSDICTHOSPITAL");
			rs = ps.executeQuery();
			if (rs.next()) {
				CHOSCODE = rs.getString("CHOSCODE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			ct.close();
		}
		return CHOSCODE;
	}

	
//	将运城市妇幼院改为运城市卫生局
	public static String changeName(String str){
//		这个顺序有讲究的 不同顺序 不同结果
		str=str.replaceAll("妇幼保健院", "卫生局");
		str=str.replaceAll("妇幼站", "卫生局");
		str=str.replaceAll("妇幼院", "卫生局");
		str=str.replaceAll("妇幼", "卫生局");
		return str;
	}
	/*
	public static void main(String args[]){
		String str="妇幼站妇幼";
		System.out.println(changeName(str));
//		卫生局站卫生局
	}
	*/
}
