


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
