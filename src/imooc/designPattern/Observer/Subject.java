package imooc.designPattern.Observer;

import java.util.ArrayList;
import java.util.List;

//目标对象，它知道观察它的观察者，并提供添加、删除观察者的接口

public class Subject {
//	定义集合  保存观察者对象
	private List<Observer> observers=new ArrayList<Observer>();
	
//	添加
	public void attach(Observer observer){
		observers.add(observer);
	}
//	删除
	public void detach(Observer observer){
		observers.remove(observer);
	}
//	通知所有的观察者对象
	protected void notifyObserver(){
		for(Observer observer:observers){
			observer.update(this);
		}
	}
}
