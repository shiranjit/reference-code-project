/**
 * Teeznar Corp
 * All rights reserved
 *
 * 2014
 */
package com.shirish.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
public class TestMap {
    
    
    public void mapTesting(){
	
	Map<String, Integer> intMap = new HashMap<String, Integer>();
	
	String initSt = "AB";
	for (int i = 0; i < 102; i++) {
	    intMap.put(initSt, i);
	    initSt = initSt +initSt;
        }
	
	
	for (Integer val : intMap.values()) {
	    System.out.println(val);
        }
    }

}
