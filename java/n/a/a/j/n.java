package n.a.a.j;

import java.net.URI;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class n {
    private final boolean a;
    private final String b;
    private final URI c;

    protected n(c cVar, URI uri, boolean z, String str, String str2) {
        Objects.requireNonNull(uri, "targetUri cannot be null");
        this.c = uri;
        this.b = str2;
        this.a = z;
    }

    public String a() {
        return this.b;
    }

    public URI b() {
        return this.c;
    }

    public boolean c() {
        return this.a;
    }
}
