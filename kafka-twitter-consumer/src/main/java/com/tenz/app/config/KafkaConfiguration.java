package com.tenz.app.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public enum KafkaConfiguration {

	INSTANCE;
	public KafkaConsumer getKafkaConfig() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", Constants.SERVERS);
		properties.put("key.deserializer", Constants.KEY);
		properties.put("value.deserializer", Constants.KEY);
		properties.put("group.id", Constants.GROUPID);
		KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
		List topics = new ArrayList();
		topics.add(Constants.TOPIC);
		kafkaConsumer.subscribe(topics);
		return kafkaConsumer;
	}
}
