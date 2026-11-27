package i.f.a.y.r.g;

import java.util.List;

/* loaded from: classes.dex */
abstract class a {
    static i.f.a.v.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        i.f.a.v.a aVar = new i.f.a.v.a(size * 12);
        int i2 = 0;
        int iB = list.get(0).c().b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iB) != 0) {
                aVar.p(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int iB2 = bVar.b().b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & iB2) != 0) {
                    aVar.p(i2);
                }
                i2++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & iB3) != 0) {
                        aVar.p(i2);
                    }
                    i2++;
                }
            }
        }
        return aVar;
    }
}
