/**
 * 
 */
package com.shirish.queueExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * @author shirish
 *
 */
public enum QueueManager {

	INSTANCE;

	private DelayQueue<DelayedElement> delayedQueue = new DelayQueue<DelayedElement>();

	/**
	 * 
	 * @param e
	 */
	public synchronized void queue(DelayedElement e) {
		this.delayedQueue.put(e);
	}

	/**
	 * 
	 * @return
	 */
	public synchronized List<DelayedElement> getAlle() {
		List<DelayedElement> listE = new ArrayList<DelayedElement>();
		this.delayedQueue.drainTo(listE);
		return listE;
	}
}
