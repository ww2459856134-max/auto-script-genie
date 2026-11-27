package com.jsj.autojs.i;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.p1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.a.WallpaperSelectAct;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.frame.g0;
import com.frame.k0;
import com.frame.l1;
import com.frame.n0;
import com.frame.p0;
import com.frame.v0;
import com.frame.w0;
import com.jsj.autojs.activity.A1393b5d52c;
import com.jsj.autojs.l.c0;
import com.jsj.autojs.model.PermissionAdapter;
import com.permission.ClickView;
import com.permission.a1;
import com.permission.b1;
import com.permission.i0;
import com.permission.x0;
import com.s.BoxService;
import com.tencent.cursor.R;
import com.yl.ui.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
public class x extends androidx.fragment.app.s implements View.OnClickListener, BaseQuickAdapter.OnItemClickListener {
    int P0 = 0;
    private WeakReference<Dialog> Q0;
    private RecyclerView R0;
    private RecyclerView S0;
    private TextView T0;
    private PermissionAdapter U0;
    private PermissionAdapter V0;

    class a implements g0.c {
        a(x xVar) {
        }

        @Override // com.frame.g0.c
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            try {
                accessibilityNodeInfo.performAction(16);
                ClickView.getInstance().n(v0.g().getString(R.string.app_name), "点击允许后台耗电");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.frame.g0.c
        public void b() {
        }
    }

    static /* synthetic */ void B2(View view) {
        if (w0.d()) {
            BoxService.m().x();
        }
        x0.m().h();
    }

    static /* synthetic */ void C2(View view) {
        if (w0.d()) {
            BoxService.m().x();
        }
        x0.m().f();
    }

