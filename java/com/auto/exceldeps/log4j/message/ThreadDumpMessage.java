package com.auto.exceldeps.log4j.message;

import aQute.bnd.annotation.spi.ServiceConsumer;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.Lazy;
import com.auto.exceldeps.log4j.util.ServiceLoaderUtil;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Supplier;

@ServiceConsumer(cardinality = "single", resolution = "optional", value = ThreadInfoFactory.class)
@AsynchronouslyFormattable
/* loaded from: classes.dex */
public class ThreadDumpMessage implements Message, StringBuilderFormattable {
    private static final Lazy<ThreadInfoFactory> FACTORY = Lazy.lazy(new Supplier() { // from class: com.auto.exceldeps.log4j.message.e
        @Override // java.util.function.Supplier
        public final Object get() {
            return ThreadDumpMessage.initFactory();
        }
    });
    private static final long serialVersionUID = -1103400781608841088L;
    private String formattedMessage;
    private volatile Map<ThreadInformation, StackTraceElement[]> threads;
    private final String title;

    /* JADX INFO: Access modifiers changed from: private */
    static class BasicThreadInfoFactory implements ThreadInfoFactory {
        private BasicThreadInfoFactory() {
        }

        @Override // com.auto.exceldeps.log4j.message.ThreadDumpMessage.ThreadInfoFactory
        public Map<ThreadInformation, StackTraceElement[]> createThreadInfo() {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            HashMap map = new HashMap(allStackTraces.size());
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                map.put(new BasicThreadInformation(entry.getKey()), entry.getValue());
            }
            return map;
        }
    }

    private static class ThreadDumpMessageProxy implements Serializable {
        private static final long serialVersionUID = -3476620450287648269L;
        private final String formattedMsg;
        private final String title;

        ThreadDumpMessageProxy(ThreadDumpMessage threadDumpMessage) {
            this.formattedMsg = threadDumpMessage.getFormattedMessage();
            this.title = threadDumpMessage.title;
        }

        protected Object readResolve() {
            return new ThreadDumpMessage(this.formattedMsg, this.title);
        }
    }

    public interface ThreadInfoFactory {
        Map<ThreadInformation, StackTraceElement[]> createThreadInfo();
    }

    static /* synthetic */ ThreadInfoFactory b() {
        return new BasicThreadInfoFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ThreadInfoFactory initFactory() {
        return (ThreadInfoFactory) ServiceLoaderUtil.safeStream(ThreadInfoFactory.class, ServiceLoader.load(ThreadInfoFactory.class, ThreadDumpMessage.class.getClassLoader()), StatusLogger.getLogger()).findFirst().orElseGet(new Supplier() { // from class: com.auto.exceldeps.log4j.message.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return ThreadDumpMessage.b();
            }
        });
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        sb.append(this.title);
        if (this.title.length() > 0) {
            sb.append('\n');
        }
        for (Map.Entry<ThreadInformation, StackTraceElement[]> entry : this.threads.entrySet()) {
            ThreadInformation key = entry.getKey();
            key.printThreadInfo(sb);
            key.printStack(sb, entry.getValue());
            sb.append('\n');
        }
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        String str = this.title;
        return str == null ? "" : str;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        String str = this.formattedMessage;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(255);
        formatTo(sb);
        return sb.toString();
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public String toString() {
        return getFormattedMessage();
    }

    protected Object writeReplace() {
        return new ThreadDumpMessageProxy(this);
    }

    public ThreadDumpMessage(String str) {
        this.title = str == null ? "" : str;
        this.threads = FACTORY.get().createThreadInfo();
    }

    private ThreadDumpMessage(String str, String str2) {
        this.formattedMessage = str;
        this.title = str2 == null ? "" : str2;
    }
}
