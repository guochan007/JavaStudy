//oracle  jdbc 事务
package com.jdbc;

import java.sql.*;

public class JdbcOracleTran {

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
			System.out.println(ct);//oracle.jdbc.driver.T4CConnection@4563f0da
//			把事务设为不自动提交
			ct.setAutoCommit(false);
			sm=ct.createStatement();
			
			/*sm.executeUpdate
			("insert into USER1 values(USER1_SEQ.nextval,'shunping','123','shunping@shohu.com',sysdate,30)");
			*/
			sm.executeUpdate("update user1 set age=age-10 where ID=6");
			sm.executeUpdate("update user1 set age=age-10 where ID=9");
//			提交所有事务 两句话整体提交 任何语句出错 则可以整体回滚
			ct.commit();
			rs=sm.executeQuery("select * from USER1");
//			循环取出
			while(rs.next()){
				System.out.println("ID: "+rs.getString(1)+" name: "+rs.getString("name")+" password: "+rs.getString(3)+" email: "+rs.getString(4)+" data："+rs.getString(5)+" age: "+rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
//			如果sql语句中任何语句出错，则可以整体回滚
			try {
				ct.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{//前面代码即使有错 也会执行
			try {
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
		}
		
	}

}
