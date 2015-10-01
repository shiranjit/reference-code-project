/**
 * 
 */



package com.shirish.amqExample;


/**
 * @author shirish
 *
 */
public class AMQSubApp {

    /**
     * 
     */
    public AMQSubApp() {

    }

    /**
     * @param args
     */
    public static void main( String[] args ) {

        AMQSubscriber sub = null;
        try {
            sub = new AMQSubscriber();
            sub.helloWorldConsumer();

            Thread.sleep( Integer.MAX_VALUE );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            sub.shutdown();
        }
    }

}
