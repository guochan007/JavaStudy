package imooc.designPattern.proxy2;

public class Client {

	/**
	 * 测试类
	 */
	public static void main(String[] args) {
//		先记录日志后记录时间
		Car car = new Car();
		CarTimeProxy ctp = new CarTimeProxy(car);
		CarLogProxy clp = new CarLogProxy(ctp);
		clp.move();
		
//		先记录时间后记录日志
//		Car car = new Car();
//		CarLogProxy clp = new CarLogProxy(car);
//		CarTimeProxy ctp = new CarTimeProxy(clp);
//		ctp.move();
		
//		CarTimeProxy CarLogProxy都是汽车的功能，如果火车、火车也想要这些功能，
//		就得再写火车的这两个方法，这是就需要动态代理
		
	}

}
