package com.string;

public class TestEquals {

	/**
	 * ==和equals的区别
	 */
	public static void main(String[] args) {
		String a="abc";
		String b="abc";
		if(a==b){
			System.out.println(1);
		}
		if(a.equals(b)){
			System.out.println(2);
		}
		//效果一样
		
		
		
		String s1 = "abc";
        String s2 = s1;
        String s5 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        
        System.out.println("== comparison : " + (s1 == s5));
        System.out.println("== comparison : " + (s1 == s2));
        System.out.println("Using equals method : " + s1.equals(s2));
        System.out.println("== comparison : " + s3 == s4);
        System.out.println("Using equals method : " + s3.equals(s4));
	}

}
