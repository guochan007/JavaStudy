//oracle  jdbc
package com.jdbc;

import java.sql.*;

public class JdbcOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection ct=null;
		Statement sm=null;
		ResultSet rs=null;
		try {
//			加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			得到连接  数据源
			ct=DriverManager.getConnection
//			("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","000000");			
			("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","system","000000");
//			创建对象 statemenyt preparedstatement callablestatement
			sm=ct.createStatement();
//			通过statement向数据库发出sql指令
//			executeUpdate执行dml语句insert update delete
//			第一个是序列USER1_SEQ.nextval
			sm.executeUpdate
			("insert into USER1 values(USER1_SEQ.nextval,'shunpinging','123123','ing@sina.com',sysdate,300)");
			
			rs=sm.executeQuery("select * from USER1");
			while(rs.next()){
				System.out.println("ID: "+rs.getString(1)+" name: "+rs.getString("name")+" password: "+rs.getString(3)+" email: "+rs.getString(4)+" date: "+rs.getString(5)+" age: "+rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			/* 1
			try {
//				先开后关
				if(rs!=null){
					rs.close();
				}
				if(sm!=null){
					sm.close();
				}
				if(ct!=null){
					ct.close();
				}				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	/******2**************/
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;//使用垃圾回收
			}
			if(sm!=null){
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sm=null;
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ct=null;
			}
			
		}
		
	}

}
