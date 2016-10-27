


package com.shirish.csv.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.shirish.csv.common.CSVReader;
import com.shirish.csv.common.CSVReaderConfig;
import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.dao.visitor.InterfaceVOAVisitor;
import com.shirish.csv.dao.voa.AbstractVisitableVOA;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:46 PM
 */
public abstract class AbstractCSVReaderDAO<T>{

    private final CSVReaderConfig cSVReaderConfig;
    protected AbstractVisitableVOA<T>  abstractVisitableVOA;
    protected InterfaceVOAVisitor    avisitor;
    private CSVReader             abstractReader;


    /**
     * 
     * @param config
     */
    public AbstractCSVReaderDAO(CSVReaderConfig config) {

        this.cSVReaderConfig = config;

    }

    /**
     * 
     * 
     * @return List<AbstractBaseModel>
     * @throws CSVReaderException
     */
    public List <T> getData() throws CSVReaderException {
        BufferedReader buffRead=null;
        try {
            //lets open the file
            this.abstractReader = new CSVReader( this.cSVReaderConfig.getCsvFileNameWithFullPath(), this.cSVReaderConfig.getCharSet() );
            buffRead = this.abstractReader.defaultCSVReader();

            //initialzie the voa and visitor
            initVOAVisitor();
            initVisitableVOA( buffRead );
            this.abstractVisitableVOA.accept( this.avisitor );

            return this.abstractVisitableVOA.getVOList();
        }
        catch ( Exception e ) {
            //e.printStackTrace();
            throw new CSVReaderException(e);
        }
        finally{
            if(null!=buffRead){
                try {
                    buffRead.close();
                }
                catch ( IOException e ) {
                    //e.printStackTrace();
                    //TODO: Please log here
                }
            }
        }
    }


    /**
     * cSVReaderConfig CSVReaderConfig
     * 
     * @return the cSVReaderConfig
     */
    public CSVReaderConfig getcSVReaderConfig() {

        return cSVReaderConfig;
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
    public abstract void initVisitableVOA( BufferedReader buffRead );


}
