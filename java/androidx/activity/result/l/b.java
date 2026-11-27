package androidx.activity.result.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class b<I, O> {
    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i2);

    public a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i2) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O c(int i2, Intent intent);
}
