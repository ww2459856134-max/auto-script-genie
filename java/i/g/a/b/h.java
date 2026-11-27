package i.g.a.b;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes.dex */
public interface h extends XmlString {
    public static final SimpleTypeFactory<h> v;
    public static final SchemaType w;
    public static final g x;

    static {
        SimpleTypeFactory<h> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "ststrokejoinstyle3c13type");
        v = simpleTypeFactory;
        w = simpleTypeFactory.getType();
        g.a("round");
        g.a("bevel");
        x = g.a("miter");
    }
}
