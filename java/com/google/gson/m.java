package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class m extends p implements Iterable<p> {
    private final ArrayList<p> c = new ArrayList<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).c.equals(this.c));
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<p> iterator() {
        return this.c.iterator();
    }

    public void l(p pVar) {
        if (pVar == null) {
            pVar = r.a;
        }
        this.c.add(pVar);
    }
}
