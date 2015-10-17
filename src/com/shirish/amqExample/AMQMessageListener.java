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

package com.shirish.amqExample;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.shirish.amqExample.encoding.EncodeXmlClass;
import com.shirish.amqExample.encoding.EncodingTypes;
import com.shirish.amqExample.encoding.TestMarshallHelper;


/**
 * @author shirish
 *
 */
public class AMQMessageListener implements MessageListener {

    /**
     * 
     */
    public AMQMessageListener() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage( Message message ) {

        try {
            if ( message instanceof TextMessage ) {
                TextMessage textMessage = (TextMessage) message;
                String xmlData = textMessage.getText();

                try {
                    TestMarshallHelper tmh = new TestMarshallHelper();

                    EncodeXmlClass xmlClass = tmh.unMarshallXmlWithDefaultEncoding( xmlData ); //tmh.unMarshallXmlByteWithEncoding( xmlData, EncodingTypes.UTF16.getType() );

                    if ( xmlClass == null ) {
                        System.out.println( " Failed to un-marshall here: " + xmlClass );
                        System.out.println( " ******************* Test Failed *****************" );
                    }
                    else {
                        System.out.println( " Un-marshalling successful and Data is ----- " );
                        System.out.println( xmlClass.toString() );
                    }
                }
                catch ( Exception e ) {
                    e.printStackTrace();
                }

            }
            else {
                System.out.println( "Received: " + message );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }




}
