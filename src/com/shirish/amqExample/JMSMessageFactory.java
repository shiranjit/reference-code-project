


package com.shirish.amqExample;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;


public class JMSMessageFactory {

    public JMSMessageFactory() {

    }

    public Message getMessage(Object msg, Session jmsSession, JMSMsgType msgType) throws JMSException{
        
        if(JMSMsgType.ByteMsgType.equals( msgType )){
            return getBytesMessage( msg, jmsSession );
        }
        else if (JMSMsgType.TextMsgType.equals( msgType )){
            return getTextMessage( (String)msg, jmsSession );
        }
        else if (JMSMsgType.ObjectMsgType.equals( msgType )){
            return getObjMessage( (String)msg, jmsSession );
        }
        
        
        return null;
    }

    /**
     * Byte Message
     * 
     * @param message
     * @param jmsSession
     * @return
     * @throws JMSException
     */
    public BytesMessage getBytesMessage( Object message, Session jmsSession ) throws JMSException {

        BytesMessage byteMsg = jmsSession.createBytesMessage();
        byteMsg.writeObject( message );

        return byteMsg;
    }


    /**
     * Test Message
     * 
     * @param msg
     * @param jmsSession
     * @return
     * @throws JMSException
     */
    public TextMessage getTextMessage( String msg, Session jmsSession ) throws JMSException {

        TextMessage txtMsg = jmsSession.createTextMessage();
        txtMsg.setText( msg );

        return txtMsg;
    }

    /**
     * Object Message
     * 
     * @param msg
     * @param jmsSession
     * @return
     * @throws JMSException
     */
    public ObjectMessage getObjMessage( String msg, Session jmsSession ) throws JMSException {

        ObjectMessage objMsg = jmsSession.createObjectMessage( );
        objMsg.setObject( msg );

        return objMsg;
    }
    
    /**
     * StreamMsssage is interesting
     * 
     */
    
    /**
     * MapMessage - what is the usecase for this?
     */
}
