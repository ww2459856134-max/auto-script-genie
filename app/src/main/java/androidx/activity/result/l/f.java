package androidx.activity.result.l;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class f extends b<Intent, androidx.activity.result.b> {
    @Override // androidx.activity.result.l.b
    public /* bridge */ /* synthetic */ Intent a(Context context, Intent intent) {
        Intent intent2 = intent;
        d(context, intent2);
        return intent2;
    }

    public Intent d(Context context, Intent intent) {
        return intent;
    }

    @Override // androidx.activity.result.l.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.b c(int i2, Intent intent) {
        return new androidx.activity.result.b(i2, intent);
    }
}
