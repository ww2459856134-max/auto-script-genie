package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.util.LazyUtil;
import java.util.Objects;
import java.util.function.Function;

/* loaded from: classes.dex */
public interface Lazy<T> extends java.util.function.Supplier<T> {
    static <T> Lazy<T> lazy(java.util.function.Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return new LazyUtil.SafeLazy(supplier);
    }

    static <T> Lazy<T> pure(java.util.function.Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return new LazyUtil.PureLazy(supplier);
    }

    static <T> Lazy<T> value(T t) {
        return new LazyUtil.Constant(t);
    }

    static <T> Lazy<T> weak(T t) {
        return new LazyUtil.WeakConstant(t);
    }

    @Override // java.util.function.Supplier
    default T get() {
        return value();
    }

    boolean isInitialized();

    default <R> Lazy<R> map(final Function<? super T, ? extends R> function) {
        return lazy(new java.util.function.Supplier() { // from class: com.auto.exceldeps.log4j.util.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return function.apply(this.a.value());
            }
        });
    }

    void set(T t);

    T value();
}
