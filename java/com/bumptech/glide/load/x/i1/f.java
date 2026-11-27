package com.bumptech.glide.load.x.i1;

import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class f implements ExecutorService {
    private static final long b = TimeUnit.SECONDS.toMillis(10);
    private static volatile int c;
    private final ExecutorService a;

    f(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (c == 0) {
            c = Math.min(4, h.a());
        }
        return c;
    }

    public static a b() {
        int i2 = a() >= 4 ? 2 : 1;
        a aVar = new a(true);
        aVar.c(i2);
        aVar.b("animation");
        return aVar;
    }

    public static f c() {
        return b().a();
    }

    public static a d() {
        a aVar = new a(true);
        aVar.c(1);
        aVar.b("disk-cache");
        return aVar;
    }

    public static f e() {
        return d().a();
    }

    public static a f() {
        a aVar = new a(false);
        aVar.c(a());
        aVar.b(SocialConstants.PARAM_SOURCE);
        return aVar;
    }

    public static f g() {
        return f().a();
    }

    public static f h() {
        return new f(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new c("source-unlimited", e.b, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(callable);
    }
}
