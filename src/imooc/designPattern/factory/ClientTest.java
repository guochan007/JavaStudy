package imooc.designPattern.factory;
//客户端-工程-接口
public class ClientTest {

	public static void main(String[] args){
//		1常规
//		HairInterface left = new LeftHair();
//		left.draw();
//		HairInterface right = new RightHair();
//		rightt.draw();
		
//		2利用工厂
//		HairFactory factory = new HairFactory();
//		HairInterface right =  factory.getHair("right");
//		right.draw();
		
//      3利用反射 根据类名生成对象
//		HairFactory factory = new HairFactory();
//		HairInterface left = factory.getHairByClass("com.sunny.project.LeftHair");
//		left.draw();
		
//		4 由于3的写法需要写那么长的类名，所以可以利用关键字，关键字放到属性文件里
//		HairFactory factory = new HairFactory();
//		HairInterface in = factory.getHairByClassKey("in");
//		in.draw();
		
//		PersonFactory facoty = new MCFctory();
//		Girl girl = facoty.getGirl();
//		girl.drawWomen();
		
		PersonFactory facoty = new HNFactory();
		Boy boy =  facoty.getBoy();
		boy.drawMan();
	}
}
