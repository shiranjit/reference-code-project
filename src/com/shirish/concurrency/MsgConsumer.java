/**
 * 
 */
package com.shirish.concurrency;

import java.util.Random;

/**
 * @author shirish
 *
 */
public class MsgConsumer implements Runnable {

	private MsgDrop drop;

	/**
	 * 
	 * @param drop
	 */
	public MsgConsumer(MsgDrop drop) {
		this.drop = drop;
	}

	/**
	 * 
	 */
	public void run() {
		Random random = new Random();
		for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}
