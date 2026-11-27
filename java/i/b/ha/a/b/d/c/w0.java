package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class w0 extends ZipException {
    public w0(v0 v0Var) {
        super("Unsupported feature " + v0Var + " used in archive.");
    }

    public w0(v0 v0Var, o1 o1Var) {
        super("Unsupported feature " + v0Var + " used in entry " + o1Var.getName());
    }

    public w0(k2 k2Var, o1 o1Var) {
        super("Unsupported compression method " + o1Var.getMethod() + " (" + k2Var.name() + ") used in entry " + o1Var.getName());
        v0 v0Var = v0.e;
    }
}
