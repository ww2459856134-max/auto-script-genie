package h.e.j.s1;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import h.e.j.s1.e;

/* loaded from: classes.dex */
class c extends InputConnectionWrapper {
    final /* synthetic */ e.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(InputConnection inputConnection, boolean z, e.a aVar) {
        super(inputConnection, z);
        this.a = aVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
        if (this.a.a(i.f(inputContentInfo), i2, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i2, bundle);
    }
}
