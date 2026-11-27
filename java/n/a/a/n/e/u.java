package n.a.a.n.e;

import java.text.DateFormatSymbols;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import n.a.a.o.a1;

/* loaded from: classes.dex */
public abstract class u {
    public static LocalDate a(String str) throws n.a.a.n.c.r1.p {
        for (t tVar : t.values()) {
            Matcher matcher = tVar.c.matcher(str);
            if (matcher.find()) {
                MatchResult matchResult = matcher.toMatchResult();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 1; i2 <= matchResult.groupCount(); i2++) {
                    arrayList.add(matchResult.group(i2));
                }
                try {
                    return LocalDate.of(tVar.d ? Integer.parseInt((String) arrayList.get(tVar.e)) : LocalDate.now(a1.f().toZoneId()).getYear(), b((String) arrayList.get(tVar.f)), Integer.parseInt((String) arrayList.get(tVar.g)));
                } catch (DateTimeException unused) {
                    throw new DateTimeException("Failed to parse date-string " + str);
                }
            }
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            String[] months = DateFormatSymbols.getInstance(a1.e()).getMonths();
            for (int i2 = 0; i2 < months.length; i2++) {
                if (months[i2].toLowerCase(a1.e()).startsWith(str.toLowerCase(a1.e()))) {
                    return i2 + 1;
                }
            }
            return -1;
        }
    }
}
