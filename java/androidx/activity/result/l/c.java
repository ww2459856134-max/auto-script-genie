package androidx.activity.result.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

@TargetApi(19)
/* loaded from: classes.dex */
public class c extends b<String[], Uri> {
    @Override // androidx.activity.result.l.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a<Uri> b(Context context, String[] strArr) {
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
