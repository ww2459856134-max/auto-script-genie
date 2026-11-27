package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.ThreadContext;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class MutableThreadContextStack implements ThreadContextStack, StringBuilderFormattable {
    private static final long serialVersionUID = 50505011;
    private boolean frozen;
    private final List<String> list;

    public MutableThreadContextStack() {
        this(new ArrayList());
    }

    private void checkInvariants() {
        if (this.frozen) {
            throw new UnsupportedOperationException("context stack has been frozen");
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        checkInvariants();
        return this.list.addAll(collection);
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public List<String> asList() {
        return this.list;
    }

    @Override // java.util.Collection
    public void clear() {
        checkInvariants();
        this.list.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ThreadContextStack)) {
            return false;
        }
        return Objects.equals(this.list, ((ThreadContextStack) obj).asList());
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        sb.append('[');
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            if (i2 > 0) {
                sb.append(',');
                sb.append(Chars.SPACE);
            }
            sb.append(this.list.get(i2));
        }
        sb.append(']');
    }

    public void freeze() {
        this.frozen = true;
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public int getDepth() {
        return this.list.size();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public ThreadContext.ContextStack getImmutableStackOrNull() {
        return copy();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Objects.hashCode(this.list) + 31;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        return this.list.iterator();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public String peek() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.get(this.list.size() - 1);
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public String pop() {
        checkInvariants();
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.remove(this.list.size() - 1);
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public void push(String str) {
        checkInvariants();
        this.list.add(str);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        checkInvariants();
        return this.list.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        checkInvariants();
        return this.list.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        checkInvariants();
        return this.list.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    public String toString() {
        return String.valueOf(this.list);
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public void trim(int i2) {
        checkInvariants();
        if (i2 < 0) {
            throw new IllegalArgumentException("Maximum stack depth cannot be negative");
        }
        if (this.list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.list.size());
        int iMin = Math.min(i2, this.list.size());
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(this.list.get(i3));
        }
        this.list.clear();
        this.list.addAll(arrayList);
    }

    public MutableThreadContextStack(List<String> list) {
        this.list = new ArrayList(list);
    }

    @Override // java.util.Collection
    public boolean add(String str) {
        checkInvariants();
        return this.list.add(str);
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public ThreadContextStack copy() {
        return new MutableThreadContextStack(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.list.toArray(tArr);
    }

    private MutableThreadContextStack(MutableThreadContextStack mutableThreadContextStack) {
        this.list = new ArrayList(mutableThreadContextStack.list);
    }
}
