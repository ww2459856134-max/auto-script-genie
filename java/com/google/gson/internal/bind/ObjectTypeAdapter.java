package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.g0;
import com.google.gson.h0;
import com.google.gson.i0;
import com.google.gson.internal.f0;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final i0 c = f(g0.c);
    private final Gson a;
    private final h0 b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static i0 e(h0 h0Var) {
        return h0Var == g0.c ? c : f(h0Var);
    }

    private static i0 f(final h0 h0Var) {
        return new i0() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                if (aVar.d() == Object.class) {
                    return new ObjectTypeAdapter(gson, h0Var);
                }
                return null;
            }
        };
    }

    private Object g(com.google.gson.l0.b bVar, c cVar) throws IOException {
        int i2 = a.a[cVar.ordinal()];
        if (i2 == 3) {
            return bVar.J();
        }
        if (i2 == 4) {
            return this.b.a(bVar);
        }
        if (i2 == 5) {
            return Boolean.valueOf(bVar.y());
        }
        if (i2 == 6) {
            bVar.H();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + cVar);
    }

    private Object h(com.google.gson.l0.b bVar, c cVar) throws IOException {
        int i2 = a.a[cVar.ordinal()];
        if (i2 == 1) {
            bVar.a();
            return new ArrayList();
        }
        if (i2 != 2) {
            return null;
        }
        bVar.c();
        return new f0();
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(com.google.gson.l0.b bVar) throws IOException {
        c cVarL = bVar.L();
        Object objH = h(bVar, cVarL);
        if (objH == null) {
            return g(bVar, cVarL);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bVar.s()) {
                String strF = objH instanceof Map ? bVar.F() : null;
                c cVarL2 = bVar.L();
                Object objH2 = h(bVar, cVarL2);
                boolean z = objH2 != null;
                if (objH2 == null) {
                    objH2 = g(bVar, cVarL2);
                }
                if (objH instanceof List) {
                    ((List) objH).add(objH2);
                } else {
                    ((Map) objH).put(strF, objH2);
                }
                if (z) {
                    arrayDeque.addLast(objH);
                    objH = objH2;
                }
            } else {
                if (objH instanceof List) {
                    bVar.j();
                } else {
                    bVar.m();
                }
                if (arrayDeque.isEmpty()) {
                    return objH;
                }
                objH = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void d(d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.w();
            return;
        }
        TypeAdapter typeAdapterM = this.a.m(obj.getClass());
        if (!(typeAdapterM instanceof ObjectTypeAdapter)) {
            typeAdapterM.d(dVar, obj);
        } else {
            dVar.f();
            dVar.m();
        }
    }

    private ObjectTypeAdapter(Gson gson, h0 h0Var) {
        this.a = gson;
        this.b = h0Var;
    }
}
