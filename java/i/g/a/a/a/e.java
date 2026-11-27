package i.g.a.a.a;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes.dex */
public interface e extends XmlObject {

    /* renamed from: n, reason: collision with root package name */
    public static final DocumentFactory<e> f1728n;

    /* renamed from: o, reason: collision with root package name */
    public static final SchemaType f1729o;

    static {
        DocumentFactory<e> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "shapelayoutebb0doctype");
        f1728n = documentFactory;
        f1729o = documentFactory.getType();
    }

    b i();
}
