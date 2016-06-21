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
public class ConcApp {

    /**
     * 
     */
    public ConcApp() {

    }

    /**
     * 
     * @param args
     *            void
     */
    public static void main( String[] args ) {

        ThreadGroup tg = new ThreadGroup( "testing threads" );

        ConcExample conce = new ConcExample();

        ConcExThead conc1 = new ConcExThead( tg, "Th1", conce );
        conc1.start();

        ConcExThead conc2 = new ConcExThead( tg, "Th2", conce );
        conc2.start();

        ConcExThead conc3 = new ConcExThead( tg, "Th3", conce );
        conc3.start();

        ConcExThead conc4 = new ConcExThead( tg, "Th4", conce );
        conc4.start();

        ConcExThead conc5 = new ConcExThead( tg, "Th5", conce );
        conc5.start();

        System.out.println("-----------checking active threads");
        boolean listNotEmpty=true;
        
        while(listNotEmpty){
            //System.out.println("--- inside while-- here");
            Thread[] activelist= new Thread[5];
            tg.enumerate( activelist );
            int activeCount = 0;
            for ( int i = 0; i < activelist.length; i++ ) {
                Thread t = activelist[i];
                if(t!=null && t.isAlive()){
                    //System.out.println("Active Thread: " + t.getName());
                    activeCount++;
                }
            }
            if (activeCount==0){
                System.out.println(" --- List is empty the size is: " + activelist.length);
                listNotEmpty = false;
            }
            else {
                //System.out.println("List is not empty the size is: " + activelist.length);
                try {
                    System.out.println("-------------------Sleep the main thread : 500");
                    Thread.sleep( 500 );
                }
                catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
           // listNotEmpty=false;
        }
        
        if(!listNotEmpty){
            System.out.println("App exiting here.. ");
            System.exit( 0 );
        }
        
//        try {
//            Thread.sleep( Long.MAX_VALUE );
//        }
//        catch ( InterruptedException e ) {
//            e.printStackTrace();
//        }

    }

}
