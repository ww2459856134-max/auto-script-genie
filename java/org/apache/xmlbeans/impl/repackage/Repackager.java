package org.apache.xmlbeans.impl.repackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class Repackager {
    private Matcher[] _fromMatchers;
    private String[] _toPackageNames;
    private final List<List<String>> _fromPackages = new ArrayList();
    private final List<List<String>> _toPackages = new ArrayList();

    public Repackager(String str) {
        boolean z;
        List<String> listSplitPath = splitPath(str, ';');
        do {
            z = false;
            for (int i2 = 1; i2 < listSplitPath.size(); i2++) {
                int i3 = i2 - 1;
                String str2 = listSplitPath.get(i3);
                String str3 = listSplitPath.get(i2);
                if (str2.indexOf(58) < str3.indexOf(58)) {
                    listSplitPath.set(i3, str3);
                    listSplitPath.set(i2, str2);
                    z = true;
                }
            }
        } while (z);
        for (String str4 : listSplitPath) {
            int iIndexOf = str4.indexOf(58);
            if (iIndexOf >= 0) {
                int i4 = iIndexOf + 1;
                if (str4.indexOf(58, i4) < 0) {
                    String strSubstring = str4.substring(0, iIndexOf);
                    String strSubstring2 = str4.substring(i4);
                    this._fromPackages.add(splitPath(strSubstring, NameUtil.PERIOD));
                    this._toPackages.add(splitPath(strSubstring2, NameUtil.PERIOD));
                }
            }
            throw new RuntimeException("Illegal repackage specification: " + str4);
        }
        this._fromMatchers = new Matcher[this._fromPackages.size() * 2];
        this._toPackageNames = new String[this._fromPackages.size() * 2];
        addPatterns(NameUtil.PERIOD, 0);
        addPatterns('/', this._fromPackages.size());
    }

    public static String dirForPath(String str) {
        return new File(str).getParent();
    }

    public static List<String> splitPath(String str, char c) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iIndexOf = str.indexOf(c);
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(str.substring(0, iIndexOf));
            str = str.substring(iIndexOf + 1);
        }
        if (!str.isEmpty()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    void addPatterns(char c, int i2) {
        for (int i3 = 0; i3 < this._fromPackages.size(); i3++) {
            List<String> list = this._fromPackages.get(i3);
            List<String> list2 = this._toPackages.get(i3);
            String str = "";
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (i4 > 0) {
                    str = str + "\\" + c;
                }
                str = str + list.get(i4);
            }
            String str2 = "";
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (i5 > 0) {
                    str2 = str2 + c;
                }
                str2 = str2 + list2.get(i5);
            }
            int i6 = i2 + i3;
            this._fromMatchers[i6] = Pattern.compile(str).matcher("");
            this._toPackageNames[i6] = str2;
        }
    }

    public List<List<String>> getFromPackages() {
        return this._fromPackages;
    }

    public List<List<String>> getToPackages() {
        return this._toPackages;
    }

    public StringBuffer repackage(StringBuffer stringBuffer) {
        int i2 = 0;
        StringBuffer stringBuffer2 = null;
        while (true) {
            Matcher[] matcherArr = this._fromMatchers;
            if (i2 >= matcherArr.length) {
                return stringBuffer;
            }
            Matcher matcher = matcherArr[i2];
            matcher.reset(stringBuffer);
            while (matcher.find()) {
                if (stringBuffer2 == null) {
                    stringBuffer2 = new StringBuffer();
                }
                matcher.appendReplacement(stringBuffer2, this._toPackageNames[i2]);
            }
            if (stringBuffer2 != null) {
                matcher.appendTail(stringBuffer2);
                stringBuffer = stringBuffer2;
                stringBuffer2 = null;
            }
            i2++;
        }
    }
}
