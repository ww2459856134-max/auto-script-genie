package com.google.gson.internal;

import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class t0 {
    public static com.google.gson.p a(com.google.gson.l0.b bVar) throws com.google.gson.t {
        boolean z;
        try {
            try {
                bVar.L();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return TypeAdapters.V.b(bVar);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return com.google.gson.r.a;
                }
                throw new com.google.gson.x(e);
            }
        } catch (com.google.gson.l0.e e3) {
            throw new com.google.gson.x(e3);
        } catch (IOException e4) {
            throw new com.google.gson.q(e4);
        } catch (NumberFormatException e5) {
            throw new com.google.gson.x(e5);
        }
    }

    public static void b(com.google.gson.p pVar, com.google.gson.l0.d dVar) throws IOException {
        TypeAdapters.V.d(dVar, pVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new s0(appendable);
    }
}
