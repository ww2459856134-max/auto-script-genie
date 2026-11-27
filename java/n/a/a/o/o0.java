package n.a.a.o;

import java.util.Iterator;
import java.util.PrimitiveIterator;

/* loaded from: classes.dex */
public abstract class o0 {
    public static Iterator<String> a(String str) {
        return new n0(b(str));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.PrimitiveIterator$OfInt] */
    public static PrimitiveIterator.OfInt b(String str) {
        return str.codePoints().iterator();
    }
}
