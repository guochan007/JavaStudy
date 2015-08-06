package com.exam.sinuobo;

public class Num10 {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				break;
			case 1:
				System.out.println("one");
				// 这题之所以奇怪 是因为没有写break 所以往后写代码时 遇到case要写break；
			case 2:
				System.out.println("two");
			case 3:
				System.out.println("three");
			}
		}
		System.out.println("done");
	}

}
