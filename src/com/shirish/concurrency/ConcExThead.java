/**
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
 */



package com.shirish.concurrency;


/**
 * @author shirish
 * @Oct 25, 2015
 *
 */
public class ConcExThead extends Thread {

    private ConcExample cone;


    /**
     * 
     */
    public ConcExThead() {

    }

    /**
     * @param name
     */
    public ConcExThead(String name) {

        super( name );
    }

    public ConcExThead(String name, ConcExample cone) {

        super( name );
        this.cone = cone;
    }


    public ConcExThead(ThreadGroup group, String name, ConcExample cone) {

        super( group, name );
        this.cone = cone;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

        super.run();

        cone.uselockAndOperate();

        System.out.println( "Thread name: " + getName()  + " num: " + cone.getNum());
        
        System.out.println(" trying again");
        
        cone.uselockAndOperate();
        
        System.out.println( "Thread name: " + getName()  + " num: " + cone.getNum());

        try {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        


    }




}
