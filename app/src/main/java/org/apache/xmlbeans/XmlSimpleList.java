package org.apache.xmlbeans;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* loaded from: classes.dex */
public class XmlSimpleList<T> implements List<T>, Serializable {
    private static final long serialVersionUID = 1;
    private final List<T> underlying;

    public XmlSimpleList(List<T> list) {
        this.underlying = list;
    }

    private String stringValue(Object obj) {
        return obj instanceof SimpleValue ? ((SimpleValue) obj).getStringValue() : obj.toString();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.underlying.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.underlying.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XmlSimpleList)) {
            return false;
        }
        List<T> list = ((XmlSimpleList) obj).underlying;
        int size = this.underlying.size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.equals(this.underlying.get(i2), list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int i2) {
        return this.underlying.get(i2);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator<T> it = this.underlying.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 19) + it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.underlying.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.underlying.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: org.apache.xmlbeans.XmlSimpleList.1

            /* renamed from: i, reason: collision with root package name */
            final Iterator<T> f2571i;

            {
                this.f2571i = XmlSimpleList.this.underlying.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f2571i.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                return this.f2571i.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.underlying.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.underlying.size();
    }

    @Override // java.util.List
    public List<T> subList(int i2, int i3) {
        return new XmlSimpleList(this.underlying.subList(i2, i3));
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.underlying.toArray(new Object[0]);
    }

    public String toString() {
        int size = this.underlying.size();
        if (size == 0) {
            return "";
        }
        String strStringValue = stringValue(this.underlying.get(0));
        if (size == 1) {
            return strStringValue;
        }
        StringBuilder sb = new StringBuilder(strStringValue);
        for (int i2 = 1; i2 < size; i2++) {
            sb.append(Chars.SPACE);
            sb.append(stringValue(this.underlying.get(i2)));
        }
        return sb.toString();
    }

    @Override // java.util.List
    public void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i2) {
        return new ListIterator<T>(i2) { // from class: org.apache.xmlbeans.XmlSimpleList.2

            /* renamed from: i, reason: collision with root package name */
            final ListIterator<T> f2572i;
            final /* synthetic */ int val$index;

            {
                this.val$index = i2;
                this.f2572i = XmlSimpleList.this.underlying.listIterator(i2);
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f2572i.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f2572i.hasPrevious();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                return this.f2572i.next();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f2572i.nextIndex();
            }

            @Override // java.util.ListIterator
            public T previous() {
                return this.f2572i.previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f2572i.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.List
    public T remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        return (X[]) this.underlying.toArray(xArr);
    }
}
