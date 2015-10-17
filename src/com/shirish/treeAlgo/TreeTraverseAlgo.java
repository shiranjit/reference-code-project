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

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author shirish
 *
 */
public class TreeTraverseAlgo {

    private LNode rootNode;


    /**
     * 
     */
    public TreeTraverseAlgo() {

        buildTree();

    }

    private void buildTree() {

        rootNode = new LNode( "1" );

        LNode leftNF = new LNode( "2" );
        LNode rightNF = new LNode( "3" );
        rootNode.setLeftNode( leftNF );
        rootNode.setRightNode( rightNF );

        LNode currentNodeLN = leftNF;
        for ( int i = 0; i < 3; i++ ) {
            LNode leftN = new LNode( "8" + i );
            LNode rightN = new LNode( "9" + i );
            currentNodeLN.setLeftNode( leftN );
            currentNodeLN.setRightNode( rightN );
            currentNodeLN = leftN;
        }

        LNode currentNodeRN = rightNF;
        for ( int i = 0; i < 3; i++ ) {
            LNode leftN = new LNode( "6" + i );
            LNode rightN = new LNode( "7" + i );
            currentNodeRN.setLeftNode( leftN );
            currentNodeRN.setRightNode( rightN );
            currentNodeRN = rightN;
        }
    }

    public void traverseTree() {

        String values = traverseTree( this.rootNode );

        System.out.println( " final value" );
        System.out.println( values );
    }

    public void traverseTreeLR() {

        //traverseTreeDepthFirst( this.rootNode );
        //traverseTreeBreathFirst( rootNode );
        traverseBreathFirst( rootNode );
        

    }

    public String traverseTree( LNode aNode ) {

        if ( aNode.getLeftNode() == null && aNode.getRightNode() == null ) {
            System.out.println( "leaf:" + aNode.getValue() );
            return aNode.getValue();
        }
        else {
            //            StringBuilder sb = new StringBuilder();
            //            sb.append( " " + aNode.getValue() + "  \n" );
            //            sb.append( "leftNode: "+traverseTree( aNode.getLeftNode() ) +" ");
            //            sb.append( "rightNode: "+traverseTree( aNode.getRightNode() )+ " ");
            //            System.out.println(sb.toString());

            StringBuilder sb = new StringBuilder();
            sb.append( " " + aNode.getValue() + "  \n" );
            sb.append( "leftNode: " + traverseTree( aNode.getLeftNode() ) + " " );
            sb.append( "rightNode: " + traverseTree( aNode.getRightNode() ) + " " );
            System.out.println( sb.toString() );
            return sb.toString();
        }
    }

    public void traverseTreeLR( LNode aNode ) {

        System.out.println( aNode.getValue() );

        if ( aNode.getLeftNode() != null ) {
            traverseTreeLR( aNode.getLeftNode() );
        }
        if ( aNode.getRightNode() != null ) {
            traverseTreeLR( aNode.getRightNode() );
        }
    }

    public void traverseTreeDepthFirst( LNode aNode ) {

        if ( aNode == null ) {
            return;
        }

        System.out.println( aNode.getValue() );
        traverseTreeDepthFirst( aNode.getLeftNode() );
        traverseTreeDepthFirst( aNode.getRightNode() );

    }
    
    public void traverseTreeBreathFirst( LNode aNode ) {

        if ( aNode == null ) {
            return;
        }

        //System.out.println( aNode.getValue() );
        if(aNode.getLeftNode()!=null){
            System.out.print("left: " + aNode.getLeftNode().getValue());
        }
        if(aNode.getRightNode()!=null){
            System.out.print("   right: " + aNode.getRightNode().getValue());
        }
        System.out.println("");
        traverseTreeBreathFirst( aNode.getLeftNode() );
        
        traverseTreeBreathFirst( aNode.getRightNode() );

    }
    
  //traverse
    public void traverseBreathFirst(LNode node){
        if(node == null)
            System.out.println("Empty tree");
        else
        {
            Queue<LNode> q= new LinkedList<LNode>();
            q.add(node);
            while(q.peek() != null)
            {
                LNode temp = q.remove();
                System.out.println(temp.getValue());
                if(temp.getLeftNode() != null)
                    q.add(temp.getLeftNode());
                if(temp.getRightNode() != null)
                    q.add(temp.getRightNode());
            }
        }
    }
}
