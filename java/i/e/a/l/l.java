package i.e.a.l;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class l extends LinkedHashMap<m, String> {
    public l() {
        super(64, 0.7f, true);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<m, String> entry) {
        return size() >= 716;
    }
}
