package com.google.gson;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class u extends p {
    private final Object a;

    public u(Boolean bool) {
        Objects.requireNonNull(bool);
        this.a = bool;
    }

    private static boolean u(u uVar) {
        Object obj = uVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.a == null) {
            return uVar.a == null;
        }
        if (u(this) && u(uVar)) {
            return p().longValue() == uVar.p().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(uVar.a instanceof Number)) {
            return obj2.equals(uVar.a);
        }
        double dDoubleValue = p().doubleValue();
        double dDoubleValue2 = uVar.p().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (u(this)) {
            jDoubleToLongBits = p().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(p().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean l() {
        return t() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(r());
    }

    public Number p() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new com.google.gson.internal.c0((String) this.a);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String r() {
        Object obj = this.a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (v()) {
            return p().toString();
        }
        if (t()) {
            return ((Boolean) this.a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.a.getClass());
    }

    public boolean t() {
        return this.a instanceof Boolean;
    }

    public boolean v() {
        return this.a instanceof Number;
    }

    public boolean w() {
        return this.a instanceof String;
    }

    public u(Number number) {
        Objects.requireNonNull(number);
        this.a = number;
    }

    public u(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }
}
