package com.abstractClassAndInterface;

public class TestImp {

	/**
	 * 接口
	 */
	public static void main(String[] args) {
		Computer computer1=new Computer();
		Camera camera1=new Camera();
		Phone phone1=new Phone();
		computer1.useUsb(camera1);
		computer1.useUsb(phone1);
	}

}

interface Usb{
//	声明两个方法
	public void start();
	public void stop();
}

class Camera implements Usb{

	public void start() {
		System.out.println("camera start");
	}

	public void stop() {
		System.out.println("camera stop");
	}
	
}

class Phone implements Usb{

	public void start() {
		System.out.println("phone start");
	}

	public void stop() {
		System.out.println("phone stop");
	}
	
}

class Computer {
	public void useUsb(Usb usb){
		usb.start();
		usb.stop();
	}
}