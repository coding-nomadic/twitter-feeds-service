package com.tenz.app;

import com.tenz.app.producer.TwitterKafkaProducer;

public class App {
	public static void main(String[] args) {
		System.out.println("Streaming live tweets from twitter....");
		TwitterKafkaProducer producer = new TwitterKafkaProducer();
		producer.run();
	}
}
