//jdbc 
package com.jdbc;
import java.sql.*;
public class JdbcSqlServer {

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
//			初始化对象
//			加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//			得到连接
			ct=DriverManager.getConnection
			("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=xx","yonghuming","mima");
			ps=ct.prepareStatement("select * from xx");
			ps=ct.prepareStatement("insert into xx values(?,?,?)");
			ps.setInt(1, 100);
			ps.setString(2, "caiwubu");
			
//			增加 删除 修改用executeUpdate()
//			查询用executeQuery
			rs=ps.executeQuery();
//			循环取出
			while(rs.next()){
				String name=rs.getString(2);
				float sal=rs.getFloat(3);
				System.out.println(name);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}

}
