package n.a.a.j;

import java.util.Collections;
import java.util.HashMap;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes.dex */
public abstract class m {
    public static final XmlOptions a;

    static {
        XmlOptions xmlOptions = new XmlOptions();
        a = xmlOptions;
        xmlOptions.setSaveOuter();
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setCharacterEncoding("UTF-8");
        xmlOptions.setDisallowDocTypeDeclaration(true);
        xmlOptions.setEntityExpansionLimit(1);
        xmlOptions.setLoadStripProcinsts(true);
        xmlOptions.setLoadStripComments(true);
        HashMap map = new HashMap();
        map.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        map.put("http://schemas.openxmlformats.org/drawingml/2006/chart", "c");
        map.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        map.put("http://schemas.openxmlformats.org/markup-compatibility/2006", "ve");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "r");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vt");
        map.put("http://schemas.openxmlformats.org/presentationml/2006/main", "p");
        map.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        map.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        map.put("urn:schemas-microsoft-com:office:office", "o");
        map.put("urn:schemas-microsoft-com:office:excel", "x");
        map.put("urn:schemas-microsoft-com:office:word", "w10");
        map.put("urn:schemas-microsoft-com:vml", "v");
        map.put("http://schemas.microsoft.com/office/word/2010/wordml", "w14");
        map.put("http://schemas.microsoft.com/office/word/2012/wordml", "w15");
        map.put("http://schemas.microsoft.com/office/drawing/2012/chart", "c15");
        xmlOptions.setSaveSuggestedPrefixes(Collections.unmodifiableMap(map));
    }
}
