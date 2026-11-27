package com.google.gson.l0;

import com.google.gson.internal.b0;
import java.io.IOException;

/* loaded from: classes.dex */
class a extends b0 {
    a() {
    }

    @Override // com.google.gson.internal.b0
    public void a(b bVar) throws IOException {
        int i2 = bVar.f761j;
        if (i2 == 0) {
            i2 = bVar.i();
        }
        if (i2 == 13) {
            bVar.f761j = 9;
            return;
        }
        if (i2 == 12) {
            bVar.f761j = 8;
            return;
        }
        if (i2 == 14) {
            bVar.f761j = 10;
            return;
        }
        throw new IllegalStateException("Expected a name but was " + bVar.L() + bVar.x());
    }
}
