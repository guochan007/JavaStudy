//绑定医疗机构和行政机构    太他妈烦了 手动对哇
//本来不相关的两个表，硬是根据名字来确定对应关系，由于汉字叫法的混乱，无法写出一劳永逸的代码，代替人工绑定的行为，比如将 长治城区卫生局 和 长治市城区 绑定在一起，编程实现感觉不太可能
//如果 将县以下的机构都和县绑定在一起  就可以拿程序统一处理了

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

public class SqlserverToOracle5 {

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
			ps = ct
			.prepareStatement("select * from SYSDICTAREA where iexecutivelevel=2 order by areaname;");
//			ps = ct
//					.prepareStatement("select * from SYSDICTHOSPITAL where no_hostyoe=1 order by chosname");
			
			rs = ps.executeQuery();
			// 绑定市
			int icity=0;
			while (rs.next()) {
				String no_area1 = rs.getString("no_area");
				int no_area = rs.getInt("no_area");
				String areaname = rs.getString("areaname");
				String chosname = rs.getString("areaname")+"卫生局";
				String choscode = rs.getString("choscode");
				if (areaname.trim().equals("太原市")) {
					continue;
				}
				String sql="update SYSDICTHOSPITAL set no_area="+no_area+" where no_hostyoe=1 and chosname="+chosname;
				ps1 = ct
				.prepareStatement(sql);
				ps1.executeQuery();
				cityArray[icity]=choscode;
				icity++;
			}
			
			ps=ct.prepareStatement("select * from SYSDICTHOSPITAL  where no_hostyoe=1 order by chosname");
			rs=ps.executeQuery();
			int icity=0;
			while (rs.next()) {
				String cHosName = rs.getString("cHosName");
				String cHosCode = rs.getString("cHosCode");
				int No_Area = rs.getInt("No_Area");
				int No_HosTyoe = rs.getInt("No_HosTyoe");
				int IsInEffect = rs.getInt("IsInEffect");
				String PcHoscode = rs.getString("PcHoscode");				
				String chelpcode = rs.getString("chelpcode").toUpperCase();
				String city = rs.getString("city");
				if (cHosName.trim().substring(0, 3).equals("太原市")) {
					continue;
				}
				cityArray[icity]=cHosCode;
				icity++;
			}

			// 绑定县
//			int ixian = 0;
			 for (int j = 0; j <= cityArray.length - 1; j++) {
//			Set set = cityMap.keySet();
//			for (Iterator iter = set.iterator(); iter.hasNext();) {
////				int key = (Integer) iter.next();
//				String key = (String) iter.next();
//				String value = (String) cityMap.get(key);
				ps = ct
						.prepareStatement("select * from SCsysdicthospital where No_HosTyoe=2 and city=?");
//				ps.setString(1, Integer.toString(key));
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					
					String sql="update SYSDICTHOSPITAL set no_area="+no_area+"  where  pchoscode="+pchoscode+"order by chosname";
					ps1 = ct
					.prepareStatement(sql);
					ps1.executeQuery();
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
