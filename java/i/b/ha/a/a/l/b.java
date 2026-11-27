package i.b.ha.a.a.l;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b<K, V> extends a<K, V> implements Map.Entry<K, V> {
    protected b(K k2, V v) {
        super(k2, v);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }
}
