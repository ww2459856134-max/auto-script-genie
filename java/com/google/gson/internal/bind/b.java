package com.google.gson.internal.bind;

import com.google.gson.l0.d;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b extends d {
    private static final Writer I = new a();
    private static final u J = new u("closed");
    private final List<p> D;
    private String G;
    private p H;

    public b() {
        super(I);
        this.D = new ArrayList();
        this.H = r.a;
    }

    private p R() {
        return this.D.get(r0.size() - 1);
    }

    private void S(p pVar) {
        if (this.G != null) {
            if (!pVar.h() || n()) {
                ((s) R()).l(this.G, pVar);
            }
            this.G = null;
            return;
        }
        if (this.D.isEmpty()) {
            this.H = pVar;
            return;
        }
        p pVarR = R();
        if (!(pVarR instanceof m)) {
            throw new IllegalStateException();
        }
        ((m) pVarR).l(pVar);
    }

    @Override // com.google.gson.l0.d
    public d J(double d) throws IOException {
        if (p() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            S(new u(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    @Override // com.google.gson.l0.d
    public d K(long j2) throws IOException {
        S(new u(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.l0.d
    public d L(Boolean bool) throws IOException {
        if (bool == null) {
            w();
            return this;
        }
        S(new u(bool));
        return this;
    }

    @Override // com.google.gson.l0.d
    public d M(Number number) throws IOException {
        if (number == null) {
            w();
            return this;
        }
        if (!p()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        S(new u(number));
        return this;
    }

    @Override // com.google.gson.l0.d
    public d N(String str) throws IOException {
        if (str == null) {
            w();
            return this;
        }
        S(new u(str));
        return this;
    }

    @Override // com.google.gson.l0.d
    public d O(boolean z) throws IOException {
        S(new u(Boolean.valueOf(z)));
        return this;
    }

    public p Q() {
        if (this.D.isEmpty()) {
            return this.H;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.D);
    }

    @Override // com.google.gson.l0.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.D.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.D.add(J);
    }

    @Override // com.google.gson.l0.d
    public d d() throws IOException {
        m mVar = new m();
        S(mVar);
        this.D.add(mVar);
        return this;
    }

    @Override // com.google.gson.l0.d
    public d f() throws IOException {
        s sVar = new s();
        S(sVar);
        this.D.add(sVar);
        return this;
    }

    @Override // com.google.gson.l0.d, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.l0.d
    public d j() throws IOException {
        if (this.D.isEmpty() || this.G != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof m)) {
            throw new IllegalStateException();
        }
        this.D.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.l0.d
    public d m() throws IOException {
        if (this.D.isEmpty() || this.G != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof s)) {
            throw new IllegalStateException();
        }
        this.D.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.l0.d
    public d s(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.D.isEmpty() || this.G != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof s)) {
            throw new IllegalStateException();
        }
        this.G = str;
        return this;
    }

    @Override // com.google.gson.l0.d
    public d w() throws IOException {
        S(r.a);
        return this;
    }
}
