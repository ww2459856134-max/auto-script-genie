package com.google.gson.internal;

/* loaded from: classes.dex */
class r0 implements CharSequence {
    private char[] c;
    private String d;

    private r0() {
    }

    void a(char[] cArr) {
        this.c = cArr;
        this.d = null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.c[i2];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return new String(this.c, i2, i3 - i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.d == null) {
            this.d = new String(this.c);
        }
        return this.d;
    }
}
