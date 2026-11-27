package n.b.a.l;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;

/* loaded from: classes2.dex */
public abstract class a implements Source {
    public abstract InputStream a() throws IOException;

    public abstract Reader b() throws IOException;

    public abstract String c();

    public abstract String d();

    @Override // javax.xml.transform.Source
    public abstract String getSystemId();
}
