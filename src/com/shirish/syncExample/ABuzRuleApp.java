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
