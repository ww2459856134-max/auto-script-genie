package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class IOUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Path tmpdir = Paths.get(System.getProperty("java.io.tmpdir"), new String[0]);

    public static void copyCompletely(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            if ((outputStream instanceof FileOutputStream) && (inputStream instanceof FileInputStream)) {
                try {
                    FileChannel channel = ((FileOutputStream) outputStream).getChannel();
                    FileChannel channel2 = ((FileInputStream) inputStream).getChannel();
                    channel2.transferTo(0L, 2147483647L, channel);
                    channel2.close();
                    channel.close();
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        outputStream.close();
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (Exception unused3) {
                }
            }
            byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    try {
                        break;
                    } catch (IOException unused4) {
                    }
                } else {
                    outputStream.write(bArr, 0, i2);
                }
            }
            inputStream.close();
            try {
                outputStream.close();
            } catch (IOException unused5) {
            }
        } finally {
        }
    }

    public static File createDir(File file, String str) {
        if (str != null) {
            file = new File(file, str);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    public static Path getTempDir() {
        return tmpdir;
    }

    private static InputStream urlToStream(URI uri) throws IOException {
        try {
            File file = new File(uri);
            if (file.exists()) {
                return Files.newInputStream(file.toPath(), new OpenOption[0]);
            }
        } catch (Exception unused) {
        }
        return uri.toURL().openStream();
    }

    public static void copyCompletely(Reader reader, Writer writer) throws IOException {
        try {
            char[] cArr = new char[XMLEvent.ENTITY_REFERENCE];
            while (true) {
                int i2 = reader.read(cArr);
                if (i2 < 0) {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                } else {
                    writer.write(cArr, 0, i2);
                }
            }
            reader.close();
            try {
                writer.close();
            } catch (IOException unused2) {
            }
        } finally {
        }
    }

    public static void copyCompletely(URI uri, URI uri2) throws IOException {
        File file = new File(uri2);
        file.getParentFile().mkdirs();
        try {
            InputStream inputStreamUrlToStream = urlToStream(uri);
            try {
                OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
                try {
                    copyCompletely(inputStreamUrlToStream, outputStreamNewOutputStream);
                    if (outputStreamNewOutputStream != null) {
                        outputStreamNewOutputStream.close();
                    }
                    if (inputStreamUrlToStream != null) {
                        inputStreamUrlToStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (IllegalArgumentException unused) {
            throw new IOException("Cannot copy to " + uri2);
        }
    }
}
