package n.a.a.l.c;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes.dex */
public class p {
    private final String[] a;
    private int b;

    public p() {
        this.a = new String[0];
    }

    static /* synthetic */ boolean a(String str) {
        return str == null || str.isEmpty();
    }

    static /* synthetic */ String[] b(int i2) {
        return new String[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != p.class) {
            return false;
        }
        return Arrays.equals(this.a, ((p) obj).a);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.a);
        this.b = iHashCode;
        return iHashCode;
    }

    public String toString() {
        return File.separatorChar + defpackage.f.a(String.valueOf(File.separatorChar), this.a);
    }

    public p(p pVar, String[] strArr) throws IllegalArgumentException {
        String[] strArr2 = pVar == null ? new String[0] : pVar.a;
        strArr = strArr == null ? new String[0] : strArr;
        if (!Stream.of((Object[]) strArr).anyMatch(pVar != null ? new Predicate() { // from class: n.a.a.l.c.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.isNull((String) obj);
            }
        } : new Predicate() { // from class: n.a.a.l.c.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return p.a((String) obj);
            }
        })) {
            this.a = (String[]) Stream.concat(Stream.of((Object[]) strArr2), Stream.of((Object[]) strArr)).toArray(new IntFunction() { // from class: n.a.a.l.c.a
                @Override // java.util.function.IntFunction
                public final Object apply(int i2) {
                    return p.b(i2);
                }
            });
            return;
        }
        throw new IllegalArgumentException("components cannot contain null or empty strings");
    }
}
