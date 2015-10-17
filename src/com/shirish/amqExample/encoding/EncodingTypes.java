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
