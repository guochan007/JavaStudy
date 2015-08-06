package imooc.designPattern.Observer.weather;

import java.util.ArrayList;
import java.util.List;

//目标对象，它知道观察它的观察者，并提供添加、删除观察者的接口

public class WeatherSubject {
//	定义集合  保存观察者对象
	private List<Observer> observers=new ArrayList<Observer>();
	
//	添加
//	把订阅天气的人添加到订阅者列表中
	public void attach(Observer observer){
		observers.add(observer);
	}
//	删除
//	删除集合中订阅天气的人
	public void detach(Observer observer){
		observers.remove(observer);
	}
//	通知所有的观察者对象
//	通知所有订阅天气的人
//	拉模型
//	protected void notifyObserver(){
//		for(Observer observer:observers){
//			observer.update(this);
//		}
//	}
//	推模型
	protected void notifyObserver(String content){
		for(Observer observer:observers){
			observer.update(content);
		}
	}
}
