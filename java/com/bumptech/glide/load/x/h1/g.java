package com.bumptech.glide.load.x.h1;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class g {
    private final Map<String, e> a = new HashMap();
    private final f b = new f();

    g() {
    }

    void a(String str) {
        e eVarA;
        synchronized (this) {
            eVarA = this.a.get(str);
            if (eVarA == null) {
                eVarA = this.b.a();
                this.a.put(str, eVarA);
            }
            eVarA.b++;
        }
        eVarA.a.lock();
    }

    void b(String str) {
        e eVar;
        synchronized (this) {
            e eVar2 = this.a.get(str);
            com.bumptech.glide.b0.n.d(eVar2);
            eVar = eVar2;
            int i2 = eVar.b;
            if (i2 < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + eVar.b);
            }
            int i3 = i2 - 1;
            eVar.b = i3;
            if (i3 == 0) {
                e eVarRemove = this.a.remove(str);
                if (!eVarRemove.equals(eVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + eVar + ", but actually removed: " + eVarRemove + ", safeKey: " + str);
                }
                this.b.b(eVarRemove);
            }
        }
        eVar.a.unlock();
    }
}
