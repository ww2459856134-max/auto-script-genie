package i.b;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
final class o9 {
    private final String a;
    private final String b;
    private final boolean c;
    private final String d;

    private o9(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str + '\n' + str2 + '\n' + z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o9 f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "chi_sim";
        }
        if ("number".equals(str2) || "number.traineddata".equals(str)) {
            return new o9("eng.traineddata", "eng", true);
        }
        if (TextUtils.isEmpty(str)) {
            str = str2 + ".traineddata";
        }
        if (new File(str).getName().equals(str)) {
            return new o9(str, str2, false);
        }
        throw new IllegalArgumentException("OCR识别库只能填写文件名：" + str);
    }
}
