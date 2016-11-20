/**
 * 
 */
package com.shirish.concurrency;

/**
 * @author shirish
 *
 */
public class MsgDrop {

	// Message sent from producer
	// to consumer.
	private String message;
	// True if consumer should wait
	// for producer to send message,
	// false if producer should wait for
	// consumer to retrieve message.
	private boolean empty = true;

	/**
	 * 
	 */
	public MsgDrop() {
		// TODO Auto-generated constructor stub
	}

	public synchronized String take() {
		// Wait until message is
		// available.
		while (empty) {
			System.out.println("empty - so waiting for the message");
			try {
				wait();
				System.out.println("==waken up in take");
			} catch (InterruptedException e) {
				System.out.println(" take wait interrupted - " + e.getLocalizedMessage());
			}
		}
		// Toggle status.
		empty = true;
		// Notify producer that
		// status has changed.
		System.out.println("==notifiy all called from take");
		notifyAll();
		return message;
	}

	public synchronized void put(String message) {
		// Wait until message has
		// been retrieved.
		while (!empty) {
			System.out.println("not empty to put the message waiting");
			try {
				wait();
				System.out.println("==waken up in put");
			} catch (InterruptedException e) {
				System.out.println(" put wait interrupted - " + e.getLocalizedMessage());
			}
		}
		// Toggle status.
		empty = false;
		// Store message.
		this.message = message;
		// Notify consumer that status
		// has changed.
		System.out.println("==notifiy all called from put");
		notifyAll();
	}
}
