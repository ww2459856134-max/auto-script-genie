package k.a0.a;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class n3 extends k.v implements k.x.j1.t, k.x.a1 {
    private static k.y.c y = k.y.c.b(n3.class);
    private j0 a;
    private int b;
    private boolean c;
    private n2 d;

    /* renamed from: i, reason: collision with root package name */
    private y2 f1816i;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1819l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f1820m;

    /* renamed from: n, reason: collision with root package name */
    private i0 f1821n;
    private a p;
    private k.x.i1.d0 q;
    private l r;
    private k.w u;
    private k.x.i1.v v;
    private t w;
    private ArrayList e = new ArrayList(10);
    private k.x.j0 g = new k.x.j0();
    private k.x.n0 f = new k.x.n0(this.g);

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1815h = new ArrayList(10);

    /* renamed from: o, reason: collision with root package name */
    private ArrayList f1822o = new ArrayList(10);

    /* renamed from: k, reason: collision with root package name */
    private HashMap f1818k = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private int f1817j = -1;
    private boolean s = false;
    private boolean t = false;
    private ArrayList x = new ArrayList(10);

    public n3(j0 j0Var, k.w wVar) {
        this.a = j0Var;
        this.u = wVar;
    }

    public k.w A() {
        return this.u;
    }

    public d3[] B() {
        return (d3[]) this.f1822o.toArray(new d3[this.f1822o.size()]);
    }

    public k.x.d1[] C() {
        return (k.x.d1[]) this.x.toArray(new k.x.d1[0]);
    }

    @Override // k.x.j1.t
    public String a(int i2) {
        if (this.p.z()) {
            return ((k) this.e.get(i2)).getName();
        }
        d3 d3Var = (d3) this.f1822o.get(this.f1821n.B(i2));
        int iY = this.f1821n.y(i2);
        int iZ = this.f1821n.z(i2);
        if (d3Var.C() != d3.g) {
            if (d3Var.C() != d3.f1796h) {
                y.f("Unknown Supbook 3");
                return "[UNKNOWN]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            File file = new File(d3Var.z());
            stringBuffer.append("'");
            stringBuffer.append(file.getAbsolutePath());
            stringBuffer.append("[");
            stringBuffer.append(file.getName());
            stringBuffer.append("]");
            stringBuffer.append(iY != 65535 ? d3Var.B(iY) : "#REF");
            if (iZ != iY) {
                stringBuffer.append(d3Var.B(iZ));
            }
            stringBuffer.append("'");
            return stringBuffer.toString();
        }
        String name = iY == 65535 ? "#REF" : ((k) this.e.get(iY)).getName();
        String name2 = iZ != 65535 ? ((k) this.e.get(iZ)).getName() : "#REF";
        if (iY != iZ) {
            name = name + NameUtil.COLON + name2;
        }
        if (name.indexOf(39) != -1) {
            name = k.x.y0.h(name, "'", "''");
        }
        if (name.indexOf(32) == -1) {
            return name;
        }
        return Chars.QUOTE + name + Chars.QUOTE;
    }

    @Override // k.x.a1
    public String b(int i2) throws k.x.t0 {
        if (i2 < 0 || i2 >= this.f1819l.size()) {
            throw new k.x.t0();
        }
        return ((o1) this.f1819l.get(i2)).getName();
    }

    @Override // k.x.j1.t
    public int c(String str) {
        return 0;
    }

    @Override // k.x.j1.t
    public a d() {
        return this.p;
    }

    @Override // k.x.a1
    public int e(String str) {
        o1 o1Var = (o1) this.f1818k.get(str);
        if (o1Var != null) {
            return o1Var.A();
        }
        return 0;
    }

    @Override // k.v
    public void f() {
        y2 y2Var = this.f1816i;
        if (y2Var != null) {
            y2Var.f();
        }
        this.a.a();
        if (this.u.j()) {
            return;
        }
        System.gc();
    }

    @Override // k.v
    public int i() {
        return this.f1815h.size();
    }

    @Override // k.v
    public k.s j(int i2) {
        y2 y2Var = this.f1816i;
        if (y2Var != null && this.f1817j == i2) {
            return y2Var;
        }
        if (y2Var != null) {
            y2Var.f();
            if (!this.u.j()) {
                System.gc();
            }
        }
        y2 y2Var2 = (y2) this.f1815h.get(i2);
        this.f1816i = y2Var2;
        this.f1817j = i2;
        y2Var2.A();
        return this.f1816i;
    }

    @Override // k.v
    public boolean n() {
        return this.s;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:156:0x03cf
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Path cross not found for [B:152:0x03b9, B:155:0x03ce], limit reached: 313 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x03ce -> B:156:0x03cf). Please report as a decompilation issue!!! */
    @Override // k.v
    protected void o() throws k.a0.a.d, k.a0.a.v1 {
        /*
            Method dump skipped, instructions count: 1247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a0.a.n3.o():void");
    }

    final void p(k.s sVar) {
        this.f1815h.add(sVar);
    }

    public boolean q() {
        return this.t;
    }

    public String[] r() {
        return (String[]) this.f1820m.toArray(new String[0]);
    }

    public l s() {
        return this.r;
    }

    public s t() {
        return this.a.b();
    }

    public t u() {
        return this.w;
    }

    public k.x.i1.v v() {
        return this.v;
    }

    public i0 w() {
        return this.f1821n;
    }

    public k.x.j0 x() {
        return this.g;
    }

    public k.x.n0 y() {
        return this.f;
    }

    public o1[] z() {
        return (o1[]) this.f1819l.toArray(new o1[this.f1819l.size()]);
    }
}
