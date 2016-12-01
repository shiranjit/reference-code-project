/**
 * 
 */
package com.shirish.camelExample;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
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
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(AMQConstants.HostURL);
			context.addComponent("testjms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

			// add our route to the CamelContext
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() {

					// content-based router
					from("testjms:topic:" + AMQConstants.QueueName).process(new Processor() {
						public void process(Exchange exchange) throws Exception {
							System.out.println("Received XML order: " + exchange.getIn().getMandatoryBody());
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
