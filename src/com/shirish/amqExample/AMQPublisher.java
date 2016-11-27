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

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.shirish.amqExample.encoding.EncodeXmlClass;
import com.shirish.amqExample.encoding.EncodingTypes;
import com.shirish.amqExample.encoding.TestMarshallHelper;


/**
 * @author shirish
 *
 */
public class AMQPublisher {

    /**
     * 
     */
    public AMQPublisher() {

    }

    private void config() {

    }

    public void helloWorldProducer(JMSMsgType msgType) {

        JMSMessageFactory msgFactory = new JMSMessageFactory();
        Session session = null;
        Connection connection = null;
        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( AMQConstants.HostURL );

            // Create a Connection
            connection = connectionFactory.createConnection( AMQConstants.username, AMQConstants.passwd );
            connection.start();

            // Create a Session
            session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );

            // Create the destination (Topic or Queue)
            Destination destination = session.createTopic( AMQConstants.QueueName );

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer( destination );
            producer.setDeliveryMode( DeliveryMode.PERSISTENT );

            for ( int i = 0; i < 10000; i++ ) {
                String xmldata = testMarshall( EncodingTypes.UTF8.getType(), Integer.valueOf( i ) );
                // Create a messages
                //String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + i;
               // TextMessage message = session.createTextMessage( xmldata );
                Message message = msgFactory.getMessage( xmldata, session, msgType );

                // Tell the producer to send the message
                System.out.println( "Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName() + " i: " + i );
                producer.send( message );

                Thread.sleep( 500 );
            }

        }
        catch ( Exception e ) {
            System.out.println( "Caught: " + e );
            e.printStackTrace();
        }
        finally {
            // Clean up

            try {
                if ( session != null )
                    session.close();
            }
            catch ( JMSException e ) {
                e.printStackTrace();
            }

            try {
                if ( connection != null )
                    connection.close();
            }
            catch ( JMSException e ) {
                e.printStackTrace();
            }
        }
    }

    private String testMarshall( String encodingType, Integer num ) {

        EncodeXmlClass xmlClass = new EncodeXmlClass();
        xmlClass.setFieldOne( "beschränkter" );
        xmlClass.setFieldTwo( "Curaçao" );
        xmlClass.setMessageNum( num );

        TestMarshallHelper tmh = new TestMarshallHelper();
        String marshalled = tmh.marshallwithEncodingType( xmlClass, false, encodingType );
        System.out.println( marshalled );
        return marshalled;
    }
}
