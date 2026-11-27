package i.b.ha.a.a.m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c<K, V> extends a<K, V> implements Serializable {
    private final int e;

    public c() {
        this(16, 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i.b.ha.a.a.m.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ArrayList<V> i() {
        return new ArrayList<>(this.e);
    }

    public c(int i2, int i3) {
        super(new HashMap(i2));
        this.e = i3;
    }
}
