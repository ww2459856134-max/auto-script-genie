package i.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.s.BoxService;
import com.user.AccountTool;
import com.v.FloatButton;
import com.v.FloatButton1;
import com.v.FloatButton10;
import com.v.FloatButton11;
import com.v.FloatButton12;
import com.v.FloatButton13;
import com.v.FloatButton14;
import com.v.FloatButton15;
import com.v.FloatButton16;
import com.v.FloatButton17;
import com.v.FloatButton18;
import com.v.FloatButton19;
import com.v.FloatButton2;
import com.v.FloatButton20;
import com.v.FloatButton21;
import com.v.FloatButton22;
import com.v.FloatButton23;
import com.v.FloatButton24;
import com.v.FloatButton25;
import com.v.FloatButton26;
import com.v.FloatButton27;
import com.v.FloatButton28;
import com.v.FloatButton29;
import com.v.FloatButton3;
import com.v.FloatButton30;
import com.v.FloatButton31;
import com.v.FloatButton32;
import com.v.FloatButton33;
import com.v.FloatButton34;
import com.v.FloatButton35;
import com.v.FloatButton36;
import com.v.FloatButton37;
import com.v.FloatButton38;
import com.v.FloatButton39;
import com.v.FloatButton4;
import com.v.FloatButton40;
import com.v.FloatButton5;
import com.v.FloatButton6;
import com.v.FloatButton7;
import com.v.FloatButton8;
import com.v.FloatButton9;
import com.yl.model.FloatButtonConfig;
import com.yl.model.TaskSimple;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class w7 {
    private static w7 f;
    private Set<FloatButtonConfig> b;
    String d;
    String e;
    Class[] a = {FloatButton.class, FloatButton1.class, FloatButton2.class, FloatButton3.class, FloatButton4.class, FloatButton5.class, FloatButton6.class, FloatButton7.class, FloatButton8.class, FloatButton9.class, FloatButton10.class, FloatButton11.class, FloatButton12.class, FloatButton13.class, FloatButton14.class, FloatButton15.class, FloatButton16.class, FloatButton17.class, FloatButton18.class, FloatButton19.class, FloatButton20.class, FloatButton21.class, FloatButton22.class, FloatButton23.class, FloatButton24.class, FloatButton25.class, FloatButton26.class, FloatButton27.class, FloatButton28.class, FloatButton29.class, FloatButton30.class, FloatButton31.class, FloatButton32.class, FloatButton33.class, FloatButton34.class, FloatButton35.class, FloatButton36.class, FloatButton37.class, FloatButton38.class, FloatButton39.class, FloatButton40.class};
    private HashMap<String, Set<FloatButtonConfig>> c = new HashMap<>();

    private w7() {
    }

    public static w7 g() {
        w7 w7Var = f;
        if (w7Var != null) {
            return w7Var;
        }
        w7 w7Var2 = new w7();
        f = w7Var2;
        return w7Var2;
    }

    static /* synthetic */ boolean k(FloatButtonConfig floatButtonConfig, FloatButtonConfig floatButtonConfig2) {
        return floatButtonConfig2 != null && floatButtonConfig2.taskId == floatButtonConfig.taskId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(com.frame.s0 s0Var, Set set) {
        int i2 = 0;
        for (Class cls : this.a) {
            s0Var.d(cls);
        }
        Iterator it = set.iterator();
        int length = !AccountTool.d().m() ? 12 : this.a.length;
        while (it.hasNext()) {
            FloatButtonConfig floatButtonConfig = (FloatButtonConfig) it.next();
            if (floatButtonConfig.isOpen) {
                if (i2 >= length) {
                    return;
                }
                if (c(floatButtonConfig.taskId)) {
                    Class cls2 = this.a[i2];
                    int i3 = floatButtonConfig.x;
                    int i4 = floatButtonConfig.y;
                    int i5 = floatButtonConfig.radius;
                    ((FloatButton) s0Var.y(cls2, i3, i4, i5, i5)).setup(floatButtonConfig);
                    i2++;
                }
            }
        }
    }

    static /* synthetic */ boolean n(FloatButtonConfig floatButtonConfig, FloatButtonConfig floatButtonConfig2) {
        return floatButtonConfig2 != null && floatButtonConfig2.taskId == floatButtonConfig.taskId;
    }

    public void a(final FloatButtonConfig floatButtonConfig) {
        e().removeIf(new Predicate() { // from class: i.b.e1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return w7.k(floatButtonConfig, (FloatButtonConfig) obj);
            }
        });
        e().add(floatButtonConfig);
        t(this.b);
        this.d = this.e;
        p();
    }

    public void b(String str) {
        final Set<FloatButtonConfig> hashSet;
        if (str == null) {
            hashSet = new HashSet<>();
        } else {
            if (str.equals(this.d)) {
                return;
            }
            hashSet = this.c.get(str);
            this.e = str;
            if (hashSet != null && !hashSet.isEmpty()) {
                this.d = str;
            } else {
                if ("other".equals(this.d)) {
                    return;
                }
                hashSet = new HashSet<>();
                this.d = "other";
            }
        }
        Set<FloatButtonConfig> set = this.c.get("other");
        if (set != null) {
            hashSet.addAll(set);
        }
        final com.frame.s0 s0VarG = com.frame.s0.g();
        com.frame.l1.e(new Runnable() { // from class: i.b.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m(s0VarG, hashSet);
            }
        });
    }

    boolean c(long j2) {
        Iterator<TaskSimple> it = da.B().C().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == j2) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        com.frame.s0 s0VarG = com.frame.s0.g();
        for (Class cls : this.a) {
            s0VarG.d(cls);
        }
    }

    public Set<FloatButtonConfig> e() {
        if (this.b == null) {
            i();
        }
        return this.b;
    }

    public FloatButtonConfig f(long j2) {
        for (FloatButtonConfig floatButtonConfig : e()) {
            if (floatButtonConfig.taskId == j2) {
                return floatButtonConfig;
            }
        }
        return null;
    }

    public String h() {
        return com.frame.n0.f("fbData", "");
    }

    public void i() {
        String strH = h();
        if (!TextUtils.isEmpty(strH)) {
            try {
                Set<FloatButtonConfig> set = (Set) new Gson().k(strH, com.google.gson.k0.a.c(Set.class, FloatButtonConfig.class).e());
                this.b = set;
                o(set);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        if (this.b == null) {
            this.b = new HashSet();
        }
        try {
            if (com.frame.w0.d() && j()) {
                BoxService.m().a(j8.b());
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public boolean j() {
        return this.c.size() > 1;
    }

    public void o(Set<FloatButtonConfig> set) {
        this.c = new HashMap<>();
        for (FloatButtonConfig floatButtonConfig : set) {
            if (TextUtils.isEmpty(floatButtonConfig.appPn)) {
                Set<FloatButtonConfig> hashSet = this.c.get("other");
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.c.put("other", hashSet);
                }
                hashSet.add(floatButtonConfig);
            } else {
                Set<FloatButtonConfig> hashSet2 = this.c.get(floatButtonConfig.appPn);
                if (hashSet2 == null) {
                    hashSet2 = new HashSet<>();
                    this.c.put(floatButtonConfig.appPn, hashSet2);
                }
                hashSet2.add(floatButtonConfig);
            }
        }
    }

    public void p() {
        String str = this.d;
        this.d = null;
        if (str != null) {
            b(str);
        } else {
            b(null);
        }
        try {
            if (com.frame.w0.d()) {
                BoxService.m().a(j8.b());
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void q(final FloatButtonConfig floatButtonConfig) {
        e().removeIf(new Predicate() { // from class: i.b.f1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return w7.n(floatButtonConfig, (FloatButtonConfig) obj);
            }
        });
        Class[] clsArr = this.a;
        int length = clsArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Class cls = clsArr[i2];
            FloatButton floatButton = (FloatButton) com.frame.s0.g().f(cls);
            if (floatButton != null && floatButton.getConfigId() == floatButtonConfig.id) {
                com.frame.s0.g().d(cls);
                break;
            }
            i2++;
        }
        t(this.b);
        p();
    }

    public void r() {
        t(this.b);
    }

    public void s(String str) {
        com.frame.n0.k("fbData", str);
    }

    public void t(Set<FloatButtonConfig> set) {
        this.b = new HashSet(set);
        s(new Gson().s(this.b));
        o(this.b);
    }

    public void u() {
        com.frame.s0 s0VarG = com.frame.s0.g();
        for (Class cls : this.a) {
            FloatButton floatButton = (FloatButton) s0VarG.f(cls);
            if (floatButton != null) {
                floatButton.setDefaultState();
            }
        }
    }
}
