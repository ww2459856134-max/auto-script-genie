package n.a.a.k.b.z;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import n.a.a.o.a1;

/* loaded from: classes.dex */
public final class k extends n.a.a.k.b.m implements n.a.a.k.b.p {
    private static final String[] W = {"yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ss.SS'Z'", "yyyy-MM-dd"};
    protected Optional<String> A;
    protected Optional<Date> C;
    protected Optional<String> D;
    protected Optional<String> G;
    protected Optional<String> H;
    protected Optional<String> I;
    protected Optional<String> J;
    protected Optional<String> K;
    protected Optional<Date> M;
    protected Optional<Date> O;
    protected Optional<String> P;
    protected Optional<String> Q;
    protected Optional<String> U;
    protected Optional<String> V;

    /* renamed from: i, reason: collision with root package name */
    private final String[] f2293i;

    /* renamed from: j, reason: collision with root package name */
    private final Pattern f2294j;

    /* renamed from: k, reason: collision with root package name */
    protected Optional<String> f2295k;
    protected Optional<String> t;

    public k(n.a.a.k.b.k kVar, n.a.a.k.b.o oVar) throws n.a.a.k.a.a {
        super(kVar, oVar, "application/vnd.openxmlformats-package.core-properties+xml");
        this.f2293i = new String[]{"yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.Sz", "yyyy-MM-dd'T'HH:mm:ss.SSz", "yyyy-MM-dd'T'HH:mm:ss.SSSz"};
        this.f2294j = Pattern.compile("([-+]\\d\\d):?(\\d\\d)");
        this.f2295k = Optional.empty();
        this.t = Optional.empty();
        this.A = Optional.empty();
        this.C = Optional.empty();
        this.D = Optional.empty();
        this.G = Optional.empty();
        this.H = Optional.empty();
        this.I = Optional.empty();
        this.J = Optional.empty();
        this.K = Optional.empty();
        this.M = Optional.empty();
        this.O = Optional.empty();
        this.P = Optional.empty();
        this.Q = Optional.empty();
        this.U = Optional.empty();
        this.V = Optional.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String P(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
        simpleDateFormat.setTimeZone(a1.a);
        return simpleDateFormat.format(date);
    }

    private static String Q(Optional<Date> optional) {
        return (String) optional.map(new Function() { // from class: n.a.a.k.b.z.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.P((Date) obj);
            }
        }).orElse("");
    }

    private static Date f0(String[] strArr, String str) {
        for (String str2 : strArr) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ROOT);
            simpleDateFormat.setTimeZone(a1.a);
            Date date = simpleDateFormat.parse(str, new ParsePosition(0));
            if (date != null) {
                return date;
            }
        }
        return null;
    }

    private Optional<Date> g0(String str) throws n.a.a.k.a.a {
        String str2;
        if (str == null || str.isEmpty()) {
            return Optional.empty();
        }
        Matcher matcher = this.f2294j.matcher(str);
        Date dateF0 = null;
        if (matcher.find()) {
            dateF0 = f0(this.f2293i, str.substring(0, matcher.start()) + matcher.group(1) + matcher.group(2));
        }
        if (dateF0 == null) {
            if (str.endsWith("Z")) {
                str2 = str;
            } else {
                str2 = str + "Z";
            }
            dateF0 = f0(W, str2);
        }
        if (dateF0 != null) {
            return Optional.of(dateF0);
        }
        throw new n.a.a.k.a.a("Date " + str + " not well formatted, expected format in: " + ((String) Stream.of((Object[]) new String[][]{this.f2293i, W}).flatMap(new Function() { // from class: n.a.a.k.b.z.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.of((Object[]) obj);
            }
        }).collect(Collectors.joining(", "))));
    }

    private Optional<String> h0(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.of(str);
    }

    @Override // n.a.a.k.b.m
    public boolean E(OutputStream outputStream) {
        throw new n.a.a.k.a.b("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    public void I() {
    }

    public Optional<String> J() {
        return this.f2295k;
    }

    public Optional<String> K() {
        return this.t;
    }

    public Optional<String> L() {
        return this.A;
    }

    public Optional<Date> M() {
        return this.C;
    }

    public String N() {
        return Q(this.C);
    }

    public Optional<String> O() {
        return this.D;
    }

    public Optional<String> R() {
        return this.G;
    }

    public Optional<String> S() {
        return this.H;
    }

    public Optional<String> T() {
        return this.I;
    }

    public Optional<String> U() {
        return this.J;
    }

    public Optional<String> V() {
        return this.K;
    }

    public Optional<Date> W() {
        return this.M;
    }

    public String X() {
        return Q(this.M);
    }

    public Optional<Date> Y() {
        return this.O;
    }

    public String Z() {
        return this.O.isPresent() ? Q(this.O) : Q(Optional.of(new Date()));
    }

    @Override // n.a.a.k.b.p
    public void a(String str) {
        this.D = h0(str);
    }

    public Optional<String> a0() {
        return this.P;
    }

    public Optional<String> b0() {
        return this.Q;
    }

    public Optional<String> c0() {
        return this.U;
    }

    public Optional<String> d0() {
        return this.V;
    }

    @Override // n.a.a.k.b.m
    public void i() {
    }

    public void i0(String str) {
        this.f2295k = h0(str);
    }

    public void j0(String str) {
        this.t = h0(str);
    }

    public void k0(String str) {
        this.A = h0(str);
    }

    public void l0(String str) throws n.a.a.k.a.a {
        this.C = g0(str);
    }

    public void m0(Optional<Date> optional) {
        this.C = optional;
    }

    @Override // n.a.a.k.b.m
    protected InputStream n() {
        throw new n.a.a.k.a.b("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    public void n0(String str) {
        this.G = h0(str);
    }

    public void o0(String str) {
        this.H = h0(str);
    }

    @Override // n.a.a.k.b.m
    protected OutputStream p() {
        throw new n.a.a.k.a.b("Can't use output stream to set properties !");
    }

    public void p0(String str) {
        this.I = h0(str);
    }

    public void q0(String str) {
        this.J = h0(str);
    }

    public void r0(String str) {
        this.K = h0(str);
    }

    public void s0(String str) throws n.a.a.k.a.a {
        this.M = g0(str);
    }

    public void t0(String str) throws n.a.a.k.a.a {
        this.O = g0(str);
    }

    public void u0(String str) {
        this.P = h0(str);
    }

    public void v0(String str) {
        this.Q = h0(str);
    }

    public void w0(String str) {
        this.U = h0(str);
    }

    public void x0(String str) {
        this.V = h0(str);
    }
}
