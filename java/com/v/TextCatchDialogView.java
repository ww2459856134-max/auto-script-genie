package com.v;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class TextCatchDialogView extends RelativeLayout implements View.OnClickListener {
    public TextCatchDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.Z, (ViewGroup) this, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.g) {
            return;
        }
        view.getId();
    }

    public void setTaskNode(Task task, Node node) {
    }
}
