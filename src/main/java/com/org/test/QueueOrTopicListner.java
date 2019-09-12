package com.org.test;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//For Queue
/*@MessageDriven(mappedName = "java:jboss/exported/jms/queue/test", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test"),
		@ActivationConfigProperty(propertyName = "RedeliveryInterval", propertyValue = "1"),
		@ActivationConfigProperty(propertyName = "RedeliveryInterval", propertyValue = "60") })*/

//For Topic
@MessageDriven(mappedName = "java:jboss/exported/jms/topic/test", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/topic/test"),
		@ActivationConfigProperty(propertyName = "RedeliveryInterval", propertyValue = "1"),
		@ActivationConfigProperty(propertyName = "RedeliveryInterval", propertyValue = "60") })
public class QueueOrTopicListner  implements MessageListener {

	private static final Logger log = Logger.getLogger(QueueOrTopicListner.class.getName());
	
	public QueueOrTopicListner() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onMessage(Message message) {
		log.info("Start: onMessage");
		log.info("Trying to retrieve Message...");
		log.info("message: "+ message);
		if(message != null) {
			try {
				String receivedMsgStr = ((TextMessage)message).getText();
				log.info("receivedMsgStr: "+ receivedMsgStr);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		log.info("End: onMessage");
	}
}
