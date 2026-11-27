package h.e.j;

import android.view.View;

/* loaded from: classes.dex */
class j0 extends l0<Boolean> {
    j0(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean d(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean h(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
