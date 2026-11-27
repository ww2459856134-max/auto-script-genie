package h.e.j;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.open.SocialConstants;

/* loaded from: classes.dex */
public final class g {
    final ClipData a;
    final int b;
    final int c;
    final Uri d;
    final Bundle e;

    g(f fVar) {
        ClipData clipData = fVar.a;
        h.e.i.h.d(clipData);
        this.a = clipData;
        int i2 = fVar.b;
        h.e.i.h.a(i2, 0, 3, SocialConstants.PARAM_SOURCE);
        this.b = i2;
        int i3 = fVar.c;
        h.e.i.h.c(i3, 1);
        this.c = i3;
        this.d = fVar.d;
        this.e = fVar.e;
    }

    static String a(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public ClipData b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public String toString() {
        return "ContentInfoCompat{clip=" + this.a + ", source=" + e(this.b) + ", flags=" + a(this.c) + ", linkUri=" + this.d + ", extras=" + this.e + "}";
    }
}
