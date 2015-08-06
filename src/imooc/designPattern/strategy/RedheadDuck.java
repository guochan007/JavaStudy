package imooc.designPattern.strategy;

import imooc.designPattern.strategy.impl.FlyWithWin;



public class RedheadDuck extends Duck {

	public RedheadDuck(){
		super();
		super.setFlyingStrategy(new FlyWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("我的头是红色的");
	}

}
