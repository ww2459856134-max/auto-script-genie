package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements com.google.gson.i0, Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public static final Excluder f731i = new Excluder();
    private boolean f;
    private double c = -1.0d;
    private int d = 136;
    private boolean e = true;
    private List<com.google.gson.a> g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private List<com.google.gson.a> f732h = Collections.emptyList();

    private boolean d(Class<?> cls) {
        if (this.c != -1.0d && !l((com.google.gson.j0.d) cls.getAnnotation(com.google.gson.j0.d.class), (com.google.gson.j0.e) cls.getAnnotation(com.google.gson.j0.e.class))) {
            return true;
        }
        if (this.e || !h(cls)) {
            return g(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z) {
        Iterator<com.google.gson.a> it = (z ? this.g : this.f732h).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean h(Class<?> cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean j(com.google.gson.j0.d dVar) {
        if (dVar != null) {
            return this.c >= dVar.value();
        }
        return true;
    }

    private boolean k(com.google.gson.j0.e eVar) {
        if (eVar != null) {
            return this.c < eVar.value();
        }
        return true;
    }

    private boolean l(com.google.gson.j0.d dVar, com.google.gson.j0.e eVar) {
        return j(dVar) && k(eVar);
    }

    @Override // com.google.gson.i0
    public <T> TypeAdapter<T> a(final Gson gson, final com.google.gson.k0.a<T> aVar) {
        Class<? super T> clsD = aVar.d();
        boolean zD = d(clsD);
        final boolean z = zD || e(clsD, true);
        final boolean z2 = zD || e(clsD, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
                private TypeAdapter<T> a;

                private TypeAdapter<T> e() {
                    TypeAdapter<T> typeAdapter = this.a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> typeAdapterN = gson.n(Excluder.this, aVar);
                    this.a = typeAdapterN;
                    return typeAdapterN;
                }

                @Override // com.google.gson.TypeAdapter
                public T b(com.google.gson.l0.b bVar) throws IOException {
                    if (!z2) {
                        return e().b(bVar);
                    }
                    bVar.V();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void d(com.google.gson.l0.d dVar, T t) throws IOException {
                    if (z) {
                        dVar.w();
                    } else {
                        e().d(dVar, t);
                    }
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean c(Class<?> cls, boolean z) {
        return d(cls) || e(cls, z);
    }

    public boolean f(Field field, boolean z) {
        com.google.gson.j0.a aVar;
        if ((this.d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.c != -1.0d && !l((com.google.gson.j0.d) field.getAnnotation(com.google.gson.j0.d.class), (com.google.gson.j0.e) field.getAnnotation(com.google.gson.j0.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f && ((aVar = (com.google.gson.j0.a) field.getAnnotation(com.google.gson.j0.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.e && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z ? this.g : this.f732h;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
