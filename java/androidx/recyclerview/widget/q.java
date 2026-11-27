package androidx.recyclerview.widget;

import java.util.Comparator;

/* loaded from: classes.dex */
final class q implements Comparator<u> {
    q() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(u uVar, u uVar2) {
        int i2 = uVar.a - uVar2.a;
        return i2 == 0 ? uVar.b - uVar2.b : i2;
    }
}
