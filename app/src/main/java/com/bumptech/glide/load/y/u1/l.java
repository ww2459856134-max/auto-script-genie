package com.bumptech.glide.load.y.u1;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
final class l<DataT> implements com.bumptech.glide.load.w.e<DataT> {
    private static final String[] A = {"_data"};
    private final Context c;
    private final p0<File, DataT> d;
    private final p0<Uri, DataT> e;
    private final Uri f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f644h;

    /* renamed from: i, reason: collision with root package name */
    private final r f645i;

    /* renamed from: j, reason: collision with root package name */
    private final Class<DataT> f646j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f647k;
    private volatile com.bumptech.glide.load.w.e<DataT> t;

    l(Context context, p0<File, DataT> p0Var, p0<Uri, DataT> p0Var2, Uri uri, int i2, int i3, r rVar, Class<DataT> cls) {
        this.c = context.getApplicationContext();
        this.d = p0Var;
        this.e = p0Var2;
        this.f = uri;
        this.g = i2;
        this.f644h = i3;
        this.f645i = rVar;
        this.f646j = cls;
    }

    private o0<DataT> e() throws FileNotFoundException {
        if (Environment.isExternalStorageLegacy()) {
            return this.d.a(h(this.f), this.g, this.f644h, this.f645i);
        }
        return this.e.a(g() ? MediaStore.setRequireOriginal(this.f) : this.f, this.g, this.f644h, this.f645i);
    }

    private com.bumptech.glide.load.w.e<DataT> f() throws FileNotFoundException {
        o0<DataT> o0VarE = e();
        if (o0VarE != null) {
            return o0VarE.c;
        }
        return null;
    }

    private boolean g() {
        return this.c.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
    }

    private File h(Uri uri) throws FileNotFoundException {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = this.c.getContentResolver().query(uri, A, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            if (TextUtils.isEmpty(string)) {
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            }
            File file = new File(string);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return file;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<DataT> a() {
        return this.f646j;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        com.bumptech.glide.load.w.e<DataT> eVar = this.t;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
        this.f647k = true;
        com.bumptech.glide.load.w.e<DataT> eVar = this.t;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super DataT> dVar) {
        try {
            com.bumptech.glide.load.w.e<DataT> eVarF = f();
            if (eVarF == null) {
                dVar.f(new IllegalArgumentException("Failed to build fetcher for: " + this.f));
                return;
            }
            this.t = eVarF;
            if (this.f647k) {
                cancel();
            } else {
                eVarF.d(hVar, dVar);
            }
        } catch (FileNotFoundException e) {
            dVar.f(e);
        }
    }
}
