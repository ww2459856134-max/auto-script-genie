package h.h.a;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* loaded from: classes.dex */
class c extends a {
    private Context a;
    private Uri b;

    c(a aVar, Context context, Uri uri) {
        super(aVar);
        this.a = context;
        this.b = uri;
    }

    @Override // h.h.a.a
    public boolean a() {
        return b.a(this.a, this.b);
    }

    @Override // h.h.a.a
    public a b(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // h.h.a.a
    public boolean c() {
        try {
            return DocumentsContract.deleteDocument(this.a.getContentResolver(), this.b);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // h.h.a.a
    public boolean d() {
        return b.c(this.a, this.b);
    }

    @Override // h.h.a.a
    public String h() {
        return b.d(this.a, this.b);
    }

    @Override // h.h.a.a
    public Uri i() {
        return this.b;
    }

    @Override // h.h.a.a
    public a[] j() {
        throw new UnsupportedOperationException();
    }
}
