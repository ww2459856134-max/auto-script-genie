package com.v;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.item.InputItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class VersionDialogView extends RelativeLayout {
    private InputItem c;
    protected TextView d;
    protected TextView e;
    private Node f;
    private lt g;

    /* renamed from: h, reason: collision with root package name */
    private DialogInterface.OnCancelListener f1078h;

    public VersionDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f0, (ViewGroup) this, true);
        this.c = (InputItem) findViewById(j.b.e.n3);
        this.d = (TextView) findViewById(j.b.e.P);
        this.e = (TextView) findViewById(j.b.e.g);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.ur
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.b(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.tr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(View view) {
        com.frame.s0.g().d(VersionDialogView.class);
        DialogInterface.OnCancelListener onCancelListener = this.f1078h;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.g.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        if (this.g != null) {
            this.f.text = this.c.getValue();
            com.frame.s0.g().d(VersionDialogView.class);
            post(new Runnable() { // from class: com.v.sr
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
        }
    }

    public VersionDialogView g(lt ltVar) {
        this.g = ltVar;
        return this;
    }

    public VersionDialogView h(Task task, Node node) {
        this.f = node;
        String str = node.text;
        if (str == null) {
            this.c.setValue(com.frame.p0.h().j());
        } else {
            this.c.setValue(str);
        }
        return this;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f1078h = onCancelListener;
    }
}
