package com.jdbc;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDBTools {
	private static String URL = "localhost";
	private static int port = 27017;
	private static Mongo mongo = null;
	private static DB db = null;
	private static DBCollection conns = null;

	public static DBCollection getConnection(String URL, int port,
			String DBName, String connctionName) {
		try {
			mongo = new Mongo(URL, port);
			db = mongo.getDB(DBName);
			conns = db.getCollection(connctionName);
			return conns;
		} catch (UnknownHostException e) {
			conns = null;
			db = null;
			mongo = null;
			e.printStackTrace();
			return null;
		}
	}

	public static DBCollection getConnection(String DBName, String connctionName) {
		return getConnection(URL, port, DBName, connctionName);
	}
}