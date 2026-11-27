package org.apache.xmlbeans.impl.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class LongUTFDataInputStream extends DataInputStream {

    /* JADX INFO: Access modifiers changed from: private */
    interface IOCall {
        byte onebyte(int[] iArr, int[] iArr2, int[] iArr3) throws IOException;
    }

    public LongUTFDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ byte c(int i2, byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3) throws IOException {
        if (iArr3[0] + 1 > i2) {
            throw new UTFDataFormatException("malformed input: partial character at end");
        }
        if (iArr[0] >= iArr2[0]) {
            iArr2[0] = Math.min(bArr.length, i2 - iArr3[0]);
            readFully(bArr, 0, iArr2[0]);
            iArr[0] = 0;
        }
        iArr3[0] = iArr3[0] + 1;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        return bArr[i3];
    }

    public String readLongUTF() throws IOException {
        final int unsignedShortOrInt = readUnsignedShortOrInt();
        StringBuilder sb = new StringBuilder(unsignedShortOrInt / 2);
        final byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        IOCall iOCall = new IOCall() { // from class: org.apache.xmlbeans.impl.util.a
            @Override // org.apache.xmlbeans.impl.util.LongUTFDataInputStream.IOCall
            public final byte onebyte(int[] iArr, int[] iArr2, int[] iArr3) {
                return this.a.c(unsignedShortOrInt, bArr, iArr, iArr2, iArr3);
            }
        };
        int[] iArr = {0};
        int[] iArr2 = {0};
        int[] iArr3 = {0};
        while (iArr[0] < unsignedShortOrInt) {
            int iOnebyte = iOCall.onebyte(iArr2, iArr3, iArr) & 255;
            switch (iOnebyte >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sb.append((char) iOnebyte);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    throw new UTFDataFormatException("malformed input around byte " + iArr[0]);
                case 12:
                case 13:
                    byte bOnebyte = iOCall.onebyte(iArr2, iArr3, iArr);
                    if ((bOnebyte & 192) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + iArr[0]);
                    }
                    sb.append((char) (((iOnebyte & 31) << 6) | (bOnebyte & 63)));
                    break;
                case 14:
                    byte bOnebyte2 = iOCall.onebyte(iArr2, iArr3, iArr);
                    byte bOnebyte3 = iOCall.onebyte(iArr2, iArr3, iArr);
                    if ((bOnebyte2 & 192) != 128 || (bOnebyte3 & 192) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + (iArr[0] - 1));
                    }
                    sb.append((char) (((iOnebyte & 15) << 12) | ((bOnebyte2 & 63) << 6) | (bOnebyte3 & 63)));
                    break;
            }
        }
        return sb.toString();
    }

    public int readUnsignedShortOrInt() throws IOException {
        return readUnsignedShortOrInt(this);
    }

    public static int readUnsignedShortOrInt(DataInputStream dataInputStream) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        return unsignedShort == 65534 ? dataInputStream.readInt() : unsignedShort;
    }
}
