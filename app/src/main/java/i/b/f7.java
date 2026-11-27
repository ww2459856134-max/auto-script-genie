package i.b;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.SystemClock;
import android.util.Log;
import java.util.List;
import java.util.function.Predicate;

/* loaded from: classes.dex */
class f7 implements AccessibilityService.TakeScreenshotCallback {
    final /* synthetic */ Runnable a;
    final /* synthetic */ int b;
    final /* synthetic */ List c;
    final /* synthetic */ h7 d;

    f7(h7 h7Var, Runnable runnable, int i2, List list) {
        this.d = h7Var;
        this.a = runnable;
        this.b = i2;
        this.c = list;
    }

    static /* synthetic */ boolean a(g7 g7Var) {
        int i2 = g7Var.g;
        g7Var.g = i2 + 1;
        return i2 == 0;
    }

    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public void onFailure(int i2) {
        this.d.a.removeCallbacks(this.a);
        if (this.b != this.d.e) {
            return;
        }
        if (i2 == 3) {
            this.d.c = null;
            this.d.b.addAll(0, this.c);
            this.d.d = SystemClock.uptimeMillis();
            this.d.s();
            return;
        }
        if (i2 == 1 && this.c.stream().allMatch(new Predicate() { // from class: i.b.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return f7.a((g7) obj);
            }
        })) {
            this.d.c = null;
            this.d.b.addAll(0, this.c);
            this.d.s();
            return;
        }
        this.d.j(this.b, this.c, null, "无障碍截图失败（错误码 " + i2 + "），请检查无障碍服务及当前页面是否允许截图");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) throws Throwable {
        Bitmap bitmapCopy;
        Bitmap bitmap;
        HardwareBuffer hardwareBuffer;
        Bitmap bitmapWrapHardwareBuffer;
        Bitmap bitmap2;
        this.d.a.removeCallbacks(this.a);
        Bitmap bitmap3 = null;
        try {
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            try {
            } catch (Throwable th) {
                th = th;
                bitmapWrapHardwareBuffer = null;
                bitmap2 = null;
            }
        } catch (RuntimeException e) {
            e = e;
            bitmap = null;
            bitmapCopy = null;
        } catch (Throwable th2) {
            th = th2;
            bitmapCopy = null;
        }
        if (this.b != this.d.e) {
            if (hardwareBuffer != null) {
                hardwareBuffer.close();
                return;
            }
            return;
        }
        bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, screenshotResult.getColorSpace());
        if (bitmapWrapHardwareBuffer != null) {
            try {
                bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
            } catch (Throwable th3) {
                th = th3;
                bitmap2 = null;
                if (hardwareBuffer != null) {
                    try {
                        hardwareBuffer.close();
                    } catch (Throwable th4) {
                        try {
                            th.addSuppressed(th4);
                        } catch (RuntimeException e2) {
                            e = e2;
                            bitmapCopy = bitmap2;
                            RuntimeException runtimeException = e;
                            bitmap = bitmapWrapHardwareBuffer;
                            e = runtimeException;
                            try {
                                Log.e("AccessibilityCapture", "Screenshot conversion failed", e);
                                this.d.j(this.b, this.c, null, "无障碍截图转换失败");
                                if (bitmap != null) {
                                }
                                if (bitmapCopy == null) {
                                }
                                bitmapCopy.recycle();
                            } catch (Throwable th5) {
                                th = th5;
                                bitmap3 = bitmap;
                                if (bitmap3 != null) {
                                    bitmap3.recycle();
                                }
                                if (bitmapCopy != null) {
                                    bitmapCopy.recycle();
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            bitmap3 = bitmapWrapHardwareBuffer;
                            th = th6;
                            bitmapCopy = bitmap2;
                            if (bitmap3 != null) {
                            }
                            if (bitmapCopy != null) {
                            }
                            throw th;
                        }
                    }
                }
                throw th;
            }
        } else {
            bitmapCopy = null;
        }
        try {
            this.d.j(this.b, this.c, bitmapCopy, bitmapCopy == null ? "无障碍截图转换失败" : null);
            if (hardwareBuffer != null) {
                try {
                    hardwareBuffer.close();
                } catch (RuntimeException e3) {
                    e = e3;
                    RuntimeException runtimeException2 = e;
                    bitmap = bitmapWrapHardwareBuffer;
                    e = runtimeException2;
                    Log.e("AccessibilityCapture", "Screenshot conversion failed", e);
                    this.d.j(this.b, this.c, null, "无障碍截图转换失败");
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    if (bitmapCopy == null) {
                        return;
                    }
                    bitmapCopy.recycle();
                } catch (Throwable th7) {
                    bitmap3 = bitmapWrapHardwareBuffer;
                    th = th7;
                    if (bitmap3 != null) {
                    }
                    if (bitmapCopy != null) {
                    }
                    throw th;
                }
            }
            if (bitmapWrapHardwareBuffer != null) {
                bitmapWrapHardwareBuffer.recycle();
            }
            if (bitmapCopy == null) {
                return;
            }
            bitmapCopy.recycle();
        } catch (Throwable th8) {
            bitmap2 = bitmapCopy;
            th = th8;
            if (hardwareBuffer != null) {
            }
            throw th;
        }
    }
}
