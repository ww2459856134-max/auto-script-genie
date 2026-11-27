package com.bumptech.glide.w;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
class m implements q {
    final /* synthetic */ n a;

    m(n nVar) {
        this.a = nVar;
    }

    @Override // com.bumptech.glide.w.q
    public Set<com.bumptech.glide.s> a() {
        Set<n> setB = this.a.b();
        HashSet hashSet = new HashSet(setB.size());
        for (n nVar : setB) {
            if (nVar.e() != null) {
                hashSet.add(nVar.e());
            }
        }
        return hashSet;
    }

    public String toString() {
        return super.toString() + "{fragment=" + this.a + "}";
    }
}
