package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.util.internal.SerializationUtil;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@InternalApi
/* loaded from: classes.dex */
public class SortedArrayStringMap implements IndexedStringMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final String FROZEN = "Frozen collection cannot be modified";
    private static final int HASHVAL = 31;
    private static final long serialVersionUID = -5748905872274478116L;
    private boolean immutable;
    private transient boolean iterating;
    private transient String[] keys;
    private transient int size;
    private int threshold;
    private transient Object[] values;
    private static final TriConsumer<String, Object, StringMap> PUT_ALL = new TriConsumer() { // from class: com.auto.exceldeps.log4j.util.s
        @Override // com.auto.exceldeps.log4j.util.TriConsumer
        public final void accept(Object obj, Object obj2, Object obj3) {
            ((StringMap) obj3).putValue((String) obj, obj2);
        }
    };
    private static final String[] EMPTY = Strings.EMPTY_ARRAY;

    public SortedArrayStringMap() {
        this(4);
    }

    private void assertNoConcurrentModification() {
        if (this.iterating) {
            throw new ConcurrentModificationException();
        }
    }

    private void assertNotFrozen() {
        if (this.immutable) {
            throw new UnsupportedOperationException(FROZEN);
        }
    }

    private static int ceilingNextPowerOfTwo(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }

    private void ensureCapacity() {
        int i2 = this.size;
        int i3 = this.threshold;
        if (i2 >= i3) {
            resize(i3 * 2);
        }
    }

    private void inflateTable(int i2) {
        this.threshold = i2;
        this.keys = new String[i2];
        this.values = new Object[i2];
    }

    private void initFrom0(SortedArrayStringMap sortedArrayStringMap) {
        int length = this.keys.length;
        int i2 = sortedArrayStringMap.size;
        if (length < i2) {
            int i3 = sortedArrayStringMap.threshold;
            this.keys = new String[i3];
            this.values = new Object[i3];
        }
        System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, 0, i2);
        System.arraycopy(sortedArrayStringMap.values, 0, this.values, 0, sortedArrayStringMap.size);
        this.size = sortedArrayStringMap.size;
        this.threshold = sortedArrayStringMap.threshold;
    }

    private void insertAt(int i2, String str, Object obj) {
        ensureCapacity();
        String[] strArr = this.keys;
        int i3 = i2 + 1;
        System.arraycopy(strArr, i2, strArr, i3, this.size - i2);
        Object[] objArr = this.values;
        System.arraycopy(objArr, i2, objArr, i3, this.size - i2);
        this.keys[i2] = str;
        this.values[i2] = obj;
        this.size++;
    }

    private void merge(SortedArrayStringMap sortedArrayStringMap) {
        String[] strArr = this.keys;
        Object[] objArr = this.values;
        int i2 = sortedArrayStringMap.size + this.size;
        int iCeilingNextPowerOfTwo = ceilingNextPowerOfTwo(i2);
        this.threshold = iCeilingNextPowerOfTwo;
        if (this.keys.length < iCeilingNextPowerOfTwo) {
            this.keys = new String[iCeilingNextPowerOfTwo];
            this.values = new Object[iCeilingNextPowerOfTwo];
        }
        boolean z = false;
        if (sortedArrayStringMap.size() > size()) {
            System.arraycopy(strArr, 0, this.keys, sortedArrayStringMap.size, this.size);
            System.arraycopy(objArr, 0, this.values, sortedArrayStringMap.size, this.size);
            System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, 0, sortedArrayStringMap.size);
            System.arraycopy(sortedArrayStringMap.values, 0, this.values, 0, sortedArrayStringMap.size);
            this.size = sortedArrayStringMap.size;
        } else {
            System.arraycopy(strArr, 0, this.keys, 0, this.size);
            System.arraycopy(objArr, 0, this.values, 0, this.size);
            System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, this.size, sortedArrayStringMap.size);
            System.arraycopy(sortedArrayStringMap.values, 0, this.values, this.size, sortedArrayStringMap.size);
            z = true;
        }
        for (int i3 = this.size; i3 < i2; i3++) {
            int iIndexOfKey = indexOfKey(this.keys[i3]);
            if (iIndexOfKey < 0) {
                insertAt(~iIndexOfKey, this.keys[i3], this.values[i3]);
            } else if (z) {
                String[] strArr2 = this.keys;
                strArr2[iIndexOfKey] = strArr2[i3];
                Object[] objArr2 = this.values;
                objArr2[iIndexOfKey] = objArr2[i3];
            }
        }
        Arrays.fill(this.keys, this.size, i2, (Object) null);
        Arrays.fill(this.values, this.size, i2, (Object) null);
    }

    private int nullKeyIndex() {
        return (this.size <= 0 || this.keys[0] != null) ? -1 : 0;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        SerializationUtil.assertFiltered(objectInputStream);
        objectInputStream.defaultReadObject();
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        int i2 = objectInputStream.readInt();
        if (i2 < 0) {
            throw new InvalidObjectException("Illegal capacity: " + i2);
        }
        int i3 = objectInputStream.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Illegal mappings count: " + i3);
        }
        if (i3 > 0) {
            inflateTable(i2);
        } else {
            this.threshold = i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            this.keys[i4] = (String) objectInputStream.readObject();
            this.values[i4] = SerializationUtil.readWrappedObject(objectInputStream);
        }
        this.size = i3;
    }

    private void resize(int i2) {
        String[] strArr = this.keys;
        Object[] objArr = this.values;
        String[] strArr2 = new String[i2];
        this.keys = strArr2;
        this.values = new Object[i2];
        System.arraycopy(strArr, 0, strArr2, 0, this.size);
        System.arraycopy(objArr, 0, this.values, 0, this.size);
        this.threshold = i2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        String[] strArr = this.keys;
        if (strArr == EMPTY) {
            objectOutputStream.writeInt(ceilingNextPowerOfTwo(this.threshold));
        } else {
            objectOutputStream.writeInt(strArr.length);
        }
        objectOutputStream.writeInt(this.size);
        if (this.size > 0) {
            for (int i2 = 0; i2 < this.size; i2++) {
                objectOutputStream.writeObject(this.keys[i2]);
                Object[] objArr = this.values;
                SerializationUtil.writeWrappedObject(objArr[i2] instanceof Serializable ? (Serializable) objArr[i2] : null, objectOutputStream);
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public void clear() {
        if (this.keys == EMPTY) {
            return;
        }
        assertNotFrozen();
        assertNoConcurrentModification();
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        this.size = 0;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String str) {
        return indexOfKey(str) >= 0;
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SortedArrayStringMap)) {
            return false;
        }
        SortedArrayStringMap sortedArrayStringMap = (SortedArrayStringMap) obj;
        if (size() != sortedArrayStringMap.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size(); i2++) {
            if (!Objects.equals(this.keys[i2], sortedArrayStringMap.keys[i2]) || !Objects.equals(this.values[i2], sortedArrayStringMap.values[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> void forEach(BiConsumer<String, ? super V> biConsumer) {
        this.iterating = true;
        for (int i2 = 0; i2 < this.size; i2++) {
            try {
                biConsumer.accept(this.keys[i2], this.values[i2]);
            } finally {
                this.iterating = false;
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public void freeze() {
        this.immutable = true;
    }

    @Override // com.auto.exceldeps.log4j.util.IndexedReadOnlyStringMap
    public String getKeyAt(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            return null;
        }
        return this.keys[i2];
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String str) {
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey < 0) {
            return null;
        }
        return (V) this.values[iIndexOfKey];
    }

    @Override // com.auto.exceldeps.log4j.util.IndexedReadOnlyStringMap
    public <V> V getValueAt(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            return null;
        }
        return (V) this.values[i2];
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public int hashCode() {
        int i2 = this.size;
        return ((((1147 + i2) * 31) + hashCode(this.keys, i2)) * 31) + hashCode(this.values, this.size);
    }

    @Override // com.auto.exceldeps.log4j.util.IndexedReadOnlyStringMap
    public int indexOfKey(String str) {
        String[] strArr = this.keys;
        if (strArr == EMPTY) {
            return -1;
        }
        if (str == null) {
            return nullKeyIndex();
        }
        int i2 = this.size;
        int i3 = 0;
        if (i2 > 0 && strArr[0] == null) {
            i3 = 1;
        }
        return Arrays.binarySearch(strArr, i3, i2, str);
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public boolean isFrozen() {
        return this.immutable;
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public void putAll(ReadOnlyStringMap readOnlyStringMap) {
        if (readOnlyStringMap == this || readOnlyStringMap == null || readOnlyStringMap.isEmpty()) {
            return;
        }
        assertNotFrozen();
        assertNoConcurrentModification();
        if (!(readOnlyStringMap instanceof SortedArrayStringMap)) {
            if (readOnlyStringMap != null) {
                readOnlyStringMap.forEach(PUT_ALL, this);
            }
        } else if (this.size == 0) {
            initFrom0((SortedArrayStringMap) readOnlyStringMap);
        } else {
            merge((SortedArrayStringMap) readOnlyStringMap);
        }
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public void putValue(String str, Object obj) {
        assertNotFrozen();
        assertNoConcurrentModification();
        if (this.keys == EMPTY) {
            inflateTable(this.threshold);
        }
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey < 0) {
            insertAt(~iIndexOfKey, str, obj);
        } else {
            this.keys[iIndexOfKey] = str;
            this.values[iIndexOfKey] = obj;
        }
    }

    @Override // com.auto.exceldeps.log4j.util.StringMap
    public void remove(String str) {
        int iIndexOfKey;
        if (this.keys != EMPTY && (iIndexOfKey = indexOfKey(str)) >= 0) {
            assertNotFrozen();
            assertNoConcurrentModification();
            String[] strArr = this.keys;
            int i2 = iIndexOfKey + 1;
            System.arraycopy(strArr, i2, strArr, iIndexOfKey, (this.size - 1) - iIndexOfKey);
            Object[] objArr = this.values;
            System.arraycopy(objArr, i2, objArr, iIndexOfKey, (this.size - 1) - iIndexOfKey);
            String[] strArr2 = this.keys;
            int i3 = this.size;
            strArr2[i3 - 1] = null;
            this.values[i3 - 1] = null;
            this.size = i3 - 1;
        }
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        HashMap map = new HashMap(size());
        for (int i2 = 0; i2 < size(); i2++) {
            Object valueAt = getValueAt(i2);
            map.put(getKeyAt(i2), valueAt == null ? null : String.valueOf(valueAt));
        }
        return map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append('{');
        for (int i2 = 0; i2 < this.size; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.keys[i2]);
            sb.append(Chars.EQ);
            Object[] objArr = this.values;
            sb.append(objArr[i2] == this ? "(this map)" : objArr[i2]);
        }
        sb.append('}');
        return sb.toString();
    }

    public SortedArrayStringMap(int i2) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        if (i2 >= 0) {
            this.threshold = ceilingNextPowerOfTwo(i2 == 0 ? 1 : i2);
            return;
        }
        throw new IllegalArgumentException("Initial capacity must be at least zero but was " + i2);
    }

    private static int hashCode(Object[] objArr, int i2) {
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iHashCode = (iHashCode * 31) + (objArr[i3] == null ? 0 : objArr[i3].hashCode());
        }
        return iHashCode;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V, T> void forEach(TriConsumer<String, ? super V, T> triConsumer, T t) {
        this.iterating = true;
        for (int i2 = 0; i2 < this.size; i2++) {
            try {
                triConsumer.accept(this.keys[i2], this.values[i2], t);
            } finally {
                this.iterating = false;
            }
        }
    }

    public SortedArrayStringMap(ReadOnlyStringMap readOnlyStringMap) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        if (readOnlyStringMap instanceof SortedArrayStringMap) {
            initFrom0((SortedArrayStringMap) readOnlyStringMap);
        } else if (readOnlyStringMap != null) {
            resize(ceilingNextPowerOfTwo(readOnlyStringMap.size()));
            readOnlyStringMap.forEach(PUT_ALL, this);
        }
    }

    public SortedArrayStringMap(Map<String, ?> map) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        resize(ceilingNextPowerOfTwo(map.size()));
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            putValue(Objects.toString(entry.getKey(), null), entry.getValue());
        }
    }
}
