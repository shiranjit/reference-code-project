/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Shirish Ranjit
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.shirish.caching.expiringCache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  
 * The class manages the cache.
 * 
 * @author SRANJIT
 * 
 */
public abstract class CacheManager {
    private static Logger LOGGER = LogManager.getLogger(CacheManager.class);
	private static int milliSecondSweepTime = 300000;
	/* This is the HashMap that contains all objects in the cache. */
	private Map <Object, Cacheable> cacheHashMap = Collections.synchronizedMap(new HashMap <Object, Cacheable>());


	/* This object acts as a semaphore, which protects the HashMap */
	 //private static Object lock = new Object(); 

	public CacheManager(int milliSecondSweepTimeIn) {
		try {

		    milliSecondSweepTime =  milliSecondSweepTimeIn;
		    if(milliSecondSweepTime <=0){
		        //default to 15 min
		        milliSecondSweepTime = 300000;
		    }
			/* Create background thread, which will be responsible for 
			 * purging expired items. 
			 */
			Thread threadCleanerUpper = new Thread(new Runnable() {
				/*  The default time the thread should sleep between scans.  The sleep 
				 *  method takes in a millisecond value so 5000 = 5 Seconds.
				 */

				public void run() {
					try {
						/* Sets up an infinite loop. The thread will continue
						 * looping forever.
						 */
						while (true) {
						    System.out.println( "while this is c-manager" );
							LOGGER.info(
								"ThreadCleanerUpper Scanning ForExpired Objects...");

							/* Get the set of all keys that are
							 * in cache.  These are the unique 
							 * identifiers  
							 */
							Set <Object> keySet = cacheHashMap.keySet();

							/* An iterator is used to move*/
							/* through the Keyset */
							Iterator <Object> keys = keySet.iterator();

							/* Sets up a loop that will iterate through each 
							 * key in the KeySet 
							 */
							while (keys.hasNext()) {
								/* Get the individual key. We need to hold 
								 * on to this key in case it needs to be 
								 * removed 
								 */
								Object key = keys.next();

								/* Get the cacheable object associated with 
								 * the key inside the cache 
								 */
								Cacheable value =
									(Cacheable) cacheHashMap.get(key);

								/* Is the cacheable object expired? */
								if (value.isExpired()) {
									/* Yes it's expired! Remove it from 
									 * the cache 
									 */
								    removeFromCache(key);

									LOGGER.info(
										"ThreadCleanerUpper Running. Found an Expired Object in the Cache.");
								}
							}

							/*
							******************************************************
							***** A LRU (least-recently used) or
								LFU (least-frequently used) *****
							******* would best be inserted here              *****
							******************************************************
							*/

							/* Puts the thread to sleep.
								  Don't need to check it
								  continuously */
							Thread.sleep(milliSecondSweepTime);
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return;
				} /* End run method */
			});
			/* End class definition and close new thread definition */

			// Sets the thread's priority to the minimum value.
			threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);

			// Starts the thread.
			threadCleanerUpper.start();
		}
		catch (Exception e) {
			LOGGER.error("CacheManager.Static Block: " + e.toString(), e);
		}
	} /* End static block */

	
	
	/**
	 * 
	 * @param object
	 */
	protected void putCache(Cacheable object) {
		/* Remember if the HashMap previously contains a mapping for the key, 
		 * the old value will be replaced.  This is valid functioning.
		 */
		cacheHashMap.put(object.getIdentifier(), object);
	}

	/**
	 * 
	 * @param identifier
	 * @return
	 */
	protected Cacheable getCache(Object identifier) {
		Cacheable object;
                   
			object = (Cacheable) cacheHashMap.get(identifier);
  
		if (object == null)
			return null;

		if (object.isExpired()) {
		    removeFromCache(identifier);
			return null;
		}
		else {
			return object;
		}
	}
	
	/**
	 * Remove object form cache.
	 * @param identifier
	 */
	private synchronized void removeFromCache(Object identifier){
	    if (identifier != null ){
	        cacheHashMap.remove(identifier);
	    }
	    
	}

}
