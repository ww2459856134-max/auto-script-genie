package n.a.a.k.b.z;

import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import n.a.a.k.b.x;
import n.a.a.o.h1;

/* loaded from: classes.dex */
public abstract class q {
    public static void a(o1 o1Var) {
        if (h1.a()) {
            o1Var.setTime(0L);
        }
    }

    public static o1 b(x xVar) {
        n.a.a.k.b.q qVarG = xVar.L("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").g(0);
        if (qVarG == null) {
            return null;
        }
        o1 o1Var = new o1(qVarG.e().getPath());
        a(o1Var);
        return o1Var;
    }

    public static String c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("zipItemName cannot be null");
        }
        if (str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    public static String d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName cannot be null");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        return str;
    }

    public static URI e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static n.a.a.k.c.f f(File file) throws n.a.a.k.a.c, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File is a directory");
        }
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            i(inputStreamNewInputStream);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return new n.a.a.k.c.f(file);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static n.a.a.k.c.b g(InputStream inputStream) throws IOException {
        return h(inputStream, true);
    }

    public static n.a.a.k.c.b h(InputStream inputStream, boolean z) throws IOException {
        InputStream inputStreamB = n.a.a.l.c.k.b(inputStream);
        i(inputStreamB);
        if (!z) {
            inputStreamB = new j(inputStreamB);
        }
        return new n.a.a.k.c.b(new q1(inputStreamB, StandardCharsets.UTF_8.name(), false, true));
    }

    private static void i(InputStream inputStream) throws n.a.a.k.a.c, IOException {
        int i2 = p.a[n.a.a.l.c.k.c(n.a.a.l.c.k.b(inputStream)).ordinal()];
        if (i2 == 1) {
            throw new n.a.a.k.a.e("The supplied data appears to be in the OLE2 Format. You are calling the part of POI that deals with OOXML (Office Open XML) Documents. You need to call a different part of POI to process this data (eg HSSF instead of XSSF)");
        }
        if (i2 == 2) {
            throw new n.a.a.k.a.c("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
        }
    }
}
