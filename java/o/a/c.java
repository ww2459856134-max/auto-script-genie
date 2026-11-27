package o.a;

import android.graphics.Bitmap;
import java.util.IdentityHashMap;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

/* loaded from: classes3.dex */
public final class c {
    private final IdentityHashMap<Bitmap, Mat> a = new IdentityHashMap<>();

    public synchronized e a(Mat mat, Bitmap bitmap, double d) {
        if (mat != null) {
            if (!mat.d() && bitmap != null && !bitmap.isRecycled()) {
                Mat mat2 = this.a.get(bitmap);
                if (mat2 == null || mat2.d()) {
                    if (mat2 != null) {
                        mat2.h();
                    }
                    mat2 = new Mat();
                    try {
                        Utils.a(bitmap, mat2);
                        this.a.put(bitmap, mat2);
                    } catch (RuntimeException e) {
                        mat2.h();
                        throw e;
                    }
                }
                return d.f(mat, mat2, d);
            }
        }
        return new e(-1, -1);
    }

    public synchronized void b() {
        for (Mat mat : this.a.values()) {
            if (mat != null) {
                mat.h();
            }
        }
        this.a.clear();
    }
}
