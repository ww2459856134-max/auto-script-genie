package com.auto.exceldeps.log4j.status;

import com.auto.exceldeps.log4j.Level;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class StatusConsoleListener implements StatusListener {
    private final Level initialLevel;
    private final PrintStream initialStream;
    private volatile Level level;
    private final Lock lock;
    private volatile PrintStream stream;

    public StatusConsoleListener(Level level) {
        this(level, System.out);
    }

    private static void closeNonSystemStream(OutputStream outputStream) throws IOException {
        if (outputStream == System.out || outputStream == System.err) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.lock.lock();
        try {
            PrintStream printStream = this.stream;
            this.stream = this.initialStream;
            this.level = this.initialLevel;
            this.lock.unlock();
            closeNonSystemStream(printStream);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // com.auto.exceldeps.log4j.status.StatusListener
    public Level getStatusLevel() {
        return this.level;
    }

    @Override // com.auto.exceldeps.log4j.status.StatusListener
    public void log(StatusData statusData) {
        Objects.requireNonNull(statusData, "data");
        this.stream.println(statusData.getFormattedStatus());
    }

    @Deprecated
    public void setFilters(String... strArr) {
    }

    public void setLevel(Level level) {
        Objects.requireNonNull(level, "level");
        if (this.level.equals(level)) {
            return;
        }
        this.lock.lock();
        try {
            this.level = level;
        } finally {
            this.lock.unlock();
        }
    }

    public void setStream(PrintStream printStream) throws IOException {
        Objects.requireNonNull(printStream, "stream");
        if (this.stream != printStream) {
            PrintStream printStream2 = null;
            this.lock.lock();
            try {
                if (this.stream != printStream) {
                    printStream2 = this.stream;
                    this.stream = printStream;
                }
                if (printStream2 != null) {
                    closeNonSystemStream(printStream2);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public StatusConsoleListener(Level level, PrintStream printStream) {
        this.lock = new ReentrantLock();
        Objects.requireNonNull(level, "level");
        Level level2 = level;
        this.level = level2;
        this.initialLevel = level2;
        Objects.requireNonNull(printStream, "stream");
        PrintStream printStream2 = printStream;
        this.stream = printStream2;
        this.initialStream = printStream2;
    }
}
