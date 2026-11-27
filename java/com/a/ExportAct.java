package com.a;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.FloatToast;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import com.yl.ui.v;
import com.yl.widget.TitleBar;
import i.b.da;
import i.b.l9;
import i.b.s8;
import i.b.v7;
import i.h.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExportAct extends com.yl.ui.p {
    Task P;
    private String Q;
    private String U;
    private List<TaskSimple> V;
    private Long W;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private l9 c0;
    private final androidx.activity.result.d<Uri> d0 = u(new androidx.activity.result.l.d(), new androidx.activity.result.c() { // from class: com.a.o
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.m2((Uri) obj);
        }
    });

    class a extends ClickableSpan {
        final /* synthetic */ Long c;
        final /* synthetic */ TextView d;
        final /* synthetic */ int e;

        a(Long l2, TextView textView, int i2) {
            this.c = l2;
            this.d = textView;
            this.e = i2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ExportAct.this.k2(this.c, this.d, this.e);
        }
    }

    class b extends i.h.g<String> {
        final /* synthetic */ Long b;
        final /* synthetic */ TextView c;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Long l2, TextView textView, int i2) {
            super(activity);
            this.b = l2;
            this.c = textView;
            this.d = i2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            ExportAct.this.b0 = false;
            if (ExportAct.this.isFinishing() || ExportAct.this.isDestroyed()) {
                return;
            }
            ExportAct.this.S();
            ExportAct.this.Y("查询创建者失败：" + str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            ExportAct.this.b0 = false;
            if (ExportAct.this.isFinishing() || ExportAct.this.isDestroyed()) {
                return;
            }
            ExportAct.this.S();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optLong("id", 0L) != this.b.longValue()) {
                    throw new IllegalArgumentException("未找到创建者用户");
                }
                ExportAct.y2(this.c, this.d, jSONObject.optString("name", ""));
            } catch (Exception e) {
                ExportAct.this.Y("查询创建者失败：" + e.getMessage());
            }
        }
    }

    class c extends i.h.g<String> {
        final /* synthetic */ Dialog b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, Dialog dialog, long j2) {
            super(activity);
            this.b = dialog;
            this.c = j2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            if (this.b.isShowing()) {
                ExportAct.this.S();
                ExportAct.this.a0 = false;
                ExportAct.this.Y("用户验证失败：" + str);
            }
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            if (this.b.isShowing()) {
                ExportAct.this.S();
                ExportAct.this.a0 = false;
                try {
                    if (new JSONObject(str).optLong("id", 0L) != this.c) {
                        throw new IllegalArgumentException("接收用户不存在，请检查用户ID");
                    }
                    ExportAct.this.l2();
                    ExportAct.this.W = Long.valueOf(this.c);
                    ExportAct.this.d0.a(null);
                    this.b.dismiss();
                } catch (Exception e) {
                    ExportAct.this.W = null;
                    ExportAct.this.Y("用户验证失败：" + e.getMessage());
                }
            }
        }
    }

    enum d {
        UPLOAD,
        SHARE_ORIGINAL,
        MISSING_ORIGINAL_SHARE_ID
    }

    static boolean A0(File file) {
        return file.length() > 5242880;
    }

    private static String A2(String str, Long l2) {
        if (str == null || str.length() == 0) {
            if (l2 == null) {
                return "未知用户";
            }
            return "用户ID:" + l2;
        }
        if (l2 == null) {
            return str;
        }
        return str + "(" + l2 + ")";
    }

    private boolean B0() {
        View viewFindViewById = findViewById(j.b.e.r);
        return viewFindViewById == null || viewFindViewById.isSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C1() {
        o2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(DialogInterface dialogInterface) {
        o2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ac A[Catch: all -> 0x018f, Exception -> 0x0191, TryCatch #5 {Exception -> 0x0191, blocks: (B:4:0x0009, B:5:0x000c, B:7:0x0024, B:8:0x002a, B:11:0x006b, B:17:0x00d4, B:19:0x00db, B:20:0x00fe, B:23:0x0106, B:25:0x010c, B:26:0x010f, B:40:0x0141, B:66:0x017f, B:67:0x0186, B:64:0x017b, B:65:0x017e, B:68:0x0187, B:69:0x018e, B:12:0x0095, B:13:0x00ac, B:15:0x00b0), top: B:91:0x0009, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4 A[Catch: all -> 0x018f, Exception -> 0x0191, TryCatch #5 {Exception -> 0x0191, blocks: (B:4:0x0009, B:5:0x000c, B:7:0x0024, B:8:0x002a, B:11:0x006b, B:17:0x00d4, B:19:0x00db, B:20:0x00fe, B:23:0x0106, B:25:0x010c, B:26:0x010f, B:40:0x0141, B:66:0x017f, B:67:0x0186, B:64:0x017b, B:65:0x017e, B:68:0x0187, B:69:0x018e, B:12:0x0095, B:13:0x00ac, B:15:0x00b0), top: B:91:0x0009, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0187 A[Catch: all -> 0x018f, Exception -> 0x0191, TryCatch #5 {Exception -> 0x0191, blocks: (B:4:0x0009, B:5:0x000c, B:7:0x0024, B:8:0x002a, B:11:0x006b, B:17:0x00d4, B:19:0x00db, B:20:0x00fe, B:23:0x0106, B:25:0x010c, B:26:0x010f, B:40:0x0141, B:66:0x017f, B:67:0x0186, B:64:0x017b, B:65:0x017e, B:68:0x0187, B:69:0x018e, B:12:0x0095, B:13:0x00ac, B:15:0x00b0), top: B:91:0x0009, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[Catch: all -> 0x018f, Exception -> 0x0191, TryCatch #5 {Exception -> 0x0191, blocks: (B:4:0x0009, B:5:0x000c, B:7:0x0024, B:8:0x002a, B:11:0x006b, B:17:0x00d4, B:19:0x00db, B:20:0x00fe, B:23:0x0106, B:25:0x010c, B:26:0x010f, B:40:0x0141, B:66:0x017f, B:67:0x0186, B:64:0x017b, B:65:0x017e, B:68:0x0187, B:69:0x018e, B:12:0x0095, B:13:0x00ac, B:15:0x00b0), top: B:91:0x0009, outer: #6 }] */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void E1(Long l2, h.h.a.a aVar) {
        Runnable runnable;
        Task task;
        File fileX0 = null;
        try {
            if (l2 != null) {
                try {
                    l2();
                    long j2 = (Long) findViewById(j.b.e.y).getTag();
                    if (findViewById(j.b.e.w).isSelected()) {
                        j2 = -1L;
                    }
                    Long l3 = j2;
                    Long l4 = (Long) findViewById(j.b.e.x).getTag();
                    String str = (String) findViewById(j.b.e.E).getTag();
                    boolean zIsSelected = findViewById(j.b.e.f1753l).isSelected();
                    boolean zIsSelected2 = findViewById(j.b.e.d).isSelected();
                    v7 v7Var = new v7();
                    v7Var.z(B0());
                    task = this.P;
                    if (task != null) {
                        String str2 = this.U;
                        if (str2 != null) {
                            fileX0 = x0(str2, this.V, zIsSelected, zIsSelected2, str, l4, l3, AccountTool.d().g(), B0(), false, l2);
                        }
                    } else if (l2 != null) {
                        fileX0 = v7Var.n((Task) com.frame.k0.l("task:" + this.P.getId(), Task.class), null, l2.longValue(), zIsSelected, zIsSelected2, str, l4, l3);
                    } else {
                        fileX0 = v7Var.o(task.getId(), zIsSelected, zIsSelected2, str, l4, l3, AccountTool.d().g());
                    }
                    if (fileX0 != null) {
                        throw new IllegalStateException("未生成脚本文件");
                    }
                    String name = fileX0.getName();
                    if (l2 != null) {
                        name = name.substring(0, name.length() - 4) + "-转让-" + l2 + ".zip";
                    }
                    h.h.a.a aVarE = aVar.e(name);
                    if (l2 == null && aVarE != null && aVarE.d()) {
                        aVarE.c();
                    }
                    final h.h.a.a aVarB = aVar.b("application/zip", name);
                    if (aVarB == null) {
                        throw new IllegalStateException("创建文件失败");
                    }
                    try {
                        OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(aVarB.i());
                        try {
                            if (outputStreamOpenOutputStream == null) {
                                throw new IllegalStateException("无法打开目标文件");
                            }
                            FileInputStream fileInputStream = new FileInputStream(fileX0);
                            try {
                                byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
                                while (true) {
                                    int i2 = fileInputStream.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    } else {
                                        outputStreamOpenOutputStream.write(bArr, 0, i2);
                                    }
                                }
                                fileInputStream.close();
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                                com.frame.l1.e(new Runnable() { // from class: com.a.p
                                    @Override // java.lang.Runnable
                                    public final void run() throws UnsupportedEncodingException {
                                        this.c.A1(aVarB);
                                    }
                                });
                                if (fileX0 != null) {
                                    fileX0.delete();
                                }
                                S();
                                runnable = new Runnable() { // from class: com.a.j0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.c.C1();
                                    }
                                };
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Exception e) {
                        aVarB.c();
                        throw e;
                    }
                } catch (Exception e2) {
                    v2("导出失败", e2);
                    if (0 != 0) {
                        fileX0.delete();
                    }
                    S();
                    runnable = new Runnable() { // from class: com.a.j0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.C1();
                        }
                    };
                }
            } else {
                long j22 = (Long) findViewById(j.b.e.y).getTag();
                if (findViewById(j.b.e.w).isSelected()) {
                }
                Long l32 = j22;
                Long l42 = (Long) findViewById(j.b.e.x).getTag();
                String str3 = (String) findViewById(j.b.e.E).getTag();
                boolean zIsSelected3 = findViewById(j.b.e.f1753l).isSelected();
                boolean zIsSelected22 = findViewById(j.b.e.d).isSelected();
                v7 v7Var2 = new v7();
                v7Var2.z(B0());
                task = this.P;
                if (task != null) {
                }
                if (fileX0 != null) {
                }
            }
            com.frame.l1.e(runnable);
        } catch (Throwable th) {
            if (0 != 0) {
                fileX0.delete();
            }
            S();
            com.frame.l1.e(new Runnable() { // from class: com.a.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.C1();
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean G0(Dialog dialog, String str) {
        if (this.a0) {
            return false;
        }
        try {
            l2();
            long jY = v7.y(str, AccountTool.d().g());
            this.a0 = true;
            V("验证接收用户...");
            f.a aVar = new f.a();
            aVar.f("/getUserInfoById");
            aVar.d("id", Long.valueOf(jY));
            aVar.a().l(String.class, new c(this, dialog, jY));
            return false;
        } catch (Exception e) {
            Y(e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1() {
        Y("请先登录~");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(JSONObject jSONObject) {
        Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0() {
        S();
        v2("生成的文件超过5MB，无法生成云分享码。请使用「导出文件」保存并分享。", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1() {
        Y("未找到可以处理的应用");
    }

    static /* synthetic */ boolean K0(View view, Dialog dialog, String str) {
        view.setSelected(true);
        view.setTag(str);
        return true;
    }

    static /* synthetic */ void L0(final View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            view.setTag(null);
            return;
        }
        try {
            v.a aVar = new v.a(com.frame.v0.g().d());
            aVar.j(1);
            aVar.l(1);
            aVar.n("温馨提示");
            aVar.f("请输入提取码");
            aVar.g(new v.b() { // from class: com.a.d
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return ExportAct.K0(view, dialog, str);
                }
            });
            aVar.d().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(Task task) {
        Uri uriFromFile;
        try {
            long j2 = (Long) findViewById(j.b.e.y).getTag();
            if (findViewById(j.b.e.w).isSelected()) {
                j2 = -1L;
            }
            Long l2 = (Long) findViewById(j.b.e.x).getTag();
            String str = (String) findViewById(j.b.e.E).getTag();
            File fileP = new v7().p(task.getId(), findViewById(j.b.e.f1753l).isSelected(), findViewById(j.b.e.d).isSelected(), str, l2, j2, AccountTool.d().g(), B0());
            if (Build.VERSION.SDK_INT >= 24) {
                uriFromFile = FileProvider.e(getApplicationContext(), com.frame.v0.g().getPackageName() + ".fileprovider", fileP);
            } else {
                uriFromFile = Uri.fromFile(fileP);
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            intent.setType(com.frame.r0.h(fileP.getPath()));
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.DEFAULT");
            if (intent.resolveActivity(getPackageManager()) == null) {
                com.frame.l1.e(new Runnable() { // from class: com.a.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.K1();
                    }
                });
                return;
            }
            try {
                startActivity(intent);
            } catch (Exception unused) {
                intent.setData(uriFromFile);
                startActivity(intent);
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
            Y(e.getMessage());
        }
    }

    static /* synthetic */ void M0(View view, DatePicker datePicker, int i2, int i3, int i4) {
        view.setSelected(true);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i2);
        calendar.set(2, i3);
        calendar.set(5, i4);
        view.setTag(Long.valueOf(calendar.getTimeInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O0(final View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            view.setTag(null);
        } else {
            if (!AccountTool.d().m()) {
                x2("此功能是VIP权益，请先开通会员后使用。");
                return;
            }
            try {
                DatePickerDialog datePickerDialog = new DatePickerDialog(this);
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() { // from class: com.a.e
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                        ExportAct.M0(view, datePicker, i2, i3, i4);
                    }
                });
                datePickerDialog.create();
                datePickerDialog.show();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1() {
        Y("未找到可以处理的应用");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean Q0(View view, Dialog dialog, String str) {
        try {
            view.setTag(Long.valueOf(str));
            view.setSelected(true);
            return true;
        } catch (Exception unused) {
            Y("请输入正确的用户端ID");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(String str, List list) {
        Uri uriFromFile;
        try {
            try {
                long j2 = (Long) findViewById(j.b.e.y).getTag();
                if (findViewById(j.b.e.w).isSelected()) {
                    j2 = -1L;
                }
                Long l2 = (Long) findViewById(j.b.e.x).getTag();
                File fileW0 = w0(str, list, findViewById(j.b.e.f1753l).isSelected(), findViewById(j.b.e.d).isSelected(), (String) findViewById(j.b.e.E).getTag(), l2, j2, AccountTool.d().g(), B0(), false);
                if (Build.VERSION.SDK_INT >= 24) {
                    uriFromFile = FileProvider.e(getApplicationContext(), com.frame.v0.g().getPackageName() + ".fileprovider", fileW0);
                } else {
                    uriFromFile = Uri.fromFile(fileW0);
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uriFromFile);
                intent.setType(com.frame.r0.h(fileW0.getPath()));
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.DEFAULT");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    com.frame.l1.e(new Runnable() { // from class: com.a.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.O1();
                        }
                    });
                }
            } catch (Exception e) {
                com.frame.y0.l(e);
                Y(e.getMessage());
            }
        } finally {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(final View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            view.setTag(null);
            return;
        }
        if (!AccountTool.d().m()) {
            x2("此功能是VIP权益，请先开通会员后使用。");
            return;
        }
        try {
            v.a aVar = new v.a(com.frame.v0.g().d());
            aVar.n("温馨提示");
            aVar.f("请输入用户ID");
            aVar.j(1);
            aVar.l(1);
            aVar.g(new v.b() { // from class: com.a.s0
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.Q0(view, dialog, str);
                }
            });
            aVar.d().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1() {
        v2("为了确保你的权益，请先登录后再分享", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(View view) {
        if (!view.isSelected() && !AccountTool.d().m()) {
            x2("此功能是VIP权益，请先开通会员后使用。");
        } else {
            view.setSelected(!view.isSelected());
            findViewById(j.b.e.y).setVisibility(!view.isSelected() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U1(String str) {
        com.frame.m0.a(str);
        Y("分享码已复制到剪切板");
        com.frame.q1.n(this, "分享脚本", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(JSONObject jSONObject) {
        Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(Task task, View view) {
        t2(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1(Task task) {
        HashMap<String, String> map;
        File fileP;
        try {
            try {
                map = new HashMap<>();
                map.put("id", task.getId() + "");
                map.put("name", task.getName());
                map.put("token", AccountTool.d().e());
                map.put("u", com.frame.p0.h().i());
                long j2 = (Long) findViewById(j.b.e.y).getTag();
                if (findViewById(j.b.e.w).isSelected()) {
                    j2 = -1L;
                }
                Long l2 = (Long) findViewById(j.b.e.x).getTag();
                String str = (String) findViewById(j.b.e.E).getTag();
                fileP = new v7().p(task.getId(), findViewById(j.b.e.f1753l).isSelected(), findViewById(j.b.e.d).isSelected(), str, l2, j2, AccountTool.d().g(), B0());
            } catch (Exception e) {
                com.frame.y0.l(e);
                Y(e.getMessage());
                com.frame.l1.e(new com.a.a(this));
            }
            if (t0(fileP)) {
                String strZ = com.frame.p0.h().z(da.s, fileP.getPath(), map);
                if (TextUtils.isEmpty(strZ)) {
                    Y("上传出错");
                } else {
                    final JSONObject jSONObject = new JSONObject(strZ);
                    int iOptInt = jSONObject.optInt("code");
                    if (iOptInt == -5) {
                        com.frame.l1.e(new Runnable() { // from class: com.a.e0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.S1();
                            }
                        });
                        return;
                    } else if (iOptInt == 1) {
                        final String strV0 = v0(Long.valueOf(jSONObject.optJSONObject("json").optLong("id")), task.getName());
                        com.frame.l1.e(new Runnable() { // from class: com.a.x0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.U1(strV0);
                            }
                        });
                    } else {
                        com.frame.l1.e(new Runnable() { // from class: com.a.c0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.W1(jSONObject);
                            }
                        });
                    }
                }
                com.frame.l1.e(new com.a.a(this));
            }
        } finally {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(String str, List list, View view) {
        u2(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2() {
        v2("为了确保你的权益，请先登录后再分享", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b1(String str, List list, View view) {
        q2(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(JSONObject jSONObject) {
        Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1() {
        com.yl.ui.i0.k(this, new Runnable() { // from class: com.a.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(String str, boolean z, List list, Runnable runnable) {
        HashMap<String, String> map;
        Long l2;
        File fileW0;
        try {
            try {
                map = new HashMap<>();
                map.put("id", System.currentTimeMillis() + "");
                map.put("name", str);
                map.put("token", AccountTool.d().e());
                map.put("u", com.frame.p0.h().i());
                if (z) {
                    l2 = -1L;
                } else {
                    long j2 = (Long) findViewById(j.b.e.y).getTag();
                    if (findViewById(j.b.e.w).isSelected()) {
                        j2 = -1L;
                    }
                    l2 = j2;
                }
                fileW0 = w0(str, list, findViewById(j.b.e.f1753l).isSelected(), findViewById(j.b.e.d).isSelected(), (String) findViewById(j.b.e.E).getTag(), (Long) findViewById(j.b.e.x).getTag(), l2, AccountTool.d().g(), B0(), z);
            } catch (Exception e) {
                com.frame.y0.l(e);
                Y(e.getMessage());
                com.frame.l1.e(new com.a.a(this));
            }
            if (fileW0 == null) {
                return;
            }
            if (z || t0(fileW0)) {
                String strZ = com.frame.p0.h().z(da.s, fileW0.getAbsolutePath(), map);
                if (TextUtils.isEmpty(strZ)) {
                    Y("上传出错");
                } else {
                    final JSONObject jSONObject = new JSONObject(strZ);
                    int iOptInt = jSONObject.optInt("code");
                    if (iOptInt == -5) {
                        com.frame.l1.e(new Runnable() { // from class: com.a.j
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.a2();
                            }
                        });
                        return;
                    } else if (iOptInt == 1) {
                        Long lValueOf = Long.valueOf(jSONObject.optJSONObject("json").optLong("id"));
                        if (runnable != null) {
                            runnable.run();
                        } else {
                            w2(lValueOf, str);
                        }
                    } else {
                        com.frame.l1.e(new Runnable() { // from class: com.a.b0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.c2(jSONObject);
                            }
                        });
                    }
                }
                com.frame.l1.e(new com.a.a(this));
            }
        } finally {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f1(String str, List list, View view) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
        } else if (!AccountTool.d().m()) {
            x2(null);
        } else {
            U();
            s2(true, str, list, new Runnable() { // from class: com.a.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d1();
                }
            });
        }
    }

    static /* synthetic */ void f2(String str, Exception exc) {
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            int i2 = j.b.d.q0;
            aVar.g(i2);
            aVar.f();
            aVar.r("知道了", null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("</br>");
            sb.append(exc == null ? "" : exc.getMessage());
            aVar.j(sb.toString());
            aVar.t("温馨提示");
            aVar.g(i2);
            aVar.e().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h1(Long l2, View view) {
        Task task;
        if (l2.longValue() != 0) {
            task = (Task) com.frame.k0.l("task:" + l2, Task.class);
        } else {
            task = null;
        }
        this.P = task;
        this.U = l2.longValue() == 0 ? getIntent().getStringExtra("group") : null;
        this.V = l2.longValue() == 0 ? new ArrayList(da.B().D(this.U, 0)) : null;
        r0();
    }

    static /* synthetic */ void g2(DialogInterface dialogInterface, int i2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void h2(DialogInterface dialogInterface, int i2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j1(ArrayList arrayList, DialogInterface dialogInterface, int i2) {
        z2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j2(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Task taskL = da.B().L(((TaskSimple) it.next()).getId());
            if (this.c0.e(taskL)) {
                n2(taskL, B0());
            }
        }
        com.frame.l1.e(new com.a.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l1(Task task, View view) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        if (!AccountTool.d().m()) {
            x2(null);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(da.B().w(task.getId()));
        s.a aVar = new s.a(this);
        aVar.t("是否需要备份此脚本？");
        aVar.r("备份", new DialogInterface.OnClickListener() { // from class: com.a.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.j1(arrayList, dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(Long l2, TextView textView, int i2) {
        if (l2 == null || this.b0 || isFinishing() || isDestroyed()) {
            return;
        }
        this.b0 = true;
        V("查询创建者名称...");
        f.a aVar = new f.a();
        aVar.f("/getUserInfoById");
        aVar.d("id", l2);
        aVar.a().l(String.class, new b(this, l2, textView, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Task> l2() {
        ArrayList arrayList = new ArrayList();
        if (this.P != null) {
            arrayList.add((Task) com.frame.k0.l("task:" + this.P.getId(), Task.class));
        } else {
            List<TaskSimple> list = this.V;
            if (list != null) {
                Iterator<TaskSimple> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((Task) com.frame.k0.l("task:" + it.next().getId(), Task.class));
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("未找到可转让的脚本");
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            v7.f((Task) it2.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n1(View view) {
        if (AccountTool.d().m()) {
            view.setSelected(!view.isSelected());
        } else {
            x2("此功能是VIP权益，请先开通会员后使用。");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(Uri uri) {
        final Long l2 = this.W;
        this.W = null;
        if (uri == null) {
            o2(false);
            S();
            return;
        }
        try {
            getContentResolver().takePersistableUriPermission(uri, 3);
            final h.h.a.a aVarG = h.h.a.a.g(this, uri);
            if (aVarG == null || !aVarG.a()) {
                throw new IllegalStateException("目录无写入权限");
            }
            U();
            com.frame.l1.g(new Runnable() { // from class: com.a.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.E1(l2, aVarG);
                }
            });
        } catch (Exception e) {
            o2(false);
            v2("文件夹授权失败", e);
        }
    }

    private final void n2(Task task, boolean z) {
        try {
            if (task.getCreateUserId() == null && AccountTool.d().j()) {
                task.setCreateUserId(AccountTool.d().g());
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("id", task.getId() + "");
            map.put("name", task.getName());
            map.put("token", AccountTool.d().e());
            map.put("u", com.frame.p0.h().i());
            String strZ = com.frame.p0.h().z(da.s, new v7().p(task.getId(), false, false, null, null, -1L, task.getCreateUserId(), z).getPath(), map);
            if (TextUtils.isEmpty(strZ)) {
                Y("上传出错");
                return;
            }
            final JSONObject jSONObject = new JSONObject(strZ);
            int iOptInt = jSONObject.optInt("code");
            if (iOptInt == -5) {
                com.frame.l1.e(new Runnable() { // from class: com.a.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.G1();
                    }
                });
            } else if (iOptInt != 1) {
                com.frame.l1.e(new Runnable() { // from class: com.a.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.I1(jSONObject);
                    }
                });
            } else {
                jSONObject.optJSONObject("json").optLong("id");
                com.yl.ui.i0.j();
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
            Y(e.getMessage());
        }
    }

    private void o2(boolean z) {
        this.Z = z;
        if (!z) {
            this.W = null;
            this.a0 = false;
            S();
        }
        int[] iArr = {j.b.e.T, j.b.e.c1, j.b.e.g1, j.b.e.e1, j.b.e.f1751j};
        for (int i2 = 0; i2 < 5; i2++) {
            findViewById(iArr[i2]).setEnabled(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1(Task task, View view) {
        p2(task);
    }

    private final void p2(final Task task) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        l9 l9Var = this.c0;
        if (l9Var == null || l9Var.f(task)) {
            this.Q = "wx";
            com.frame.l1.g(new Runnable() { // from class: com.a.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.M1(task);
                }
            });
        }
    }

    private final void q2(final String str, final List<TaskSimple> list) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        U();
        this.Q = "wx";
        com.frame.l1.g(new Runnable() { // from class: com.a.v
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Q1(str, list);
            }
        });
    }

    private void r0() {
        if (this.Z) {
            return;
        }
        try {
            l2();
            o2(true);
            v.a aVar = new v.a(this);
            aVar.n("转让脚本");
            aVar.f("请输入接收者用户ID");
            aVar.l(1);
            aVar.j(1);
            aVar.h(2);
            aVar.e(false);
            aVar.m(new DialogInterface.OnCancelListener() { // from class: com.a.k0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.c.E0(dialogInterface);
                }
            });
            aVar.g(new v.b() { // from class: com.a.f0
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.G0(dialog, str);
                }
            });
            final com.yl.ui.v vVarD = aVar.d();
            vVarD.findViewById(com.yl.ui.v.d).setOnClickListener(new View.OnClickListener() { // from class: com.a.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    vVarD.cancel();
                }
            });
            vVarD.show();
        } catch (Exception e) {
            v2("无法转让脚本", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s1(Task task, View view) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
        } else {
            U();
            r2(task);
        }
    }

    private final void r2(final Task task) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        l9 l9Var = this.c0;
        if (l9Var != null && !l9Var.f(task)) {
            S();
            return;
        }
        d dVarY0 = y0(task, AccountTool.d().g());
        if (dVarY0 == d.MISSING_ORIGINAL_SHARE_ID) {
            v2("当前脚本缺少原分享码信息，不能直接生成云分享码。请重新通过分享码导入后再分享，或使用文件导出。", null);
            return;
        }
        if (dVarY0 != d.SHARE_ORIGINAL) {
            this.Q = null;
            U();
            com.frame.l1.g(new Runnable() { // from class: com.a.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.Y1(task);
                }
            });
        } else {
            String strS0 = s0(com.frame.v0.g().getString(j.b.g.c), task.getCloudScriptId(), task.getName(), task.getCreateUserId(), null);
            com.frame.m0.a(strS0);
            Y("分享码已复制到剪切板");
            com.frame.q1.n(this, "分享脚本", strS0);
        }
    }

    static String s0(String str, Long l2, String str2, Long l3, String str3) {
        return "复制该段文字#" + l2 + "#，应用市场下载【" + str + "】，打开APP-【我的】-【导入脚本】，粘贴该段文字，即可获取【" + A2(str3, l3) + "】分享的【" + str2 + "】自动化流程。";
    }

    private final void s2(final boolean z, final String str, final List<TaskSimple> list, final Runnable runnable) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        if (!z && u0(list)) {
            S();
            v2("分组中包含非本人创建的脚本，不能生成分享码，请使用文件导出。", null);
        } else {
            this.Q = null;
            U();
            com.frame.l1.g(new Runnable() { // from class: com.a.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.e2(str, z, list, runnable);
                }
            });
        }
    }

    private boolean t0(File file) {
        if (!A0(file)) {
            return true;
        }
        com.frame.l1.e(new Runnable() { // from class: com.a.z
            @Override // java.lang.Runnable
            public final void run() {
                this.c.J0();
            }
        });
        return false;
    }

    private final void t2(Task task) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        l9 l9Var = this.c0;
        if (l9Var == null || l9Var.f(task)) {
            this.P = task;
            this.U = null;
            this.V = null;
            this.Q = null;
            da.B().B1("selectfolder.mp4");
            this.d0.a(null);
        }
    }

    private boolean u0(List<TaskSimple> list) {
        Iterator<TaskSimple> it = list.iterator();
        while (it.hasNext()) {
            Task taskL = da.B().L(it.next().getId());
            if (taskL != null && !s8.a(taskL) && taskL.getCreateUserId() != null && !AccountTool.d().k(taskL.getCreateUserId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v1(String str, List list, View view) {
        if (AccountTool.d().j()) {
            U();
            s2(false, str, list, null);
        } else {
            if (AccountTool.d().j()) {
                return;
            }
            v2("为了确保你的权益，请先登录后再分享", null);
        }
    }

    private final void u2(String str, List<TaskSimple> list) {
        if (!AccountTool.d().j()) {
            v2("为了确保你的权益，请先登录后再分享", null);
            return;
        }
        this.U = str;
        this.V = list;
        this.P = null;
        this.Q = null;
        da.B().B1("selectfolder.mp4");
        this.d0.a(null);
    }

    private final File w0(String str, List<TaskSimple> list, boolean z, boolean z2, String str2, Long l2, Long l3, Long l4, boolean z3, boolean z4) throws Exception {
        return x0(str, list, z, z2, str2, l2, l3, l4, z3, z4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x1(h.h.a.a aVar, DialogInterface dialogInterface, int i2) {
        com.frame.k0.u(this, aVar.i());
    }

    private File x0(String str, List<TaskSimple> list, boolean z, boolean z2, String str2, Long l2, Long l3, Long l4, boolean z3, boolean z4, Long l5) throws Exception {
        v7 v7Var = new v7();
        v7Var.z(z3);
        ArrayList arrayList = new ArrayList();
        File file = new File(da.z() + "/aiTouch/export_group_" + System.nanoTime());
        file.mkdirs();
        try {
            for (TaskSimple taskSimple : list) {
                Task task = (Task) com.frame.k0.l("task:" + taskSimple.getId(), Task.class);
                if (l5 != null) {
                    v7.f(task);
                }
                if (task == null) {
                    com.frame.r0.d(file);
                    return null;
                }
                try {
                    l9 l9Var = this.c0;
                    if (l9Var != null) {
                        if (z4) {
                            if (!l9Var.e(task)) {
                                com.frame.r0.d(file);
                                return null;
                            }
                        } else if (!l9Var.f(task)) {
                            com.frame.r0.d(file);
                            return null;
                        }
                    }
                    task.setGroup(taskSimple.getGroup());
                    String absolutePath = new File(file, "任务-" + task.getId() + ".ajs").getAbsolutePath();
                    arrayList.add(l5 != null ? v7Var.n(task, absolutePath, l5.longValue(), z, z2, str2, l2, l3) : v7Var.s(task, absolutePath, z, z2, str2, l2, l3, l4));
                } catch (Throwable th) {
                    th = th;
                    com.frame.r0.d(file);
                    throw th;
                }
            }
            File file2 = new File(da.z() + "/aiTouch/点击宝分组-" + str + ".zip");
            if (file2.exists()) {
                file2.delete();
            }
            v7.k(arrayList, file2.getAbsolutePath(), null);
            com.frame.r0.d(file);
            return file2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static d y0(Task task, Long l2) {
        Long createUserId = task.getCreateUserId();
        return (s8.a(task) || createUserId == null || createUserId.equals(l2)) ? d.UPLOAD : task.getCloudScriptId() == null ? d.MISSING_ORIGINAL_SHARE_ID : d.SHARE_ORIGINAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y2(TextView textView, int i2, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText(), 0, i2);
        SpannableStringBuilder spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) "创建者 ：");
        if (TextUtils.isEmpty(str) || str.trim().isEmpty()) {
            str = "未设置名称";
        }
        spannableStringBuilderAppend.append((CharSequence) str).append((CharSequence) "\n");
        textView.setText(spannableStringBuilder);
    }

    private final void z0(Task task) {
        View viewFindViewById = findViewById(j.b.e.E);
        viewFindViewById.setTag(task.getPwd());
        viewFindViewById.setSelected(task.getPwd() != null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.a.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportAct.L0(view);
            }
        });
        View viewFindViewById2 = findViewById(j.b.e.x);
        viewFindViewById2.setTag(task.getLimitTime());
        viewFindViewById2.setSelected(task.getLimitTime() != null);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.a.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.O0(view);
            }
        });
        Long l2 = -1L;
        boolean zEquals = l2.equals(task.getLimitUserId());
        View viewFindViewById3 = findViewById(j.b.e.y);
        viewFindViewById3.setTag(zEquals ? null : task.getLimitUserId());
        viewFindViewById3.setSelected((zEquals || task.getLimitUserId() == null) ? false : true);
        viewFindViewById3.setVisibility(zEquals ? 8 : 0);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.a.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.S0(view);
            }
        });
        View viewFindViewById4 = findViewById(j.b.e.w);
        viewFindViewById4.setSelected(zEquals);
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.a.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.U0(view);
            }
        });
        View viewFindViewById5 = findViewById(j.b.e.f1753l);
        viewFindViewById5.setSelected(task.isCanNotShare());
        View viewFindViewById6 = findViewById(j.b.e.d);
        viewFindViewById6.setSelected(task.isActCode());
        boolean z = s8.a(task) || task.getCreateUserId() == null || AccountTool.d().k(task.getCreateUserId());
        View[] viewArr = {viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, viewFindViewById5, viewFindViewById6};
        for (int i2 = 0; i2 < 6; i2++) {
            View view = viewArr[i2];
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.55f);
        }
        findViewById(j.b.e.O5).setVisibility(z ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A1(final h.h.a.a aVar) throws UnsupportedEncodingException {
        try {
            s.a aVar2 = new s.a(this);
            aVar2.g(j.b.d.y);
            aVar2.t("温馨提示");
            final String strDecode = URLDecoder.decode(String.valueOf(aVar.i()), StandardCharsets.UTF_8.name());
            aVar2.j("文件导出成功路径：" + strDecode + " 路径已复制至剪切板");
            aVar2.r("发送", new DialogInterface.OnClickListener() { // from class: com.a.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.x1(aVar, dialogInterface, i2);
                }
            });
            aVar2.m("复制地址", new DialogInterface.OnClickListener() { // from class: com.a.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.frame.m0.a(strDecode);
                }
            });
            aVar2.e().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return j.b.f.b;
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        ((TitleBar) findViewById(j.b.e.s5)).setTitle("分享脚本");
        View viewFindViewById = findViewById(j.b.e.r);
        boolean z = true;
        viewFindViewById.setSelected(true);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.a.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.setSelected(!view.isSelected());
            }
        });
        final Long lValueOf = Long.valueOf(getIntent().getLongExtra("id", 0L));
        if (lValueOf.longValue() != 0) {
            final Task taskL = da.B().L(lValueOf.longValue());
            if (taskL == null) {
                FloatToast.i("未找到脚本");
                finish();
                return;
            }
            if (!s8.a(taskL) && taskL.isCanNotShare() && (!AccountTool.d().j() || !AccountTool.d().k(taskL.getCreateUserId()))) {
                FloatToast.i("此脚本仅作者可分享~");
                finish();
                return;
            }
            if (taskL.getCreateUserId() == null) {
                taskL.setCreateUserId(AccountTool.d().g());
            }
            TextView textView = (TextView) findViewById(j.b.e.n6);
            textView.append("脚本编号 ：");
            textView.append(taskL.getId() + "");
            textView.append("\n");
            textView.append("脚本名称 ：");
            textView.append(taskL.getName());
            textView.append("\n");
            textView.append("最佳分辨率：");
            textView.append(taskL.getScreenWith() + ProcessIdUtil.DEFAULT_PROCESSID + taskL.getScreenHeight());
            textView.append("\n");
            textView.append("节点个数 ：");
            textView.append(taskL.getNodeMap().size() + "个");
            textView.append("\n");
            textView.append("创建者 ID：");
            Long createUserId = taskL.getCreateUserId();
            int length = textView.length();
            textView.append(createUserId == null ? "未知" : createUserId.toString());
            textView.append("\n");
            int length2 = textView.length();
            if (createUserId != null) {
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new a(createUserId, textView, length2), length, length2 - 1, 33);
                textView.setText(spannableString);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (AccountTool.d().j() && AccountTool.d().k(createUserId)) {
                y2(textView, length2, AccountTool.d().c().getName());
            } else if (createUserId != null) {
                k2(createUserId, textView, length2);
            }
            z0(taskL);
            findViewById(j.b.e.c1).setOnClickListener(new View.OnClickListener() { // from class: com.a.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.X0(taskL, view);
                }
            });
            findViewById(j.b.e.f1751j).setOnClickListener(new View.OnClickListener() { // from class: com.a.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.l1(taskL, view);
                }
            });
            findViewById(j.b.e.f1753l).setOnClickListener(new View.OnClickListener() { // from class: com.a.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.n1(view);
                }
            });
            findViewById(j.b.e.d).setOnClickListener(new View.OnClickListener() { // from class: com.a.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    view.setSelected(!view.isSelected());
                }
            });
            findViewById(j.b.e.g1).setOnClickListener(new View.OnClickListener() { // from class: com.a.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.q1(taskL, view);
                }
            });
            findViewById(j.b.e.e1).setOnClickListener(new View.OnClickListener() { // from class: com.a.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.s1(taskL, view);
                }
            });
        } else {
            final String stringExtra = getIntent().getStringExtra("group");
            if (!TextUtils.isEmpty(stringExtra)) {
                findViewById(j.b.e.f1753l).setOnClickListener(new View.OnClickListener() { // from class: com.a.p0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        view.setSelected(!view.isSelected());
                    }
                });
                final List<TaskSimple> listD = da.B().D(stringExtra, 0);
                TextView textView2 = (TextView) findViewById(j.b.e.n6);
                for (TaskSimple taskSimple : listD) {
                    textView2.append(taskSimple.getName());
                    textView2.append("\n");
                    if (z) {
                        Task taskL2 = da.B().L(taskSimple.getId());
                        if (!s8.a(taskL2) && taskL2.isCanNotShare() && (!AccountTool.d().j() || !AccountTool.d().k(taskL2.getCreateUserId()))) {
                            FloatToast.i("此脚本仅作者可分享~");
                            finish();
                            return;
                        }
                        z0(taskL2);
                    }
                    z = false;
                }
                findViewById(j.b.e.e1).setOnClickListener(new View.OnClickListener() { // from class: com.a.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.v1(stringExtra, listD, view);
                    }
                });
                findViewById(j.b.e.c1).setOnClickListener(new View.OnClickListener() { // from class: com.a.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.Z0(stringExtra, listD, view);
                    }
                });
                findViewById(j.b.e.g1).setOnClickListener(new View.OnClickListener() { // from class: com.a.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.b1(stringExtra, listD, view);
                    }
                });
                findViewById(j.b.e.f1751j).setOnClickListener(new View.OnClickListener() { // from class: com.a.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.f1(stringExtra, listD, view);
                    }
                });
            }
        }
        View viewFindViewById2 = findViewById(j.b.e.T);
        viewFindViewById2.setVisibility((AccountTool.d().j() && AccountTool.d().l()) ? 0 : 8);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.a.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h1(lValueOf, view);
            }
        });
        l9 l9Var = new l9();
        this.c0 = l9Var;
        l9Var.p();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        if ("wx".equals(this.Q)) {
            com.yl.ui.q qVar = new com.yl.ui.q();
            qVar.n2(j.b.d.f1748o);
            qVar.j2(x(), "file:///android_asset/share_wx.jpg");
        }
        this.Q = null;
    }

    public String v0(Long l2, String str) {
        return s0(com.frame.v0.g().getString(j.b.g.c), l2, str, AccountTool.d().g(), AccountTool.d().c().getName());
    }

    public void v2(final String str, final Exception exc) {
        com.frame.l1.e(new Runnable() { // from class: com.a.h
            @Override // java.lang.Runnable
            public final void run() {
                ExportAct.f2(str, exc);
            }
        });
    }

    public void w2(Long l2, String str) {
        com.frame.q1.n(this, "自动化流程", v0(l2, str));
    }

    public void x2(String str) {
        s.a aVar = new s.a(this);
        if (str == null) {
            str = "脚本备份是会员权益功能功能，解锁更多任务及会员权益，请开通VIP可继续使用？";
        }
        aVar.j(str);
        aVar.m("查看权益", new DialogInterface.OnClickListener() { // from class: com.a.r0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ExportAct.g2(dialogInterface, i2);
            }
        });
        aVar.g(j.b.d.M0);
        aVar.r("去开通", new DialogInterface.OnClickListener() { // from class: com.a.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ExportAct.h2(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
    }

    public void z2(final Collection<TaskSimple> collection) {
        U();
        com.frame.l1.g(new Runnable() { // from class: com.a.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j2(collection);
            }
        });
    }
}
