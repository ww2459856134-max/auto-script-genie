package h.e.j.q1;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {
    private final int c;
    private final e d;
    private final int e;

    public a(int i2, e eVar, int i3) {
        this.c = i2;
        this.d = eVar;
        this.e = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.c);
        this.d.L(this.e, bundle);
    }
}
