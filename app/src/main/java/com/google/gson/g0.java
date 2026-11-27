package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class g0 implements h0 {
    public static final g0 c;
    public static final g0 d;
    public static final g0 e;
    public static final g0 f;
    private static final /* synthetic */ g0[] g;

    static {
        c0 c0Var = new c0("DOUBLE", 0);
        c = c0Var;
        final String str = "LAZILY_PARSED_NUMBER";
        final int i2 = 1;
        g0 g0Var = new g0(str, i2) { // from class: com.google.gson.d0
            {
                c0 c0Var2 = null;
            }

            @Override // com.google.gson.h0
            public Number a(com.google.gson.l0.b bVar) throws IOException {
                return new com.google.gson.internal.c0(bVar.J());
            }
        };
        d = g0Var;
        final String str2 = "LONG_OR_DOUBLE";
        final int i3 = 2;
        g0 g0Var2 = new g0(str2, i3) { // from class: com.google.gson.e0
            {
                c0 c0Var2 = null;
            }

            @Override // com.google.gson.h0
            public Number a(com.google.gson.l0.b bVar) throws t, IOException, NumberFormatException {
                String strJ = bVar.J();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strJ));
                    } catch (NumberFormatException e2) {
                        throw new t("Cannot parse " + strJ + "; at path " + bVar.q(), e2);
                    }
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strJ);
                    if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || bVar.u()) {
                        return dValueOf;
                    }
                    throw new com.google.gson.l0.e("JSON forbids NaN and infinities: " + dValueOf + "; at path " + bVar.q());
                }
            }
        };
        e = g0Var2;
        final String str3 = "BIG_DECIMAL";
        final int i4 = 3;
        g0 g0Var3 = new g0(str3, i4) { // from class: com.google.gson.f0
            {
                c0 c0Var2 = null;
            }

            @Override // com.google.gson.h0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(com.google.gson.l0.b bVar) throws IOException {
                String strJ = bVar.J();
                try {
                    return new BigDecimal(strJ);
                } catch (NumberFormatException e2) {
                    throw new t("Cannot parse " + strJ + "; at path " + bVar.q(), e2);
                }
            }
        };
        f = g0Var3;
        g = new g0[]{c0Var, g0Var, g0Var2, g0Var3};
    }

    private g0(String str, int i2) {
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) g.clone();
    }

    /* synthetic */ g0(String str, int i2, c0 c0Var) {
        this(str, i2);
    }
}
