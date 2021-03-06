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

package com.shirish.test;

import java.util.ArrayList;

/**
 * Created by shirish on 12/23/14.
 */
public class GenerateHTMLForAOrderedList {
    
    StringBuffer sb = new StringBuffer();
    
    /*
     * 
     <table>
  <tr>
    <th>Month</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td>January</td>
    <td>$100</td>
  </tr>
  <tr>
    <td>February</td>
    <td>$80</td>
  </tr>
</table>
     * 
     */

    public void generateOrderedTable(ArrayList<String> orderedlist){
        sb.append( "<table> \n" );
        int numOfElementsInaRow = 3;

        int numRows = orderedlist.size()/numOfElementsInaRow;
        int isRemain = orderedlist.size()%numOfElementsInaRow;
        if (isRemain>0){
            //this means that we have some in the new line
            numRows++;
        }

        //printing 3 items.
        int startid = 0;
        int endid = numOfElementsInaRow;
        for (int i = 0; i < numRows ; i++) {
            sb.append( "    <tr> \n" );
            for (int j=startid; j<endid; j++){
                System.out.print(orderedlist.get(j));
                sb.append( "        <td>" );
                
                sb.append( orderedlist.get( j ));
                sb.append( "</td> \n" );
                
            }
            sb.append( "    </tr> \n" );
            System.out.println();

            startid = endid;
            endid = startid+numOfElementsInaRow;
            //if have not the full row, then we need to just print the partial row.
            if(endid>orderedlist.size()){
                endid = orderedlist.size();
            }
        }
        sb.append( "</tabe>" );
        
        
        System.out.println(sb.toString());
    }
}
