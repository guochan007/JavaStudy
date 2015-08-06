package com.test;

import java.util.ArrayList;
import java.util.HashSet;

//Java删除ArrayList中的重复元素的2种方法
//方法1：使用HashSet删除ArrayList中重复的元素
//删除重复的元素后，元素的插入顺序就不对了
public class RemoveChongFuInArraryList {
	public static void main(String[] args) {
		// Constructing An ArrayList

		ArrayList<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");

		// Printing listWithDuplicateElements

		System.out.print("ArrayList With Duplicate Elements :");
		System.out.println(listWithDuplicateElements);

		// Constructing HashSet using listWithDuplicateElements
		HashSet<String> set = new HashSet<String>(listWithDuplicateElements);

		// Constructing listWithoutDuplicateElements using set
		ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(
				set);

		// Printing listWithoutDuplicateElements
		System.out.print("ArrayList After Removing Duplicate Elements :");
		System.out.println(listWithoutDuplicateElements);
	}
}
