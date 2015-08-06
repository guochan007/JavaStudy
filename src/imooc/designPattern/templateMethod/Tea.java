 package imooc.designPattern.templateMethod;

/*
 * 具体子类，提供了制备茶的具体实现
 */
public class Tea extends RefreshBeverage {

	@Override
	protected void brew() {
		System.out.println("用80度的热水浸泡茶叶5分钟");
	}

	@Override
	protected void addCondiments() {
		System.out.println("加入柠檬");
	}

}
