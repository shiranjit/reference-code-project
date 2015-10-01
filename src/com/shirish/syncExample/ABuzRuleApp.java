/**
 * The MIT License (MIT)
 * Copyright (c) 2015 Shirish Ranjit
 * 
 */
package com.shirish.syncExample;


/**
 * @author shirish Ranjit
 * @since 7/9/2015
 */
public class ABuzRuleApp {

    /**
     * 
     */
    public ABuzRuleApp() {

    }

    /**
     * @param args
     */
    public static void main( String[] args ) {
        ABuzRuleThread c1 = new ABuzRuleThread(2l);
        Thread t = new Thread( c1 );
        t.start();
        
        ABuzRuleThread c2 = new ABuzRuleThread(4l);
        Thread t2 = new Thread( c2 );
        t2.start();
        
        ABuzRuleThread c3 = new ABuzRuleThread(8l);
        Thread t3 = new Thread( c3 );
        t3.start();
        
        
        ABuzRuleThread c4 = new ABuzRuleThread(10l);
        Thread t4 = new Thread( c4 );
        t4.start();
        
        try {
            Thread.sleep( Long.MAX_VALUE );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
       
    }

}
