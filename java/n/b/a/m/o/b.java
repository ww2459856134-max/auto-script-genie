package n.b.a.m.o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends a {
    protected char[] e;
    protected int f;
    protected int g;

    /* renamed from: h, reason: collision with root package name */
    protected final ArrayList<char[]> f2545h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    protected int f2546i;

    /* renamed from: j, reason: collision with root package name */
    protected int f2547j;

    /* renamed from: k, reason: collision with root package name */
    protected int f2548k;

    private boolean i() {
        if (this.f2548k >= this.f2545h.size()) {
            return false;
        }
        ArrayList<char[]> arrayList = this.f2545h;
        int i2 = this.f2548k;
        this.f2548k = i2 + 1;
        this.e = arrayList.get(i2);
        if (this.f2548k == this.f2545h.size()) {
            this.f = this.f2546i;
            this.g = this.f2547j;
            return true;
        }
        this.f = 0;
        this.g = this.e.length;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013b A[SYNTHETIC] */
    @Override // n.b.a.m.o.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(byte[] bArr, int i2, int i3) throws IllegalArgumentException {
        int iA;
        int iA2;
        int iA3;
        char c;
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            switch (this.b) {
                case 0:
                    do {
                        if (this.f >= this.g && !i()) {
                            break;
                        } else {
                            char[] cArr = this.e;
                            int i6 = this.f;
                            this.f = i6 + 1;
                            c = cArr[i6];
                        }
                    } while (c <= ' ');
                    int iA4 = this.a.a(c);
                    if (iA4 < 0) {
                        throw f(c, 0);
                    }
                    this.c = iA4;
                    if (this.f < this.g && !i()) {
                        this.b = 1;
                        break;
                    } else {
                        char[] cArr2 = this.e;
                        int i7 = this.f;
                        this.f = i7 + 1;
                        char c2 = cArr2[i7];
                        iA3 = this.a.a(c2);
                        if (iA3 >= 0) {
                            throw f(c2, 1);
                        }
                        this.c = (this.c << 6) | iA3;
                        if (this.f < this.g && !i()) {
                            this.b = 2;
                            break;
                        } else {
                            char[] cArr3 = this.e;
                            int i8 = this.f;
                            this.f = i8 + 1;
                            char c3 = cArr3[i8];
                            iA2 = this.a.a(c3);
                            if (iA2 < 0) {
                                this.c = (this.c << 6) | iA2;
                                if (this.f < this.g && !i()) {
                                    this.b = 3;
                                    break;
                                } else {
                                    char[] cArr4 = this.e;
                                    int i9 = this.f;
                                    this.f = i9 + 1;
                                    char c4 = cArr4[i9];
                                    iA = this.a.a(c4);
                                    if (iA < 0) {
                                        this.c = (this.c << 6) | iA;
                                        if (i5 < i4) {
                                            this.b = 4;
                                            break;
                                        } else {
                                            bArr[i5] = (byte) (this.c >> 16);
                                            i5++;
                                            if (i5 < i4) {
                                                this.b = 5;
                                                break;
                                            } else {
                                                bArr[i5] = (byte) (this.c >> 8);
                                                i5++;
                                                if (i5 < i4) {
                                                    this.b = 6;
                                                    break;
                                                } else {
                                                    bArr[i5] = (byte) this.c;
                                                    this.b = 0;
                                                    i5++;
                                                }
                                            }
                                        }
                                    } else {
                                        if (iA != -2) {
                                            throw f(c4, 3);
                                        }
                                        this.c >>= 2;
                                        this.b = 5;
                                    }
                                }
                            } else {
                                if (iA2 != -2) {
                                    throw f(c3, 2);
                                }
                                this.b = 7;
                            }
                        }
                    }
                    break;
                case 1:
                    if (this.f < this.g) {
                        break;
                    }
                    char[] cArr22 = this.e;
                    int i72 = this.f;
                    this.f = i72 + 1;
                    char c22 = cArr22[i72];
                    iA3 = this.a.a(c22);
                    if (iA3 >= 0) {
                    }
                    break;
                case 2:
                    if (this.f < this.g) {
                        break;
                    }
                    char[] cArr32 = this.e;
                    int i82 = this.f;
                    this.f = i82 + 1;
                    char c32 = cArr32[i82];
                    iA2 = this.a.a(c32);
                    if (iA2 < 0) {
                    }
                    break;
                case 3:
                    if (this.f < this.g) {
                        break;
                    }
                    char[] cArr42 = this.e;
                    int i92 = this.f;
                    this.f = i92 + 1;
                    char c42 = cArr42[i92];
                    iA = this.a.a(c42);
                    if (iA < 0) {
                    }
                    break;
                case 4:
                    if (i5 < i4) {
                    }
                    break;
                case 5:
                    if (i5 < i4) {
                    }
                    break;
                case 6:
                    if (i5 < i4) {
                    }
                    break;
                case 7:
                    if (this.f >= this.g && !i()) {
                        break;
                    } else {
                        char[] cArr5 = this.e;
                        int i10 = this.f;
                        this.f = i10 + 1;
                        char c5 = cArr5[i10];
                        if (!this.a.d(c5)) {
                            throw g(c5, 3, "expected padding character '" + this.a.b() + "'");
                        }
                        this.b = 6;
                        this.c >>= 4;
                    }
                    break;
                default:
                    throw new IllegalStateException("Illegal internal state " + this.b);
            }
        }
        return i5 - i2;
    }

    public void h(n.b.a.n.a aVar, boolean z, char[] cArr, int i2, int i3, List<char[]> list) {
        this.a = aVar;
        if (z) {
            this.b = 0;
        }
        this.f2545h.clear();
        if (list == null || list.isEmpty()) {
            this.e = cArr;
            this.f = i2;
            this.g = i2 + i3;
        } else {
            if (cArr == null) {
                throw new IllegalArgumentException();
            }
            Iterator<char[]> it = list.iterator();
            char[] next = it.next();
            this.e = next;
            this.f = 0;
            this.g = next.length;
            while (it.hasNext()) {
                this.f2545h.add(it.next());
            }
            this.f2548k = 0;
            this.f2545h.add(cArr);
            this.f2546i = i2;
            this.f2547j = i2 + i3;
        }
    }
}
