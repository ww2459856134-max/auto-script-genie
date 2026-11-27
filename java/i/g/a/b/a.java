package i.g.a.b;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes.dex */
public interface a extends XmlObject {
    public static final DocumentFactory<a> p;
    public static final SchemaType q;

    static {
        DocumentFactory<a> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgroup2b13type");
        p = documentFactory;
        q = documentFactory.getType();
    }

    c m();
}
