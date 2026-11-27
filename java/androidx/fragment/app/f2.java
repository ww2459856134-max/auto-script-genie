package androidx.fragment.app;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f2 {
    int b;
    int c;
    int d;
    int e;
    int f;
    boolean g;

    /* renamed from: h, reason: collision with root package name */
    String f251h;

    /* renamed from: i, reason: collision with root package name */
    int f252i;

    /* renamed from: j, reason: collision with root package name */
    CharSequence f253j;

    /* renamed from: k, reason: collision with root package name */
    int f254k;

    /* renamed from: l, reason: collision with root package name */
    CharSequence f255l;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<String> f256m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<String> f257n;
    ArrayList<Runnable> p;
    ArrayList<e2> a = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    boolean f258o = false;

    f2(r0 r0Var, ClassLoader classLoader) {
    }

    public f2 b(int i2, Fragment fragment, String str) {
        m(i2, fragment, str, 1);
        return this;
    }

    f2 c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.g0 = viewGroup;
        b(viewGroup.getId(), fragment, str);
        return this;
    }

    public f2 d(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    void e(e2 e2Var) {
        this.a.add(e2Var);
        e2Var.c = this.b;
        e2Var.d = this.c;
        e2Var.e = this.d;
        e2Var.f = this.e;
    }

    public f2 f(Fragment fragment) {
        e(new e2(7, fragment));
        return this;
    }

    public abstract int g();

    public abstract int h();

    public abstract void i();

    public abstract void j();

    public f2 k(Fragment fragment) {
        e(new e2(6, fragment));
        return this;
    }

    public f2 l() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    void m(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.W;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.W + " now " + str);
            }
            fragment.W = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.U;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.U + " now " + i2);
            }
            fragment.U = i2;
            fragment.V = i2;
        }
        e(new e2(i3, fragment));
    }

    public f2 n(Fragment fragment) {
        e(new e2(3, fragment));
        return this;
    }

    public f2 o(int i2, Fragment fragment) {
        p(i2, fragment, null);
        return this;
    }

    public f2 p(int i2, Fragment fragment, String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m(i2, fragment, str, 2);
        return this;
    }

    public f2 q(boolean z) {
        this.f258o = z;
        return this;
    }
}
