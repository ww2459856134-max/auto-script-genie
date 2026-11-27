package h.h.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

/* loaded from: classes.dex */
public abstract class a {
    a(a aVar) {
    }

    public static a f(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new c(null, context, uri);
        }
        return null;
    }

    public static a g(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
        if (DocumentsContract.isDocumentUri(context, uri)) {
            treeDocumentId = DocumentsContract.getDocumentId(uri);
        }
        return new d(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, treeDocumentId));
    }

    public abstract boolean a();

    public abstract a b(String str, String str2);

    public abstract boolean c();

    public abstract boolean d();

    public a e(String str) {
        for (a aVar : j()) {
            if (str.equals(aVar.h())) {
                return aVar;
            }
        }
        return null;
    }

    public abstract String h();

    public abstract Uri i();

    public abstract a[] j();
}
