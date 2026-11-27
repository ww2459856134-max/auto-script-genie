package com.auto.exceldeps.log4j.util;

import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class LazyUtil {
    private static final Object NULL = new Object() { // from class: com.auto.exceldeps.log4j.util.LazyUtil.1
        public String toString() {
            return "null";
        }
    };

    static class Constant<T> implements Lazy<T> {
        private final T value;

        Constant(T t) {
            this.value = t;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public boolean isInitialized() {
            return true;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public T value() {
            return this.value;
        }
    }

    static class PureLazy<T> implements Lazy<T> {
        private final java.util.function.Supplier<T> supplier;
        private Object value;

        public PureLazy(java.util.function.Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public boolean isInitialized() {
            return this.value != null;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public void set(T t) {
            this.value = t;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public T value() {
            Object obj = this.value;
            if (obj == null) {
                obj = this.supplier.get();
                this.value = LazyUtil.wrapNull(obj);
            }
            return (T) LazyUtil.unwrapNull(obj);
        }
    }

    static class SafeLazy<T> implements Lazy<T> {
        private final Lock lock = new ReentrantLock();
        private final java.util.function.Supplier<T> supplier;
        private volatile Object value;

        SafeLazy(java.util.function.Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public boolean isInitialized() {
            return this.value != null;
        }

        public void reset() {
            this.value = null;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public void set(T t) {
            this.value = t;
        }

        public String toString() {
            return isInitialized() ? String.valueOf(this.value) : "Lazy value not initialized";
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public T value() {
            Object obj = this.value;
            if (obj == null) {
                this.lock.lock();
                try {
                    obj = this.value;
                    if (obj == null) {
                        obj = this.supplier.get();
                        this.value = LazyUtil.wrapNull(obj);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return (T) LazyUtil.unwrapNull(obj);
        }
    }

    static class WeakConstant<T> implements Lazy<T> {
        private final WeakReference<T> reference;

        WeakConstant(T t) {
            this.reference = new WeakReference<>(t);
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public boolean isInitialized() {
            return true;
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return String.valueOf(value());
        }

        @Override // com.auto.exceldeps.log4j.util.Lazy
        public T value() {
            return this.reference.get();
        }
    }

    LazyUtil() {
    }

    static <T> T unwrapNull(Object obj) {
        if (obj == NULL) {
            return null;
        }
        return (T) Cast.cast(obj);
    }

    static Object wrapNull(Object obj) {
        return obj == null ? NULL : obj;
    }
}
