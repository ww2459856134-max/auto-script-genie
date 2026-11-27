package i.b.ha.a.c.g;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.OpenOption;

/* loaded from: classes.dex */
public class c extends d<InputStream, c> {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.ha.a.c.g.d
    public byte[] d() throws IOException {
        return i.b.ha.a.c.e.s((InputStream) this.a);
    }

    @Override // i.b.ha.a.c.g.d
    public InputStream e(OpenOption... openOptionArr) {
        return get();
    }
}
