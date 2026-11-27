package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;
    private final Context a;
    final v0 b;
    private final Window c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    ListView g;

    /* renamed from: h, reason: collision with root package name */
    private View f6h;

    /* renamed from: i, reason: collision with root package name */
    private int f7i;

    /* renamed from: j, reason: collision with root package name */
    private int f8j;

    /* renamed from: k, reason: collision with root package name */
    private int f9k;

    /* renamed from: l, reason: collision with root package name */
    private int f10l;

    /* renamed from: m, reason: collision with root package name */
    private int f11m;

    /* renamed from: o, reason: collision with root package name */
    Button f13o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new c(this);

    public static class RecycleListView extends ListView {
        private final int c;
        private final int d;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.c, getPaddingRight(), z2 ? getPaddingBottom() : this.d);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.T1);
            this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(h.a.j.U1, -1);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(h.a.j.V1, -1);
        }
    }

    public AlertController(Context context, v0 v0Var, Window window) {
        this.a = context;
        this.b = v0Var;
        this.c = window;
        this.R = new n(v0Var);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, h.a.j.G, h.a.a.f1183o, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(h.a.j.H, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(h.a.j.J, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(h.a.j.L, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(h.a.j.M, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(h.a.j.O, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(h.a.j.K, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(h.a.j.N, true);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.a.j.I, 0);
        typedArrayObtainStyledAttributes.recycle();
        v0Var.f(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i2 = this.K;
        return i2 == 0 ? this.J : this.Q == 1 ? i2 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i2, int i3) {
        View viewFindViewById = this.c.findViewById(h.a.f.B);
        View viewFindViewById2 = this.c.findViewById(h.a.f.A);
        if (Build.VERSION.SDK_INT >= 23) {
            h.e.j.s0.h0(view, i2, i3);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f != null) {
            this.A.setOnScrollChangeListener(new d(this, viewFindViewById, viewFindViewById2));
            this.A.post(new e(this, viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.g;
        if (listView != null) {
            listView.setOnScrollListener(new f(this, viewFindViewById, viewFindViewById2));
            this.g.post(new g(this, viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f13o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.f13o.setVisibility(8);
            i2 = 0;
        } else {
            this.f13o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i3 = this.d;
                drawable.setBounds(0, 0, i3, i3);
                this.f13o.setCompoundDrawables(this.r, null, null, null);
            }
            this.f13o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i4 = this.d;
                drawable2.setBounds(0, 0, i4, i4);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i5 = this.d;
                drawable3.setBounds(0, 0, i5, i5);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            i2 |= 4;
        }
        if (z(this.a)) {
            if (i2 == 1) {
                b(this.f13o);
            } else if (i2 == 2) {
                b(this.s);
            } else if (i2 == 4) {
                b(this.w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.c.findViewById(h.a.f.C);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View viewInflate = this.f6h;
        if (viewInflate == null) {
            viewInflate = this.f7i != 0 ? LayoutInflater.from(this.a).inflate(this.f7i, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !a(viewInflate)) {
            this.c.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.c.findViewById(h.a.f.f1208o);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f12n) {
            frameLayout.setPadding(this.f8j, this.f9k, this.f10l, this.f11m);
        }
        if (this.g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.c.findViewById(h.a.f.U).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.e)) || !this.P) {
            this.c.findViewById(h.a.f.U).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.c.findViewById(h.a.f.f1204k);
        this.E = textView;
        textView.setText(this.e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.c.findViewById(h.a.f.z);
        int i2 = h.a.f.V;
        View viewFindViewById4 = viewFindViewById3.findViewById(i2);
        int i3 = h.a.f.f1207n;
        View viewFindViewById5 = viewFindViewById3.findViewById(i3);
        int i4 = h.a.f.f1205l;
        View viewFindViewById6 = viewFindViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(h.a.f.p);
        w(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i2);
        View viewFindViewById8 = viewGroup.findViewById(i3);
        View viewFindViewById9 = viewGroup.findViewById(i4);
        ViewGroup viewGroupI = i(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupI2 = i(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupI3 = i(viewFindViewById9, viewFindViewById6);
        v(viewGroupI2);
        u(viewGroupI3);
        x(viewGroupI);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupI2 != null && (viewFindViewById2 = viewGroupI2.findViewById(h.a.f.Q)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f == null && this.g == null) ? null : viewGroupI.findViewById(h.a.f.T);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupI2 != null && (viewFindViewById = viewGroupI2.findViewById(h.a.f.R)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view = this.g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(viewGroupI2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i5 = this.I;
        if (i5 > -1) {
            listView2.setItemChecked(i5, true);
            listView2.setSelection(i5);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(h.a.a.f1182n, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.g;
    }

    public void e() {
        this.b.setContentView(j());
        y();
    }

    public boolean g(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void k(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i2) {
        this.f6h = null;
        this.f7i = i2;
        this.f12n = false;
    }

    public void s(View view) {
        this.f6h = view;
        this.f7i = 0;
        this.f12n = false;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.f6h = view;
        this.f7i = 0;
        this.f12n = true;
        this.f8j = i2;
        this.f9k = i3;
        this.f10l = i4;
        this.f11m = i5;
    }
}
