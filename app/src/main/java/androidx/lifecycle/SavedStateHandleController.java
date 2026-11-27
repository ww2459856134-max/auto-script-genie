package androidx.lifecycle;

import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements g {
    private final String a;
    private boolean b;
    private final s c;

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.c cVar) throws NoSuchMethodException, SecurityException {
            if (!(cVar instanceof w)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            v vVarF = ((w) cVar).f();
            SavedStateRegistry savedStateRegistryB = cVar.b();
            Iterator<String> it = vVarF.c().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.h(vVarF.b(it.next()), savedStateRegistryB, cVar.o());
            }
            if (vVarF.c().isEmpty()) {
                return;
            }
            savedStateRegistryB.e(a.class);
        }
    }

    static void h(t tVar, SavedStateRegistry savedStateRegistry, f fVar) throws NoSuchMethodException, SecurityException {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) tVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.i(savedStateRegistry, fVar);
        k(savedStateRegistry, fVar);
    }

    private static void k(final SavedStateRegistry savedStateRegistry, final f fVar) throws NoSuchMethodException, SecurityException {
        f.b bVarB = fVar.b();
        if (bVarB == f.b.INITIALIZED || bVarB.a(f.b.STARTED)) {
            savedStateRegistry.e(a.class);
        } else {
            fVar.a(new g() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.g
                public void a(i iVar, f.a aVar) throws NoSuchMethodException, SecurityException {
                    if (aVar == f.a.ON_START) {
                        fVar.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        }
    }

    @Override // androidx.lifecycle.g
    public void a(i iVar, f.a aVar) {
        if (aVar == f.a.ON_DESTROY) {
            this.b = false;
            iVar.o().c(this);
        }
    }

    void i(SavedStateRegistry savedStateRegistry, f fVar) {
        if (this.b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.b = true;
        fVar.a(this);
        savedStateRegistry.d(this.a, this.c.a());
    }

    boolean j() {
        return this.b;
    }
}
