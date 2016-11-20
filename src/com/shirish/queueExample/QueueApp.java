/**
 * 
 */
package com.shirish.queueExample;

import java.util.List;

/**
 * @author shirish
 *
 */
public class QueueApp {

	/**
	 * 
	 */
	public QueueApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			DelayedElement e = new DelayedElement(60000, "Item:"+i);
			QueueManager aninst = QueueManager.INSTANCE;
			aninst.queue(e);
			
		}
		
		List<DelayedElement> list = QueueManager.INSTANCE.getAlle();
		
		for (DelayedElement delayedElement : list) {
			System.out.println(delayedElement.getData());
		}
	}

}
