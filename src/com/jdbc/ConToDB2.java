//jdbc 连接db2
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConToDB2 {

	public static void main(String[] args) {

		Connection ct=null;
		Statement sm=null;
		ResultSet rs=null;
		try {
//			加载驱动
			Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
			String url = "jdbc:db2://localhost:50000/DB2TEST";
			String userName="USER1";
			String password="000000";
//			String userName="Administrator";
//			String password=";'\\";
			
//			得到连接  数据源
			ct=DriverManager.getConnection
			(url,userName,password);
//			创建对象 statemenyt preparedstatement callablestatement
			sm=ct.createStatement();
//			通过statement向数据库发出sql指令
//			executeUpdate执行dml语句insert update delete
//			sm.executeUpdate
//			("insert into Administrator.USERS (name,age) values('大明',7)");
//			sm.executeUpdate
//			("update Administrator.users set age=age+10 where name='大明'");
			sm.executeUpdate
			("delete Administrator.users where id=8 ");
			
//			rs=sm.executeQuery("select * from USERS");
			rs=sm.executeQuery("select * from Administrator.USERS");
			while(rs.next()){
				System.out.println("ID: "+rs.getString(1)+" name: "+rs.getString("name")+" age: "+rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/* 1*/
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
				e.printStackTrace();
			}
			
	/******2**************/
			/*
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs=null;//使用垃圾回收
			}
			if(sm!=null){
				try {
					sm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sm=null;
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ct=null;
			}
			*/
		}
		
	}

}
