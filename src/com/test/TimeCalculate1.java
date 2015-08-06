package com.test;

import java.util.Scanner;

public class TimeCalculate1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
        System.out.println("上班时间为 8:30"); 
        String timeStart = "8:30"; 
        int colonIndex=timeStart.indexOf(":");
        int timeStartHour=Integer.parseInt(timeStart.substring(0, colonIndex));
        int timeStartMin=Integer.parseInt(timeStart.substring(colonIndex+1));
        System.out.println("请输入下班时间："); 
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
