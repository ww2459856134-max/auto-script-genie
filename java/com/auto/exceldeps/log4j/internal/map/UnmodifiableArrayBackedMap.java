package com.auto.exceldeps.log4j.internal.map;

import com.auto.exceldeps.log4j.util.ReadOnlyStringMap;
import com.auto.exceldeps.log4j.util.TriConsumer;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

/* loaded from: classes.dex */
public class UnmodifiableArrayBackedMap extends AbstractMap<String, String> implements Serializable, ReadOnlyStringMap {
    public static final UnmodifiableArrayBackedMap EMPTY_MAP = new UnmodifiableArrayBackedMap(0);
    private static final int NUM_FIXED_ARRAY_ENTRIES = 1;
    private static final long serialVersionUID = 6849423432534211514L;
    private Object[] backingArray;
    private int numEntries;

    private class UnmodifiableEntry implements Map.Entry<String, String> {
        private int index;

        public UnmodifiableEntry(int i2) {
            this.index = i2;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return Objects.hashCode((String) UnmodifiableArrayBackedMap.this.backingArray[UnmodifiableArrayBackedMap.getArrayIndexForKey(this.index)]) ^ Objects.hashCode((String) UnmodifiableArrayBackedMap.this.backingArray[UnmodifiableArrayBackedMap.getArrayIndexForValue(this.index)]);
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return (String) UnmodifiableArrayBackedMap.this.backingArray[UnmodifiableArrayBackedMap.getArrayIndexForKey(this.index)];
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            return (String) UnmodifiableArrayBackedMap.this.backingArray[UnmodifiableArrayBackedMap.getArrayIndexForValue(this.index)];
        }

        @Override // java.util.Map.Entry
        public String setValue(String str) {
            throw new UnsupportedOperationException("Cannot update Entry instances in UnmodifiableArrayBackedMap");
        }
    }

    private class UnmodifiableEntryIterator implements Iterator<Map.Entry<String, String>> {
        private int index;

