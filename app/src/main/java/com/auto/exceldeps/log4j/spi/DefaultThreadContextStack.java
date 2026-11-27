package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.ThreadContext;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.auto.exceldeps.log4j.util.StringBuilders;
import com.auto.exceldeps.log4j.util.Strings;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultThreadContextStack implements ThreadContextStack, StringBuilderFormattable {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final ThreadLocal<MutableThreadContextStack> STACK = new ThreadLocal<>();
    private static final long serialVersionUID = 5050501;
    private final boolean useStack;

    public DefaultThreadContextStack() {
        this(true);
    }

    private MutableThreadContextStack getNonNullStackCopy() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return (MutableThreadContextStack) (mutableThreadContextStack == null ? new MutableThreadContextStack() : mutableThreadContextStack.copy());
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        if (!this.useStack || collection.isEmpty()) {
            return false;
        }
        MutableThreadContextStack nonNullStackCopy = getNonNullStackCopy();
        nonNullStackCopy.addAll(collection);
        nonNullStackCopy.freeze();
        STACK.set(nonNullStackCopy);
        return true;
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public List<String> asList() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack == null ? Collections.emptyList() : mutableThreadContextStack.asList();
    }

    @Override // java.util.Collection
    public void clear() {
        STACK.remove();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack != null && mutableThreadContextStack.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack != null && mutableThreadContextStack.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (((obj instanceof DefaultThreadContextStack) && this.useStack != ((DefaultThreadContextStack) obj).useStack) || !(obj instanceof ThreadContextStack)) {
            return false;
        }
        ThreadContextStack threadContextStack = (ThreadContextStack) obj;
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        if (mutableThreadContextStack == null) {
            return false;
        }
        return mutableThreadContextStack.equals(threadContextStack);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        if (mutableThreadContextStack == null) {
            sb.append("[]");
        } else {
            StringBuilders.appendValue(sb, mutableThreadContextStack);
        }
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public int getDepth() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        if (mutableThreadContextStack == null) {
            return 0;
        }
        return mutableThreadContextStack.getDepth();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public ThreadContext.ContextStack getImmutableStackOrNull() {
        return STACK.get();
    }

    @Override // java.util.Collection
    public int hashCode() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return 31 + (mutableThreadContextStack == null ? 0 : mutableThreadContextStack.hashCode());
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack == null || mutableThreadContextStack.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack == null ? Collections.emptyList().iterator() : mutableThreadContextStack.iterator();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public String peek() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return (mutableThreadContextStack == null || mutableThreadContextStack.isEmpty()) ? "" : mutableThreadContextStack.peek();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public String pop() {
        ThreadLocal<MutableThreadContextStack> threadLocal;
        MutableThreadContextStack mutableThreadContextStack;
        if (!this.useStack || (mutableThreadContextStack = (threadLocal = STACK).get()) == null || mutableThreadContextStack.isEmpty()) {
            return "";
        }
        MutableThreadContextStack mutableThreadContextStack2 = (MutableThreadContextStack) mutableThreadContextStack.copy();
        String strPop = mutableThreadContextStack2.pop();
        mutableThreadContextStack2.freeze();
        threadLocal.set(mutableThreadContextStack2);
        return strPop;
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public void push(String str) {
        if (this.useStack) {
            add(str);
        }
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        ThreadLocal<MutableThreadContextStack> threadLocal;
        MutableThreadContextStack mutableThreadContextStack;
        if (!this.useStack || (mutableThreadContextStack = (threadLocal = STACK).get()) == null || mutableThreadContextStack.isEmpty()) {
            return false;
        }
        MutableThreadContextStack mutableThreadContextStack2 = (MutableThreadContextStack) mutableThreadContextStack.copy();
        boolean zRemove = mutableThreadContextStack2.remove(obj);
        mutableThreadContextStack2.freeze();
        threadLocal.set(mutableThreadContextStack2);
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        ThreadLocal<MutableThreadContextStack> threadLocal;
        MutableThreadContextStack mutableThreadContextStack;
        if (!this.useStack || collection.isEmpty() || (mutableThreadContextStack = (threadLocal = STACK).get()) == null || mutableThreadContextStack.isEmpty()) {
            return false;
        }
        MutableThreadContextStack mutableThreadContextStack2 = (MutableThreadContextStack) mutableThreadContextStack.copy();
        boolean zRemoveAll = mutableThreadContextStack2.removeAll(collection);
        mutableThreadContextStack2.freeze();
        threadLocal.set(mutableThreadContextStack2);
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        ThreadLocal<MutableThreadContextStack> threadLocal;
        MutableThreadContextStack mutableThreadContextStack;
        if (!this.useStack || collection.isEmpty() || (mutableThreadContextStack = (threadLocal = STACK).get()) == null || mutableThreadContextStack.isEmpty()) {
            return false;
        }
        MutableThreadContextStack mutableThreadContextStack2 = (MutableThreadContextStack) mutableThreadContextStack.copy();
        boolean zRetainAll = mutableThreadContextStack2.retainAll(collection);
        mutableThreadContextStack2.freeze();
        threadLocal.set(mutableThreadContextStack2);
        return zRetainAll;
    }

    @Override // java.util.Collection
    public int size() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        if (mutableThreadContextStack == null) {
            return 0;
        }
        return mutableThreadContextStack.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack == null ? Strings.EMPTY_ARRAY : mutableThreadContextStack.toArray(EMPTY_OBJECT_ARRAY);
    }

    public String toString() {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        return mutableThreadContextStack == null ? "[]" : mutableThreadContextStack.toString();
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public void trim(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Maximum stack depth cannot be negative");
        }
        ThreadLocal<MutableThreadContextStack> threadLocal = STACK;
        MutableThreadContextStack mutableThreadContextStack = threadLocal.get();
        if (mutableThreadContextStack == null) {
            return;
        }
        MutableThreadContextStack mutableThreadContextStack2 = (MutableThreadContextStack) mutableThreadContextStack.copy();
        mutableThreadContextStack2.trim(i2);
        mutableThreadContextStack2.freeze();
        threadLocal.set(mutableThreadContextStack2);
    }

    @Deprecated
    public DefaultThreadContextStack(boolean z) {
        this.useStack = z;
    }

    @Override // java.util.Collection
    public boolean add(String str) {
        if (!this.useStack) {
            return false;
        }
        MutableThreadContextStack nonNullStackCopy = getNonNullStackCopy();
        nonNullStackCopy.add(str);
        nonNullStackCopy.freeze();
        STACK.set(nonNullStackCopy);
        return true;
    }

    @Override // com.auto.exceldeps.log4j.ThreadContext.ContextStack
    public ThreadContextStack copy() {
        MutableThreadContextStack mutableThreadContextStack;
        return (!this.useStack || (mutableThreadContextStack = STACK.get()) == null) ? new MutableThreadContextStack() : mutableThreadContextStack.copy();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        MutableThreadContextStack mutableThreadContextStack = STACK.get();
        if (mutableThreadContextStack == null) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        return (T[]) mutableThreadContextStack.toArray(tArr);
    }
}
