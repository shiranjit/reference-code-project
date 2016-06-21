


package com.shirish.csv.common;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:56 PM
 */
public class CSVReaderConfig extends AbstractBaseModel {

    private final String csvFileNameWithFullPath;
    private final String charSet;


    /**
     * 
     * @param csvFileNameWithFullPath
     * @param charSet
     */
    public CSVReaderConfig(String csvFileNameWithFullPath, String charSet) {

        this.csvFileNameWithFullPath = csvFileNameWithFullPath;
        this.charSet = charSet;
    }



    /**
     * csvFileNameWithFullPath String
     * 
     * @return the csvFileNameWithFullPath
     */
    public String getCsvFileNameWithFullPath() {

        return csvFileNameWithFullPath;
    }



    /**
     * charSet String
     * 
     * @return the charSet
     */
    public String getCharSet() {

        return charSet;
    }



    @Override
    public boolean validate() {

        return ((this.csvFileNameWithFullPath != null && this.csvFileNameWithFullPath.trim() != "") ? true : false);
    }

}