        private UnmodifiableEntryIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < UnmodifiableArrayBackedMap.this.numEntries;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            UnmodifiableArrayBackedMap unmodifiableArrayBackedMap = UnmodifiableArrayBackedMap.this;
            int i2 = this.index;
            this.index = i2 + 1;
            return unmodifiableArrayBackedMap.new UnmodifiableEntry(i2);
        }
    }

    private class UnmodifiableEntrySet extends AbstractSet<Map.Entry<String, String>> {
        private UnmodifiableEntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<String, String>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, String>> iterator() {
            return new UnmodifiableEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return UnmodifiableArrayBackedMap.this.numEntries;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<String, String> entry) {
            throw new UnsupportedOperationException();
        }
    }

    private UnmodifiableArrayBackedMap(int i2) {
        Object[] objArr = new Object[(i2 * 2) + 1];
        this.backingArray = objArr;
        objArr[0] = 0;
    }

    private void add(String str, String str2) {
        this.backingArray[getArrayIndexForKey(this.numEntries)] = str;
        this.backingArray[getArrayIndexForValue(this.numEntries)] = str2;
        this.numEntries++;
    }

    private void addOrOverwriteKey(String str, String str2) {
        int iHashCode = str.hashCode();
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            if (this.backingArray[getArrayIndexForKey(i2)].hashCode() == iHashCode && this.backingArray[getArrayIndexForKey(i2)].equals(str)) {
                this.backingArray[getArrayIndexForValue(i2)] = str2;
                return;
            }
        }
        add(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getArrayIndexForKey(int i2) {
        return (i2 * 2) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getArrayIndexForValue(int i2) {
        return (i2 * 2) + 1 + 1;
    }

    public static UnmodifiableArrayBackedMap getMap(Object[] objArr) {
        return (objArr == null || objArr.length == 1) ? EMPTY_MAP : new UnmodifiableArrayBackedMap(objArr);
    }

    private void updateNumEntriesInArray() {
        this.backingArray[0] = Integer.valueOf(this.numEntries);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Instance cannot be cleared, reuse EMPTY_MAP instead.");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey((String) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            Object obj2 = this.backingArray[getArrayIndexForValue(i2)];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public UnmodifiableArrayBackedMap copyAndPut(String str, String str2) {
        UnmodifiableArrayBackedMap unmodifiableArrayBackedMap = new UnmodifiableArrayBackedMap(this.numEntries + 1);
        int i2 = this.numEntries;
        if (i2 > 0) {
            System.arraycopy(this.backingArray, 1, unmodifiableArrayBackedMap.backingArray, 1, i2 * 2);
            unmodifiableArrayBackedMap.numEntries = this.numEntries;
        }
        unmodifiableArrayBackedMap.addOrOverwriteKey(str, str2);
        unmodifiableArrayBackedMap.updateNumEntriesInArray();
        return unmodifiableArrayBackedMap;
    }

    public UnmodifiableArrayBackedMap copyAndPutAll(Map<String, String> map) {
        UnmodifiableArrayBackedMap unmodifiableArrayBackedMap = new UnmodifiableArrayBackedMap(this.numEntries + map.size());
        int i2 = this.numEntries;
        if (i2 > 0) {
            System.arraycopy(this.backingArray, 0, unmodifiableArrayBackedMap.backingArray, 0, (i2 * 2) + 1);
            unmodifiableArrayBackedMap.numEntries = this.numEntries;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (isEmpty()) {
                unmodifiableArrayBackedMap.add(key, value);
            } else {
                unmodifiableArrayBackedMap.addOrOverwriteKey(key, value);
            }
        }
        unmodifiableArrayBackedMap.updateNumEntriesInArray();
        return unmodifiableArrayBackedMap;
    }

    public UnmodifiableArrayBackedMap copyAndRemove(String str) {
        int i2 = this.numEntries - 1;
        while (true) {
            if (i2 < 0) {
                i2 = -1;
                break;
            }
            if (this.backingArray[getArrayIndexForKey(i2)].hashCode() == str.hashCode() && this.backingArray[getArrayIndexForKey(i2)].equals(str)) {
                break;
            }
            i2--;
        }
        if (i2 == -1) {
            return this;
        }
        int i3 = this.numEntries;
        if (i3 == 1) {
            return EMPTY_MAP;
        }
        UnmodifiableArrayBackedMap unmodifiableArrayBackedMap = new UnmodifiableArrayBackedMap(i3);
        if (i2 > 0) {
            System.arraycopy(this.backingArray, 1, unmodifiableArrayBackedMap.backingArray, 1, i2 * 2);
        }
        int i4 = i2 + 1;
        int i5 = this.numEntries;
        if (i4 < i5) {
            System.arraycopy(this.backingArray, getArrayIndexForKey(i4), unmodifiableArrayBackedMap.backingArray, getArrayIndexForKey(i2), (i5 - i4) * 2);
        }
        unmodifiableArrayBackedMap.numEntries = this.numEntries - 1;
        unmodifiableArrayBackedMap.updateNumEntriesInArray();
        return unmodifiableArrayBackedMap;
    }

    public UnmodifiableArrayBackedMap copyAndRemoveAll(Iterable<String> iterable) {
        Set set;
        if (isEmpty()) {
            return EMPTY_MAP;
        }
        if (iterable instanceof Set) {
            set = (Set) iterable;
        } else {
            HashSet hashSet = new HashSet();
            Iterator<String> it = iterable.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            set = hashSet;
        }
        int i2 = this.numEntries;
        UnmodifiableArrayBackedMap unmodifiableArrayBackedMap = new UnmodifiableArrayBackedMap(i2);
        if (set.isEmpty()) {
            System.arraycopy(this.backingArray, 0, unmodifiableArrayBackedMap.backingArray, 0, i2 * 2);
            unmodifiableArrayBackedMap.numEntries = i2;
            return this;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = this.backingArray[getArrayIndexForKey(i4)];
            if (!set.contains(obj)) {
                Object obj2 = this.backingArray[getArrayIndexForValue(i4)];
                int arrayIndexForKey = getArrayIndexForKey(i3);
                int arrayIndexForValue = getArrayIndexForValue(i3);
                Object[] objArr = unmodifiableArrayBackedMap.backingArray;
                objArr[arrayIndexForKey] = obj;
                objArr[arrayIndexForValue] = obj2;
                i3++;
            }
        }
        unmodifiableArrayBackedMap.numEntries = i3;
        unmodifiableArrayBackedMap.updateNumEntriesInArray();
        return unmodifiableArrayBackedMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, String>> entrySet() {
        return new UnmodifiableEntrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super String, ? super String> biConsumer) {
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            biConsumer.accept((String) this.backingArray[getArrayIndexForKey(i2)], (String) this.backingArray[getArrayIndexForValue(i2)]);
        }
    }

    public Object[] getBackingArray() {
        return this.backingArray;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String str) {
        if (this.numEntries == 0) {
            return null;
        }
        int iHashCode = str.hashCode();
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            if (this.backingArray[getArrayIndexForKey(i2)].hashCode() == iHashCode && this.backingArray[getArrayIndexForKey(i2)].equals(str)) {
                return (V) this.backingArray[getArrayIndexForValue(i2)];
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends String, ? extends String> map) {
        throw new UnsupportedOperationException("putAll() is not supported, use copyAndPutAll instead");
    }

    @Override // java.util.AbstractMap, java.util.Map, com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public int size() {
        return this.numEntries;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        return this;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String str) {
        int iHashCode = str.hashCode();
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            if (this.backingArray[getArrayIndexForKey(i2)].hashCode() == iHashCode && this.backingArray[getArrayIndexForKey(i2)].equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String get(Object obj) {
        return (String) getValue((String) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String put(String str, String str2) {
        throw new UnsupportedOperationException("put() is not supported, use copyAndPut instead");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public String remove(Object obj) {
        throw new UnsupportedOperationException("remove() is not supported, use copyAndRemove instead");
    }

    private UnmodifiableArrayBackedMap(Object[] objArr) {
        this.numEntries = objArr != null ? ((Integer) objArr[0]).intValue() : 0;
        this.backingArray = objArr;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> void forEach(com.auto.exceldeps.log4j.util.BiConsumer<String, ? super V> biConsumer) {
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            biConsumer.accept((String) this.backingArray[getArrayIndexForKey(i2)], this.backingArray[getArrayIndexForValue(i2)]);
        }
    }

    UnmodifiableArrayBackedMap(UnmodifiableArrayBackedMap unmodifiableArrayBackedMap) {
        this.backingArray = unmodifiableArrayBackedMap.backingArray;
        this.numEntries = unmodifiableArrayBackedMap.numEntries;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V, S> void forEach(TriConsumer<String, ? super V, S> triConsumer, S s) {
        for (int i2 = 0; i2 < this.numEntries; i2++) {
            triConsumer.accept((String) this.backingArray[getArrayIndexForKey(i2)], this.backingArray[getArrayIndexForValue(i2)], s);
        }
    }
}
