package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.h0;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.w.v;
import com.bumptech.glide.load.x.i0;
import com.bumptech.glide.load.y.a0;
import com.bumptech.glide.load.y.a1;
import com.bumptech.glide.load.y.b1;
import com.bumptech.glide.load.y.d1;
import com.bumptech.glide.load.y.f1;
import com.bumptech.glide.load.y.g1;
import com.bumptech.glide.load.y.h1;
import com.bumptech.glide.load.y.i1;
import com.bumptech.glide.load.y.k1;
import com.bumptech.glide.load.y.n1;
import com.bumptech.glide.load.y.o1;
import com.bumptech.glide.load.y.q1;
import com.bumptech.glide.load.y.s1;
import com.bumptech.glide.load.y.w;
import com.bumptech.glide.load.z.f.c0;
import com.bumptech.glide.load.z.f.c1;
import com.bumptech.glide.load.z.f.k0;
import com.bumptech.glide.load.z.f.n0;
import com.bumptech.glide.load.z.f.p0;
import com.bumptech.glide.load.z.f.t0;
import com.bumptech.glide.load.z.f.y;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: k, reason: collision with root package name */
    private static volatile c f577k;
    private static volatile boolean t;
    private final com.bumptech.glide.load.x.g1.g c;
    private final com.bumptech.glide.load.x.h1.o d;
    private final f e;
    private final o f;
    private final com.bumptech.glide.load.x.g1.b g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.w.p f578h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.w.e f579i;

    /* renamed from: j, reason: collision with root package name */
    private final List<s> f580j = new ArrayList();

    c(Context context, i0 i0Var, com.bumptech.glide.load.x.h1.o oVar, com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.x.g1.b bVar, com.bumptech.glide.w.p pVar, com.bumptech.glide.w.e eVar, int i2, b bVar2, Map<Class<?>, t<?, ?>> map, List<com.bumptech.glide.z.f<Object>> list, boolean z, boolean z2) {
        com.bumptech.glide.load.t gVar2;
        com.bumptech.glide.load.t p0Var;
        com.bumptech.glide.load.z.h.d dVar;
        g gVar3 = g.NORMAL;
        this.c = gVar;
        this.g = bVar;
        this.d = oVar;
        this.f578h = pVar;
        this.f579i = eVar;
        Resources resources = context.getResources();
        o oVar2 = new o();
        this.f = oVar2;
        oVar2.o(new com.bumptech.glide.load.z.f.p());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            oVar2.o(new c0());
        }
        List<ImageHeaderParser> listG = oVar2.g();
        com.bumptech.glide.load.z.j.c cVar = new com.bumptech.glide.load.z.j.c(context, listG, gVar, bVar);
        com.bumptech.glide.load.t<ParcelFileDescriptor, Bitmap> tVarH = c1.h(gVar);
        y yVar = new y(oVar2.g(), resources.getDisplayMetrics(), gVar, bVar);
        if (!z2 || i3 < 28) {
            gVar2 = new com.bumptech.glide.load.z.f.g(yVar);
            p0Var = new p0(yVar, bVar);
        } else {
            p0Var = new com.bumptech.glide.load.z.f.i0();
            gVar2 = new com.bumptech.glide.load.z.f.h();
        }
        com.bumptech.glide.load.z.h.d dVar2 = new com.bumptech.glide.load.z.h.d(context);
        com.bumptech.glide.load.y.c1 c1Var = new com.bumptech.glide.load.y.c1(resources);
        d1 d1Var = new d1(resources);
        b1 b1Var = new b1(resources);
        a1 a1Var = new a1(resources);
        com.bumptech.glide.load.z.f.c cVar2 = new com.bumptech.glide.load.z.f.c(bVar);
        com.bumptech.glide.load.z.k.a aVar = new com.bumptech.glide.load.z.k.a();
        com.bumptech.glide.load.z.k.d dVar3 = new com.bumptech.glide.load.z.k.d();
        ContentResolver contentResolver = context.getContentResolver();
        oVar2.a(ByteBuffer.class, new com.bumptech.glide.load.y.l());
        oVar2.a(InputStream.class, new f1(bVar));
        oVar2.e("Bitmap", ByteBuffer.class, Bitmap.class, gVar2);
        oVar2.e("Bitmap", InputStream.class, Bitmap.class, p0Var);
        if (v.c()) {
            dVar = dVar2;
            oVar2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new k0(yVar));
        } else {
            dVar = dVar2;
        }
        oVar2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, tVarH);
        oVar2.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, c1.c(gVar));
        oVar2.d(Bitmap.class, Bitmap.class, k1.a());
        oVar2.e("Bitmap", Bitmap.class, Bitmap.class, new t0());
        oVar2.b(Bitmap.class, cVar2);
        oVar2.e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.z.f.a(resources, gVar2));
        oVar2.e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.z.f.a(resources, p0Var));
        oVar2.e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.z.f.a(resources, tVarH));
        oVar2.b(BitmapDrawable.class, new com.bumptech.glide.load.z.f.b(gVar, cVar2));
        oVar2.e("Gif", InputStream.class, com.bumptech.glide.load.z.j.f.class, new com.bumptech.glide.load.z.j.q(listG, cVar, bVar));
        oVar2.e("Gif", ByteBuffer.class, com.bumptech.glide.load.z.j.f.class, cVar);
        oVar2.b(com.bumptech.glide.load.z.j.f.class, new com.bumptech.glide.load.z.j.g());
        oVar2.d(com.bumptech.glide.v.b.class, com.bumptech.glide.v.b.class, k1.a());
        oVar2.e("Bitmap", com.bumptech.glide.v.b.class, Bitmap.class, new com.bumptech.glide.load.z.j.o(gVar));
        com.bumptech.glide.load.z.h.d dVar4 = dVar;
        oVar2.c(Uri.class, Drawable.class, dVar4);
        oVar2.c(Uri.class, Bitmap.class, new n0(dVar4, gVar));
        oVar2.p(new com.bumptech.glide.load.z.g.a());
        oVar2.d(File.class, ByteBuffer.class, new com.bumptech.glide.load.y.n());
        oVar2.d(File.class, InputStream.class, new a0());
        oVar2.c(File.class, File.class, new com.bumptech.glide.load.z.i.a());
        oVar2.d(File.class, ParcelFileDescriptor.class, new w());
        oVar2.d(File.class, File.class, k1.a());
        oVar2.p(new com.bumptech.glide.load.w.q(bVar));
        if (v.c()) {
            oVar2.p(new com.bumptech.glide.load.w.t());
        }
        Class cls = Integer.TYPE;
        oVar2.d(cls, InputStream.class, c1Var);
        oVar2.d(cls, ParcelFileDescriptor.class, b1Var);
        oVar2.d(Integer.class, InputStream.class, c1Var);
        oVar2.d(Integer.class, ParcelFileDescriptor.class, b1Var);
        oVar2.d(Integer.class, Uri.class, d1Var);
        oVar2.d(cls, AssetFileDescriptor.class, a1Var);
        oVar2.d(Integer.class, AssetFileDescriptor.class, a1Var);
        oVar2.d(cls, Uri.class, d1Var);
        oVar2.d(String.class, InputStream.class, new com.bumptech.glide.load.y.s());
        oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.s());
        oVar2.d(String.class, InputStream.class, new i1());
        oVar2.d(String.class, ParcelFileDescriptor.class, new h1());
        oVar2.d(String.class, AssetFileDescriptor.class, new g1());
        oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.u1.c());
        oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.c(context.getAssets()));
        oVar2.d(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.y.b(context.getAssets()));
        oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.u1.e(context));
        oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.u1.g(context));
        if (i3 >= 29) {
            oVar2.d(Uri.class, InputStream.class, new com.bumptech.glide.load.y.u1.k(context));
            oVar2.d(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.y.u1.j(context));
        }
        oVar2.d(Uri.class, InputStream.class, new q1(contentResolver));
        oVar2.d(Uri.class, ParcelFileDescriptor.class, new o1(contentResolver));
        oVar2.d(Uri.class, AssetFileDescriptor.class, new n1(contentResolver));
        oVar2.d(Uri.class, InputStream.class, new s1());
        oVar2.d(URL.class, InputStream.class, new com.bumptech.glide.load.y.u1.n());
        oVar2.d(Uri.class, File.class, new com.bumptech.glide.load.y.i0(context));
        oVar2.d(com.bumptech.glide.load.y.c0.class, InputStream.class, new com.bumptech.glide.load.y.u1.a());
        oVar2.d(byte[].class, ByteBuffer.class, new com.bumptech.glide.load.y.f());
        oVar2.d(byte[].class, InputStream.class, new com.bumptech.glide.load.y.j());
        oVar2.d(Uri.class, Uri.class, k1.a());
        oVar2.d(Drawable.class, Drawable.class, k1.a());
        oVar2.c(Drawable.class, Drawable.class, new com.bumptech.glide.load.z.h.e());
        oVar2.q(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.z.k.b(resources));
        oVar2.q(Bitmap.class, byte[].class, aVar);
        oVar2.q(Drawable.class, byte[].class, new com.bumptech.glide.load.z.k.c(gVar, aVar, dVar3));
        oVar2.q(com.bumptech.glide.load.z.j.f.class, byte[].class, dVar3);
        if (i3 >= 23) {
            com.bumptech.glide.load.t<ByteBuffer, Bitmap> tVarD = c1.d(gVar);
            oVar2.c(ByteBuffer.class, Bitmap.class, tVarD);
            oVar2.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.z.f.a(resources, tVarD));
        }
        this.e = new f(context, bVar, oVar2, new com.bumptech.glide.z.l.f(), bVar2, map, list, i0Var, z, i2);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (t) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        t = true;
        m(context, generatedAppGlideModule);
        t = false;
    }

    public static c c(Context context) {
        if (f577k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (c.class) {
                if (f577k == null) {
                    a(context, generatedAppGlideModuleD);
                }
            }
        }
        return f577k;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e) {
            q(e);
            throw null;
        } catch (InstantiationException e2) {
            q(e2);
            throw null;
        } catch (NoSuchMethodException e3) {
            q(e3);
            throw null;
        } catch (InvocationTargetException e4) {
            q(e4);
            throw null;
        }
    }

    private static com.bumptech.glide.w.p l(Context context) {
        com.bumptech.glide.b0.n.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new e(), generatedAppGlideModule);
    }

    private static void n(Context context, e eVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.x.b> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new com.bumptech.glide.x.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<com.bumptech.glide.x.b> it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.x.b next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.x.b> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        eVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator<com.bumptech.glide.x.b> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, eVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, eVar);
        }
        c cVarA = eVar.a(applicationContext);
        for (com.bumptech.glide.x.b bVar : listEmptyList) {
            try {
                bVar.b(applicationContext, cVarA, cVarA.f);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, cVarA, cVarA.f);
        }
        applicationContext.registerComponentCallbacks(cVarA);
        f577k = cVarA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static s t(Context context) {
        return l(context).k(context);
    }

    public static s u(View view) {
        return l(view.getContext()).l(view);
    }

    public static s v(h0 h0Var) {
        return l(h0Var).n(h0Var);
    }

    public void b() {
        com.bumptech.glide.b0.p.a();
        this.d.b();
        this.c.b();
        this.g.b();
    }

    public com.bumptech.glide.load.x.g1.b e() {
        return this.g;
    }

    public com.bumptech.glide.load.x.g1.g f() {
        return this.c;
    }

    com.bumptech.glide.w.e g() {
        return this.f579i;
    }

    public Context h() {
        return this.e.getBaseContext();
    }

    f i() {
        return this.e;
    }

    public o j() {
        return this.f;
    }

    public com.bumptech.glide.w.p k() {
        return this.f578h;
    }

    void o(s sVar) {
        synchronized (this.f580j) {
            if (this.f580j.contains(sVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.f580j.add(sVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        r(i2);
    }

    boolean p(com.bumptech.glide.z.l.h<?> hVar) {
        synchronized (this.f580j) {
            Iterator<s> it = this.f580j.iterator();
            while (it.hasNext()) {
                if (it.next().D(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i2) {
        com.bumptech.glide.b0.p.a();
        Iterator<s> it = this.f580j.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i2);
        }
        this.d.a(i2);
        this.c.a(i2);
        this.g.a(i2);
    }

    void s(s sVar) {
        synchronized (this.f580j) {
            if (!this.f580j.contains(sVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.f580j.remove(sVar);
        }
    }
}
