package androidx.preference;

import android.text.TextUtils;

/* loaded from: classes.dex */
class q {
    int a;
    int b;
    String c;

    q() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b && TextUtils.equals(this.c, qVar.c);
    }

    public int hashCode() {
        return ((((527 + this.a) * 31) + this.b) * 31) + this.c.hashCode();
    }

    q(q qVar) {
        this.a = qVar.a;
        this.b = qVar.b;
        this.c = qVar.c;
    }
}
