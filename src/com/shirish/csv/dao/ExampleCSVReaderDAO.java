/**

The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. 

 */
package com.shirish.csv.dao;

import java.io.BufferedReader;

import com.shirish.csv.common.CSVReaderConfig;
import com.shirish.csv.common.ExampleCSVModel;
import com.shirish.csv.dao.visitor.CsvDefaultAssemblerVisitor;
import com.shirish.csv.dao.voa.ExampleVisitableCsvReaderVOA;


/**
 * @author shirish
 * @Nov 15, 2015
 *
 */
public class ExampleCSVReaderDAO extends AbstractCSVReaderDAO <ExampleCSVModel> {
    
    

    /**
     * 
     * @param config
     */
    public ExampleCSVReaderDAO(CSVReaderConfig config) {
        
        super( config );
        
    }

    @Override
    public void initVOAVisitor() {

        this.avisitor = new CsvDefaultAssemblerVisitor();
        
    }

    @Override
    public void initVisitableVOA( BufferedReader buffRead ) {

       this.abstractVisitableVOA = new ExampleVisitableCsvReaderVOA( buffRead );
        
    }

}
