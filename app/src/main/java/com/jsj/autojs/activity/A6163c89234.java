package com.jsj.autojs.activity;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.cursor.R;
import java.io.File;

/* loaded from: classes.dex */
public class A6163c89234 extends com.yl.ui.p {
    static /* synthetic */ void m0(TextView textView, String str, final ScrollView scrollView) {
        try {
            textView.setText(Html.fromHtml(str));
            textView.post(new Runnable() { // from class: com.jsj.autojs.activity.f1
                @Override // java.lang.Runnable
                public final void run() {
                    scrollView.fullScroll(130);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void n0(File file, final TextView textView, final ScrollView scrollView) {
        try {
            final String strW = com.frame.r0.w(file.getAbsolutePath());
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.h1
                @Override // java.lang.Runnable
                public final void run() {
                    A6163c89234.m0(textView, strW, scrollView);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492904;
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        String stringExtra = getIntent().getStringExtra("file");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        final File file = new File(stringExtra);
        if (!file.exists()) {
            finish();
            return;
        }
        j0(file.getName().split(".txt")[0]);
        Z();
        f0(2131231064, new View.OnClickListener() { // from class: com.jsj.autojs.activity.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.c1.a(file);
            }
        });
        final TextView textView = (TextView) findViewById(2131297143);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        textView.setText("加载中...");
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.i1
            @Override // java.lang.Runnable
            public final void run() {
                A6163c89234.n0(file, textView, scrollView);
            }
        });
    }
}
