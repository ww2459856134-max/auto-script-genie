package com.bumptech.glide.load.z.f;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class p implements ImageHeaderParser {
    static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static int d(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int e(n nVar, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        try {
            int iA = nVar.a();
            if (!g(iA)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
                }
                return -1;
            }
            int i2 = i(nVar);
            if (i2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.c(i2, byte[].class);
            try {
                return k(nVar, bArr, i2);
            } finally {
                bVar.e(bArr);
            }
        } catch (m unused) {
            return -1;
        }
    }

    private ImageHeaderParser.ImageType f(n nVar) throws IOException {
        try {
            int iA = nVar.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iA << 8) | nVar.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | nVar.c();
            if (iC2 == -1991225785) {
                nVar.skip(21L);
                try {
                    return nVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (m unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            nVar.skip(4L);
            if (((nVar.a() << 16) | nVar.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (nVar.a() << 16) | nVar.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iA2 & 255;
            if (i2 == 88) {
                nVar.skip(4L);
                return (nVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            nVar.skip(4L);
            return (nVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (m unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean g(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean h(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > a.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = a;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            }
        }
        return z;
    }

    private int i(n nVar) throws IOException {
        short sC;
        int iA;
        long j2;
        long jSkip;
        do {
            short sC2 = nVar.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = nVar.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = nVar.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j2 = iA;
            jSkip = nVar.skip(j2);
        } while (jSkip == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int j(l lVar) {
        ByteOrder byteOrder;
        short sA = lVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        lVar.e(byteOrder);
        int iB = lVar.b(10) + 6;
        short sA2 = lVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iD = d(iB, i2);
            short sA3 = lVar.a(iD);
            if (sA3 == 274) {
                short sA4 = lVar.a(iD + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = lVar.b(iD + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i3 = iB2 + b[sA4];
                        if (i3 <= 4) {
                            int i4 = iD + 8;
                            if (i4 >= 0 && i4 <= lVar.d()) {
                                if (i3 >= 0 && i3 + i4 <= lVar.d()) {
                                    return lVar.a(i4);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int k(n nVar, byte[] bArr, int i2) throws IOException {
        int iB = nVar.b(bArr, i2);
        if (iB == i2) {
            if (h(bArr, i2)) {
                return j(new l(bArr, i2));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + iB);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        com.bumptech.glide.b0.n.d(inputStream);
        return f(new o(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        com.bumptech.glide.b0.n.d(inputStream);
        o oVar = new o(inputStream);
        com.bumptech.glide.b0.n.d(bVar);
        return e(oVar, bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) throws IOException {
        com.bumptech.glide.b0.n.d(byteBuffer);
        return f(new k(byteBuffer));
    }
}
