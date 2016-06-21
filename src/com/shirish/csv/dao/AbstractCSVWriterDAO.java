


package com.shirish.csv.dao;

import java.util.List;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.common.CSVWriter;
import com.shirish.csv.common.CSVWriterConfig;
import com.shirish.csv.dao.visitor.InterfaceVOAWriterVisitor;
import com.shirish.csv.dao.voa.AbstractVisitableCsvWriteVOA;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:46 PM
 */
public abstract class AbstractCSVWriterDAO <T> {

    private final CSVWriterConfig              cSVWriterConfig;
    private CSVWriter                          csvWriter;
    protected AbstractVisitableCsvWriteVOA <T> abstractVisitableVOA;
    protected InterfaceVOAWriterVisitor        avisitor;


    /**
     * 
     * @param config
     */
    public AbstractCSVWriterDAO(CSVWriterConfig config) {

        this.cSVWriterConfig = config;

    }

    /**
     * 
     * 
     * @return List<AbstractBaseModel>
     * @throws CSVReaderException
     */
    public void writeData( List <T> dataList ) throws CSVReaderException {

        //initialzie the voa and visitor
        initVOAVisitor();
        initVisitableVOA( dataList );
        this.abstractVisitableVOA.accept( this.avisitor );

        List <String> csvData = this.abstractVisitableVOA.getVOList();

        if ( csvData.size() > 0 ) {
            //lets open the file
            this.csvWriter = new CSVWriter( this.cSVWriterConfig.getCsvFileNameWithFullPath(), this.cSVWriterConfig.getCharSet(), this.cSVWriterConfig.getCsvLoggerName() );
            this.csvWriter.fileWriter( csvData );
        }
    }

    /**
     * cSVReaderConfig CSVReaderConfig
     * 
     * @return the cSVReaderConfig
     */
    public CSVWriterConfig getcSVReaderConfig() {

        return cSVWriterConfig;
    }

    /**
     * 
     * 
     * void
     */
    public abstract void initVOAVisitor();

    /**
     * 
     * 
     * void
     */
    public abstract void initVisitableVOA( List <T> dataList );


}
