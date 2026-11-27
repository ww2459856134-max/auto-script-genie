package n.c.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class b extends Binder implements c {
    public static c g(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.opencv.engine.OpenCVEngineInterface");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
    }
}
