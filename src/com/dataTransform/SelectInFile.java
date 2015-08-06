package com.dataTransform;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectInFile {

	/*
	 	Select b from table1 where xx in (a1,a2,a3)
	   	这样查到的结果，b的列表不是按照a1,a2,a3的顺序排列的，怎样写才能保证查到的结果和in（）中的顺序列表一一对应？？？
	  	case when 和union all 感觉都有点笨 写太多了 记录很多
	  
	  	create table temp2 (
		id number(10),
		choscode varchar2(30)
		)
	  	实验发现select * from temp2的结果顺序并不是但是插入时的顺序
	  	由于之前将数据写入数据库的表中 不尽人意，本人觉得还是将数据写入文件中，进行备份
	 */
	public static void main(String[] args) {

		Connection ct = null;
		Connection ct1 = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		File f = new File("e:\\tt.txt");
		FileOutputStream fos = null;// 字节输出流
		int[] Array_no_Hospital = { 910179, 13322, 910183, 910200, 910180,
				911232, 910083, 13204, 910085, 910088, 910093, 910092, 910086,
				911235, 911233, 911234, 910126, 910129, 910133, 910128, 13306,
				910203, 911236, 911237, 910167, 910168, 910136, 910145, 910137,
				911238, 911239, 911240, 910101, 910109, 910118, 910123, 910117,
				910111, 910115, 910110, 910102, 910120, 910114, 910107, 910005,
				910004, 910030, 910027, 910025, 910008, 910026, 13310, 13309,
				13308, 13311, 13307, 910032, 910029, 910043, 910015, 910028,
				911241, 910063, 910075, 910064, 910065, 910074, 910072, 910067,
				910079, 910080, 910077, 910068, 910066, 911242, 910153, 910158,
				910154, 911243, 910046, 910051, 910049, 910053, 910058, 910055,
				910048, 910057, 910061, 910052, 910010, 910047, 910059, 910056,
				910050, 910060 };

		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@183.203.16.185:1521:ORCL", "dbo_tyggws",
					"dbo_tyggws");
//			ct1 = DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "jmmchis", "1");
			// ct.setAutoCommit(false);
			// ct1.setAutoCommit(false);
			fos = new FileOutputStream(f);
			for (int i = 0; i < Array_no_Hospital.length; i++) {
				String sql = "select choscode,logincode from sysdicthospital where no_hospital="
						+ Array_no_Hospital[i];
				ps = ct.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					String choscode = rs.getString("choscode");
					String logincode = rs.getString("logincode");
//					ps1 = ct1
//							.prepareStatement("insert into temp2(choscode) values("
//									+ choscode + ")");
//					ps1.executeQuery();
					
					fos.write(logincode.getBytes());
					String s = "\r\n";
					fos.write(s.getBytes());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ct.commit();
				rs.close();
				ps.close();
				ct.close();
				// ct1.commit();
				fos.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
