package i.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class q8 {
    private final String a;
    private final List<p8> b;

    public q8(String str, List<p8> list) {
        this.a = str == null ? "" : str;
        this.b = list == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
    }

    public p8 a(String str) {
        if (str == null) {
            return null;
        }
        for (p8 p8Var : this.b) {
            if (p8Var.a.contains(str)) {
                return p8Var;
            }
        }
        return null;
    }

    public String b() {
        return this.a;
    }
}
