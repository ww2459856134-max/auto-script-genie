package com.bumptech.glide.y;

import com.bumptech.glide.load.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class i {
    private final List<h<?>> a = new ArrayList();

    public synchronized <Z> void a(Class<Z> cls, u<Z> uVar) {
        this.a.add(new h<>(cls, uVar));
    }

    public synchronized <Z> u<Z> b(Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            h<?> hVar = this.a.get(i2);
            if (hVar.a(cls)) {
                return (u<Z>) hVar.b;
            }
        }
        return null;
    }
}
