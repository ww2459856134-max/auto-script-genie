package com.yl.float_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.frame.j1;
import com.frame.v0;
import java.io.File;

/* loaded from: classes.dex */
public class ScreenImageView extends ImageView {
    public ScreenImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setImageBitmap(j1.c().a(new File(v0.g().getExternalFilesDir(null), "/screenImage1.png").getAbsolutePath()));
    }

    public ScreenImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ScreenImageView() {
        super(v0.g());
    }
}
