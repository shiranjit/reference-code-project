


package com.shirish.csv.dao.voa;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.dao.visitor.InterfaceVOAVisitor;


/**
 * Value object assembler
 * 
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:52 PM
 */
public abstract class AbstractVisitableVOA <T> {

    protected final BufferedReader buffRead;
    protected List <T>             dataList;


    /**
     * 
     * @param buffRead
     */
    public AbstractVisitableVOA(BufferedReader buffRead) {

        this.buffRead = buffRead;
        this.dataList = new ArrayList <T>();

    }


    /**
     * 
     * @param voaVisitor
     * @throws CSVReaderException
     */
    public void accept( InterfaceVOAVisitor voaVisitor ) throws CSVReaderException {

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
    public List <T> getVOList() {

        return this.dataList;
    }



}
