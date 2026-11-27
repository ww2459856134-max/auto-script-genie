package o.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes3.dex */
public abstract class b {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        b(inputStream, outputStream, true);
    }

    public static void b(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
        while (inputStream.available() > 0) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 > 0) {
                    outputStream.write(bArr, 0, i2);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        if (z) {
            inputStream.close();
            outputStream.close();
        }
    }
}
