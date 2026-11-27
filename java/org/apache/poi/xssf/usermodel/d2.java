package org.apache.poi.xssf.usermodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

/* loaded from: classes.dex */
public class d2 implements n.a.a.n.d.n0 {
    private static final Pattern c = Pattern.compile("_x([0-9A-Fa-f]{4})_");
    private CTRst a;
    private n.a.a.q.b.i b;

    public d2(String str) {
        CTRst cTRstNewInstance = CTRst.Factory.newInstance();
        this.a = cTRstNewInstance;
        cTRstNewInstance.setT(str);
        b(this.a.xgetT());
    }

    protected static void b(STXstring sTXstring) {
        String stringValue = sTXstring.getStringValue();
        if (stringValue == null || stringValue.isEmpty()) {
            return;
        }
        char cCharAt = stringValue.charAt(0);
        char cCharAt2 = stringValue.charAt(stringValue.length() - 1);
        if (Character.isWhitespace(cCharAt) || Character.isWhitespace(cCharAt2)) {
            XmlCursor xmlCursorNewCursor = sTXstring.newCursor();
            try {
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.insertAttributeWithValue(new QName(XMLConstants.XML_NS_URI, "space"), "preserve");
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    private void c(CTFont cTFont, CTRPrElt cTRPrElt) {
        if (cTFont.sizeOfBArray() > 0) {
            cTRPrElt.addNewB().setVal(cTFont.getBArray(0).getVal());
        }
        if (cTFont.sizeOfUArray() > 0) {
            cTRPrElt.addNewU().setVal(cTFont.getUArray(0).getVal());
        }
        if (cTFont.sizeOfIArray() > 0) {
            cTRPrElt.addNewI().setVal(cTFont.getIArray(0).getVal());
        }
        if (cTFont.sizeOfColorArray() > 0) {
            CTColor colorArray = cTFont.getColorArray(0);
            CTColor cTColorAddNewColor = cTRPrElt.addNewColor();
            if (colorArray.isSetAuto()) {
                cTColorAddNewColor.setAuto(colorArray.getAuto());
            }
            if (colorArray.isSetIndexed()) {
                cTColorAddNewColor.setIndexed(colorArray.getIndexed());
            }
            if (colorArray.isSetRgb()) {
                cTColorAddNewColor.setRgb(colorArray.getRgb());
            }
            if (colorArray.isSetTheme()) {
                cTColorAddNewColor.setTheme(colorArray.getTheme());
            }
            if (colorArray.isSetTint()) {
                cTColorAddNewColor.setTint(colorArray.getTint());
            }
        }
        if (cTFont.sizeOfSzArray() > 0) {
            cTRPrElt.addNewSz().setVal(cTFont.getSzArray(0).getVal());
        }
        if (cTFont.sizeOfNameArray() > 0) {
            cTRPrElt.addNewRFont().setVal(cTFont.getNameArray(0).getVal());
        }
        if (cTFont.sizeOfFamilyArray() > 0) {
            cTRPrElt.addNewFamily().setVal(cTFont.getFamilyArray(0).getVal());
        }
        if (cTFont.sizeOfSchemeArray() > 0) {
            cTRPrElt.addNewScheme().setVal(cTFont.getSchemeArray(0).getVal());
        }
        if (cTFont.sizeOfCharsetArray() > 0) {
            cTRPrElt.addNewCharset().setVal(cTFont.getCharsetArray(0).getVal());
        }
        if (cTFont.sizeOfCondenseArray() > 0) {
            cTRPrElt.addNewCondense().setVal(cTFont.getCondenseArray(0).getVal());
        }
        if (cTFont.sizeOfExtendArray() > 0) {
            cTRPrElt.addNewExtend().setVal(cTFont.getExtendArray(0).getVal());
        }
        if (cTFont.sizeOfVertAlignArray() > 0) {
            cTRPrElt.addNewVertAlign().setVal(cTFont.getVertAlignArray(0).getVal());
        }
        if (cTFont.sizeOfOutlineArray() > 0) {
            cTRPrElt.addNewOutline().setVal(cTFont.getOutlineArray(0).getVal());
        }
        if (cTFont.sizeOfShadowArray() > 0) {
            cTRPrElt.addNewShadow().setVal(cTFont.getShadowArray(0).getVal());
        }
        if (cTFont.sizeOfStrikeArray() > 0) {
            cTRPrElt.addNewStrike().setVal(cTFont.getStrikeArray(0).getVal());
        }
    }

    static String e(String str) {
        if (str == null || !str.contains("_x")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = c.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            int iStart = matcher.start();
            if (iStart > iEnd) {
                sb.append((CharSequence) str, iEnd, iStart);
            }
            sb.append((char) Integer.decode("0x" + matcher.group(1)).intValue());
            iEnd = matcher.end();
        }
        if (iEnd == 0) {
            return str;
        }
        sb.append(str.substring(iEnd));
        return sb.toString();
    }

    public CTRst a() {
        return this.a;
    }

    protected void d(n.a.a.q.b.i iVar) {
        this.b = iVar;
        if (this.a.sizeOfRArray() > 0) {
            for (CTRElt cTRElt : this.a.getRArray()) {
                CTRPrElt rPr = cTRElt.getRPr();
                if (rPr != null && rPr.sizeOfRFontArray() > 0) {
                    String val = rPr.getRFontArray(0).getVal();
                    if (val.startsWith("#")) {
                        p1 fontAt = this.b.getFontAt(Integer.parseInt(val.substring(1)));
                        rPr.removeRFont(0);
                        c(fontAt.b(), rPr);
                    }
                }
            }
        }
    }

    @Override // n.a.a.n.d.n0
    public String getString() {
        if (this.a.sizeOfRArray() == 0) {
            return e(this.a.getT());
        }
        StringBuilder sb = new StringBuilder();
        for (CTRElt cTRElt : this.a.getRArray()) {
            sb.append(cTRElt.getT());
        }
        return e(sb.toString());
    }

    public String toString() {
        String string = getString();
        return string == null ? "" : string;
    }

    public d2(CTRst cTRst) {
        this.a = cTRst;
    }
}
