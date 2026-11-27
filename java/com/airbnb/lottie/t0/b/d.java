package com.airbnb.lottie.t0.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {
    private List<w> a = new ArrayList();

    void a(w wVar) {
        this.a.add(wVar);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.y0.h.b(path, this.a.get(size));
        }
    }
}
