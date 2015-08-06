package imooc.designPattern.adapter;


public class TwoPlugAdapter implements ThreePlugIf {

	private GBTwoPlug plug;
	
	public TwoPlugAdapter(GBTwoPlug plug){
		this.plug = plug;
	}
	
	public void powerWithThree() {
		System.out.println("通过转化");
		plug.powerWithTwo();

	}

}
