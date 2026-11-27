package com.yl.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.k0;
import com.frame.p1;
import com.frame.v0;

/* loaded from: classes.dex */
public class s extends Dialog {
    public static final int e = a0.A;
    public static final int f = a0.F;
    public static final int g = a0.f1131i;
    private DialogInterface.OnClickListener c;
    private Runnable d;

    public static class a {
        private Drawable a;
        boolean b = false;
        private Context c;
        private View d;
        private String e;
        private int f;
        private String g;

        /* renamed from: h, reason: collision with root package name */
        private int f1146h;

        /* renamed from: i, reason: collision with root package name */
        private String f1147i;

        /* renamed from: j, reason: collision with root package name */
        private String f1148j;

        /* renamed from: k, reason: collision with root package name */
        private DialogInterface.OnCancelListener f1149k;

        /* renamed from: l, reason: collision with root package name */
        private DialogInterface.OnClickListener f1150l;

        /* renamed from: m, reason: collision with root package name */
        private DialogInterface.OnClickListener f1151m;

        /* renamed from: n, reason: collision with root package name */
        private DialogInterface.OnClickListener f1152n;

        /* renamed from: o, reason: collision with root package name */
        private DialogInterface.OnClickListener f1153o;
        private DialogInterface.OnClickListener p;
        private int q;
        private int r;
        private View s;
        private RelativeLayout.LayoutParams t;
        private boolean u;

        public a(Context context) {
            this.c = context;
        }

        public s e() {
            try {
                s sVar = new s(this.c, d0.a);
                View viewInflate = View.inflate(this.c.getApplicationContext(), b0.e, null);
                this.d = viewInflate;
                if (this.b) {
                    viewInflate.findViewById(s.g).setVisibility(4);
                }
                ImageView imageView = (ImageView) this.d.findViewById(a0.f1134l);
                TextView textView = (TextView) this.d.findViewById(a0.B);
                TextView textView2 = (TextView) this.d.findViewById(a0.I);
                if (TextUtils.isEmpty(this.e)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(this.e);
                }
                if (this.f1146h != 0) {
                    textView.setVisibility(0);
                    textView.setText(this.f1146h);
                } else if (TextUtils.isEmpty(this.g)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(Html.fromHtml(this.g));
                }
                int i2 = this.q;
                if (i2 != 0) {
                    this.d.setBackgroundColor(i2);
                }
                if (this.a != null) {
                    imageView.setVisibility(0);
                    imageView.setImageDrawable(this.a);
                } else if (this.r != 0) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(this.r);
                } else {
                    imageView.setVisibility(8);
                }
                if (this.s != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.d.findViewById(a0.L);
                    RelativeLayout.LayoutParams layoutParams = this.t;
                    if (layoutParams != null) {
                        relativeLayout.addView(this.s, layoutParams);
                    } else {
                        relativeLayout.addView(this.s, -1, -2);
                    }
                }
                sVar.addContentView(this.d, new ViewGroup.LayoutParams((int) (v0.g().getResources().getDisplayMetrics().widthPixels * 0.72f), -2));
                DialogInterface.OnCancelListener onCancelListener = this.f1149k;
                if (onCancelListener != null) {
                    sVar.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnClickListener onClickListener = this.f1150l;
                if (onClickListener != null) {
                    sVar.a(onClickListener);
                }
                r rVar = new r(this, sVar);
                textView.setOnClickListener(rVar);
                if (this.u) {
                    this.d.findViewById(s.g).setVisibility(4);
                } else {
                    this.d.findViewById(s.g).setOnClickListener(rVar);
                }
                TextView textView3 = (TextView) this.d.findViewById(s.e);
                textView3.setOnClickListener(rVar);
                if (TextUtils.isEmpty(this.f1147i)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(this.f1147i);
                    textView3.setVisibility(0);
                }
                TextView textView4 = (TextView) this.d.findViewById(s.f);
                if (this.f == 3) {
                    textView4.setVisibility(8);
                    textView4 = (TextView) this.d.findViewById(a0.E);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.leftMargin = p1.c(20.0f);
                    layoutParams2.rightMargin = p1.c(20.0f);
                    textView3.setLayoutParams(layoutParams2);
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView4.getLayoutParams();
                    layoutParams3.leftMargin = p1.c(20.0f);
                    layoutParams3.rightMargin = p1.c(20.0f);
                    layoutParams3.topMargin = p1.c(10.0f);
                    textView4.setLayoutParams(layoutParams3);
                }
                textView4.setOnClickListener(rVar);
                if (TextUtils.isEmpty(this.f1148j)) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setText(this.f1148j);
                    textView4.setVisibility(0);
                }
                return sVar;
            } catch (Exception e) {
                k0.r(e);
                return null;
            }
        }

        public a f() {
            this.b = true;
            return this;
        }

        public a g(int i2) {
            this.r = i2;
            return this;
        }

        public a h(Drawable drawable) {
            this.a = drawable;
            return this;
        }

        public a i(int i2) {
            this.f1146h = i2;
            this.g = null;
            this.f1153o = null;
            return this;
        }

        public a j(String str) {
            this.g = str;
            this.f1146h = 0;
            this.f1153o = null;
            return this;
        }

        public a k(String str, DialogInterface.OnClickListener onClickListener) {
            this.g = str;
            this.f1146h = 0;
            this.f1153o = onClickListener;
            return this;
        }

        public a l(int i2, DialogInterface.OnClickListener onClickListener) {
            this.f1148j = (String) v0.g().getText(i2);
            this.f1152n = onClickListener;
            return this;
        }

        public a m(String str, DialogInterface.OnClickListener onClickListener) {
            this.f1148j = str;
            this.f1152n = onClickListener;
            return this;
        }

        public a n() {
            this.u = true;
            return this;
        }

        public a o(DialogInterface.OnCancelListener onCancelListener) {
            this.f1149k = onCancelListener;
            return this;
        }

        public a p(DialogInterface.OnClickListener onClickListener) {
            this.f1150l = onClickListener;
            return this;
        }

        public a q(int i2, DialogInterface.OnClickListener onClickListener) {
            this.f1147i = (String) v0.g().getText(i2);
            this.f1151m = onClickListener;
            return this;
        }

        public a r(String str, DialogInterface.OnClickListener onClickListener) {
            this.f1147i = str;
            this.f1151m = onClickListener;
            return this;
        }

        public a s(int i2) {
            this.e = (String) v0.g().getText(i2);
            return this;
        }

        public a t(String str) {
            this.e = str;
            return this;
        }

        public a u(View view) {
            this.s = view;
            return this;
        }

        public a v(View view, RelativeLayout.LayoutParams layoutParams) {
            this.s = view;
            this.t = layoutParams;
            return this;
        }
    }

    public s(Context context, int i2) {
        super(context, i2);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        return new Bundle();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        DialogInterface.OnClickListener onClickListener = this.c;
        if (onClickListener != null) {
            try {
                onClickListener.onClick(this, 1);
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
        try {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setGravity(17);
            window.setAttributes(attributes);
        } catch (Exception e3) {
            k0.r(e3);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Runnable runnable;
        super.onWindowFocusChanged(z);
        if (!z || (runnable = this.d) == null) {
            return;
        }
        runnable.run();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e2) {
            k0.r(e2);
        }
    }
}
