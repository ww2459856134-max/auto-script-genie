package com.bumptech.glide.load.x.h1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class t implements com.bumptech.glide.b0.q.d<u> {
    t(v vVar) {
    }

    @Override // com.bumptech.glide.b0.q.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u a() {
        try {
            return new u(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
