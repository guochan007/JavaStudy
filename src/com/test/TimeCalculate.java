package com.test;

import java.util.Scanner;

public class TimeCalculate {

	/**
	 * 下班时间-上班时间=工作时间
	 */
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in); 
//        System.out.println("请输入你的姓名："); 
//        String name = sc.nextLine(); 
//        System.out.println("请输入你的年龄："); 
//        int age = sc.nextInt(); 
//        System.out.println("请输入你的工资："); 
//        float salary = sc.nextFloat(); 
//        System.out.println("你的信息如下："); 
//        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary); 
        
		Scanner sc = new Scanner(System.in); 
        System.out.println("请输入起始时间：如 6:30"); 
        String timeStart = sc.nextLine(); 
        int colonIndex=timeStart.indexOf(":");
        int timeStartHour=Integer.parseInt(timeStart.substring(0, colonIndex));
        int timeStartMin=Integer.parseInt(timeStart.substring(colonIndex+1));
        System.out.println("请输入结束时间："); 
        String timeEnd = sc.nextLine(); 
        int colonIndex2=timeEnd.indexOf(":");
        int timeEndHour=Integer.parseInt(timeEnd.substring(0, colonIndex2));
        int timeEndMin=Integer.parseInt(timeEnd.substring(colonIndex2+1));
        System.out.println("减去中午休息2小时中间时间为："); 
        int resultMin=0;
        if(timeEndMin>=timeStartMin){
        	resultMin=timeEndMin-timeStartMin;
        }else{
        	resultMin=timeEndMin+60-timeStartMin;
        	timeEndHour--;
        }
        int resultHour=timeEndHour-timeStartHour-2;
        System.out.println(resultHour+"个小时"+resultMin+"分钟"); 
	}

}
