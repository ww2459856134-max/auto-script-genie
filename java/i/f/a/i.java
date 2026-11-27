package i.f.a;

import com.auto.exceldeps.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class i {
    private final int a;
    private final int b;

    protected i(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i2, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public i e() {
        return new h(this);
    }

    public boolean f() {
        return false;
    }

    public i g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        byte[] bArrC = new byte[i2];
        StringBuilder sb = new StringBuilder(this.b * (i2 + 1));
        for (int i3 = 0; i3 < this.b; i3++) {
            bArrC = c(i3, bArrC);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArrC[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? NameUtil.PERIOD : Chars.SPACE);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
