package org.apache.xmlbeans.impl.regex;

import java.text.CharacterIterator;

/* loaded from: classes.dex */
public class BMPattern {
    boolean ignoreCase;
    char[] pattern;
    int[] shiftTable;

    public BMPattern(String str, boolean z) {
        this(str, 256, z);
    }

    public int matches(CharacterIterator characterIterator, int i2, int i3) {
        char index;
        if (this.ignoreCase) {
            return matchesIgnoreCase(characterIterator, i2, i3);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                index = characterIterator.setIndex(i4);
                i6--;
                if (index != this.pattern[i6]) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[index % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(CharacterIterator characterIterator, int i2, int i3) {
        char index;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                index = characterIterator.setIndex(i4);
                i6--;
                char c = this.pattern[i6];
                if (index != c && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[index % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }

    public BMPattern(String str, int i2, boolean z) {
        char[] charArray = str.toCharArray();
        this.pattern = charArray;
        this.shiftTable = new int[i2];
        this.ignoreCase = z;
        int length = charArray.length;
        int i3 = 0;
        while (true) {
            int[] iArr = this.shiftTable;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = length;
            i3++;
        }
        for (int i4 = 0; i4 < length; i4++) {
            char c = this.pattern[i4];
            int i5 = (length - i4) - 1;
            int[] iArr2 = this.shiftTable;
            int length2 = c % iArr2.length;
            if (i5 < iArr2[length2]) {
                iArr2[length2] = i5;
            }
            if (this.ignoreCase) {
                char upperCase = Character.toUpperCase(c);
                int[] iArr3 = this.shiftTable;
                int length3 = upperCase % iArr3.length;
                if (i5 < iArr3[length3]) {
                    iArr3[length3] = i5;
                }
                char lowerCase = Character.toLowerCase(upperCase);
                int[] iArr4 = this.shiftTable;
                int length4 = lowerCase % iArr4.length;
                if (i5 < iArr4[length4]) {
                    iArr4[length4] = i5;
                }
            }
        }
    }

    public int matches(String str, int i2, int i3) {
        char cCharAt;
        if (this.ignoreCase) {
            return matchesIgnoreCase(str, i2, i3);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                cCharAt = str.charAt(i4);
                i6--;
                if (cCharAt != this.pattern[i6]) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[cCharAt % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(String str, int i2, int i3) {
        char cCharAt;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                cCharAt = str.charAt(i4);
                i6--;
                char c = this.pattern[i6];
                if (cCharAt != c && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[cCharAt % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }

    public int matches(char[] cArr, int i2, int i3) {
        char c;
        if (this.ignoreCase) {
            return matchesIgnoreCase(cArr, i2, i3);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                c = cArr[i4];
                i6--;
                if (c != this.pattern[i6]) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[c % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(char[] cArr, int i2, int i3) {
        char c;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i2;
        }
        int i4 = i2 + length;
        while (i4 <= i3) {
            int i5 = i4 + 1;
            int i6 = length;
            do {
                i4--;
                c = cArr[i4];
                i6--;
                char c2 = this.pattern[i6];
                if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i6 == 0) {
                    return i4;
                }
            } while (i6 > 0);
            int[] iArr = this.shiftTable;
            i4 += iArr[c % iArr.length] + 1;
            if (i4 < i5) {
                i4 = i5;
            }
        }
        return -1;
    }
}
