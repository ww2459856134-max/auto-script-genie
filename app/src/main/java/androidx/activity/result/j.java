package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;

/* loaded from: classes.dex */
public final class j {
    private IntentSender a;
    private Intent b;
    private int c;
    private int d;

    public j(IntentSender intentSender) {
        this.a = intentSender;
    }

    public k a() {
        return new k(this.a, this.b, this.c, this.d);
    }

    public j b(Intent intent) {
        this.b = intent;
        return this;
    }

    public j c(int i2, int i3) {
        this.d = i2;
        this.c = i3;
        return this;
    }
}
