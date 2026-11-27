package n.a.a.p.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import n.a.a.j.c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.i2;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

/* loaded from: classes.dex */
public abstract class l extends n.a.a.j.c {
    private XSSFWorkbook a;
    private int b;
    protected final CTChartSpace c;

    protected l() {
        this.b = 0;
        new ArrayList();
        CTChartSpace cTChartSpaceNewInstance = CTChartSpace.Factory.newInstance();
        this.c = cTChartSpaceNewInstance;
        cTChartSpaceNewInstance.addNewChart().addNewPlotArea();
    }

    private n.a.a.k.b.m J(n.a.a.j.l lVar, n.a.a.j.e eVar) throws n.a.a.k.a.a {
        n.a.a.k.b.q qVarI = I(lVar, eVar, this.b);
        W(qVarI.a());
        return getTargetPart(qVarI);
    }

    private Map<Long, m> N() {
        CTPlotArea cTPlotAreaM = M();
        int iSizeOfCatAxArray = cTPlotAreaM.sizeOfCatAxArray();
        HashMap map = new HashMap(iSizeOfCatAxArray);
        for (int i2 = 0; i2 < iSizeOfCatAxArray; i2++) {
            CTCatAx catAxArray = cTPlotAreaM.getCatAxArray(i2);
            map.put(Long.valueOf(catAxArray.getAxId().getVal()), new j(catAxArray));
        }
        return map;
    }

    private Map<Long, t0> R() {
        CTPlotArea cTPlotAreaM = M();
        int iSizeOfValAxArray = cTPlotAreaM.sizeOfValAxArray();
        HashMap map = new HashMap(iSizeOfValAxArray);
        for (int i2 = 0; i2 < iSizeOfValAxArray; i2++) {
            CTValAx valAxArray = cTPlotAreaM.getValAxArray(i2);
            map.put(Long.valueOf(valAxArray.getAxId().getVal()), new t0(valAxArray));
        }
        return map;
    }

    private n.a.a.k.b.m S() throws n.a.a.k.a.a {
        for (c.a aVar : getRelationParts()) {
            if (n.a.a.j.b.PACK_OBJECT_REL_TYPE.equals(aVar.b().b())) {
                return getTargetPart(aVar.b());
            }
        }
        return null;
    }

    private void Y() {
        for (c.a aVar : getRelationParts()) {
            if (n.a.a.j.b.PACK_OBJECT_REL_TYPE.equals(aVar.b().b())) {
                aVar.a().setCommitted(true);
                return;
            }
        }
    }

    public n.a.a.k.b.q I(n.a.a.j.l lVar, n.a.a.j.e eVar, int i2) {
        return addRelation(null, lVar, createRelationship(lVar, eVar, i2, true).a()).b();
    }

    public CTChart K() {
        return this.c.getChart();
    }

    public CTChartSpace L() {
        return this.c;
    }

    protected CTPlotArea M() {
        return K().getPlotArea();
    }

    protected abstract n.a.a.j.e O();

    public List<o> P() {
        LinkedList linkedList = new LinkedList();
        CTPlotArea cTPlotAreaM = M();
        Map<Long, m> mapN = N();
        Map<Long, t0> mapR = R();
        for (int i2 = 0; i2 < cTPlotAreaM.sizeOfAreaChartArray(); i2++) {
            linkedList.add(new e(this, cTPlotAreaM.getAreaChartArray(i2), mapN, mapR));
        }
        for (int i3 = 0; i3 < cTPlotAreaM.sizeOfArea3DChartArray(); i3++) {
            linkedList.add(new c(this, cTPlotAreaM.getArea3DChartArray(i3), mapN, mapR));
        }
        for (int i4 = 0; i4 < cTPlotAreaM.sizeOfBarChartArray(); i4++) {
            linkedList.add(new i(this, cTPlotAreaM.getBarChartArray(i4), mapN, mapR));
        }
        for (int i5 = 0; i5 < cTPlotAreaM.sizeOfBar3DChartArray(); i5++) {
            linkedList.add(new g(this, cTPlotAreaM.getBar3DChartArray(i5), mapN, mapR));
        }
        for (int i6 = 0; i6 < cTPlotAreaM.sizeOfDoughnutChartArray(); i6++) {
            linkedList.add(new b0(this, cTPlotAreaM.getDoughnutChartArray(i6)));
        }
        for (int i7 = 0; i7 < cTPlotAreaM.sizeOfLineChartArray(); i7++) {
            linkedList.add(new f0(this, cTPlotAreaM.getLineChartArray(i7), mapN, mapR));
        }
        for (int i8 = 0; i8 < cTPlotAreaM.sizeOfLine3DChartArray(); i8++) {
            linkedList.add(new d0(this, cTPlotAreaM.getLine3DChartArray(i8), mapN, mapR));
        }
        for (int i9 = 0; i9 < cTPlotAreaM.sizeOfPieChartArray(); i9++) {
            linkedList.add(new k0(this, cTPlotAreaM.getPieChartArray(i9)));
        }
        for (int i10 = 0; i10 < cTPlotAreaM.sizeOfPie3DChartArray(); i10++) {
            linkedList.add(new i0(this, cTPlotAreaM.getPie3DChartArray(i10)));
        }
        for (int i11 = 0; i11 < cTPlotAreaM.sizeOfRadarChartArray(); i11++) {
            linkedList.add(new m0(this, cTPlotAreaM.getRadarChartArray(i11), mapN, mapR));
        }
        for (int i12 = 0; i12 < cTPlotAreaM.sizeOfScatterChartArray(); i12++) {
            linkedList.add(new o0(this, cTPlotAreaM.getScatterChartArray(i12), mapN, mapR));
        }
        for (int i13 = 0; i13 < cTPlotAreaM.sizeOfSurfaceChartArray(); i13++) {
            linkedList.add(new s0(this, cTPlotAreaM.getSurfaceChartArray(i13), mapN, mapR));
        }
        for (int i14 = 0; i14 < cTPlotAreaM.sizeOfSurface3DChartArray(); i14++) {
            linkedList.add(new q0(this, cTPlotAreaM.getSurface3DChartArray(i14), mapN, mapR));
        }
        linkedList.size();
        return linkedList;
    }

