package com.jsj.autojs.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.cursor.R;
import com.user.AccountTool;
import com.user.model.WechatModel;
import com.yl.ui.f0;
import com.yl.ui.s;
import i.b.u8;
import i.h.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class A63ddcc819d extends com.yl.ui.p implements View.OnClickListener {
    private WechatModel P;
    private String Q;
    private TextView U;
    private final androidx.activity.result.d<Uri> V = u(new androidx.activity.result.l.d(), new androidx.activity.result.c() { // from class: com.jsj.autojs.activity.l1
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.L0((Uri) obj);
        }
    });

    class a extends i.h.g<Long> {
        a(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            A63ddcc819d.this.S();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Long l2) {
            A63ddcc819d.this.S();
            A63ddcc819d.this.U.setText("已邀请" + l2 + "人");
        }
    }

    class b implements f0.b {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        b(A63ddcc819d a63ddcc819d, String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.yl.ui.f0.b
        public void a(Dialog dialog) {
            com.user.p.g().c(com.frame.v0.g().d(), this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void b(Dialog dialog) {
            com.user.p.g().a(com.frame.v0.g().d(), this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void c(Dialog dialog) {
            com.user.w.h().D(this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void d(Dialog dialog) {
            com.user.w.h().F(2131231011, this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0() {
        S();
        com.jsj.autojs.l.c0.e().B("导出失败", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(h.h.a.a aVar, DialogInterface dialogInterface, int i2) {
        com.frame.k0.u(this, aVar.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(final String str, final h.h.a.a aVar) {
        try {
            s.a aVar2 = new s.a(this);
            aVar2.g(R.drawable.great_icon);
            aVar2.t("温馨提示");
            aVar2.j("图片导出成功路径：" + str + " 路径已复制至剪切板");
            aVar2.r("发送", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.o1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.F0(aVar, dialogInterface, i2);
                }
            });
            aVar2.m("复制地址", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.r1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.frame.m0.a(str);
                }
            });
            aVar2.e().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(Uri uri) {
        if (uri == null) {
            S();
            com.jsj.autojs.l.c0.e().B("未选择文件夹", null);
            return;
        }
        getContentResolver().takePersistableUriPermission(uri, 3);
        Log.d("SAF", "已授权目录：" + uri);
        final h.h.a.a aVarG = h.h.a.a.g(this, uri);
        if (aVarG == null || !aVarG.a()) {
            Log.e("SAF", "目录无写入权限");
            return;
        }
        final View viewFindViewById = findViewById(2131296924);
        U();
        viewFindViewById.post(new Runnable() { // from class: com.jsj.autojs.activity.k1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.B0(viewFindViewById, aVarG);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public void p0(Bitmap bitmap, h.h.a.a aVar) {
        Runnable runnable;
        try {
            try {
            } finally {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.k8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.S();
                    }
                });
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.v1
                @Override // java.lang.Runnable
                public final void run() {
                    com.jsj.autojs.l.c0.e().B("文件写入失败", e);
                }
            });
            runnable = new Runnable() { // from class: com.jsj.autojs.activity.k8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.S();
                }
            };
        }
        if (bitmap == null || aVar == null) {
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.m1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.D0();
                }
            });
            return;
        }
        String str = getCacheDir() + "/share_" + System.currentTimeMillis() + ".png";
        com.frame.l0.d(bitmap, new File(str));
        File file = new File(str);
        if (!file.exists()) {
            throw new IllegalStateException("cache image save failed");
        }
        String name = file.getName();
        h.h.a.a aVarE = aVar.e(name);
        if (aVarE != null && aVarE.d()) {
            aVarE.c();
        }
        final h.h.a.a aVarB = aVar.b("image/png", name);
        if (aVarB == null) {
            Log.e("SAF", "创建文件失败");
            file.delete();
            throw new IllegalStateException("create file failed");
        }
        try {
            OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(aVarB.i());
            try {
                o.a.b.a(new FileInputStream(file), outputStreamOpenOutputStream);
                Log.i("SAF", "图片导出成功 路径：" + aVarB.i());
                final String strDecode = URLDecoder.decode(String.valueOf(aVarB.i()), StandardCharsets.UTF_8.name());
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.u1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.I0(strDecode, aVarB);
                    }
                });
                if (outputStreamOpenOutputStream != null) {
                    outputStreamOpenOutputStream.close();
                }
                file.delete();
                runnable = new Runnable() { // from class: com.jsj.autojs.activity.k8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.S();
                    }
                };
                com.frame.l1.e(runnable);
            } finally {
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void B0(View view, final h.h.a.a aVar) {
        try {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            Bitmap drawingCache = view.getDrawingCache();
            final Bitmap bitmapCreateBitmap = (drawingCache == null || drawingCache.getWidth() <= 0 || drawingCache.getHeight() <= 0 || drawingCache.isRecycled()) ? null : Bitmap.createBitmap(drawingCache);
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            if (bitmapCreateBitmap != null) {
                com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.q1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.p0(bitmapCreateBitmap, aVar);
                    }
                });
            } else {
                com.jsj.autojs.l.c0.e().B("截图为空，请稍后重试", null);
                S();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(DialogInterface dialogInterface, int i2) {
        androidx.core.app.f.l(this, new String[]{"android.permission.CAMERA"}, 1026);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(View view) {
        startActivity(new Intent(com.frame.v0.g(), (Class<?>) InputInviteAct934934.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v0() {
        AccountTool.d().y(null, null);
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.s1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(String str) {
        new u8().a(str, new Runnable() { // from class: com.jsj.autojs.activity.j1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.v0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0() {
        try {
            s.a aVar = new s.a(this);
            aVar.t("温馨提示");
            aVar.j("已绑定邀请码，免费获得vip体验，请重新登录账号查看");
            aVar.r("知道了", null);
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void K0() {
        f.a aVar = new f.a();
        aVar.f("/countInviteUser");
        aVar.a().l(Long.class, new a(this));
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492903;
    }

    @Override // com.yl.ui.p
    public void b0() throws Resources.NotFoundException {
        super.b0();
        this.U = (TextView) findViewById(2131297158);
        findViewById(R.id.iv_back).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(2131296823);
        TextView textView = (TextView) findViewById(2131297169);
        TextView textView2 = (TextView) findViewById(2131297155);
        TextView textView3 = (TextView) findViewById(2131297159);
        TextView textView4 = (TextView) findViewById(2131297175);
        ImageView imageView2 = (ImageView) findViewById(2131296987);
        ImageView imageView3 = (ImageView) findViewById(2131296406);
        ImageView imageView4 = (ImageView) findViewById(2131296357);
        ImageView imageView5 = (ImageView) findViewById(2131296370);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        textView2.setOnClickListener(this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(com.frame.v0.g(), R.anim.push_up_in);
        animationLoadAnimation.setStartOffset(160L);
        imageView3.startAnimation(animationLoadAnimation);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(com.frame.v0.g(), R.anim.push_up_in);
        animationLoadAnimation2.setStartOffset(240L);
        imageView4.startAnimation(animationLoadAnimation2);
        Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(com.frame.v0.g(), R.anim.push_up_in);
        animationLoadAnimation3.setStartOffset(320L);
        imageView5.startAnimation(animationLoadAnimation3);
        WechatModel wechatModelC = AccountTool.d().c();
        this.P = wechatModelC;
        if (wechatModelC != null) {
            try {
                this.Q = com.frame.n1.h(this.P.getId() + "", "4jso$dkm#kkd*lsdk@");
                textView.setText("ID：" + this.P.getId());
                textView2.setText("邀请码：" + this.Q);
                textView4.setText(this.P.getName());
                if (AccountTool.d().l()) {
                    textView3.setText("终身会员");
                } else if (AccountTool.d().m()) {
                    textView3.setText("会员用户");
                } else {
                    textView3.setText("普通用户");
                }
                com.bumptech.glide.c.v(this).w(this.P.getHeadimgurl()).q0(imageView);
                imageView2.setImageBitmap(new com.jsj.autojs.l.f0().c("邀请码：" + this.Q));
                com.frame.m0.a(this.Q);
                if (this.P.getCid() == null) {
                    long jE = com.frame.m1.e(this.P.getInsertTime(), "yyyy-MM-dd HH:mm");
                    if (!AccountTool.d().m() && System.currentTimeMillis() - jE < 6.048E8f) {
                        i0("填写邀请码", new View.OnClickListener() { // from class: com.jsj.autojs.activity.t1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.c.t0(view);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            finish();
        }
        K0();
    }

    public boolean m0() {
        if (androidx.core.content.a.a(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        s.a aVar = new s.a(this);
        aVar.j("扫描邀请码需要用到相机权限扫描？");
        aVar.m("取消", null);
        aVar.r("开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.p1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.r0(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
        return false;
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1024) {
            if (i2 == 1026 && i3 == -1) {
                new com.jsj.autojs.l.f0().j(this, 1024);
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("qrcode_result");
            if (TextUtils.isEmpty(stringExtra) || !stringExtra.contains("邀请码")) {
                return;
            }
            final String str = stringExtra.split("：")[1];
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.n1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.x0(str);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296357:
                if (this.P.getCid() == null) {
                    if (m0()) {
                        new com.jsj.autojs.l.f0().j(this, 1024);
                        break;
                    }
                } else {
                    s.a aVar = new s.a(this);
                    aVar.j("您已经填写过邀请码，不需要重复填写了");
                    aVar.g(2131231260);
                    aVar.r("知道了", null);
                    aVar.t("温馨提示");
                    aVar.e().show();
                    break;
                }
                break;
            case 2131296370:
                this.V.a(null);
                break;
            case 2131296406:
                try {
                    String str = "邀请码：" + this.Q;
                    f0.a aVar2 = new f0.a(this);
                    aVar2.c(new b(this, "自动脚本精灵-邀请码", str, "https://a.app.qq.com/o/simple.jsp?pkgname=com.jsj.autojs"));
                    aVar2.a().show();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.iv_back /* 2131296824 */:
                finish();
                break;
            case 2131296987:
            case 2131297155:
                com.frame.m0.a(this.Q);
                Y("邀请码已复制");
                break;
        }
    }
}
