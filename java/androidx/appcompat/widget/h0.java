package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
class h0 extends g0 {
    h0() {
    }

    @Override // androidx.appcompat.widget.g0, androidx.appcompat.widget.i0
    void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // androidx.appcompat.widget.i0
    boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
