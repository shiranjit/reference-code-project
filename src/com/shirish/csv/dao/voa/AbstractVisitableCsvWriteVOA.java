


package com.shirish.csv.dao.voa;

import java.util.ArrayList;
import java.util.List;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.dao.visitor.InterfaceVOAWriterVisitor;


/**
 * Value object assembler
 * 
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:52 PM
 */
public abstract class AbstractVisitableCsvWriteVOA<T> {

    protected final List<T> dataList;
    protected List<String> csvFormatedData;


    /**
     * 
     * @param inputData
     */
    public AbstractVisitableCsvWriteVOA(List<T> inputData) {

        this.csvFormatedData = new ArrayList <String>(100);
        this.dataList = inputData;

    }

    /**
     * 
     * @param voaVisitor
     * @throws CSVReaderException
     */
    public void accept( InterfaceVOAWriterVisitor voaVisitor ) throws CSVReaderException {

        voaVisitor.assemble( this );
    }

    /**
     * 
     * 
     * @throws CSVReaderException
     *             void
     */
    public abstract void assembleVO() throws CSVReaderException;


    /**
     * 
     * 
     * @return List
     */
    public List<String> getVOList() {

        return this.csvFormatedData;
    }



}
