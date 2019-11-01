package com.tenz.app.config;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoConfiguration {

	public void insertIntoMongo(String tweets) throws UnknownHostException {
		Mongo mongo = new Mongo("localhost", 27017);
		// Since 2.10.0, uses MongoClient
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("twitter");
		DBCollection table = db.getCollection("tweets");
		BasicDBObject document = new BasicDBObject();
		document.put("tweets", tweets);
		table.insert(document);
	}
}
