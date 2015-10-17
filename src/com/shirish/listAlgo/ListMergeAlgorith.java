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

package com.shirish.listAlgo;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


/**
 * @author shirish
 *
 */
public class ListMergeAlgorith {

    /**
     * 
     */
    public ListMergeAlgorith() {

    }

    
    /**
     * Merge two lists. 
     * First go through the list and check the hashmap. If there is data in Hashmap mark the object as there one from other source.
     * 
     * Now iterate thourgh the hashmap and pick the data that is not marked as in the list. Add the data to the list to create a 
     * single list for processing. 
     * 
     * @param sourceOneHash
     * @param sourceTwo
     * @return
     */
    public List<DataItem> mergeLists(HashMap <String, DataItem> sourceOneHash, List <DataItem> sourceTwo){
        
        /*
         * check the hashmap if the id exist. If the id exist mark the data in hashmap that it 
         * is in the list too. 
         * 
         */
        for ( DataItem dataItem : sourceTwo ) {
            DataItem dataI = sourceOneHash.get( dataItem.getDataId() );
            if(dataI!=null){
                dataI.setFromSourceTwo( true );
            }
        }
        
        /*
         * Get the data that is not in the list and only in the hashmap and add to the list.
         */
        Set <String> keyset = sourceOneHash.keySet();
        for ( String key : keyset ) {
            DataItem di = sourceOneHash.get( key );
            if (!di.isFromSourceTwo()){
                di.setFromSourceOneOnly( true );
                sourceTwo.add( di );
            }
        }
        
        return sourceTwo;
        
    }
    
    
}
