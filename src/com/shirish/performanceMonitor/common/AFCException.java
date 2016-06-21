

package com.shirish.performanceMonitor.common;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class AFCException extends Exception {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -2768389319941264709L;

	// int errorCode = -9999;

	/**
	 * Empty Constructor.
	 */
	public AFCException() {
	}

	/**
	 * Create a new Exception using an error message.
	 * 
	 * @param message
	 */
	public AFCException(String message) {
		super(message);
	}

	/**
	 * Create a new Exception using a throwable
	 * 
	 * @param cause
	 */
	public AFCException(Throwable cause) {
		super(cause);
	}

	/**
	 * Create a new Exception using a message and a throwable.
	 * 
	 * @param message
	 * @param cause
	 */
	public AFCException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create a new Exception using an error code and message.
	 * 
	 * @param errNum
	 * @param errMsg
	 */
	public AFCException(int errNum, String errMsg) {
		super(errNum + " - " + errMsg);
	}

	/**
	 * Create a new error using an error code, message and a throwable.
	 * 
	 * @param errNum
	 * @param errMsg
	 * @param t
	 */
	public AFCException(int errNum, String errMsg, Throwable t) {
		super(errNum + " - " + errMsg, t);
	}

}
