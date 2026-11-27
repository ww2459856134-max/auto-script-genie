package n.a.a.j;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n.a.a.k.b.o;
import n.a.a.k.b.q;
import n.a.a.k.b.r;
import n.a.a.k.b.s;
import n.a.a.k.b.v;
import n.a.a.r.a.y0;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes.dex */
public class c {
    private static final Logger LOG = n.a.a.i.b.a(c.class);
    private String coreDocumentRel;
    private boolean isCommitted;
    private n.a.a.k.b.m packagePart;
    private c parent;
    private final Map<String, n> referenceRelationships;
    private int relationCounter;
    private final Map<String, a> relations;

    public static class a {
        private final q a;
        private final c b;

        a(q qVar, c cVar) {
            this.a = qVar;
            this.b = cVar;
        }

        public <T extends c> T a() {
            return (T) this.b;
        }

        public q b() {
            return this.a;
        }
    }

    public c(n.a.a.k.b.k kVar) {
        this(kVar, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
    }

    private void F(q qVar, c cVar) {
        this.relations.put(qVar.a(), new a(qVar, cVar));
        cVar.incrementRelationCounter();
    }

    private static n.a.a.k.b.m G(n.a.a.k.b.k kVar, String str) {
        try {
            q qVarG = kVar.L(str).g(0);
            if (qVarG == null) {
                if (kVar.L("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").g(0) != null) {
                    kVar.b0();
                    throw new d("Strict OOXML isn't currently supported, please see bug #57699");
                }
                kVar.b0();
                throw new d("OOXML file structure broken/invalid - no core document found!");
            }
            n.a.a.k.b.m mVarD = kVar.D(qVarG);
            if (mVarD != null) {
                return mVarD;
            }
            kVar.b0();
            throw new d("OOXML file structure broken/invalid - core document '" + qVarG.e() + "' not found.");
        } catch (d e) {
            throw e;
        } catch (RuntimeException e2) {
            kVar.b0();
            throw new d("OOXML file structure broken/invalid", e2);
        }
    }

    private boolean H(String str, boolean z) throws n.a.a.k.a.b {
        a aVar = this.relations.get(str);
        if (aVar == null) {
            return false;
        }
        c cVarA = aVar.a();
        cVarA.decrementRelationCounter();
        getPackagePart().D(str);
        this.relations.remove(str);
        if (!z || cVarA.getRelationCounter() != 0) {
            return true;
        }
        try {
            cVarA.onDocumentRemove();
            getPackagePart().q().Y(cVarA.getPackagePart());
            return true;
        } catch (IOException e) {
            throw new d(e);
        }
    }

    public final a addRelation(String str, l lVar, c cVar) throws n.a.a.k.a.b {
        q qVarK = this.packagePart.k(cVar.getPackagePart());
        if (qVarK == null) {
            qVarK = this.packagePart.f(cVar.getPackagePart().r(), v.INTERNAL, lVar.h(), str);
        }
        F(qVarK, cVar);
        return new a(qVarK, cVar);
    }

    protected void commit() throws IOException {
    }

    public final n.a.a.j.a createHyperlink(URI uri, boolean z, String str) throws n.a.a.k.a.b {
        this.packagePart.d(uri, z ? v.EXTERNAL : v.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", str);
        n.a.a.j.a aVar = new n.a.a.j.a(this, uri, z, str);
        this.referenceRelationships.put(str, aVar);
        return aVar;
    }

    public final c createRelationship(l lVar, e eVar) {
        return createRelationship(lVar, eVar, -1, false).a();
    }

    int decrementRelationCounter() {
        int i2 = this.relationCounter - 1;
        this.relationCounter = i2;
        return i2;
    }

    public final int getNextPartNumber(l lVar, int i2) {
        n.a.a.k.b.k kVarQ = this.packagePart.q();
        try {
            String strC = lVar.c();
            if (strC.equals(lVar.d(9999))) {
                return kVarQ.n(s.b(strC)) ? -1 : 0;
            }
            int size = i2 + kVarQ.F().size();
            for (int i3 = i2 < 0 ? 1 : i2; i3 <= size; i3++) {
                if (!kVarQ.n(s.b(lVar.d(i3)))) {
                    return i3;
                }
            }
            return -1;
        } catch (n.a.a.k.a.a e) {
            throw new d(e);
        }
    }

    public final n.a.a.k.b.m getPackagePart() {
        return this.packagePart;
    }

    public final c getParent() {
        return this.parent;
    }

    public final n getReferenceRelationship(String str) {
        return this.referenceRelationships.get(str);
    }

    public final List<n> getReferenceRelationships() {
        return Collections.unmodifiableList(new ArrayList(this.referenceRelationships.values()));
    }

    public final c getRelationById(String str) {
        a relationPartById = getRelationPartById(str);
        if (relationPartById == null) {
            return null;
        }
        return relationPartById.a();
    }

    int getRelationCounter() {
        return this.relationCounter;
    }

    public final String getRelationId(c cVar) {
        for (a aVar : this.relations.values()) {
            if (aVar.a() == cVar) {
                return aVar.b().a();
            }
        }
        return null;
    }

    public final a getRelationPartById(String str) {
        return this.relations.get(str);
    }

    public final List<a> getRelationParts() {
        return Collections.unmodifiableList(new ArrayList(this.relations.values()));
    }

    public final List<c> getRelations() {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.relations.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    protected n.a.a.k.b.m getTargetPart(q qVar) throws n.a.a.k.a.a {
        return getPackagePart().s(qVar);
    }

    int incrementRelationCounter() {
        int i2 = this.relationCounter + 1;
        this.relationCounter = i2;
        return i2;
    }

    public boolean isCommitted() {
        return this.isCommitted;
    }

    protected void onDocumentCreate() throws IOException {
    }

    protected void onDocumentRead() throws IOException {
        throw null;
    }

    protected void onDocumentRemove() throws IOException {
    }

    protected final void onSave(Set<n.a.a.k.b.m> set) throws IOException {
        if (this.isCommitted) {
            return;
        }
        prepareForCommit();
        commit();
        set.add(getPackagePart());
        Iterator<a> it = this.relations.values().iterator();
        while (it.hasNext()) {
            c cVarA = it.next().a();
            if (!set.contains(cVarA.getPackagePart())) {
                cVarA.onSave(set);
            }
        }
    }

    protected void prepareForCommit() {
        n.a.a.k.b.m packagePart = getPackagePart();
        if (packagePart != null) {
            packagePart.g();
        }
    }

    protected void read(e eVar, Map<n.a.a.k.b.m, c> map) throws n.a.a.k.a.f {
        n.a.a.k.b.m packagePart = getPackagePart();
        if (packagePart.l().equals(y0.f2527i.a())) {
            LOG.atWarn().log("POI does not currently support template.main+xml (glossary) parts.  Skipping this part for now.");
            return;
        }
        c cVarPut = map.put(packagePart, this);
        if (cVarPut != null && cVarPut != this) {
            throw new d("Unique PackagePart-POIXMLDocumentPart relation broken!");
        }
        if (packagePart.y()) {
            r rVarU = this.packagePart.u();
            ArrayList arrayList = new ArrayList();
            Iterator<q> it = rVarU.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (Objects.equals(next.b(), "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink")) {
                    this.referenceRelationships.put(next.a(), new n.a.a.j.a(this, next.e(), next.d() == v.EXTERNAL, next.a()));
                } else if (next.d() == v.INTERNAL) {
                    URI uriE = next.e();
                    n.a.a.k.b.m mVarB = this.packagePart.q().B(uriE.getRawFragment() != null ? s.b(uriE.getPath()) : s.c(uriE));
                    if (mVarB == null) {
                        LOG.atError().log("Skipped invalid entry {}", next.e());
                    } else {
                        c cVarCreateDocumentPart = map.get(mVarB);
                        if (cVarCreateDocumentPart == null) {
                            cVarCreateDocumentPart = eVar.createDocumentPart(this, mVarB);
                            if ((this instanceof n.a.a.p.a.a.l) && (cVarCreateDocumentPart instanceof XSSFWorkbook)) {
                                ((n.a.a.p.a.a.l) this).X((XSSFWorkbook) cVarCreateDocumentPart);
                            }
                            cVarCreateDocumentPart.parent = this;
                            map.put(mVarB, cVarCreateDocumentPart);
                            arrayList.add(cVarCreateDocumentPart);
                        }
                        F(next, cVarCreateDocumentPart);
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).read(eVar, map);
            }
        }
    }

    protected final void rebase(n.a.a.k.b.k kVar) throws n.a.a.k.a.a {
        r rVarV = this.packagePart.v(this.coreDocumentRel);
        if (rVarV.size() == 1) {
            this.packagePart = this.packagePart.s(rVarV.g(0));
            return;
        }
        throw new IllegalStateException("Tried to rebase using " + this.coreDocumentRel + " but found " + rVarV.size() + " parts of the right type");
    }

    public final boolean removeReferenceRelationship(String str) throws n.a.a.k.a.b {
        if (this.referenceRelationships.remove(str) == null) {
            return false;
        }
        this.packagePart.D(str);
        return true;
    }

    protected final void removeRelation(c cVar) {
        removeRelation(cVar, true);
    }

    public void setCommitted(boolean z) {
        this.isCommitted = z;
    }

    public String toString() {
        n.a.a.k.b.m mVar = this.packagePart;
        return mVar == null ? "" : mVar.toString();
    }

    public c(n.a.a.k.b.k kVar, String str) {
        this(G(kVar, str));
        this.coreDocumentRel = str;
    }

    public final c createRelationship(l lVar, e eVar, int i2) {
        return createRelationship(lVar, eVar, i2, false).a();
    }

    protected final boolean removeRelation(c cVar, boolean z) {
        return H(getRelationId(cVar), z);
    }

    public final a createRelationship(l lVar, e eVar, int i2, boolean z) {
        try {
            o oVarB = s.b(lVar.d(i2));
            n.a.a.k.b.m mVarP = this.packagePart.q().p(oVarB, lVar.a());
            q qVarE = z ? null : this.packagePart.e(oVarB, v.INTERNAL, lVar.h());
            c cVarNewDocumentPart = eVar.newDocumentPart(lVar);
            cVarNewDocumentPart.packagePart = mVarP;
            cVarNewDocumentPart.parent = this;
            if (!z) {
                F(qVarE, cVarNewDocumentPart);
            }
            return new a(qVarE, cVarNewDocumentPart);
        } catch (n.a.a.k.a.h e) {
            throw e;
        } catch (Exception e2) {
            throw new d(e2);
        }
    }

    public c() {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.referenceRelationships = new LinkedHashMap();
        this.isCommitted = false;
    }

    protected final void removeRelation(String str) throws n.a.a.k.a.b {
        H(str, true);
    }

    public c(n.a.a.k.b.m mVar) {
        this((c) null, mVar);
    }

    public c(c cVar, n.a.a.k.b.m mVar) {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.referenceRelationships = new LinkedHashMap();
        this.isCommitted = false;
        this.packagePart = mVar;
        this.parent = cVar;
    }
}
