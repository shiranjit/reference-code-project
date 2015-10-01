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
public class ABuzRuleThread implements Runnable {

    private Long sleepNum;
    /**
     * 
     */
    public ABuzRuleThread(Long sleepNumber) {
        this.sleepNum = sleepNumber;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println("thread started for sleep number: " + sleepNum);
        ABuzRuleClass rule = new ABuzRuleClass();
        rule.executeRule( sleepNum );
    }

}
