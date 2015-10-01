/**
 * 
 */



package com.shirish.amqExample;


/**
 * @author shirish
 *
 */
public class AMQPubApp {

    /**
     * 
     */
    public AMQPubApp() {
    }

    /**
     * @param args
     */
    public static void main( String[] args ) {

        AMQPublisher sub = null;
        try {
            sub = new AMQPublisher();
            sub.helloWorldProducer();

        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
