package com.jsj.widget;

import android.view.View;
import android.widget.Toast;
import com.frame.v0;

/* loaded from: classes.dex */
public abstract class d {
    public static void a() {
        Toast toast = new Toast(v0.g());
        View viewInflate = View.inflate(v0.g(), 2131493187, null);
        toast.setView(viewInflate);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.show();
        ((SuccessAnimView) viewInflate.findViewById(2131297079)).e();
    }
}
