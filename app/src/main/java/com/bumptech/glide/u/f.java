package com.bumptech.glide.u;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.auto.exceldeps.log4j.util.Chars;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class f implements Closeable {
    private int A;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private long f677h;

    /* renamed from: i, reason: collision with root package name */
    private final int f678i;

    /* renamed from: k, reason: collision with root package name */
    private Writer f680k;

    /* renamed from: j, reason: collision with root package name */
    private long f679j = 0;
    private final LinkedHashMap<String, d> t = new LinkedHashMap<>(0, 0.75f, true);
    private long C = 0;
    final ThreadPoolExecutor D = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> G = new a(this);

    private f(File file, int i2, int i3, long j2) {
        this.c = file;
        this.g = i2;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.f678i = i3;
        this.f677h = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        int i2 = this.A;
        return i2 >= 2000 && i2 >= this.t.size();
    }

    public static f D(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                K(file2, file3, false);
            }
        }
        f fVar = new f(file, i2, i3, j2);
        if (fVar.d.exists()) {
            try {
                fVar.G();
                fVar.F();
                return fVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                fVar.s();
            }
        }
        file.mkdirs();
        f fVar2 = new f(file, i2, i3, j2);
        fVar2.I();
        return fVar2;
    }

    private void F() throws IOException {
        u(this.e);
        Iterator<d> it = this.t.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.f678i) {
                    this.f679j += next.b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.f678i) {
                    u(next.j(i2));
                    u(next.k(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void G() throws IOException {
        h hVar = new h(new FileInputStream(this.d), i.a);
        try {
            String strF = hVar.f();
            String strF2 = hVar.f();
            String strF3 = hVar.f();
            String strF4 = hVar.f();
            String strF5 = hVar.f();
            if (!"libcore.io.DiskLruCache".equals(strF) || !"1".equals(strF2) || !Integer.toString(this.g).equals(strF3) || !Integer.toString(this.f678i).equals(strF4) || !"".equals(strF5)) {
                throw new IOException("unexpected journal header: [" + strF + ", " + strF2 + ", " + strF4 + ", " + strF5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    H(hVar.f());
                    i2++;
                } catch (EOFException unused) {
                    this.A = i2 - this.t.size();
                    if (hVar.d()) {
                        I();
                    } else {
                        this.f680k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), i.a));
                    }
                    i.a(hVar);
                    return;
                }
            }
        } catch (Throwable th) {
            i.a(hVar);
            throw th;
        }
    }

    private void H(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.t.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.t.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.t.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void I() throws IOException {
        Writer writer = this.f680k;
        if (writer != null) {
            p(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), i.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f678i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.t.values()) {
                if (dVar.f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                }
            }
            p(bufferedWriter);
            if (this.d.exists()) {
                K(this.d, this.f, true);
            }
            K(this.e, this.d, false);
            this.f.delete();
            this.f680k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), i.a));
        } catch (Throwable th) {
            p(bufferedWriter);
            throw th;
        }
    }

    private static void K(File file, File file2, boolean z) throws IOException {
        if (z) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() throws IOException {
        while (this.f679j > this.f677h) {
            J(this.t.entrySet().iterator().next().getKey());
        }
    }

    private void o() {
        if (this.f680k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void p(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i2 = 0; i2 < this.f678i; i2++) {
                if (!cVar.b[i2]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!dVar.k(i2).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f678i; i3++) {
            File fileK = dVar.k(i3);
            if (!z) {
                u(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i3);
                fileK.renameTo(fileJ);
                long j2 = dVar.b[i3];
                long length = fileJ.length();
                dVar.b[i3] = length;
                this.f679j = (this.f679j - j2) + length;
            }
        }
        this.A++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.f680k.append((CharSequence) "CLEAN");
            this.f680k.append(Chars.SPACE);
            this.f680k.append((CharSequence) dVar.a);
            this.f680k.append((CharSequence) dVar.l());
            this.f680k.append('\n');
            if (z) {
                long j3 = this.C;
                this.C = 1 + j3;
                dVar.g = j3;
            }
        } else {
            this.t.remove(dVar.a);
            this.f680k.append((CharSequence) "REMOVE");
            this.f680k.append(Chars.SPACE);
            this.f680k.append((CharSequence) dVar.a);
            this.f680k.append('\n');
        }
        y(this.f680k);
        if (this.f679j > this.f677h || B()) {
            this.D.submit(this.G);
        }
    }

    private static void u(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c x(String str, long j2) throws IOException {
        o();
        d dVar = this.t.get(str);
        a aVar = null;
        if (j2 != -1 && (dVar == null || dVar.g != j2)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.t.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f = cVar;
        this.f680k.append((CharSequence) "DIRTY");
        this.f680k.append(Chars.SPACE);
        this.f680k.append((CharSequence) str);
        this.f680k.append('\n');
        y(this.f680k);
        return cVar;
    }

    @TargetApi(26)
    private static void y(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized boolean J(String str) throws IOException {
        o();
        d dVar = this.t.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i2 = 0; i2 < this.f678i; i2++) {
                File fileJ = dVar.j(i2);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.f679j -= dVar.b[i2];
                dVar.b[i2] = 0;
            }
            this.A++;
            this.f680k.append((CharSequence) "REMOVE");
            this.f680k.append(Chars.SPACE);
            this.f680k.append((CharSequence) str);
            this.f680k.append('\n');
            this.t.remove(str);
            if (B()) {
                this.D.submit(this.G);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f680k == null) {
            return;
        }
        Iterator it = new ArrayList(this.t.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        L();
        p(this.f680k);
        this.f680k = null;
    }

    public void s() throws IOException {
        close();
        i.b(this.c);
    }

    public c w(String str) throws IOException {
        return x(str, -1L);
    }

    public synchronized e z(String str) throws IOException {
        o();
        d dVar = this.t.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.A++;
        this.f680k.append((CharSequence) "READ");
        this.f680k.append(Chars.SPACE);
        this.f680k.append((CharSequence) str);
        this.f680k.append('\n');
        if (B()) {
            this.D.submit(this.G);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }
}
