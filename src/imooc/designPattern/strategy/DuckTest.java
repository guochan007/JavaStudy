package imooc.designPattern.strategy;

public class DuckTest {

	public static void main(String[] args){
		System.out.println("测试鸭子程序");
		System.out.println("************************");
		Duck duck = null;
//		duck = new MallardDuck();
//		duck = new RedheadDuck();
//		duck = new RubberDuck();
		duck = new BigYellow();//其实大黄鸭不会飞也不会叫，父类的叫也得使用策略模式
//		duck = new SpaceDuck();
		
		duck.display();
		duck.quack();
		duck.fly();
		System.out.println("************************");
		System.out.println("测试完毕");
	}

}
