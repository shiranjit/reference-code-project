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
 * @author shirish
 * @Nov 15, 2015
 *
 */
public class ExampleCSVModel extends AbstractBaseModel {

    private static String header = "Name,Value,Comment \n";
    private String name;
    private long value;
    private String comment;
    
    /**
     * 
     */
    public ExampleCSVModel() {

        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.shirish.csv.common.AbstractBaseModel#validate()
     */
    @Override
    public boolean validate() {

        // TODO Auto-generated method stub
        return false;
    }

    
    /**
     * name String
     * @return the name
     */
    public String getName() {
    
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName( String name ) {
    
        this.name = name;
    }

    
    /**
     * value long
     * @return the value
     */
    public long getValue() {
    
        return value;
    }

    
    /**
     * @param value the value to set
     */
    public void setValue( long value ) {
    
        this.value = value;
    }

    
    /**
     * comment String
     * @return the comment
     */
    public String getComment() {
    
        return comment;
    }

    
    /**
     * @param comment the comment to set
     */
    public void setComment( String comment ) {
    
        this.comment = comment;
    }

    
    /**
     * header String
     * @return the header
     */
    public static String getHeader() {
    
        return header;
    }

}
