/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Shirish Ranjit
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



package com.shirish.csv.dao.voa;

import java.util.List;

import com.shirish.csv.common.CSVReaderException;
import com.shirish.csv.common.ExampleCSVModel;


/**
 * @author shirish
 * @Nov 15, 2015
 *
 */
public class ExampleVisitableCsvWritierVOA extends AbstractVisitableCsvWriteVOA <ExampleCSVModel> {


    public ExampleVisitableCsvWritierVOA(List <ExampleCSVModel> inputData) {

        super( inputData );

    }

    /**
     * 
     */
    @Override
    public void assembleVO() throws CSVReaderException {
        
        //add a header.. if you would like
       
        this.csvFormatedData.add( ExampleCSVModel.getHeader() );
        for ( ExampleCSVModel model : this.dataList ) {
            StringBuilder sb = new StringBuilder();
            sb.append( model.getName() );
            sb.append( "," );
            sb.append( model.getValue() );
            sb.append( "," );
            sb.append( model.getComment() );
            //must have the line break
            sb.append( "\n" );

            this.csvFormatedData.add( sb.toString() );

        }

    }

}
