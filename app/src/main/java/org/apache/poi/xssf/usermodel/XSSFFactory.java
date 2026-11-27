package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
public class XSSFFactory extends n.a.a.j.e {
    private static final XSSFFactory inst = new XSSFFactory();

    protected XSSFFactory() {
    }

    public static XSSFFactory getInstance() {
        return inst;
    }

    @Override // n.a.a.j.e
    protected n.a.a.j.l getDescriptor(String str) {
        return c2.i(str);
    }
}
