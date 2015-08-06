package imooc.designPattern.singleton;

public class Test {
	public static void main(String[] args) {
//		之前这样写，前提是Singleton类的默认构造方法是public
//		Singleton s1=new Singleton();
//		Singleton s2=new Singleton();
		
//		Singleton s1=Singleton.instance;
//		Singleton s2=Singleton.instance;
//		上面这样写的问题，不安全，不允许外界随便访问singleton的成员变量
		
		//饿汉模式
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		if(s1==s2){
			System.out.println("s1和s2是同一个实例");
		}else{
			System.out.println("s1和s2不是同一个实例");
		}
		
		//懒汉模式
		Singleton2 s3=Singleton2.getInstance();
		Singleton2 s4=Singleton2.getInstance();
		if(s3==s4){
			System.out.println("s3和s4是同一个实例");
		}else{
			System.out.println("S3和s4不是同一个实例");
		}
		
	}
}
