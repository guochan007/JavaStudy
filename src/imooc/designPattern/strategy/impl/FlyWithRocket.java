package imooc.designPattern.strategy.impl;

import imooc.designPattern.strategy.FlyingStrategy;

public class FlyWithRocket implements FlyingStrategy {

	public void performFly() {
		System.out.println("用火箭在太空遨游");
	}

}
