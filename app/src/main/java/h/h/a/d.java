package h.h.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
class d extends a {
    private Context a;
    private Uri b;

    d(a aVar, Context context, Uri uri) {
        super(aVar);
        this.a = context;
        this.b = uri;
    }

    private static void k(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private static Uri l(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // h.h.a.a
    public boolean a() {
        return b.a(this.a, this.b);
    }

    @Override // h.h.a.a
    public a b(String str, String str2) {
        Uri uriL = l(this.a, this.b, str, str2);
        if (uriL != null) {
            return new d(this, this.a, uriL);
        }
        return null;
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
    public a[] j() throws Exception {
        ContentResolver contentResolver = this.a.getContentResolver();
        Uri uri = this.b;
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.b, cursorQuery.getString(0)));
                }
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i2 = 0; i2 < uriArr.length; i2++) {
                aVarArr[i2] = new d(this, this.a, uriArr[i2]);
            }
            return aVarArr;
        } finally {
            k(cursorQuery);
        }
    }
}
