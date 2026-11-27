package com.jsj.autojs.i;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.fragment.app.p1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.BackupSimpleListAdapter;
import com.jsj.autojs.model.ScriptModel;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class w extends androidx.fragment.app.s implements View.OnClickListener {
    private Window P0;
    private BackupSimpleListAdapter Q0;
    private List<ScriptModel.ContentBean> R0;
    private b S0;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            w.this.Q0.e(z);
            w.this.Q0.notifyDataSetChanged();
        }
    }

    public interface b {
        void a(Collection<ScriptModel.ContentBean> collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n2(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.Q0.g(i2);
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        try {
            Window window = a2().getWindow();
            this.P0 = window;
            window.setBackgroundDrawableResource(R.color.transparent);
            this.P0.setWindowAnimations(com.tencent.cursor.R.style.bottomDialog);
            WindowManager.LayoutParams attributes = this.P0.getAttributes();
            attributes.gravity = 17;
            attributes.width = R().getDisplayMetrics().widthPixels;
            this.P0.setAttributes(attributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.s
    public void j2(p1 p1Var, String str) {
        try {
            super.j2(p1Var, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void o2(b bVar) {
        this.S0 = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297200) {
            this.S0.a(this.Q0.d());
            X1();
        } else {
            if (id != 2131297272) {
                return;
            }
            X1();
        }
    }

    public void p2(List<ScriptModel.ContentBean> list) {
        this.R0 = list;
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a2().requestWindowFeature(1);
        View viewInflate = layoutInflater.inflate(2131492947, (ViewGroup) null);
        viewInflate.findViewById(com.tencent.cursor.R.id.tv_accept).setOnClickListener(this);
        viewInflate.findViewById(com.tencent.cursor.R.id.tv_refuse).setOnClickListener(this);
        ((CheckBox) viewInflate.findViewById(2131296547)).setOnCheckedChangeListener(new a());
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.tencent.cursor.R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(q()));
        BackupSimpleListAdapter backupSimpleListAdapter = new BackupSimpleListAdapter(this.R0);
        this.Q0 = backupSimpleListAdapter;
        backupSimpleListAdapter.f(true);
        this.Q0.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.i.a
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.n2(baseQuickAdapter, view, i2);
            }
        });
        recyclerView.setAdapter(this.Q0);
        return viewInflate;
    }
}
