//计算公卫各表随访次数  下半年
package com.dataTransform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JinYuanBuZhu2 {

	static Connection ct = null;
//	11.8
//	static File f = new File("d:\\晋源补助.txt");
//	180
	static File f = new File("e:\\晋源补助.txt");
	static FileOutputStream fos = null;// 字节输出流
	
	public static void main(String[] args) {

		// 定义需要的对象
//		String startTime="20141128";
//		String endTime="20141231";
//		int no_hospital=1;
		String startTime="20140701";
		String endTime="20141231";
		Scanner s = new Scanner(System.in);
		System.out.println("输入no_hospital");
		//receive string
		int no_hospital = s.nextInt();
		System.out.println("输入的是："+no_hospital);
		String sql=" and no_hospital in (select no_hospital from sysdicthospital z start with z.no_hospital="+no_hospital+" connect by z.pchoscode=prior z.choscode)";
		String sql1=" and b.choscode in (select choscode from sysdicthospital z start with z.no_hospital="+no_hospital+" connect by z.pchoscode=prior z.choscode)";
		String sql2=" and a.no_hospital in (select no_hospital from sysdicthospital z start with z.no_hospital="+no_hospital+" connect by z.pchoscode=prior z.choscode)";
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载数据库驱动成功");
			// 得到连接
			ct = DriverManager.getConnection(
//					清徐11.8
//					"jdbc:oracle:thin:@192.168.11.8:1522:QXVHCIS118", "qxvhcis", "1");
//					太原185
					"jdbc:oracle:thin:@192.168.2.45:1521:orcl", "dbo_tyggws", "dbo_tyggws");
//					本地测试
//					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "mchis", "1");
			fos = new FileOutputStream(f);

			//新生儿访视人次
			String sql3="select count(*) num from NEWBABYHOMEVISZ where to_char(dvistime,'yyyyMMdd')>="+ startTime +" and to_char(dvistime,'yyyyMMdd')<= "+ endTime+sql; 
			//满月
			String sql4="select count(*) num from withinOneYearChildCheck where to_char(dvistime,'yyyyMMdd')>= "+ startTime +" and to_char(dvistime,'yyyyMMdd')<= "+ endTime +" and period=1 "+sql;
			//3月
			String sql5="select count(*) num from withinOneYearChildCheck where to_char(dvistime,'yyyyMMdd')>= "+ startTime +" and to_char(dvistime,'yyyyMMdd')<= "+ endTime +" and period=2 "+sql;
//			8 18 30月
			String sql6="select sum(a1) num from " +
				" (select count(*) a1 from withinOneYearChildCheck where to_char(dvistime,'yyyyMMdd')>= "+ startTime +" and to_char(dvistime,'yyyyMMdd')<= "+ endTime +" and period=4 "+sql+
				" union select count(*) a1 from chUnderTwoYearsHealthCare where to_char(dVisitDate,'yyyyMMdd')>= "+ startTime +" and to_char(dVisitDate,'yyyyMMdd')<= "+ endTime +" and nProject in (2,4) "+sql+")";
//			6 12 24 36月	
			String sql7="select sum(a1) num from " +
				" (select count(*) a1 from withinOneYearChildCheck where to_char(dvistime,'yyyyMMdd')>= "+ startTime +" and to_char(dvistime,'yyyyMMdd')<= "+ endTime +" and period=3 "+sql+
				" union select count(*) a1 from chUnderTwoYearsHealthCare where to_char(dVisitDate,'yyyyMMdd')>= "+ startTime +" and to_char(dVisitDate,'yyyyMMdd')<= "+ endTime +" and nProject in (1,3) "+sql+
				" union select count(*) a1 from yearOldchildren where to_char(ChildFollowUpdate,'yyyyMMdd')>= "+ startTime +" and to_char(ChildFollowUpdate,'yyyyMMdd')<= "+ endTime +" and nianl=1 "+sql+")";
//			4-6岁
			String sql8="select count(*) num from yearOldchildren where to_char(ChildFollowUpdate,'yyyyMMdd')>= "+ startTime +" and to_char(ChildFollowUpdate,'yyyyMMdd')<= "+ endTime +" and nianl in (2,3,4) "+sql;
//			孕12周
			String sql9="select count(*) num from whFirstAntenatalClinic "+
				" where floor( dCheckDate-dLastMonthlies) <=12*7 "+
				" and to_char(dCheckDate,'yyyyMMdd')>= "+ startTime +" and to_char(dCheckDate,'yyyyMMdd')<= "+ endTime +sql;
//			孕13-15周
			String sql10="select count(*) num from  woPretanalReview09 a "+
			" left join whFirstAntenatalClinic b on a.iwomanid=b.iwomanid "+
			" where floor( a.DVISITDATE-b.dLastMonthlies) >=13*7 and floor( a.DVISITDATE-b.dLastMonthlies) <=15*7 "+
			" and to_char(a.DVISITDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DVISITDATE,'yyyyMMdd')<= "+ endTime +sql2;
//			孕16-24周
			String sql11="select count(*) num from  woPretanalReview09 a "+
			" left join whFirstAntenatalClinic b on a.iwomanid=b.iwomanid "+
			" where floor( a.DVISITDATE-b.dLastMonthlies) >=16*7 and floor( a.DVISITDATE-b.dLastMonthlies) <=24*7 "+
			" and to_char(a.DVISITDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DVISITDATE,'yyyyMMdd')<= "+ endTime +sql2;
//			孕25-27周
			String sql12="select count(*) num from  woPretanalReview09 a "+
				" left join whFirstAntenatalClinic b on a.iwomanid=b.iwomanid "+
				" where floor( a.DVISITDATE-b.dLastMonthlies) >=25*7 and floor( a.DVISITDATE-b.dLastMonthlies) <=27*7 "+
				" and to_char(a.DVISITDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DVISITDATE,'yyyyMMdd')<= "+ endTime +sql2;
//			孕28-40周
			String sql13="select count(*) num from  woPretanalReview09 a "+
				" left join whFirstAntenatalClinic b on a.iwomanid=b.iwomanid "+
				" where floor( a.DVISITDATE-b.dLastMonthlies) >=28*7 and floor( a.DVISITDATE-b.dLastMonthlies) <=40*7"+
				" and to_char(a.DVISITDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DVISITDATE,'yyyyMMdd')<= "+ endTime +sql2;
//			产后
			String sql14="select count(*) num from whAfterPregnantVisit09 where to_char(DVISITDATE,'yyyyMMdd')>= "+ startTime +" and to_char(DVISITDATE,'yyyyMMdd')<= "+ endTime +sql;
//			产后42
			String sql15="select count(*) num from womenAfterBirth where to_char(visDate,'yyyyMMdd')>= "+ startTime +" and to_char(visDate,'yyyyMMdd')<= "+ endTime +sql;
//			老年人体检  归档的就不算了（理论上来讲，应该不考虑归档不归档，只要做过随访就算工作量，但是系统中都是考虑的，为了统一查询出来的数字，将归档因素考虑进来 ）
			String sql16="select count(*) num from HealthMedicaTable a left join paarchive b on a.ipersonserialno=b.ipersonserialno" +
//				" where b.nStatus=0 and floor(extract(year from sysdate)-extract(year from b.DBIRTH))>=65 " +
				" where b.nStatus=0 and trunc(months_between(sysdate,b.dBirth)/12) >=65 " +
//				" where floor(extract(year from sysdate)-extract(year from b.DBIRTH))>=65 " +
				" and to_char(a.DCHECKDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DCHECKDATE,'yyyyMMdd')<= "+ endTime +sql1;
//			高血压随访
			String sql17="select count(*) num from gxyvisrecord a left join paarchive b on a.ipersonserialno=b.ipersonserialno " +
				" where b.bHypertension=1 and b.nStatus=0 and to_char(a.gxyVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.gxyVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//				" where b.bHypertension=1 and to_char(a.gxyVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.gxyVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//				" where to_char(a.gxyVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.gxyVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//			一直查.....  太慢   建索引  建了还慢 算了
//			create index gxyvisrecord_iper on gxyvisrecord(ipersonserialno)
//			create index gxyvisrecord_visdate on gxyvisrecord(gxyVisDate)
//			糖尿病随访
			String sql18="select count(*) num from tnbvisrecord a left join paarchive b on a.ipersonserialno=b.ipersonserialno " +
				" where b.bDiabetes=1 and b.nStatus=0 and to_char(a.tnbVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.tnbVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//				" where b.bDiabetes=1 and to_char(a.tnbVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.tnbVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//				" where to_char(a.tnbVisDate,'yyyyMMdd')>= "+ startTime +" and to_char(a.tnbVisDate,'yyyyMMdd')<= "+ endTime +sql1;
//			一直查.....
//			老年人中医体质辨识
			String sql19="select count(*) num from HEALTHMEDICATCM a left join paarchive b on a.ipersonserialno=b.ipersonserialno " +
				" where b.nStatus=0 and to_char(a.DCHECKDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DCHECKDATE,'yyyyMMdd')<= "+ endTime +sql1;
//				" where to_char(a.DCHECKDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DCHECKDATE,'yyyyMMdd')<= "+ endTime +sql1;
//			儿童中医调养
			String sql20="select count(*) num from PEChildrentcm a left join chChildArc b on a.ICHILDID=b.ICHILDID " +
				" where to_char(a.DCHECKDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DCHECKDATE,'yyyyMMdd')<= "+ endTime +sql;
//			高血压体检
			String sql21="SELECT count(*) num from HealthMedicaTable a left join paArchive b on a.iPersonSerialNo = b.iPersonSerialNo " +
				" where b.bhypertension=1 and b.nStatus = 0 " +
				" and to_char(a.DCHECKDATE,'yyyyMMdd')>= '"+ startTime +"' and to_char(a.DCHECKDATE,'yyyyMMdd')<= '"+ endTime +"' "+sql1;
//			糖尿病体检
			String sql22="SELECT count(*) num from HealthMedicaTable a left join paArchive b on b.iPersonSerialNo = a.iPersonSerialNo " +
				" where b.bDiabetes=1 and b.nStatus = 0 " +
				" and to_char(a.DCHECKDATE,'yyyyMMdd')>= "+ startTime +" and to_char(a.DCHECKDATE,'yyyyMMdd')<= "+ endTime +sql1;
//			新增档案
			String sql23="select count(*) num from paarchive b where b.nstatus = 0 "+
				" and to_char(b.dIntime,'yyyyMMdd')>= "+ startTime +" and to_char(b.dIntime,'yyyyMMdd')<= "+ endTime +sql1;
//			修改档案
			String sql24="select count(*) num from paarchive b where b.nstatus = 0 "+
				" and to_char(b.dlastupdate,'yyyyMMdd')>= "+ startTime +" and to_char(b.dlastupdate,'yyyyMMdd')<= "+ endTime +sql1;
			
			writeIntoFile("新生儿访视人次",sql3);
			writeIntoFile("满月访视人次",sql4);
			writeIntoFile("3月访视人次",sql5);
			writeIntoFile("8 18 30月访视人次",sql6);
			writeIntoFile("6 12 24 36访视人次",sql7);
			writeIntoFile("4-6岁访视人次",sql8);
			writeIntoFile("孕12周访视人次",sql9);
			writeIntoFile("孕13-15访视人次",sql10);
			writeIntoFile("孕16-24访视人次",sql11);
			writeIntoFile("孕25-27访视人次",sql12);
			writeIntoFile("孕28-40访视人次",sql13);
			writeIntoFile("产后访视人次",sql14);
			writeIntoFile("产后42访视人次",sql15);
			writeIntoFile("老年人体检人次",sql16);
			writeIntoFile("高血压访视人次",sql17);
			writeIntoFile("高血压体检人次",sql21);
			writeIntoFile("糖尿病访视人次",sql18);
			writeIntoFile("糖尿病体检人次",sql22);
			writeIntoFile("老年人中医体质辨识人次",sql19);
			writeIntoFile("儿童中医调养人次",sql20);
			writeIntoFile("新增档案人次",sql23);
			writeIntoFile("修改档案人次",sql24);

			
			System.out.println("over");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	
	public static void writeIntoFile(String name,String sql){
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			fos.write(name.getBytes());
			String s = "\r\n";
			fos.write(s.getBytes());
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				String num = rs.getString("num");
				fos.write(num.getBytes());
				fos.write(s.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
