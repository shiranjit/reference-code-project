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
