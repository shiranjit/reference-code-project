/**
 * 
 */
package com.shirish.concurrency;

/**
 * @author shirish
 *
 */
public class MsgPubConExApp {

	/**
	 * 
	 */
	public MsgPubConExApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MsgDrop drop = new MsgDrop();
		(new Thread(new MsgProducer(drop))).start();
		(new Thread(new MsgConsumer(drop))).start();
		(new Thread(new MsgProducer(drop))).start();
		(new Thread(new MsgConsumer(drop))).start();
	}
}
