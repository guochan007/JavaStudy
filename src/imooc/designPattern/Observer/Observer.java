package imooc.designPattern.Observer;
//观察者接口，定义一个更新的接口给那些在目标发生变化的时候被通知的对象
public interface Observer {
//	更新的接口，传入目标对象，方便获取相应的目标对象的状态
	public void update(Subject subject);
}
