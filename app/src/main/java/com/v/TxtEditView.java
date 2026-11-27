package com.v;

import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yl.float_ui.DingMsgView;
import java.io.File;

/* loaded from: classes.dex */
public class TxtEditView extends RelativeLayout {
    public TxtEditView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.d0, this);
    }

    static /* synthetic */ void a(File file, EditText editText, View view) {
        com.frame.r0.z(file.getAbsolutePath(), editText.getText().toString(), false);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void c(File file, EditText editText, View view) {
        com.frame.r0.z(file.getAbsolutePath(), "", false);
        editText.setText((CharSequence) null);
        com.frame.s0.g().d(DingMsgView.class);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void e(final File file, final EditText editText, View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确定清空此文件内容？");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.lr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TxtEditView.c(file, editText, view2);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.hr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    static /* synthetic */ void f(Uri uri, EditText editText, View view) throws Throwable {
        com.frame.r0.y(uri.toString(), editText.getText().toString(), false);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void h(Uri uri, EditText editText, View view) throws Throwable {
        com.frame.r0.y(uri.toString(), "", false);
        editText.setText((CharSequence) null);
        com.frame.s0.g().d(DingMsgView.class);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void j(final Uri uri, final EditText editText, View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确定清空此文件内容？");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.nr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Throwable {
                TxtEditView.h(uri, editText, view2);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.ir
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void setFile(final File file) {
        ((TextView) findViewById(j.b.e.r5)).setText(file.getName());
        final EditText editText = (EditText) findViewById(j.b.e.y5);
        editText.setText(com.frame.r0.w(file.getAbsolutePath()));
        findViewById(j.b.e.S4).setOnClickListener(new View.OnClickListener() { // from class: com.v.or
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TxtEditView.a(file, editText, view);
            }
        });
        findViewById(j.b.e.r1).setOnClickListener(new View.OnClickListener() { // from class: com.v.pr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(TxtEditView.class);
            }
        });
        findViewById(j.b.e.f0).setOnClickListener(new View.OnClickListener() { // from class: com.v.jr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TxtEditView.e(file, editText, view);
            }
        });
    }

    public void setUri(final Uri uri) {
        ((TextView) findViewById(j.b.e.r5)).setText(com.frame.r0.t(com.frame.v0.g(), uri));
        final EditText editText = (EditText) findViewById(j.b.e.y5);
        editText.setText(com.frame.r0.x(uri.toString()));
        findViewById(j.b.e.S4).setOnClickListener(new View.OnClickListener() { // from class: com.v.mr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                TxtEditView.f(uri, editText, view);
            }
        });
        findViewById(j.b.e.r1).setOnClickListener(new View.OnClickListener() { // from class: com.v.qr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(TxtEditView.class);
            }
        });
        findViewById(j.b.e.f0).setOnClickListener(new View.OnClickListener() { // from class: com.v.kr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TxtEditView.j(uri, editText, view);
            }
        });
    }
}
