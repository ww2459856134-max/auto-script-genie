package com.v;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.MultiTaskSimpleAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.ItemChooseDialogView;
import com.v.item.CheckItem;
import com.yl.float_ui.CanDragFloatView;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TaskChooseDialogView1 extends CanDragFloatView implements View.OnClickListener {
    private b c;
    private MultiTaskSimpleAdapter d;
    private EditText e;
    private View f;
    private Button g;

    /* renamed from: h, reason: collision with root package name */
    private CheckItem f1057h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f1058i;

    /* renamed from: j, reason: collision with root package name */
    private int f1059j;

    /* renamed from: k, reason: collision with root package name */
    private String f1060k;

    class a extends RecyclerView.n {
        final /* synthetic */ int a;

        a(TaskChooseDialogView1 taskChooseDialogView1, int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2 = this.a;
            rect.right = i2;
            rect.left = i2;
            rect.top = i2 / 2;
            rect.bottom = i2 / 2;
        }
    }

    public interface b {
        void a(boolean z, TaskSimple taskSimple);
    }

    public TaskChooseDialogView1() {
        this(com.frame.v0.g());
    }

    public static int getH() {
        return com.frame.n0.c("tcd_h", com.frame.p1.c(400.0f));
    }

    public static int getW() {
        return com.frame.n0.c("tcd_w", com.frame.p1.c(320.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskSimple taskSimple = (TaskSimple) this.d.getItem(i2);
        if (!"group".equals(taskSimple.getPn())) {
            if (this.c != null) {
                this.d.m(taskSimple);
            }
        } else if (((TaskSimple) this.d.getItem(i2)).isExpanded()) {
            this.d.collapse(i2);
        } else {
            this.d.expand(i2);
        }
    }

    private void init() {
        this.f1059j = com.frame.v0.f().getInt("taskSort", 0);
        View.inflate(com.frame.v0.g(), j.b.f.A, this);
        this.f1057h = (CheckItem) findViewById(j.b.e.l3);
        this.f = findViewById(j.b.e.i4);
        this.e = (EditText) findViewById(j.b.e.I1);
        int i2 = j.b.e.M;
        Button button = (Button) findViewById(i2);
        this.g = button;
        button.setOnClickListener(this);
        findViewById(j.b.e.u).setOnClickListener(this);
        findViewById(j.b.e.N).setOnClickListener(this);
        TextView textView = (TextView) findViewById(j.b.e.w6);
        textView.setText("任务列表");
        textView.setOnTouchListener(this.mSubTouchListener);
        MultiTaskSimpleAdapter multiTaskSimpleAdapter = new MultiTaskSimpleAdapter(null);
        this.d = multiTaskSimpleAdapter;
        multiTaskSimpleAdapter.n(true);
        this.f1058i = (RecyclerView) findViewById(j.b.e.O4);
        if (com.frame.k0.c().e() > com.frame.k0.c().d()) {
            this.f1058i.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 2));
        } else {
            this.f1058i.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        }
        this.f1058i.setAdapter(this.d);
        this.f1058i.g(new a(this, com.frame.p1.c(5.0f)));
        View viewFindViewById = findViewById(j.b.e.P);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnTouchListener(this.mSubTouchListener);
        findViewById(j.b.e.h0).setOnClickListener(this);
        View viewFindViewById2 = findViewById(i2);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById3 = findViewById(j.b.e.B);
        viewFindViewById3.setOnTouchListener(this.mSubTouchListener);
        viewFindViewById3.setOnClickListener(this);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.eo
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.j(baseQuickAdapter, view, i3);
            }
        });
        View viewFindViewById4 = findViewById(j.b.e.Q0);
        View viewFindViewById5 = findViewById(j.b.e.R0);
        i.b.y8 y8Var = new i.b.y8();
        y8Var.b(this, viewFindViewById4, new Runnable() { // from class: com.v.ft
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
        y8Var.a(this, viewFindViewById5, new Runnable() { // from class: com.v.ft
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        com.frame.p1.b(this.e.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        com.frame.p1.g(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(ItemChooseDialogView itemChooseDialogView, int i2, List list) {
        if (this.f1059j == i2) {
            this.f1059j = -i2;
        } else {
            this.f1059j = i2;
        }
        update();
        com.frame.v0.f().edit().putInt("taskSort", this.f1059j).apply();
        itemChooseDialogView.setDefaultData(this.f1059j);
        com.frame.s0.g().d(ItemChooseDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(List list) {
        this.d.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        final List<TaskSimple> listD = i.b.da.B().D(this.f1060k, this.f1059j);
        com.frame.l1.e(new Runnable() { // from class: com.v.bo
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r(listD);
            }
        });
    }

    public static TaskChooseDialogView1 u() {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        return (TaskChooseDialogView1) com.frame.s0.g().y(TaskChooseDialogView1.class, com.frame.n0.c("tcd_x", iE), com.frame.n0.c("tcd_y", iD), w, h2);
    }

    public static TaskChooseDialogView1 v(b bVar) {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        TaskChooseDialogView1 taskChooseDialogView1 = (TaskChooseDialogView1) com.frame.s0.g().y(TaskChooseDialogView1.class, com.frame.n0.c("tcd_x", iE), com.frame.n0.c("tcd_y", iD), w, h2);
        taskChooseDialogView1.setOnChooseListener(bVar);
        return taskChooseDialogView1;
    }

    public void endResize() {
        endMove(true);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        com.frame.n0.i("tcd_x", layoutParams.x);
        com.frame.n0.i("tcd_y", layoutParams.y);
        com.frame.n0.i("tcd_w", layoutParams.width);
        com.frame.n0.i("tcd_h", layoutParams.height);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        int w = getW();
        int h2 = getH();
        return new Point(com.frame.n0.c("tcd_x", (com.frame.q1.e() - w) / 2), com.frame.n0.c("tcd_y", (com.frame.q1.d() - h2) / 2));
    }

    @Override // com.yl.float_ui.CanDragFloatView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        update();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.N) {
            showSorterDialog();
            return;
        }
        if (id == j.b.e.u) {
            if (this.f.getVisibility() != 0) {
                this.f.setVisibility(0);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                if (Build.VERSION.SDK_INT >= 19) {
                    layoutParams.flags = 201328160;
                } else {
                    layoutParams.flags = 544;
                }
                com.frame.s0.g().I(this, layoutParams);
                post(new Runnable() { // from class: com.v.ao
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.n();
                    }
                });
                return;
            }
            this.f.setVisibility(8);
            this.g.setText("搜索");
            update();
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
            if (Build.VERSION.SDK_INT >= 19) {
                layoutParams2.flags = 201328160;
            } else {
                layoutParams2.flags = 544;
            }
            com.frame.s0.g().I(this, layoutParams2);
            post(new Runnable() { // from class: com.v.do
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l();
                }
            });
            return;
        }
        if (id == j.b.e.B) {
            if (this.d.d() == null) {
                FloatToast.i("请选择任务");
                return;
            } else {
                this.c.a(this.f1057h.getValue().booleanValue(), this.d.d());
                com.frame.s0.g().d(TaskChooseDialogView1.class);
                return;
            }
        }
        if (id != j.b.e.M) {
            if (id == j.b.e.P || id == j.b.e.h0) {
                com.frame.s0.g().d(TaskChooseDialogView1.class);
                return;
            }
            return;
        }
        if (this.g.getText().toString().equals("搜索")) {
            this.g.setText("取消");
            this.d.setNewData(i.b.da.B().T1(String.valueOf(this.e.getText())));
        } else {
            this.e.setText((CharSequence) null);
            this.g.setText("搜索");
            update();
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("tcd_x", point.x);
        com.frame.n0.i("tcd_y", point.y);
    }

    public void setDefaultValue(boolean z, TaskSimple taskSimple) {
        this.f1057h.setValue(z);
        this.d.m(taskSimple);
        this.f1058i.j1(this.d.getData().indexOf(taskSimple));
    }

    public void setGroupType(String str) {
        this.f1060k = str;
    }

    public void setOnChooseListener(b bVar) {
        this.c = bVar;
    }

    public void showSorterDialog() {
        final ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add("默认排序");
        int i2 = this.f1059j;
        if (i2 == 1) {
            arrayList.add("按名字排序（降序）");
        } else if (i2 == -1) {
            arrayList.add("按名字排序（升序）");
        } else {
            arrayList.add("按名字排序");
        }
        itemChooseDialogView.setDefaultData(this.f1059j, arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.fo
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.p(itemChooseDialogView, i3, list);
            }
        });
    }

    public void update() {
        this.d.l(i.b.da.B().J());
        com.frame.l1.g(new Runnable() { // from class: com.v.co
            @Override // java.lang.Runnable
            public final void run() {
                this.c.t();
            }
        });
    }

    public TaskChooseDialogView1(Context context) {
        this(context, null);
    }

    public TaskChooseDialogView1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1059j = 0;
        init();
    }
}
