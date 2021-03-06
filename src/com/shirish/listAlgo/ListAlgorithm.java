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

package com.shirish.listAlgo;


/**
 * @author shirish
 *
 */
public class ListAlgorithm {

    private SinglyLinkedNode headNode;


    /**
     * 
     */
    public ListAlgorithm() {

        createLinkedList();
    }

    private void createLinkedList() {

        headNode = new SinglyLinkedNode( "h1", "1" );
        // headNode.addNext( new LNode( "h2","2" ) );
        SinglyLinkedNode currentNode = headNode;
        for ( int i = 2; i < 10; i++ ) {
            SinglyLinkedNode nextNode = new SinglyLinkedNode( "h" + i, "" + i );
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
    }

    public void reverseList() {

        System.out.println( "actual list" );
        printNodes( headNode );
        SinglyLinkedNode revNode = reverseListIteratively( headNode );
        System.out.println( "printing out the reverse" );
        printNodes( revNode );
    }

    private SinglyLinkedNode reverseListIteratively( SinglyLinkedNode head ) {

        if ( head == null || head.next == null ) {
            return null; //empty or just one node in list
        }
        SinglyLinkedNode Second = head.next;
        //store third node before we change 
        SinglyLinkedNode Third = Second.next;
        //Second's next pointer
        Second.next = head; //second now points to head
        head.next = null; //change head pointer to null

        //only two nodes, which we already reversed
        if ( Third == null )
            return null;

        SinglyLinkedNode CurrentNode = Third;
        SinglyLinkedNode PreviousNode = Second;

        while ( CurrentNode != null ) {
            SinglyLinkedNode NextNode = CurrentNode.next;
            CurrentNode.next = PreviousNode;
            /*
             * repeat the process, but have to reset the PreviousNode and
             * CurrentNode
             */
            PreviousNode = CurrentNode;
            CurrentNode = NextNode;
        }
        head = PreviousNode; //reset the head node

        System.out.println( "printing in the method" );
        printNodes( head );
        return head;
    }

    private void printNodes( SinglyLinkedNode node ) {

        SinglyLinkedNode currNode = node;
        while ( currNode != null ) {
            System.out.println( currNode.getName() + ": " + currNode.getValue() );
            currNode = currNode.next;
        }
    }


    public void reverseAListHalfSteps() {

        int[] i = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int size = i.length;
        int[] a = new int[size];
        int k =0;
        int midpoint = (size/2)-1;
        int midStartPoint = midpoint+1;
        //this is to handle odd size case
        if(size % 2 >0){
            midpoint = size/2;
            midStartPoint = midpoint;
        }
        
        for ( int n = size - 1; n > midpoint; n-- ) {
            a[k] = i[n];
            //the index in half + need to add 1 to account for 0 based indexs
            a[midStartPoint+k] = i[midpoint-k];
            k++;
        }
        // we will miss the first one due to odd size 
        if (size%2>0){
            a[size-1] = i[0];
        }

        System.out.println( "original" );
        for ( int j = 0; j < i.length; j++ ) {
            System.out.print( i[j] + "," );
        }
        System.out.println("");
        System.out.println( "reversed" );
        for ( int j = 0; j < a.length; j++ ) {
            System.out.print( a[j] +",");
        }
    }
}
