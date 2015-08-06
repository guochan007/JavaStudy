package com.jdbc;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDBTest {
	public static void main(String[] args) {
		Mongo mongo = null;
		try {
			// 创建一个Mongo实例
			mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("The Database names are : "
				+ mongo.getDatabaseNames());
		System.out.println("The Database diver version is : "
				+ mongo.getVersion());
		// 获取一个数据库
		DB db = mongo.getDB("test");
		System.out.println("The Test connections are : "
				+ db.getCollectionNames());
		// 获取数据库连接 ?表
		DBCollection conns = db.getCollection("student");
		// 获取数据库游标
		DBCursor cur = conns.find();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}
		System.out.println(cur.count());
		System.out.println(cur.getCursorId());
		// 数据库关闭和垃圾回收
		if (cur != null) {
			cur.close();
		}
		cur = null;
		conns = null;
		db = null;
		mongo = null;
		System.gc();
	}
}
