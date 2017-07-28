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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shirish
 * @Feb 28, 2016
 *
 */
public enum ExampleExecutorServiceSingleton {

    INSTANCE;

    private final ThreadPoolExecutor tpe;


    /**
     * 
     */
    ExampleExecutorServiceSingleton() {
        BlockingQueue <Runnable> workQueue = new LinkedBlockingQueue <Runnable>();
        tpe = new ThreadPoolExecutor( 20, 20, 2, TimeUnit.MINUTES, workQueue );
        tpe.prestartCoreThread();
    }


    /**
     * 
     * 
     * @return ExampleExecutorServiceSingleton
     */
    public static ExampleExecutorServiceSingleton getInstance() {

        return INSTANCE;
    }

    /**
     * 
     * 
     * @param exec
     *            void
     */
    public synchronized void addtoPool(
                                        Runnable exec )
    {

        tpe.execute( exec );
    }

    /**
     * 
     * 
     * void
     */
    public void printStats() {

        System.out.println( "active threads: " + tpe.getActiveCount() );
        System.out.println( "task counts: " + tpe.getTaskCount() );
        System.out.println( "queue size: " + tpe.getQueue().size() );
        System.out.println( "completed task count: " + tpe.getCompletedTaskCount() );
        System.out.println( "we are waiting for tasks to complete" );
    }

    /**
     * 
     * 
     * void
     */
    public void shutdown() {

        if ( tpe.getQueue().size() <= 0 ) {
            System.out.println( "All the taks complete, the queue is empty" );
            tpe.shutdown();
           // System.exit( 0 );
        }
    }
    
    /**
     * 
     * 
     * void
     */
    public boolean isDone() {

        if ( tpe.getQueue().size() <= 0 ) {
            System.out.println( "All the taks complete, the queue is empty" );
            tpe.shutdown();
            return true;
        }
        else {
        	return false;
        }
    }
}
