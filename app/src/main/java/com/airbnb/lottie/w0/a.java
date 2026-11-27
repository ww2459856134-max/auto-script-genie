package com.airbnb.lottie.w0;

/* loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");

    public final String c;

    a(String str) {
        this.c = str;
    }

    public String a() {
        return ".temp" + this.c;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }
}
