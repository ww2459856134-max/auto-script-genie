package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class RangeToken extends Token implements Serializable {
    private static final int MAPSIZE = 256;
    boolean compacted;
    RangeToken icaseCache;
    int[] map;
    int nonMapIndex;
    int[] ranges;
    boolean sorted;

    RangeToken(int i2) {
        super(i2);
        this.icaseCache = null;
        this.map = null;
        setSorted(false);
    }

    static Token complementRanges(Token token) {
        int i2 = token.type;
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException("Token#complementRanges(): must be RANGE: " + token.type);
        }
        RangeToken rangeToken = (RangeToken) token;
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = rangeToken.ranges;
        int length = iArr.length + 2;
        int i3 = 0;
        if (iArr[0] == 0) {
            length -= 2;
        }
        int i4 = iArr[iArr.length - 1];
        if (i4 == 1114111) {
            length -= 2;
        }
        RangeToken rangeTokenCreateRange = Token.createRange();
        int[] iArr2 = new int[length];
        rangeTokenCreateRange.ranges = iArr2;
        int[] iArr3 = rangeToken.ranges;
        if (iArr3[0] > 0) {
            iArr2[0] = 0;
            iArr2[1] = iArr3[0] - 1;
            i3 = 2;
        }
        int i5 = 1;
        while (true) {
            int[] iArr4 = rangeToken.ranges;
            if (i5 >= iArr4.length - 2) {
                break;
            }
            int[] iArr5 = rangeTokenCreateRange.ranges;
            int i6 = i3 + 1;
            iArr5[i3] = iArr4[i5] + 1;
            i3 = i6 + 1;
            iArr5[i6] = iArr4[i5 + 1] - 1;
            i5 += 2;
        }
        if (i4 != 1114111) {
            int[] iArr6 = rangeTokenCreateRange.ranges;
            iArr6[i3] = i4 + 1;
            iArr6[i3 + 1] = 1114111;
        }
        rangeTokenCreateRange.setCompacted();
        return rangeTokenCreateRange;
    }

    private void createMap() {
        int[] iArr = new int[8];
        int length = this.ranges.length;
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            iArr[i3] = 0;
        }
        while (true) {
            int[] iArr2 = this.ranges;
            if (i2 >= iArr2.length) {
                break;
            }
            int i4 = iArr2[i2];
            int i5 = iArr2[i2 + 1];
            if (i4 >= 256) {
                break;
            }
            while (i4 <= i5 && i4 < 256) {
                int i6 = i4 / 32;
                iArr[i6] = iArr[i6] | (1 << (i4 & 31));
                i4++;
            }
            if (i5 >= 256) {
                break;
            } else {
                i2 += 2;
            }
        }
        length = i2;
        this.nonMapIndex = length;
        this.map = iArr;
    }

    private static String escapeCharInCharClass(int i2) {
        if (i2 == 9) {
            return "\\t";
        }
        if (i2 == 10) {
            return "\\n";
        }
        if (i2 == 12) {
            return "\\f";
        }
        if (i2 == 13) {
            return "\\r";
        }
        if (i2 == 27) {
            return "\\e";
        }
        if (i2 != 44 && i2 != 45) {
            switch (i2) {
                case 91:
                case 92:
                case 93:
                case 94:
                    break;
                default:
                    if (i2 < 32) {
                        return "\\x" + ("0" + Integer.toHexString(i2)).substring(r2.length() - 2);
                    }
                    if (i2 < 65536) {
                        return "" + ((char) i2);
                    }
                    return "\\v" + ("0" + Integer.toHexString(i2)).substring(r2.length() - 6);
            }
        }
        return "\\" + ((char) i2);
    }

    private boolean isCompacted() {
        return this.compacted;
    }

    private boolean isSorted() {
        return this.sorted;
    }

    private void setCompacted() {
        this.compacted = true;
    }

    private void setSorted(boolean z) {
        this.sorted = z;
        if (z) {
            return;
        }
        this.compacted = false;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void addRange(int i2, int i3) {
        this.icaseCache = null;
        if (i2 > i3) {
            i3 = i2;
            i2 = i3;
        }
        int[] iArr = this.ranges;
        if (iArr == null) {
            this.ranges = new int[]{i2, i3};
            setSorted(true);
            return;
        }
        int length = iArr.length;
        int i4 = length - 1;
        if (iArr[i4] + 1 == i2) {
            iArr[i4] = i3;
            return;
        }
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.ranges = iArr2;
        if (iArr2[i4] >= i2) {
            setSorted(false);
        }
        int[] iArr3 = this.ranges;
        iArr3[length] = i2;
        iArr3[length + 1] = i3;
        if (this.sorted) {
            return;
        }
        sortRanges();
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void compactRanges() {
        int i2;
        int i3;
        int[] iArr = this.ranges;
        if (iArr == null || iArr.length <= 2 || isCompacted()) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i4 >= iArr2.length) {
                if (i5 != iArr2.length) {
                    int[] iArr3 = new int[i5];
                    System.arraycopy(iArr2, 0, iArr3, 0, i5);
                    this.ranges = iArr3;
                }
                setCompacted();
                return;
            }
            if (i5 != i4) {
                int i6 = i4 + 1;
                iArr2[i5] = iArr2[i4];
                i2 = i6 + 1;
                iArr2[i5 + 1] = iArr2[i6];
            } else {
                i2 = i4 + 2;
            }
            int i7 = i5 + 1;
            int i8 = iArr2[i7];
            while (true) {
                int[] iArr4 = this.ranges;
                if (i2 >= iArr4.length || (i3 = i8 + 1) < iArr4[i2]) {
                    break;
                }
                if (i3 == iArr4[i2]) {
                    iArr4[i7] = iArr4[i2 + 1];
                    i8 = iArr4[i7];
                } else {
                    int i9 = i2 + 1;
                    if (i8 >= iArr4[i9]) {
                        continue;
                    } else {
                        if (i8 >= iArr4[i9]) {
                            throw new RuntimeException("Token#compactRanges(): Internel Error: [" + this.ranges[i5] + "," + this.ranges[i7] + "] [" + this.ranges[i2] + "," + this.ranges[i9] + "]");
                        }
                        iArr4[i7] = iArr4[i9];
                        i8 = iArr4[i7];
                    }
                }
                i2 += 2;
            }
            i5 += 2;
            i4 = i2;
        }
    }

    synchronized RangeToken getCaseInsensitiveToken() {
        RangeToken rangeToken = this.icaseCache;
        if (rangeToken != null) {
            return rangeToken;
        }
        RangeToken rangeTokenCreateRange = this.type == 4 ? Token.createRange() : Token.createNRange();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.ranges;
            if (i3 >= iArr.length) {
                break;
            }
            for (int i4 = iArr[i3]; i4 <= this.ranges[i3 + 1]; i4++) {
                if (i4 > 65535) {
                    rangeTokenCreateRange.addRange(i4, i4);
                } else {
                    char upperCase = Character.toUpperCase((char) i4);
                    rangeTokenCreateRange.addRange(upperCase, upperCase);
                }
            }
            i3 += 2;
        }
        RangeToken rangeTokenCreateRange2 = this.type == 4 ? Token.createRange() : Token.createNRange();
        while (true) {
            int[] iArr2 = rangeTokenCreateRange.ranges;
            if (i2 >= iArr2.length) {
                rangeTokenCreateRange2.mergeRanges(rangeTokenCreateRange);
                rangeTokenCreateRange2.mergeRanges(this);
                rangeTokenCreateRange2.compactRanges();
                this.icaseCache = rangeTokenCreateRange2;
                return rangeTokenCreateRange2;
            }
            for (int i5 = iArr2[i2]; i5 <= rangeTokenCreateRange.ranges[i2 + 1]; i5++) {
                if (i5 > 65535) {
                    rangeTokenCreateRange2.addRange(i5, i5);
                } else {
                    char upperCase2 = Character.toUpperCase((char) i5);
                    rangeTokenCreateRange2.addRange(upperCase2, upperCase2);
                }
            }
            i2 += 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        r13 = r12.ranges;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c5, code lost:
    
        if (r2 >= r13.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
    
        r3 = r4 + 1;
        r5 = r2 + 1;
        r0[r4] = r13[r2];
        r4 = r3 + 1;
        r2 = r5 + 1;
        r0[r3] = r13[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d8, code lost:
    
        r13 = new int[r4];
        r12.ranges = r13;
        java.lang.System.arraycopy(r0, 0, r13, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00df, code lost:
    
        return;
     */
    @Override // org.apache.xmlbeans.impl.regex.Token
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void intersectRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        if (rangeToken.ranges != null && this.ranges != null) {
            this.icaseCache = null;
            sortRanges();
            compactRanges();
            rangeToken.sortRanges();
            rangeToken.compactRanges();
            int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i2 >= iArr2.length) {
                    break;
                }
                int[] iArr3 = rangeToken.ranges;
                if (i3 >= iArr3.length) {
                    break;
                }
                int i5 = iArr2[i2];
                int i6 = i2 + 1;
                int i7 = iArr2[i6];
                int i8 = iArr3[i3];
                int i9 = i3 + 1;
                int i10 = iArr3[i9];
                if (i7 >= i8) {
                    if (i7 < i8 || i5 > i10) {
                        if (i10 >= i5) {
                            throw new RuntimeException("Token#intersectRanges(): Internal Error: [" + this.ranges[i2] + "," + this.ranges[i6] + "] & [" + rangeToken.ranges[i3] + "," + rangeToken.ranges[i9] + "]");
                        }
                        i3 += 2;
                    } else if (i8 <= i5 && i7 <= i10) {
                        int i11 = i4 + 1;
                        iArr[i4] = i5;
                        i4 = i11 + 1;
                        iArr[i11] = i7;
                    } else if (i8 <= i5) {
                        int i12 = i4 + 1;
                        iArr[i4] = i5;
                        i4 = i12 + 1;
                        iArr[i12] = i10;
                        iArr2[i2] = i10 + 1;
                        i3 += 2;
                    } else if (i7 <= i10) {
                        int i13 = i4 + 1;
                        iArr[i4] = i8;
                        i4 = i13 + 1;
                        iArr[i13] = i7;
                    } else {
                        int i14 = i4 + 1;
                        iArr[i4] = i8;
                        i4 = i14 + 1;
                        iArr[i14] = i10;
                        iArr2[i2] = i10 + 1;
                    }
                }
                i2 += 2;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    boolean match(int i2) {
        if (this.map == null) {
            createMap();
        }
        if (this.type == 4) {
            if (i2 < 256) {
                return ((1 << (i2 & 31)) & this.map[i2 / 32]) != 0;
            }
            int i3 = this.nonMapIndex;
            while (true) {
                int[] iArr = this.ranges;
                if (i3 >= iArr.length) {
                    return false;
                }
                if (iArr[i3] <= i2 && i2 <= iArr[i3 + 1]) {
                    return true;
                }
                i3 += 2;
            }
        } else {
            if (i2 < 256) {
                return ((1 << (i2 & 31)) & this.map[i2 / 32]) == 0;
            }
            int i4 = this.nonMapIndex;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i4 >= iArr2.length) {
                    return true;
                }
                if (iArr2[i4] <= i2 && i2 <= iArr2[i4 + 1]) {
                    return false;
                }
                i4 += 2;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void mergeRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        sortRanges();
        rangeToken.sortRanges();
        if (rangeToken.ranges == null) {
            return;
        }
        this.icaseCache = null;
        setSorted(true);
        int[] iArr = this.ranges;
        int i2 = 0;
        if (iArr == null) {
            int[] iArr2 = new int[rangeToken.ranges.length];
            this.ranges = iArr2;
            int[] iArr3 = rangeToken.ranges;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            return;
        }
        int[] iArr4 = new int[iArr.length + rangeToken.ranges.length];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr5 = this.ranges;
            if (i2 >= iArr5.length && i3 >= rangeToken.ranges.length) {
                this.ranges = iArr4;
                return;
            }
            if (i2 >= iArr5.length) {
                int i5 = i4 + 1;
                int[] iArr6 = rangeToken.ranges;
                int i6 = i3 + 1;
                iArr4[i4] = iArr6[i3];
                i4 = i5 + 1;
                i3 = i6 + 1;
                iArr4[i5] = iArr6[i6];
            } else {
                int[] iArr7 = rangeToken.ranges;
                if (i3 >= iArr7.length) {
                    int i7 = i4 + 1;
                    int i8 = i2 + 1;
                    iArr4[i4] = iArr5[i2];
                    i4 = i7 + 1;
                    i2 = i8 + 1;
                    iArr4[i7] = iArr5[i8];
                } else if (iArr7[i3] < iArr5[i2] || (iArr7[i3] == iArr5[i2] && iArr7[i3 + 1] < iArr5[i2 + 1])) {
                    int i9 = i4 + 1;
                    int i10 = i3 + 1;
                    iArr4[i4] = iArr7[i3];
                    i4 = i9 + 1;
                    i3 = i10 + 1;
                    iArr4[i9] = iArr7[i10];
                } else {
                    int i11 = i4 + 1;
                    int i12 = i2 + 1;
                    iArr4[i4] = iArr5[i2];
                    i4 = i11 + 1;
                    i2 = i12 + 1;
                    iArr4[i11] = iArr5[i12];
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void sortRanges() {
        int[] iArr;
        if (isSorted() || (iArr = this.ranges) == null) {
            return;
        }
        for (int length = iArr.length - 4; length >= 0; length -= 2) {
            int i2 = 0;
            while (i2 <= length) {
                int[] iArr2 = this.ranges;
                int i3 = i2 + 2;
                if (iArr2[i2] > iArr2[i3] || (iArr2[i2] == iArr2[i3] && iArr2[i2 + 1] > iArr2[i2 + 3])) {
                    int i4 = iArr2[i3];
                    iArr2[i3] = iArr2[i2];
                    iArr2[i2] = i4;
                    int i5 = i2 + 3;
                    int i6 = iArr2[i5];
                    int i7 = i2 + 1;
                    iArr2[i5] = iArr2[i7];
                    iArr2[i7] = i6;
                }
                i2 = i3;
            }
        }
        setSorted(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
    
        r13 = r12.ranges;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d0, code lost:
    
        if (r2 >= r13.length) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
    
        r3 = r4 + 1;
        r5 = r2 + 1;
        r0[r4] = r13[r2];
        r4 = r3 + 1;
        r2 = r5 + 1;
        r0[r3] = r13[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        r13 = new int[r4];
        r12.ranges = r13;
        java.lang.System.arraycopy(r0, 0, r13, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ea, code lost:
    
        return;
     */
    @Override // org.apache.xmlbeans.impl.regex.Token
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void subtractRanges(Token token) {
        if (token.type != 5) {
            RangeToken rangeToken = (RangeToken) token;
            if (rangeToken.ranges != null && this.ranges != null) {
                this.icaseCache = null;
                sortRanges();
                compactRanges();
                rangeToken.sortRanges();
                rangeToken.compactRanges();
                int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.ranges;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    int[] iArr3 = rangeToken.ranges;
                    if (i3 >= iArr3.length) {
                        break;
                    }
                    int i5 = iArr2[i2];
                    int i6 = i2 + 1;
                    int i7 = iArr2[i6];
                    int i8 = iArr3[i3];
                    int i9 = i3 + 1;
                    int i10 = iArr3[i9];
                    if (i7 < i8) {
                        int i11 = i4 + 1;
                        iArr[i4] = iArr2[i2];
                        i4 = i11 + 1;
                        i2 = i6 + 1;
                        iArr[i11] = iArr2[i6];
                    } else if (i7 < i8 || i5 > i10) {
                        if (i10 >= i5) {
                            throw new RuntimeException("Token#subtractRanges(): Internal Error: [" + this.ranges[i2] + "," + this.ranges[i6] + "] - [" + rangeToken.ranges[i3] + "," + rangeToken.ranges[i9] + "]");
                        }
                        i3 += 2;
                    } else {
                        if (i8 > i5 || i7 > i10) {
                            if (i8 <= i5) {
                                iArr2[i2] = i10 + 1;
                            } else if (i7 <= i10) {
                                int i12 = i4 + 1;
                                iArr[i4] = i5;
                                i4 = i12 + 1;
                                iArr[i12] = i8 - 1;
                            } else {
                                int i13 = i4 + 1;
                                iArr[i4] = i5;
                                i4 = i13 + 1;
                                iArr[i13] = i8 - 1;
                                iArr2[i2] = i10 + 1;
                            }
                            i3 += 2;
                        }
                        i2 += 2;
                    }
                }
            }
        } else {
            intersectRanges(token);
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public String toString(int i2) {
        int i3 = 0;
        if (this.type != 4) {
            if (this == Token.token_not_0to9) {
                return "\\D";
            }
            if (this == Token.token_not_wordchars) {
                return "\\W";
            }
            if (this == Token.token_not_spaces) {
                return "\\S";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[^");
            while (i3 < this.ranges.length) {
                if ((i2 & 1024) != 0 && i3 > 0) {
                    sb.append(",");
                }
                int[] iArr = this.ranges;
                int i4 = i3 + 1;
                if (iArr[i3] == iArr[i4]) {
                    sb.append(escapeCharInCharClass(iArr[i3]));
                } else {
                    sb.append(escapeCharInCharClass(iArr[i3]));
                    sb.append(NameUtil.HYPHEN);
                    sb.append(escapeCharInCharClass(this.ranges[i4]));
                }
                i3 += 2;
            }
            sb.append("]");
            return sb.toString();
        }
        if (this == Token.token_dot) {
            return ".";
        }
        if (this == Token.token_0to9) {
            return "\\d";
        }
        if (this == Token.token_wordchars) {
            return "\\w";
        }
        if (this == Token.token_spaces) {
            return "\\s";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        while (i3 < this.ranges.length) {
            if ((i2 & 1024) != 0 && i3 > 0) {
                sb2.append(",");
            }
            int[] iArr2 = this.ranges;
            int i5 = i3 + 1;
            if (iArr2[i3] == iArr2[i5]) {
                sb2.append(escapeCharInCharClass(iArr2[i3]));
            } else {
                sb2.append(escapeCharInCharClass(iArr2[i3]));
                sb2.append(NameUtil.HYPHEN);
                sb2.append(escapeCharInCharClass(this.ranges[i5]));
            }
            i3 += 2;
        }
        sb2.append("]");
        return sb2.toString();
    }
}
