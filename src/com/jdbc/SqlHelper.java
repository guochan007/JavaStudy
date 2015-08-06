//oracle  jdbc sqlHelper 工具类
package com.jdbc;

import java.io.*;
import java.sql.*;
import java.util.Properties;

//import javax.management.RuntimeErrorException;



public class SqlHelper {
//		定义资源变量           无并发时 或访问量不大时设为static   有并发时 访问数据库很频繁不设为static 因为static只能允许一个人连上
	private static Connection ct=null;		
	private static Statement sm=null;
	private static PreparedStatement ps=null;//防止sql注入漏洞
	private static ResultSet rs=null;		
	private static CallableStatement cs=null;
	
	public static ResultSet getRs() {
		return rs;
	}
	public static Connection getCt() {
		return ct;
	}
	public static PreparedStatement getPs() {
		return ps;
	}
	public static CallableStatement getCs() {
        return cs;
    }
//		连接数据库参数
	private static String url="";
	private static String username="";
	private static String driver="";
	private static String password="";
	
	private static Properties pp=null;
	private static FileInputStream fis=null;
//			加载驱动 只需要一次 用静态代码块
	static{
		try {
//				从dbinfo.properties文件中读取配置信息
			fis=new FileInputStream("dbinfo.properties");//放在工程项目下
			pp=new Properties();
			pp.load(fis);
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			driver=pp.getProperty("driver");
			password=pp.getProperty("password");
			
//			Class.forName("driver");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				fis.close();					
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			fis=null;
		}			
	}
//		得到连接  数据源		
	public static Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	}
	
//		一个update delete insert     
//		sql格式 update 表名 set 字段名=？ where 字段=？   parameters ("abc",23)
	public static void executeUpdate(String sql,String [] parameters){
//			创建ps
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
//				给？赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]); //第一个问号
				}
			}
//				执行
			ps.executeUpdate();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs, ps, ct);
		}
	}
//		如果有多个sql语句时要考虑使用事务
	public static void executeUpdate2(String sql[],String [][] parameters){
		try {
			ct=getConnection();
//				因为用户传入的sql是多个
			ct.setAutoCommit(false);
			for(int i=0;i<sql.length;i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql[i]);					
					for(int j=0;j<parameters[i].length;j++){
						ps.setString(j+1,parameters[i][j]);
					}
				}
				ps.executeUpdate();
			}
//			int i=9/0;
			ct.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				ct.rollback();//回滚
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs, ps, ct);
		}
	}
//		统一的select 有的是将resultset设为arraylist
	public static ResultSet executeQuery(String sql,String []parameters){
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);	
			if(parameters!=null && !parameters.equals("")){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
//			close(rs, ps, ct);
		}
		return rs;
	}
//		分页问题
	public static ResultSet executeQuery2(){
		return null;
	}
//		调用存储过程{call 过程(?,?,?}
/**/		//视频中这样写无返回值
	public static void callPro0(String sql,String []parameters){
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
//				给？号赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1, parameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,cs,ct);
		}
	}
	
	
	//*************callPro1存储过程函数1*************    
    public static CallableStatement callPro1(String sql,String[] parameters)
    {
        try{
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if(parameters!=null){
                for(int i=0;i<parameters.length;i++){
                 cs.setObject(i+1,parameters[i]);
                }
            }    
            cs.execute();
        }
        catch(Exception e) { 
        	e.printStackTrace();
        	throw new RuntimeException(e.getMessage());
        	}
        finally{ 
        	close(rs,cs,ct);
        	}
        return cs;
    }
	    
	//*******************callpro2存储过程2********输入输出参数****************
	public static CallableStatement callPro2(String sql,String[] inparameters,
	Integer[] outparameters)
	{
	    try
	    {
	        ct = getConnection();
	        cs = ct.prepareCall(sql);
	        if(inparameters!=null)
	        {
	            for(int i=0;i<inparameters.length;i++)
	            {
	                cs.setObject(i+1,inparameters[i]);
	            }
	        }
	    //cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
//	        给out参数赋值
	        if(outparameters!=null) 
	        {
	            for(int i=0;i<outparameters.length;i++)
	            {
	                cs.registerOutParameter(inparameters.length+1+i,outparameters[i]);
	            }
	        }
	        cs.execute();
	    }
	    catch(Exception e) {
	        e.printStackTrace(); 
	        throw new RuntimeException(e.getMessage());
	    }
	    finally
	    {
	    	//close(rs,cs,ct);//不需要关闭
	    }
	    return cs;
	}
		
//		关闭资源函数
		/*public static void close(ResultSet rs,Statement ps,Connection ct){
			try {
				if(ps!=null){
					ps.close();
				}
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
		}*/
	
	public static void close(ResultSet rs,Statement ps,Connection ct) {
        //关闭资源(先开后关)
        if(rs!=null) {
            try {
                rs.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            rs=null; 
        }
        if(ps!=null) {
            try {
                ps.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            ps=null;
        }
        if(null!=ct) {
            try {
                ct.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            ct=null;
        }
    }
}
