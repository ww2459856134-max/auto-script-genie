package i.h;

import android.text.TextUtils;
import com.frame.k0;
import com.frame.l1;
import com.frame.p0;
import com.frame.v0;
import com.google.gson.Gson;
import com.user.AccountTool;
import i.h.f;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ f.b c;
    final /* synthetic */ Class d;
    final /* synthetic */ f e;

    e(f fVar, f.b bVar, Class cls) {
        this.e = fVar;
        this.c = bVar;
        this.d = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Class cls, f.b bVar, String str, Gson gson) {
        try {
            if (cls == String.class) {
                bVar.b(str);
            } else if (TextUtils.isEmpty(str)) {
                bVar.b(null);
            } else {
                bVar.b(gson.j(str, cls));
            }
            this.e.i();
        } catch (Exception e) {
            bVar.a(-1, e.getMessage());
            k0.r(e);
            this.e.i();
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(f.b bVar) {
        bVar.a(-1, "empty response");
        this.e.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(f.b bVar, Exception exc) {
        bVar.a(-1, exc.getMessage());
        this.e.i();
    }

    @Override // java.lang.Runnable
    public void run() {
        String strW;
        try {
            if (this.e.e) {
                this.e.b.add(new BasicNameValuePair("token", AccountTool.d().e()));
            }
            if (!"com.yl.mgr".equals(v0.g().getPackageName())) {
                this.e.b.add(new BasicNameValuePair("packageName", v0.g().getPackageName()));
            }
            if (this.e.a.startsWith("http")) {
                strW = p0.h().w(this.e.a, this.e.b, null, this.e.c, this.e.d);
            } else {
                strW = p0.h().w(k0.g + this.e.a, this.e.b, null, this.e.c, this.e.d);
            }
            if (this.c == null) {
                return;
            }
            if (TextUtils.isEmpty(strW) || "bad base-64".equals(strW)) {
                final f.b bVar = this.c;
                l1.e(new Runnable() { // from class: i.h.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.d(bVar);
                    }
                });
                return;
            }
            JSONObject jSONObject = new JSONObject(strW);
            if (f.f1731i == null || !f.f1731i.a(this.e, strW, jSONObject)) {
                final String strOptString = jSONObject.optString("json");
                final Gson gson = new Gson();
                final Class cls = this.d;
                final f.b bVar2 = this.c;
                l1.e(new Runnable() { // from class: i.h.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.b(cls, bVar2, strOptString, gson);
                    }
                });
            }
        } catch (Exception e) {
            k0.r(e);
            if (e.getMessage() != null && e.getMessage().contains("NameValuePair")) {
                try {
                    p0.h().y();
                    this.e.b.clear();
                    run();
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            final f.b bVar3 = this.c;
            l1.e(new Runnable() { // from class: i.h.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.f(bVar3, e);
                }
            });
            k0.r(e);
        }
    }
}
