package com.v.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.v.FileChooseView;
import com.v.FloatToast;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.InputDialogView;
import i.b.da;
import i.b.k7;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class FileItem extends BaseItemView implements View.OnClickListener {
    protected TextView c;
    private TextView d;
    private boolean e;
    String f;

    public FileItem(Context context) {
        super(context);
        d();
    }

    private void c() {
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().B(FileChooseView.class);
        fileChooseView.setChooseFile(this.c.getText().toString());
        fileChooseView.setUriCallback(new FileChooseView.c() { // from class: com.v.item.p
            @Override // com.v.FileChooseView.c
            public final void a(Uri uri) throws Throwable {
                this.a.g(uri);
            }
        });
    }

    private void e() {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setChooseParamNameType();
        paramNameTextView.setInputLabel("用变量访问文件路径");
        paramNameTextView.setInputHint("请输入变量名，如：xxx");
        String str = this.f;
        if (str != null && str.contains("${") && this.f.contains("}")) {
            paramNameTextView.setInputDefaultValue(this.f.replace("${", "").replace("}", ""));
        }
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.item.s
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str2) {
                return this.a.i(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Uri uri) throws Throwable {
        if (!this.e) {
            setValue(uri.toString());
            new k7().a(uri.toString());
            return;
        }
        File file = new File(da.z(), "/img/" + n(com.frame.v0.g(), uri));
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        com.frame.r0.A(uri, file);
        setValue(file.getAbsolutePath());
        new k7().a(file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean i(String str) {
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            FloatToast.i("请输入变量");
            return false;
        }
        if (!strTrim.contains("${")) {
            strTrim = "${" + strTrim + "}";
        }
        setValue(strTrim);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i2, List list) throws UnsupportedEncodingException {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            o();
        } else if (i2 == 1) {
            c();
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(k7 k7Var, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        setValue((String) new ArrayList(k7Var.c()).get(i2));
    }

    private static String n(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return uri.getLastPathSegment();
    }

    private void o() throws UnsupportedEncodingException {
        final k7 k7Var = new k7();
        ArrayList<String> arrayListD = k7Var.d();
        if (arrayListD.isEmpty()) {
            FloatToast.i("暂无最近访问的文件");
            return;
        }
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("最近访问过的文件");
        itemChooseDialogView.setDefaultData(-1, arrayListD);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.q
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.m(k7Var, i2, list);
            }
        });
    }

    public void d() {
        View.inflate(getContext(), j.b.f.Y0, this);
        this.d = (TextView) findViewById(j.b.e.K5);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择文件");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("选择最近文件", "选择本地文件", "用变量访问文件路径")));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.item.r
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) throws UnsupportedEncodingException {
                this.a.k(i2, list);
            }
        });
    }

    public void setCopyToLocal(boolean z) {
        this.e = z;
    }

    public void setHint(String str) {
        this.c.setHint(str);
    }

    public void setLabel(String str) {
        this.d.setText(str);
    }

    public void setValue(String str) {
        this.f = str;
        if (str == null) {
            this.c.setText((CharSequence) null);
            return;
        }
        try {
            this.c.setText(URLDecoder.decode(str, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.v.item.BaseItemView
    public String getValue() {
        return this.f;
    }

    public FileItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.h.a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(j.b.h.b);
        String string2 = typedArrayObtainStyledAttributes.getString(j.b.h.c);
        setLabel(string);
        setHint(string2);
        this.c.setOnClickListener(this);
    }

    public FileItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
