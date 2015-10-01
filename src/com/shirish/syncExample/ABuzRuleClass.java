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
public class ABuzRuleClass {

    /**
     * 
     */
    public ABuzRuleClass() {

    }
    
    public void executeRule(Long sleepNum){
        
        //synchronized ( ABuzRuleClass.class ) {
            try {
                System.out.println("---- Sleeping --- for " +sleepNum.longValue() + " seconds");
                Thread.sleep( sleepNum *1000 );
            }
            catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println(" done sleeping");
        //}
    }

}
