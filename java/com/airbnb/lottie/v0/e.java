package com.airbnb.lottie.v0;

import com.airbnb.lottie.v0.l.q;
import java.util.List;

/* loaded from: classes.dex */
public class e {
    private final List<q> a;
    private final char b;
    private final double c;
    private final String d;
    private final String e;

    public e(List<q> list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d2;
        this.d = str;
        this.e = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<q> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return c(this.b, this.e, this.d);
    }
}