    static /* synthetic */ void E2() {
        try {
            Intent intent = new Intent(v0.g(), v0.g().d() == null ? A1393b5d52c.class : v0.g().d().getClass());
            intent.setFlags(67108864);
            v0.g().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G2(DialogInterface dialogInterface, int i2) {
        n0.g("already_autorun", true);
        try {
            this.V0.setNewData(n2());
            this.V0.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I2() {
        try {
            ImageView imageView = new ImageView(v0.g());
            imageView.setImageResource(2131231009);
            s.a aVar = new s.a(v0.g().d());
            aVar.g(a1.g().h() instanceof com.permission.g0 ? 0 : 2131231019);
            aVar.m("取消", null);
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.i.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.G2(dialogInterface, i2);
                }
            });
            if (!(a1.g().h() instanceof com.permission.g0)) {
                imageView = null;
            }
            aVar.u(imageView);
            aVar.j("您是否已经跟随指引成功开启自启动权限？");
            aVar.t("温馨提示");
            com.yl.ui.s sVarE = aVar.e();
            sVarE.show();
            this.Q0 = new WeakReference<>(sVarE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K2(DialogInterface dialogInterface, int i2) {
        n0.g("already_better_power", true);
        try {
            this.V0.setNewData(n2());
            this.V0.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M2() {
        try {
            s.a aVar = new s.a(v0.g().d());
            aVar.g(2131231019);
            aVar.m("取消", null);
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.i.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.K2(dialogInterface, i2);
                }
            });
            aVar.j("您是否已经跟随指引成功允许后台耗电？");
            aVar.t("温馨提示");
            com.yl.ui.s sVarE = aVar.e();
            sVarE.show();
            this.Q0 = new WeakReference<>(sVarE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l2(View view) {
        this.R0 = (RecyclerView) view.findViewById(2131296866);
        this.S0 = (RecyclerView) view.findViewById(2131296867);
        this.T0 = (TextView) view.findViewById(R.id.tv_title);
        ((TextView) view.findViewById(2131297295)).setText(p0.h().j() + "  (" + Build.VERSION.SDK_INT + ")");
        view.findViewById(R.id.btn_close).setOnClickListener(this);
        view.findViewById(2131296986).setOnClickListener(this);
        String strJ = a1.g().j();
        String str = "vivo".equals(strJ) ? "vivo" : "oppo".equals(strJ) ? "oppo" : "miui".equals(strJ) ? "小米" : "meizu".equals(strJ) ? "魅族" : "huawei".equals(strJ) ? "华为" : Build.MANUFACTURER;
        this.T0.setText(str + "权限加固");
        this.U0 = new PermissionAdapter(null);
        this.R0.setLayoutManager(new LinearLayoutManager(v0.g()));
        this.R0.setAdapter(this.U0);
        this.V0 = new PermissionAdapter(null);
        this.S0.setLayoutManager(new LinearLayoutManager(v0.g()));
        this.S0.setAdapter(this.V0);
        this.V0.setOnItemClickListener(this);
        this.U0.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q2(View view) {
        if (w0.d()) {
            BoxService.m().x();
        }
        this.P0 = x0.d.intValue();
        v0.g().startActivity(new Intent(v0.g(), (Class<?>) WallpaperSelectAct.class));
    }

    static /* synthetic */ void r2(View view) {
        if (w0.d()) {
            BoxService.m().x();
        }
        x0.m().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u2(View view) {
        if (w0.d()) {
            BoxService.m().x();
        }
        if (a1.g().h() instanceof com.permission.g0) {
            try {
                ImageView imageView = new ImageView(v0.g());
                imageView.setImageResource(2131231009);
                s.a aVar = new s.a(v0.g().d());
                aVar.u(imageView);
                aVar.m("取消", null);
                aVar.r("去开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.i.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        x0.m().b();
                    }
                });
                aVar.j("华为手机需要如图指示，先改成手动后勾选三项自启动。");
                aVar.t("温馨提示");
                aVar.e().show();
            } catch (Exception e) {
                k0.r(e);
            }
        } else {
            x0.m().b();
        }
        this.P0 = x0.f835h.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w2() {
        g0.v().M("com.iqoo.powersaving", null, "后台耗电管理", 5000L, 500L, false, new AtomicReference<>(Boolean.TRUE), new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y2(View view) {
        a1.g().h().c();
        this.P0 = x0.f837j.intValue();
        if (Build.VERSION.SDK_INT >= 16 && w0.d() && (a1.g().h() instanceof b1)) {
            l1.g(new Runnable() { // from class: com.jsj.autojs.i.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w2();
                }
            });
        }
    }

    static /* synthetic */ void z2(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            androidx.core.app.f.l(v0.g().d(), new String[]{"android.permission.POST_NOTIFICATIONS"}, x0.e.intValue());
        } else {
            x0.m().g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A0() {
        super.A0();
    }

    @Override // androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        Log.e("permission", "onResume: ");
        try {
            List<com.permission.v0> listN2 = n2();
            List<com.permission.v0> listM2 = m2();
            this.U0.setNewData(listM2);
            this.U0.notifyDataSetChanged();
            this.V0.setNewData(listN2);
            this.V0.notifyDataSetChanged();
            if (listN2.isEmpty() && listM2.isEmpty()) {
                try {
                    Y1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.P0 == x0.f835h.intValue()) {
            try {
                WeakReference<Dialog> weakReference = this.Q0;
                if (weakReference != null && weakReference.get() != null) {
                    this.Q0.get().cancel();
                }
                l1.c(11231238, new Runnable() { // from class: com.jsj.autojs.i.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.I2();
                    }
                }, 600L);
            } catch (Exception e3) {
                k0.r(e3);
            }
        } else if (this.P0 == x0.f837j.intValue()) {
            try {
                WeakReference<Dialog> weakReference2 = this.Q0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.Q0.get().cancel();
                }
                l1.c(11231238, new Runnable() { // from class: com.jsj.autojs.i.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.M2();
                    }
                }, 600L);
            } catch (Exception e4) {
                k0.r(e4);
            }
        }
        this.P0 = 0;
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        Log.e("permission", "onStart: ");
        Dialog dialogA2 = a2();
        if (dialogA2 != null) {
            try {
                q().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                dialogA2.getWindow().setLayout((int) (r1.widthPixels * 0.8d), -2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.s
    public void Y1() {
        if (q() == null || q().isFinishing()) {
            return;
        }
        super.Y1();
    }

    @Override // androidx.fragment.app.s
    public void j2(p1 p1Var, String str) {
        try {
            super.j2(p1Var, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<com.permission.v0> m2() {
        ArrayList arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21) {
            com.permission.v0 v0Var = new com.permission.v0();
            v0Var.a = 2131558493;
            v0Var.b = 2131558492;
            v0Var.d = Boolean.valueOf(w0.d());
            v0Var.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x0.m().a();
                }
            };
            arrayList.add(v0Var);
        }
        com.permission.v0 v0Var2 = new com.permission.v0();
        v0Var2.a = 2131558520;
        v0Var2.b = 2131558519;
        v0Var2.d = Boolean.valueOf(WallpaperSetting.q());
        v0Var2.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q2(view);
            }
        };
        arrayList.add(v0Var2);
        if (i2 >= 19 && (a1.g().h() instanceof i0)) {
            com.permission.v0 v0Var3 = new com.permission.v0();
            v0Var3.a = 2131558434;
            v0Var3.b = 2131558433;
            v0Var3.d = Boolean.valueOf(x0.m().n());
            v0Var3.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x.r2(view);
                }
            };
            arrayList.add(v0Var3);
        }
        return arrayList;
    }

    public List<com.permission.v0> n2() {
        ArrayList arrayList = new ArrayList();
        com.permission.v0 v0Var = new com.permission.v0();
        v0Var.a = 2131558509;
        v0Var.b = 2131558508;
        v0Var.d = Boolean.valueOf(x0.m().p());
        v0Var.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.C2(view);
            }
        };
        arrayList.add(v0Var);
        if (!(a1.g().h() instanceof com.permission.n0) || a1.g().i() > 2.0f || Build.VERSION.SDK_INT > 28) {
            com.permission.v0 v0Var2 = new com.permission.v0();
            v0Var2.a = 2131558497;
            v0Var2.b = 2131558496;
            v0Var2.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.u2(view);
                }
            };
            v0Var2.d = Boolean.valueOf(n0.a("already_autorun", false));
            arrayList.add(v0Var2);
        }
        if (a1.g().h() instanceof b1) {
            com.permission.v0 v0Var3 = new com.permission.v0();
            v0Var3.a = 2131558502;
            v0Var3.b = 2131558501;
            v0Var3.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.y2(view);
                }
            };
            v0Var3.d = Boolean.valueOf(n0.a("already_better_power", false));
            arrayList.add(v0Var3);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19 && !x0.m().q()) {
            com.permission.v0 v0Var4 = new com.permission.v0();
            v0Var4.a = 2131558514;
            v0Var4.b = 2131558513;
            v0Var4.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x.z2(view);
                }
            };
            v0Var4.d = Boolean.FALSE;
            arrayList.add(v0Var4);
        }
        if (i2 >= 23) {
            com.permission.v0 v0Var5 = new com.permission.v0();
            v0Var5.a = 2131558500;
            v0Var5.b = 2131558499;
            v0Var5.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x0.m().d();
                }
            };
            v0Var5.d = Boolean.valueOf(x0.m().o());
            arrayList.add(v0Var5);
        }
        if (i2 > 19) {
            com.permission.v0 v0Var6 = new com.permission.v0();
            v0Var6.a = 2131558515;
            v0Var6.b = 2131558512;
            v0Var6.d = Boolean.valueOf(x0.m().r());
            v0Var6.e = new View.OnClickListener() { // from class: com.jsj.autojs.i.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x.B2(view);
                }
            };
            arrayList.add(v0Var6);
        }
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131296439) {
            Y1();
            return;
        }
        if (id != 2131296986) {
            return;
        }
        if (com.user.p.g().j()) {
            c0.e().h();
            return;
        }
        s.a aVar = new s.a(v0.g().d());
        aVar.r("知道了", null);
        aVar.m("反馈", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.i.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c0.e().g();
            }
        });
        aVar.j("群交流需要通过QQ进行反馈，您还未安装QQ请先安装QQ。");
        aVar.t("温馨提示");
        aVar.e().show();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        try {
            ((com.permission.v0) baseQuickAdapter.getItem(i2)).e.onClick(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        w0.j(new Runnable() { // from class: com.jsj.autojs.i.c
            @Override // java.lang.Runnable
            public final void run() {
                x.E2();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            a2().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            a2().requestWindowFeature(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        View viewInflate = layoutInflater.inflate(2131492973, viewGroup);
        l2(viewInflate);
        return viewInflate;
    }
}
