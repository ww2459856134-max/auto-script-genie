package com.v;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.v.TaskChooseDialogView1;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import com.yl.model.TaskSimple;

/* loaded from: classes.dex */
public class LooperCountDurationDialogView extends DingMsgView {
    private Task A;

    /* renamed from: h, reason: collision with root package name */
    public boolean f982h = true;

    /* renamed from: i, reason: collision with root package name */
    private EditText f983i;

    /* renamed from: j, reason: collision with root package name */
    private EditText f984j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f985k;
    private a t;

    public interface a {
        void a(String str);
    }

    public LooperCountDurationDialogView() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.J, null);
        viewInflate.findViewById(j.b.e.s3).setVisibility(8);
        this.f983i = (EditText) viewInflate.findViewById(j.b.e.C1);
        this.f984j = (EditText) viewInflate.findViewById(j.b.e.F1);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.v);
        this.f985k = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.wb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r(view);
            }
        });
        this.f985k.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.xb
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.c.t(view);
            }
        });
        a(viewInflate);
        l("循环设置");
        this.f984j.setInputType(2);
        this.f984j.setHint("循环间隔时长");
        this.f983i.setInputType(4098);
        this.f983i.setHint("无限：-1");
        k("确定", new View.OnClickListener() { // from class: com.v.zb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.v(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.yb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.x(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(boolean z, TaskSimple taskSimple) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        this.f985k.setText(taskSimple.getName());
        this.f985k.setTag(Long.valueOf(taskSimple.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        TaskChooseDialogView1.u().setOnChooseListener(new TaskChooseDialogView1.b() { // from class: com.v.ac
            @Override // com.v.TaskChooseDialogView1.b
            public final void a(boolean z, TaskSimple taskSimple) {
                this.a.p(z, taskSimple);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean t(View view) {
        this.f985k.setText((CharSequence) null);
        this.f985k.setTag(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(View view) {
        try {
            this.A.setRepeatCount(Integer.parseInt(this.f983i.getText().toString()));
            try {
                this.A.setRepeatDelay(Integer.parseInt(this.f984j.getText().toString()));
                com.frame.s0.g().o(this);
                if (this.f985k.getTag() != null) {
                    this.A.setRepeatFinishJumpTaskId(((Long) this.f985k.getTag()).longValue());
                } else {
                    this.A.setRepeatFinishJumpTaskId(0L);
                }
                if (this.f982h) {
                    i.b.da.B().R1(this.A);
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(null);
                }
            } catch (Exception unused) {
                this.f984j.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入整数（毫秒）");
            }
        } catch (Exception unused2) {
            this.f983i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入整数（次数）");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(View view) {
        com.frame.s0.g().o(this);
    }

    public void setAutoSave(boolean z) {
        this.f982h = z;
    }

    public void setTask(Task task) {
        this.A = task;
        this.f984j.setText(task.getRepeatDelay() + "");
        if (task.getRepeatCount() != 0) {
            this.f983i.setText(task.getRepeatCount() + "");
        }
        if (task.getRepeatFinishJumpTaskId() != 0) {
            Task taskL = i.b.da.B().L(task.getRepeatFinishJumpTaskId());
            if (taskL == null) {
                this.f985k.setText("设置的任务未找到");
                this.f985k.setTextColor(-65536);
            } else {
                this.f985k.setText(taskL.getName());
                this.f985k.setTag(Long.valueOf(task.getRepeatFinishJumpTaskId()));
            }
        }
    }

    public LooperCountDurationDialogView y(a aVar) {
        this.t = aVar;
        return this;
    }
}
