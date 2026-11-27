package com.google.gson;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class s extends p {
    private final com.google.gson.internal.f0<String, p> a = new com.google.gson.internal.f0<>(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof s) && ((s) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void l(String str, p pVar) {
        com.google.gson.internal.f0<String, p> f0Var = this.a;
        if (pVar == null) {
            pVar = r.a;
        }
        f0Var.put(str, pVar);
    }

    public Set<Map.Entry<String, p>> p() {
        return this.a.entrySet();
    }
}
