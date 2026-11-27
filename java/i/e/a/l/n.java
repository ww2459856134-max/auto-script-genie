package i.e.a.l;

/* loaded from: classes.dex */
public final class n {
    private l a = null;

    private void b() {
        this.a = new l();
    }

    public synchronized String a(char[] cArr, int i2) {
        m mVar = new m(cArr, i2);
        l lVar = this.a;
        if (lVar == null) {
            b();
        } else {
            String str = lVar.get(mVar);
            if (str != null) {
                return str;
            }
        }
        m mVarB = mVar.b();
        String strIntern = new String(cArr, 0, i2).intern();
        this.a.put(mVarB, strIntern);
        return strIntern;
    }
}
