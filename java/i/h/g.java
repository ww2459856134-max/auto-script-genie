package i.h;

import android.app.Activity;
import i.h.f;
import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public abstract class g<T> implements f.b<T> {
    private SoftReference<Activity> a;

    public g(Activity activity) {
        this.a = new SoftReference<>(activity);
    }

    @Override // i.h.f.b
    public void a(int i2, String str) {
    }

    public Activity c() {
        return this.a.get();
    }
}
