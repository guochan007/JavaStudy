package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time1 = sdf1.format(new Date());
		String time2 = sdf2.format(new Date());
		System.out.println(time1);
		System.out.println(time2);
	}

}
