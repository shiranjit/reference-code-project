/**
 * 
 */
package com.shirish.camelExample;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;

import com.shirish.amqExample.AMQConstants;

/**
 * @author shirish
 *
 */
public class CamelExample {

	/**
	 * 
	 */
	public CamelExample() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			BasicConfigurator.configure();
			// create CamelContext
			CamelContext context = new DefaultCamelContext();

			// connect to embedded ActiveMQ JMS broker
			//ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(AMQConstants.HostURL);
			//context.addComponent(AMQConstants.MQQueue, JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			
			ActiveMQComponent activemqcomp =  ActiveMQComponent.activeMQComponent(AMQConstants.HostURL);
			JMSConfigBuilder jmsconfig = new JMSConfigBuilder();
			activemqcomp.setConfiguration(jmsconfig.getJmsConfiguration());
			context.addComponent("testJMS",activemqcomp);
			
			
			//&consumer.prefetchSize=50
			//destination.consumer.prefetchSize=1
			//acknowledgementModeName=AUTO_ACKNOWLEDGE
			//concurrentConsumers=2&
			// add our route to the CamelContext
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() {

					// content-based router
					from("testJMS:"+AMQConstants.MQQueue +":" + AMQConstants.VMQueueName
							+"?concurrentConsumers=10")//+"&consumer.prefetchSize=10")
									.process(new Processor() {
										public void process(Exchange exchange) throws Exception {
											System.out.println(
													"Received XML order: " + exchange.getIn().getMandatoryBody());
											Thread.sleep(1000);
										}
									});

				}
			});

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
