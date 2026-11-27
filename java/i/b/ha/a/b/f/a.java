package i.b.ha.a.b.f;

import java.lang.Character;
import java.util.Arrays;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class a {
    public static String a(String str) {
        Character.UnicodeBlock unicodeBlockOf;
        char[] charArray = str.toCharArray();
        char[] cArrCopyOf = charArray.length <= 255 ? charArray : Arrays.copyOf(charArray, 255);
        if (charArray.length > 255) {
            Arrays.fill(cArrCopyOf, 252, 255, NameUtil.PERIOD);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cArrCopyOf) {
            if (Character.isISOControl(c) || (unicodeBlockOf = Character.UnicodeBlock.of(c)) == null || unicodeBlockOf == Character.UnicodeBlock.SPECIALS) {
                sb.append('?');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
