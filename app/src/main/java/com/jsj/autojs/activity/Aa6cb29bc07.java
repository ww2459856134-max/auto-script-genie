package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.AlarmListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tencent.cursor.R;
import com.yl.model.AlarmTask;
import com.yl.ui.s;
import java.util.List;

/* loaded from: classes.dex */
public class Aa6cb29bc07 extends com.yl.ui.p implements View.OnClickListener {
    private RecyclerView P;
    private AlarmListAdapter Q;
    private List<AlarmTask> U;

    class a implements BaseQuickAdapter.OnItemClickListener {
        a(Aa6cb29bc07 aa6cb29bc07) {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        }
    }

    class b implements BaseQuickAdapter.OnItemLongClickListener {
        b() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
        public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            Aa6cb29bc07.this.p0(i2);
            return true;
        }
    }

    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ int c;

        c(int i2) {
            this.c = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Aa6cb29bc07.this.U.remove(this.c);
            Aa6cb29bc07.this.Q.notifyDataSetChanged();
            i.b.i7.p().E(Aa6cb29bc07.this.U);
            Aa6cb29bc07.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o0() {
        List<AlarmTask> list = this.U;
        if (list != null && !list.isEmpty()) {
            this.P.setVisibility(0);
            findViewById(2131296831).setVisibility(8);
            return false;
        }
        this.P.setVisibility(8);
        findViewById(2131296831).setVisibility(0);
        findViewById(2131296443).setOnClickListener(this);
        return true;
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492893;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("定时自动");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.P = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        o0();
    }

    public void n0() {
        List<AlarmTask> listK = i.b.i7.p().k();
        this.U = listK;
        AlarmListAdapter alarmListAdapter = this.Q;
        if (alarmListAdapter != null) {
            alarmListAdapter.setNewData(listK);
            return;
        }
        AlarmListAdapter alarmListAdapter2 = new AlarmListAdapter(this.U);
        this.Q = alarmListAdapter2;
        alarmListAdapter2.setEnableLoadMore(false);
        this.Q.setUpFetchEnable(true);
        this.Q.setOnItemClickListener(new a(this));
        this.Q.setOnItemLongClickListener(new b());
        this.P.setAdapter(this.Q);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296443) {
            return;
        }
        new com.yl.ui.q().j2(x(), "https://images.skyingidea.com/aitouch_alarm_img1.png");
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        n0();
    }

    public void p0(int i2) {
        try {
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("确认", new c(i2));
            aVar.m("取消", null);
            aVar.j("是否确认删除该定时自动任务？");
            aVar.t("开启提醒");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
