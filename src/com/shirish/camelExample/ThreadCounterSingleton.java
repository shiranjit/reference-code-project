/**
 * 
 */
package com.shirish.camelExample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shirish
 *
 */
public enum ThreadCounterSingleton {
	
	ThreadCounter;
	
	private AtomicInteger counter = new AtomicInteger(0);
	
	
	public static ThreadCounterSingleton getInstance(){
		return ThreadCounter;
	}
	
	public synchronized int add(){
		return counter.incrementAndGet();
	}

	public synchronized int sub(){
		return counter.decrementAndGet();
	}

}
