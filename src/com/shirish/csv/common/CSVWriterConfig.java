


package com.shirish.csv.common;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:56 PM
 */
public class CSVWriterConfig extends AbstractBaseModel {

    private final String csvFileNameWithFullPath;
    private final String csvLoggerName;
    private final String charSet;


    /**
     * 
     * @param csvFileNameWithFullPath
     * @param charSet
     */
    public CSVWriterConfig(String csvFileNameWithFullPath, String charSet, String csvLoggerName) {

        this.csvFileNameWithFullPath = csvFileNameWithFullPath;
        this.csvLoggerName = csvLoggerName;
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

    /**
     * 
     * 
     * @return String
     */
    public String getCsvLoggerName() {

        return csvLoggerName;
    }



    @Override
    public boolean validate() {

        return ((this.csvFileNameWithFullPath != null && this.csvFileNameWithFullPath.trim() != "") || 
                (this.csvLoggerName != null && this.csvLoggerName.trim() != "") ? true : false);
    }
}
