package i.e.a.i;

/* loaded from: classes.dex */
public abstract class b {
    public static String A = "Illegal input: {0} contains a character (code {1}) that can only be output as character entity";
    public static String B = "Illegal input: SPACE content has a non-whitespace character (code {0}) in it (index {1})";
    public static String C = "Trying to write an attribute when there is no open start element.";
    public static String D = "Trying to write a namespace declaration when there is no open start element.";
    public static String E = "Illegal to pass empty name";
    public static String F = "xml declaration";
    public static String G = "Inconsistent text encoding; declared as \"{0}\" in xml declaration, application had passed \"{1}\"";
    public static String a = "Illegal to pass null as argument";
    public static String b = "Element <{0}> has EMPTY content specification; can not contain {1}";
    public static String c = "Element <{0}> has non-mixed content specification; can not contain non-white space text, or any CDATA sections";
    public static String d = "Element <{0}> has ANY content specification; can not contain {1}";
    public static String e = "Current state not START_ELEMENT";
    public static String f = "Current state not START_ELEMENT or END_ELEMENT";
    public static String g = "Current state not PROCESSING_INSTRUCTION";

    /* renamed from: h, reason: collision with root package name */
    public static String f1561h = "Current state not START_ELEMENT, CHARACTERS or CDATA";

    /* renamed from: i, reason: collision with root package name */
    public static String f1562i = " in prolog";

    /* renamed from: j, reason: collision with root package name */
    public static String f1563j = " in epilog";

    /* renamed from: k, reason: collision with root package name */
    public static String f1564k = " in xml document";

    /* renamed from: l, reason: collision with root package name */
    public static String f1565l = "Illegal processing instruction target: 'xml' (case insensitive) is reserved by the xml specification";

    /* renamed from: m, reason: collision with root package name */
    public static String f1566m = "Duplicate attributes \"{0}\" (index {1}), \"{2}\" (index {3})";

    /* renamed from: n, reason: collision with root package name */
    public static String f1567n = "Trying to redeclare prefix 'xml' from its default URI 'http://www.w3.org/XML/1998/namespace' to \"{0}\"";

    /* renamed from: o, reason: collision with root package name */
    public static String f1568o = "Trying to declare prefix 'xmlns' (illegal as per NS 1.1 #4)";
    public static String p = "Trying to bind URI 'http://www.w3.org/XML/1998/namespace to prefix \"{0}\" (can only bind to 'xml')";
    public static String q = "Trying to bind URI 'http://www.w3.org/2000/xmlns/ to prefix \"{0}\" (can not be explicitly bound)";
    public static String r = "Non-default namespace can not map to empty URI (as per Namespace 1.0 # 2) in XML 1.0 documents";
    public static String s = "Trying to output a CDATA block outside main element tree (in prolog or epilog)";
    public static String t = "Trying to output an entity reference outside main element tree (in prolog or epilog)";
    public static String u = "Trying to output second root, <{0}>";
    public static String v = "Trying to write END_DOCUMENT when document has no root (ie. trying to output empty document).";
    public static String w = "Can not output XML declaration, after other output has already been done.";
    public static String x = "Illegal input: CDATA block has embedded ']]>' in it (index {0})";
    public static String y = "Illegal input: comment content has embedded '--' in it (index {0})";
    public static String z = "Illegal input: processing instruction content has embedded '?>' in it (index {0})";

    public static void a() {
        b(null);
        throw null;
    }

    public static void b(String str) {
        String str2 = "Internal error";
        if (str != null) {
            str2 = "Internal error: " + str;
        }
        throw new RuntimeException(str2);
    }

    public static String c(int i2) {
        switch (i2) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
            default:
                return "[" + i2 + "]";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
        }
    }
}
