package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class s implements Iterable<Intent> {
    private final ArrayList<Intent> c = new ArrayList<>();
    private final Context d;

    private s(Context context) {
        this.d = context;
    }

    public static s g(Context context) {
        return new s(context);
    }

    public s a(Intent intent) {
        this.c.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s b(Activity activity) {
        Intent intentA = activity instanceof r ? ((r) activity).a() : null;
        if (intentA == null) {
            intentA = o.a(activity);
        }
        if (intentA != null) {
            ComponentName component = intentA.getComponent();
            if (component == null) {
                component = intentA.resolveActivity(this.d.getPackageManager());
            }
            e(component);
            a(intentA);
        }
        return this;
    }

    public s e(ComponentName componentName) {
        int size = this.c.size();
        try {
            Intent intentB = o.b(this.d, componentName);
            while (intentB != null) {
                this.c.add(size, intentB);
                intentB = o.b(this.d, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void h() {
        j(null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.c.iterator();
    }

    public void j(Bundle bundle) {
        if (this.c.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.c;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.h(this.d, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.d.startActivity(intent);
    }
}
