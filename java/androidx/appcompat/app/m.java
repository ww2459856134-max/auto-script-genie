package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class m {
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean[] F;
    public boolean G;
    public boolean H;
    public DialogInterface.OnMultiChoiceClickListener J;
    public Cursor K;
    public String L;
    public String M;
    public AdapterView.OnItemSelectedListener N;
    public l O;
    public final Context a;
    public final LayoutInflater b;
    public Drawable d;
    public CharSequence f;
    public View g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f24h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f25i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f26j;

    /* renamed from: k, reason: collision with root package name */
    public DialogInterface.OnClickListener f27k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f28l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f29m;

    /* renamed from: n, reason: collision with root package name */
    public DialogInterface.OnClickListener f30n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f31o;
    public Drawable p;
    public DialogInterface.OnClickListener q;
    public DialogInterface.OnCancelListener s;
    public DialogInterface.OnDismissListener t;
    public DialogInterface.OnKeyListener u;
    public CharSequence[] v;
    public ListAdapter w;
    public DialogInterface.OnClickListener x;
    public int y;
    public View z;
    public int c = 0;
    public int e = 0;
    public boolean E = false;
    public int I = -1;
    public boolean r = true;

    public m(Context context) {
        this.a = context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void b(AlertController alertController) {
        ListAdapter oVar;
        AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) this.b.inflate(alertController.L, (ViewGroup) null);
        if (this.G) {
            oVar = this.K == null ? new h(this, this.a, alertController.M, R.id.text1, this.v, recycleListView) : new i(this, this.a, this.K, false, recycleListView, alertController);
        } else {
            int i2 = this.H ? alertController.N : alertController.O;
            if (this.K != null) {
                oVar = new SimpleCursorAdapter(this.a, i2, this.K, new String[]{this.L}, new int[]{R.id.text1});
            } else {
                oVar = this.w;
                if (oVar == null) {
                    oVar = new o(this.a, i2, R.id.text1, this.v);
                }
            }
        }
        l lVar = this.O;
        if (lVar != null) {
            lVar.a(recycleListView);
        }
        alertController.H = oVar;
        alertController.I = this.I;
        if (this.x != null) {
            recycleListView.setOnItemClickListener(new j(this, alertController));
        } else if (this.J != null) {
            recycleListView.setOnItemClickListener(new k(this, recycleListView, alertController));
        }
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
        if (onItemSelectedListener != null) {
            recycleListView.setOnItemSelectedListener(onItemSelectedListener);
        }
        if (this.H) {
            recycleListView.setChoiceMode(1);
        } else if (this.G) {
            recycleListView.setChoiceMode(2);
        }
        alertController.g = recycleListView;
    }

    public void a(AlertController alertController) {
        View view = this.g;
        if (view != null) {
            alertController.l(view);
        } else {
            CharSequence charSequence = this.f;
            if (charSequence != null) {
                alertController.q(charSequence);
            }
            Drawable drawable = this.d;
            if (drawable != null) {
                alertController.n(drawable);
            }
            int i2 = this.c;
            if (i2 != 0) {
                alertController.m(i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                alertController.m(alertController.c(i3));
            }
        }
        CharSequence charSequence2 = this.f24h;
        if (charSequence2 != null) {
            alertController.o(charSequence2);
        }
        CharSequence charSequence3 = this.f25i;
        if (charSequence3 != null || this.f26j != null) {
            alertController.k(-1, charSequence3, this.f27k, null, this.f26j);
        }
        CharSequence charSequence4 = this.f28l;
        if (charSequence4 != null || this.f29m != null) {
            alertController.k(-2, charSequence4, this.f30n, null, this.f29m);
        }
        CharSequence charSequence5 = this.f31o;
        if (charSequence5 != null || this.p != null) {
            alertController.k(-3, charSequence5, this.q, null, this.p);
        }
        if (this.v != null || this.K != null || this.w != null) {
            b(alertController);
        }
        View view2 = this.z;
        if (view2 != null) {
            if (this.E) {
                alertController.t(view2, this.A, this.B, this.C, this.D);
                return;
            } else {
                alertController.s(view2);
                return;
            }
        }
        int i4 = this.y;
        if (i4 != 0) {
            alertController.r(i4);
        }
    }
}
