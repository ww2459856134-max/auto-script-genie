package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes.dex */
public class p extends v0 implements DialogInterface {
    final AlertController e;

    public static class a {
        private final m a;
        private final int b;

        public a(Context context) {
            this(context, p.h(context, 0));
        }

        public p a() {
            p pVar = new p(this.a.a, this.b);
            this.a.a(pVar.e);
            pVar.setCancelable(this.a.r);
            if (this.a.r) {
                pVar.setCanceledOnTouchOutside(true);
            }
            pVar.setOnCancelListener(this.a.s);
            pVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                pVar.setOnKeyListener(onKeyListener);
            }
            return pVar;
        }

        public Context b() {
            return this.a.a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            m mVar = this.a;
            mVar.w = listAdapter;
            mVar.x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.a.g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.a.f24h = charSequence;
            return this;
        }

        public a g(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            m mVar = this.a;
            mVar.v = charSequenceArr;
            mVar.J = onMultiChoiceClickListener;
            mVar.F = zArr;
            mVar.G = true;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            m mVar = this.a;
            mVar.f28l = charSequence;
            mVar.f30n = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            m mVar = this.a;
            mVar.f25i = charSequence;
            mVar.f27k = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            m mVar = this.a;
            mVar.w = listAdapter;
            mVar.x = onClickListener;
            mVar.I = i2;
            mVar.H = true;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            m mVar = this.a;
            mVar.v = charSequenceArr;
            mVar.x = onClickListener;
            mVar.I = i2;
            mVar.H = true;
            return this;
        }

        public a m(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public a n(View view) {
            m mVar = this.a;
            mVar.z = view;
            mVar.y = 0;
            mVar.E = false;
            return this;
        }

        public a(Context context, int i2) {
            this.a = new m(new ContextThemeWrapper(context, p.h(context, i2)));
            this.b = i2;
        }
    }

    protected p(Context context, int i2) {
        super(context, h(context, i2));
        this.e = new AlertController(getContext(), this, getWindow());
    }

    static int h(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(h.a.a.p, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView g() {
        return this.e.d();
    }

    @Override // androidx.appcompat.app.v0, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.e.g(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.e.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.v0, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.e.q(charSequence);
    }
}
