package androidx.activity.result.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

@TargetApi(21)
/* loaded from: classes.dex */
public class d extends b<Uri, Uri> {
    @Override // androidx.activity.result.l.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        if (Build.VERSION.SDK_INT >= 26 && uri != null) {
            intent.putExtra("android.provider.extra.INITIAL_URI", uri);
        }
        return intent;
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a<Uri> b(Context context, Uri uri) {
        return null;
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i2, Intent intent) {
        if (intent == null || i2 != -1) {
            return null;
        }
        return intent.getData();
    }
}
