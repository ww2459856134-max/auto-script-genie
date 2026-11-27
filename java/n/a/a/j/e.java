package n.a.a.j;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.util.Iterator;
import n.a.a.k.b.q;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes.dex */
public abstract class e {
    private static final Logger LOGGER = n.a.a.i.b.a(e.class);

    public c createDocumentPart(c cVar, n.a.a.k.b.m mVar) {
        q packageRelationship = getPackageRelationship(cVar, mVar);
        String strB = packageRelationship.b();
        l descriptor = getDescriptor(strB);
        if (descriptor != null) {
            try {
                if (!b.PACK_OBJECT_REL_TYPE.equals(strB)) {
                    k kVarG = descriptor.g();
                    if (kVarG != null) {
                        return kVarG.a(cVar, mVar);
                    }
                    j jVarF = descriptor.f();
                    if (jVarF != null) {
                        return jVarF.a(mVar);
                    }
                }
            } catch (IOException | XmlException e) {
                throw new d(e.getMessage(), e);
            }
        }
        LOGGER.atDebug().log("using default POIXMLDocumentPart for {}", packageRelationship.b());
        return new c(cVar, mVar);
    }

    protected abstract l getDescriptor(String str);

    protected q getPackageRelationship(c cVar, n.a.a.k.b.m mVar) {
        try {
            String strF = mVar.r().f();
            Iterator<q> it = cVar.getPackagePart().u().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next.e().toASCIIString().equalsIgnoreCase(strF)) {
                    return next;
                }
            }
            throw new d("package part isn't a child of the parent document.");
        } catch (n.a.a.k.a.a e) {
            throw new d("error while determining package relations", e);
        }
    }

    public c newDocumentPart(l lVar) {
        if (lVar == null || lVar.e() == null) {
            throw new d("can't initialize POIXMLDocumentPart");
        }
        return lVar.e().a();
    }
}
