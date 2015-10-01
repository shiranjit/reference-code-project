package com.shirish.amqExample.encoding;

/**
 * Created by t556427 on 6/4/2015.
 */
public class TestEncodingMarshllingTest {

    public static String testMarshall(String encodingType) {
        EncodeXmlClass xmlClass = new EncodeXmlClass();
        xmlClass.setFieldOne("beschränkter");
        xmlClass.setFieldTwo("Curaçao");

        TestMarshallHelper tmh = new TestMarshallHelper();
        String marshalled = tmh.marshallwithEncodingType(xmlClass, false, encodingType);
        System.out.println(marshalled);
        return marshalled;
    }

    /**
     * Default Encoding
     */

    public static void testUnMarshallXmlUsingDefaultEncoding(String xmlData) {
        System.out.println("encoding type : " + "default from string");
        try {
            TestMarshallHelper tmh = new TestMarshallHelper();

            EncodeXmlClass xmlClass = tmh.unMarshallXmlWithDefaultEncoding(xmlData);

            if (xmlClass == null) {
                System.out.println(" Failed to un-marshall here: " + xmlClass);
                System.out.println(" ******************* Test Failed *****************");
            } else {
                System.out.println(" Un-marshalling successful and Data is ----- ");
                System.out.println(xmlClass.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This is where encoding is passed
     * @param xmlData
     * @param encodingType
     */
    public static void testUnMarshallXmlString(String xmlData, String encodingType) {
        System.out.println("encoding type : " + encodingType);
        try {
            TestMarshallHelper tmh = new TestMarshallHelper();

            EncodeXmlClass xmlClass = tmh.unMarshallXmlByteWithEncoding(xmlData, encodingType);

            if (xmlClass == null) {
                System.out.println(" Failed to un-marshall here: " + xmlClass);
                System.out.println(" ******************* Test Failed *****************");
            } else {
                System.out.println(" Un-marshalling successful and Data is ----- ");
                System.out.println(xmlClass.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Tests
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\n\n=====test 1 - UTF-8 to UTF-8 pass =======");
        System.out.println(" Encode xml with UTF-8 and decode with UTF-8 ");
        String xmldata = testMarshall(EncodingTypes.UTF8.getType());
        testUnMarshallXmlString(xmldata, EncodingTypes.UTF8.getType());

        System.out.println("\n\n=====test 2 - UTF-8 to UTF-16 Fail =======");
        System.out.println(" Encode xml with UTF-8 and decode with UTF-8 ");
        xmldata = testMarshall(EncodingTypes.UTF8.getType());
        testUnMarshallXmlString(xmldata, EncodingTypes.UTF16.getType());

        System.out.println("\n\n=====test 3 - UTF-16 to UTF-16 pass =======");
        System.out.println(" Encode xml with UTF-16 and decode with UTF-16 ");
        xmldata = testMarshall(EncodingTypes.UTF16.getType());
        testUnMarshallXmlString(xmldata, EncodingTypes.UTF16.getType());

        System.out.println("\n\n=====test 4  - USASCII to UTF-16 fail =======");
        System.out.println(" Encode xml with USASCII and decode with UTF-16 ");
        xmldata = testMarshall(EncodingTypes.USASCII.getType());
        testUnMarshallXmlString(xmldata, EncodingTypes.UTF16.getType());

        System.out.println("\n\n=====test 5 - USASCII to Default encoding pass =======");
        System.out.println(" Encode xml with USASCII and decode default decoding ");
        xmldata = testMarshall(EncodingTypes.USASCII.getType());
        testUnMarshallXmlUsingDefaultEncoding(xmldata);

        System.out.println("\n\n=====test 6 - UTF-16 to Default encoding pass =======");
        System.out.println(" Encode xml with UTF-16 and decode default decoding ");
        xmldata = testMarshall(EncodingTypes.UTF16.getType());
        testUnMarshallXmlUsingDefaultEncoding(xmldata);

        System.out.println("\n\n=====test 7 - UTF-8 to Default encoding pass =======");
        System.out.println(" Encode xml with UTF-8 and decode default decoding ");
        xmldata = testMarshall(EncodingTypes.UTF8.getType());
        testUnMarshallXmlUsingDefaultEncoding(xmldata);

    }
}
