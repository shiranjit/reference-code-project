/**
 * 
 */



package com.shirish.csv.dao.visitor;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.dao.voa.AbstractVisitableVOA;

/**
 * 
 * This is concrete implementation of VOAVisitor. This visitor has knowledge of
 * assembling default type of value object in visitable class. *
 * 
 * @author shirish
 * 
 */
public class CsvDefaultAssemblerVisitor implements InterfaceVOAVisitor {


    /**
     * 
     * 
     * @param visitable
     * @throws CSVReaderException
     *             void
     */
    @Override
    public <T> void assemble( AbstractVisitableVOA <T> visitable ) throws CSVReaderException {

        visitable.assembleVO();

    }


}
