package i.e.a.j;

/* loaded from: classes.dex */
final class h {
    private final w a;
    private final h b;

    public h(w wVar, h hVar) {
        this.a = wVar;
        this.b = hVar;
    }

    public w a(char[] cArr, int i2, int i3, int i4) {
        h hVarB = this;
        do {
            w wVar = hVarB.a;
            if (wVar.w(cArr, i2, i3, i4)) {
                return wVar;
            }
            hVarB = hVarB.b();
        } while (hVarB != null);
        return null;
    }

    public h b() {
        return this.b;
    }

    public w c() {
        return this.a;
    }
}
