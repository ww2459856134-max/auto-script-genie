package com.frame;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class r0 {
    public static File A(Uri uri, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        try {
            if (!file.isAbsolute()) {
                file = new File(v0.g().getFilesDir(), file.getPath());
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            inputStreamOpenInputStream = v0.g().getContentResolver().openInputStream(uri);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                inputStream = inputStreamOpenInputStream;
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
            while (true) {
                int i2 = inputStreamOpenInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
            fileOutputStream.flush();
            x0.c(inputStreamOpenInputStream);
        } catch (Exception e3) {
            inputStream = inputStreamOpenInputStream;
            e = e3;
            try {
                e.printStackTrace();
                x0.c(inputStream);
                x0.e(fileOutputStream);
                return file;
            } catch (Throwable th3) {
                th = th3;
                x0.c(inputStream);
                x0.e(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStreamOpenInputStream;
            th = th;
            x0.c(inputStream);
            x0.e(fileOutputStream);
            throw th;
        }
        x0.e(fileOutputStream);
        return file;
    }

    public static void a(File file, File file2) throws Throwable {
        FileChannel fileChannel;
        FileChannel channel = null;
        try {
            if (!file2.exists()) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
            }
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
                channel2.transferTo(0L, channel2.size(), channel);
                if (channel2 != null) {
                    channel2.close();
                }
                if (channel != null) {
                    channel.close();
                }
            } catch (Throwable th) {
                FileChannel fileChannel2 = channel;
                channel = channel2;
                th = th;
                fileChannel = fileChannel2;
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public static boolean b(String str, String str2) throws IOException {
        try {
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                Log.e("--Method--", "copyFolder: cannot create directory.");
                return false;
            }
            for (String str3 : new File(str).list()) {
                String str4 = File.separator;
                File file2 = str.endsWith(str4) ? new File(str + str3) : new File(str + str4 + str3);
                if (file2.isDirectory()) {
                    b(str + "/" + str3, str2 + "/" + str3);
                } else {
                    if (!file2.exists()) {
                        Log.e("--Method--", "copyFolder:  oldFile not exist.");
                        return false;
                    }
                    if (!file2.isFile()) {
                        Log.e("--Method--", "copyFolder:  oldFile not file.");
                        return false;
                    }
                    if (!file2.canRead()) {
                        Log.e("--Method--", "copyFolder:  oldFile cannot read.");
                        return false;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file2.getName());
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
            return true;
        } catch (Exception e) {
            k0.r(e);
            return false;
        }
    }

    public static File c(Uri uri, String str, String str2) throws IOException {
        String name;
        v0 v0VarG = v0.g();
        File file = new File(v0VarG.getFilesDir(), str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("mkdir failed: " + file.getAbsolutePath());
        }
        if (TextUtils.isEmpty(str2)) {
            name = "file_" + System.currentTimeMillis();
        } else {
            name = new File(str2).getName();
        }
        if (TextUtils.isEmpty(name) || ".".equals(name) || "..".equals(name)) {
            name = "file_" + System.currentTimeMillis();
        }
        File file2 = new File(file, name);
        InputStream inputStreamOpenInputStream = v0VarG.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            throw new IOException("openInputStream returned null");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
                while (true) {
                    int i2 = inputStreamOpenInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return file2;
            } finally {
            }
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void d(File file) {
        if (file.listFiles() == null) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                d(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    private static String e(Context context, Uri uri, String str, String[] strArr) {
        int columnIndexOrThrow;
        String path = uri.getPath();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data")) > -1) {
                    path = cursorQuery.getString(columnIndexOrThrow);
                }
            } catch (Exception e) {
                k0.r(e);
            }
            return path;
        } finally {
            x0.a(cursorQuery);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
    
        r1 = r4.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0083, code lost:
    
        if (128 > r1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0085, code lost:
    
        if (r1 > 191) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0087, code lost:
    
        r1 = r4.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008b, code lost:
    
        if (128 > r1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008d, code lost:
    
        if (r1 > 191) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052 A[Catch: all -> 0x0098, Exception -> 0x009b, LOOP:0: B:31:0x0052->B:88:0x0052, LOOP_START, TryCatch #4 {Exception -> 0x009b, all -> 0x0098, blocks: (B:5:0x000c, B:10:0x001d, B:13:0x0025, B:29:0x004d, B:31:0x0052, B:44:0x006e, B:52:0x007f, B:55:0x0087, B:17:0x002d, B:19:0x0031, B:22:0x0038, B:24:0x003e, B:26:0x0044), top: B:76:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0090 A[EDGE_INSN: B:78:0x0090->B:59:0x0090 BREAK  A[LOOP:0: B:31:0x0052->B:88:0x0052], EDGE_INSN: B:35:0x005c->B:59:0x0090 BREAK  A[LOOP:0: B:31:0x0052->B:88:0x0052], EDGE_INSN: B:39:0x0065->B:59:0x0090 BREAK  A[LOOP:0: B:31:0x0052->B:88:0x0052], EDGE_INSN: B:83:0x0090->B:59:0x0090 BREAK  A[LOOP:0: B:31:0x0052->B:88:0x0052], EDGE_INSN: B:84:0x0090->B:59:0x0090 BREAK  A[LOOP:0: B:31:0x0052->B:88:0x0052]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String f(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        boolean z;
        String str = "GBK";
        byte[] bArr = new byte[3];
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                z = false;
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedInputStream.mark(0);
            if (bufferedInputStream.read(bArr, 0, 3) == -1) {
                x0.c(inputStream);
                x0.c(bufferedInputStream);
                return "GBK";
            }
            String str2 = "UTF-8";
            if (bArr[0] == -1 && bArr[1] == -2) {
                str = "UTF-16LE";
            } else {
                if (bArr[0] != -2 || bArr[1] != -1) {
                    if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
                        str = "UTF-8";
                    }
                    bufferedInputStream.reset();
                    if (z) {
                        while (true) {
                            int i2 = bufferedInputStream.read();
                            if (i2 == -1 || i2 >= 240 || (128 <= i2 && i2 <= 191)) {
                                break;
                            }
                            if (192 <= i2 && i2 <= 223) {
                                int i3 = bufferedInputStream.read();
                                if (128 > i3 || i3 > 191) {
                                    break;
                                }
                            } else if (224 <= i2 && i2 <= 239) {
                                break;
                            }
                        }
                        str2 = str;
                    } else {
                        str2 = str;
                    }
                    x0.c(inputStream);
                    x0.c(bufferedInputStream);
                    return str2;
                }
                str = "UTF-16BE";
            }
            z = true;
            bufferedInputStream.reset();
            if (z) {
            }
            x0.c(inputStream);
            x0.c(bufferedInputStream);
            return str2;
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream2 = bufferedInputStream;
            k0.r(e);
            x0.c(inputStream);
            x0.c(bufferedInputStream2);
            return str;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            x0.c(inputStream);
            x0.c(bufferedInputStream2);
            throw th;
        }
    }

    public static String g(Context context, Uri uri) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            return Build.VERSION.SDK_INT >= 19 ? i(context, uri) : j(context, uri);
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String h(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (str == null) {
            return "*/*";
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            return mediaMetadataRetriever.extractMetadata(12);
        } catch (IllegalArgumentException | IllegalStateException | RuntimeException unused) {
            return "*/*";
        }
    }

    @SuppressLint({"NewApi"})
    private static String i(Context context, Uri uri) {
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            return "content".equals(uri.getScheme()) ? k(uri).getAbsolutePath() : "file".equals(uri.getScheme()) ? uri.getPath() : uri.getPath();
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        Uri uri2 = null;
        if (q(uri)) {
            String str = documentId.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0];
            String[] strArr = {documentId.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[1]};
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return e(context, uri2, "_id=?", strArr);
        }
        if (o(uri)) {
            return e(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
        }
        if (!p(uri)) {
            return null;
        }
        String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (!"primary".equalsIgnoreCase(strArrSplit[0])) {
            return null;
        }
        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
    }

    private static String j(Context context, Uri uri) {
        return e(context, uri, null, null);
    }

    public static File k(Uri uri) {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = v0.g().getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        InputStream inputStream = null;
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                } catch (Exception e) {
                    e = e;
                    inputStreamOpenInputStream = null;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    x0.c(inputStream);
                    x0.e(fileOutputStream);
                    throw th;
                }
                try {
                    File file = new File(v0.g().getExternalCacheDir().getAbsolutePath(), string);
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            n(inputStreamOpenInputStream, file);
                            x0.c(inputStreamOpenInputStream);
                            x0.e(fileOutputStream);
                            return file;
                        } catch (Exception e2) {
                            e = e2;
                            k0.r(e);
                            x0.c(inputStreamOpenInputStream);
                            x0.e(fileOutputStream);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpenInputStream;
                        x0.c(inputStream);
                        x0.e(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    inputStream = inputStreamOpenInputStream;
                    x0.c(inputStream);
                    x0.e(fileOutputStream);
                    throw th;
                }
            }
            return null;
        } finally {
            x0.a(cursorQuery);
        }
    }

    public static InputStream l(String str) throws FileNotFoundException {
        if (!str.contains("content://")) {
            return new FileInputStream(new File(str));
        }
        return v0.g().getContentResolver().openInputStream(Uri.parse(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:29:0x0033). Please report as a decompilation issue!!! */
    public static String m(String str) throws Throwable {
        FileInputStream fileInputStream;
        ?? IsEmpty = TextUtils.isEmpty(str);
        String strEncodeToString = null;
        strEncodeToString = null;
        strEncodeToString = null;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                inputStream = IsEmpty;
            }
        } catch (IOException e) {
            k0.r(e);
            IsEmpty = IsEmpty;
        }
        if (IsEmpty != 0) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                strEncodeToString = Base64.encodeToString(bArr, 16);
                fileInputStream.close();
                IsEmpty = fileInputStream;
            } catch (Exception e2) {
                e = e2;
                k0.r(e);
                IsEmpty = fileInputStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                    IsEmpty = fileInputStream;
                }
                return strEncodeToString;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    k0.r(e4);
                }
            }
            throw th;
        }
        return strEncodeToString;
    }

    public static void n(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            fileOutputStream2.close();
            inputStream.close();
            throw th;
        }
    }

    private static boolean o(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean p(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean q(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    static /* synthetic */ int r(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified > 0) {
            return 1;
        }
        return jLastModified == 0 ? 0 : -1;
    }

    public static File[] s(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.frame.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return r0.r((File) obj, (File) obj2);
                }
            });
        }
        return fileArrListFiles;
    }

    public static String t(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String u(String str) throws IOException {
        try {
            InputStream inputStreamOpen = v0.g().getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamOpen.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String v(String str) {
        try {
            FileReader fileReader = new FileReader(new File(str));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line + "\n");
                    } catch (Exception e) {
                        k0.r(e);
                    }
                } finally {
                    x0.b(bufferedReader);
                    x0.d(fileReader);
                }
            }
            return sb.toString();
        } catch (FileNotFoundException e2) {
            k0.r(e2);
            return "";
        }
    }

    public static String w(String str) throws IOException {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        File file = new File(str);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, f(new FileInputStream(file)));
            } catch (Exception e) {
                e = e;
                inputStreamReader = null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line + "\n");
                        } catch (Exception e2) {
                            k0.r(e2);
                        }
                    } finally {
                        x0.b(bufferedReader);
                        x0.d(inputStreamReader);
                        x0.c(fileInputStream);
                    }
                }
                return sb.toString();
            } catch (Exception e3) {
                e = e3;
                x0.b(null);
                x0.d(inputStreamReader);
                x0.c(fileInputStream);
                k0.r(e);
                return "";
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            inputStreamReader = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
    public static String x(String str) throws Throwable {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Exception e;
        String string;
        InputStream inputStream;
        try {
            try {
                String strF = f(l(str));
                str = l(str);
                try {
                    inputStreamReader = new InputStreamReader((InputStream) str, strF);
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                            }
                            string = sb.toString();
                            inputStream = str;
                        } catch (Exception e2) {
                            e = e2;
                            k0.r(e);
                            string = "";
                            inputStream = str;
                            x0.b(bufferedReader2);
                            x0.d(inputStreamReader);
                            x0.c(inputStream);
                            return string;
                        }
                    } catch (Exception e3) {
                        bufferedReader2 = null;
                        e = e3;
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                        x0.b(bufferedReader);
                        x0.d(inputStreamReader);
                        x0.c(str);
                        throw th;
                    }
                } catch (Exception e4) {
                    inputStreamReader = null;
                    e = e4;
                    bufferedReader2 = null;
                } catch (Throwable th3) {
                    inputStreamReader = null;
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e5) {
            bufferedReader2 = null;
            inputStreamReader = null;
            e = e5;
            str = 0;
        } catch (Throwable th5) {
            bufferedReader = null;
            inputStreamReader = null;
            th = th5;
            str = 0;
        }
        x0.b(bufferedReader2);
        x0.d(inputStreamReader);
        x0.c(inputStream);
        return string;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:5|(13:7|57|8|(1:10)(1:11)|51|23|(1:25)|26|27|(1:41)|49|29|60)(2:(1:18)(1:19)|20))(1:21)|51|23|(0)|26|27|(0)|49|29|60) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        r6 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[Catch: IOException -> 0x0084, all -> 0x009a, TryCatch #5 {IOException -> 0x0084, blocks: (B:23:0x0064, B:25:0x006a, B:26:0x0072), top: B:51:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void y(String str, String str2, boolean z) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        OutputStream outputStream;
        OutputStream fileOutputStream;
        try {
        } catch (IOException e) {
            e = e;
            parcelFileDescriptorOpenFileDescriptor = null;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            parcelFileDescriptorOpenFileDescriptor = null;
            outputStream = null;
        }
        try {
            try {
                if (str.contains("content://")) {
                    Uri uri = Uri.parse(str);
                    if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        parcelFileDescriptorOpenFileDescriptor = v0.g().getContentResolver().openFileDescriptor(uri, "rw");
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            FileChannel channel = fileOutputStream2.getChannel();
                            if (z) {
                                channel.position(channel.size());
                                outputStream = fileOutputStream2;
                            } else {
                                channel.truncate(0L);
                                outputStream = fileOutputStream2;
                            }
                            outputStreamWriter = Build.VERSION.SDK_INT >= 19 ? new OutputStreamWriter(outputStream, StandardCharsets.UTF_8) : null;
                            outputStreamWriter.write(str2);
                            outputStreamWriter.flush();
                            x0.f(outputStreamWriter);
                            x0.e(outputStream);
                            if (parcelFileDescriptorOpenFileDescriptor == null) {
                                return;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            outputStream = null;
                            k0.r(e);
                            x0.f(outputStreamWriter);
                            x0.e(outputStream);
                            if (parcelFileDescriptorOpenFileDescriptor == null) {
                            }
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                            x0.f(outputStreamWriter);
                            x0.e(outputStream);
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                            }
                            throw th;
                        }
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return;
                    }
                    fileOutputStream = v0.g().getContentResolver().openOutputStream(uri, z ? "wa" : "wt");
                } else {
                    fileOutputStream = new FileOutputStream(str, z);
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                return;
            } catch (Exception unused) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
            }
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            x0.f(outputStreamWriter);
            x0.e(outputStream);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            x0.f(outputStreamWriter);
            x0.e(outputStream);
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        parcelFileDescriptorOpenFileDescriptor = null;
        outputStream = fileOutputStream;
    }

    public static void z(String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.flush();
            x0.e(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            k0.r(e);
            x0.e(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            x0.e(fileOutputStream2);
            throw th;
        }
    }
}
