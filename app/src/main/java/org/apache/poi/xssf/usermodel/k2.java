package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import n.a.a.j.c;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* loaded from: classes.dex */
public class k2 extends n.a.a.j.c implements n.a.a.n.d.r0 {

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f2561j = n.a.a.i.b.a(k2.class);
    private CTTable c;
    private transient List<l2> d;
    private transient ConcurrentSkipListMap<String, Integer> e;
    private transient n.a.a.n.e.s f;
    private transient n.a.a.n.e.s g;

    /* renamed from: h, reason: collision with root package name */
    private transient String f2562h;

    /* renamed from: i, reason: collision with root package name */
    private transient String f2563i;

    public k2() {
        this.c = CTTable.Factory.newInstance();
    }

    private void X() {
        String ref = this.c.getRef();
        if (ref != null) {
            String[] strArrSplit = ref.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit.length == 2 ? strArrSplit[1] : strArrSplit[0];
            this.f = new n.a.a.n.e.s(str);
            this.g = new n.a.a.n.e.s(str2);
        }
    }

    @Override // n.a.a.n.d.r0
    public int D() {
        return O().l();
    }

    public l2 I(String str, int i2) {
        int iL = L();
        if (i2 < 0 || i2 > iL) {
            throw new IllegalArgumentException("Column index out of bounds");
        }
        CTTableColumns tableColumns = this.c.getTableColumns();
        if (tableColumns == null) {
            tableColumns = this.c.addNewTableColumns();
        }
        long jMax = 0;
        for (l2 l2Var : M()) {
            if (str != null && str.equalsIgnoreCase(l2Var.b())) {
                throw new IllegalArgumentException("Column '" + str + "' already exists. Column names must be unique per table.");
            }
            jMax = Math.max(jMax, l2Var.a());
        }
        long j2 = jMax + 1;
        CTTableColumn cTTableColumnInsertNewTableColumn = tableColumns.insertNewTableColumn(i2);
        tableColumns.setCount(tableColumns.sizeOfTableColumnArray());
        cTTableColumnInsertNewTableColumn.setId(j2);
        if (str != null) {
            cTTableColumnInsertNewTableColumn.setName(str);
        } else {
            cTTableColumnInsertNewTableColumn.setName("Column " + j2);
        }
        if (this.c.getRef() != null) {
            W(new n.a.a.n.e.k(O(), new n.a.a.n.e.s(N().m(), (r8.l() + (iL + 1)) - 1), R().getWorkbook().getSpreadsheetVersion()));
        }
        c0();
        return M().get(i2);
    }

    public n.a.a.n.e.k J() {
        if (this.c.getRef() == null) {
            return null;
        }
        return new n.a.a.n.e.k(this.c.getRef(), R().getWorkbook().getSpreadsheetVersion());
    }

    public CTTable K() {
        return this.c;
    }

    public int L() {
        CTTableColumns tableColumns = this.c.getTableColumns();
        if (tableColumns == null) {
            return 0;
        }
        return (int) tableColumns.getCount();
    }

    public List<l2> M() {
        if (this.d == null) {
            ArrayList arrayList = new ArrayList();
            CTTableColumns tableColumns = this.c.getTableColumns();
            if (tableColumns != null) {
                Iterator<CTTableColumn> it = tableColumns.getTableColumnList().iterator();
                while (it.hasNext()) {
                    arrayList.add(new l2(this, it.next()));
                }
            }
            this.d = Collections.unmodifiableList(arrayList);
        }
        return this.d;
    }

    public n.a.a.n.e.s N() {
        if (this.g == null) {
            X();
        }
        return this.g;
    }

    public n.a.a.n.e.s O() {
        if (this.f == null) {
            X();
        }
        return this.f;
    }

    public n.a.a.n.d.t0 P() {
        if (this.c.isSetTableStyleInfo()) {
            return new n2(((i2) getParent()).getWorkbook().getStylesSource(), this.c.getTableStyleInfo());
        }
        return null;
    }

    public String Q() {
        if (this.f2563i == null && this.c.isSetTableStyleInfo()) {
            a0(this.c.getTableStyleInfo().getName());
        }
        return this.f2563i;
    }

    public i2 R() {
        return (i2) getParent();
    }

    protected void S() {
        Iterator<c.a> it = getRelationParts().iterator();
        while (it.hasNext()) {
            removeRelation(it.next().a(), true);
        }
    }

