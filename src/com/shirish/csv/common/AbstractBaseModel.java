


package com.shirish.csv.common;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;




/**
 * @author shirish
 * @version 1.0
 * @created 04-Nov-2015 5:13:49 PM
 */
public abstract class AbstractBaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -8791416820530818365L;
    protected StringBuilder   errorMesg        = new StringBuilder();


    public AbstractBaseModel() {

    }

    /**
     * In this method, validation must be performed to check that key elements
     * are not null
     */
    public abstract boolean validate();

    /**
     * add error message
     * 
     * @param msg
     */
    public void addErrorMsg( String msg ) {

        this.errorMesg.append( msg + "\n" );
    }

    /**
     * @return
     */
    public String getErrorMsg() {

        return errorMesg.toString();
    }

    /**
     * 
     */
    public String toString() {

        StringBuilder result = new StringBuilder();
        String newLine = "\n";
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
                    result.append( "\t" );
                    result.append( aMethod.getName() );
                    result.append( ": " );
                    // requires access to private field:
                    try {
                        String invokeRs = String.valueOf( aMethod.invoke( this ) );
                        if ( (null != invokeRs) && invokeRs.contains( newLine ) ) {
                            String[] lines = invokeRs.split( newLine );
                            for ( int i = 1; i < lines.length; i++ ) {
                                result.append( newLine );
                                result.append( "\t" );
                                result.append( lines[i] );
                            }
                        }
                        else {
                            result.append( invokeRs );
                        }
                        result.append( newLine );
                    }
                    catch ( Exception e ) {
                        result.append( e );
                    }
                }
            }
            catch ( Exception ex ) {
                result.append( ex );
            }

        }
        result.append( "}" );
        result.append( newLine );

        return result.toString();

    }
}
