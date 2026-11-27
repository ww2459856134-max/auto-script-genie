package n.a.a.r.a;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;

/* loaded from: classes.dex */
public class d1 implements d0 {
    private final CTSdtContentCell a;
    private String b;

    public d1(CTSdtContentCell cTSdtContentCell, k1 k1Var, y yVar) {
        this.a = cTSdtContentCell;
    }

    private String a() {
        if (this.a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        XmlCursor xmlCursorNewCursor = this.a.newCursor();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (xmlCursorNewCursor.hasNextToken() && i2 > 0) {
            try {
                if (xmlCursorNewCursor.toNextToken().isText()) {
                    sb.append(xmlCursorNewCursor.getTextValue());
                } else if (b(xmlCursorNewCursor, "tr")) {
                    i3 = 0;
                    i4 = 0;
                } else if (b(xmlCursorNewCursor, "tc")) {
                    int i5 = i3 + 1;
                    if (i3 > 0) {
                        sb.append("\t");
                    }
                    i3 = i5;
                    i4 = 0;
                } else if (b(xmlCursorNewCursor, "p") || b(xmlCursorNewCursor, "tbl") || b(xmlCursorNewCursor, "sdt")) {
                    if (i4 > 0) {
                        sb.append("\n");
                    }
                    i4++;
                }
                if (xmlCursorNewCursor.isStart()) {
                    i2++;
                } else if (xmlCursorNewCursor.isEnd()) {
                    i2--;
                }
            } finally {
            }
        }
        String string = sb.toString();
        if (xmlCursorNewCursor != null) {
            xmlCursorNewCursor.close();
        }
        return string;
    }

    private boolean b(XmlCursor xmlCursor, String str) {
        QName name;
        return xmlCursor.isStart() && (name = xmlCursor.getName()) != null && name.getLocalPart() != null && name.getLocalPart().equals(str);
    }

    @Override // n.a.a.r.a.d0
    public String getText() {
        if (this.b == null) {
            this.b = a();
        }
        return this.b;
    }

    public String toString() {
        return getText();
    }
}
