package com.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoDBCrud {
	private DBCollection dbConnection = null;
	private final String DBName = "test";
	private final String connectionName = "student";
	private DBCursor cur = null;

	@Before
	public void init() {
		dbConnection = MongoDBTools.getConnection(DBName, connectionName);
	}

	@After
	public void destory() {
		if (cur != null) {
			cur.close();
		}
		cur = null;
		dbConnection = null;
	}

	private void queryAndPrintAll() {
		System.out.println("The query result is : ");
		cur = this.dbConnection.find();
		while (cur.hasNext()) {
			System.out.print(cur.next());
		}
		System.out.println();
		System.out.println("The query count is : " + cur.count());
	}

	@Test
	public void add() {
		queryAndPrintAll();
		DBObject user = new BasicDBObject();
		user.put("name", "yangfei");
		user.put("age", 25);
		user.put("sex", "男");
		// 保存数据
		System.out.println(this.dbConnection.save(user).getN());
		System.out.println(this.dbConnection.insert(
				new BasicDBObject("name", "tom")).getN());
		queryAndPrintAll();
	}

	@Test
	public void remove() {
		queryAndPrintAll();
		// 按Id删
		// System.out.println("删除id = 5599eb0adb8b9c36220c7972 :"
		// + dbConnection.remove(
		// new BasicDBObject("_id", new ObjectId(
		// "5599eb0adb8b9c36220c7972"))).getN());
		// System.out.println("删除id = 5599eb0cdb8b9c36220c7973 :"
		// + dbConnection.remove(
		// new BasicDBObject("_id", new ObjectId(
		// "5599eb0cdb8b9c36220c7973"))).getN());
		// 按名字删
		System.out.println("删除yangfei :"
				+ dbConnection.remove(new BasicDBObject("name", "yangfei"))
						.getN());
		System.out.println("删除tom :"
				+ dbConnection.remove(new BasicDBObject("name", "tom")).getN());
		queryAndPrintAll();
	}

	@Test
	public void modify() {
		queryAndPrintAll();
//		System.out.println(dbConnection.update(
//				new BasicDBObject("_id", new ObjectId(
//						"5599f527db8bef44248de5ef")),
//				new BasicDBObject("age", 99)).getN());
//		该语句将age以外的其他字段都删除了
		
		Map<String, Object> user=new HashMap<String, Object>();
		user.put("name", "yangfei");
		user.put("age", 99);
		user.put("sex", "男");
		System.out.println(dbConnection.update(
				new BasicDBObject("_id", new ObjectId(
						"5599f527db8bef44248de5ef")),
				new BasicDBObject(user)).getN());
		queryAndPrintAll();
	}

	@Test
	public void query() {
		System.out.println("find id = 5599f527db8bef44248de5ef: "
				+ dbConnection.find(
						new BasicDBObject("_id", new ObjectId(
								"5599f527db8bef44248de5ef"))).toArray());
	}
}
