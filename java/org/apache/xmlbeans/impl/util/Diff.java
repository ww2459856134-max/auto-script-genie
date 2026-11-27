package org.apache.xmlbeans.impl.util;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.List;

/* loaded from: classes.dex */
public class Diff {
    public static void readersAsText(Reader reader, String str, Reader reader2, String str2, List list) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(reader);
        LineNumberReader lineNumberReader2 = new LineNumberReader(reader2);
        String line = lineNumberReader.readLine();
        String line2 = lineNumberReader2.readLine();
        while (true) {
            if (line == null || line2 == null) {
                break;
            }
            if (!line.equals(line2)) {
                list.add("File \"" + str + "\" and file \"" + str2 + "\" differ at line " + lineNumberReader.getLineNumber() + ":\n" + line + "\n========\n" + line2);
                break;
            }
            line = lineNumberReader.readLine();
            line2 = lineNumberReader2.readLine();
        }
        if (line == null && line2 != null) {
            list.add("File \"" + str2 + "\" has extra lines at line " + lineNumberReader2.getLineNumber() + ":\n" + line2);
        }
        if (line == null || line2 != null) {
            return;
        }
        list.add("File \"" + str + "\" has extra lines at line " + lineNumberReader.getLineNumber() + ":\n" + line);
    }
}
