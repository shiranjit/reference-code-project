/**
 * 
 */
package com.shirish.camelExample;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;
import org.apache.log4j.BasicConfigurator;

import com.shirish.amqExample.AMQConstants;

/**
 * @author shirish
 *
 */
public class CamelQueueRouteBeanExample {

	/**
	 * 
	 */
	public CamelQueueRouteBeanExample() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			BasicConfigurator.configure();
			JndiContext jndiContext = new JndiContext();
			jndiContext.bind("msgProcessor", new MsgProcessor());
			// create CamelContext
			CamelContext context = new DefaultCamelContext();

			// connect to embedded ActiveMQ JMS broker
			// ConnectionFactory connectionFactory = new
			// ActiveMQConnectionFactory(AMQConstants.HostURL);
			// context.addComponent(AMQConstants.MQQueue,
			// JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

			ActiveMQComponent activemqcomp = ActiveMQComponent.activeMQComponent(AMQConstants.HostURL);
			JMSConfigBuilder jmsconfig = new JMSConfigBuilder();
			activemqcomp.setConfiguration(jmsconfig.getJmsConfiguration());
			// context.addComponent("testJMS",activemqcomp);
			context.addComponent(AMQConstants.MQQueue, activemqcomp);

			// &consumer.prefetchSize=50
			// destination.consumer.prefetchSize=1
			// acknowledgementModeName=AUTO_ACKNOWLEDGE
			// concurrentConsumers=2&
			// add our route to the CamelContext
			context.addRoutes(new CamelRouteBuilderBean(context));

			System.out.println("Starting up.. ");
			// start the route and let it do its work
			context.start();
			Thread.sleep(Integer.MAX_VALUE);

			// stop the CamelContext
			context.stop();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
