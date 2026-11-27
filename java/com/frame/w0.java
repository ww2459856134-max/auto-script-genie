package com.frame;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class w0 extends AccessibilityService {
    protected static w0 d;
    protected static Runnable e;
    protected HashSet<a> c;

    public interface a {
        void a(AccessibilityEvent accessibilityEvent);
    }

    public static w0 b() {
        return d;
    }

    public static boolean d() {
        return d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(a aVar) {
        try {
            this.c.add(aVar);
        } catch (Exception e2) {
            y0.l(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(a aVar) {
        try {
            this.c.remove(aVar);
        } catch (Exception e2) {
            y0.l(e2);
            k0.r(e2);
        }
    }

    public static void j(Runnable runnable) {
        e = runnable;
    }

    public void a(final a aVar) {
        if (this.c == null) {
            this.c = new HashSet<>();
        }
        if (aVar != null) {
            l1.e(new Runnable() { // from class: com.frame.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.f(aVar);
                }
            });
        }
    }

    public AccessibilityNodeInfo c() {
        return getRootInActiveWindow();
    }

    public void i(final a aVar) {
        if (this.c != null) {
            l1.e(new Runnable() { // from class: com.frame.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.h(aVar);
                }
            });
        }
    }

    public abstract void k();

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        HashSet<a> hashSet;
        if (accessibilityEvent.getPackageName() == null || (hashSet = this.c) == null) {
            return;
        }
        try {
            Iterator<a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a(accessibilityEvent);
            }
        } catch (Exception e2) {
            k0.r(e2);
            if (v0.g().l()) {
                k0.r(e2);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        HashSet<a> hashSet = this.c;
        if (hashSet != null) {
            hashSet.clear();
            this.c = null;
        }
        d = null;
        y0.j("IAccessibility.onDestroy()");
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected boolean onKeyEvent(KeyEvent keyEvent) {
        return super.onKeyEvent(keyEvent);
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        d = this;
        super.onServiceConnected();
        if (v0.g().l()) {
            Runnable runnable = e;
            if (runnable != null) {
                runnable.run();
                e = null;
            }
            y0.j("IAccessibility.onServiceConnected()");
        }
    }
}
