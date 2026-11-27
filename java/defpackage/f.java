package defpackage;

import java.util.Objects;

/* loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static /* synthetic */ String a(CharSequence charSequence, CharSequence[] charSequenceArr) {
        Objects.requireNonNull(charSequence, "delimiter");
        StringBuilder sb = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb.append(charSequenceArr[0]);
            for (int i2 = 1; i2 < charSequenceArr.length; i2++) {
                sb.append(charSequence);
                sb.append(charSequenceArr[i2]);
            }
        }
        return sb.toString();
    }
}