    protected abstract n.a.a.j.l Q();

    public void T(l lVar) {
        L().set(lVar.L());
    }

    public void U(i2 i2Var) {
        g0<? extends Number> g0Var;
        Iterator<o> it = P().iterator();
        while (it.hasNext()) {
            for (n nVar : it.next().a) {
                p<?> pVarC = nVar.a;
                g0<? extends Number> g0VarC = nVar.b;
                if (pVarC != null) {
                    try {
                        if (pVarC.a()) {
                            String strD = nVar.a.d();
                            n.a.a.n.e.m mVarF = n.a.a.n.e.m.F(strD.substring(strD.indexOf(33) + 1));
                            pVarC = nVar.a.isNumeric() ? z.c(i2Var, mVarF) : z.d(i2Var, mVarF);
                            if (pVarC.isNumeric()) {
                                ((g0) pVarC).setFormatCode(nVar.a.getFormatCode());
                            }
                        }
                        g0Var = nVar.b;
                        if (g0Var == null && g0Var.a()) {
                            String strD2 = nVar.b.d();
                            g0VarC = z.c(i2Var, n.a.a.n.e.m.F(strD2.substring(strD2.indexOf(33) + 1)));
                            g0VarC.setFormatCode(nVar.b.getFormatCode());
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    g0Var = nVar.b;
                    if (g0Var == null) {
                    }
                }
                nVar.d(pVarC, g0VarC);
                nVar.c();
            }
        }
    }

    public void V(XSSFWorkbook xSSFWorkbook) throws n.a.a.k.a.a, IOException {
        n.a.a.k.b.m mVarS = S();
        if (mVarS == null) {
            n.a.a.j.l lVarQ = Q();
            n.a.a.j.e eVarO = O();
            if (lVarQ == null || eVarO == null) {
                throw new n.a.a.k.a.a("unable to determine chart relations");
            }
            mVarS = J(lVarQ, eVarO);
        }
        OutputStream outputStreamO = mVarS.o();
        try {
            Y();
            xSSFWorkbook.write(outputStreamO);
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

    public void W(String str) {
        CTChartSpace cTChartSpaceL = L();
        (cTChartSpaceL.isSetExternalData() ? cTChartSpaceL.getExternalData() : cTChartSpaceL.addNewExternalData()).setId(str);
    }

    public void X(XSSFWorkbook xSSFWorkbook) {
        this.a = xSSFWorkbook;
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        XSSFWorkbook xSSFWorkbook = this.a;
        if (xSSFWorkbook != null) {
            try {
                V(xSSFWorkbook);
            } catch (n.a.a.k.a.a e) {
                throw new n.a.a.j.d(e);
            }
        }
        OutputStream outputStreamO = getPackagePart().o();
        try {
            this.c.save(outputStreamO, xmlOptions);
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

    protected l(n.a.a.k.b.m mVar) throws XmlException, IOException {
        super(mVar);
        this.b = 0;
        new ArrayList();
        InputStream inputStreamM = mVar.m();
        try {
            this.c = ChartSpaceDocument.Factory.parse(inputStreamM, n.a.a.j.m.a).getChartSpace();
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
