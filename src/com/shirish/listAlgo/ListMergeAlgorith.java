/**
 * 
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
