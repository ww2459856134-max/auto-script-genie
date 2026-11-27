package i.b.ha.a.c.g;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.OpenOption;

/* loaded from: classes.dex */
public class b extends d<byte[], b> {
    public b(byte[] bArr) {
        super(bArr);
    }

    @Override // i.b.ha.a.c.g.d
    public byte[] d() {
        return get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.ha.a.c.g.d
    public InputStream e(OpenOption... openOptionArr) throws IOException {
        return new ByteArrayInputStream((byte[]) this.a);
    }
}
