package org.apache.xmlbeans.impl.values;

import java.util.AbstractList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes2.dex */
public class JavaListXmlObject<T extends XmlObject> extends AbstractList<T> {
    private final Function<Integer, T> adder;
    private final Function<Integer, T> getter;
    private final Consumer<Integer> remover;
    private final BiConsumer<Integer, T> setter;
    private final Supplier<Integer> sizer;

    public JavaListXmlObject(Function<Integer, T> function, BiConsumer<Integer, T> biConsumer, Function<Integer, T> function2, Consumer<Integer> consumer, Supplier<Integer> supplier) {
        this.getter = function;
        this.setter = biConsumer;
        this.adder = function2;
        this.remover = consumer;
        this.sizer = supplier;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        Supplier<Integer> supplier = this.sizer;
        if (supplier != null) {
            return supplier.get().intValue();
        }
        throw new IllegalStateException("XmlBean generated using partial methods - no size-of method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        Function<Integer, T> function = this.adder;
        if (function == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no add method available");
        }
        function.apply(Integer.valueOf(i2)).set(t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        Function<Integer, T> function = this.getter;
        if (function != null) {
            return function.apply(Integer.valueOf(i2));
        }
        throw new IllegalStateException("XmlBean generated using partial methods - no getter available");
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i2) {
        if (this.remover == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no remove method available");
        }
        T t = (T) get(i2);
        this.remover.accept(Integer.valueOf(i2));
        return t;
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        if (this.setter == null) {
            throw new IllegalStateException("XmlBean generated using partial methods - no setter available");
        }
        T t2 = (T) get(i2);
        this.setter.accept(Integer.valueOf(i2), t);
        return t2;
    }
}
