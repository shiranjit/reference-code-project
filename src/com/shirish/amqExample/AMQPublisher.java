/**
 * 
 */



package com.shirish.amqExample;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
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

    public void helloWorldProducer() {

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
            Destination destination = session.createQueue( AMQConstants.QueueName );

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer( destination );
            producer.setDeliveryMode( DeliveryMode.NON_PERSISTENT );

            for ( int i = 0; i < 100; i++ ) {
                String xmldata = testMarshall( EncodingTypes.UTF8.getType(), Integer.valueOf( i ) );
                // Create a messages
                //String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + i;
                TextMessage message = session.createTextMessage( xmldata );

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