package imooc.designPattern.Observer.weather2;

public class ConcreteWeatherSubject extends WeatherSubject {

//	目标对象状态
	private String weatherContent;
	
	@Override
	protected void notifyObserver() {
		// TODO Auto-generated method stub
//		循环所有观察者
		for(Observer observer : observers){
//			规则是 黄明女友 下雨才通知她   他老妈 下雨下雪才通知她
			if("下雨".equals(this.getWeatherContent())){
				if("黄明女友".equals(observer.getObserverName())){
					observer.update(this);
				}
				if("黄明老妈".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
			
			if("下雪".equals(this.getWeatherContent())){
				if("黄明老妈".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
		}
	}


	public String getWeatherContent() {
		return weatherContent;
	}


	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		
		this.notifyObserver();
	}

}
