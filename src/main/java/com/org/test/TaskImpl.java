package com.org.test;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.Topic;


@Stateless
public class TaskImpl {

	private static final Logger log = Logger.getLogger(TaskImpl.class.getName());
	//@Resource(name = "java:jboss/exported/jms/queue/test")
	@Resource(name = "java:jboss/exported/jms/topic/test")
	Destination destination; //Destination represents both queue and topic, based upon jndi resource
//	Queue destination;
//	Topic destination;

    @Inject
    JMSContext jmsContext;
    
    @PersistenceContext(unitName="edgeCrmPU")
    private EntityManager entityManager;
    
    public void getCrmAccountsFullExport() throws Exception {
        log.info("Start: getCrmAccountsFullExport");
        final List<CrmCommonAccount> accounts = getAccountsForActiveStateCode();
        log.info("Number of accounts in full export: " + accounts.size());
        log.info("End: getCrmAccountsFullExport");
    }

	private List<CrmCommonAccount> getAccountsForActiveStateCode() {
		return entityManager.createNamedQuery("Account.findByStateCodeFormatted", CommonAccount.class)
							.setParameter("stateCodeFormatted", "Active")
							.setMaxResults(10)
							.getResultList();
	}

	public void communicateWithJMSQueue() throws JMSException {
		log.info("destination: "+ destination);
		log.info("jmsContext: "+ jmsContext);
		log.info("Trying to post message into queue/topic...");
		jmsContext.createProducer().send(destination, "Hello...This is a Test Message...!");
		log.info("Message posted successfully...");
		
		//Following code can be used to fetch messages from queue instead of using MessageListener
//		log.info("Trying to retrieve Message...");
//		Message receivedMsg = jmsContext.createConsumer(destination).receiveNoWait();
////	Message receivedMsg = jmsContext.createConsumer(destination).receive(10*1000);
//		log.info("receivedMsg: "+ receivedMsg);
//		if(receivedMsg != null) {
//			String receivedMsgStr = ((TextMessage)receivedMsg).getText();
//			log.info("receivedMsgStr: "+ receivedMsgStr);
//		}
	}
	
}
