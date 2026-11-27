package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.n;
import androidx.lifecycle.f;
import androidx.lifecycle.r;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class ComponentActivity extends n implements androidx.lifecycle.i, w, androidx.savedstate.c, k, androidx.activity.result.h {
    private v g;

    /* renamed from: i, reason: collision with root package name */
    private int f1i;
    final androidx.activity.l.a d = new androidx.activity.l.a();
    private final androidx.lifecycle.k e = new androidx.lifecycle.k(this);
    final androidx.savedstate.b f = androidx.savedstate.b.a(this);

    /* renamed from: h, reason: collision with root package name */
    private final OnBackPressedDispatcher f0h = new OnBackPressedDispatcher(new b(this));

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f2j = new AtomicInteger();

    /* renamed from: k, reason: collision with root package name */
    private final ActivityResultRegistry f3k = new e(this);

    public ComponentActivity() {
        if (o() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            o().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.g
                public void a(androidx.lifecycle.i iVar, f.a aVar) {
                    if (aVar == f.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        o().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.g
            public void a(androidx.lifecycle.i iVar, f.a aVar) {
                if (aVar == f.a.ON_DESTROY) {
                    ComponentActivity.this.d.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.f().a();
                }
            }
        });
        o().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.g
            public void a(androidx.lifecycle.i iVar, f.a aVar) {
                ComponentActivity.this.s();
                ComponentActivity.this.o().c(this);
            }
        });
        if (19 <= i2 && i2 <= 23) {
            o().a(new ImmLeaksCleaner(this));
        }
        b().d("android:support:activity-result", new f(this));
        r(new g(this));
    }

    @Override // androidx.savedstate.c
    public final SavedStateRegistry b() {
        return this.f.b();
    }

    @Override // androidx.activity.result.h
    public final ActivityResultRegistry e() {
        return this.f3k;
    }

    @Override // androidx.lifecycle.w
    public v f() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        s();
        return this.g;
    }

    @Override // androidx.activity.k
    public final OnBackPressedDispatcher k() {
        return this.f0h;
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.f o() {
        return this.e;
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (this.f3k.b(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f0h.c();
    }

    @Override // androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f.c(bundle);
        this.d.c(this);
        super.onCreate(bundle);
        r.f(this);
        int i2 = this.f1i;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.f3k.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        h hVar;
        Object objT = t();
        v vVar = this.g;
        if (vVar == null && (hVar = (h) getLastNonConfigurationInstance()) != null) {
            vVar = hVar.b;
        }
        if (vVar == null && objT == null) {
            return null;
        }
        h hVar2 = new h();
        hVar2.a = objT;
        hVar2.b = vVar;
        return hVar2;
    }

    @Override // androidx.core.app.n, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.f fVarO = o();
        if (fVarO instanceof androidx.lifecycle.k) {
            ((androidx.lifecycle.k) fVarO).o(f.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f.d(bundle);
    }

    public final void r(androidx.activity.l.b bVar) {
        this.d.a(bVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (h.o.a.d()) {
                h.o.a.a("reportFullyDrawn() for " + getComponentName());
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 19) {
                super.reportFullyDrawn();
            } else if (i2 == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            h.o.a.b();
        }
    }

    void s() {
        if (this.g == null) {
            h hVar = (h) getLastNonConfigurationInstance();
            if (hVar != null) {
                this.g = hVar.b;
            }
            if (this.g == null) {
                this.g = new v();
            }
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public abstract void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view);

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Deprecated
    public Object t() {
        return null;
    }

    public final <I, O> androidx.activity.result.d<I> u(androidx.activity.result.l.b<I, O> bVar, androidx.activity.result.c<O> cVar) {
        return v(bVar, this.f3k, cVar);
    }

    public final <I, O> androidx.activity.result.d<I> v(androidx.activity.result.l.b<I, O> bVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.c<O> cVar) {
        return activityResultRegistry.j("activity_rq#" + this.f2j.getAndIncrement(), this, bVar, cVar);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
