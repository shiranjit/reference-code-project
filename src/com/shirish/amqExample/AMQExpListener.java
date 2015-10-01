/**
 * 
 */
package com.shirish.amqExample;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;


/**
 * @author shirish
 *
 */
public class AMQExpListener implements ExceptionListener {

    /**
     * 
     */
    public AMQExpListener() {

        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see javax.jms.ExceptionListener#onException(javax.jms.JMSException)
     */
    @Override
    public void onException( JMSException arg0 ) {
        System.out.println("JMS Exception occured.  Shutting down client.");

    }
}
