package imooc.designPattern.strategy;

import imooc.designPattern.strategy.impl.FlyNoWay;
//大黄鸭
public class BigYellow extends Duck {

	public BigYellow() {
		super();
		super.setFlyingStrategy(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("我身体很大，全身黄黄");
	}

}
