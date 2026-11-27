package i.e.a.l;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public abstract class k {
    public static String a(File file) throws IOException {
        return b(file).toExternalForm();
    }

    public static URL b(File file) throws IOException {
        String absolutePath = file.getAbsolutePath();
        char c = File.separatorChar;
        if (c != '/') {
            absolutePath = absolutePath.replace(c, '/');
        }
        if (absolutePath.length() > 0 && absolutePath.charAt(0) != '/') {
            absolutePath = "/" + absolutePath;
        }
        return new URL("file", "", absolutePath);
    }

    public static InputStream c(URL url) throws IOException {
        String host;
        return ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) ? new FileInputStream(url.getPath()) : url.openStream();
    }

    public static OutputStream d(URL url) throws IOException {
        String host;
        return ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) ? new FileOutputStream(url.getPath()) : url.openConnection().getOutputStream();
    }

    private static void e(MalformedURLException malformedURLException, String str) throws IOException {
        IOException iOException = new IOException("[resolving systemId '" + str + "']: " + malformedURLException.toString());
        iOException.initCause(malformedURLException);
        throw iOException;
    }

    public static URL f(String str) throws IOException {
        try {
            int iIndexOf = str.indexOf(58, 0);
            return (iIndexOf < 3 || iIndexOf > 8) ? b(new File(str)) : new URL(str);
        } catch (MalformedURLException e) {
            e(e, str);
            throw null;
        }
    }

    public static String g(URL url) {
        return url.toExternalForm();
    }
}
