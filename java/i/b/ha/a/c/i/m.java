package i.b.ha.a.c.i;

import java.io.IOException;

@FunctionalInterface
/* loaded from: classes.dex */
public interface m<T> {
    static {
        i iVar = new m() { // from class: i.b.ha.a.c.i.i
            @Override // i.b.ha.a.c.i.m
            public final void accept(Object obj) throws IOException {
                m.a(obj);
            }
        };
    }

    static /* synthetic */ void a(Object obj) throws IOException {
    }

    void accept(T t) throws IOException;
}
