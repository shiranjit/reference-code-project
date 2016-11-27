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

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;

/**
 * @author shirish
 *
 */
public class AMQPooledSubscriber {

	private List<Connection> connectionList = new ArrayList<Connection>();
	private Session session;
	private PooledConnectionFactory pooledConnectionFactory;
	private ActiveMQConnectionFactory connectionFactory;

	/**
	 * 
	 */
	public AMQPooledSubscriber() {

	}

	public void helloWorldConsumer() {

		try {

			// Create a ConnectionFactory
			connectionFactory = new ActiveMQConnectionFactory(AMQConstants.HostURL);
			pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(100);
			pooledConnectionFactory.start();

			for (int i = 0; i < 10; i++) {
				// Create a Connection
				Connection connection = pooledConnectionFactory.createConnection(AMQConstants.username,
						AMQConstants.passwd);
				connectionList.add(connection);
				connection.setClientID("shirish");

				connection.start();

				connection.setExceptionListener(new AMQExpListener());

				// Create a Session
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Topic destination = session.createTopic(AMQConstants.QueueName);

				// Create a MessageConsumer from the Session to the Topic or
				// Queue
				MessageConsumer consumer = session.createDurableSubscriber(destination, "shirish");
				consumer.setMessageListener(new AMQMessageListener());

				// // Wait for a message
				// Message message = consumer.receive( 1000 );
				//
				// if ( message instanceof TextMessage ) {
				// TextMessage textMessage = (TextMessage) message;
				// String text = textMessage.getText();
				// System.out.println( "Received: " + text );
				// }
				// else {
				// System.out.println( "Received: " + message );
				// }
				//
				// consumer.close();
			}
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
			shutdown();

			System.exit(-1);
		}
	}

	public void shutdown() {

		try {
			if (session != null)
				session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

		try {
			if (connectionList.size()>0){
				for (Connection connection : connectionList) {
					connection.close();
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

		try {
			if (null != pooledConnectionFactory) {
				pooledConnectionFactory.clear();
				pooledConnectionFactory.stop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
