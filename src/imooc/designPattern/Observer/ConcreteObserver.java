package imooc.designPattern.Observer;
//具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
public class ConcreteObserver implements Observer{
//	观察者的状态
	private String observerState;
	
//	将目标对象的状态同步给观察者对象
	public void update(Subject subject) {
		observerState=((ConcreteSubject)subject).getSubjectState();
	}
}
