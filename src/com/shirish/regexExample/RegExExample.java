/**
 * 
 */
package com.shirish.regexExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author shirish
 *
 */
public class RegExExample {

    /**
     * 
     */
    public RegExExample() {

    }

    public boolean applyRegEx(String pattern, String data){
        return data.matches(pattern );
    }
    
    public boolean applyPattern(String pattern, String data){
        Pattern ptern = Pattern.compile( pattern );
        Matcher matcher = ptern.matcher(data );
        return matcher.matches();
    }
    
}
