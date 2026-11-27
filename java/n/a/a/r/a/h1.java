package n.a.a.r.a;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* loaded from: classes.dex */
public class h1 implements z {
    private static final EnumMap<g1, STBorder.Enum> g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<Integer, g1> f2519h;
    protected StringBuilder c = new StringBuilder(64);
    protected final List<k1> d = new ArrayList();
    protected y e;
    private final CTTbl f;

    static {
        EnumMap<g1, STBorder.Enum> enumMap = new EnumMap<>(g1.class);
        g = enumMap;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.NIL, (g1) STBorder.NIL);
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.NONE, (g1) STBorder.NONE);
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.SINGLE, (g1) STBorder.SINGLE);
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.THICK, (g1) STBorder.THICK);
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.DOUBLE, (g1) STBorder.DOUBLE);
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1.DOTTED, (g1) STBorder.DOTTED);
        g1 g1Var = g1.DASHED;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var, (g1) STBorder.DASHED);
        g1 g1Var2 = g1.DOT_DASH;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var2, (g1) STBorder.DOT_DASH);
        g1 g1Var3 = g1.DOT_DOT_DASH;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var3, (g1) STBorder.DOT_DOT_DASH);
        g1 g1Var4 = g1.TRIPLE;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var4, (g1) STBorder.TRIPLE);
        g1 g1Var5 = g1.THIN_THICK_SMALL_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var5, (g1) STBorder.THIN_THICK_SMALL_GAP);
        g1 g1Var6 = g1.THICK_THIN_SMALL_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var6, (g1) STBorder.THICK_THIN_SMALL_GAP);
        g1 g1Var7 = g1.THIN_THICK_THIN_SMALL_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var7, (g1) STBorder.THIN_THICK_THIN_SMALL_GAP);
        g1 g1Var8 = g1.THIN_THICK_MEDIUM_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var8, (g1) STBorder.THIN_THICK_MEDIUM_GAP);
        g1 g1Var9 = g1.THICK_THIN_MEDIUM_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var9, (g1) STBorder.THICK_THIN_MEDIUM_GAP);
        g1 g1Var10 = g1.THIN_THICK_THIN_MEDIUM_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var10, (g1) STBorder.THIN_THICK_THIN_MEDIUM_GAP);
        g1 g1Var11 = g1.THIN_THICK_LARGE_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var11, (g1) STBorder.THIN_THICK_LARGE_GAP);
        g1 g1Var12 = g1.THICK_THIN_LARGE_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var12, (g1) STBorder.THICK_THIN_LARGE_GAP);
        g1 g1Var13 = g1.THIN_THICK_THIN_LARGE_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var13, (g1) STBorder.THIN_THICK_THIN_LARGE_GAP);
        g1 g1Var14 = g1.WAVE;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var14, (g1) STBorder.WAVE);
        g1 g1Var15 = g1.DOUBLE_WAVE;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var15, (g1) STBorder.DOUBLE_WAVE);
        g1 g1Var16 = g1.DASH_SMALL_GAP;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var16, (g1) STBorder.DASH_SMALL_GAP);
        g1 g1Var17 = g1.DASH_DOT_STROKED;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var17, (g1) STBorder.DASH_DOT_STROKED);
        g1 g1Var18 = g1.THREE_D_EMBOSS;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var18, (g1) STBorder.THREE_D_EMBOSS);
        g1 g1Var19 = g1.THREE_D_ENGRAVE;
        enumMap.put((EnumMap<g1, STBorder.Enum>) g1Var19, (g1) STBorder.THREE_D_ENGRAVE);
        EnumMap<g1, STBorder.Enum> enumMap2 = g;
        g1 g1Var20 = g1.OUTSET;
        enumMap2.put((EnumMap<g1, STBorder.Enum>) g1Var20, (g1) STBorder.OUTSET);
        g1 g1Var21 = g1.INSET;
        enumMap2.put((EnumMap<g1, STBorder.Enum>) g1Var21, (g1) STBorder.INSET);
        HashMap<Integer, g1> map = new HashMap<>();
        f2519h = map;
        map.put(1, g1.NIL);
        map.put(2, g1.NONE);
        map.put(3, g1.SINGLE);
        map.put(4, g1.THICK);
        map.put(5, g1.DOUBLE);
        map.put(6, g1.DOTTED);
        map.put(7, g1Var);
        map.put(8, g1Var2);
        map.put(9, g1Var3);
        map.put(10, g1Var4);
        map.put(11, g1Var5);
        map.put(12, g1Var6);
        map.put(13, g1Var7);
        map.put(14, g1Var8);
        map.put(15, g1Var9);
        map.put(16, g1Var10);
        map.put(17, g1Var11);
        map.put(18, g1Var12);
        map.put(19, g1Var13);
        map.put(20, g1Var14);
        map.put(21, g1Var15);
        map.put(22, g1Var16);
        map.put(23, g1Var17);
        map.put(24, g1Var18);
        map.put(25, g1Var19);
        map.put(26, g1Var20);
        map.put(27, g1Var21);
    }

    public h1(CTTbl cTTbl, y yVar, boolean z) {
        this.e = yVar;
        this.f = cTTbl;
        if (z && cTTbl.sizeOfTrArray() == 0) {
            a(cTTbl);
        }
        for (CTRow cTRow : cTTbl.getTrList()) {
            StringBuilder sb = new StringBuilder();
            this.d.add(new k1(cTRow, this));
            Iterator<CTTc> it = cTRow.getTcList().iterator();
            while (it.hasNext()) {
                Iterator<CTP> it2 = it.next().getPList().iterator();
                while (it2.hasNext()) {
                    v0 v0Var = new v0(it2.next(), yVar);
                    if (sb.length() > 0) {
                        sb.append('\t');
                    }
                    sb.append(v0Var.c());
                }
            }
            if (sb.length() > 0) {
                this.c.append((CharSequence) sb);
                this.c.append('\n');
            }
        }
    }

    private void a(CTTbl cTTbl) {
        cTTbl.addNewTr().addNewTc().addNewP();
        CTTblPr cTTblPrAddNewTblPr = cTTbl.addNewTblPr();
        cTTblPrAddNewTblPr.addNewTblW().setW(BigInteger.valueOf(0L));
        cTTblPrAddNewTblPr.getTblW().setType(STTblWidth.AUTO);
        CTTblBorders cTTblBordersAddNewTblBorders = cTTblPrAddNewTblPr.addNewTblBorders();
        CTBorder cTBorderAddNewBottom = cTTblBordersAddNewTblBorders.addNewBottom();
        STBorder.Enum r1 = STBorder.SINGLE;
        cTBorderAddNewBottom.setVal(r1);
        cTTblBordersAddNewTblBorders.addNewInsideH().setVal(r1);
        cTTblBordersAddNewTblBorders.addNewInsideV().setVal(r1);
        cTTblBordersAddNewTblBorders.addNewLeft().setVal(r1);
        cTTblBordersAddNewTblBorders.addNewRight().setVal(r1);
        cTTblBordersAddNewTblBorders.addNewTop().setVal(r1);
    }

    public y b() {
        return this.e;
    }

    public List<k1> c() {
        return Collections.unmodifiableList(this.d);
    }
}
