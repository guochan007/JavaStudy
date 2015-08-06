package imooc.designPattern.strategy;

import imooc.designPattern.strategy.impl.FlyNoWay;
//橡胶鸭
public class RubberDuck extends Duck {

	public RubberDuck() {
		super();
		super.setFlyingStrategy(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("我全身发黄，嘴巴很红");
	}
	
//	叫声和父类不一样，需要重载
	public void quack(){
		System.out.println("嘎~嘎~嘎~");
	}

}
