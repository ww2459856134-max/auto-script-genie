package i.e.a;

import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class c extends RuntimeException {
    private c(XMLStreamException xMLStreamException) {
        super(xMLStreamException);
    }

    public static c a(XMLStreamException xMLStreamException) {
        return new c(xMLStreamException);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getCause().getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getCause().getMessage();
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        return getCause().getStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        getCause().printStackTrace();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getCause().toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        getCause().printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        getCause().printStackTrace(printWriter);
    }
}
