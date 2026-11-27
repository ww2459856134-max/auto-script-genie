package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.a0;
import androidx.appcompat.widget.t1;
import h.e.j.s0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements a0.a, AbsListView.SelectionBoundsAdjuster {
    private int A;
    private Context C;
    private boolean D;
    private Drawable G;
    private boolean H;
    private LayoutInflater I;
    private boolean J;
    private p c;
    private ImageView d;
    private RadioButton e;
    private TextView f;
    private CheckBox g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f50h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f51i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f52j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f53k;
    private Drawable t;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.D);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f53k;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(h.a.g.f1211j, (ViewGroup) this, false);
        this.g = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(h.a.g.f1212k, (ViewGroup) this, false);
        this.d = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(h.a.g.f1214m, (ViewGroup) this, false);
        this.e = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.I == null) {
            this.I = LayoutInflater.from(getContext());
        }
        return this.I;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f51i;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f52j;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52j.getLayoutParams();
        rect.top += this.f52j.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public void d(p pVar, int i2) {
        this.c = pVar;
        setVisibility(pVar.isVisible() ? 0 : 8);
        setTitle(pVar.i(this));
        setCheckable(pVar.isCheckable());
        setShortcut(pVar.A(), pVar.g());
        setIcon(pVar.getIcon());
        setEnabled(pVar.isEnabled());
        setSubMenuArrowVisible(pVar.hasSubMenu());
        setContentDescription(pVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.a0.a
    public p getItemData() {
        return this.c;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        s0.a0(this, this.t);
        TextView textView = (TextView) findViewById(h.a.f.S);
        this.f = textView;
        int i2 = this.A;
        if (i2 != -1) {
            textView.setTextAppearance(this.C, i2);
        }
        this.f50h = (TextView) findViewById(h.a.f.L);
        ImageView imageView = (ImageView) findViewById(h.a.f.O);
        this.f51i = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.G);
        }
        this.f52j = (ImageView) findViewById(h.a.f.u);
        this.f53k = (LinearLayout) findViewById(h.a.f.f1206m);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.d != null && this.D) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.e == null && this.g == null) {
            return;
        }
        if (this.c.m()) {
            if (this.e == null) {
                g();
            }
            compoundButton = this.e;
            compoundButton2 = this.g;
        } else {
            if (this.g == null) {
                e();
            }
            compoundButton = this.g;
            compoundButton2 = this.e;
        }
        if (z) {
            compoundButton.setChecked(this.c.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.g;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.e;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.c.m()) {
            if (this.e == null) {
                g();
            }
            compoundButton = this.e;
        } else {
            if (this.g == null) {
                e();
            }
            compoundButton = this.g;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.J = z;
        this.D = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f52j;
        if (imageView != null) {
            imageView.setVisibility((this.H || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.c.z() || this.J;
        if (z || this.D) {
            ImageView imageView = this.d;
            if (imageView == null && drawable == null && !this.D) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.D) {
                this.d.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.d;
            if (!z) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
    }

    public void setShortcut(boolean z, char c) {
        int i2 = (z && this.c.A()) ? 0 : 8;
        if (i2 == 0) {
            this.f50h.setText(this.c.h());
        }
        if (this.f50h.getVisibility() != i2) {
            this.f50h.setVisibility(i2);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f.getVisibility() != 8) {
                this.f.setVisibility(8);
            }
        } else {
            this.f.setText(charSequence);
            if (this.f.getVisibility() != 0) {
                this.f.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        t1 t1VarU = t1.u(getContext(), attributeSet, h.a.j.L1, i2, 0);
        this.t = t1VarU.f(h.a.j.N1);
        this.A = t1VarU.m(h.a.j.M1, -1);
        this.D = t1VarU.a(h.a.j.O1, false);
        this.C = context;
        this.G = t1VarU.f(h.a.j.P1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, h.a.a.A, 0);
        this.H = typedArrayObtainStyledAttributes.hasValue(0);
        t1VarU.v();
        typedArrayObtainStyledAttributes.recycle();
    }
}
