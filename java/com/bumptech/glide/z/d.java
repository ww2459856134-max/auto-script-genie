package com.bumptech.glide.z;

/* loaded from: classes.dex */
public enum d {
    RUNNING(false),
    PAUSED(false),
    CLEARED(false),
    SUCCESS(true),
    FAILED(true);

    private final boolean c;

    d(boolean z) {
        this.c = z;
    }

    boolean a() {
        return this.c;
    }
}
