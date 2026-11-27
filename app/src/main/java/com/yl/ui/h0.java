package com.yl.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.frame.k0;
import com.frame.l1;
import com.frame.n0;
import com.frame.q1;
import com.frame.v0;
import com.yl.ui.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class h0 extends com.act.f {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0() {
        if (v0.g().l()) {
            if (Debug.isDebuggerConnected()) {
                finish();
                System.exit(0);
                Process.killProcess(Process.myPid());
            }
            if (getApplicationInfo().flags == 2) {
                finish();
                System.exit(0);
                Process.killProcess(Process.myPid());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i2) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(DialogInterface dialogInterface, int i2) {
        g0();
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), getPackageName() + ".basicmode.BasicModeActivity");
        startActivity(intent);
        finish();
    }

    public static void h0(TextView textView, String str, View.OnClickListener onClickListener, String... strArr) throws Resources.NotFoundException {
        textView.setClickable(true);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(str);
        int color = v0.g().getResources().getColor(y.b);
        for (String str2 : strArr) {
            Matcher matcher = Pattern.compile(str2).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new g0(color, str2, onClickListener), matcher.start(), matcher.end(), 33);
            }
        }
        textView.setText(spannableString);
    }

    public void f0() {
        v0.g().r(1);
        i.a.j jVar = this.M;
        if (jVar != null) {
            jVar.j();
        } else {
            l();
        }
        k0.f();
    }

    public void g0() {
    }

    public void i0() {
        try {
            s.a aVar = new s.a(this);
            aVar.t("温馨提示");
            aVar.j("您需要阅读并同意《隐私政策》才能继续使用我们的应用。");
            aVar.n();
            aVar.r("下一步", new DialogInterface.OnClickListener() { // from class: com.yl.ui.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.c0(dialogInterface, i2);
                }
            });
            aVar.m("使用基础功能", new DialogInterface.OnClickListener() { // from class: com.yl.ui.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.e0(dialogInterface, i2);
                }
            });
            s sVarE = aVar.e();
            sVarE.setCancelable(false);
            sVarE.show();
        } catch (Exception e) {
            k0.r(e);
            finish();
        }
    }

    public abstract void m();

    @Override // com.act.f, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        v0.g().o(this);
        super.onCreate(bundle);
        l1.g(new Runnable() { // from class: com.yl.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a0();
            }
        });
        float fH = q1.h(this);
        if (fH != 0.0f) {
            n0.h("status_bar_height", fH);
        }
        Log.e("height-----------", fH + "");
    }

    @Override // com.act.f, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        v0.g().q(true);
        super.onResume();
    }

    @Override // com.act.f, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        v0.g().q(false);
        super.onStop();
    }
}
