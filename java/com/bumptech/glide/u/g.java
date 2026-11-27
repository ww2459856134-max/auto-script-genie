package com.bumptech.glide.u;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
class g extends ByteArrayOutputStream {
    final /* synthetic */ h c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(h hVar, int i2) {
        super(i2);
        this.c = hVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
            i2--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i2, this.c.d.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
