package imooc.designPattern.Observer.weather2;

public class ConcreteObserver implements Observer {

//	观察者名称
	private String observerName;
//	天气内容
	private String weatherContent;
//	提醒内容
	private String remindThing;
	
	
	public void update(WeatherSubject subject) {
		// TODO Auto-generated method stub
		weatherContent=((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
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
