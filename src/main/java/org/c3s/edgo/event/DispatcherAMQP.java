package org.c3s.edgo.event;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DispatcherAMQP {

	private static String exchange = "edgo.topic"; 
	private static byte[] message = "update".getBytes(); 
	
	private static DispatcherAMQP instance = new DispatcherAMQP();
	
	public static DispatcherAMQP getInstance() {
		return instance;
	}
	
	private AMQP.BasicProperties props;
	private Channel channel;
	
	private DispatcherAMQP() {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.0.10");
		factory.setPort(5672);
		factory.setUsername("remoteuser");
		factory.setPassword("remoteuser");
		
		try {
		
		Connection connection = factory.newConnection();
		
		channel = connection.createChannel();
		
		channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
		
		props = new AMQP.BasicProperties.Builder()
        .expiration("60000")
        .build();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void fireEvent(String[] tags, String pilotName) {
		try {
			String pilot = pilotName; //URLEncoder.encode(pilotName, "UTF-8");
			for (String tag: tags) {
				channel.basicPublish(exchange, tag + "-" + pilot, props, message);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
