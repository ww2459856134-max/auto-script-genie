package com.jsj.autojs.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.act.WebAct;
import com.jsj.autojs.App90534;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import i.b.a9;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class r8 extends com.yl.ui.h0 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(View view) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(View view, View view2) {
        com.frame.v0.g().r(1);
        view.setVisibility(8);
        f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(View view) {
        if ("《隐私政策》".equals(view.getTag())) {
            try {
                Intent intent = new Intent(this, (Class<?>) WebAct.class);
                intent.putExtra(SocialConstants.PARAM_URL, j0());
                intent.putExtra("key", "privacy");
                intent.putExtra("title", "隐私政策");
                startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                com.frame.k0.r(e);
                return;
            }
        }
        if ("《用户协议》".equals(view.getTag())) {
            try {
                Intent intent2 = new Intent(this, (Class<?>) WebAct.class);
                intent2.putExtra(SocialConstants.PARAM_URL, k0());
                intent2.putExtra("key", "agreement");
                intent2.putExtra("title", "用户协议");
                startActivity(intent2);
            } catch (Exception e2) {
                e2.printStackTrace();
                com.frame.k0.r(e2);
            }
        }
    }

    private void r0(ViewGroup viewGroup) {
        try {
            viewGroup.setVisibility(0);
            ViewPager viewPager = new ViewPager(com.frame.v0.g());
            ArrayList arrayList = new ArrayList();
            arrayList.add(2131230943);
            arrayList.add(2131230944);
            arrayList.add(2131230945);
            com.jsj.autojs.adapter.f fVar = new com.jsj.autojs.adapter.f(getApplicationContext(), false, arrayList);
            viewPager.setAdapter(fVar);
            viewPager.setOffscreenPageLimit(4);
            viewGroup.addView(viewPager, -1, -1);
            fVar.j();
            this.M.v();
        } catch (Exception e) {
            e.printStackTrace();
            this.M.o();
        }
    }

    @Override // com.yl.ui.h0
    public void f0() {
        super.f0();
        ((App90534) getApplication()).C();
        a9.c(this);
    }

    protected String j0() throws JSONException {
        String string;
        JSONObject jSONObjectF = com.frame.a1.b().f("privacy");
        if (jSONObjectF != null) {
            try {
                string = jSONObjectF.getString(SocialConstants.PARAM_URL);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            string = null;
        }
        return TextUtils.isEmpty(string) ? com.jsj.autojs.l.c0.e().f() : string;
    }

    protected String k0() {
        return "https://h5.skyingidea.com/useragree/autojs.html";
    }

    @Override // com.act.f, i.a.i
    public void l() {
    }

    @Override // com.yl.ui.h0, i.a.i
    public void m() throws Resources.NotFoundException {
        final View viewInflate = View.inflate(com.frame.v0.g(), 2131493135, null);
        addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        viewInflate.findViewById(2131296449).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.i8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m0(view);
            }
        });
        viewInflate.findViewById(2131296425).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.h8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o0(viewInflate, view);
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(2131297317);
        String string = com.frame.v0.g().getResources().getString(R.string.app_name);
        com.yl.ui.h0.h0(textView, "欢迎您使用" + string + "。我们依据相关法律制定了《隐私政策》和《用户协议》，请您在同意之前仔细阅读并充分理解相关条例。\n\n本APP仅是自动化工具，严禁使用" + string + "进行刷量、评论、外挂等损害公平及他人利益的活动。", new View.OnClickListener() { // from class: com.jsj.autojs.activity.g8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q0(view);
            }
        }, "《隐私政策》", "《用户协议》");
    }

    @Override // com.act.f, androidx.appcompat.app.s, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        i.a.j.H = 10;
        super.onPostCreate(bundle);
        if (com.frame.v0.g().l()) {
            return;
        }
        com.frame.y0.g("SplashKk.onPostCreate");
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.splash_container);
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            viewGroup.setLayoutParams(layoutParams);
            r0(viewGroup);
        }
    }
}
