/**
 * 
 */



package com.shirish.amqExample;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author shirish
 *
 */
public class AMQSubscriber {

    private Connection connection;
    private Session    session;



    /**
     * 
     */
    public AMQSubscriber() {

    }

    public void helloWorldConsumer() {

        try {


            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( AMQConstants.HostURL );

            // Create a Connection
            Connection connection = connectionFactory.createConnection(AMQConstants.username,AMQConstants.passwd);
            connection.start();

            connection.setExceptionListener( new AMQExpListener() );

            // Create a Session
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue( AMQConstants.QueueName );

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer( destination );
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
