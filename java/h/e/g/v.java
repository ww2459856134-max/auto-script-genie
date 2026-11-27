package h.e.g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
abstract class v {
    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new s(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, h.e.i.a<T> aVar) {
        executor.execute(new u(d.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
