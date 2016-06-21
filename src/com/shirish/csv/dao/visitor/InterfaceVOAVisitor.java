


package com.shirish.csv.dao.visitor;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.dao.voa.AbstractVisitableVOA;


/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:54 PM
 */
public interface InterfaceVOAVisitor {

    /**
     * 
     * 
     * @param <T>
     * @param visitable
     * @throws CSVReaderException
     *             void
     */
    public <T> void assemble( AbstractVisitableVOA<T> visitable ) throws CSVReaderException;

}
