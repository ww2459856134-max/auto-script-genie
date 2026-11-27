package org.apache.xmlbeans.impl.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class LongUTFDataOutputStream extends DataOutputStream {
    static final int MAX_UNSIGNED_SHORT = 65534;

    public LongUTFDataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public static int countUTF(String str) {
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            i2 = (cCharAt < 1 || cCharAt > 127) ? cCharAt > 2047 ? i2 + 3 : i2 + 2 : i2 + 1;
        }
        return i2;
    }

    public void writeLongUTF(String str) throws IOException {
        int i2;
        int i3;
        writeShortOrInt(countUTF(str));
        byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (i4 >= 4093) {
                write(bArr, 0, i4);
                i4 = 0;
            }
            char cCharAt = str.charAt(i5);
            if (cCharAt < 1 || cCharAt > 127) {
                if (cCharAt > 2047) {
                    int i6 = i4 + 1;
                    bArr[i4] = (byte) (((cCharAt >> '\f') & 15) | 224);
                    i2 = i6 + 1;
                    bArr[i6] = (byte) (((cCharAt >> 6) & 63) | 128);
                } else {
                    bArr[i4] = (byte) (((cCharAt >> 6) & 31) | 192);
                    i2 = i4 + 1;
                }
                i3 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt & '?') | 128);
            } else {
                i3 = i4 + 1;
                bArr[i4] = (byte) cCharAt;
            }
            i4 = i3;
        }
        write(bArr, 0, i4);
    }

    public void writeShortOrInt(int i2) throws IOException {
        writeShortOrInt(this, i2);
    }

    public static void writeShortOrInt(DataOutputStream dataOutputStream, int i2) throws IOException {
        if (i2 < MAX_UNSIGNED_SHORT) {
            dataOutputStream.writeShort(i2);
        } else {
            dataOutputStream.writeShort(MAX_UNSIGNED_SHORT);
            dataOutputStream.writeInt(i2);
        }
    }
}
