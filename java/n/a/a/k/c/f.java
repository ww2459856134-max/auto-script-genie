package n.a.a.k.c;

import com.auto.exceldeps.log4j.Logger;
import i.b.ha.a.b.d.c.i2;
import i.b.ha.a.b.d.c.o1;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import n.a.a.k.b.z.g;

/* loaded from: classes.dex */
public class f extends i2 {
    private static final Logger W = n.a.a.i.b.a(f.class);
    static double Z = 0.01d;
    static long a0 = 4294967295L;
    static long b0 = 1000;
    static long c0 = 102400;

    public f(File file) throws IOException {
        super(file);
        file.getAbsolutePath();
        N();
    }

    public static long K() {
        return a0;
    }

    public static long L() {
        return b0;
    }

    public static void M(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Max entry size must be greater than or equal to zero");
        }
        if (j2 > 4294967295L) {
            W.warn("setting max entry size greater than 4Gb can be risky; set to {} bytes", Long.valueOf(j2));
        }
        a0 = j2;
    }

    private void N() throws IOException {
        Enumeration<o1> enumerationA = A();
        HashSet hashSet = new HashSet();
        while (enumerationA.hasMoreElements()) {
            o1 o1VarNextElement = enumerationA.nextElement();
            String name = o1VarNextElement.getName();
            if (name == null || name.isEmpty()) {
                throw new g("Input file contains an entry with an empty name");
            }
            String lowerCase = name.toLowerCase(Locale.ROOT);
            if (hashSet.contains(lowerCase)) {
                throw new g("Input file contains more than 1 entry with the name " + o1VarNextElement.getName());
            }
            hashSet.add(lowerCase);
        }
    }

    @Override // i.b.ha.a.b.d.c.i2
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public b v(o1 o1Var) throws IOException {
        b bVar = new b(super.v(o1Var));
        bVar.d(o1Var);
        return bVar;
    }
}
