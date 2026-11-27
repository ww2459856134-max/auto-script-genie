package h.e.g;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class j implements Callable<l> {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ g c;
    final /* synthetic */ int d;

    j(String str, Context context, g gVar, int i2) {
        this.a = str;
        this.b = context;
        this.c = gVar;
        this.d = i2;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() {
        return m.c(this.a, this.b, this.c, this.d);
    }
}
