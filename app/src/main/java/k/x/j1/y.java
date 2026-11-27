package k.x.j1;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tencent.open.SocialConstants;
import org.apache.xmlbeans.XmlErrorCodes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
final class y {
    private static y[] d;
    public static final y e;
    public static final y f;
    public static final y g;

    /* renamed from: h, reason: collision with root package name */
    public static final y f2149h;

    /* renamed from: i, reason: collision with root package name */
    public static final y f2150i;
    private final int a;
    private final String b;
    private final int c;

    static {
        k.y.c.b(y.class);
        d = new y[0];
        new y(0, "count", 255);
        e = new y(1, "", 255);
        new y(2, "isna", 1);
        new y(3, "iserror", 1);
        f = new y(4, "sum", 255);
        new y(5, "average", 255);
        new y(6, "min", 255);
        new y(7, "max", 255);
        new y(8, "row", 255);
        new y(9, "column", 255);
        new y(10, "na", 0);
        new y(11, "npv", 255);
        new y(12, "stdev", 255);
        new y(13, "dollar", 2);
        new y(14, "fixed", 255);
        new y(15, "sin", 1);
        new y(16, "cos", 1);
        new y(17, "tan", 1);
        new y(18, "atan", 1);
        new y(19, "pi", 0);
        new y(20, "sqrt", 1);
        new y(21, "exp", 1);
        new y(22, "ln", 1);
        new y(23, "log10", 1);
        new y(24, "abs", 1);
        new y(25, XmlErrorCodes.INT, 1);
        new y(26, "sign", 1);
        new y(27, "round", 2);
        new y(28, "lookup", 2);
        new y(29, "index", 3);
        new y(30, "rept", 2);
        new y(31, "mid", 3);
        new y(32, "len", 1);
        new y(33, "value", 1);
        new y(34, "true", 0);
        new y(35, "false", 0);
        new y(36, "and", 255);
        new y(37, "or", 255);
        new y(38, "not", 1);
        new y(39, "mod", 2);
        new y(40, "dcount", 3);
        new y(41, "dsum", 3);
        new y(42, "daverage", 3);
        new y(43, "dmin", 3);
        new y(44, "dmax", 3);
        new y(45, "dstdev", 3);
        new y(46, "var", 255);
        new y(47, "dvar", 3);
        new y(48, "text", 2);
        new y(49, "linest", 255);
        new y(50, "trend", 255);
        new y(51, "logest", 255);
        new y(52, "growth", 255);
        new y(56, "pv", 255);
        new y(57, "fv", 255);
        new y(58, "nper", 255);
        new y(59, "pmt", 255);
        new y(60, "rate", 255);
        new y(63, "rand", 0);
        new y(64, "match", 3);
        new y(65, XmlErrorCodes.DATE, 3);
        new y(66, "time", 3);
        new y(67, "day", 1);
        new y(68, "month", 1);
        new y(69, "year", 1);
        new y(70, "weekday", 2);
        new y(71, "hour", 1);
        new y(72, "minute", 1);
        new y(73, "second", 1);
        new y(74, "now", 0);
        new y(75, "areas", 255);
        new y(76, "rows", 1);
        new y(77, "columns", 255);
        new y(78, "offset", 255);
        new y(82, "search", 255);
        new y(83, "transpose", 255);
        new y(84, "error", 1);
        new y(86, SocialConstants.PARAM_TYPE, 1);
        new y(97, "atan2", 1);
        new y(98, "asin", 1);
        new y(99, "acos", 1);
        new y(100, "choose", 255);
        new y(101, "hlookup", 255);
        new y(102, "vlookup", 255);
        new y(105, "isref", 1);
        new y(109, "log", 255);
        new y(111, "char", 1);
        new y(112, "lower", 1);
        new y(113, "upper", 1);
        new y(114, "proper", 1);
        new y(115, "left", 255);
        new y(116, "right", 255);
        new y(117, "exact", 2);
        new y(118, "trim", 1);
        new y(119, "replace", 4);
        new y(120, "substitute", 255);
        new y(121, "code", 1);
        new y(124, "find", 255);
        new y(125, "cell", 2);
        new y(126, "iserr", 1);
        new y(127, "istext", 1);
        new y(128, "isnumber", 1);
        new y(129, "isblank", 1);
        new y(130, "t", 1);
        new y(131, "n", 1);
        new y(140, "datevalue", 1);
        new y(141, "timevalue", 1);
        new y(142, "sln", 3);
        new y(143, "syd", 3);
        new y(144, "ddb", 255);
        new y(148, "indirect", 255);
        new y(162, "clean", 1);
        new y(163, "mdeterm", 255);
        new y(164, "minverse", 255);
        new y(165, "mmult", 255);
        new y(167, "ipmt", 255);
        new y(168, "ppmt", 255);
        new y(169, "counta", 255);
        new y(183, "product", 255);
        new y(184, "fact", 1);
        new y(189, "dproduct", 3);
        new y(190, "isnontext", 1);
        new y(STBorder.INT_CUSTOM, "stdevp", 255);
        new y(194, "varp", 255);
        new y(195, "dstdevp", 255);
        new y(196, "dvarp", 255);
        new y(197, "trunc", 255);
        new y(198, "islogical", 1);
        new y(199, "dcounta", 255);
        new y(205, "findb", 255);
        new y(206, "searchb", 3);
        new y(207, "replaceb", 4);
        new y(208, "leftb", 255);
        new y(209, "rightb", 255);
        new y(210, "midb", 3);
        new y(211, "lenb", 1);
        new y(212, "roundup", 2);
        new y(213, "rounddown", 2);
        new y(216, "rank", 255);
        new y(219, "address", 255);
        new y(220, "days360", 255);
        new y(221, "today", 0);
        new y(222, "vdb", 255);
        new y(227, "median", 255);
        g = new y(228, "sumproduct", 255);
        new y(229, "sinh", 1);
        new y(230, "cosh", 1);
        new y(231, "tanh", 1);
        new y(232, "asinh", 1);
        new y(233, "acosh", 1);
        new y(234, "atanh", 1);
        new y(244, "info", 1);
        new y(269, "avedev", 255);
        new y(270, "betadist", 255);
        new y(271, "gammaln", 1);
        new y(272, "betainv", 255);
        new y(BaseQuickAdapter.HEADER_VIEW, "binomdist", 4);
        new y(274, "chidist", 2);
        new y(275, "chiinv", 2);
        new y(276, "combin", 2);
        new y(277, "confidence", 3);
        new y(278, "critbinom", 3);
        new y(279, "even", 1);
        new y(280, "expondist", 3);
        new y(281, "fdist", 3);
        new y(282, "finv", 3);
        new y(283, "fisher", 1);
        new y(284, "fisherinv", 1);
        new y(285, "floor", 2);
        new y(286, "gammadist", 4);
        new y(287, "gammainv", 3);
        new y(288, "ceiling", 2);
        new y(289, "hypgeomdist", 4);
        new y(290, "lognormdist", 3);
        new y(291, "loginv", 3);
        new y(292, "negbinomdist", 3);
        new y(293, "normdist", 4);
        new y(294, "normsdist", 1);
        new y(295, "norminv", 3);
        new y(296, "normsinv", 1);
        new y(297, "standardize", 3);
        new y(298, "odd", 1);
        new y(299, "permut", 2);
        new y(300, "poisson", 3);
        new y(301, "tdist", 3);
        new y(302, "weibull", 4);
        new y(303, "sumxmy2", 255);
        new y(304, "sumx2my2", 255);
        new y(305, "sumx2py2", 255);
        new y(306, "chitest", 255);
        new y(307, "correl", 255);
        new y(308, "covar", 255);
        new y(309, "forecast", 255);
        new y(310, "ftest", 255);
        new y(311, "intercept", 255);
        new y(312, "pearson", 255);
        new y(313, "rsq", 255);
        new y(314, "steyx", 255);
        new y(315, "slope", 2);
        new y(316, "ttest", 255);
        new y(317, "prob", 255);
        new y(318, "devsq", 255);
        new y(319, "geomean", 255);
        new y(320, "harmean", 255);
        new y(321, "sumsq", 255);
        new y(322, "kurt", 255);
        new y(323, "skew", 255);
        new y(324, "ztest", 255);
        new y(325, "large", 255);
        new y(326, "small", 255);
        new y(327, "quartile", 255);
        new y(328, "percentile", 255);
        new y(329, "percentrank", 255);
        new y(330, "mode", 255);
        new y(331, "trimmean", 255);
        new y(332, "tinv", 2);
        new y(336, "concatenate", 255);
        new y(337, "power", 2);
        new y(342, "radians", 1);
        new y(343, "degrees", 1);
        new y(344, "subtotal", 255);
        new y(345, "sumif", 255);
        new y(346, "countif", 2);
        new y(347, "countblank", 1);
        new y(359, "hyperlink", 2);
        new y(361, "averagea", 255);
        new y(362, "maxa", 255);
        new y(363, "mina", 255);
        new y(364, "stdevpa", 255);
        new y(365, "varpa", 255);
        new y(366, "stdeva", 255);
        new y(367, "vara", 255);
        f2149h = new y(65534, "if", 255);
        f2150i = new y(65535, "", 0);
    }

    private y(int i2, String str, int i3) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        y[] yVarArr = d;
        y[] yVarArr2 = new y[yVarArr.length + 1];
        System.arraycopy(yVarArr, 0, yVarArr2, 0, yVarArr.length);
        yVarArr2[d.length] = this;
        d = yVarArr2;
    }

    public static y b(int i2) {
        y yVar;
        int i3 = 0;
        while (true) {
            y[] yVarArr = d;
            if (i3 >= yVarArr.length) {
                yVar = null;
                break;
            }
            if (yVarArr[i3].a == i2) {
                yVar = yVarArr[i3];
                break;
            }
            i3++;
        }
        return yVar != null ? yVar : f2150i;
    }

    public static y c(String str, k.w wVar) {
        y yVarA = wVar.i().a(str);
        return yVarA != null ? yVarA : f2150i;
    }

    static y[] d() {
        return d;
    }

    int a() {
        return this.a;
    }

    String e(k.w wVar) {
        return wVar.i().b(this);
    }

    int f() {
        return this.c;
    }

    String g() {
        return this.b;
    }

    public int hashCode() {
        return this.a;
    }
}
