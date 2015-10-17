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
package com.shirish.amqExample.encoding;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 */
@XmlRootElement
public class EncodeXmlClass {

    private String  fieldOne;
    private String  fieldTwo;
    private Integer messageNum;


    public String getFieldTwo() {

        return fieldTwo;
    }

    public String getFieldOne() {

        return fieldOne;
    }

    public void setFieldOne( String fieldOne ) {

        this.fieldOne = fieldOne;
    }

    public void setFieldTwo( String fieldTwo ) {

        this.fieldTwo = fieldTwo;
    }

    /**
     * @return the messageNum
     */
    public Integer getMessageNum() {

        return messageNum;
    }


    /**
     * @param messageNum
     *            the messageNum to set
     */
    public void setMessageNum( Integer messageNum ) {

        this.messageNum = messageNum;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {

        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty( "line.separator" );

        result.append( newLine );
        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append( newLine );

        // Class thisClass = this.getClass();
        // determine fields declared in this class only (no fields of
        // superclass)
        Method[] methods = this.getClass().getMethods();
        // print field names paired with their values
        for ( Method aMethod : methods ) {

            try {
                if ( aMethod.getName().equalsIgnoreCase( "getClass" ) ) {

                }
                else if ( aMethod.getName().startsWith( "get" ) || aMethod.getName().startsWith( "is" ) ) {
                    result.append( aMethod.getName() );
                    result.append( ":" );
                    // requires access to private field:
                    try {
                        result.append( aMethod.invoke( this, null ) );
                        result.append( newLine );
                    }
                    catch ( IllegalArgumentException e ) {
                        //TODO Auto-generated catch block
                        result.append( e.getStackTrace() );
                    }
                    catch ( InvocationTargetException e ) {
                        //TODO Auto-generated catch block
                        result.append( e.getStackTrace() );
                    }
                }
            }
            catch ( IllegalAccessException ex ) {
                System.out.println( ex );
            }
        }

        result.append( "}" );
        result.append( newLine );

        return result.toString();
    }
}
