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
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author shirish
 *
 */
public class AMQQueueSubscriber {

    private Connection connection;
    private Session    session;



    /**
     * 
     */
    public AMQQueueSubscriber() {

    }

    public void helloWorldConsumer() {

        try {


            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( AMQConstants.HostURL );

            // Create a Connection
            Connection connection = connectionFactory.createConnection(AMQConstants.username,AMQConstants.passwd);
            connection.setClientID("shirish");
            connection.start();

            connection.setExceptionListener( new AMQExpListener() );

            // Create a Session
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );

            // Create the destination (Topic or Queue)
            //Topic destination = session.createTopic( AMQConstants.QueueName );
            Queue destination = session.createQueue( AMQConstants.MQQueue + AMQConstants.VMQueueName );

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination );
            consumer.setMessageListener( new AMQMessageListener() );

            //            // Wait for a message
            //            Message message = consumer.receive( 1000 );
            //
            //            if ( message instanceof TextMessage ) {
            //                TextMessage textMessage = (TextMessage) message;
            //                String text = textMessage.getText();
            //                System.out.println( "Received: " + text );
            //            }
            //            else {
            //                System.out.println( "Received: " + message );
            //            }
            //
            //            consumer.close();
        }
        catch ( Exception e ) {
            System.out.println( "Caught: " + e );
            e.printStackTrace();
            shutdown();
            
            System.exit( -1 );
        }
    }


    public void shutdown() {

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
