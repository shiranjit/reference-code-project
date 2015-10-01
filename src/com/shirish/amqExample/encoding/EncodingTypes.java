package com.shirish.amqExample.encoding;

/**
 * Created by t556427 on 6/4/2015.
 * <p/>
 * <p/>
 * US-ASCII	Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode character set
 * ISO-8859-1  	ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1
 * UTF-8	Eight-bit UCS Transformation Format
 * UTF-16BE	Sixteen-bit UCS Transformation Format, big-endian byte order
 * UTF-16LE	Sixteen-bit UCS Transformation Format, little-endian byte order
 * UTF-16	Sixteen-bit UCS Transformation Format, byte order identified by an optional byte-order mark
 * <p/>
 */
public enum EncodingTypes {
    USASCII("US-ASCII"),
    UTF8("UTF-8"),
    UTF16("UTF-16");

    private String name;

    private EncodingTypes(String type) {
        this.name = type;
    }

    public String getType() {
        return this.name;
    }
}
