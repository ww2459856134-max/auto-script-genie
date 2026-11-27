package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class StringEnumAbstractBase implements Serializable {
    private static final long serialVersionUID = 1;
    private int _int;
    private String _string;

    public static final class Table {
        private List<StringEnumAbstractBase> _list;
        private Map<String, StringEnumAbstractBase> _map;

        public Table(StringEnumAbstractBase[] stringEnumAbstractBaseArr) {
            this._map = new HashMap(stringEnumAbstractBaseArr.length);
            this._list = new ArrayList(stringEnumAbstractBaseArr.length + 1);
            for (int i2 = 0; i2 < stringEnumAbstractBaseArr.length; i2++) {
                this._map.put(stringEnumAbstractBaseArr[i2].toString(), stringEnumAbstractBaseArr[i2]);
                int iIntValue = stringEnumAbstractBaseArr[i2].intValue();
                while (this._list.size() <= iIntValue) {
                    this._list.add(null);
                }
                this._list.set(iIntValue, stringEnumAbstractBaseArr[i2]);
            }
        }

        public StringEnumAbstractBase forInt(int i2) {
            if (i2 < 0 || i2 > this._list.size()) {
                return null;
            }
            return this._list.get(i2);
        }

        public StringEnumAbstractBase forString(String str) {
            return this._map.get(str);
        }

        public int lastInt() {
            return this._list.size() - 1;
        }
    }

    protected StringEnumAbstractBase(String str, int i2) {
        this._string = str;
        this._int = i2;
    }

    public final int hashCode() {
        return this._string.hashCode();
    }

    public final int intValue() {
        return this._int;
    }

    public final String toString() {
        return this._string;
    }
}
