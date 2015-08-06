//jdbc--odbc
package com.jdbc;
import java.sql.*;
public class Test1 {

	/**
	 * 1配置数据源  控制面板 管理工具 数据源 用户dns 添加 sql server 名称mytest 服务器：local或者一个.
	 * 登录方式 
	 * 2在程序中连接数据源  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection ct=null;
		Statement sm=null;
//		PreparedStatement ps=null;
		try {
//			1 加载驱动 把需要的驱动程序加入内存
			Class.forName("sun.jdbc.odbc,JdbcOdbcDriver");
//			2 得到连接 指定连接到哪个数据源
			ct=DriverManager.getConnection("jdbc:odbc:mytest","yonghuming","mima");
//			如果没有密码
//			Connection ct=DriverManager.getConnection("jdbc:odbc:mytest");
//			3 创建statement 或者preparestatement 用来发送sql语句到数据库
			sm=ct.createStatement();
//			4  执行数据库操作
			int i=sm.executeUpdate("insert into xx values('50','保安','北京')");//undate 可执行添加 删除 修改 
//			上面语句返回一个整数 1表示添加成功
//			删除一条记录
			sm.executeUpdate("delete from xx where xxId='50'");
//			修改
			sm.executeUpdate("Update xx set xxLcation='beijing' where xxId='40'");
//			查询      resultset可以理解为一个表结果
			ResultSet rs=sm.executeQuery("select * from xx");
//			rs指向结果集的第一行的前一行
//			取出第一行 第一列
			rs.next();//rs 游标往下走一行
			System.out.println(rs.getInt(1));
			
//			循环取出所有行列
			while(rs.next()){
				int xxId=rs.getInt(1);
				String xxName=rs.getString(2);
				
				System.out.println(xxId+" "+xxName);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
//			关闭资源  后创建的先关闭
			try {
//				为了程序健壮
				if(sm!=null){
					sm.close();					
				}
				if(ct!=null){
					ct.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
