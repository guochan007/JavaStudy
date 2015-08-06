package com.exam.RuanTongDongLi;

//选择法？？
public class Test6 {
	public static void main(String arg[]) {
		int array[] = { 20, 10, 50, 40, 30, 70, 60, 80, 90, 100 };
		int i, j, temp;
		int len = array.length;
		for (i = 0; i < len; i++) {
			for (j = i + 1; j < len; j++) {
				if (array[j] < array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (i = 0; i < len; i++) {
			System.out.println("array[" + i + "]=" + array[i]);
		}
	}
}
