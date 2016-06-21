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
package com.shirish.csv.common;


/**
 * Exceptions from CSV reader framework.
 * 
 * @author shirish
 * @Nov 7, 2015
 *
 */
public class CSVReaderException extends Exception {

    /**
     * 
     * serialVersionUID  long
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public CSVReaderException() {

     
    }

    /**
     * @param message
     */
    public CSVReaderException(String message) {

        super( message );
  
    }

    /**
     * @param cause
     */
    public CSVReaderException(Throwable cause) {

        super( cause );

    }

    /**
     * @param message
     * @param cause
     */
    public CSVReaderException(String message, Throwable cause) {

        super( message, cause );
 
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public CSVReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super( message, cause, enableSuppression, writableStackTrace );
  
    }

}
