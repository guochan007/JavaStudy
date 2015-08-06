package com.string;


public class TestStringReplace1 {

	public static void main(String[] args) {

		String str="[A01]+[A02]+[A03]";
//		递归
		while(str.indexOf("[")!=-1){
			String index=str.substring(str.indexOf("["), str.indexOf("]")+1);//[A001]
			String jiSuanZhiBiaoZhi="8";
			str=str.replaceAll("\\"+index, jiSuanZhiBiaoZhi);			
		}
		System.out.println("str="+str);
	}
}
