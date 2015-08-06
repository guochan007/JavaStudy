package imooc.designPattern.Observer.JDK.weather;

public class ClientTest {
	public static void main(String[] args) {
//		创建天气作为一个目标，被观察者
		ConcreteWeatherSubject subject=new ConcreteWeatherSubject();
//		创建观察者
		ConcreteObserver girl=new ConcreteObserver();
		girl.setObserverName("黄明女友");
		ConcreteObserver mum=new ConcreteObserver();
		mum.setObserverName("黄明妈妈");
		
//		注册观察者
		subject.addObserver(girl);
		subject.addObserver(mum);
		
//		目标更新天气情况
		subject.setContent("晴天");
	}
}
