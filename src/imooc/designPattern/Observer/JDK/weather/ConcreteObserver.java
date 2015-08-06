package imooc.designPattern.Observer.JDK.weather;

import java.util.Observable;
import java.util.Observer;
//具体的观察者对象
public class ConcreteObserver implements Observer {

//	观察者名称
	private String observerName;
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
//		推
		System.out.println("推"+observerName+"收到了消息，目标推送的是"+arg);
//		拉
		System.out.println("拉"+observerName+"收到了消息，目标推送的是"+((ConcreteWeatherSubject)o).getContent());
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

}
