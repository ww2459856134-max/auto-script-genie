package n.a.a.k.c;

import i.b.ha.a.b.d.c.i2;
import i.b.ha.a.b.d.c.o1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* loaded from: classes.dex */
public class d implements c {
    private i2 c;

    public d(i2 i2Var) {
        this.c = i2Var;
    }

    @Override // n.a.a.k.c.c
    public Enumeration<? extends o1> A() {
        i2 i2Var = this.c;
        if (i2Var != null) {
            return i2Var.A();
        }
        throw new IllegalStateException("Zip File is closed");
    }

    @Override // n.a.a.k.c.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        i2 i2Var = this.c;
        if (i2Var != null) {
            i2Var.close();
        }
        this.c = null;
    }

    @Override // n.a.a.k.c.c
    public o1 k(String str) {
        String strReplace = str.replace('\\', '/');
        o1 o1VarK = this.c.k(strReplace);
        if (o1VarK != null) {
            return o1VarK;
        }
        Enumeration<o1> enumerationA = this.c.A();
        while (enumerationA.hasMoreElements()) {
            o1 o1VarNextElement = enumerationA.nextElement();
            if (strReplace.equalsIgnoreCase(o1VarNextElement.getName().replace('\\', '/'))) {
                return o1VarNextElement;
            }
        }
        return null;
    }

    @Override // n.a.a.k.c.c
    public boolean l() {
        return this.c == null;
    }

    @Override // n.a.a.k.c.c
    public InputStream v(o1 o1Var) throws IOException {
        i2 i2Var = this.c;
        if (i2Var != null) {
            return i2Var.v(o1Var);
        }
        throw new IllegalStateException("Zip File is closed");
    }
}
