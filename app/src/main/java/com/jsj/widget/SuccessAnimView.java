package com.jsj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.jsj.widget.CircleView;

/* loaded from: classes.dex */
public class SuccessAnimView extends RelativeLayout {
    private SuccessTickView c;
    private FrameLayout d;
    private CircleView e;
    private boolean f;

    class a implements CircleView.a {
        a() {
        }

        @Override // com.jsj.widget.CircleView.a
        public void a() {
            if (SuccessAnimView.this.f) {
                return;
            }
            SuccessAnimView.this.f = true;
            SuccessAnimView.this.c.setVisibility(0);
            SuccessAnimView.this.c.l();
        }
    }

    public SuccessAnimView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void d() {
        View.inflate(getContext(), 2131493176, this);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131297078);
        this.d = frameLayout;
        SuccessTickView successTickView = (SuccessTickView) frameLayout.findViewById(2131297079);
        this.c = successTickView;
        successTickView.setVisibility(4);
        CircleView circleView = (CircleView) findViewById(2131296545);
        this.e = circleView;
        circleView.setOnFinishListener(new a());
    }

    public void e() {
        this.f = false;
        this.c.setVisibility(4);
        this.e.a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    public SuccessAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SuccessAnimView(Context context) {
        super(context);
        d();
    }
}
