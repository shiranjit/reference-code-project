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
package com.shirish.caching;

import java.util.Calendar;

/**
 *  
 * 
 * 
 * @author SRANJIT
 * 
 */
public class CachedObject implements Cacheable {

	/*  This variable will be used to determine if the
		object is expired.
	*/
	private java.util.Date dateofExpiration = null;
	private Object identifier = null;
	/*  This contains the real "value".  This is the
	object which needs to be shared.
	*/
	private Object object = null;

	/**
	 * 
	 * @param obj
	 * @param id
	 * @param minutesToLive
	 */
	public CachedObject(Object obj, Object id, int minutesToLive) {
		this.object = obj;
		this.identifier = id;

		// minutesToLive of 0 means it lives onindefinitely.
		if (minutesToLive != 0) {
			dateofExpiration = new java.util.Date();
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(dateofExpiration);
			cal.add(Calendar.MINUTE, minutesToLive);
			dateofExpiration = cal.getTime();
		}
	}

	/**
	 * 
	 */
	public boolean isExpired() {
		// Remember if the minutes to live is zero then it lives forever!
		if (dateofExpiration != null) {
			// date of expiration is compared.
			if (dateofExpiration.before(new java.util.Date())) {
				// @todo TODO log hereCalenda
//				System.out.println(
//					"CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: "
//						+ dateofExpiration.toString()
//						+ " CURRENT TIME: "
//						+ (new java.util.Date()).toString());
				return true;
			}
			else {
				//System.out.println("CachedResultSet.isExpired: not Expired from Cache!");
				return false;
			}
		}
		else {
			// This means it lives forever!
			return false;
		}
	}

	/**
	 * 
	 */
	public Object getIdentifier() {
		return identifier;
	}

	/**
	 * @return
	 */
	public Object getObject() {
		return object;
	}

}
