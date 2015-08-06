 package imooc.designPattern.templateMethod;

/*
 * 具体子类，提供了咖啡制备的具体实现
 */
public class Coffee extends RefreshBeverage {
//需要实现抽象基类的所有抽象方法
	
	@Override
	protected void brew() {
		System.out.println("用沸水冲泡咖啡");

	}

	@Override
	protected void addCondiments() {
		System.out.println("加入糖和牛奶");
	}

}
