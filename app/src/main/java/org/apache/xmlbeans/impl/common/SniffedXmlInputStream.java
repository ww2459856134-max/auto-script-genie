package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class SniffedXmlInputStream extends BufferedInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_SNIFFED_BYTES = 192;
    private String _encoding;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName("UTF-16BE");
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private static char[] WHITESPACE = {Chars.SPACE, Chars.CR, '\t', '\n'};
    private static char[] NOTNAME = {Chars.EQ, Chars.SPACE, Chars.CR, '\t', '\n', '?', '>', '<', Chars.QUOTE, Chars.DQUOTE};

    private static class ScannedAttribute {
        public String name;
        public String value;

        private ScannedAttribute() {
        }
    }

    public SniffedXmlInputStream(InputStream inputStream) throws IOException {
        String strSniffForXmlDecl;
        super(inputStream);
        String strSniffFourBytes = sniffFourBytes();
        this._encoding = strSniffFourBytes;
        if (strSniffFourBytes != null && strSniffFourBytes.equals("IBM037") && (strSniffForXmlDecl = sniffForXmlDecl(this._encoding)) != null) {
            this._encoding = strSniffForXmlDecl;
        }
        if (this._encoding == null) {
            this._encoding = sniffForXmlDecl("UTF-8");
        }
        if (this._encoding == null) {
            this._encoding = "UTF-8";
        }
    }

    static String extractXmlDeclEncoding(char[] cArr, int i2, int i3) {
        int i4 = i3 + i2;
        int iFirstIndexOf = firstIndexOf("<?xml", cArr, i2, i4);
        if (iFirstIndexOf >= 0) {
            int iScanAttribute = iFirstIndexOf + 5;
            ScannedAttribute scannedAttribute = new ScannedAttribute();
            while (iScanAttribute < i4) {
                iScanAttribute = scanAttribute(cArr, iScanAttribute, i4, scannedAttribute);
                if (iScanAttribute < 0) {
                    return null;
                }
                if (scannedAttribute.name.equals("encoding")) {
                    return scannedAttribute.value;
                }
            }
        }
        return null;
    }

    private static int firstIndexOf(String str, char[] cArr, int i2, int i3) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        int length = i3 - charArray.length;
        while (i2 < length) {
            if (cArr[i2] == c) {
                for (int i4 = 1; i4 < charArray.length; i4++) {
                    if (cArr[i2 + i4] != charArray[i4]) {
                        break;
                    }
                }
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int nextMatchingByte(char[] cArr, char[] cArr2, int i2, int i3) {
        while (i2 < i3) {
            char c = cArr2[i2];
            for (char c2 : cArr) {
                if (c == c2) {
                    return i2;
                }
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int nextNonmatchingByte(char[] cArr, char[] cArr2, int i2, int i3) {
        while (i2 < i3) {
            char c = cArr2[i2];
            for (char c2 : cArr) {
                if (c == c2) {
                    break;
                }
            }
            return i2;
        }
        return -1;
    }

    private int readAsMuchAsPossible(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int i5 = read(bArr, i2 + i4, i3 - i4);
            if (i5 < 0) {
                break;
            }
            i4 += i5;
        }
        return i4;
    }

    private static int scanAttribute(char[] cArr, int i2, int i3, ScannedAttribute scannedAttribute) {
        int iNextMatchingByte;
        int iNextNonmatchingByte;
        int i4;
        int iNextMatchingByte2;
        int iNextNonmatchingByte2 = nextNonmatchingByte(WHITESPACE, cArr, i2, i3);
        if (iNextNonmatchingByte2 < 0 || (iNextMatchingByte = nextMatchingByte(NOTNAME, cArr, iNextNonmatchingByte2, i3)) < 0 || (iNextNonmatchingByte = nextNonmatchingByte(WHITESPACE, cArr, iNextMatchingByte, i3)) < 0 || cArr[iNextNonmatchingByte] != '=') {
            return -1;
        }
        int iNextNonmatchingByte3 = nextNonmatchingByte(WHITESPACE, cArr, iNextNonmatchingByte + 1, i3);
        if ((cArr[iNextNonmatchingByte3] != '\'' && cArr[iNextNonmatchingByte3] != '\"') || (iNextMatchingByte2 = nextMatchingByte(cArr[iNextNonmatchingByte3], cArr, (i4 = iNextNonmatchingByte3 + 1), i3)) < 0) {
            return -1;
        }
        scannedAttribute.name = new String(cArr, iNextNonmatchingByte2, iNextMatchingByte - iNextNonmatchingByte2);
        scannedAttribute.value = new String(cArr, i4, (iNextMatchingByte2 - iNextNonmatchingByte3) - 1);
        return iNextMatchingByte2 + 1;
    }

    private String sniffForXmlDecl(String str) throws IOException {
        mark(192);
        try {
            byte[] bArr = new byte[192];
            int asMuchAsPossible = readAsMuchAsPossible(bArr, 0, 192);
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 0, asMuchAsPossible), Charset.forName(str));
            char[] cArr = new char[asMuchAsPossible];
            int i2 = 0;
            while (i2 < asMuchAsPossible) {
                int i3 = inputStreamReader.read(cArr, i2, asMuchAsPossible - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            }
            return extractXmlDeclEncoding(cArr, 0, i2);
        } finally {
            reset();
        }
    }

    private String sniffFourBytes() throws IOException {
        mark(4);
        try {
            byte[] bArr = new byte[4];
            if (readAsMuchAsPossible(bArr, 0, 4) < 4) {
                return null;
            }
            long j2 = ((-16777216) & (bArr[0] << 24)) | (16711680 & (bArr[1] << 16)) | (65280 & (bArr[2] << 8)) | (bArr[3] & 255);
            if (j2 == 65279) {
                return "UCS-4";
            }
            if (j2 == -131072) {
                return "UCS-4";
            }
            if (j2 == 60) {
                return "UCS-4BE";
            }
            if (j2 == 1006632960) {
                return "UCS-4LE";
            }
            if (j2 == 3932223) {
                return "UTF-16BE";
            }
            if (j2 == 1006649088) {
                return "UTF-16LE";
            }
            if (j2 == 1010792557) {
                return null;
            }
            if (j2 == 1282385812) {
                return "IBM037";
            }
            long j3 = (-65536) & j2;
            if (j3 == -16842752) {
                return "UTF-16";
            }
            if (j3 == -131072) {
                return "UTF-16";
            }
            if ((j2 & (-256)) == -272908544) {
                return "UTF-8";
            }
            return null;
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }

    private static int nextMatchingByte(char c, char[] cArr, int i2, int i3) {
        while (i2 < i3) {
            if (cArr[i2] == c) {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
