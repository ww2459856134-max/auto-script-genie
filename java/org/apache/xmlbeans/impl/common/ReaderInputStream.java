package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* loaded from: classes.dex */
public class ReaderInputStream extends PushedInputStream {
    public static final int defaultBufferSize = 2048;
    private final char[] buf;
    private final Reader reader;
    private final Writer writer;

    public ReaderInputStream(Reader reader, String str) throws UnsupportedEncodingException {
        this(reader, str, 2048);
    }

    @Override // org.apache.xmlbeans.impl.common.PushedInputStream
    public void fill(int i2) throws IOException {
        do {
            int i3 = this.reader.read(this.buf);
            if (i3 < 0) {
                return;
            }
            this.writer.write(this.buf, 0, i3);
            this.writer.flush();
        } while (available() <= 0);
    }

    public ReaderInputStream(Reader reader, String str, int i2) throws UnsupportedEncodingException {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.reader = reader;
        this.writer = new OutputStreamWriter(getOutputStream(), str);
        this.buf = new char[i2];
    }
}
