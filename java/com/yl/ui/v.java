package com.yl.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.k0;
import com.frame.v0;

/* loaded from: classes.dex */
public class v extends Dialog {
    public static final int c = a0.A;
    public static final int d = a0.F;

    public static class a {
        private TextWatcher a;
        private View b;
        private Context c;
        private String d;
        private String e;
        private DialogInterface.OnCancelListener f;
        private b g;

        /* renamed from: h, reason: collision with root package name */
        private int f1154h;

        /* renamed from: i, reason: collision with root package name */
        private View f1155i;

        /* renamed from: j, reason: collision with root package name */
        private String f1156j;

        /* renamed from: k, reason: collision with root package name */
        private String f1157k;

        /* renamed from: l, reason: collision with root package name */
        private int f1158l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f1159m = true;

        /* renamed from: n, reason: collision with root package name */
        private int f1160n = 3;

        /* renamed from: o, reason: collision with root package name */
        private int f1161o = 0;
        private int p = 0;
        private String q;
        private ViewGroup.LayoutParams r;

        public a(Context context) {
            this.c = context;
        }

        public v d() {
            try {
                v vVar = new v(this.c, d0.a);
                View viewInflate = View.inflate(this.c.getApplicationContext(), b0.c, null);
                this.b = viewInflate;
                EditText editText = (EditText) viewInflate.findViewById(a0.g);
                editText.setMinLines(this.f1160n);
                TextView textView = (TextView) this.b.findViewById(a0.I);
                TextView textView2 = (TextView) this.b.findViewById(a0.J);
                TextWatcher textWatcher = this.a;
                if (textWatcher != null) {
                    editText.addTextChangedListener(textWatcher);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    textView2.setVisibility(0);
                    textView2.setText(this.q);
                }
                if (this.f1161o != 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f1161o)});
                }
                int i2 = this.p;
                if (i2 != 0) {
                    editText.setMaxLines(i2);
                }
                int i3 = this.f1154h;
                if (i3 != 0) {
                    this.b.setBackgroundColor(i3);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    editText.setText(this.e);
                }
                if (!TextUtils.isEmpty(this.f1157k)) {
                    editText.setHint(this.f1157k);
                }
                int i4 = this.f1158l;
                if (i4 != 0) {
                    editText.setInputType(i4);
                }
                editText.addTextChangedListener(new t(this));
                if (this.f1155i != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(a0.L);
                    ViewGroup.LayoutParams layoutParams = this.r;
                    if (layoutParams != null) {
                        relativeLayout.addView(this.f1155i, layoutParams);
                    } else {
                        relativeLayout.addView(this.f1155i, -1, -2);
                    }
                }
                if (!TextUtils.isEmpty(this.d)) {
                    textView.setText(Html.fromHtml(this.d));
                }
                vVar.addContentView(this.b, new ViewGroup.LayoutParams((int) (v0.g().getResources().getDisplayMetrics().widthPixels * 0.72f), -2));
                DialogInterface.OnCancelListener onCancelListener = this.f;
                if (onCancelListener != null) {
                    vVar.setOnCancelListener(onCancelListener);
                }
                u uVar = new u(this, vVar, editText);
                ((TextView) this.b.findViewById(v.c)).setOnClickListener(uVar);
                ((TextView) this.b.findViewById(v.d)).setOnClickListener(uVar);
                return vVar;
            } catch (Exception e) {
                k0.r(e);
                return null;
            }
        }

        public a e(boolean z) {
            this.f1159m = z;
            return this;
        }

        public a f(String str) {
            this.f1157k = str;
            return this;
        }

        public a g(b bVar) {
            this.g = bVar;
            return this;
        }

        public a h(int i2) {
            this.f1158l = i2;
            return this;
        }

        public a i(int i2) {
            this.f1161o = i2;
            return this;
        }

        public a j(int i2) {
            this.p = i2;
            return this;
        }

        public a k(String str) {
            this.e = str;
            return this;
        }

        public a l(int i2) {
            this.f1160n = i2;
            return this;
        }

        public a m(DialogInterface.OnCancelListener onCancelListener) {
            this.f = onCancelListener;
            return this;
        }

        public a n(String str) {
            this.d = str;
            return this;
        }

        public a o(String str) {
            this.q = str;
            return this;
        }

        public a p(View view) {
            q(view, null);
            return this;
        }

        public a q(View view, ViewGroup.LayoutParams layoutParams) {
            this.f1155i = view;
            this.r = layoutParams;
            return this;
        }
    }

    public interface b {
        boolean a(Dialog dialog, String str);
    }

    public v(Context context, int i2) {
        super(context, i2);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setGravity(17);
            window.setAttributes(attributes);
        } catch (Exception e) {
            k0.r(e);
        }
    }
}
