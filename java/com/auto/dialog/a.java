package com.auto.dialog;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class a extends RecyclerView.n {
    private int a;
    private int b;
    private int c;
    private int d;

    public a(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.left = this.a;
        rect.right = this.b;
        rect.bottom = this.c;
        rect.top = this.d;
    }
}
