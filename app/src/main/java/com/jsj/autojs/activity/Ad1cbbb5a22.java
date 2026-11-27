package com.jsj.autojs.activity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.k0;
import com.tencent.cursor.R;
import com.user.AccountTool;
import com.user.model.WechatModel;
import com.yl.ui.CropActivity;
import com.yl.ui.s;
import com.yl.ui.v;
import i.h.f;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Ad1cbbb5a22 extends com.yl.ui.p implements View.OnClickListener {
    private ImageView P;
    private TextView Q;
    private TextView U;
    private TextView V;
    private TextView W;
    private WechatModel Z;
    private File a0;
    private boolean b0;
    private final androidx.activity.result.d<Intent> c0 = u(new androidx.activity.result.l.f(), new androidx.activity.result.c() { // from class: com.jsj.autojs.activity.y5
        @Override // androidx.activity.result.c
        public final void a(Object obj) throws IOException {
            this.a.B0((androidx.activity.result.b) obj);
        }
    });
    private final androidx.activity.result.d<Intent> d0 = u(new androidx.activity.result.l.f(), new androidx.activity.result.c() { // from class: com.jsj.autojs.activity.w5
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.D0((androidx.activity.result.b) obj);
        }
    });

    class a implements f.b<String> {
        final /* synthetic */ String a;
        final /* synthetic */ Dialog b;

        a(String str, Dialog dialog) {
            this.a = str;
            this.b = dialog;
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Ad1cbbb5a22.this.u0();
            Ad1cbbb5a22 ad1cbbb5a22 = Ad1cbbb5a22.this;
            ad1cbbb5a22.Y(ad1cbbb5a22.T0(str, "昵称保存失败，请稍后重试"));
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Ad1cbbb5a22.this.Z.setName(this.a);
            AccountTool.d().w(Ad1cbbb5a22.this.Z);
            Ad1cbbb5a22.this.Q.setText(this.a);
            Ad1cbbb5a22.this.U.setText(this.a);
            this.b.cancel();
            Ad1cbbb5a22.this.u0();
            com.yl.ui.i0.k(Ad1cbbb5a22.this, null);
            Ad1cbbb5a22.this.Y("昵称已更新");
        }
    }

    class b implements f.b<String> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Ad1cbbb5a22 ad1cbbb5a22 = Ad1cbbb5a22.this;
            ad1cbbb5a22.W0(this.b, ad1cbbb5a22.T0(str, "头像保存失败，请稍后重试"));
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Ad1cbbb5a22.this.Z.setHeadimgurl(this.a);
            AccountTool.d().w(Ad1cbbb5a22.this.Z);
            Ad1cbbb5a22.this.u0();
            Ad1cbbb5a22.this.s0();
            com.yl.ui.i0.k(Ad1cbbb5a22.this, null);
            Ad1cbbb5a22.this.Y("头像已更新");
            com.frame.k0.i("modify_userheader");
        }
    }

    class c implements f.b<String> {
        c() {
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Ad1cbbb5a22.this.u0();
            Ad1cbbb5a22 ad1cbbb5a22 = Ad1cbbb5a22.this;
            ad1cbbb5a22.Y(ad1cbbb5a22.T0(str, "退出失败，请稍后重试"));
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            AccountTool.d().s();
            Ad1cbbb5a22.this.u0();
            Ad1cbbb5a22.this.finish();
        }
    }

    class d implements f.b<String> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            AccountTool.d().s();
            Ad1cbbb5a22.this.finish();
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Ad1cbbb5a22.this.u0();
            Ad1cbbb5a22 ad1cbbb5a22 = Ad1cbbb5a22.this;
            ad1cbbb5a22.Y(ad1cbbb5a22.T0(str, "提交失败，请稍后重试或联系客服"));
        }

        @Override // i.h.f.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Ad1cbbb5a22.this.u0();
            Toast.makeText(Ad1cbbb5a22.this, "注销申请已提交，请等待审核", 1).show();
            com.frame.l1.f(new Runnable() { // from class: com.jsj.autojs.activity.s5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(androidx.activity.result.b bVar) throws IOException {
        if (bVar.b() != -1) {
            s0();
            return;
        }
        try {
            File file = this.a0;
            if (file == null || !file.exists()) {
                throw new IOException("Crop result is missing");
            }
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.a0.getAbsolutePath());
            if (bitmapDecodeFile == null) {
                throw new IOException("Crop result cannot be decoded");
            }
            this.P.setImageBitmap(bitmapDecodeFile);
            if (a1()) {
                c1(this.Z.getHeadimgurl());
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            Y("图片处理失败，请重新选择");
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(androidx.activity.result.b bVar) {
        if (bVar.b() != -1 || bVar.a() == null) {
            return;
        }
        Uri data = bVar.a().getData();
        if (data == null) {
            Y("未能读取所选图片");
            return;
        }
        try {
            s0();
            this.a0 = File.createTempFile("crop_", ".jpg", getCacheDir());
            Intent intent = new Intent(this, (Class<?>) CropActivity.class);
            intent.setData(data);
            intent.putExtra("outputX", 300);
            intent.putExtra("outputY", 300);
            intent.putExtra("output", this.a0.getAbsolutePath());
            this.c0.a(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
            s0();
            Y("无法读取所选图片，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "kefu");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(final com.yl.ui.s sVar, final EditText editText, DialogInterface dialogInterface) {
        sVar.findViewById(com.yl.ui.s.e).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.b6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.K0(editText, sVar, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(EditText editText, com.yl.ui.s sVar, View view) {
        String strTrim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            Y("请填写注销原因");
        } else {
            sVar.cancel();
            b1(strTrim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0(DialogInterface dialogInterface, int i2) {
        S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O0(String str) {
        W0(str, "头像上传失败，请检查网络后重试");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(final String str) throws IOException {
        try {
            String strA = com.frame.p0.h().A(this.a0.getAbsolutePath(), AccountTool.d().e());
            if (TextUtils.isEmpty(strA)) {
                throw new IOException("Upload result is empty");
            }
            String strOptString = new JSONObject(strA).optString("json");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IOException("Avatar URL is empty");
            }
            f.a aVar = new f.a();
            aVar.f("/modifyUser");
            aVar.e("headimgurl", strOptString);
            aVar.a().l(String.class, new b(strOptString, str));
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.r5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.O0(str);
                }
            });
        }
    }

    private void R0(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bumptech.glide.c.v(this).v(2131230906).q0(this.P);
        } else {
            com.bumptech.glide.c.v(this).w(str).R(2131230906).h(2131230906).q0(this.P);
        }
    }

    private void S0() {
        if (a1()) {
            f.a aVar = new f.a();
            aVar.f("/logout");
            aVar.a().l(String.class, new c());
            com.frame.k0.i("logout");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T0(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    private void U0() {
        if (AccountTool.d().m()) {
            com.jsj.autojs.l.c0.e().h();
            return;
        }
        s.a aVar = new s.a(this);
        aVar.g(2131231019);
        aVar.r("开通会员", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.z5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.F0(dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.j("会员交流群面向 VIP 用户开放，可用于功能交流、问题反馈和经验分享。");
        aVar.t("会员专属服务");
        aVar.e().show();
    }

    private void V0() {
        String str;
        String name = TextUtils.isEmpty(this.Z.getName()) ? "未设置昵称" : this.Z.getName();
        this.Q.setText(name);
        this.U.setText(name);
        ((TextView) findViewById(2131297232)).setText(d1(this.Z.getId()));
        R0(this.Z.getHeadimgurl());
        boolean z = this.Z.getPid() != null;
        View viewFindViewById = findViewById(2131296775);
        View viewFindViewById2 = findViewById(2131296586);
        viewFindViewById.setVisibility(z ? 0 : 8);
        viewFindViewById2.setVisibility(z ? 0 : 8);
        if (z) {
            viewFindViewById.setOnClickListener(this);
            ((TextView) findViewById(2131297252)).setText(d1(this.Z.getPid()));
        }
        if (AccountTool.d().m()) {
            this.W.setText("已开通，可进入专属交流群");
            str = "VIP 会员";
        } else if (AccountTool.d().n()) {
            this.W.setText("会员已过期，续费后可加入");
            str = "会员已过期";
        } else {
            this.W.setText("开通会员后可加入");
            str = "普通用户";
        }
        TextView textView = this.V;
        if (z) {
            str = str + " · 子账号";
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str, String str2) {
        R0(str);
        u0();
        s0();
        Y(str2);
    }

    private void X0() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            this.d0.a(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
            Y("无法打开系统图片选择器");
        }
    }

    private void Y0() {
        if (this.Z.getPid() != null) {
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("联系客服", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.t5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.jsj.autojs.l.c0.e().g();
                }
            });
            aVar.m("取消", null);
            aVar.j("当前为子账号，需由主账号同意后办理注销。如需帮助，请联系客服。");
            aVar.t("子账号注销说明");
            aVar.e().show();
            return;
        }
        View viewInflate = View.inflate(this, 2131492983, null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.edit_content);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(k0.a.DEFAULT_DRAG_ANIMATION_DURATION)});
        s.a aVar2 = new s.a(this);
        aVar2.g(2131231019);
        aVar2.u(viewInflate);
        aVar2.r("提交申请", null);
        aVar2.m("取消", null);
        aVar2.t("申请注销账号");
        aVar2.j("审核通过后，账号及相关数据将被删除且无法恢复。请填写注销原因。");
        final com.yl.ui.s sVarE = aVar2.e();
        sVarE.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.jsj.autojs.activity.c6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.a.H0(sVarE, editText, dialogInterface);
            }
        });
        sVarE.show();
    }

    private void Z0() {
        s.a aVar = new s.a(this);
        aVar.g(2131231019);
        aVar.t("确认退出登录？");
        aVar.j("退出后需重新登录才能继续使用账号、会员和云端服务。");
        aVar.r("退出登录", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.v5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.M0(dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.e().show();
    }

    private boolean a1() {
        if (this.b0) {
            Y("操作处理中，请稍候");
            return false;
        }
        this.b0 = true;
        U();
        return true;
    }

    private void b1(String str) {
        if (a1()) {
            f.a aVar = new f.a();
            aVar.f("/logoffApply");
            aVar.e("mobile", "");
            aVar.e("descr", str);
            aVar.a().l(String.class, new d());
        }
    }

    private void c1(final String str) {
        new Thread(new Runnable() { // from class: com.jsj.autojs.activity.x5
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.c.Q0(str);
            }
        }).start();
    }

    private String d1(Long l2) {
        return l2 == null ? "--" : String.valueOf(l2);
    }

    private void r0(Dialog dialog, String str) {
        if (a1()) {
            f.a aVar = new f.a();
            aVar.f("/modifyUser");
            aVar.e("name", str);
            aVar.e("nickname", str);
            aVar.a().l(String.class, new a(str, dialog));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        File file = this.a0;
        if (file != null && file.exists() && !this.a0.delete()) {
            this.a0.deleteOnExit();
        }
        this.a0 = null;
    }

    private void t0(String str, Long l2) {
        if (l2 == null) {
            Y(str + "暂不可用");
            return;
        }
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, String.valueOf(l2)));
        com.yl.ui.i0.k(this, null);
        Toast.makeText(this, str + "已复制", 0).show();
        com.frame.k0.i("copy_user_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.b0 = false;
        S();
    }

    private void v0() {
        v.a aVar = new v.a(this);
        aVar.k(this.Z.getName());
        aVar.n("修改昵称");
        aVar.f("请输入昵称");
        aVar.l(1);
        aVar.j(1);
        aVar.i(20);
        final com.yl.ui.v vVarD = aVar.d();
        if (vVarD != null) {
            vVarD.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.jsj.autojs.activity.u5
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.a.z0(vVarD, dialogInterface);
                }
            });
            vVarD.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(EditText editText, com.yl.ui.v vVar, View view) {
        String strTrim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            Y("昵称不能为空");
            return;
        }
        if (strTrim.length() > 20) {
            Y("昵称不能超过 20 个字");
        } else if (strTrim.equals(this.Z.getName())) {
            vVar.cancel();
        } else {
            r0(vVar, strTrim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(final com.yl.ui.v vVar, DialogInterface dialogInterface) {
        final EditText editText = (EditText) vVar.findViewById(R.id.edit_content);
        vVar.findViewById(com.yl.ui.v.c).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.a6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.x0(editText, vVar, view);
            }
        });
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492912;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("个人信息");
        findViewById(2131296799).setOnClickListener(this);
        findViewById(2131297250).setOnClickListener(this);
        findViewById(2131296785).setOnClickListener(this);
        findViewById(2131296779).setOnClickListener(this);
        findViewById(2131296774).setOnClickListener(this);
        findViewById(2131296764).setOnClickListener(this);
        this.P = (ImageView) findViewById(2131296823);
        this.Q = (TextView) findViewById(2131297255);
        this.U = (TextView) findViewById(2131297226);
        this.V = (TextView) findViewById(2131297201);
        this.W = (TextView) findViewById(2131297296);
        WechatModel wechatModelC = AccountTool.d().c();
        this.Z = wechatModelC;
        if (wechatModelC == null) {
            finish();
        } else {
            V0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b0) {
            Y("操作处理中，请稍候");
        }
        switch (view.getId()) {
            case 2131296764:
                t0("账号 ID", this.Z.getId());
                break;
            case 2131296774:
                Y0();
                break;
            case 2131296775:
                t0("主账号 ID", this.Z.getPid());
                break;
            case 2131296779:
                v0();
                break;
            case 2131296785:
                X0();
                break;
            case 2131296799:
                U0();
                break;
            case 2131297250:
                Z0();
                break;
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        s0();
        super.onDestroy();
    }
}
