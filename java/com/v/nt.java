package com.v;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.FileChooseView;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class nt {
    private static void a(final i.b.k7 k7Var, final ItemChooseDialogView itemChooseDialogView) {
        ((FileChooseView) com.frame.s0.g().B(FileChooseView.class)).setUriCallback(new FileChooseView.c() { // from class: com.v.uj
            @Override // com.v.FileChooseView.c
            public final void a(Uri uri) {
                nt.c(k7Var, itemChooseDialogView, uri);
            }
        });
    }

    private static boolean b(String str) {
        return str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".png");
    }

    static /* synthetic */ void c(i.b.k7 k7Var, ItemChooseDialogView itemChooseDialogView, Uri uri) {
        k7Var.a(uri.toString());
        itemChooseDialogView.setDefaultData(-1, k7Var.d());
    }

    static /* synthetic */ void d(i.b.k7 k7Var, int i2, List list) throws UnsupportedEncodingException {
        ArrayList<String> arrayListD = k7Var.d();
        ArrayList arrayList = new ArrayList(k7Var.c());
        if (i2 < 0 || i2 >= arrayListD.size() || i2 >= arrayList.size()) {
            return;
        }
        String str = arrayListD.get(i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String str2 = (String) arrayList.get(i2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (lowerCase.endsWith(".xlsx")) {
            FloatToast.i("仅支持.xls的表格文件");
            return;
        }
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (lowerCase.endsWith(".txt")) {
            TxtEditView txtEditView = (TxtEditView) com.frame.s0.g().B(TxtEditView.class);
            if (str2.contains("content://")) {
                txtEditView.setUri(Uri.parse(str2));
                return;
            } else {
                txtEditView.setFile(new File(str2));
                return;
            }
        }
        if (b(lowerCase)) {
            ((ImagePreviewView) com.frame.s0.g().x(ImagePreviewView.class)).setPath(str2);
        } else if (lowerCase.endsWith(".xls")) {
            ((ExcelPreviewView) com.frame.s0.g().x(ExcelPreviewView.class)).setPath(str2);
        }
    }

    static /* synthetic */ void e(ItemChooseDialogView itemChooseDialogView, i.b.k7 k7Var) {
        itemChooseDialogView.setTitle("最近访问过的文件");
        itemChooseDialogView.setDefaultData(-1, k7Var.d());
        itemChooseDialogView.setOnTextChoose(o(k7Var, itemChooseDialogView));
    }

    static /* synthetic */ void f(i.b.k7 k7Var, ItemChooseDialogView itemChooseDialogView, Runnable runnable, int i2, List list) {
        if (i2 == 0) {
            q(k7Var, itemChooseDialogView, runnable);
        } else {
            runnable.run();
            a(k7Var, itemChooseDialogView);
        }
    }

    static /* synthetic */ void g(final ItemChooseDialogView itemChooseDialogView, final i.b.k7 k7Var, final Runnable runnable, View view) {
        itemChooseDialogView.setTitle("新增");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("创建空文本文件", "从存储器选择")));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.bk
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                nt.f(k7Var, itemChooseDialogView, runnable, i2, list);
            }
        });
    }

    static /* synthetic */ void h(i.b.k7 k7Var, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        k7Var.b();
        com.yl.ui.i0.l(null);
        com.frame.s0.g().d(ItemChooseDialogView.class);
    }

    static /* synthetic */ void i(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(ItemChooseDialogView.class);
    }

    static /* synthetic */ void j(final i.b.k7 k7Var, View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否清空最近访问文件列表");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.rj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                nt.h(k7Var, view2);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.zj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                nt.i(view2);
            }
        });
        dingMsgView.l("温馨提示");
    }

    static /* synthetic */ void k(i.b.k7 k7Var, String str, ItemChooseDialogView itemChooseDialogView, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        k7Var.e(str);
        itemChooseDialogView.setDefaultData(-1, k7Var.d());
    }

    static /* synthetic */ boolean m(final i.b.k7 k7Var, final ItemChooseDialogView itemChooseDialogView, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        final String str = (String) new ArrayList(k7Var.c()).get(i2);
        String str2 = k7Var.d().get(i2);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("温馨提示");
        dingMsgView.h("是否删除 " + str2);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.xj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                nt.k(k7Var, str, itemChooseDialogView, view2);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.vj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        return true;
    }

    static /* synthetic */ boolean n(InputDialogView inputDialogView, i.b.k7 k7Var, Runnable runnable, String str) {
        String strTrim = str == null ? "" : str.trim();
        if (TextUtils.isEmpty(strTrim)) {
            inputDialogView.z("请输入文件名称");
            return false;
        }
        if (!strTrim.contains(".")) {
            strTrim = strTrim + ".txt";
        }
        File file = new File(i.b.da.z(), "file");
        if (!file.exists() && !file.mkdirs()) {
            inputDialogView.z("创建目录失败");
            return false;
        }
        File file2 = new File(file, strTrim);
        if (file2.exists()) {
            inputDialogView.z("文件已存在");
            return false;
        }
        com.frame.r0.z(file2.getAbsolutePath(), "", false);
        k7Var.a(file2.getAbsolutePath());
        runnable.run();
        return true;
    }

    private static ItemChooseDialogView.b o(final i.b.k7 k7Var, ItemChooseDialogView itemChooseDialogView) {
        return new ItemChooseDialogView.b() { // from class: com.v.yj
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) throws UnsupportedEncodingException {
                nt.d(k7Var, i2, list);
            }
        };
    }

    public static void p() {
        final i.b.k7 k7Var = new i.b.k7();
        ArrayList<String> arrayListD = k7Var.d();
        final ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("最近访问过的文件");
        itemChooseDialogView.setDefaultData(-1, arrayListD);
        final Runnable runnable = new Runnable() { // from class: com.v.wj
            @Override // java.lang.Runnable
            public final void run() {
                nt.e(itemChooseDialogView, k7Var);
            }
        };
        TextView textView = (TextView) itemChooseDialogView.findViewById(j.b.e.i0);
        textView.setVisibility(0);
        textView.setTextColor(-7829368);
        textView.setBackground(null);
        textView.setText("新增");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.sj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nt.g(itemChooseDialogView, k7Var, runnable, view);
            }
        });
        TextView textView2 = new TextView(com.frame.v0.g());
        textView2.setTextColor(Color.parseColor("#99999999"));
        textView2.setTextSize(10.0f);
        int iC = com.frame.p1.c(15.0f);
        textView2.setPadding(iC, 0, iC, 0);
        textView2.setText("在您使用了变量写入文件等功能时，会将其记录在列表中方便查看。");
        itemChooseDialogView.c(textView2);
        TextView textView3 = (TextView) itemChooseDialogView.findViewById(j.b.e.g);
        textView3.setVisibility(0);
        textView3.setText("清空");
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.v.qj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nt.j(k7Var, view);
            }
        });
        itemChooseDialogView.setOnTextChoose(o(k7Var, itemChooseDialogView));
        itemChooseDialogView.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.v.tj
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return nt.m(k7Var, itemChooseDialogView, baseQuickAdapter, view, i2);
            }
        });
    }

    private static void q(final i.b.k7 k7Var, ItemChooseDialogView itemChooseDialogView, final Runnable runnable) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("文件名称");
        inputDialogView.s("请输入文件名称");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.ak
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return nt.n(inputDialogView, k7Var, runnable, str);
            }
        });
    }
}
