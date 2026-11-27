package i.b;

import android.text.TextUtils;
import android.widget.Toast;
import i.h.f;
import org.json.JSONObject;

/* loaded from: classes.dex */
class j9 implements f.b<String> {
    final /* synthetic */ l9 a;

    j9(l9 l9Var) {
        this.a = l9Var;
    }

    @Override // i.h.f.b
    public void a(int i2, final String str) {
        this.a.d();
        com.frame.l1.e(new Runnable() { // from class: i.b.g3
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(com.frame.v0.g(), str, 0).show();
            }
        });
    }

    @Override // i.h.f.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        this.a.d();
        if (TextUtils.isEmpty(str)) {
            this.a.a = new JSONObject();
            com.frame.n0.k("sPermission", this.a.a.toString());
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("permissions");
            com.frame.n0.k("sPermission", strOptString);
            this.a.a = new JSONObject(strOptString);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }
}
