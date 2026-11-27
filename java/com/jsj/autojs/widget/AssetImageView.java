package com.jsj.autojs.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.jsj.autojs.h;
import com.jsj.autojs.l.w;

/* loaded from: classes.dex */
public final class AssetImageView extends AppCompatImageView {
    public AssetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a);
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                w.b(this, string);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
