package imooc.designPattern.proxy1;

public class Client {

	/**
	 * 测试类
	 */
	public static void main(String[] args) {
//		Car car = new Car();
//		car.move();
		
		//使用继承方式
//		Moveable m = new Car2();
//		m.move();
		
		//使用聚合方式实现
//		原来一个类中引用另一个类叫做聚合啊，这么高档！
		Car car = new Car();
		Moveable m = new Car3(car);
		m.move();
	}

}
