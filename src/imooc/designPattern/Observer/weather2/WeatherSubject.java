package imooc.designPattern.Observer.weather2;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {
	public List<Observer> observers=new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
//	区别对待观察者
	protected abstract void notifyObserver();
}
