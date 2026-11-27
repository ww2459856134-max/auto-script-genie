package com.frame;

import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.frame.w0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class f0 implements w0.a {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Runnable d;

    f0(g0 g0Var, AtomicReference atomicReference, String str, boolean z, Runnable runnable) {
        this.a = atomicReference;
        this.b = str;
        this.c = z;
        this.d = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        w0.b().i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        w0.b().i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        w0.b().i(this);
    }

    @Override // com.frame.w0.a
    public void a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            try {
                if (!q1.l(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString()) || TextUtils.isEmpty((CharSequence) this.a.get()) || accessibilityEvent.getPackageName().toString().equals(this.a.get())) {
                    return;
                }
                l1.e(new Runnable() { // from class: com.frame.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.c();
                    }
                });
                return;
            } catch (Exception e) {
                k0.r(e);
                return;
            }
        }
        if (accessibilityEvent.getEventType() == 1) {
            l1.e(new Runnable() { // from class: com.frame.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.e();
                }
            });
            return;
        }
        if (accessibilityEvent.getEventType() == 4096) {
            Log.e("scroll", "already scroll:" + this.b);
            l1.e(new Runnable() { // from class: com.frame.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g();
                }
            });
            if (this.c) {
                l1.g(this.d);
            }
        }
    }
}
