package com.shirish.performanceMonitor.common.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil
{

    /**
     * @param obj
     * @param writer
     * @return 
     */
    public static String JavaBeanToXml(Object obj)
    {
        return convertToXml(obj, "UTF-8");
    }

    /**
     *
     * @param obj
     * @param encoding 
     * @return 
     */
    public static String convertToXml(Object obj, String encoding)
    {
        String result = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            //            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToJavaBean(String xml, Class<T> c)
    {
        if (xml.trim().isEmpty())
        {
            return null;
        }
        T t = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return t;
    }
}