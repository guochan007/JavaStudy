package com.math.calculate;

import java.math.BigDecimal;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

public class CalculateString {

	/**
	 * 已知计算公式的字符串  怎么计算求和呢？
	 * 【皇帝】河南-孤狼(1208178396)  15:42:43
		str.split("+");
		【亲王】济南-Eagle(2558415983)  15:42:48
		先判断有没有运算符，运算符是什么，然后根据运算符拆解
		再用double或者float去转换
		别用int
		
		其实apache有工具的
	 */
	public static void main(String[] args) {
//		t1();
//		t2();
//		t3();
//		t4();
//		t5();
		test();
	}
	
	private static void t1(){
		JexlEngine jexl = new JexlEngine();
		String calculate = "(G1 + G2)/3";
		Expression e =jexl.createExpression(calculate);
		JexlContext context = new MapContext();
		context.set("G1", "2");
		context.set("G2", "2");
		Object res = e.evaluate(context);
		System.out.println(res);//1
	}
	
	private static void t2(){
//		String str="2*(1+2)-4/3";//4
		
//		String str="4/3";
		String str="4/3.0";
		JexlEngine jexl = new JexlEngine();
		Expression e =jexl.createExpression(str);
		JexlContext context = new MapContext();
//		Double res = (Double)e.evaluate(context);
		Number res = (Number)e.evaluate(context);
//		Object res = e.evaluate(context);
		System.out.println(res);
	}
	
	private static void t3(){
		String testcontent = "(aaaa+bbbb)/3";
		BigDecimal aa = new BigDecimal(2);
		BigDecimal bb = new BigDecimal(2);
		JexlContext _jexlContext = new MapContext();
		_jexlContext.set("aaaa",aa);
		_jexlContext.set("bbbb",bb);
		JexlEngine _jexlEngine = new JexlEngine();
		Expression _expression = _jexlEngine.createExpression(testcontent);
		Number num = (Number)_expression.evaluate(_jexlContext);
		System.out.println(num);
	} 
	
	private static void t4(){
		String testcontent = "(aaaa+bbbb)/3";
		double aa = 2;
		double bb = 2;
		JexlContext _jexlContext = new MapContext();
		_jexlContext.set("aaaa",aa);
		_jexlContext.set("bbbb",bb);
		JexlEngine _jexlEngine = new JexlEngine();
		Expression _expression = _jexlEngine.createExpression(testcontent);
		Number num = (Number)_expression.evaluate(_jexlContext);
		System.out.println(num);
	} 
	
	private static void t5(){
		System.out.println(7*3+7*2+1*2+1*47+412746*15);
		String str="7*3+7*2+1*2+1*47+412746*15";
		JexlEngine jexl = new JexlEngine();
		Expression e =jexl.createExpression(str);
		JexlContext context = new MapContext();
		Number res = (Number)e.evaluate(context);
		System.out.println(res);
	}
	
	private static void test(){
		String str="6726.9-1907.2-650-2650.73";
		JexlEngine jexl = new JexlEngine();
		Expression e =jexl.createExpression(str);
		JexlContext context = new MapContext();
		Number res = (Number)e.evaluate(context);
		System.out.println(res);//1518.9699999999998  结果正确
	}
}

