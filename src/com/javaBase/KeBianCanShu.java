package com.javaBase;

//可变参数
public class KeBianCanShu {
	// int(type) followed ... (three dot's) is syntax of a variable argument.
	public int sum(int... numbers) {
		// inside the method a variable argument is similar to an array.
		// number can be treated as if it is declared as int[] numbers;
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	public static void main(String[] args) {
		KeBianCanShu example = new KeBianCanShu();
		// 3 Arguments
		System.out.println(example.sum(1, 4, 5));// 10
		// 4 Arguments
		System.out.println(example.sum(1, 4, 5, 20));// 30
		// 0 Arguments
		System.out.println(example.sum());// 0
	}
}
