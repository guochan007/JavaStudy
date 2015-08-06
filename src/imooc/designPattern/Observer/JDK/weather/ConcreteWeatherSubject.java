package imooc.designPattern.Observer.JDK.weather;

import java.util.Observable;
//天气目标具体实现类
public class ConcreteWeatherSubject extends Observable {
//	天气内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
//		通知观察者
		this.setChanged();//必须
//		推
		this.notifyObservers(content);
//		拉
//		this.notifyObservers();
	}
	
}
