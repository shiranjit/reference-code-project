/**
 * 
 */
package com.shirish.camelExample;

import org.apache.camel.Exchange;

/**
 * @author shirish
 *
 */
public class MsgProcessor {

	/**
	 * 
	 */
	public MsgProcessor() {
	}

	/**
	 * 
	 * @param exchange
	 */
	public void process(Exchange exchange){

		try {
			System.out.println(ThreadCounterSingleton.getInstance().add());
			System.out.println("Received XML order: " + exchange.getIn().getMandatoryBody());
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(ThreadCounterSingleton.getInstance().sub());
		}
	}
}
