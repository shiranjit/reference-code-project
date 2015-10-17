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

package com.shirish.regexExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author shirish
 *
 */
public class TestRegExExample {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

    }

   // @Test
    public void test() {
//
//        File errorfile = new File("resources/testerror");
//        if(!errorfile.exists()){
//            System.err.println(" file not found " + errorfile.getAbsolutePath());
//        }
//        
        //String pattern = "(?!header\\b)\\b\\w+";
        String pattern = "header";
        System.out.println("pattern: " + pattern);
        try {
            RegExExample regex = new RegExExample();
            
            BufferedReader reader = new BufferedReader( new FileReader( "resources/testerror" ) );

            String line = null;

            while ( (line = reader.readLine()) != null ) {
                boolean istherepattern = regex.applyPattern( pattern, line );
                System.out.println("pattern there " + istherepattern);
//                if(regex.applyRegEx( pattern, line ));
//                    System.out.println(line);
            }
        }
        catch ( Exception e ) {
         
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testtwo(){
        String pattern = "[header]";
        System.out.println("pattern: " + pattern);
        try {
            String line = "----------------header------------------------";
            System.out.println(line);
            RegExExample regex = new RegExExample();
            boolean istherepattern = regex.applyRegEx( pattern, line );
            System.out.println("pattern there " + istherepattern);
        }
        catch ( Exception e ) {
            
            e.printStackTrace();
        }
    }

}
