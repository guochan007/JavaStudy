package com.string;

public class TestStringReplace {

	public static void main(String[] args) {

		String str="abc";
		System.out.println(str);
		
		str.replaceAll("a","d");
		System.out.println(str);
		
		str=str.replaceAll("a","d");
		System.out.println(str);
		
		String str1="[A030101]";
		str1=str1.replaceAll("[A030101]","");
		System.out.println("str1="+str1);
		
		String str2="[A030101]";
//		str2=str2.replaceAll("u005BA030101]","");
		str2=str2.replaceAll("\\[A030101]","");
//		str2=str2.replaceAll("\\[A030101\\]","");
		System.out.println("str2="+str2);
		
		String sName = "Java转义字符(补遗)";  
//		sName = sName.replaceFirst("(补遗)","");  
		sName = sName.replaceFirst("\\(补遗\\)","");  
		System.out.println(sName);  
		
		String str3="[A030101";
//		str3=str3.replaceAll("u005BA030101","");
		str3=str3.replaceAll("\\[A030101","");
		System.out.println("str3="+str3);
	}
}
