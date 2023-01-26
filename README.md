## Kafka-Twitter-Mongo

Reading Data from twitter API on twitter feeds, send message to Kafka topic with producer and consumer stores data in MongoDB

## Kafka-Twitter-Producer

This application configures Kakfa topic and starts reading the twitter feeds API.

As soon as reads data, process to send the payload to Kafka topic which has consumers reading.


## Kafka-Twitter-Consumer

When consumer application receives payload from the topic, it will process and stores (dumbs) in the MongoDB.



