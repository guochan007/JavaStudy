package com.dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//测试优先级队列使用方法
public class PriorityQueueTest {
	private String name;
	private int population;

	public PriorityQueueTest(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return this.name;
	}

	public int getPopulation() {
		return this.population;
	}

	public String toString() {
		return getName() + " - " + getPopulation();
	}

	public static void main(String args[]) {
		Comparator<PriorityQueueTest> OrderIsdn = new Comparator<PriorityQueueTest>() {
//			定义队排序规则
			public int compare(PriorityQueueTest o1, PriorityQueueTest o2) {
				int numbera = o1.getPopulation();
				int numberb = o2.getPopulation();
				if (numberb > numbera) {
					return 1;
				} else if (numberb < numbera) {
					return -1;
				} else {
					return 0;
				}
			}

		};
		Queue<PriorityQueueTest> priorityQueue = new PriorityQueue<PriorityQueueTest>(11, OrderIsdn);

		PriorityQueueTest t1 = new PriorityQueueTest("t1", 1);
		PriorityQueueTest t2 = new PriorityQueueTest("t2", 2);
		PriorityQueueTest t3 = new PriorityQueueTest("t3", 3);
		PriorityQueueTest t4 = new PriorityQueueTest("t4", 4);
		priorityQueue.add(t3);
		priorityQueue.add(t1);
		priorityQueue.add(t4);
		priorityQueue.add(t2);
		
		
//		返回队头
//		System.out.println(priorityQueue.peek().toString());
		
        //集合方式遍历，元素不会被移除 
        for (PriorityQueueTest i : priorityQueue) { 
            System.out.println(i.name+" "+i.population); 
        }
//        观察发现，队头数字是最大的，下面的数字没有排序，而是和add的顺序有关，但也并不是和add的顺序一一对应
		System.out.println("===============");
		
		priorityQueue.remove();
		
		PriorityQueueTest t5 = new PriorityQueueTest("t5", -2);
		priorityQueue.add(t5);
		for (PriorityQueueTest i : priorityQueue) { 
			System.out.println(i.name+" "+i.population); 
		}
		
	}
}









