package com.airbnb.lottie.y0;

import android.util.Log;
import com.airbnb.lottie.h0;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements h0 {
    private static final Set<String> a = new HashSet();

    @Override // com.airbnb.lottie.h0
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.h0
    public void b(String str, Throwable th) {
        Set<String> set = a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void c(String str, Throwable th) {
        if (com.airbnb.lottie.c.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.h0
    public void debug(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.h0
    public void error(String str, Throwable th) {
        if (com.airbnb.lottie.c.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
