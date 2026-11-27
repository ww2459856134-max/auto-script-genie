package i.b;

import android.graphics.Bitmap;
import android.system.ErrnoException;
import android.system.Os;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class q9 {
    private static final Object b = new Object();
    private static int c;
    private final Map<String, n9> a = new HashMap();

    static /* synthetic */ int d() {
        int i2 = c;
        c = i2 + 1;
        return i2;
    }

    private static void e(String str, File file) throws IOException {
        File fileCreateTempFile = File.createTempFile(file.getName(), ".tmp", file.getParentFile());
        InputStream inputStreamOpen = com.frame.v0.g().getAssets().open(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                byte[] bArr = new byte[WXMediaMessage.THUMB_LENGTH_LIMIT];
                while (true) {
                    int i2 = inputStreamOpen.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i2);
                    }
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                o(fileCreateTempFile, file);
            } finally {
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() throws IOException {
        File fileH = h();
        if (!fileH.isDirectory() && !fileH.mkdirs()) {
            throw new IOException("无法创建OCR模型目录：" + fileH);
        }
        File file = new File(fileH, "chi_sim.traineddata");
        File file2 = new File(fileH, "eng.traineddata");
        File file3 = new File(fileH, ".builtin-model-version");
        if ("tessdata_best@e12c65a915945e4c28e237a9b52bc4a8f39a0cec".equals(k(file3)) && file.length() == 13077423 && file2.length() == 15400601) {
            return;
        }
        e("chi_sim.traineddata", file);
        e("eng.traineddata", file2);
        r(file3, "tessdata_best@e12c65a915945e4c28e237a9b52bc4a8f39a0cec");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File g() {
        if (com.frame.v0.g() != null) {
            return new File(da.z(), "tesseract");
        }
        throw new IllegalStateException("Application尚未初始化，无法初始化Tesseract");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File h() {
        return new File(g(), "tessdata");
    }

    private static String k(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static q8 m(String str, String str2, String str3, final Bitmap bitmap) throws Exception {
        return i.b.ja.i.a(i.b.ja.i.c(str, com.frame.v0.g().getPackageName())) ? i.b.ja.m.i().l(bitmap, str3) : (q8) q(str2, str3, new p9() { // from class: i.b.m3
            @Override // i.b.p9
            public final Object a(n9 n9Var) {
                return n9Var.e(bitmap);
            }
        });
    }

    private static void o(File file, File file2) throws IOException {
        try {
            try {
                Os.rename(file.getAbsolutePath(), file2.getAbsolutePath());
            } catch (ErrnoException e) {
                throw new IOException("无法更新OCR模型：" + file2, e);
            }
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static <T> T q(String str, String str2, p9<T> p9Var) throws Exception {
        T tA;
        synchronized (b) {
            n9 n9Var = new n9(o9.f(str, str2));
            try {
                tA = p9Var.a(n9Var);
            } finally {
                n9Var.d();
            }
        }
        return tA;
    }

    private static void r(File file, String str) throws IOException {
        File fileCreateTempFile = File.createTempFile(file.getName(), ".tmp", file.getParentFile());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            try {
                outputStreamWriter.write(str);
                outputStreamWriter.write(10);
                outputStreamWriter.flush();
                fileOutputStream.getFD().sync();
                outputStreamWriter.close();
                fileOutputStream.close();
                o(fileCreateTempFile, file);
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public q8 l(String str, String str2, String str3, final Bitmap bitmap) throws Exception {
        return i.b.ja.i.a(i.b.ja.i.c(str, com.frame.v0.g().getPackageName())) ? i.b.ja.m.i().l(bitmap, str3) : (q8) p(str2, str3, new p9() { // from class: i.b.n3
            @Override // i.b.p9
            public final Object a(n9 n9Var) {
                return n9Var.e(bitmap);
            }
        });
    }

    public void n() {
        synchronized (b) {
            synchronized (this) {
                Iterator<n9> it = this.a.values().iterator();
                while (it.hasNext()) {
                    it.next().d();
                }
                this.a.clear();
            }
        }
    }

    public <T> T p(String str, String str2, p9<T> p9Var) throws Exception {
        n9 n9Var;
        T tA;
        synchronized (b) {
            o9 o9VarF = o9.f(str, str2);
            synchronized (this) {
                n9Var = this.a.get(o9VarF.d);
                if (n9Var == null) {
                    n9Var = new n9(o9VarF);
                    this.a.put(o9VarF.d, n9Var);
                }
            }
            try {
                tA = p9Var.a(n9Var);
            } finally {
                n9Var.c();
            }
        }
        return tA;
    }
}
