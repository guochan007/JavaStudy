package imooc.designPattern.strategy.impl;

import imooc.designPattern.strategy.FlyingStrategy;

public class FlyWithWin implements FlyingStrategy {

	public void performFly() {
		System.out.println("振翅高飞");
	}

}
