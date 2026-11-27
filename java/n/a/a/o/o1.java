package n.a.a.o;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.LogBuilder;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes.dex */
class o1 implements ErrorHandler {
    private final boolean a;

    public o1(boolean z) {
        this.a = z;
    }

    private void a(Level level, SAXParseException sAXParseException) {
        int iLastIndexOf;
        String systemId = sAXParseException.getSystemId();
        if (systemId != null && (iLastIndexOf = systemId.lastIndexOf(47)) != -1) {
            systemId = systemId.substring(iLastIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        if (systemId == null) {
            systemId = "";
        }
        sb.append(systemId);
        sb.append(NameUtil.COLON);
        sb.append(sAXParseException.getLineNumber());
        sb.append(NameUtil.COLON);
        sb.append(sAXParseException.getColumnNumber());
        sb.append(NameUtil.COLON);
        sb.append(sAXParseException.getMessage());
        String string = sb.toString();
        LogBuilder logBuilderAtLevel = r1.b.atLevel(level);
        if (this.a) {
            logBuilderAtLevel = logBuilderAtLevel.withThrowable(sAXParseException);
        }
        logBuilderAtLevel.log(string);
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        a(Level.ERROR, sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        a(Level.FATAL, sAXParseException);
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        a(Level.WARN, sAXParseException);
    }
}
