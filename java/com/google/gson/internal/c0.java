package com.google.gson.internal;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class c0 extends Number {
    private final String c;

    public c0(String str) {
        this.c = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        String str = this.c;
        String str2 = ((c0) obj).c;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.c);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.c);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.c).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.c);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.c).longValue();
        }
    }

    public String toString() {
        return this.c;
    }
}
