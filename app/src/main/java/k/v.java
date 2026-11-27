package k;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import k.a0.a.j0;
import k.a0.a.n3;
import k.b0.v.q3;

/* loaded from: classes.dex */
public abstract class v {
    protected v() {
    }

    public static k.b0.t g(File file, v vVar) throws IOException {
        return h(file, vVar, new w());
    }

    public static k.b0.t h(File file, v vVar, w wVar) throws IOException {
        return new q3(new FileOutputStream(file), vVar, true, wVar);
    }

    public static String k() {
        return "2.6.12";
    }

    public static v l(File file) throws k.a0.a.d, IOException {
        return m(file, new w());
    }

    public static v m(File file, w wVar) throws k.a0.a.d, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            j0 j0Var = new j0(fileInputStream, wVar);
            fileInputStream.close();
            n3 n3Var = new n3(j0Var, wVar);
            n3Var.o();
            return n3Var;
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        } catch (k.a0.a.d e2) {
            fileInputStream.close();
            throw e2;
        }
    }

    public abstract void f();

    public abstract int i();

    public abstract s j(int i2) throws IndexOutOfBoundsException;

    public abstract boolean n();

    protected abstract void o() throws k.a0.a.d;
}
