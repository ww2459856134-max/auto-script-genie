package i.h;

import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import com.frame.k0;
import com.frame.l1;
import com.frame.p0;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1730h;

    /* renamed from: i, reason: collision with root package name */
    private static c f1731i;
    private String a;
    private long c;
    private boolean d;
    private b f;
    private ProgressDialog g;
    private ArrayList<BasicNameValuePair> b = new ArrayList<>();
    private boolean e = true;

    public static class a {
        private String b;
        private ArrayList<BasicNameValuePair> a = new ArrayList<>();
        private boolean c = true;

        public a() {
            boolean unused = f.f1730h = false;
        }

        public f a() {
            f fVar = new f();
            fVar.o(this.b, this.a, this.c);
            return fVar;
        }

        public a b() {
            this.a.addAll(p0.h().b());
            return this;
        }

        public a c(String str, Integer num) {
            if (num == null) {
                return this;
            }
            this.a.add(new BasicNameValuePair(str, String.valueOf(num)));
            return this;
        }

        public a d(String str, Long l2) {
            if (l2 == null) {
                return this;
            }
            this.a.add(new BasicNameValuePair(str, String.valueOf(l2)));
            return this;
        }

        public a e(String str, String str2) {
            if (str2 == null || TextUtils.isEmpty(str)) {
                return this;
            }
            this.a.add(new BasicNameValuePair(str, str2));
            return this;
        }

        public a f(String str) {
            this.b = str;
            return this;
        }

        public a g(boolean z) {
            boolean unused = f.f1730h = z;
            return this;
        }
    }

    public interface b<T> {
        void a(int i2, String str);

        void b(T t);
    }

    public interface c {
        boolean a(f fVar, String str, JSONObject jSONObject) throws JSONException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(b bVar) {
        h(((g) bVar).c());
    }

    public static void n(c cVar) {
        f1731i = cVar;
    }

    public void h(Activity activity) {
        if (!f1730h || activity == null) {
            return;
        }
        try {
            if (this.g == null) {
                ProgressDialog progressDialog = new ProgressDialog(activity, 3);
                this.g = progressDialog;
                progressDialog.setProgressStyle(0);
            }
            this.g.setMessage("加载中...");
            this.g.setCancelable(true);
            this.g.show();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void i() {
        try {
            ProgressDialog progressDialog = this.g;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.g.dismiss();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public <T> void l(Class<? extends T> cls, final b<T> bVar) {
        this.f = bVar;
        if (bVar instanceof g) {
            l1.e(new Runnable() { // from class: i.h.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.k(bVar);
                }
            });
        }
        l1.g(new e(this, bVar, cls));
    }

    public void m(int i2, String str) {
        this.f.a(i2, str);
    }

    public f o(String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.a = str;
        this.b = arrayList;
        this.e = z;
        return this;
    }
}
