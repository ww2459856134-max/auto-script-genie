package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private Random a = new Random();
    private final Map<Integer, String> b = new HashMap();
    final Map<String, Integer> c = new HashMap();
    private final Map<String, g> d = new HashMap();
    ArrayList<String> e = new ArrayList<>();
    final transient Map<String, a<?>> f = new HashMap();
    final Map<String, Object> g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f5h = new Bundle();

    private static class a<O> {
        final c<O> a;
        final androidx.activity.result.l.b<?, O> b;

        a(c<O> cVar, androidx.activity.result.l.b<?, O> bVar) {
            this.a = cVar;
            this.b = bVar;
        }
    }

    private void a(int i2, String str) {
        this.b.put(Integer.valueOf(i2), str);
        this.c.put(str, Integer.valueOf(i2));
    }

    private <O> void d(String str, int i2, Intent intent, a<O> aVar) {
        c<O> cVar;
        if (aVar != null && (cVar = aVar.a) != null) {
            cVar.a(aVar.b.c(i2, intent));
        } else {
            this.g.remove(str);
            this.f5h.putParcelable(str, new b(i2, intent));
        }
    }

    private int e() {
        int iNextInt = this.a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (!this.b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            iNextInt = this.a.nextInt(2147418112);
        }
    }

    private int k(String str) {
        Integer num = this.c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iE = e();
        a(iE, str);
        return iE;
    }

    public final boolean b(int i2, int i3, Intent intent) {
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.e.remove(str);
        d(str, i3, intent, this.f.get(str));
        return true;
    }

    public final <O> boolean c(int i2, @SuppressLint({"UnknownNullness"}) O o2) {
        c<?> cVar;
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.e.remove(str);
        a<?> aVar = this.f.get(str);
        if (aVar != null && (cVar = aVar.a) != null) {
            cVar.a(o2);
            return true;
        }
        this.f5h.remove(str);
        this.g.put(str, o2);
        return true;
    }

    public abstract <I, O> void f(int i2, androidx.activity.result.l.b<I, O> bVar, @SuppressLint({"UnknownNullness"}) I i3, androidx.core.app.g gVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f5h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str = stringArrayList.get(i2);
            if (this.c.containsKey(str)) {
                Integer numRemove = this.c.remove(str);
                if (!this.f5h.containsKey(str)) {
                    this.b.remove(numRemove);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f5h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> d<I> i(String str, androidx.activity.result.l.b<I, O> bVar, c<O> cVar) {
        int iK = k(str);
        this.f.put(str, new a<>(cVar, bVar));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            cVar.a(obj);
        }
        b bVar2 = (b) this.f5h.getParcelable(str);
        if (bVar2 != null) {
            this.f5h.remove(str);
            cVar.a(bVar.c(bVar2.b(), bVar2.a()));
        }
        return new f(this, str, iK, bVar);
    }

    public final <I, O> d<I> j(final String str, androidx.lifecycle.i iVar, final androidx.activity.result.l.b<I, O> bVar, final c<O> cVar) {
        androidx.lifecycle.f fVarO = iVar.o();
        if (fVarO.b().a(f.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + iVar + " is attempting to register while current state is " + fVarO.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int iK = k(str);
        g gVar = this.d.get(str);
        if (gVar == null) {
            gVar = new g(fVarO);
        }
        gVar.a(new androidx.lifecycle.g() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.g
            public void a(androidx.lifecycle.i iVar2, f.a aVar) {
                if (!f.a.ON_START.equals(aVar)) {
                    if (f.a.ON_STOP.equals(aVar)) {
                        ActivityResultRegistry.this.f.remove(str);
                        return;
                    } else {
                        if (f.a.ON_DESTROY.equals(aVar)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f.put(str, new a<>(cVar, bVar));
                if (ActivityResultRegistry.this.g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.g.get(str);
                    ActivityResultRegistry.this.g.remove(str);
                    cVar.a(obj);
                }
                b bVar2 = (b) ActivityResultRegistry.this.f5h.getParcelable(str);
                if (bVar2 != null) {
                    ActivityResultRegistry.this.f5h.remove(str);
                    cVar.a(bVar.c(bVar2.b(), bVar2.a()));
                }
            }
        });
        this.d.put(str, gVar);
        return new e(this, str, iK, bVar);
    }

    final void l(String str) {
        Integer numRemove;
        if (!this.e.contains(str) && (numRemove = this.c.remove(str)) != null) {
            this.b.remove(numRemove);
        }
        this.f.remove(str);
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.get(str));
            this.g.remove(str);
        }
        if (this.f5h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f5h.getParcelable(str));
            this.f5h.remove(str);
        }
        g gVar = this.d.get(str);
        if (gVar != null) {
            gVar.b();
            this.d.remove(str);
        }
    }
}
