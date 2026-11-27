package com.frame;

import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class e1 implements SharedPreferences.Editor {
    private SharedPreferences.Editor a;
    final /* synthetic */ f1 b;

    /* synthetic */ e1(f1 f1Var, d1 d1Var) {
        this(f1Var);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.apply();
        } else {
            this.a.commit();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.a.clear();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.a.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        this.a.putBoolean(str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        this.a.putFloat(str, f);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        this.a.putInt(str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        this.a.putLong(str, j2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        try {
            this.a.putString(str, this.b.e(str2));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(this.b.e(it.next()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.a.putStringSet(str, hashSet);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.a.remove(str);
        for (byte[] bArr : n1.d) {
            this.a.remove(this.b.j(str, bArr));
        }
        return this;
    }

    private e1(f1 f1Var) {
        this.b = f1Var;
        this.a = f1Var.a.edit();
    }
}
