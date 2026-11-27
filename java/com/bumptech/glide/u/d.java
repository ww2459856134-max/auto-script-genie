package com.bumptech.glide.u;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class d {
    private final String a;
    private final long[] b;
    File[] c;
    File[] d;
    private boolean e;
    private c f;
    private long g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ f f676h;

    /* synthetic */ d(f fVar, String str, a aVar) {
        this(fVar, str);
    }

    private IOException m(String[] strArr) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String[] strArr) throws IOException {
        if (strArr.length != this.f676h.f678i) {
            m(strArr);
            throw null;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                this.b[i2] = Long.parseLong(strArr[i2]);
            } catch (NumberFormatException unused) {
                m(strArr);
                throw null;
            }
        }
    }

    public File j(int i2) {
        return this.c[i2];
    }

    public File k(int i2) {
        return this.d[i2];
    }

    public String l() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (long j2 : this.b) {
            sb.append(Chars.SPACE);
            sb.append(j2);
        }
        return sb.toString();
    }

    private d(f fVar, String str) {
        this.f676h = fVar;
        this.a = str;
        this.b = new long[fVar.f678i];
        this.c = new File[fVar.f678i];
        this.d = new File[fVar.f678i];
        StringBuilder sb = new StringBuilder(str);
        sb.append(NameUtil.PERIOD);
        int length = sb.length();
        for (int i2 = 0; i2 < fVar.f678i; i2++) {
            sb.append(i2);
            this.c[i2] = new File(fVar.c, sb.toString());
            sb.append(".tmp");
            this.d[i2] = new File(fVar.c, sb.toString());
            sb.setLength(length);
        }
    }
}
