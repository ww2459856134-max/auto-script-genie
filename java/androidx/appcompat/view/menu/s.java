package androidx.appcompat.view.menu;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
class s extends FrameLayout implements h.a.o.d {
    final CollapsibleActionView c;

    /* JADX WARN: Multi-variable type inference failed */
    s(View view) {
        super(view.getContext());
        this.c = (CollapsibleActionView) view;
        addView(view);
    }

    View a() {
        return (View) this.c;
    }

    @Override // h.a.o.d
    public void b() {
        this.c.onActionViewCollapsed();
    }

    @Override // h.a.o.d
    public void c() {
        this.c.onActionViewExpanded();
    }
}
