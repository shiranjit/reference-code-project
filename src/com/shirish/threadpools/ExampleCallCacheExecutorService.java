/**
 * 
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
 * 
 */



package com.shirish.threadpools;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author shirish
 * @Feb 28, 2016
 *
 */
public class ExampleCallCacheExecutorService {

	private Logger logger = LogManager.getLogger(ExampleCallCacheExecutorService.class);
    /**
     * 
     */
    public ExampleCallCacheExecutorService() {

    }

    public void startExample(int numrun) {

//        BlockingQueue <Runnable> workQueue = new LinkedBlockingQueue <Runnable>();
//        ThreadPoolExecutor tpe = new ThreadPoolExecutor( 20, 20, 2, TimeUnit.MINUTES, workQueue );
//        tpe.prestartCoreThread();
        
    	logger.info(", Starting the run, "+numrun);
        ExampleExecutorServiceSingleton tpe = ExampleExecutorServiceSingleton.getInstance();

        for ( int i = 0; i < numrun; i++ ) {
            
        	String key = "key-"+i;
        	String indata = RandomStringUtils.randomAlphanumeric(250);
        	ExampleCallCacheRunnable er = new ExampleCallCacheRunnable("t"+i, key, indata);
            tpe.addtoPool( er );

        }

        System.out.println( "Lets check what is going on" );
        //logger.info("before... going to loop");
        
        while ( !tpe.isDone() ) {

        	System.out.println("not done yet: " + tpe.isDone());
            try {
//                System.out.println( "active threads: " + tpe.getActiveCount() );
//                System.out.println( "task counts: " + tpe.getTaskCount() );
//                System.out.println( "queue size: " + tpe.getQueue().size() );
//                System.out.println( "completed task count: " + tpe.getCompletedTaskCount() );
//                System.out.println( "we are waiting for tasks to complete" );
                tpe.printStats();
                
                Thread.sleep(10 );
                
//                if(tpe.getQueue().size()<=0){
//                    System.exit( 0 );
//                }
                
                
            }
            catch ( InterruptedException e ) {
                e.printStackTrace();
            }

        }
        System.out.println("Shutting down the service");
        tpe.shutdown();
        
        //System.exit(1);
    }

}
