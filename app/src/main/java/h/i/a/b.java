package h.i.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class b {
    public final int a;
    public final int b;
    public final byte[] c;

    b(int i2, int i3, byte[] bArr) {
        this.a = i2;
        this.b = i3;
        this.c = bArr;
    }

    public static b a(String str) {
        byte[] bytes = (str + (char) 0).getBytes(e.L);
        return new b(2, bytes.length, bytes);
    }

    public static b b(long j2, ByteOrder byteOrder) {
        return c(new long[]{j2}, byteOrder);
    }

    public static b c(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[e.t[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j2 : jArr) {
            byteBufferWrap.putInt((int) j2);
        }
        return new b(4, jArr.length, byteBufferWrap.array());
    }

    public static b d(d dVar, ByteOrder byteOrder) {
        return e(new d[]{dVar}, byteOrder);
    }

    public static b e(d[] dVarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[e.t[5] * dVarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (d dVar : dVarArr) {
            byteBufferWrap.putInt((int) dVar.a);
            byteBufferWrap.putInt((int) dVar.b);
        }
        return new b(5, dVarArr.length, byteBufferWrap.array());
    }

    public static b f(int i2, ByteOrder byteOrder) {
        return g(new int[]{i2}, byteOrder);
    }

    public static b g(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[e.t[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i2 : iArr) {
            byteBufferWrap.putShort((short) i2);
        }
        return new b(3, iArr.length, byteBufferWrap.array());
    }

    public double h(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objK instanceof String) {
            return Double.parseDouble((String) objK);
        }
        if (objK instanceof long[]) {
            if (((long[]) objK).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objK instanceof int[]) {
            if (((int[]) objK).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objK instanceof double[]) {
            double[] dArr = (double[]) objK;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objK instanceof d[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        d[] dVarArr = (d[]) objK;
        if (dVarArr.length == 1) {
            return dVarArr[0].a();
        }
        throw new NumberFormatException("There are more than one component");
    }

    public int i(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objK instanceof String) {
            return Integer.parseInt((String) objK);
        }
        if (objK instanceof long[]) {
            long[] jArr = (long[]) objK;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objK instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objK;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public String j(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            return null;
        }
        if (objK instanceof String) {
            return (String) objK;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (objK instanceof long[]) {
            long[] jArr = (long[]) objK;
            while (i2 < jArr.length) {
                sb.append(jArr[i2]);
                i2++;
                if (i2 != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objK instanceof int[]) {
            int[] iArr = (int[]) objK;
            while (i2 < iArr.length) {
                sb.append(iArr[i2]);
                i2++;
                if (i2 != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objK instanceof double[]) {
            double[] dArr = (double[]) objK;
            while (i2 < dArr.length) {
                sb.append(dArr[i2]);
                i2++;
                if (i2 != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objK instanceof d[])) {
            return null;
        }
        d[] dVarArr = (d[]) objK;
        while (i2 < dVarArr.length) {
            sb.append(dVarArr[i2].a);
            sb.append('/');
            sb.append(dVarArr[i2].b);
            i2++;
            if (i2 != dVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a0: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x01a0 */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Object k(ByteOrder byteOrder) throws Throwable {
        a aVar;
        InputStream inputStream;
        byte b;
        byte[] bArr;
        InputStream inputStream2 = null;
        try {
            try {
                aVar = new a(this.c);
                try {
                    aVar.f(byteOrder);
                    boolean z = true;
                    int length = 0;
                    switch (this.a) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.c;
                            if (bArr2.length != 1 || bArr2[0] < 0 || bArr2[0] > 1) {
                                String str = new String(this.c, e.L);
                                try {
                                    aVar.close();
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (this.c[0] + 48)});
                            try {
                                aVar.close();
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.b >= e.u.length) {
                                int i2 = 0;
                                while (true) {
                                    bArr = e.u;
                                    if (i2 < bArr.length) {
                                        if (this.c[i2] != bArr[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    length = bArr.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < this.b && (b = this.c[length]) != 0) {
                                if (b >= 32) {
                                    sb.append((char) b);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            String string = sb.toString();
                            try {
                                aVar.close();
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return string;
                        case 3:
                            int[] iArr = new int[this.b];
                            while (length < this.b) {
                                iArr[length] = aVar.readUnsignedShort();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.b];
                            while (length < this.b) {
                                jArr[length] = aVar.c();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return jArr;
                        case 5:
                            d[] dVarArr = new d[this.b];
                            while (length < this.b) {
                                dVarArr[length] = new d(aVar.c(), aVar.c());
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return dVarArr;
                        case 8:
                            int[] iArr2 = new int[this.b];
                            while (length < this.b) {
                                iArr2[length] = aVar.readShort();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.b];
                            while (length < this.b) {
                                iArr3[length] = aVar.readInt();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return iArr3;
                        case 10:
                            d[] dVarArr2 = new d[this.b];
                            while (length < this.b) {
                                dVarArr2[length] = new d(aVar.readInt(), aVar.readInt());
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return dVarArr2;
                        case 11:
                            double[] dArr = new double[this.b];
                            while (length < this.b) {
                                dArr[length] = aVar.readFloat();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.b];
                            while (length < this.b) {
                                dArr2[length] = aVar.readDouble();
                                length++;
                            }
                            try {
                                aVar.close();
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return dArr2;
                        default:
                            try {
                                aVar.close();
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    e = e13;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException e14) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e15) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                    }
                }
                throw th;
            }
        } catch (IOException e16) {
            e = e16;
            aVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public String toString() {
        return "(" + e.s[this.a] + ", data length:" + this.c.length + ")";
    }
}
