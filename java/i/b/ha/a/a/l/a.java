package i.b.ha.a.a.l;

import com.auto.exceldeps.log4j.util.Chars;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<K, V>] */
/* loaded from: classes.dex */
public abstract class a<K, V> {
    private K c;
    private V d;

    protected a(K k2, V v) {
        this.c = k2;
        this.d = v;
    }

    public K getKey() {
        return this.c;
    }

    public V getValue() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(Chars.EQ);
        sb.append(getValue());
        return sb.toString();
    }
}
