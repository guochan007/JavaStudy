//java中使用ddl语句  create  drop  backup
package com.jdbc;
import java.sql.*;
public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		定义需要的对象
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		
		try {
//			加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//			得到连接
			ct=DriverManager.getConnection
			("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=xx","yonghuming","mima");
			ps=ct.prepareStatement("create database xxx");
			ps=ct.prepareStatement("create table xxx(aa int)");
			ps=ct.prepareStatement("backup database bbb to disk='d:/213.bak'");
			boolean b=ps.execute();
			if(b){
				System.out.println("ok");
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}

}
