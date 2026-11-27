package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.v.item.InputItem;
import com.v.item.KeyValueItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class UrlDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    private Node d;
    private InputItem e;
    private KeyValueItem f;

    public UrlDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.e0, (ViewGroup) this, true);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.e = (InputItem) findViewById(j.b.e.m3);
        KeyValueItem keyValueItem = (KeyValueItem) findViewById(j.b.e.P2);
        this.f = keyValueItem;
        keyValueItem.setBtnAddName("添加额外信息(extra)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.c.a(this.d);
    }

    public UrlDialogView c(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                return;
            } else {
                if (view.getId() == j.b.e.I && TextUtils.isEmpty(i.b.da.B().G(this.e.getValue().toString()))) {
                    this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                }
                return;
            }
        }
        if (TextUtils.isEmpty(this.e.getValue().toString())) {
            this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        this.d.url = this.e.getValue().toString();
        this.d.arg2 = TextUtils.join("&", this.f.getValue());
        com.frame.s0.g().d(UrlDialogView.class);
        post(new Runnable() { // from class: com.v.rr
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b();
            }
        });
    }

    public void setTaskNode(Task task, Node node) {
        this.d = node;
        if (!TextUtils.isEmpty(node.arg2)) {
            this.f.setValue(new ArrayList(Arrays.asList(this.d.arg2.split("&"))));
        }
        this.e.setValue(this.d.url);
    }
}
