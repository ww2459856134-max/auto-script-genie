package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements g {
    private final c a;

    static final class a implements SavedStateRegistry.b {
        final Set<String> a = new HashSet();

        a(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.d("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.a));
            return bundle;
        }

        void b(String str) {
            this.a.add(str);
        }
    }

    Recreator(c cVar) {
        this.a = cVar;
    }

    private void h(String str) throws NoSuchMethodException, SecurityException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    @Override // androidx.lifecycle.g
    public void a(i iVar, f.a aVar) throws NoSuchMethodException, SecurityException {
        if (aVar != f.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        iVar.o().c(this);
        Bundle bundleA = this.a.b().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }
}
