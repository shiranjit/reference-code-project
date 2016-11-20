/**
 * 
 */
package com.shirish.queueExample;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author shirish
 *
 */
public class DelayedElement implements Delayed {

	private Object data;
	private TimeUnit timeU = TimeUnit.MILLISECONDS;
	private long delaytime = 0;

	/**
	 * 
	 */
	public DelayedElement(long delayperiod, Object indata) {
		this.delaytime = delayperiod;
		this.data = indata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Delayed o) {
		if (this.equals(o))
			return 0;
		else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
			return 1;
		} else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
			return -1;
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		return this.timeU.convert(delaytime, unit);

	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

}
