package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.v.item.AreaChooseItem;
import com.v.item.FileItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class WatermarkDialogView extends RelativeLayout implements View.OnClickListener {
    private Node c;
    private FileItem d;
    private AreaChooseItem e;
    private SeekBar f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private SelectItem f1079h;

    /* renamed from: i, reason: collision with root package name */
    private lt f1080i;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            WatermarkDialogView.this.g.setText("透明度" + i2 + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements SelectItem.a {
        b() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if (i2 == 1) {
                WatermarkDialogView.this.findViewById(j.b.e.j4).setVisibility(8);
                WatermarkDialogView.this.d.setVisibility(8);
                WatermarkDialogView.this.e.setVisibility(8);
            } else {
                WatermarkDialogView.this.findViewById(j.b.e.j4).setVisibility(0);
                WatermarkDialogView.this.d.setVisibility(0);
                WatermarkDialogView.this.e.setVisibility(0);
            }
        }
    }

    public WatermarkDialogView(Context context) {
        super(context);
    }

    public void d() {
        View.inflate(com.frame.v0.g(), j.b.f.g0, this);
        this.f1079h = (SelectItem) findViewById(j.b.e.Z2);
        this.g = (TextView) findViewById(j.b.e.u5);
        FileItem fileItem = (FileItem) findViewById(j.b.e.o2);
        this.d = fileItem;
        fileItem.setCopyToLocal(true);
        this.e = (AreaChooseItem) findViewById(j.b.e.X1);
        SeekBar seekBar = (SeekBar) findViewById(j.b.e.T4);
        this.f = seekBar;
        seekBar.setOnSeekBarChangeListener(new a());
        this.f1079h.setOnItemClick(new b());
        this.f1079h.setSelectValue(0);
        findViewById(j.b.e.A).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
    }

    public WatermarkDialogView e(lt ltVar) {
        this.f1080i = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.A) {
            com.frame.s0.g().o(this);
            return;
        }
        if (view.getId() == j.b.e.B) {
            this.c.what = ((Integer) this.f1079h.getValue()).intValue();
            this.c.url = this.d.getValue();
            this.e.u(this.c);
            this.c.argInt1 = this.f.getProgress();
            this.f1080i.a(this.c);
            com.frame.s0.g().o(this);
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.c = node;
        this.d.setValue(node.url);
        this.e.setValue(node.getArea(), node.areaParam);
        this.f.setProgress(node.argInt1, true);
        this.f1079h.setSelectValue(Integer.valueOf(node.what));
    }

    public WatermarkDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WatermarkDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public WatermarkDialogView() {
        super(com.frame.v0.g());
        d();
    }
}
