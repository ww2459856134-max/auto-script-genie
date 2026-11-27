package org.apache.xmlbeans.impl.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class SniffedXmlReader extends BufferedReader {
    public static final int MAX_SNIFFED_CHARS = 192;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName("UTF-16BE");
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private String _encoding;

    public SniffedXmlReader(Reader reader) throws IOException {
        super(reader);
        this._encoding = sniffForXmlDecl();
    }

    private int readAsMuchAsPossible(char[] cArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int i5 = read(cArr, i2 + i4, i3 - i4);
            if (i5 < 0) {
                break;
            }
            i4 += i5;
        }
        return i4;
    }

    private String sniffForXmlDecl() throws IOException {
        mark(192);
        try {
            char[] cArr = new char[192];
            return SniffedXmlInputStream.extractXmlDeclEncoding(cArr, 0, readAsMuchAsPossible(cArr, 0, 192));
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }
}
