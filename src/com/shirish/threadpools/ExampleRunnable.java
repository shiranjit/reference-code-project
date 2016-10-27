/**

The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. 

 */
package com.shirish.threadpools;


/**
 * @author shirish
 * @Feb 28, 2016
 *
 */
public class ExampleRunnable implements Runnable {

    private final String name;
    /**
     * 
     */
    public ExampleRunnable(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        
        try {
            System.out.println( "Started Running runnable: " + name );
            
            long sleeptime = (new Double( 1000 * Math.random() + 1000)).longValue();
            System.out.println( "Running runnable: " + name  + " time: " + sleeptime);
            
            Thread.sleep(sleeptime);
            
        }
        catch ( Exception e ) {
            e.printStackTrace( );
        }

    }

    public String getName() {

        return name;
    }

}
