package com.google.gson;

/* loaded from: classes.dex */
public interface b0 {

    public enum a {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    a a(Class<?> cls);
}
