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
package com.shirish.dateExample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shirish
 * @Nov 18, 2017
 *
 */
public class DateRollExample {

    /**
     * 
     */
    public DateRollExample() {
        
    }
    
    /**
     * 
     * 
     * @param d1
     * @param d2
     * @return
     * boolean
     */
    public boolean dateRoll5Compare(Date d1, Date d2, int numRollDays){
        boolean isD1Over5Day=false;
        
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime( d1 );
        System.out.println( "Entred date 1:  " + format1.format( cal1.getTime()) );
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime( d2 );
       // cal2.roll( Calendar.DAY_OF_YEAR, 6 );
        System.out.println( "Entered date 2 : " + format1.format( cal2.getTime()) );
        
        for ( int i = 0; i < numRollDays; i++ ) {
            cal1.roll( Calendar.DAY_OF_YEAR,1 );
            if (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println("Sunday! roll 1 ");
                cal1.roll( Calendar.DAY_OF_YEAR,1 );
            }
            else if (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println("Saturday roll 2.");
                cal1.roll( Calendar.DAY_OF_YEAR,2);
            }
        }
        
        System.out.println( "date 1 after 5 week days roll is -- " + format1.format( cal1.getTime()) );
        
        if(cal2.before( cal1 )){
            isD1Over5Day = true;
            System.out.println( " cal2 is before cal1" );
        }
        else if (cal2.after( cal1 )){
            isD1Over5Day = false;
            System.out.println( " cal2 is after cal1 " );
        }
        else {
            isD1Over5Day = true;
            System.out.println( " cal2 equals cal1 " );
        }
        
        return isD1Over5Day;
        
        
    }

}
