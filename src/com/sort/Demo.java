//我得出的冒泡和选择 速度差不多
package com.sort;

import java.util.Calendar;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr1[]={1,6,0,-1,9};
		int len=100000;
		int arr1[]=new int[len];
		for(int i=0;i<len;i++){
//			随机产生一个1-10000的数      random(0-1) 
			int t=(int) Math.random()*10000;
			arr1[i]=t;
		}
		Bubble bubble=new Bubble();	
//		Select select=new Select();
//		打印系统时间
		Calendar cal1=Calendar.getInstance();
		System.out.println(cal1.getTime());
//		select.sort(arr1);
		bubble.sort(arr1);
		Calendar cal2=Calendar.getInstance();
		System.out.println(cal2.getTime());
//		System.out.println(cal2.getTime()-cal1.getTime());//error
		
		/*for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
		*/
	}

}
//冒泡
class Bubble{
	public void sort(int arr[]){
		int temp=0;
//		外层循环 决定一共走几趟 arr.length-1
		for(int i=0;i<arr.length-1;i++){
//			内层循环 开始逐个比较 如果发现前一个数比后一个大 则交换
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
//					换位
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
//选择
class Select{
	public void sort(int arr[]){
//		假设第一个数就是最小
		int temp=0;
		for(int j=0;j<arr.length-1;j++){
			int min=arr[j];
//			下表
			int minIndex=j;
			for(int k=j+1;k<arr.length;k++){
				if(min>arr[k]){
//					修改最小
					min=arr[k];
					minIndex=k;
				}
			}
//			退出for时 就找到这次的最小值
			temp=arr[j];
			arr[j]=arr[minIndex];
			arr[minIndex]=temp;
		}
		
	}
}