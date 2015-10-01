/**
 * 
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
