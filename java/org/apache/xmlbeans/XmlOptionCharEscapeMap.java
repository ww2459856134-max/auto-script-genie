package org.apache.xmlbeans;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class XmlOptionCharEscapeMap {
    public static final int DECIMAL = 1;
    public static final int HEXADECIMAL = 2;
    public static final int PREDEF_ENTITY = 0;
    private static final Map<Character, String> _predefEntities;
    private final Map<Character, String> _charMap = new HashMap();

    static {
        HashMap map = new HashMap();
        map.put('<', "&lt;");
        map.put('>', "&gt;");
        map.put('&', "&amp;");
        map.put(Character.valueOf(Chars.QUOTE), "&apos;");
        map.put(Character.valueOf(Chars.DQUOTE), "&quot;");
        _predefEntities = Collections.unmodifiableMap(map);
    }

    public void addMapping(char c, int i2) throws XmlException {
        Character chValueOf = Character.valueOf(c);
        if (i2 == 0) {
            String str = _predefEntities.get(chValueOf);
            if (str == null) {
                throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
            }
            this._charMap.put(chValueOf, str);
            return;
        }
        if (i2 == 1) {
            this._charMap.put(chValueOf, "&#" + ((int) c) + ";");
            return;
        }
        if (i2 != 2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
        }
        String hexString = Integer.toHexString(c);
        this._charMap.put(chValueOf, "&#x" + hexString + ";");
    }

    public void addMappings(char c, char c2, int i2) throws XmlException {
        if (c > c2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
        }
        while (c <= c2) {
            addMapping(c, i2);
            c = (char) (c + 1);
        }
    }

    public boolean containsChar(char c) {
        return this._charMap.containsKey(Character.valueOf(c));
    }

    public String getEscapedString(char c) {
        return this._charMap.get(Character.valueOf(c));
    }
}
