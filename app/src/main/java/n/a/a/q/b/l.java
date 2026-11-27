package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.j.m;
import org.apache.poi.xssf.usermodel.e1;
import org.apache.poi.xssf.usermodel.u0;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* loaded from: classes.dex */
public class l extends n.a.a.j.c {
    private u0 a;
    private ThemeDocument b;

    public l() {
        ThemeDocument themeDocumentNewInstance = ThemeDocument.Factory.newInstance();
        this.b = themeDocumentNewInstance;
        themeDocumentNewInstance.addNewTheme().addNewThemeElements();
    }

    public e1 I(int i2) {
        CTColor lt1;
        byte[] lastClr;
        CTColorScheme clrScheme = this.b.getTheme().getThemeElements().getClrScheme();
        switch (j.a[k.a(i2).ordinal()]) {
            case 1:
                lt1 = clrScheme.getLt1();
                break;
            case 2:
                lt1 = clrScheme.getDk1();
                break;
            case 3:
                lt1 = clrScheme.getLt2();
                break;
            case 4:
                lt1 = clrScheme.getDk2();
                break;
            case 5:
                lt1 = clrScheme.getAccent1();
                break;
            case 6:
                lt1 = clrScheme.getAccent2();
                break;
            case 7:
                lt1 = clrScheme.getAccent3();
                break;
            case 8:
                lt1 = clrScheme.getAccent4();
                break;
            case 9:
                lt1 = clrScheme.getAccent5();
                break;
            case 10:
                lt1 = clrScheme.getAccent6();
                break;
            case 11:
                lt1 = clrScheme.getHlink();
                break;
            case 12:
                lt1 = clrScheme.getFolHlink();
                break;
            default:
                return null;
        }
        if (lt1.isSetSrgbClr()) {
            lastClr = lt1.getSrgbClr().getVal();
        } else {
            if (!lt1.isSetSysClr()) {
                return null;
            }
            lastClr = lt1.getSysClr().getLastClr();
        }
        return new e1(lastClr, this.a);
    }

    public void J(e1 e1Var) {
        if (e1Var != null && e1Var.h().isSetTheme()) {
            e1Var.h().setRgb(I(e1Var.j()).h().getRgb());
        }
    }

    public void K(InputStream inputStream) throws IOException {
        try {
            this.b = ThemeDocument.Factory.parse(inputStream, m.a);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    protected void L(u0 u0Var) {
        this.a = u0Var;
    }

    public void M(OutputStream outputStream) throws IOException {
        this.b.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            M(outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public l(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            K(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
