//测试sqlhelper
package com.jdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import org.junit.Test;

public class TestSqlHelper {
	@Test //告诉程序 这个可以用来单元测试
	public void testsqlhelper(){
//		System.out.println("ok");
		String sql="insert into user1 values"+
		"(USER1_SEQ.nextval,?,?,?,sysdate,?)";//自增长
	
		String parameters[]={"xiaohong2","133","xiaohong@126.com","40"};
		SqlHelper.executeUpdate(sql,parameters);
	}
	
	@Test
	public void testsqlhelper2(){
		String sql1="update user1 set age=age+10 where name=?";
		String sql2="update user1 set age=age+10 where name=?";
		String sqls[]={sql1,sql2};
		String sql1_paras[]={"xiaohong"};
		String sql2_paras[]={"xiaohong2"};
		String parameters [][]={sql1_paras,sql2_paras};
		
		SqlHelper.executeUpdate2(sqls, parameters);
	}
	
	@Test
	public void testsqlhelper3() throws Exception{
		String sql="select * from user1";
		ResultSet rs=null;
		try {
			rs=SqlHelper.executeQuery(sql, null);
			System.out.println(rs);
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
//			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());//给ps生成get方法  反向引用
			System.out.println(SqlHelper.getRs());//测试sqlhelper.getrs和rs是不是一回事
			SqlHelper.close(SqlHelper.getRs(), SqlHelper.getPs(), SqlHelper.getCt());
		}
				
	}
	
	@Test
	public void testsqlhelper4(){
		try {
			String sql="{call pro0(?,?)}";
			String parameters[]={"55","nimei"};
			SqlHelper.callPro0(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public void testsql5(){
		System.out.println(oracle.jdbc.OracleTypes.CURSOR);
	}
	
	public void testsql6(){
		ResultSet rs=null;
		try {
			String sql="{call pro2(?,?)}";
			String []in={"10"};
			Integer []out={oracle.jdbc.OracleTypes.CURSOR};
			CallableStatement cs= SqlHelper.callPro2(sql, in, out);
			rs=(ResultSet)cs.getObject(2);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getCs(), SqlHelper.getCt());
		}
	}
}
