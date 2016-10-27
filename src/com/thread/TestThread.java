/*
start() 和 run()的区别说明
start() : 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
run()   : run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
*/
public class TestThread {

	public static void main(String args[]) {
		Thread t = new Thread() {
			public void run() {
				pong();
			}
		};

//		t.run();//pongping
		t.start();//pingpong
		System.out.print("ping");
	}

	static void pong() {
		System.out.print("pong");
	}

}
