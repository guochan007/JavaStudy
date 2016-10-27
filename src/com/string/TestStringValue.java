//java里没有引用传递，只有值传递
public class TestStringValue {
	String str = new String("good");
	char[] ch = { 'a', 'b', 'c' };

	public static void main(String args[]) {
		TestStringValue ex = new TestStringValue();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
	}

	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'g';
	}
}
