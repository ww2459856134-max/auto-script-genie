package i.g.a.b;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes.dex */
public interface f extends XmlString {
    public static final SimpleTypeFactory<f> r;
    public static final SchemaType s;
    public static final e u;

    static {
        SimpleTypeFactory<f> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stext2fe5type");
        r = simpleTypeFactory;
        s = simpleTypeFactory.getType();
        e.a("view");
        u = e.a("edit");
        e.a("backwardCompatible");
    }
}
