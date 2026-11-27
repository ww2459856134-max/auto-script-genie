package org.apache.xmlbeans.impl.repackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* loaded from: classes.dex */
public class EditBuildScript {
    static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int i2 = reader.read(cArr, 0, 16384);
            if (i2 < 0) {
                return;
            } else {
                writer.write(cArr, 0, i2);
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        strArr[0] = strArr[0].replace('/', File.separatorChar);
        File file = new File(strArr[0]);
        StringBuffer file2 = readFile(file);
        String str = "<property name=\"" + strArr[1] + "\" value=\"";
        int iIndexOf = file2.indexOf(str);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("Can't find token: " + str);
        }
        int length = str.length() + iIndexOf;
        while (file2.charAt(length) != '\"') {
            length++;
        }
        file2.replace(iIndexOf + str.length(), length, strArr[2]);
        writeFile(file, file2);
    }

    static StringBuffer readFile(File file) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.ISO_8859_1);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                copy(bufferedReaderNewBufferedReader, stringWriter);
                StringBuffer buffer = stringWriter.getBuffer();
                stringWriter.close();
                if (bufferedReaderNewBufferedReader != null) {
                    bufferedReaderNewBufferedReader.close();
                }
                return buffer;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    static void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(file.toPath(), StandardCharsets.ISO_8859_1, new OpenOption[0]);
        try {
            StringReader stringReader = new StringReader(stringBuffer.toString());
            try {
                copy(stringReader, bufferedWriterNewBufferedWriter);
                stringReader.close();
                if (bufferedWriterNewBufferedWriter != null) {
                    bufferedWriterNewBufferedWriter.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (bufferedWriterNewBufferedWriter != null) {
                    try {
                        bufferedWriterNewBufferedWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
