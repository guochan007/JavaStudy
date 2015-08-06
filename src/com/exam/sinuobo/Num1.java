package com.exam.sinuobo;

public class Num1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestForm form=new TestForm();
		form.setId(2);
		int id=2;
		change(id,form);
		System.out.println(id);
		System.out.println(form.getId());
	}

	private static void change(int id,TestForm form){
		id=4;
		form.setId(4);
	}
}
