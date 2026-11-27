package com.frame;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class f1 implements SharedPreferences {
    public static int b = (int) (Runtime.getRuntime().maxMemory() / 20);
    private static LruCache<String, String> c = new d1(b);
    private static final String d = f1.class.getName();
    private SharedPreferences a;

    public f1(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            this.a = PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            this.a = context.getSharedPreferences(str, i2);
        }
    }

    private String c(String str, String str2) {
        try {
            String strB = n1.b(str);
            return strB == null ? str2 : strB;
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) throws Exception {
        if (str != null) {
            return n1.g(str);
        }
        return null;
    }

    public static f1 f(Context context, String str, int i2) {
        return new f1(context, str, i2);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (this.a.contains(str)) {
            return true;
        }
        for (byte[] bArr : n1.d) {
            String strJ = j(str, bArr);
            if (strJ != null && this.a.contains(strJ)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e1 edit() {
        return new e1(this, null);
    }

    public SharedPreferences g() {
        return this.a;
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = this.a.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (this.a.contains(str)) {
            return this.a.getBoolean(str, z);
        }
        try {
            return this.a.getBoolean(h(str), z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (this.a.contains(str)) {
            return this.a.getFloat(str, f);
        }
        try {
            return this.a.getFloat(h(str), f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        if (this.a.contains(str)) {
            return this.a.getInt(str, i2);
        }
        try {
            return this.a.getInt(h(str), i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        if (this.a.contains(str)) {
            return this.a.getLong(str, j2);
        }
        try {
            return this.a.getLong(h(str), j2);
        } catch (Exception unused) {
            return j2;
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.a.contains(str)) {
            String string = this.a.getString(str, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return n1.d(string, new byte[]{97, 50, 101, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
                } catch (Exception e) {
                    Log.e(d, "SharedPreferences decrypt failed, key=" + str, e);
                    return str2;
                }
            }
        }
        String string2 = this.a.getString(h(str), null);
        return string2 == null ? str2 : c(string2, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (this.a.contains(str)) {
            try {
                Set<String> stringSet = this.a.getStringSet(str, set);
                if (stringSet == null) {
                    return set;
                }
                HashSet hashSet = new HashSet();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    hashSet.add(c(it.next(), null));
                }
                return hashSet;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Set<String> stringSet2 = this.a.getStringSet(h(str), set);
        if (stringSet2 == null) {
            return set;
        }
        HashSet hashSet2 = new HashSet();
        Iterator<String> it2 = stringSet2.iterator();
        while (it2.hasNext()) {
            hashSet2.add(c(it2.next(), null));
        }
        return hashSet2;
    }

    public String h(String str) {
        String strE = c.get(str);
        if (strE != null) {
            return strE;
        }
        try {
            strE = e(str);
            c.put(str, strE);
            return strE;
        } catch (Exception e) {
            e.printStackTrace();
            return strE;
        }
    }

    public String i(String str, String str2) {
        try {
            return n1.h(str, str2).trim();
        } catch (Exception unused) {
            return null;
        }
    }

    public String j(String str, byte[] bArr) {
        try {
            return n1.i(str, bArr).trim();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
