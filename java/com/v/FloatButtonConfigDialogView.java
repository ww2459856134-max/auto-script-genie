package com.v;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.HabitWidgetColorAdapter;
import com.adapter.TextColorAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.TaskChooseDialogView;
import com.v.item.AppCheckItem;
import com.yl.model.FloatButtonConfig;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.Arrays;

/* loaded from: classes.dex */
public class FloatButtonConfigDialogView extends RelativeLayout implements View.OnClickListener {
    private TextView A;
    private TextView C;
    private TextView D;
    private TextView G;
    private SeekBar H;
    private SeekBar I;
    private HabitWidgetColorAdapter c;
    private TextColorAdapter d;
    private Integer[] e;
    private c f;
    private FloatButtonConfig g;

    /* renamed from: h, reason: collision with root package name */
    private EditText f953h;

    /* renamed from: i, reason: collision with root package name */
    private View f954i;

    /* renamed from: j, reason: collision with root package name */
    private View f955j;

    /* renamed from: k, reason: collision with root package name */
    private AppCheckItem f956k;
    private View t;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            FloatButtonConfigDialogView.this.G.setText("悬浮透明度（" + i2 + "%）");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            FloatButtonConfigDialogView.this.D.setText("悬浮键大小（" + i2 + "）");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public interface c {
        void a(FloatButtonConfig floatButtonConfig);
    }

    public FloatButtonConfigDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.w, (ViewGroup) this, true);
        this.f953h = (EditText) findViewById(j.b.e.J1);
        this.H = (SeekBar) findViewById(j.b.e.Y4);
        SeekBar seekBar = (SeekBar) findViewById(j.b.e.X4);
        this.I = seekBar;
        seekBar.setMax(100);
        this.H.setMax(50);
        this.C = (TextView) findViewById(j.b.e.t0);
        this.A = (TextView) findViewById(j.b.e.V5);
        this.f955j = findViewById(j.b.e.n4);
        this.f956k = (AppCheckItem) findViewById(j.b.e.V1);
        this.f954i = findViewById(j.b.e.I4);
        this.D = (TextView) findViewById(j.b.e.Q5);
        this.G = (TextView) findViewById(j.b.e.u5);
        this.C.setOnClickListener(this);
        this.f955j.setOnClickListener(this);
        this.f954i.setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
        View viewFindViewById = findViewById(j.b.e.c5);
        viewFindViewById.setOnClickListener(this);
        findViewById(j.b.e.d5).setOnClickListener(this);
        findViewById(j.b.e.e5).setOnClickListener(this);
        this.t = viewFindViewById;
        viewFindViewById.setSelected(true);
        this.f954i.setVisibility(8);
        new LinearLayoutManager(com.frame.v0.g());
        this.e = new Integer[]{-16777216, Integer.valueOf(Color.parseColor("#ffffff")), Integer.valueOf(Color.parseColor("#789FFB")), Integer.valueOf(Color.parseColor("#79D383")), Integer.valueOf(Color.parseColor("#E87575")), Integer.valueOf(Color.parseColor("#E49757"))};
        this.c = new HabitWidgetColorAdapter(Arrays.asList(this.e));
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.P4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(com.frame.v0.g());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.B2(0);
        recyclerView.setAdapter(this.c);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.r5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.d(baseQuickAdapter, view, i2);
            }
        });
        this.d = new TextColorAdapter(Arrays.asList(this.e));
        RecyclerView recyclerView2 = (RecyclerView) findViewById(j.b.e.Q4);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(com.frame.v0.g());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        linearLayoutManager2.B2(0);
        recyclerView2.setAdapter(this.d);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.s5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.f(baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.c.e(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.d.e(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view, TaskSimple taskSimple) {
        view.setTag(Long.valueOf(taskSimple.getId()));
        this.A.setText(taskSimple.getName());
    }

    public FloatButtonConfigDialogView i(FloatButtonConfig floatButtonConfig) {
        Task taskL;
        this.g = floatButtonConfig;
        int iIndexOf = Arrays.asList(this.e).indexOf(Integer.valueOf(floatButtonConfig.color));
        int iIndexOf2 = Arrays.asList(this.e).indexOf(Integer.valueOf(floatButtonConfig.textColor));
        HabitWidgetColorAdapter habitWidgetColorAdapter = this.c;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        habitWidgetColorAdapter.e(iIndexOf);
        TextColorAdapter textColorAdapter = this.d;
        if (iIndexOf2 == -1) {
            iIndexOf2 = 0;
        }
        textColorAdapter.e(iIndexOf2);
        this.f955j.setTag(null);
        this.A.setText("选择任务");
        if (floatButtonConfig.taskId != 0 && (taskL = i.b.da.B().L(floatButtonConfig.taskId)) != null) {
            this.A.setText(taskL.getName());
            this.f955j.setTag(Long.valueOf(floatButtonConfig.taskId));
        }
        this.f956k.setValue(floatButtonConfig.appPn);
        this.f953h.setText(this.g.text);
        this.C.setSelected(floatButtonConfig.hideInRun);
        this.I.setOnSeekBarChangeListener(new a());
        this.H.setOnSeekBarChangeListener(new b());
        this.H.setProgress(floatButtonConfig.radius);
        this.I.setProgress((int) (floatButtonConfig.alpha * 100.0f));
        return this;
    }

    public FloatButtonConfigDialogView j(c cVar) {
        this.f = cVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(FloatButtonConfigDialogView.class);
            return;
        }
        if (id != j.b.e.g) {
            if (id == j.b.e.t0) {
                view.setSelected(!view.isSelected());
                return;
            } else {
                if (id == j.b.e.n4) {
                    TaskChooseDialogView.show().setOnChooseListener(new TaskChooseDialogView.b() { // from class: com.v.t5
                        @Override // com.v.TaskChooseDialogView.b
                        public final void a(TaskSimple taskSimple) {
                            this.a.h(view, taskSimple);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (this.f955j.getTag() == null) {
            this.f955j.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        com.frame.s0.g().o(this);
        this.g.taskId = ((Long) this.f955j.getTag()).longValue();
        this.g.appPn = this.f956k.getValue();
        this.g.pageCls = (String) this.f954i.getTag();
        this.g.radius = this.H.getProgress();
        this.g.text = this.f953h.getText().toString();
        this.g.color = this.e[this.c.d()].intValue();
        this.g.textColor = this.e[this.d.d()].intValue();
        this.g.alpha = this.I.getProgress() / 100.0f;
        this.g.hideInRun = this.C.isSelected();
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(this.g);
        }
    }
}
