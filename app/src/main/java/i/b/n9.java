package i.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.googlecode.tesseract.android.ResultIterator;
import com.googlecode.tesseract.android.TessBaseAPI;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n9 {
    private final TessBaseAPI a;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.a.a();
        } catch (RuntimeException unused) {
        }
        this.a.f();
    }

    public q8 e(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            throw new IllegalArgumentException("OCR图片为空");
        }
        this.a.g(bitmap);
        String strC = this.a.c();
        ArrayList arrayList = new ArrayList();
        ResultIterator resultIteratorB = this.a.b();
        if (resultIteratorB != null) {
            try {
                resultIteratorB.a();
                do {
                    String strF = resultIteratorB.f(3);
                    int[] iArrB = resultIteratorB.b(3);
                    if (!TextUtils.isEmpty(strF) && iArrB != null && iArrB.length == 4 && iArrB[2] > iArrB[0] && iArrB[3] > iArrB[1]) {
                        float fD = resultIteratorB.d(3) / 100.0f;
                        if (Float.isNaN(fD)) {
                            fD = 0.0f;
                        }
                        arrayList.add(new p8(strF, Math.max(0.0f, Math.min(1.0f, fD)), iArrB[0], iArrB[1], iArrB[2], iArrB[3]));
                    }
                } while (resultIteratorB.c(3));
            } finally {
                resultIteratorB.e();
            }
        }
        return new q8(strC, arrayList);
    }

    private n9(o9 o9Var) throws Exception {
        q9.f();
        if (!new File(q9.h(), o9Var.a).isFile()) {
            throw new IllegalStateException(o9Var.a + "文字识别库未找到");
        }
        TessBaseAPI tessBaseAPI = new TessBaseAPI();
        try {
            if (!tessBaseAPI.d(q9.g().getAbsolutePath(), o9Var.b, 1)) {
                throw new IllegalStateException("OCR初始化失败：" + o9Var.b);
            }
            if (o9Var.c) {
                tessBaseAPI.h("tessedit_char_whitelist", "0123456789.");
            }
            this.a = tessBaseAPI;
            q9.d();
        } catch (Error | RuntimeException e) {
            tessBaseAPI.f();
            throw e;
        }
    }
}
