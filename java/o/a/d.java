package o.a;

import android.graphics.Bitmap;
import java.util.LinkedList;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes3.dex */
public abstract class d {
    static boolean a(int i2, int i3, int i4, int i5) {
        return i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0 && i4 <= i2 && i5 <= i3;
    }

    private static Mat b(Mat mat, Mat mat2) {
        if (mat == null || mat2 == null || mat.d() || mat2.d() || !a(mat.i(), mat.b(), mat2.i(), mat2.b())) {
            return null;
        }
        return new Mat((mat.i() - mat2.i()) + 1, (mat.b() - mat2.b()) + 1, org.opencv.core.b.c);
    }

    public static LinkedList<e> c(Bitmap bitmap, a aVar) {
        LinkedList<e> linkedList = new LinkedList<>();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i2 = 0; i2 < width; i2++) {
            for (int i3 = 0; i3 < height; i3++) {
                if (a.d(e(bitmap, i2, i3), aVar)) {
                    linkedList.add(new e(i2, i3));
                }
            }
        }
        return linkedList;
    }

    public static String d(int i2) {
        return String.format("%06x", Integer.valueOf(i2 & 16777215));
    }

    public static a e(Bitmap bitmap, int i2, int i3) {
        try {
            return new a(bitmap.getPixel(i2, i3));
        } catch (IllegalArgumentException unused) {
            return new a(0, 0, 0);
        }
    }

    public static e f(Mat mat, Mat mat2, double d) {
        if (d <= 0.0d) {
            d = 0.5d;
        }
        Mat matB = b(mat, mat2);
        try {
            return g(mat, mat2, matB, d);
        } finally {
            if (matB != null) {
                matB.h();
            }
        }
    }

    private static e g(Mat mat, Mat mat2, Mat mat3, double d) {
        if (mat3 == null || mat3.d()) {
            return new e(-1, -1);
        }
        Imgproc.e(mat, mat2, mat3, 5);
        org.opencv.core.a aVarJ = Core.j(mat3);
        if (aVarJ.a < d) {
            return new e(-1, -1);
        }
        org.opencv.core.c cVar = aVarJ.c;
        return new e((int) cVar.a, (int) cVar.b);
    }
}
