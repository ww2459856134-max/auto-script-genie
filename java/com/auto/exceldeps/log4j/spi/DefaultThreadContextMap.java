package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.internal.map.UnmodifiableArrayBackedMap;
import com.auto.exceldeps.log4j.util.BiConsumer;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import com.auto.exceldeps.log4j.util.ReadOnlyStringMap;
import com.auto.exceldeps.log4j.util.TriConsumer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class DefaultThreadContextMap implements ThreadContextMap, ReadOnlyStringMap {
    public static final String INHERITABLE_MAP = "isThreadContextMapInheritable";
    private static final long serialVersionUID = -2635197170958057849L;
    private ThreadLocal<Object[]> localState;

    public DefaultThreadContextMap() {
        this(PropertiesUtil.getProperties());
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void clear() {
        this.localState.remove();
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap, com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String str) {
        Object[] objArr = this.localState.get();
        return objArr != null && UnmodifiableArrayBackedMap.getMap(objArr).containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ThreadContextMap)) {
            return Objects.equals(UnmodifiableArrayBackedMap.getMap(this.localState.get()), ((ThreadContextMap) obj).getImmutableMapOrNull());
        }
        return false;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> void forEach(BiConsumer<String, ? super V> biConsumer) {
        Object[] objArr = this.localState.get();
        if (objArr == null) {
            return;
        }
        UnmodifiableArrayBackedMap.getMap(objArr).forEach((BiConsumer) biConsumer);
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public String get(String str) {
        Object[] objArr = this.localState.get();
        if (objArr == null) {
            return null;
        }
        return UnmodifiableArrayBackedMap.getMap(objArr).get((Object) str);
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public Map<String, String> getCopy() {
        Object[] objArr = this.localState.get();
        return objArr == null ? new HashMap(0) : new HashMap(UnmodifiableArrayBackedMap.getMap(objArr));
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public Map<String, String> getImmutableMapOrNull() {
        Object[] objArr = this.localState.get();
        if (objArr == null) {
            return null;
        }
        return UnmodifiableArrayBackedMap.getMap(objArr);
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String str) {
        return (V) get(str);
    }

    public int hashCode() {
        Object[] objArr = this.localState.get();
        return 31 + (objArr == null ? 0 : UnmodifiableArrayBackedMap.getMap(objArr).hashCode());
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap, com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void put(String str, String str2) {
        this.localState.set(UnmodifiableArrayBackedMap.getMap(this.localState.get()).copyAndPut(str, str2).getBackingArray());
    }

    public void putAll(Map<String, String> map) {
        this.localState.set(UnmodifiableArrayBackedMap.getMap(this.localState.get()).copyAndPutAll(map).getBackingArray());
    }

    @Override // com.auto.exceldeps.log4j.spi.ThreadContextMap
    public void remove(String str) {
        Object[] objArr = this.localState.get();
        if (objArr != null) {
            this.localState.set(UnmodifiableArrayBackedMap.getMap(objArr).copyAndRemove(str).getBackingArray());
        }
    }

    public void removeAll(Iterable<String> iterable) {
        Object[] objArr = this.localState.get();
        if (objArr != null) {
            this.localState.set(UnmodifiableArrayBackedMap.getMap(objArr).copyAndRemoveAll(iterable).getBackingArray());
        }
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap, java.util.Map
    public int size() {
        return UnmodifiableArrayBackedMap.getMap(this.localState.get()).size();
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        return getCopy();
    }

    public String toString() {
        Object[] objArr = this.localState.get();
        return objArr == null ? "{}" : UnmodifiableArrayBackedMap.getMap(objArr).toString();
    }

    @Deprecated
    public DefaultThreadContextMap(boolean z) {
        this(PropertiesUtil.getProperties());
    }

    DefaultThreadContextMap(PropertiesUtil propertiesUtil) {
        ThreadLocal<Object[]> threadLocal;
        if (propertiesUtil.getBooleanProperty(INHERITABLE_MAP)) {
            threadLocal = new InheritableThreadLocal<Object[]>() { // from class: com.auto.exceldeps.log4j.spi.DefaultThreadContextMap.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.InheritableThreadLocal
                public Object[] childValue(Object[] objArr) {
                    return objArr;
                }
            };
        } else {
            threadLocal = new ThreadLocal<>();
        }
        this.localState = threadLocal;
    }

    @Override // com.auto.exceldeps.log4j.util.ReadOnlyStringMap
    public <V, S> void forEach(TriConsumer<String, ? super V, S> triConsumer, S s) {
        Object[] objArr = this.localState.get();
        if (objArr == null) {
            return;
        }
        UnmodifiableArrayBackedMap.getMap(objArr).forEach(triConsumer, s);
    }
}
