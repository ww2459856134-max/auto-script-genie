package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.g0;
import com.google.gson.h0;
import com.google.gson.i0;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import com.google.gson.x;
import java.io.IOException;

/* loaded from: classes.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final i0 b = f(g0.d);
    private final h0 a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NumberTypeAdapter(h0 h0Var) {
        this.a = h0Var;
    }

    public static i0 e(h0 h0Var) {
        return h0Var == g0.d ? b : f(h0Var);
    }

    private static i0 f(h0 h0Var) {
        return new i0() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                if (aVar.d() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(com.google.gson.l0.b bVar) throws IOException {
        c cVarL = bVar.L();
        int i2 = a.a[cVarL.ordinal()];
        if (i2 == 1) {
            bVar.H();
            return null;
        }
        if (i2 == 2 || i2 == 3) {
            return this.a.a(bVar);
        }
        throw new x("Expecting number, got: " + cVarL + "; at path " + bVar.o());
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Number number) throws IOException {
        dVar.M(number);
    }
}
