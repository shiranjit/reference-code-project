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
