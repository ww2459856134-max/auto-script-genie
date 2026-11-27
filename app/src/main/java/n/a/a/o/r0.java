package n.a.a.o;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
class r0 extends Writer {
    private final Appendable c;
    private final Writer d;
    private String e;

    r0(Appendable appendable) {
        super(appendable);
        this.c = appendable;
        this.d = null;
    }

    void a(String str) {
        this.e = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        Object obj = this.c;
        if (obj == null) {
            obj = this.d;
        }
        if (obj instanceof Closeable) {
            ((Closeable) obj).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Object obj = this.c;
        if (obj == null) {
            obj = this.d;
        }
        if (obj instanceof Flushable) {
            ((Flushable) obj).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) throws IOException {
        String str = this.e;
        if (str != null) {
            Appendable appendable = this.c;
            if (appendable != null) {
                appendable.append(str);
            } else {
                Writer writer = this.d;
                if (writer != null) {
                    writer.write(str);
                }
            }
            this.e = null;
        }
        Appendable appendable2 = this.c;
        if (appendable2 != null) {
            appendable2.append(String.valueOf(cArr), i2, i3);
            return;
        }
        Writer writer2 = this.d;
        if (writer2 != null) {
            writer2.write(cArr, i2, i3);
        }
    }
}
