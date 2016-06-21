package com.shirish.performanceMonitor.common;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class AFCInvalidInputException extends AFCException {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1298611125595261338L;
	private String objectName;

	/**
	 * Constructor that takes an error message as an argument.
	 * 
	 * @param message
	 *            Reason for this exception.
	 */
	public AFCInvalidInputException(String message) {
		// Constructor that takes an error message
		// as an argument. Invokes the superclass
		// constructor with the same arguments.
		// Sets the error code to default.
		super(message);
	}

	/**
	 * Default Constructor.
	 */
	public AFCInvalidInputException() {
		// Default Constructor. Invokes the
		// superclass constructor with the same
		// arguments. Sets the error code to
		// default.
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            Cause of this Exception
	 * @param throwable
	 *            The underlying exception that is wrapped by this exception.
	 */
	public AFCInvalidInputException(String message, Throwable throwable) {
		// Constructs a new exception with the
		// specified detail message and cause.
		// Invokes the superclass constructor with
		// the same arguments. Sets the error code
		// to default.

		super(message, throwable);
	}

	public AFCInvalidInputException(int errNum, String message,
			Throwable throwable) {
		// Constructs a new exception with the
		// specified detail message and cause.
		// Invokes the superclass constructor with
		// the same arguments. Sets the error code
		// to default.

		super(errNum + " - " + message, throwable);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of (cause==null ? null : cause.toString()) (which typically contains the
	 * class and detail message of cause). This constructor is useful for
	 * exceptions that are little more than wrappers for other throwables (for
	 * example, PrivilegedActionException).
	 * 
	 * @param throwable
	 *            cause - the cause (which is saved for later retrieval by the
	 *            Throwable.getCause() method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 */
	public AFCInvalidInputException(Throwable throwable) {
		// Constructs a new exception with the
		// specified cause and a detail message of
		// (cause==null ? null : cause.toString()).
		// Invokes the super class constructor
		// with the same arguments. Sets the error
		// code to default.
		super(throwable);

	}

	/**
	 * Constructor taking the error code as the argument.
	 * 
	 * @param inErrorCode
	 *            Error code for this exception.
	 */
	public AFCInvalidInputException(int inErrorCode) {
		// Constructor taking the error code as
		// the argument. Invokes super() and then
		// sets the error code to the specified
		// value.
		// super(inErrorCode);
	}

	/**
	 * Creates a new instance of the object.
	 * 
	 * @param errorCodeWkflInvalidParam
	 * @param string
	 */
	public AFCInvalidInputException(int errorCode, String message) {
		super(errorCode + " - " + message);
	}

	/**
	 * Name of the object on which the method was invoked.
	 */
	public String getObjectName() {
		// Name of the object on which the method
		// was invoked. Returns the value at 0th
		// index of the replacementList attribute.

		return objectName;
	}

	/**
	 * Name of the object on which the method was invoked.
	 * 
	 * @param newVal
	 */
	public void setObjectName(String newVal) {
		// Name of the object on which the method
		// was invoked. Adds the passed value to
		// the 0th index of the replacementList
		// attribute.
		objectName = newVal;
	}

}