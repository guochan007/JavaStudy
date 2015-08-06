package imooc.designPattern.strategy.impl;

import imooc.designPattern.strategy.FlyingStrategy;

public class FlyNoWay implements FlyingStrategy {

	public void performFly() {
		System.out.println("我不会飞行！");
	}

}
