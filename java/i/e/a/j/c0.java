package i.e.a.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes.dex */
public class c0 extends Reader {
    protected final z c;
    protected InputStream d;
    protected byte[] e;
    protected int f;
    protected int g;

    /* renamed from: h, reason: collision with root package name */
    protected final boolean f1574h;

    /* renamed from: i, reason: collision with root package name */
    protected char f1575i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected int f1576j = 0;

    /* renamed from: k, reason: collision with root package name */
    protected int f1577k = 0;
    char[] t = null;

    public c0(z zVar, InputStream inputStream, byte[] bArr, int i2, int i3, boolean z) {
        this.c = zVar;
        this.f1574h = z;
    }

    private boolean c(int i2) throws IOException {
        this.f1577k += this.g - i2;
        if (i2 > 0) {
            if (this.f > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    byte[] bArr = this.e;
                    bArr[i3] = bArr[this.f + i3];
                }
                this.f = 0;
            }
            this.g = i2;
        } else {
            this.f = 0;
            int i4 = this.d.read(this.e);
            if (i4 < 1) {
                this.g = 0;
                if (i4 < 0) {
                    a();
                    return false;
                }
                i();
                throw null;
            }
            this.g = i4;
        }
        while (true) {
            int i5 = this.g;
            if (i5 >= 4) {
                return true;
            }
            InputStream inputStream = this.d;
            byte[] bArr2 = this.e;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 < 1) {
                if (i6 >= 0) {
                    i();
                    throw null;
                }
                a();
                j(this.g, 4);
                throw null;
            }
            this.g += i6;
        }
    }

    private void f(int i2, int i3, String str) throws IOException {
        int i4 = (this.f1577k + this.f) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i2) + str + " at char #" + (this.f1576j + i3) + ", byte #" + i4 + ")");
    }

    private void j(int i2, int i3) throws IOException {
        int i4 = this.f1577k + i2;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i2 + ", needed " + i3 + ", at char #" + this.f1576j + ", byte #" + i4 + ")");
    }

    public final void a() {
        byte[] bArr = this.e;
        if (bArr != null) {
            this.e = null;
            z zVar = this.c;
            if (zVar != null) {
                zVar.x(bArr);
            }
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            this.d = null;
            a();
            inputStream.close();
        }
    }

    protected void d(char[] cArr, int i2, int i3) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i2 + "," + i3 + "), cbuf[" + cArr.length + "]");
    }

    protected void i() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.t == null) {
            this.t = new char[1];
        }
        if (read(this.t, 0, 1) < 1) {
            return -1;
        }
        return this.t[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e6, code lost:
    
        r1 = r1 - r10;
        r8.f1576j += r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ec, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e3 A[LOOP:0: B:22:0x0031->B:51:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e1 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(char[] cArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int i6;
        if (this.e != null) {
            if (i3 >= 1) {
                if (i2 >= 0 && i2 + i3 <= cArr.length) {
                    int i7 = i3 + i2;
                    char c = this.f1575i;
                    if (c != 0) {
                        i4 = i2 + 1;
                        cArr[i2] = c;
                        this.f1575i = (char) 0;
                    } else {
                        int i8 = this.g - this.f;
                        if (i8 < 4 && !c(i8)) {
                            return -1;
                        }
                        i4 = i2;
                    }
                    byte[] bArr = this.e;
                    while (true) {
                        if (i4 >= i7) {
                            break;
                        }
                        int i9 = this.f;
                        if (this.f1574h) {
                            i5 = (bArr[i9] << 24) | ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9 + 2] & 255) << 8);
                            i6 = bArr[i9 + 3] & 255;
                        } else {
                            i5 = (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
                            i6 = bArr[i9 + 3] << 24;
                        }
                        int i10 = i5 | i6;
                        int i11 = i9 + 4;
                        this.f = i11;
                        if (i10 < 55296) {
                            int i12 = i4 + 1;
                            cArr[i4] = (char) i10;
                            if (i11 < this.g) {
                                i4 = i12;
                                break;
                            }
                            i4 = i12;
                        } else {
                            if (i10 > 1114111) {
                                f(i10, i4 - i2, "(above " + Integer.toHexString(1114111) + ") ");
                                throw null;
                            }
                            if (i10 > 65535) {
                                int i13 = i10 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                int i14 = i4 + 1;
                                cArr[i4] = (char) ((i13 >> 10) + 55296);
                                i10 = (i13 & 1023) | 56320;
                                if (i14 >= i7) {
                                    this.f1575i = (char) i10;
                                    i4 = i14;
                                    break;
                                }
                                i4 = i14;
                            } else {
                                if (i10 < 57344) {
                                    f(i10, i4 - i2, "(a surrogate char) ");
                                    throw null;
                                }
                                if (i10 >= 65534) {
                                    f(i10, i4 - i2, "");
                                    throw null;
                                }
                            }
                            int i122 = i4 + 1;
                            cArr[i4] = (char) i10;
                            if (i11 < this.g) {
                            }
                        }
                    }
                } else {
                    d(cArr, i2, i3);
                    throw null;
                }
            } else {
                return i3;
            }
        } else {
            return -1;
        }
    }
}
