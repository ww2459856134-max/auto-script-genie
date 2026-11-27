package androidx.appcompat.widget;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import h.e.j.s1.e;

/* loaded from: classes.dex */
class u implements e.a {
    final /* synthetic */ View a;

    u(View view) {
        this.a = view;
    }

    @Override // h.e.j.s1.e.a
    public boolean a(h.e.j.s1.i iVar, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                iVar.d();
                InputContentInfo inputContentInfo = (InputContentInfo) iVar.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e) {
                Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        h.e.j.f fVar = new h.e.j.f(new ClipData(iVar.b(), new ClipData.Item(iVar.a())), 2);
        fVar.d(iVar.c());
        fVar.b(bundle);
        return h.e.j.s0.S(this.a, fVar.a()) == null;
    }
}
