package imooc.designPattern.Observer.weather2;

public class Test {

	/**
	 * 区别对待观察者
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		创建目标
		ConcreteWeatherSubject weatherSubject=new ConcreteWeatherSubject();
		
//		创建观察者
		ConcreteObserver observerGirl=new ConcreteObserver();
		observerGirl.setObserverName("黄明女友");
		observerGirl.setRemindThing("下雨，我不出门");
		
		ConcreteObserver observerMum=new ConcreteObserver();
		observerMum.setObserverName("黄明老妈");
		observerMum.setRemindThing("下雨下雪，我不出门");
		
//		注册观察者
		weatherSubject.attach(observerGirl);
		weatherSubject.attach(observerMum);
		
//		目标发布天气
//		weatherSubject.setWeatherContent("下雨");
		weatherSubject.setWeatherContent("下雪");
		
	}

}
