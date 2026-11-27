package n.a.a.l.c;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import n.a.a.o.w0;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Iterable<java.nio.ByteBuffer>] */
/* loaded from: classes.dex */
public final class o implements Object {
    private n.a.a.l.e.d c;
    private q d;
    private s e;
    private int f;

    public o(String str, q qVar, InputStream inputStream) throws IOException, ArrayIndexOutOfBoundsException {
        this.d = qVar;
        n.a.a.l.e.d dVar = new n.a.a.l.e.d(str, g(inputStream));
        this.c = dVar;
        dVar.z(this.e.p());
        this.c.E(this);
    }

    private int g(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 4097);
        bufferedInputStream.mark(XMLEvent.CHANGE_PREFIX_MAPPING);
        if (w0.n(bufferedInputStream, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
            this.e = new s(this.d.z());
            this.f = this.d.z().d();
        } else {
            q qVar = this.d;
            this.e = new s(qVar);
            this.f = qVar.d();
        }
        bufferedInputStream.reset();
        OutputStream outputStreamL = this.e.l();
        try {
            long jH = w0.h(bufferedInputStream, outputStreamL);
            int i2 = this.f;
            int i3 = (int) (jH % i2);
            if (i3 != 0 && i3 != i2) {
                byte[] bArrL = w0.l(i2 - i3, q.y());
                Arrays.fill(bArrL, (byte) -1);
                outputStreamL.write(bArrL);
            }
            if (outputStreamL != null) {
                outputStreamL.close();
            }
            return Math.toIntExact(jH);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamL != null) {
                    try {
                        outputStreamL.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    Iterator<ByteBuffer> a() {
        return (e() > 0 ? this.e : Collections.emptyList()).iterator();
    }

    n.a.a.l.e.d b() {
        return this.c;
    }

    public int e() {
        return this.c.e();
    }

    public Iterator<ByteBuffer> iterator() {
        return a();
    }
}
