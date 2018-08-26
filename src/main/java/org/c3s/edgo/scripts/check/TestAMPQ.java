package org.c3s.edgo.scripts.check;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TestAMPQ {

	public static void main(String[] args) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.0.10");
		factory.setPort(5672);
		factory.setUsername("remoteuser");
		factory.setPassword("remoteuser");
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare("hello.topic", BuiltinExchangeType.TOPIC);
		
		int count = 1;
		
		AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
        .expiration("60000")
        .build();
		
		while (count < 5000) {
			System.out.println(count);
			channel.basicPublish("hello.topic", "route-to-all", props, new String("Message #" + count).getBytes());
			count++;
			Thread.sleep(5000);
		}
	}

}
