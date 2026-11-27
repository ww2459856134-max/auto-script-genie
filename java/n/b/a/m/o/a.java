package n.b.a.m.o;

import n.b.a.m.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class a {
    n.b.a.n.a a;
    int c;
    int b = 0;
    i.a d = null;

    protected a() {
    }

    public abstract int a(byte[] bArr, int i2, int i3) throws IllegalArgumentException;

    public byte[] b() throws IllegalArgumentException {
        i.a aVarD = d();
        byte[] bArrC = aVarD.c();
        while (true) {
            int i2 = 0;
            int length = bArrC.length;
            do {
                int iA = a(bArrC, i2, length);
                if (iA < 1) {
                    int iC = c();
                    if (iC < 0) {
                        throw new IllegalArgumentException("Incomplete base64 triplet at the end of decoded content");
                    }
                    if (iC <= 0) {
                        return aVarD.b(bArrC, i2);
                    }
                } else {
                    i2 += iA;
                    length -= iA;
                }
            } while (length > 0);
            bArrC = aVarD.a(bArrC);
        }
    }

    public int c() {
        int i2 = this.b;
        if (i2 == 0 || i2 == 4 || i2 == 5 || i2 == 6) {
            return 0;
        }
        if (this.a.c()) {
            return -1;
        }
        int i3 = this.b;
        if (i3 == 2) {
            this.b = 6;
            this.c >>= 4;
            return 1;
        }
        if (i3 != 3) {
            return -1;
        }
        this.c >>= 2;
        this.b = 5;
        return 2;
    }

    public i.a d() {
        if (this.d == null) {
            this.d = new i.a();
        }
        return this.d;
    }

    public boolean e() {
        int i2 = this.b;
        return i2 >= 4 && i2 <= 6;
    }

    protected IllegalArgumentException f(char c, int i2) throws IllegalArgumentException {
        return g(c, i2, null);
    }

    protected IllegalArgumentException g(char c, int i2, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (this.a.d(c)) {
            str2 = "Unexpected padding character ('" + this.a.b() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }
}
