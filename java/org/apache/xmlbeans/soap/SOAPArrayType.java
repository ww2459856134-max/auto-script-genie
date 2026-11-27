package org.apache.xmlbeans.soap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes2.dex */
public final class SOAPArrayType {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private int[] _dimensions;
    private int[] _ranks;
    private QName _type;

    public SOAPArrayType(String str, PrefixResolver prefixResolver) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            throw new XmlValueOutOfRangeException();
        }
        String strCollapse = XmlWhitespace.collapse(str.substring(0, iIndexOf), 3);
        int iIndexOf2 = strCollapse.indexOf(58);
        String namespaceForPrefix = prefixResolver.getNamespaceForPrefix(iIndexOf2 >= 0 ? strCollapse.substring(0, iIndexOf2) : "");
        if (namespaceForPrefix == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._type = QNameHelper.forLNS(strCollapse.substring(iIndexOf2 + 1), namespaceForPrefix);
        initDimensions(str, iIndexOf);
    }

    static /* synthetic */ String b(int i2) {
        return i2 >= 0 ? Integer.toString(i2) : "";
    }

    static /* synthetic */ String c(int i2) {
        return i2 >= 0 ? Integer.toString(i2) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int collapseDimString(String str) {
        String strCollapse = XmlWhitespace.collapse(str, 3);
        try {
            if (!"*".equals(strCollapse) && !strCollapse.isEmpty()) {
                return Integer.parseInt(strCollapse);
            }
            return -1;
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
        }
    }

    private void initDimensions(String str, int i2) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = -1;
        while (i2 >= 0) {
            iIndexOf = str.indexOf(93, i2);
            if (iIndexOf < 0) {
                throw new XmlValueOutOfRangeException();
            }
            arrayList.add(str.substring(i2 + 1, iIndexOf));
            i2 = str.indexOf(91, iIndexOf);
        }
        if (!XmlWhitespace.isAllSpace(str.substring(iIndexOf + 1))) {
            throw new XmlValueOutOfRangeException();
        }
        this._ranks = new int[arrayList.size() - 1];
        for (int i3 = 0; i3 < this._ranks.length; i3++) {
            String str2 = (String) arrayList.get(i3);
            int i4 = 0;
            for (int i5 = 0; i5 < str2.length(); i5++) {
                char cCharAt = str2.charAt(i5);
                if (cCharAt == ',') {
                    i4++;
                } else if (!XmlWhitespace.isSpace(cCharAt)) {
                    throw new XmlValueOutOfRangeException();
                }
            }
            this._ranks[i3] = i4 + 1;
        }
        this._dimensions = internalParseCommaIntString((String) arrayList.get(arrayList.size() - 1));
    }

    private static int[] internalParseCommaIntString(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf < 0) {
                arrayList.add(str.substring(i2));
                return arrayList.stream().mapToInt(new ToIntFunction() { // from class: org.apache.xmlbeans.soap.a
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return SOAPArrayType.collapseDimString((String) obj);
                    }
                }).toArray();
            }
            arrayList.add(str.substring(i2, iIndexOf));
            i2 = iIndexOf + 1;
        }
    }

    public static SOAPArrayType newSoap12Array(QName qName, String str) {
        String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
        int[] iArr = new int[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String str2 = strArrSplit[i2];
            if (i2 == 0 && str2.equals("*")) {
                iArr[i2] = -1;
            } else {
                try {
                    iArr[i2] = Integer.parseInt(strArrSplit[i2]);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException();
                }
            }
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._ranks = EMPTY_INT_ARRAY;
        sOAPArrayType._type = qName;
        sOAPArrayType._dimensions = iArr;
        return sOAPArrayType;
    }

    public boolean containsNestedArrays() {
        return this._ranks.length > 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SOAPArrayType)) {
            return false;
        }
        SOAPArrayType sOAPArrayType = (SOAPArrayType) obj;
        return this._type.equals(sOAPArrayType._type) && Arrays.equals(this._ranks, sOAPArrayType._ranks) && Arrays.equals(this._dimensions, sOAPArrayType._dimensions);
    }

    public int[] getDimensions() {
        int[] iArr = this._dimensions;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public QName getQName() {
        return this._type;
    }

    public int[] getRanks() {
        int[] iArr = this._ranks;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public int hashCode() {
        int iHashCode = this._type.hashCode();
        int[] iArr = this._dimensions;
        return iHashCode + iArr.length + this._ranks.length + (iArr.length != 0 ? iArr[0] : 0);
    }

    public boolean isSameRankAs(SOAPArrayType sOAPArrayType) {
        return Arrays.equals(this._ranks, sOAPArrayType._ranks) && this._dimensions.length == sOAPArrayType._dimensions.length;
    }

    public SOAPArrayType nestedArrayType() {
        if (!containsNestedArrays()) {
            throw new IllegalStateException();
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._type = this._type;
        int[] iArr = new int[this._ranks.length - 1];
        sOAPArrayType._ranks = iArr;
        System.arraycopy(this._ranks, 0, iArr, 0, iArr.length);
        int[] iArr2 = new int[this._ranks[r1.length - 1]];
        sOAPArrayType._dimensions = iArr2;
        Arrays.fill(iArr2, -1);
        return sOAPArrayType;
    }

    public String soap11DimensionString() {
        return soap11DimensionString(this._dimensions);
    }

    public String soap12DimensionString(int[] iArr) {
        return (String) IntStream.of(iArr).mapToObj(new IntFunction() { // from class: org.apache.xmlbeans.soap.c
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SOAPArrayType.c(i2);
            }
        }).collect(Collectors.joining(" "));
    }

    public String soap11DimensionString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 : this._ranks) {
            sb.append('[');
            for (int i3 = 1; i3 < i2; i3++) {
                sb.append(',');
            }
            sb.append(']');
        }
        sb.append((String) IntStream.of(iArr).mapToObj(new IntFunction() { // from class: org.apache.xmlbeans.soap.b
            @Override // java.util.function.IntFunction
            public final Object apply(int i4) {
                return SOAPArrayType.b(i4);
            }
        }).collect(Collectors.joining(",", "[", "]")));
        return sb.toString();
    }

    public SOAPArrayType(QName qName, String str) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            this._type = qName;
            this._ranks = EMPTY_INT_ARRAY;
            String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                if (strArrSplit[i2].equals("*")) {
                    this._dimensions[i2] = -1;
                } else {
                    try {
                        this._dimensions[i2] = Integer.parseInt(strArrSplit[i2]);
                    } catch (Exception unused) {
                        throw new XmlValueOutOfRangeException();
                    }
                }
            }
            return;
        }
        this._type = qName;
        initDimensions(str, iIndexOf);
    }

    public SOAPArrayType(SOAPArrayType sOAPArrayType, int[] iArr) {
        this._type = sOAPArrayType._type;
        int[] iArr2 = new int[sOAPArrayType._ranks.length + 1];
        this._ranks = iArr2;
        int[] iArr3 = sOAPArrayType._ranks;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        this._ranks[r0.length - 1] = sOAPArrayType._dimensions.length;
        int[] iArr4 = new int[iArr.length];
        this._dimensions = iArr4;
        System.arraycopy(iArr, 0, iArr4, 0, iArr.length);
    }

    private SOAPArrayType() {
    }
}
