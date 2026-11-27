package n.a.a.n.d;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface o0 extends Iterable<e> {

    public enum a {
        RETURN_NULL_AND_BLANK,
        RETURN_BLANK_AS_NULL,
        CREATE_NULL_AS_BLANK
    }

    p0 getSheet();

    e i(int i2);

    @Override // java.lang.Iterable
    default Iterator<e> iterator() {
        return s();
    }

    short n();

    int q();

    Iterator<e> s();

    e x(int i2);
}
