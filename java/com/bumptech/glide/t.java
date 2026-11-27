package com.bumptech.glide;

import com.bumptech.glide.t;

/* loaded from: classes.dex */
public abstract class t<CHILD extends t<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private com.bumptech.glide.z.m.e<? super TranscodeType> c = com.bumptech.glide.z.m.b.b();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    final com.bumptech.glide.z.m.e<? super TranscodeType> b() {
        return this.c;
    }
}
