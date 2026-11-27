package n.a.a.k.b;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterator;
import java.util.TreeMap;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public final class r implements Iterable<q> {

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f2284j = n.a.a.i.b.a(r.class);
    private final TreeMap<String, q> c;
    private final HashMap<String, q> d;
    private m e;
    private m f;
    private o g;

    /* renamed from: h, reason: collision with root package name */
    private k f2285h;

    /* renamed from: i, reason: collision with root package name */
    private int f2286i;

    r() {
        this.c = new TreeMap<>();
        this.d = new HashMap<>();
        this.f2286i = -1;
    }

    private static o j(m mVar) throws n.a.a.k.a.b {
        return s.g(mVar == null ? s.g : mVar.r());
    }

    public q a(URI uri, v vVar, String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            if (this.f2286i == -1) {
                this.f2286i = size() + 1;
            }
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("rId");
                int i2 = this.f2286i;
                this.f2286i = i2 + 1;
                sb.append(i2);
                str2 = sb.toString();
            } while (this.c.get(str2) != null);
        }
        q qVar = new q(this.f2285h, this.f, uri, vVar, str, str2);
        b(qVar);
        if (vVar == v.INTERNAL) {
            this.d.put(uri.toASCIIString(), qVar);
        }
        return qVar;
    }

    public void b(q qVar) {
        if (qVar != null && qVar.a() != null && !qVar.a().isEmpty()) {
            this.c.put(qVar.a(), qVar);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid relationship part/id: ");
        sb.append(qVar == null ? "<null>" : qVar.a());
        sb.append(" for relationship: ");
        sb.append(qVar);
        throw new IllegalArgumentException(sb.toString());
    }

    public void clear() {
        this.c.clear();
        this.d.clear();
    }

    public q e(m mVar) {
        return this.d.get(mVar.r().f());
    }

    public q g(int i2) {
        if (i2 < 0 || i2 > this.c.values().size()) {
            throw new IllegalArgumentException("index");
        }
        int i3 = 0;
        for (q qVar : this.c.values()) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return qVar;
            }
            i3 = i4;
        }
        return null;
    }

    public q h(String str) {
        if (str != null) {
            return this.c.get(str);
        }
        throw new IllegalArgumentException("Cannot read relationship, provided ID is empty: " + str + ", having relationships: " + this.c.keySet());
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<q> iterator() {
        return this.c.values().iterator();
    }

    public r k(String str) {
        return new r(this, str);
    }

    public void l(m mVar) throws DOMException, n.a.a.k.a.a, IOException {
        try {
            f2284j.atDebug().log("Parsing relationship: {}", mVar.r());
            InputStream inputStreamM = mVar.m();
            try {
                Document documentD = n.a.a.j.o.a.d(inputStreamM);
                if (inputStreamM != null) {
                    inputStreamM.close();
                }
                NodeList elementsByTagNameNS = documentD.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
                int length = elementsByTagNameNS.getLength();
                boolean z = false;
                for (int i2 = 0; i2 < length; i2++) {
                    Element element = (Element) elementsByTagNameNS.item(i2);
                    String attribute = element.getAttribute("Id");
                    String attribute2 = element.getAttribute("Type");
                    if (attribute2.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties")) {
                        if (z) {
                            throw new n.a.a.k.a.a("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package !");
                        }
                        z = true;
                    }
                    Attr attributeNode = element.getAttributeNode("TargetMode");
                    v vVar = v.INTERNAL;
                    if (attributeNode != null && !attributeNode.getValue().toLowerCase(Locale.ROOT).equals("internal")) {
                        vVar = v.EXTERNAL;
                    }
                    URI uriN = s.n("http://invalid.uri");
                    String attribute3 = element.getAttribute("Target");
                    try {
                        uriN = s.n(attribute3);
                    } catch (URISyntaxException e) {
                        f2284j.atError().withThrowable(e).log("Cannot convert {} in a valid relationship URI-> dummy-URI used", attribute3);
                    }
                    a(uriN, vVar, attribute2, attribute);
                }
            } finally {
            }
        } catch (Exception e2) {
            throw new n.a.a.k.a.a("Failed to parse relationships", e2);
        }
    }

    public void p(String str) {
        q qVar = this.c.get(str);
        if (qVar != null) {
            this.c.remove(qVar.a());
            this.d.values().remove(qVar);
        }
    }

    public int size() {
        return this.c.size();
    }

    @Override // java.lang.Iterable
    public Spliterator<q> spliterator() {
        return this.c.values().spliterator();
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4 = this.c.size() + " relationship(s) = [";
        m mVar = this.e;
        if (mVar == null || mVar.d == null) {
            str = str4 + "relationshipPart=null";
        } else {
            str = str4 + this.e.d;
        }
        m mVar2 = this.f;
        if (mVar2 == null || mVar2.d == null) {
            str2 = str + ",sourcePart=null";
        } else {
            str2 = str + "," + this.f.d;
        }
        if (this.g != null) {
            str3 = str2 + "," + this.g;
        } else {
            str3 = str2 + ",uri=null)";
        }
        return str3 + "]";
    }

    public r(r rVar, String str) {
        this();
        for (q qVar : rVar.c.values()) {
            if (str == null || qVar.b().equals(str)) {
                b(qVar);
            }
        }
    }

    public r(k kVar) throws n.a.a.k.a.a {
        this(kVar, (m) null);
    }

    public r(m mVar) throws n.a.a.k.a.a {
        this(mVar.c, mVar);
    }

    public r(k kVar, m mVar) throws DOMException, n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        this.c = new TreeMap<>();
        this.d = new HashMap<>();
        this.f2286i = -1;
        if (kVar != null) {
            if (mVar != null && mVar.B()) {
                throw new IllegalArgumentException("part");
            }
            this.f2285h = kVar;
            this.f = mVar;
            this.g = j(mVar);
            if (kVar.y() == l.WRITE || !kVar.n(this.g)) {
                return;
            }
            m mVarB = kVar.B(this.g);
            this.e = mVarB;
            l(mVarB);
            return;
        }
        throw new IllegalArgumentException("container needs to be specified");
    }
}
