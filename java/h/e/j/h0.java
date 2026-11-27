package h.e.j;

import android.text.TextUtils;
import android.view.View;

/* loaded from: classes.dex */
class h0 extends l0<CharSequence> {
    h0(int i2, Class cls, int i3, int i4) {
        super(i2, cls, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public CharSequence d(View view) {
        return view.getAccessibilityPaneTitle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.e.j.l0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean h(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
