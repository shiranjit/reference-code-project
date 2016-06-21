


package com.shirish.csv.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:51 PM
 */
public class CSVReader {

    private final String fileNameWithPath;
    /* default is "UTF-8" */
    private final String charSet;


    /**
     * Takes a file name with full path and character set. The default charset is UTF-8
     * @param fileNameWithPath
     */
    public CSVReader(String fileNameWithPath, String charSet) {

        this.fileNameWithPath = fileNameWithPath;
        if ( null == charSet || charSet.trim().equals( "" ) ) {
            this.charSet = "UTF-8";
        }
        else {
            this.charSet = charSet;
        }
    }


    /**
     * Opens a file returns a buffered reader.
     * 
     * @return BufferedReader
     * @throws CSVReaderException
     */
    public BufferedReader defaultCSVReader() throws CSVReaderException {

        BufferedReader buffreader = null;
        try {
            InputStream in = new FileInputStream( new File( fileNameWithPath ) );
            buffreader = new BufferedReader( new InputStreamReader( in, charSet) );
        }
        catch ( Exception e ) {
            throw new CSVReaderException( e.getMessage(), e );
        }

        return buffreader;
    }

}
