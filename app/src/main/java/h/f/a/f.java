package h.f.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class f extends c {
    private LayoutInflater A;

    /* renamed from: k, reason: collision with root package name */
    private int f1324k;
    private int t;

    @Deprecated
    public f(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.t = i2;
        this.f1324k = i2;
        this.A = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // h.f.a.c
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.A.inflate(this.t, viewGroup, false);
    }

    @Override // h.f.a.c
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.A.inflate(this.f1324k, viewGroup, false);
    }
}
