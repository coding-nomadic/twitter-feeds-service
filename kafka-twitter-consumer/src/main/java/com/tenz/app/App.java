package com.tenz.app;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.tenz.app.config.KafkaConfiguration;
import com.tenz.app.config.MongoConfiguration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final MongoConfiguration mongoConfiguration = new MongoConfiguration();
		final KafkaConfiguration kafkaConfiguration = KafkaConfiguration.INSTANCE;
		KafkaConsumer kafkaConsumer = kafkaConfiguration.getKafkaConfig();
		try {
			while (true) {
				ConsumerRecords<Long, String> records = kafkaConsumer.poll(1000);
				for (ConsumerRecord record : records) {
					System.out.println("tweets message : " + record.value());
					mongoConfiguration.insertIntoMongo(record.value().toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			kafkaConsumer.close();
		}
	}
}
