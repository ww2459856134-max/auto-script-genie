package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class GDuration implements GDurationSpecification, Serializable {
    private static final int SEEN_DAY = 3;
    private static final int SEEN_HOUR = 4;
    private static final int SEEN_MINUTE = 5;
    private static final int SEEN_MONTH = 2;
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_SECOND = 6;
    private static final int SEEN_YEAR = 1;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    public GDuration() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    private GDuration _add(GDurationSpecification gDurationSpecification, int i2) {
        GDuration gDuration = new GDuration(this);
        gDuration._CY += gDurationSpecification.getYear() * i2;
        gDuration._M += gDurationSpecification.getMonth() * i2;
        gDuration._D += gDurationSpecification.getDay() * i2;
        gDuration._h += gDurationSpecification.getHour() * i2;
        gDuration._m += gDurationSpecification.getMinute() * i2;
        gDuration._s += gDurationSpecification.getSecond() * i2;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return gDuration;
        }
        if (gDuration._fs.signum() == 0 && i2 == 1) {
            gDuration._fs = gDurationSpecification.getFraction();
        } else {
            gDuration._fs = i2 > 0 ? gDuration._fs.add(gDurationSpecification.getFraction()) : gDuration._fs.subtract(gDurationSpecification.getFraction());
        }
        return gDuration;
    }

    public GDuration add(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, this._sign * gDurationSpecification.getSign());
    }

    public Object clone() {
        return new GDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return GDurationBuilder.compareDurations(this, gDurationSpecification);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GDuration)) {
            return false;
        }
        GDuration gDuration = (GDuration) obj;
        return this._sign == gDuration.getSign() && this._CY == gDuration.getYear() && this._M == gDuration.getMonth() && this._D == gDuration.getDay() && this._h == gDuration.getHour() && this._m == gDuration.getMinute() && this._s == gDuration.getSecond() && this._fs.equals(gDuration.getFraction());
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSign() {
        return this._sign;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getYear() {
        return this._CY;
    }

    public int hashCode() {
        return this._s + (this._m * 67) + (this._h * 3607) + (this._D * 86407) + (this._M * 2678407) + (this._CY * 32140807) + (this._sign * 11917049);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public boolean isValid() {
        return GDurationBuilder.isValidDuration(this);
    }

    public GDuration subtract(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, (-this._sign) * gDurationSpecification.getSign());
    }

    public String toString() {
        return GDurationBuilder.formatDuration(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GDuration(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        while (length > 0 && GDate.isSpace(charSequence.charAt(length - 1))) {
            length--;
        }
        int i2 = 0;
        while (i2 < length && GDate.isSpace(charSequence.charAt(i2))) {
            i2++;
        }
        this._sign = 1;
        if (i2 < length && charSequence.charAt(i2) == '-') {
            this._sign = -1;
            i2++;
        }
        if (i2 < length && charSequence.charAt(i2) == 'P') {
            int i3 = i2 + 1;
            this._fs = GDate._zero;
            char c = 0;
            boolean z = false;
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 == 'T') {
                    if (z) {
                        throw new IllegalArgumentException("duration must have no more than one T'");
                    }
                    if (c > 3) {
                        throw new IllegalArgumentException("T in duration must precede time fields");
                    }
                    i3++;
                    if (i3 < length) {
                        cCharAt2 = charSequence.charAt(i3);
                        z = true;
                        c = 3;
                    } else {
                        throw new IllegalArgumentException("illegal duration");
                    }
                }
                if (GDate.isDigit(cCharAt2)) {
                    int iDigitVal = GDate.digitVal(cCharAt2);
                    while (true) {
                        i3++;
                        cCharAt = i3 < length ? charSequence.charAt(i3) : (char) 0;
                        if (!GDate.isDigit(cCharAt)) {
                            break;
                        } else {
                            iDigitVal = (iDigitVal * 10) + GDate.digitVal(cCharAt);
                        }
                    }
                    if (cCharAt == '.') {
                        int i4 = i3;
                        do {
                            i4++;
                            if (i4 >= length) {
                                break;
                            } else {
                                cCharAt = charSequence.charAt(i4);
                            }
                        } while (GDate.isDigit(cCharAt));
                        this._fs = new BigDecimal(charSequence.subSequence(i3, i4).toString());
                        if (i4 >= length || cCharAt != 'S') {
                            throw new IllegalArgumentException("illegal duration");
                        }
                        i3 = i4;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 3) {
                                    if (c != 4) {
                                        if (c == 5) {
                                        }
                                        throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                                    }
                                    if (cCharAt == 'S') {
                                        throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
                                    }
                                    if (z) {
                                        this._s = iDigitVal;
                                        c = 6;
                                        i3++;
                                    } else {
                                        throw new IllegalArgumentException("time in duration must follow T");
                                    }
                                }
                                if (cCharAt != 'M') {
                                    if (z) {
                                        this._m = iDigitVal;
                                        c = 5;
                                    } else {
                                        throw new IllegalArgumentException("time in duration must follow T");
                                    }
                                } else if (cCharAt == 'S') {
                                }
                                i3++;
                            }
                            if (cCharAt != 'H') {
                                if (z) {
                                    this._h = iDigitVal;
                                    c = 4;
                                } else {
                                    throw new IllegalArgumentException("time in duration must follow T");
                                }
                            } else if (cCharAt != 'M') {
                            }
                            i3++;
                        }
                        if (cCharAt != 'D') {
                            this._D = iDigitVal;
                            c = 3;
                        } else if (cCharAt != 'H') {
                        }
                        i3++;
                    } else {
                        if (cCharAt == 'Y') {
                            this._CY = iDigitVal;
                            c = 1;
                        }
                        i3++;
                    }
                    if (cCharAt == 'M') {
                        this._M = iDigitVal;
                        c = 2;
                    } else if (cCharAt != 'D') {
                    }
                    i3++;
                } else {
                    throw new IllegalArgumentException("illegal duration at char[" + i3 + "]: '" + cCharAt2 + "'");
                }
            }
            if (c != 0) {
                return;
            }
            throw new IllegalArgumentException("duration must contain at least one number and its designator: " + ((Object) charSequence));
        }
        throw new IllegalArgumentException("duration must begin with P");
    }

    public GDuration(int i2, int i3, int i4, int i5, int i6, int i7, int i8, BigDecimal bigDecimal) {
        if (i2 != 1 && i2 != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i2;
        this._CY = i3;
        this._M = i4;
        this._D = i5;
        this._h = i6;
        this._m = i7;
        this._s = i8;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
    }

    public GDuration(GDurationSpecification gDurationSpecification) {
        this._sign = gDurationSpecification.getSign();
        this._CY = gDurationSpecification.getYear();
        this._M = gDurationSpecification.getMonth();
        this._D = gDurationSpecification.getDay();
        this._h = gDurationSpecification.getHour();
        this._m = gDurationSpecification.getMinute();
        this._s = gDurationSpecification.getSecond();
        this._fs = gDurationSpecification.getFraction();
    }
}
