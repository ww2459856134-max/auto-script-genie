package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class a extends Tracer implements Handler.Callback {
    private b a;
    private FileWriter b;
    private FileWriter c;
    private File d;
    private File e;
    private char[] f;
    private volatile f g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f f878h;

    /* renamed from: i, reason: collision with root package name */
    private volatile f f879i;

    /* renamed from: j, reason: collision with root package name */
    private volatile f f880j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f881k;

    /* renamed from: l, reason: collision with root package name */
    private HandlerThread f882l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f883m;

    public a(b bVar) {
        this(c.b, true, g.a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f882l && !this.f881k) {
            this.f881k = true;
            j();
            try {
                try {
                    this.f880j.a(g(), this.f);
                } catch (IOException e) {
                    SLog.e("FileTracer", "flushBuffer exception", e);
                }
                this.f881k = false;
            } finally {
                this.f880j.b();
            }
        }
    }

    private Writer[] g() {
        File[] fileArrA = c().a();
        if (fileArrA != null && fileArrA.length >= 2) {
            File file = fileArrA[0];
            if ((file != null && !file.equals(this.d)) || (this.b == null && file != null)) {
                this.d = file;
                h();
                try {
                    this.b = new FileWriter(this.d, true);
                } catch (IOException unused) {
                    this.b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = fileArrA[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.c = new FileWriter(this.e, true);
                } catch (IOException unused2) {
                    this.c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.b, this.c};
    }

    private void h() {
        try {
            FileWriter fileWriter = this.b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.b.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.c.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.f879i == this.g) {
                this.f879i = this.f878h;
                this.f880j = this.g;
            } else {
                this.f879i = this.g;
                this.f880j = this.f878h;
            }
        }
    }

    public void a() {
        if (this.f883m.hasMessages(1024)) {
            this.f883m.removeMessages(1024);
        }
        this.f883m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.f882l.quit();
    }

    public b c() {
        return this.a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, g gVar, b bVar) {
        super(i2, z, gVar);
        this.f881k = false;
        a(bVar);
        this.g = new f();
        this.f878h = new f();
        this.f879i = this.g;
        this.f880j = this.f878h;
        this.f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f882l = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f882l.isAlive() || this.f882l.getLooper() == null) {
            return;
        }
        this.f883m = new Handler(this.f882l.getLooper(), this);
    }

    private void a(String str) {
        this.f879i.a(str);
        if (this.f879i.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
