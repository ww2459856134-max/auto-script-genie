package com.yl.ui;

import android.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.p1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.v0;
import java.util.List;

/* loaded from: classes.dex */
public class w extends androidx.fragment.app.s implements View.OnClickListener {
    private View P0;
    private Window Q0;
    private RecyclerView R0;
    private a S0;
    private List<String> T0;
    private BaseQuickAdapter.OnItemClickListener U0;
    private String V0;

    class a extends BaseQuickAdapter<String, BaseViewHolder> {
        int[] a;

        public a(w wVar, List<String> list) {
            super(b0.g, list);
            this.a = new int[]{Color.parseColor("#E92D2D"), Color.parseColor("#E96A2D"), Color.parseColor("#687DC9"), Color.parseColor("#57B575"), Color.parseColor("#FCCF6D")};
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void convert(BaseViewHolder baseViewHolder, String str) {
            baseViewHolder.setText(a0.H, str);
            baseViewHolder.getView(a0.e).setBackgroundColor(this.a[baseViewHolder.getAdapterPosition() % this.a.length]);
        }
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        try {
            Window window = a2().getWindow();
            this.Q0 = window;
            window.setBackgroundDrawableResource(R.color.transparent);
            this.Q0.setWindowAnimations(d0.c);
            WindowManager.LayoutParams attributes = this.Q0.getAttributes();
            attributes.gravity = 17;
            attributes.width = (R().getDisplayMetrics().widthPixels * 2) / 3;
            this.Q0.setAttributes(attributes);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.fragment.app.s
    public void X1() {
        Y1();
    }

    @Override // androidx.fragment.app.s
    public void Y1() {
        if (q() == null || q().isFinishing()) {
            return;
        }
        super.Y1();
    }

    @Override // androidx.fragment.app.s
    public void j2(p1 p1Var, String str) {
        try {
            super.j2(p1Var, str);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void l2(List<String> list, BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.T0 = list;
        this.U0 = onItemClickListener;
    }

    public void m2(String str) {
        this.V0 = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == a0.b) {
                X1();
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a2().requestWindowFeature(1);
        View viewInflate = layoutInflater.inflate(b0.d, (ViewGroup) null);
        this.P0 = viewInflate;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(a0.r);
        this.R0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(v0.g()));
        a aVar = new a(this, this.T0);
        this.S0 = aVar;
        this.R0.setAdapter(aVar);
        this.S0.setOnItemClickListener(this.U0);
        ((TextView) this.P0.findViewById(a0.I)).setText(this.V0);
        this.P0.findViewById(a0.b).setOnClickListener(this);
        return this.P0;
    }
}
