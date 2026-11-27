package com.jsj.autojs;

import android.app.Activity;
import android.os.Process;
import java.util.Stack;

/* loaded from: classes.dex */
public class g {
    private static Stack<Activity> a;
    private static g b;

    private g() {
    }

    public static g c() {
        if (b == null) {
            b = new g();
        }
        return b;
    }

    public void a() {
        try {
            b();
            System.exit(0);
            Process.killProcess(Process.myPid());
        } catch (Exception unused) {
        }
    }

    public void b() {
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (a.get(i2) != null) {
                a.get(i2).finish();
            }
        }
        a.clear();
    }
}
