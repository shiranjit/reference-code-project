/**
 * 
 */
package com.shirish.camelExample;

import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.component.jms.JmsConfiguration;

/**
 * @author shirish
 *
 */
public class JMSConfigBuilder {

	/**
	 * 
	 */
	public JMSConfigBuilder() {
	}

	/**
	 * 
	 * @return
	 */
	public JmsConfiguration getJmsConfiguration() {
		JmsConfiguration jmsConfiguration = new JmsConfiguration();
		// Once all the messages are sent or received, the client send
		// acknowledgement to ActiveMQ
		jmsConfiguration.setAcknowledgementMode(Session.AUTO_ACKNOWLEDGE);
		jmsConfiguration.setTransacted(false);
		// It will start at 3 parallel consumers
		jmsConfiguration.setConcurrentConsumers(3);
		jmsConfiguration.setConnectionFactory(getPooledConnectionFactory());
		return jmsConfiguration;
	}

	/**
	 * 
	 * @return
	 */
	public PooledConnectionFactory getPooledConnectionFactory() {
		PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
		// A maximum of 10 connections can be opened on high volume of messages
		pooledConnectionFactory.setMaxConnections(10);
		pooledConnectionFactory.setConnectionFactory(getConnectionFactory());
		return pooledConnectionFactory;
	}

	/**
	 * 
	 * @return
	 */
	public ActiveMQConnectionFactory getConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
		//?jms.prefetchPolicy.all=50
	}
}
