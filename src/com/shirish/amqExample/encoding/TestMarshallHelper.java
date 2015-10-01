package com.shirish.amqExample.encoding;



import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by t556427 on 6/4/2015.
 * <p/>
 * Charset
 * <p/>
 * Description
 * <p/>
 * US-ASCII	Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode character set
 * ISO-8859-1  	ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1
 * UTF-8	Eight-bit UCS Transformation Format
 * UTF-16BE	Sixteen-bit UCS Transformation Format, big-endian byte order
 * UTF-16LE	Sixteen-bit UCS Transformation Format, little-endian byte order
 * UTF-16	Sixteen-bit UCS Transformation Format, byte order identified by an optional byte-order mark
 * <p/>
 * http://docs.oracle.com/javase/1.5.0/docs/api/java/nio/charset/Charset.html
 */
public class TestMarshallHelper {

    public String marshall(EncodeXmlClass xmlClass, boolean writeTofile) {
        return marshallwithEncodingType(xmlClass,writeTofile,EncodingTypes.UTF8.getType());
    }
        public String marshallwithEncodingType(EncodeXmlClass xmlClass, boolean writeTofile, String encodingType) {
        try {
            JAXBContext context = JAXBContext.newInstance(EncodeXmlClass.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encodingType);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(xmlClass, stringWriter);

            if(writeTofile) {
                Writer writer = new FileWriter("xmlClass.xml");

                writer.write(stringWriter.toString());
                writer.flush();
            }
            return stringWriter.toString();
        } catch (Exception e) {
            System.out.println(" Error in Un-marshalling - " + e.getMessage());
            //e.printStackTrace();
            return "";
        }
    }

    /**
     * Un-marshall with default encoding in String object.
     * @param xmlData
     * @return
     */
    public EncodeXmlClass unMarshallXmlWithDefaultEncoding(String xmlData) {
        try {
            JAXBContext context = JAXBContext.newInstance(EncodeXmlClass.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            InputStream is = new ByteArrayInputStream(xmlData.getBytes());
            EncodeXmlClass xmlClass = (EncodeXmlClass) unmarshaller.unmarshal(is);

            is.close();
            return xmlClass;
        } catch (Exception e) {
            System.out.println(" Error in Un-marshalling - " + e.getMessage());
            //e.printStackTrace();
            return null;
        }

    }

    /**
     * Use given encoding type to un-marshall xml string
     * @param xmlData
     * @param encodingType
     * @return
     */
    public EncodeXmlClass unMarshallXmlByteWithEncoding(String xmlData, String encodingType) {
        try {
            JAXBContext context = JAXBContext.newInstance(EncodeXmlClass.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            InputStream is = new ByteArrayInputStream(xmlData.getBytes(encodingType));
            EncodeXmlClass xmlClass = (EncodeXmlClass) unmarshaller.unmarshal(is);

            is.close();
            return xmlClass;
        } catch (Exception e) {
            System.out.println(" Error in Un-marshalling - " + e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }
}
