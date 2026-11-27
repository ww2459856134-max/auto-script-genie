package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class a0 {
    public static final a0 c;
    public static final a0 d;
    private static final /* synthetic */ a0[] e;

    static {
        y yVar = new y("DEFAULT", 0);
        c = yVar;
        final String str = "STRING";
        final int i2 = 1;
        a0 a0Var = new a0(str, i2) { // from class: com.google.gson.z
            {
                y yVar2 = null;
            }
        };
        d = a0Var;
        e = new a0[]{yVar, a0Var};
    }

    private a0(String str, int i2) {
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) e.clone();
    }

    /* synthetic */ a0(String str, int i2, y yVar) {
        this(str, i2);
    }
}
