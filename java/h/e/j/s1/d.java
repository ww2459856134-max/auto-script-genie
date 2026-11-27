package h.e.j.s1;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import h.e.j.s1.e;

/* loaded from: classes.dex */
class d extends InputConnectionWrapper {
    final /* synthetic */ e.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(InputConnection inputConnection, boolean z, e.a aVar) {
        super(inputConnection, z);
        this.a = aVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        if (e.b(str, bundle, this.a)) {
            return true;
        }
        return super.performPrivateCommand(str, bundle);
    }
}
