package n.a.a.o;

import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.PackedColorModel;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class t0 implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    private static final String f2501h;

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f2502i = Pattern.compile("[\"\\p{Cntrl}\\\\]");

    /* renamed from: j, reason: collision with root package name */
    private static final String f2503j = System.getProperty("line.separator");

    /* renamed from: k, reason: collision with root package name */
    private static final List<Map.Entry<Class<?>, s0>> f2504k = new ArrayList();
    protected final r0 c;
    protected final PrintWriter d;
    protected int e = 0;
    protected boolean f = true;
    protected int g = 0;

    static {
        char[] cArr = new char[255];
        Arrays.fill(cArr, '\t');
        f2501h = new String(cArr);
        f fVar = new s0() { // from class: n.a.a.o.f
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.K(str, obj);
            }
        };
        a(String.class, fVar);
        a(Number.class, new s0() { // from class: n.a.a.o.c0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.J(str, obj);
            }
        });
        a(Boolean.class, new s0() { // from class: n.a.a.o.s
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.x(str, obj);
            }
        });
        a(List.class, new s0() { // from class: n.a.a.o.a0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.G(str, obj);
            }
        });
        a(n.a.a.e.a.a.class, new s0() { // from class: n.a.a.o.g0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.D(str, obj);
            }
        });
        a(u0.class, new s0() { // from class: n.a.a.o.p
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.u(str, obj);
            }
        });
        a(byte[].class, new s0() { // from class: n.a.a.o.u
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.y(str, obj);
            }
        });
        a(Point2D.class, new s0() { // from class: n.a.a.o.b0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.M(str, obj);
            }
        });
        a(n.a.a.h.a.b.b.class, new s0() { // from class: n.a.a.o.t
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.B(str, obj);
            }
        });
        a(Rectangle2D.class, new s0() { // from class: n.a.a.o.q
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.N(str, obj);
            }
        });
        a(Path2D.class, new s0() { // from class: n.a.a.o.y
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.L(str, obj);
            }
        });
        a(n.a.a.h.a.b.a.class, new s0() { // from class: n.a.a.o.i0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.s(str, obj);
            }
        });
        a(n.a.a.h.a.a.class, new s0() { // from class: n.a.a.o.o
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.z(str, obj);
            }
        });
        a(n.a.a.h.a.c.a.class, new s0() { // from class: n.a.a.o.z
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.F(str, obj);
            }
        });
        a(Array.class, new s0() { // from class: n.a.a.o.h0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str, Object obj) {
                return t0Var.w(str, obj);
            }
        });
        a(Object.class, fVar);
    }

    public t0(Appendable appendable) {
        r0 r0Var = new r0(appendable);
        this.c = r0Var;
        this.d = new PrintWriter(r0Var);
    }

    static String Q(long j2, int i2) {
        String hexString = Long.toHexString(j2);
        int length = hexString.length();
        return "0000000000000000".substring(0, Math.max(0, i2 - length)) + hexString.substring(Math.max(0, length - i2), length);
    }

    private static void a(Class<?> cls, s0 s0Var) {
        f2504k.add(new AbstractMap.SimpleEntry(cls, s0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Object obj) {
        V(null, obj);
        this.g++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean i(n.a.a.e.a.a aVar) {
        if (V(null, aVar)) {
            int i2 = this.g + 1;
            this.g = i2;
            if (i2 > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean m(Map.Entry entry) {
        return T((String) entry.getKey(), (Supplier) entry.getValue());
    }

    public static String o(n.a.a.e.a.a aVar) {
        return p(aVar, true);
    }

    public static String p(n.a.a.e.a.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            t0 t0Var = new t0(sb);
            try {
                t0Var.O(z);
                t0Var.R(aVar);
                String string = sb.toString();
                t0Var.close();
                return string;
            } finally {
            }
        } catch (IOException unused) {
            return "{}";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean q(Class<?> cls, Object obj) {
        return cls.isInstance(obj) || (Array.class.equals(cls) && obj.getClass().isArray());
    }

    protected boolean B(String str, Object obj) {
        H(str);
        n.a.a.h.a.b.b bVar = (n.a.a.h.a.b.b) obj;
        this.d.write("{ \"width\": " + bVar.b() + ", \"height\": " + bVar.a() + " }");
        return true;
    }

    protected boolean D(String str, Object obj) {
        H(str);
        this.e++;
        R((n.a.a.e.a.a) obj);
        this.e--;
        return true;
    }

    protected boolean F(String str, Object obj) {
        n.a.a.h.a.c.a aVar = (n.a.a.h.a.c.a) obj;
        String[] strArr = {"XYZ", "Lab", "Luv", "YCbCr", "Yxy", "RGB", "GRAY", "HSV", "HLS", "CMYK", "Unknown", "CMY", "Unknown"};
        String[] strArr2 = {"CUSTOM", "INT_RGB", "INT_ARGB", "INT_ARGB_PRE", "INT_BGR", "3BYTE_BGR", "4BYTE_ABGR", "4BYTE_ABGR_PRE", "USHORT_565_RGB", "USHORT_555_RGB", "BYTE_GRAY", "USHORT_GRAY", "BYTE_BINARY", "BYTE_INDEXED"};
        H(str);
        ColorModel colorModel = aVar.getColorModel();
        String str2 = colorModel instanceof IndexColorModel ? "indexed" : colorModel instanceof ComponentColorModel ? "component" : colorModel instanceof DirectColorModel ? "direct" : colorModel instanceof PackedColorModel ? "packed" : "unknown";
        this.d.write("{ \"width\": " + aVar.b() + ", \"height\": " + aVar.a() + ", \"type\": \"" + strArr2[aVar.getType()] + "\", \"colormodel\": \"" + str2 + "\", \"pixelBits\": " + colorModel.getPixelSize() + ", \"numComponents\": " + colorModel.getNumComponents() + ", \"colorSpace\": \"" + strArr[Math.min(colorModel.getColorSpace().getType(), 12)] + "\", \"transparency\": " + colorModel.getTransparency() + ", \"alpha\": " + colorModel.hasAlpha() + "}");
        return true;
    }

    protected boolean G(String str, Object obj) {
        H(str);
        this.d.println("[");
        int i2 = this.g;
        this.g = 0;
        ((List) obj).forEach(new Consumer() { // from class: n.a.a.o.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.a.d(obj2);
            }
        });
        this.g = i2;
        this.d.write(P() + "\t]");
        return true;
    }

    protected void H(String str) {
        String str2;
        PrintWriter printWriter = this.d;
        if (str != null) {
            str2 = "\"" + str + "\": ";
        } else {
            str2 = "";
        }
        printWriter.print(str2);
    }

    protected boolean I(String str, Object obj) {
        H(str);
        this.d.write("null");
        return true;
    }

    protected boolean J(String str, Object obj) {
        Number number = (Number) obj;
        H(str);
        if (obj instanceof Float) {
            this.d.print(number.floatValue());
            return true;
        }
        if (obj instanceof Double) {
            this.d.print(number.doubleValue());
            return true;
        }
        this.d.print(number.longValue());
        int i2 = number instanceof Byte ? 2 : number instanceof Short ? 4 : number instanceof Integer ? 8 : number instanceof Long ? 16 : -1;
        long jLongValue = number.longValue();
        if (this.f && i2 > 0 && (jLongValue < 0 || jLongValue > 9)) {
            this.d.write(" /* 0x");
            this.d.write(Q(jLongValue, i2));
            this.d.write(" */");
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean K(String str, Object obj) {
        H(str);
        this.d.write(34);
        String string = obj.toString();
        Matcher matcher = f2502i.matcher(string);
        int iEnd = 0;
        while (true) {
            char c = 1;
            if (!matcher.find()) {
                this.d.append((CharSequence) string, iEnd, string.length());
                this.d.write(34);
                return true;
            }
            this.d.append((CharSequence) string, iEnd, matcher.start());
            String strGroup = matcher.group();
            strGroup.hashCode();
            switch (strGroup.hashCode()) {
                case 8:
                    if (!strGroup.equals("\b")) {
                        c = 65535;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 9:
                    if (!strGroup.equals("\t")) {
                    }
                    break;
                case 10:
                    if (strGroup.equals("\n")) {
                        c = 2;
                        break;
                    }
                    break;
                case 12:
                    if (strGroup.equals("\f")) {
                        c = 3;
                        break;
                    }
                    break;
                case 13:
                    if (strGroup.equals("\r")) {
                        c = 4;
                        break;
                    }
                    break;
                case 34:
                    if (strGroup.equals("\"")) {
                        c = 5;
                        break;
                    }
                    break;
                case 92:
                    if (strGroup.equals("\\")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.d.write("\\\\b");
                    break;
                case 1:
                    this.d.write("\\\\t");
                    break;
                case 2:
                    this.d.write("\\\\n");
                    break;
                case 3:
                    this.d.write("\\\\f");
                    break;
                case 4:
                    this.d.write("\\\\r");
                    break;
                case 5:
                    this.d.write("\\\\\"");
                    break;
                case 6:
                    this.d.write("\\\\\\\\");
                    break;
                default:
                    this.d.write("\\\\u");
                    this.d.write(Q(strGroup.charAt(0), 4));
                    break;
            }
            iEnd = matcher.end();
        }
    }

    protected boolean L(String str, Object obj) {
        H(str);
        PathIterator pathIterator = ((Path2D) obj).getPathIterator((n.a.a.h.a.b.a) null);
        double[] dArr = new double[6];
        this.d.write("[");
        this.e += 2;
        String strP = P();
        this.e -= 2;
        boolean z = false;
        while (!pathIterator.isDone()) {
            this.d.println(z ? ", " : "");
            this.d.print(strP);
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            this.d.append((CharSequence) "{ \"type\": ");
            if (iCurrentSegment == 0) {
                this.d.write("\"move\", \"x\": " + dArr[0] + ", \"y\": " + dArr[1]);
            } else if (iCurrentSegment == 1) {
                this.d.write("\"lineto\", \"x\": " + dArr[0] + ", \"y\": " + dArr[1]);
            } else if (iCurrentSegment == 2) {
                this.d.write("\"quad\", \"x1\": " + dArr[0] + ", \"y1\": " + dArr[1] + ", \"x2\": " + dArr[2] + ", \"y2\": " + dArr[3]);
            } else if (iCurrentSegment == 3) {
                this.d.write("\"cubic\", \"x1\": " + dArr[0] + ", \"y1\": " + dArr[1] + ", \"x2\": " + dArr[2] + ", \"y2\": " + dArr[3] + ", \"x3\": " + dArr[4] + ", \"y3\": " + dArr[5]);
            } else if (iCurrentSegment == 4) {
                this.d.write("\"close\"");
            }
            this.d.append((CharSequence) " }");
            pathIterator.next();
            z = true;
        }
        this.d.write("]");
        return true;
    }

    protected boolean M(String str, Object obj) {
        H(str);
        Point2D point2D = (Point2D) obj;
        this.d.write("{ \"x\": " + point2D.getX() + ", \"y\": " + point2D.getY() + " }");
        return true;
    }

    protected boolean N(String str, Object obj) {
        H(str);
        Rectangle2D rectangle2D = (Rectangle2D) obj;
        this.d.write("{ \"x\": " + rectangle2D.getX() + ", \"y\": " + rectangle2D.getY() + ", \"width\": " + rectangle2D.getWidth() + ", \"height\": " + rectangle2D.getHeight() + " }");
        return true;
    }

    public void O(boolean z) {
        this.f = z;
    }

    protected String P() {
        String str = f2501h;
        return str.substring(0, Math.min(this.e, str.length()));
    }

    public void R(n.a.a.e.a.a aVar) {
        String strP = P();
        Enum<?> enumJ = aVar.j();
        String strName = enumJ != null ? enumJ.name() : aVar.getClass().getSimpleName();
        this.d.append((CharSequence) strP);
        this.d.append((CharSequence) "{");
        if (this.f) {
            this.d.append((CharSequence) "   /* ");
            this.d.append((CharSequence) strName);
            if (this.g > 0) {
                this.d.append((CharSequence) " - index: ");
                this.d.print(this.g);
            }
            this.d.append((CharSequence) " */");
        }
        this.d.println();
        boolean zU = U(aVar);
        this.d.println();
        S(aVar, zU);
        this.d.append((CharSequence) strP);
        this.d.append((CharSequence) "}");
    }

    protected boolean S(n.a.a.e.a.a aVar, boolean z) {
        List<? extends n.a.a.e.a.a> listH = aVar.h();
        if (listH == null || listH.isEmpty()) {
            return false;
        }
        this.e++;
        r0 r0Var = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(P());
        sb.append(z ? ", " : "");
        sb.append("\"children\": [");
        sb.append(f2503j);
        r0Var.a(sb.toString());
        int i2 = this.g;
        this.g = 0;
        long jCount = listH.stream().filter(new Predicate() { // from class: n.a.a.o.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.i((n.a.a.e.a.a) obj);
            }
        }).count();
        this.g = i2;
        this.c.a(null);
        if (jCount > 0) {
            this.d.println();
            this.d.println(P() + "]");
        }
        this.e--;
        return jCount > 0;
    }

    protected boolean T(String str, Supplier<?> supplier) {
        StringBuilder sb;
        String str2;
        boolean z = this.g > 0;
        r0 r0Var = this.c;
        if (z) {
            sb = new StringBuilder();
            sb.append(f2503j);
            sb.append(P());
            str2 = "\t, ";
        } else {
            sb = new StringBuilder();
            sb.append(P());
            str2 = "\t  ";
        }
        sb.append(str2);
        r0Var.a(sb.toString());
        int i2 = this.g;
        this.g = 0;
        boolean zV = V(str, supplier.get());
        this.g = i2 + (zV ? 1 : 0);
        this.c.a(null);
        return zV;
    }

    protected boolean U(n.a.a.e.a.a aVar) {
        Map<String, Supplier<?>> mapE = aVar.e();
        if (mapE == null || mapE.isEmpty()) {
            return false;
        }
        int i2 = this.g;
        this.g = 0;
        long jCount = mapE.entrySet().stream().filter(new Predicate() { // from class: n.a.a.o.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.m((Map.Entry) obj);
            }
        }).count();
        this.g = i2;
        return jCount > 0;
    }

    protected boolean V(String str, final Object obj) {
        if (this.g > 0) {
            this.c.a(",");
        }
        s0 s0Var = obj == null ? new s0() { // from class: n.a.a.o.d0
            @Override // n.a.a.o.s0
            public final boolean a(t0 t0Var, String str2, Object obj2) {
                return t0Var.I(str2, obj2);
            }
        } : (s0) f2504k.stream().filter(new Predicate() { // from class: n.a.a.o.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return t0.q((Class) ((Map.Entry) obj2).getKey(), obj);
            }
        }).findFirst().map(new Function() { // from class: n.a.a.o.j0
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return (s0) ((Map.Entry) obj2).getValue();
            }
        }).orElse(null);
        boolean z = s0Var != null && s0Var.a(this, str, obj);
        this.c.a(null);
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    protected boolean s(String str, Object obj) {
        H(str);
        n.a.a.h.a.b.a aVar = (n.a.a.h.a.b.a) obj;
        this.d.write("{ \"scaleX\": " + aVar.getScaleX() + ", \"shearX\": " + aVar.getShearX() + ", \"transX\": " + aVar.getTranslateX() + ", \"scaleY\": " + aVar.getScaleY() + ", \"shearY\": " + aVar.getShearY() + ", \"transY\": " + aVar.getTranslateY() + " }");
        return true;
    }

    protected boolean u(String str, Object obj) {
        H(str);
        u0 u0Var = (u0) obj;
        this.d.print(u0Var.b().get().longValue());
        if (!this.f) {
            return true;
        }
        this.d.write(" /* ");
        this.d.write(u0Var.a());
        this.d.write(" */ ");
        return true;
    }

    protected boolean w(String str, Object obj) {
        H(str);
        this.d.write("[");
        int length = Array.getLength(obj);
        int i2 = this.g;
        int i3 = 0;
        while (true) {
            this.g = i3;
            int i4 = this.g;
            if (i4 >= length) {
                this.g = i2;
                this.d.write(P() + "\t]");
                return true;
            }
            V(null, Array.get(obj, i4));
            i3 = this.g + 1;
        }
    }

    protected boolean x(String str, Object obj) {
        H(str);
        this.d.write(((Boolean) obj).toString());
        return true;
    }

    protected boolean y(String str, Object obj) {
        H(str);
        this.d.write(34);
        this.d.write(Base64.getEncoder().encodeToString((byte[]) obj));
        this.d.write(34);
        return true;
    }

    protected boolean z(String str, Object obj) {
        H(str);
        int iC = ((n.a.a.h.a.a) obj).c();
        this.d.print(iC);
        if (!this.f) {
            return true;
        }
        this.d.write(" /* 0x");
        this.d.write(Q(iC, 8));
        this.d.write(" */");
        return true;
    }
}
