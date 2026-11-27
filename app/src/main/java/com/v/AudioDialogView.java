package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.v.item.FileItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class AudioDialogView extends RelativeLayout implements View.OnClickListener {
    private SelectItem c;
    private FileItem d;
    private lt e;
    private Node f;

    public AudioDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f1761l, (ViewGroup) this, true);
        this.c = (SelectItem) findViewById(j.b.e.X2);
        FileItem fileItem = (FileItem) findViewById(j.b.e.Z1);
        this.d = fileItem;
        fileItem.setCopyToLocal(true);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.c.setItems(new String[]{"默认声音", "播放本地声音", "仅震动"});
        this.c.setOnItemClick(new SelectItem.a() { // from class: com.v.b2
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i2, Object obj, String str) {
                this.a.b(z, i2, obj, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(boolean z, int i2, Object obj, String str) {
        e(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.e.a(this.f);
    }

    public void e(int i2) {
        if (i2 == 0 || i2 == 2) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.d.setVisibility(0);
        this.d.setValue(this.f.text);
    }

    public AudioDialogView f(lt ltVar) {
        this.e = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                return;
            }
            return;
        }
        this.f.what = ((Integer) this.c.getValue()).intValue();
        Node node = this.f;
        if (node.what == 1) {
            node.text = this.d.getValue().toString();
            if (TextUtils.isEmpty(this.f.text)) {
                FloatToast.g(j.b.d.k0, "请输入路声音文件路径");
                this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            }
        } else {
            node.text = null;
        }
        com.frame.s0.g().d(AudioDialogView.class);
        post(new Runnable() { // from class: com.v.c2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d();
            }
        });
    }

    public void setTaskNode(Task task, Node node) {
        this.f = node;
        this.c.setSelectValue(Integer.valueOf(node.what));
    }
}
