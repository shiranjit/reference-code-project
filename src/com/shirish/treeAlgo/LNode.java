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
