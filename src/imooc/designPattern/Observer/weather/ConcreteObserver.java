package imooc.designPattern.Observer.weather;
//具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
public class ConcreteObserver implements Observer{
//	观察者的名字，谁收到了天气信息
	private String observerName;
//	天气内容，从目标处获取
	private String weatherContent;
//	提醒的内容，黄明的女朋友提醒约会，他老马提醒出去购物
	private String remindThing;
	
//	将目标对象的状态同步给观察者对象
//	拉模型
	/*
	public void update(WeatherSubject subject) {
//		获取天气内容
		weatherContent=((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"收到了天气情况："+weatherContent+","+remindThing);
	}*/
	
//	推模型
	public void update(String weatherContent) {
//		获取天气内容
		System.out.println(observerName+"收到了天气情况："+weatherContent+","+remindThing);
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
	
}
