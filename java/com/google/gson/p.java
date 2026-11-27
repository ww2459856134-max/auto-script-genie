package com.google.gson;

import com.google.gson.internal.t0;
import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class p {
    @Deprecated
    public p() {
    }

    public m a() {
        if (g()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public s b() {
        if (j()) {
            return (s) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public u e() {
        if (k()) {
            return (u) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean g() {
        return this instanceof m;
    }

    public boolean h() {
        return this instanceof r;
    }

    public boolean j() {
        return this instanceof s;
    }

    public boolean k() {
        return this instanceof u;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.l0.d dVar = new com.google.gson.l0.d(stringWriter);
            dVar.G(true);
            t0.b(this, dVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
