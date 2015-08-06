package imooc.designPattern.singleton;
/*
 * 单例模式Singleton
 * 应用场合：有些对象只需要一个就足够了，如古代皇帝、老婆
 * 作用：保证整个应用程序中某个实例有且只有一个
 * 类型：饿汉模式、懒汉模式
 */

//恶汉模式   singleton类加载的时候就早早加载了类的唯一实例instance，饿爬床了
public class Singleton {
	//1.将构造方法私有化，不允许外部直接创建对象
	private Singleton(){		
	}
	
	//2.创建类的唯一实例，使用private static修饰
	private static Singleton instance=new Singleton();
	
//	以前是new一个实例s1，然后s1.instance获取对象的成员变量，而现在s1都没法new出来
	//3.提供一个用于获取实例的方法，供外头的类使用该实例，使用public static修饰
	public static Singleton getInstance(){
		return instance;
	}
	
//	静态变量又叫类变量，静态方法又叫类方法
}
