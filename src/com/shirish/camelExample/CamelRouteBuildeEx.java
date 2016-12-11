/**
 * 
 */
package com.shirish.camelExample;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.shirish.amqExample.AMQConstants;

/**
 * @author shirish
 *
 */
public class CamelRouteBuildeEx extends RouteBuilder {

	/**
	 * 
	 */
	public CamelRouteBuildeEx() {
	}

	/**
	 * @param context
	 */
	public CamelRouteBuildeEx(CamelContext context) {
		super(context);
	}

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {

		from(AMQConstants.MQQueue +":" + AMQConstants.VMQueueName
				+"?concurrentConsumers=1")//&destination.consumer.prefetchSize=10")
						.process(new Processor() {
							public void process(Exchange exchange) throws Exception {
								System.out.println(
										"Received XML order: " + exchange.getIn().getMandatoryBody());
								Thread.sleep(1000);
							}
						});

	}

}
