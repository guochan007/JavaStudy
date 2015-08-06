package com.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalendar {

	/**
	 * 测试日期 得到本月第一天，最后一天
	 * 
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=Calendar.getInstance();//获取当前日期
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		System.out.println(cal.getTime());
		System.out.println(sdf.format(cal.getTime()));
		
		cal.add(Calendar.MONTH,1);//月增加1天
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天
		System.out.println(cal.getTime());
		System.out.println(sdf.format(cal.getTime()));
	}

}
