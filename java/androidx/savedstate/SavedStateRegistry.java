package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.savedstate.Recreator;
import h.b.a.b.e;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private Bundle b;
    private boolean c;
    private Recreator.a d;
    private e<String, b> a = new e<>();
    boolean e = true;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (!this.c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.b.remove(str);
        if (this.b.isEmpty()) {
            this.b = null;
        }
        return bundle2;
    }

    void b(f fVar, Bundle bundle) {
        if (this.c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        fVar.a(new g() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.g
            public void a(i iVar, f.a aVar) {
                if (aVar == f.a.ON_START) {
                    SavedStateRegistry.this.e = true;
                } else if (aVar == f.a.ON_STOP) {
                    SavedStateRegistry.this.e = false;
                }
            }
        });
        this.c = true;
    }

    void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        e<String, b>.a aVarG = this.a.g();
        while (aVarG.hasNext()) {
            Map.Entry next = aVarG.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.a.k(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) throws NoSuchMethodException, SecurityException {
        if (!this.e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.d == null) {
            this.d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.d.b(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
