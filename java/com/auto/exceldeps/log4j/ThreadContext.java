package com.auto.exceldeps.log4j;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.spi.CleanableThreadContextMap;
import com.auto.exceldeps.log4j.spi.DefaultThreadContextMap;
import com.auto.exceldeps.log4j.spi.DefaultThreadContextStack;
import com.auto.exceldeps.log4j.spi.MutableThreadContextStack;
import com.auto.exceldeps.log4j.spi.ReadOnlyThreadContextMap;
import com.auto.exceldeps.log4j.spi.ThreadContextMap;
import com.auto.exceldeps.log4j.spi.ThreadContextMap2;
import com.auto.exceldeps.log4j.spi.ThreadContextMapFactory;
import com.auto.exceldeps.log4j.spi.ThreadContextStack;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import com.auto.exceldeps.log4j.util.ProviderUtil;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ThreadContext {
    private static final String DISABLE_ALL = "disableThreadContext";
    private static final String DISABLE_STACK = "disableThreadContextStack";
    public static final Map<String, String> EMPTY_MAP = Collections.emptyMap();
    public static final ThreadContextStack EMPTY_STACK = new EmptyThreadContextStack();
    private static ThreadContextMap contextMap;
    private static ThreadContextStack contextStack;
    private static ReadOnlyThreadContextMap readOnlyContextMap;

    public interface ContextStack extends Serializable, Collection<String> {
        List<String> asList();

        ContextStack copy();

        int getDepth();

        ContextStack getImmutableStackOrNull();

        String peek();

        String pop();

        void push(String str);

        void trim(int i2);
    }

    private static class EmptyThreadContextStack extends AbstractCollection<String> implements ThreadContextStack {
        private static final long serialVersionUID = 1;

        private EmptyThreadContextStack() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends String> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public List<String> asList() {
            return Collections.emptyList();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public ContextStack copy() {
            return new MutableThreadContextStack();
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            return (obj instanceof Collection) && ((Collection) obj).isEmpty();
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public int getDepth() {
            return 0;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public ContextStack getImmutableStackOrNull() {
            return this;
        }

        @Override // java.util.Collection
        public int hashCode() {
            return 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<String> iterator() {
            return Collections.emptyIterator();
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public String peek() {
            return null;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public String pop() {
            return null;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public void push(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public void trim(int i2) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(String str) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class NoOpThreadContextStack extends EmptyThreadContextStack {
        private NoOpThreadContextStack() {
            super();
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.EmptyThreadContextStack, java.util.AbstractCollection, java.util.Collection
        public boolean add(String str) {
            return false;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.EmptyThreadContextStack, java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends String> collection) {
            return false;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.EmptyThreadContextStack, com.auto.exceldeps.log4j.ThreadContext.ContextStack
        public void push(String str) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.EmptyThreadContextStack, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override // com.auto.exceldeps.log4j.ThreadContext.EmptyThreadContextStack, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return false;
        }
    }

    static {
        init();
    }

    private ThreadContext() {
    }

    public static void clearAll() {
        clearMap();
        clearStack();
    }

    public static void clearMap() {
        contextMap.clear();
    }

    public static void clearStack() {
        contextStack.clear();
    }

    public static ContextStack cloneStack() {
        return contextStack.copy();
    }

    public static boolean containsKey(String str) {
        return contextMap.containsKey(str);
    }

    public static String get(String str) {
        return contextMap.get(str);
    }

    public static Map<String, String> getContext() {
        return contextMap.getCopy();
    }

    public static int getDepth() {
        return contextStack.getDepth();
    }

    public static Map<String, String> getImmutableContext() {
        Map<String, String> immutableMapOrNull = contextMap.getImmutableMapOrNull();
        return immutableMapOrNull == null ? EMPTY_MAP : immutableMapOrNull;
    }

    public static ContextStack getImmutableStack() {
        ContextStack immutableStackOrNull = contextStack.getImmutableStackOrNull();
        return immutableStackOrNull == null ? EMPTY_STACK : immutableStackOrNull;
    }

    public static ReadOnlyThreadContextMap getThreadContextMap() {
        return readOnlyContextMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void init() throws ClassNotFoundException {
        PropertiesUtil properties = PropertiesUtil.getProperties();
        contextStack = (properties.getBooleanProperty(DISABLE_STACK) || properties.getBooleanProperty(DISABLE_ALL)) ? new NoOpThreadContextStack() : new DefaultThreadContextStack();
        ThreadContextMapFactory.init();
        ThreadContextMap threadContextMapInstance = ProviderUtil.getProvider().getThreadContextMapInstance();
        contextMap = threadContextMapInstance;
        readOnlyContextMap = threadContextMapInstance instanceof ReadOnlyThreadContextMap ? (ReadOnlyThreadContextMap) threadContextMapInstance : null;
    }

    public static boolean isEmpty() {
        return contextMap.isEmpty();
    }

    public static String peek() {
        return contextStack.peek();
    }

    public static String pop() {
        return contextStack.pop();
    }

    public static void push(String str) {
        contextStack.push(str);
    }

    public static void put(String str, String str2) {
        contextMap.put(str, str2);
    }

    public static void putAll(Map<String, String> map) {
        ThreadContextMap threadContextMap = contextMap;
        if (threadContextMap instanceof ThreadContextMap2) {
            ((ThreadContextMap2) threadContextMap).putAll(map);
            return;
        }
        if (threadContextMap instanceof DefaultThreadContextMap) {
            ((DefaultThreadContextMap) threadContextMap).putAll(map);
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            contextMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static void putIfNull(String str, String str2) {
        if (contextMap.containsKey(str)) {
            return;
        }
        contextMap.put(str, str2);
    }

    public static void remove(String str) {
        contextMap.remove(str);
    }

    public static void removeAll(Iterable<String> iterable) {
        ThreadContextMap threadContextMap = contextMap;
        if (threadContextMap instanceof CleanableThreadContextMap) {
            ((CleanableThreadContextMap) threadContextMap).removeAll(iterable);
            return;
        }
        if (threadContextMap instanceof DefaultThreadContextMap) {
            ((DefaultThreadContextMap) threadContextMap).removeAll(iterable);
            return;
        }
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            contextMap.remove(it.next());
        }
    }

    public static void removeStack() {
        contextStack.clear();
    }

    public static void setStack(Collection<String> collection) {
        if (collection.isEmpty()) {
            return;
        }
        contextStack.clear();
        contextStack.addAll(collection);
    }

    public static void trim(int i2) {
        contextStack.trim(i2);
    }

    public static void push(String str, Object... objArr) {
        contextStack.push(ParameterizedMessage.format(str, objArr));
    }
}
