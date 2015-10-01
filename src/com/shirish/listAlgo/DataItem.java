/**
 * 
 */
package com.shirish.listAlgo;


/**
 * @author shirish
 *
 */
public class DataItem {

    private String dataId;
    private boolean fromSourceOneOnly;
    private boolean fromSourceTwo;
    
    /**
     * 
     */
    public DataItem() {

    }

    
    /**
     * @return the dataId
     */
    public String getDataId() {
    
        return dataId;
    }

    
    /**
     * @param dataId the dataId to set
     */
    public void setDataId( String dataId ) {
    
        this.dataId = dataId;
    }

    
    /**
     * @return the fromSourceOneOnly
     */
    public boolean isFromSourceOneOnly() {
    
        return fromSourceOneOnly;
    }

    
    /**
     * @param fromSourceOneOnly the fromSourceOneOnly to set
     */
    public void setFromSourceOneOnly( boolean fromSourceOneOnly ) {
    
        this.fromSourceOneOnly = fromSourceOneOnly;
    }

    
    /**
     * @return the fromSourceTwo
     */
    public boolean isFromSourceTwo() {
    
        return fromSourceTwo;
    }

    
    /**
     * @param fromSourceTwo the fromSourceTwo to set
     */
    public void setFromSourceTwo( boolean fromSourceTwo ) {
    
        this.fromSourceTwo = fromSourceTwo;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append( "id: " +this.dataId );
        sb.append( "   fromSourceOneOnly: " + this.fromSourceOneOnly  );
        sb.append( "   fromSourceTwo: " + this.fromSourceTwo );
        
        return sb.toString();
        
    }

}
