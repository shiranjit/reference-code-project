/**
 * 
 */
package com.shirish.camelExample;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import com.shirish.amqExample.AMQConstants;

/**
 * @author shirish
 *
 */
public class CamelRouteBuilderBean extends RouteBuilder {

	/**
	 * 
	 */
	public CamelRouteBuilderBean() {
	}

	/**
	 * @param context
	 */
	public CamelRouteBuilderBean(CamelContext context) {
		super(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 * 
	 * from(URI) to (URI bean)
	 */
	@Override
	public void configure() throws Exception {

		try {
			from(AMQConstants.MQQueue + ":" + AMQConstants.VMQueueName + "?concurrentConsumers=3000")// &destination.consumer.prefetchSize=10")
					.to("bean:msgProcessor?method=process");

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
