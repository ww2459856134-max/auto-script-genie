package org.apache.xmlbeans.impl.repackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class Repackage {
    private List<List<String>> _fromPackages;
    private List<String> _moveAlongFiles;
    private Map<String, String> _movedDirs;
    private Pattern _packagePattern;
    private final Repackager _repackager;
    private int _skippedFiles;
    private final File _sourceBase;
    private final File _targetBase;
    private List<List<String>> _toPackages;

    private Repackage(String[] strArr) {
        int i2;
        int i3 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (i3 < strArr.length) {
            if (strArr[i3].equals("-repackage") && (i2 = i3 + 1) < strArr.length) {
                str = strArr[i2];
            } else if (strArr[i3].equals("-f") && (i2 = i3 + 1) < strArr.length) {
                str2 = strArr[i2];
            } else if (!strArr[i3].equals("-t") || (i2 = i3 + 1) >= strArr.length) {
                z = true;
                i3++;
            } else {
                str3 = strArr[i2];
            }
            i3 = i2;
            i3++;
        }
        if (!z && str != null) {
            if (!((str2 == null) ^ (str3 == null))) {
                this._repackager = new Repackager(str);
                if (str2 == null || str3 == null) {
                    this._targetBase = null;
                    this._sourceBase = null;
                    return;
                } else {
                    this._sourceBase = new File(str2);
                    this._targetBase = new File(str3);
                    return;
                }
            }
        }
        throw new RuntimeException("Usage: repackage -repackage [spec] [ -f [sourcedir] -t [targetdir] ]");
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 16384);
            if (i2 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        file2.getParentFile().mkdirs();
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(file2.toPath(), new OpenOption[0]);
            try {
                copy(inputStreamNewInputStream, outputStreamNewOutputStream);
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        new Repackage(strArr).repackage();
    }

    public void fillFiles(List<File> list, File file) {
        if (!file.isDirectory()) {
            list.add(file);
            return;
        }
        if (file.getName().equals("build") || file.getName().equals("CVS")) {
            return;
        }
        String[] list2 = file.list();
        if (list2 == null) {
            throw new RuntimeException("Directory can't be accessed: " + file.toString());
        }
        for (String str : list2) {
            fillFiles(list, new File(file, str));
        }
    }

    public void finishMovingFiles() throws IOException {
        for (String str : this._moveAlongFiles) {
            String str2 = this._movedDirs.get(Repackager.dirForPath(str));
            String string = str2 == null ? str : new File(str2, new File(str).getName()).toString();
            if (str.endsWith(".html")) {
                repackageNonJavaFile(str, string);
            } else {
                justMoveNonJavaFile(str, string);
            }
        }
    }

    public void justMoveNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            copyFile(file, file2);
        }
    }

    public void moveAlongWithJavaFiles(String str) {
        this._moveAlongFiles.add(str);
    }

    StringBuffer readFile(File file) throws IOException {
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

    StringBuffer readInputStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                copy(inputStreamReader, stringWriter);
                StringBuffer buffer = stringWriter.getBuffer();
                stringWriter.close();
                inputStreamReader.close();
                return buffer;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void recursiveDelete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list == null) {
                    throw new RuntimeException("Directory can't be accessed: " + file.toString());
                }
                for (String str : list) {
                    recursiveDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }

    public void repackage() throws Exception {
        if (this._sourceBase == null || this._targetBase == null) {
            System.out.println(this._repackager.repackage(readInputStream(System.in)).toString());
            return;
        }
        this._fromPackages = this._repackager.getFromPackages();
        this._toPackages = this._repackager.getToPackages();
        this._packagePattern = Pattern.compile("^\\s*package\\s+((?:\\w|\\.)*)\\s*;", 8);
        this._moveAlongFiles = new ArrayList();
        this._movedDirs = new HashMap();
        this._targetBase.mkdirs();
        ArrayList arrayList = new ArrayList();
        fillFiles(arrayList, this._sourceBase);
        System.out.println("Repackaging " + arrayList.size() + " files ...");
        int length = this._sourceBase.getCanonicalPath().length();
        Iterator<File> it = arrayList.iterator();
        while (it.hasNext()) {
            repackageFile(it.next().getCanonicalPath().substring(length + 1));
        }
        finishMovingFiles();
        if (this._skippedFiles > 0) {
            System.out.println("Skipped " + this._skippedFiles + " unmodified files.");
        }
    }

    public void repackageFile(String str) throws IOException {
        if (str.endsWith(".java")) {
            repackageJavaFile(str);
            return;
        }
        if (str.endsWith(".xsdconfig") || str.endsWith(".xml") || str.endsWith(".g")) {
            repackageNonJavaFile(str);
            return;
        }
        if (str.startsWith("bin" + File.separatorChar)) {
            repackageNonJavaFile(str);
        } else {
            moveAlongWithJavaFiles(str);
        }
    }

    public void repackageJavaFile(String str) throws IOException {
        List<String> list;
        List<String> list2;
        String str2 = str;
        File file = new File(this._sourceBase, str2);
        StringBuffer file2 = readFile(file);
        Matcher matcher = this._packagePattern.matcher(file2);
        int i2 = 1;
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            if (matcher.find()) {
                throw new RuntimeException("Two package specifications found: " + str2);
            }
            List<String> listSplitPath = Repackager.splitPath(str2, File.separatorChar);
            String strDirForPath = Repackager.dirForPath(str);
            while (true) {
                boolean z = false;
                for (int i3 = i2; i3 < listSplitPath.size(); i3++) {
                    int i4 = i3 - 1;
                    String str3 = listSplitPath.get(i4);
                    String str4 = listSplitPath.get(i3);
                    if (str3.indexOf(58) < str4.indexOf(58)) {
                        listSplitPath.set(i4, str4);
                        listSplitPath.set(i3, str3);
                        z = true;
                    }
                }
                if (!z) {
                    break;
                } else {
                    i2 = 1;
                }
            }
            List<String> listSplitPath2 = Repackager.splitPath(strGroup, NameUtil.PERIOD);
            int size = listSplitPath.size() - 2;
            if (size < 0 || listSplitPath.size() - 1 < listSplitPath2.size()) {
                throw new RuntimeException("Package spec differs from file path: " + str2);
            }
            for (int size2 = listSplitPath2.size() - 1; size2 >= 0; size2--) {
                if (!listSplitPath2.get(size2).equals(listSplitPath.get(size))) {
                    throw new RuntimeException("Package spec differs from file path: " + str2);
                }
                size--;
            }
            int i5 = 0;
            loop3: while (true) {
                list = null;
                if (i5 >= this._fromPackages.size()) {
                    list2 = null;
                    break;
                }
                List<String> list3 = this._fromPackages.get(i5);
                if (list3.size() <= listSplitPath2.size()) {
                    for (int i6 = 0; i6 < list3.size(); i6++) {
                        if (!list3.get(i6).equals(listSplitPath2.get(i6))) {
                            break;
                        }
                    }
                    list = this._toPackages.get(i5);
                    list2 = list3;
                    break loop3;
                }
                i5++;
            }
            if (list != null) {
                String str5 = "";
                String str6 = "";
                for (int i7 = 0; i7 < list.size(); i7++) {
                    if (i7 > 0) {
                        str5 = str5 + ".";
                        str6 = str6 + File.separatorChar;
                    }
                    str5 = str5 + list.get(i7);
                    str6 = str6 + list.get(i7);
                }
                for (int size3 = (listSplitPath.size() - listSplitPath2.size()) - 2; size3 >= 0; size3--) {
                    str6 = listSplitPath.get(size3) + File.separatorChar + str6;
                }
                for (int size4 = list2.size(); size4 < listSplitPath2.size(); size4++) {
                    str6 = str6 + File.separatorChar + listSplitPath2.get(size4);
                    str5 = str5 + NameUtil.PERIOD + listSplitPath2.get(size4);
                }
                String str7 = str6 + File.separatorChar + listSplitPath.get(listSplitPath.size() - 1);
                file2.replace(iStart, iEnd, str5);
                String strDirForPath2 = Repackager.dirForPath(str7);
                if (!strDirForPath.equals(strDirForPath2)) {
                    this._movedDirs.put(strDirForPath, strDirForPath2);
                }
                str2 = str7;
            }
        }
        if (file.lastModified() < new File(this._targetBase, str2).lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(new File(this._targetBase, str2), this._repackager.repackage(file2));
        }
    }

    public void repackageNonJavaFile(String str) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        file.getParentFile().mkdirs();
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

    public static void copy(Reader reader, Writer writer) throws IOException {
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

    public void repackageNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }
}
