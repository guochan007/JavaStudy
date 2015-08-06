package imooc.designPattern.Observer.weather;

public class ClientTest {
	public static void main(String[] args) {
//		1 创建目标
		ConcreteWeatherSubject weather=new ConcreteWeatherSubject();
		
//		2 创建观察者
		ConcreteObserver observerGirl=new ConcreteObserver();
		observerGirl.setObserverName("黄明女朋友");
		observerGirl.setRemindThing("可以去约会");
		
		ConcreteObserver observerMum=new ConcreteObserver();
		observerMum.setObserverName("黄明老妈");
		observerMum.setRemindThing("可以去逛街");
		
//		3添加观察者
		weather.attach(observerGirl);
		weather.attach(observerMum);
		
//		4目标发布天气
		weather.setWeatherContent("明天晴天");
	}
}
