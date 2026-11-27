package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
class y0 implements androidx.activity.result.c<Map<String, Boolean>> {
    final /* synthetic */ p1 a;

    y0(p1 p1Var) {
        this.a = p1Var;
    }

    @Override // androidx.activity.result.c
    @SuppressLint({"SyntheticAccessor"})
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Map<String, Boolean> map) {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
        }
        k1 k1VarPollFirst = this.a.C.pollFirst();
        if (k1VarPollFirst == null) {
            Log.w("FragmentManager", "No permissions were requested for " + this);
            return;
        }
        String str = k1VarPollFirst.c;
        int i3 = k1VarPollFirst.d;
        Fragment fragmentI = this.a.c.i(str);
        if (fragmentI != null) {
            fragmentI.P0(i3, strArr, iArr);
            return;
        }
        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
    }
}
