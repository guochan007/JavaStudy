package imooc.designPattern.Observer.weather2;
//定义更新接口，给哪些在目标发生改变时被通知的观察者对象调用
public interface Observer {
//	更新接口
	public void update(WeatherSubject subject);
//	设置观察者名称
	public void setObserverName(String observerName);
//	取得观察者名称
	public String getObserverName();
}
