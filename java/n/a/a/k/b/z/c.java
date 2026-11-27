package n.a.a.k.b.z;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c {
    private static final Pattern d = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)$");
    private static final Pattern e;
    private static final Pattern f;
    private final String a;
    private final String b;
    private final Map<String, String> c;

    static {
        String str = "([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+\"?)";
        e = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)(;" + str + ")*$");
        StringBuilder sb = new StringBuilder();
        sb.append(";");
        sb.append(str);
        f = Pattern.compile(sb.toString());
    }

    public c(String str) throws n.a.a.k.a.a {
        Matcher matcher = d.matcher(str);
        matcher = matcher.matches() ? matcher : e.matcher(str);
        if (!matcher.matches()) {
            throw new n.a.a.k.a.a("The specified content type '" + str + "' is not compliant with RFC 2616: malformed content type.");
        }
        if (matcher.groupCount() < 2) {
            this.a = "";
            this.b = "";
            this.c = Collections.emptyMap();
            return;
        }
        this.a = matcher.group(1);
        this.b = matcher.group(2);
        this.c = new HashMap();
        if (matcher.groupCount() >= 5) {
            Matcher matcher2 = f.matcher(str.substring(matcher.end(2)));
            while (matcher2.find()) {
                this.c.put(matcher2.group(1), matcher2.group(2));
            }
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public final String c(boolean z) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(b());
        sb.append('/');
        sb.append(a());
        if (z) {
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                sb.append(';');
                sb.append(entry.getKey());
                sb.append(Chars.EQ);
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof c) || toString().equalsIgnoreCase(obj.toString());
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }

    public final String toString() {
        return c(true);
    }
}
