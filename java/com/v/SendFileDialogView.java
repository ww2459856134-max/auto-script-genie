package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.v.item.FileItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class SendFileDialogView extends RelativeLayout implements View.OnClickListener {
    private Node c;
    private FileItem d;
    private lt e;

    public SendFileDialogView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.e.a(this.c);
    }

    public void a() {
        View.inflate(com.frame.v0.g(), j.b.f.W, this);
        findViewById(j.b.e.A).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
        this.d = (FileItem) findViewById(j.b.e.o2);
    }

    public SendFileDialogView d(lt ltVar) {
        this.e = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.A) {
            com.frame.s0.g().o(this);
            return;
        }
        if (view.getId() == j.b.e.B) {
            try {
                this.c.url = this.d.getValue();
                com.frame.s0.g().d(SendFileDialogView.class);
                post(new Runnable() { // from class: com.v.il
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.c();
                    }
                });
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            com.frame.s0.g().o(this);
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.c = node;
        this.d.setValue(node.url);
    }

    public SendFileDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SendFileDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SendFileDialogView() {
        super(com.frame.v0.g());
        a();
    }
}
