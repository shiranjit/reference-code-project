/**
 * 
 */
package com.shirish.treeAlgo;


/**
 * @author shirish
 *
 */
public class LNode {

    private final String value;
    private LNode leftNode;
    private LNode rightNode;
    
    /**
     * 
     */
    public LNode(String input) {
        this.value = input;
    }

    
    /**
     * @return the leftNode
     */
    public LNode getLeftNode() {
    
        return leftNode;
    }

    
    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode( LNode leftNode ) {
    
        this.leftNode = leftNode;
    }

    
    /**
     * @return the rightNode
     */
    public LNode getRightNode() {
    
        return rightNode;
    }

    
    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode( LNode rightNode ) {
    
        this.rightNode = rightNode;
    }

    
    /**
     * @return the value
     */
    public String getValue() {
    
        return value;
    }

}
