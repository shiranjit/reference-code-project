/**
 * 
 */
package com.shirish.listAlgo;


/**
 * @author shirish
 *
 */
public class SinglyLinkedNode {

    private final String name;
    private final String value;
    
    public SinglyLinkedNode next;
   
    /**
     * 
     * @param name
     * @param value
     */
    public SinglyLinkedNode(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public void addNext(SinglyLinkedNode node){
        this.next = node;
    }
    public SinglyLinkedNode next(){
        return next;
    }

    
    /**
     * @return the name
     */
    public String getName() {
    
        return name;
    }

    
    /**
     * @return the value
     */
    public String getValue() {
    
        return value;
    }
}
