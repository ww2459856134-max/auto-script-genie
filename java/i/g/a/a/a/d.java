package i.g.a.a.a;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes.dex */
public interface d extends XmlString {
    public static final SimpleTypeFactory<d> b;

    /* renamed from: l, reason: collision with root package name */
    public static final SchemaType f1726l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f1727m;

    static {
        SimpleTypeFactory<d> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stconnecttype97adtype");
        b = simpleTypeFactory;
        f1726l = simpleTypeFactory.getType();
        c.a("none");
        f1727m = c.a("rect");
        c.a("segments");
        c.a("custom");
    }
}
