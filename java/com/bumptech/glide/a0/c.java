package com.bumptech.glide.a0;

import com.bumptech.glide.load.n;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c implements n {
    private static final c b = new c();

    private c() {
    }

    public static c c() {
        return b;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
