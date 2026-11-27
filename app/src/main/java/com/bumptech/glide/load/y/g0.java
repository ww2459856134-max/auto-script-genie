package com.bumptech.glide.load.y;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
final class g0 implements e0 {
    private final String a;

    g0(String str) {
        this.a = str;
    }

    @Override // com.bumptech.glide.load.y.e0
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g0) {
            return this.a.equals(((g0) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "StringHeaderFactory{value='" + this.a + Chars.QUOTE + '}';
    }
}
