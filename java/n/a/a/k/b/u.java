package n.a.a.k.b;

import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import n.a.a.o.r1;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

/* loaded from: classes.dex */
public abstract class u {
    public static boolean a(Document document, OutputStream outputStream) throws TransformerException, DOMException, IllegalArgumentException {
        try {
            document.setXmlStandalone(true);
            Transformer transformerM = r1.m();
            DOMSource dOMSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new t(outputStream));
            transformerM.setOutputProperty("encoding", "UTF-8");
            transformerM.setOutputProperty("indent", "no");
            transformerM.setOutputProperty("standalone", "yes");
            transformerM.transform(dOMSource, streamResult);
            return true;
        } catch (TransformerException unused) {
            return false;
        }
    }
}
