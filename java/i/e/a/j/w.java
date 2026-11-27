package i.e.a.j;

/* loaded from: classes.dex */
public final class w extends v {
    protected final int e;

    public w(String str, String str2, String str3, int i2) {
        super(str, str2, str3);
        this.e = i2;
    }

    public static int t(String str) {
        int iCharAt = str.charAt(0);
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            iCharAt = (iCharAt * 31) + str.charAt(i2);
        }
        return iCharAt;
    }

    public static w u(String str) {
        return v(str, t(str));
    }

    public static w v(String str, int i2) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? new w(str, null, str, i2) : new w(str, str.substring(0, iIndexOf).intern(), str.substring(iIndexOf + 1).intern(), i2);
    }

    @Override // i.e.a.j.v
    public v g(q qVar) {
        w wVar = new w(this.a, this.b, this.c, this.e);
        wVar.d = qVar;
        return wVar;
    }

    @Override // i.e.a.j.v
    public final int h() {
        i.e.a.i.b.a();
        throw null;
    }

    public int hashCode() {
        return this.e;
    }

    @Override // i.e.a.j.v
    public int m(int i2) {
        i.e.a.i.b.a();
        throw null;
    }

    @Override // i.e.a.j.v
    public int q() {
        i.e.a.i.b.a();
        throw null;
    }

    public boolean w(char[] cArr, int i2, int i3, int i4) {
        if (i4 != this.e) {
            return false;
        }
        String str = this.a;
        if (i3 != str.length()) {
            return false;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            if (cArr[i2 + i5] != str.charAt(i5)) {
                return false;
            }
        }
        return true;
    }

    public int x() {
        return this.e;
    }
}
