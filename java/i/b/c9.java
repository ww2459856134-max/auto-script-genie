package i.b;

import android.content.Context;
import org.opencv.core.Mat;

/* loaded from: classes.dex */
class c9 extends org.opencv.android.n {
    final /* synthetic */ i9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c9(i9 i9Var, Context context) {
        super(context);
        this.b = i9Var;
    }

    @Override // org.opencv.android.n, org.opencv.android.v
    public void b(int i2) {
        i9 i9Var;
        synchronized (this.b) {
            try {
                try {
                    if (i2 == 0) {
                        new Mat().h();
                        this.b.t = true;
                        com.frame.y0.n("OpenCV loaded successfully");
                    } else {
                        this.b.t = false;
                        super.b(i2);
                    }
                    i9Var = this.b;
                } catch (Throwable th) {
                    this.b.s = false;
                    throw th;
                }
            } catch (LinkageError | RuntimeException e) {
                this.b.t = false;
                com.frame.y0.j("OpenCV原生初始化失败：" + e);
                i9Var = this.b;
            }
            i9Var.s = false;
        }
    }
}
