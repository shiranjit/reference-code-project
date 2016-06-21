


package com.shirish.csv.common;

import java.io.FileWriter;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Class to write to a file or log for given string.
 * 
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:51 PM
 */
public class CSVWriter {

    private final String fileNameWithPath;
    /* default is "UTF-8" */
    private final String charSet;
    private final String loggerName;

    private static Log LOG;

    /**
     * 
     * @param fileNameWithPath
     * @param charSet
     * @param loggerName
     */
    public CSVWriter(String fileNameWithPath, String charSet, String loggerName) {

        this.fileNameWithPath = fileNameWithPath;
        if ( null == charSet || charSet.trim().equals( "" ) ) {
            this.charSet = "UTF-8";
        }
        else {
            this.charSet = charSet;
        }
        this.loggerName = loggerName;
        LOG = LogFactory.getLog(loggerName);
    }

    /**
     * 
     * 
     * @param dataList
     * @throws CSVReaderException
     * void
     */
    public void logWriter(List <String> dataList) throws CSVReaderException {
        
        for ( String row : dataList ) {
            LOG.info( row );
        }
    }

    /**
     * 
     * 
     * @return BufferedReader
     * @throws CSVReaderException
     */
    public void fileWriter(List <String> dataList) throws CSVReaderException {

        FileWriter fwriter=null;
        try {
           fwriter = new FileWriter( fileNameWithPath );
            
            for ( String row : dataList ) {
                fwriter.append( row );
            }
           
        }
        catch ( Exception e ) {
            throw new CSVReaderException( e.getMessage(), e );
        }
        finally{
            try {
                fwriter.flush();
                fwriter.close();
            }
            catch ( Exception e ) {
                
            }
        }

    }
}
