package n.a.a.j;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import n.a.a.k.b.q;
import n.a.a.k.b.r;
import org.apache.xmlbeans.impl.common.SystemCache;

/* loaded from: classes.dex */
public abstract class b extends c implements Closeable {
    public static final String DOCUMENT_CREATOR = "Apache POI";
    public static final String OLE_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject";
    public static final String PACK_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package";
    private n.a.a.k.b.k pkg;
    private h properties;

    protected b(n.a.a.k.b.k kVar) {
        super(kVar);
        I(kVar);
    }

    private void I(n.a.a.k.b.k kVar) {
        this.pkg = kVar;
        SystemCache.get().setSaxLoader(null);
    }

    public static n.a.a.k.b.k J(String str) throws IOException {
        try {
            return n.a.a.k.b.k.V(str);
        } catch (n.a.a.k.a.a e) {
            throw new IOException(e.toString(), e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        n.a.a.k.b.k kVar = this.pkg;
        if (kVar != null) {
            if (kVar.y() == n.a.a.k.b.l.READ) {
                this.pkg.b0();
            } else {
                this.pkg.close();
            }
            this.pkg = null;
        }
    }

    protected n.a.a.k.b.m getCorePart() {
        return getPackagePart();
    }

    public n.a.a.k.b.k getPackage() {
        return this.pkg;
    }

    public h getProperties() {
        if (this.properties == null) {
            try {
                this.properties = new h(this.pkg);
            } catch (Exception e) {
                throw new d(e);
            }
        }
        return this.properties;
    }

    protected n.a.a.k.b.m[] getRelatedByType(String str) throws n.a.a.k.a.a {
        r rVarV = getPackagePart().v(str);
        n.a.a.k.b.m[] mVarArr = new n.a.a.k.b.m[rVarV.size()];
        Iterator<q> it = rVarV.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            mVarArr[i2] = getPackagePart().s(it.next());
            i2++;
        }
        return mVarArr;
    }

    protected final void load(e eVar) throws IOException {
        HashMap map = new HashMap();
        try {
            read(eVar, map);
            onDocumentRead();
            map.clear();
        } catch (n.a.a.k.a.f e) {
            throw new d(e);
        }
    }

    public final void write(OutputStream outputStream) throws IOException {
        n.a.a.k.b.k kVar = getPackage();
        if (kVar == null) {
            throw new IOException("Cannot write data, document seems to have been closed already");
        }
        HashSet hashSet = new HashSet();
        onSave(hashSet);
        hashSet.clear();
        getProperties().a();
        kVar.e0(outputStream);
    }
}
