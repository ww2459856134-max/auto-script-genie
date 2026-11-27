package com.jsj.autojs.k;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class b extends Binder implements c {
    public static c g(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.jsj.autojs.ocrplugin.IPaddleOcrService");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
    }

    public static c h() {
        return a.b;
    }
}