    public void T(InputStream inputStream) throws IOException {
        try {
            this.c = TableDocument.Factory.parse(inputStream, n.a.a.j.m.a).getTable();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void U(int i2) {
        if (i2 < 0 || i2 > L() - 1) {
            throw new IllegalArgumentException("Column index out of bounds");
        }
        if (L() == 1) {
            throw new IllegalArgumentException("Table must have at least one column");
        }
        CTTableColumns tableColumns = this.c.getTableColumns();
        tableColumns.removeTableColumn(i2);
        tableColumns.setCount(tableColumns.getTableColumnList().size());
        d0();
        c0();
    }

    public void V(n.a.a.n.e.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("AreaReference must not be null");
        }
        String strN = kVar.b().n();
        if (strN != null && !strN.equals(R().c())) {
            throw new IllegalArgumentException("The AreaReference must not reference a different sheet");
        }
        if (!b0(kVar)) {
            throw new IllegalArgumentException("AreaReference needs at least " + (getHeaderRowCount() + 1 + getTotalsRowCount()) + " rows, to cover at least one data row and all header rows and totals rows");
        }
        String strA = kVar.a();
        if (strA.indexOf(33) != -1) {
            strA = strA.substring(strA.indexOf(33) + 1);
        }
        this.c.setRef(strA);
        if (this.c.isSetAutoFilter()) {
            this.c.getAutoFilter().setRef(strA);
        }
        d0();
        int iL = L();
        int iL2 = (kVar.c().l() - kVar.b().l()) + 1;
        if (iL2 > iL) {
            while (iL < iL2) {
                I(null, iL);
                iL++;
            }
        } else if (iL2 < iL) {
            while (iL > iL2) {
                U(iL - 1);
                iL--;
            }
        }
        c0();
    }

    protected void W(n.a.a.n.e.k kVar) {
        String strA = kVar.a();
        if (strA.indexOf(33) != -1) {
            strA = strA.substring(strA.indexOf(33) + 1);
        }
        this.c.setRef(strA);
        if (this.c.isSetAutoFilter()) {
            int totalsRowCount = getTotalsRowCount();
            if (totalsRowCount != 0) {
                strA = new n.a.a.n.e.k(new n.a.a.n.e.s(kVar.b().m(), kVar.b().l()), new n.a.a.n.e.s(kVar.c().m() - totalsRowCount, kVar.c().l()), n.a.a.n.a.EXCEL2007).a();
            }
            this.c.getAutoFilter().setRef(strA);
        }
        d0();
        c0();
    }

    public void Y(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Display name must not be null or empty");
        }
        this.c.setDisplayName(str);
    }

    public void Z(String str) {
        if (str == null) {
            this.c.unsetName();
            this.f2562h = null;
        } else {
            this.c.setName(str);
            this.f2562h = str;
        }
    }

    @Override // n.a.a.n.d.r0
    public int a(String str) {
        if (str == null) {
            return -1;
        }
        if (this.e == null) {
            this.e = new ConcurrentSkipListMap<>(String.CASE_INSENSITIVE_ORDER);
            int i2 = 0;
            Iterator<l2> it = M().iterator();
            while (it.hasNext()) {
                this.e.put(it.next().b(), Integer.valueOf(i2));
                i2++;
            }
        }
        Integer num = this.e.get(str.replace("''", "'").replace("'#", "#"));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void a0(String str) {
        if (str != null) {
            if (!this.c.isSetTableStyleInfo()) {
                this.c.addNewTableStyleInfo();
            }
            this.c.getTableStyleInfo().setName(str);
            this.f2563i = str;
            return;
        }
        if (this.c.isSetTableStyleInfo()) {
            try {
                this.c.getTableStyleInfo().unsetName();
            } catch (Exception e) {
                f2561j.atDebug().log("Failed to unset style name", e);
            }
        }
        this.f2563i = null;
    }

    boolean b0(n.a.a.n.e.k kVar) {
        return (kVar.c().m() - kVar.b().m()) + 1 >= (Math.max(1, getHeaderRowCount()) + 1) + getTotalsRowCount();
    }

    @Override // n.a.a.n.d.r0
    public String c() {
        return R().c();
    }

    public void c0() {
        CTTableColumns tableColumns;
        n.a.a.j.c parent = getParent();
        if (!(parent instanceof i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Had unexpected type of parent: ");
            sb.append(parent == null ? "<null>" : parent.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
        i2 i2Var = (i2) parent;
        n.a.a.n.e.s sVarO = O();
        if (sVarO == null) {
            return;
        }
        int iM = sVarO.m();
        int iL = sVarO.l();
        f2 f2VarF = i2Var.f(iM);
        n.a.a.n.d.w wVar = new n.a.a.n.d.w();
        if (f2VarF != null && (tableColumns = K().getTableColumns()) != null) {
            for (CTTableColumn cTTableColumn : tableColumns.getTableColumnList()) {
                z0 z0VarX = f2VarF.x(iL);
                if (z0VarX != null) {
                    cTTableColumn.setName(wVar.l(z0VarX).replace("\n", "_x000a_").replace("\r", "_x000d_"));
                }
                iL++;
            }
        }
        this.d = null;
        this.e = null;
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            e0(outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void d0() {
        this.f = null;
        this.g = null;
    }

    public void e0(OutputStream outputStream) throws IOException {
        c0();
        TableDocument tableDocumentNewInstance = TableDocument.Factory.newInstance();
        tableDocumentNewInstance.setTable(this.c);
        tableDocumentNewInstance.save(outputStream, n.a.a.j.m.a);
    }

    @Override // n.a.a.n.d.r0
    public int getHeaderRowCount() {
        return (int) this.c.getHeaderRowCount();
    }

    @Override // n.a.a.n.d.r0
    public String getName() {
        if (this.f2562h == null && this.c.getName() != null) {
            Z(this.c.getName());
        }
        return this.f2562h;
    }

    @Override // n.a.a.n.d.r0
    public int getTotalsRowCount() {
        return (int) this.c.getTotalsRowCount();
    }

    @Override // n.a.a.n.d.r0
    public int j() {
        return N().l();
    }

    @Override // n.a.a.n.d.r0
    public int w() {
        return O().m();
    }

    @Override // n.a.a.n.d.r0
    public int z() {
        return N().m();
    }

    public k2(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            T(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
