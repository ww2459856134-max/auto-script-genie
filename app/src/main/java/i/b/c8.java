package i.b;

import android.graphics.Bitmap;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes.dex */
public abstract class c8 {
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x007d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:39:0x007d */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #6 {all -> 0x007c, blocks: (B:7:0x001c, B:9:0x0031, B:10:0x003c, B:26:0x005f, B:28:0x0065, B:29:0x0068, B:33:0x006d, B:35:0x0073, B:36:0x0076, B:37:0x007b), top: B:48:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Bitmap bitmap, int i2, int i3) throws Throwable {
        Mat mat;
        try {
            if (!i9.v().m()) {
                throw new IllegalStateException("OpenCV初始化失败");
            }
            Mat mat2 = null;
            bitmapCreateBitmap = null;
            bitmapCreateBitmap = null;
            bitmapCreateBitmap = null;
            bitmapCreateBitmap = null;
            Bitmap bitmapCreateBitmap = null;
            try {
                try {
                    Mat mat3 = new Mat(bitmap.getWidth(), bitmap.getHeight(), org.opencv.core.b.a);
                    try {
                        Utils.a(bitmap, mat3);
                        Imgproc.b(mat3, mat3, 6);
                        Imgproc.f(mat3, mat3, i2, 255.0d, 1);
                        if (i3 != 0) {
                            double d = i3;
                            Imgproc.a(mat3, mat3, new org.opencv.core.d(d, d), 0.0d);
                        }
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        Utils.c(mat3, bitmapCreateBitmap);
                        mat3.h();
                        return bitmapCreateBitmap;
                    } catch (UnsatisfiedLinkError e) {
                        e = e;
                        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                            bitmapCreateBitmap.recycle();
                        }
                        throw new IllegalStateException("OpenCV native库未加载", e);
                    } catch (Error e2) {
                        e = e2;
                        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                            bitmapCreateBitmap.recycle();
                        }
                        throw e;
                    } catch (RuntimeException e3) {
                        e = e3;
                        if (bitmapCreateBitmap != null) {
                            bitmapCreateBitmap.recycle();
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    th = th;
                    mat2 = mat;
                    if (mat2 != null) {
                        mat2.h();
                    }
                    throw th;
                }
            } catch (UnsatisfiedLinkError e4) {
                e = e4;
            } catch (Error e5) {
                e = e5;
                if (bitmapCreateBitmap != null) {
                }
                throw e;
            } catch (RuntimeException e6) {
                e = e6;
                if (bitmapCreateBitmap != null) {
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
                if (mat2 != null) {
                }
                throw th;
            }
        } catch (UnsatisfiedLinkError e7) {
            throw new IllegalStateException("OpenCV native库未加载", e7);
        }
    }

    public static int b(String str) {
        if ("轻度".equals(str)) {
            return 3;
        }
        if ("中度".equals(str)) {
            return 7;
        }
        return "高度".equals(str) ? 9 : 0;
    }
}
