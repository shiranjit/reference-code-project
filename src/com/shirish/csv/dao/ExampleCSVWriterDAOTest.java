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



package com.shirish.csv.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shirish.csv.common.CSVWriterConfig;
import com.shirish.csv.common.ExampleCSVModel;


/**
 * @author shirish
 * @Nov 15, 2015
 *
 */
public class ExampleCSVWriterDAOTest {

    private ExampleCSVWriterDAO writerDAO;
    private List <ExampleCSVModel> dataList;

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @Before
    public void setUp() throws Exception {

        CSVWriterConfig config = new CSVWriterConfig( "writertest.csv", "UTF-8", "" );
        writerDAO = new ExampleCSVWriterDAO( config );
        
        this.dataList = new ArrayList <ExampleCSVModel>();
        
        for(int i=0; i<4;i++){
            ExampleCSVModel model = new ExampleCSVModel();
            model.setName( "same stuff: " + i );
            model.setValue( i );
            model.setComment( " same comment : " +i );
            this.dataList.add( model );
        }
        
        
    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test method for
     * {@link com.shirish.csv.dao.AbstractCSVWriterDAO#writeData(java.util.List)}
     * .
     */
    @Test
    public void testWriteData() {

        try {

            writerDAO.writeData( dataList );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "writer test failed" );
        }

    }

}
