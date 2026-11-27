package com.bumptech.glide.load.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
class j0 implements com.bumptech.glide.load.w.e<File> {
    private static final String[] e = {"_data"};
    private final Context c;
    private final Uri d;

    j0(Context context, Uri uri) {
        this.c = context;
        this.d = uri;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<File> a() {
        return File.class;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super File> dVar) {
        Cursor cursorQuery = this.c.getContentResolver().query(this.d, e, null, null, null);
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
            } finally {
                cursorQuery.close();
            }
        }
        if (!TextUtils.isEmpty(string)) {
            dVar.e(new File(string));
            return;
        }
        dVar.f(new FileNotFoundException("Failed to find file path for: " + this.d));
    }
}
