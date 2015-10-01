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
