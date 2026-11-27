package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class GDurationBuilder implements GDurationSpecification, Serializable {
    private static final GDate[] _compDate = {new GDate(1696, 9, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1697, 2, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 3, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 7, 1, 0, 0, 0, null, 0, 0, 0)};
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    public GDurationBuilder() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    private void _add(GDurationSpecification gDurationSpecification, int i2) {
        this._CY += gDurationSpecification.getYear() * i2;
        this._M += gDurationSpecification.getMonth() * i2;
        this._D += gDurationSpecification.getDay() * i2;
        this._h += gDurationSpecification.getHour() * i2;
        this._m += gDurationSpecification.getMinute() * i2;
        this._s += gDurationSpecification.getSecond() * i2;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return;
        }
        if (this._fs.signum() == 0 && i2 == 1) {
            this._fs = gDurationSpecification.getFraction();
        } else {
            this._fs = i2 > 0 ? this._fs.add(gDurationSpecification.getFraction()) : this._fs.subtract(gDurationSpecification.getFraction());
        }
    }

    private static long _fQuotient(long j2, int i2) {
        if ((j2 < 0) == (i2 < 0)) {
            return j2 / i2;
        }
        long j3 = i2;
        return -(((j3 - j2) - 1) / j3);
    }

    private int _getTotalSignSlowly() {
        GDateBuilder gDateBuilder = new GDateBuilder();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (GDate gDate : _compDate) {
            gDateBuilder.setGDate(gDate);
            gDateBuilder.addGDuration(this);
            int iCompareToGDate = gDateBuilder.compareToGDate(gDate);
            if (iCompareToGDate == -1) {
                i3++;
            } else if (iCompareToGDate == 0) {
                i4++;
            } else if (iCompareToGDate == 1) {
                i2++;
            }
        }
        GDate[] gDateArr = _compDate;
        if (i2 == gDateArr.length) {
            return 1;
        }
        if (i3 == gDateArr.length) {
            return -1;
        }
        return i4 == gDateArr.length ? 0 : 2;
    }

    private static int _mod(long j2, int i2, long j3) {
        return (int) (j2 - (j3 * i2));
    }

    private void _normalizeImpl(boolean z) {
        long jIntValue;
        int i2;
        BigDecimal bigDecimal;
        int i3;
        int i4;
        int i5;
        int i6 = this._M;
        if (i6 < 0 || i6 > 11) {
            long j2 = i6;
            long j_fQuotient = _fQuotient(j2, 12);
            this._M = _mod(j2, 12, j_fQuotient);
            this._CY = Math.addExact(this._CY, Math.toIntExact(j_fQuotient));
        }
        BigDecimal bigDecimal2 = this._fs;
        if (bigDecimal2 == null || (bigDecimal2.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            jIntValue = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, RoundingMode.FLOOR);
            this._fs = this._fs.subtract(scale);
            jIntValue = scale.intValue();
        }
        if (jIntValue != 0 || (i3 = this._s) < 0 || i3 > 59 || (i4 = this._m) < 0 || i4 > 50 || (i5 = this._h) < 0 || i5 > 23) {
            long j3 = this._s + jIntValue;
            long j_fQuotient2 = _fQuotient(j3, 60);
            this._s = _mod(j3, 60, j_fQuotient2);
            long j4 = this._m + j_fQuotient2;
            long j_fQuotient3 = _fQuotient(j4, 60);
            this._m = _mod(j4, 60, j_fQuotient3);
            long j5 = this._h + j_fQuotient3;
            long j_fQuotient4 = _fQuotient(j5, 24);
            this._h = _mod(j5, 24, j_fQuotient4);
            this._D = Math.addExact(this._D, Math.toIntExact(j_fQuotient4));
        }
        if (this._CY == 0 && this._M == 0 && this._D == 0 && this._h == 0 && this._m == 0 && this._s == 0 && ((bigDecimal = this._fs) == null || bigDecimal.signum() == 0)) {
            this._sign = 1;
        }
        if (z) {
            int i7 = this._D;
            if (i7 < 0 || this._CY < 0) {
                int i_getTotalSignSlowly = (i7 > 0 || ((i2 = this._CY) >= 0 && !(i2 == 0 && this._M == 0))) ? _getTotalSignSlowly() : -this._sign;
                if (i_getTotalSignSlowly == 2) {
                    i_getTotalSignSlowly = this._CY < 0 ? -this._sign : this._sign;
                }
                int i8 = i_getTotalSignSlowly != 0 ? i_getTotalSignSlowly : 1;
                if (i8 != this._sign) {
                    this._sign = i8;
                    this._CY = -this._CY;
                    this._M = -this._M;
                    this._D = -this._D;
                    this._h = -this._h;
                    this._m = -this._m;
                    this._s = -this._s;
                    BigDecimal bigDecimal3 = this._fs;
                    if (bigDecimal3 != null) {
                        this._fs = bigDecimal3.negate();
                    }
                }
                _normalizeImpl(false);
            }
        }
    }

    static int compareDurations(GDurationSpecification gDurationSpecification, GDurationSpecification gDurationSpecification2) {
        if (gDurationSpecification.getFraction().signum() == 0 && gDurationSpecification2.getFraction().signum() == 0) {
            int sign = gDurationSpecification.getSign();
            long j2 = sign;
            long year = ((gDurationSpecification.getYear() * 12) + gDurationSpecification.getMonth()) * j2;
            long sign2 = gDurationSpecification2.getSign();
            long year2 = ((gDurationSpecification2.getYear() * 12) + gDurationSpecification2.getMonth()) * sign2;
            long day = j2 * ((((((gDurationSpecification.getDay() * 24) + gDurationSpecification.getHour()) * 60) + gDurationSpecification.getMinute()) * 60) + gDurationSpecification.getSecond());
            long day2 = sign2 * ((((((gDurationSpecification2.getDay() * 24) + gDurationSpecification2.getHour()) * 60) + gDurationSpecification2.getMinute()) * 60) + gDurationSpecification2.getSecond());
            if (year == year2) {
                if (day == day2) {
                    return 0;
                }
                return day < day2 ? -1 : 1;
            }
            if (year < year2 && day - day2 < 2419200) {
                return -1;
            }
            if (year > year2 && day2 - day < 2419200) {
                return 1;
            }
        }
        GDurationBuilder gDurationBuilder = new GDurationBuilder(gDurationSpecification);
        gDurationBuilder.subtractGDuration(gDurationSpecification2);
        return gDurationBuilder._getTotalSignSlowly();
    }

    static String formatDuration(GDurationSpecification gDurationSpecification) {
        StringBuilder sb = new StringBuilder(30);
        if (gDurationSpecification.getSign() < 0) {
            sb.append(NameUtil.HYPHEN);
        }
        sb.append('P');
        if (gDurationSpecification.getYear() != 0) {
            sb.append(gDurationSpecification.getYear());
            sb.append('Y');
        }
        if (gDurationSpecification.getMonth() != 0) {
            sb.append(gDurationSpecification.getMonth());
            sb.append('M');
        }
        if (gDurationSpecification.getDay() != 0) {
            sb.append(gDurationSpecification.getDay());
            sb.append('D');
        }
        if (gDurationSpecification.getHour() != 0 || gDurationSpecification.getMinute() != 0 || gDurationSpecification.getSecond() != 0 || gDurationSpecification.getFraction().signum() != 0) {
            sb.append('T');
        }
        if (gDurationSpecification.getHour() != 0) {
            sb.append(gDurationSpecification.getHour());
            sb.append('H');
        }
        if (gDurationSpecification.getMinute() != 0) {
            sb.append(gDurationSpecification.getMinute());
            sb.append('M');
        }
        if (gDurationSpecification.getFraction().signum() != 0) {
            BigDecimal fraction = gDurationSpecification.getFraction();
            if (gDurationSpecification.getSecond() != 0) {
                fraction = fraction.add(BigDecimal.valueOf(gDurationSpecification.getSecond()));
            }
            sb.append(stripTrailingZeros(toPlainString(fraction)));
            sb.append('S');
        } else if (gDurationSpecification.getSecond() != 0) {
            sb.append(gDurationSpecification.getSecond());
            sb.append('S');
        } else if (sb.length() <= 2) {
            sb.append("T0S");
        }
        return sb.toString();
    }

    static boolean isValidDuration(GDurationSpecification gDurationSpecification) {
        return (gDurationSpecification.getSign() == 1 || gDurationSpecification.getSign() == -1) && gDurationSpecification.getYear() >= 0 && gDurationSpecification.getMonth() >= 0 && gDurationSpecification.getDay() >= 0 && gDurationSpecification.getHour() >= 0 && gDurationSpecification.getMinute() >= 0 && gDurationSpecification.getSecond() >= 0 && gDurationSpecification.getFraction().signum() >= 0;
    }

    public static String stripTrailingZeros(String str) {
        boolean z;
        int length = str.length() - 1;
        int i2 = length;
        while (length >= 0 && str.charAt(length) == '0') {
            length--;
            i2--;
        }
        while (true) {
            if (length < 0) {
                z = false;
                break;
            }
            if (str.charAt(length) == 'E') {
                return str;
            }
            if (str.charAt(length) == '.') {
                z = true;
                break;
            }
            length--;
        }
        return z ? str.substring(0, i2 + 1) : str;
    }

    public static String toPlainString(BigDecimal bigDecimal) {
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        int iScale = bigDecimal.scale();
        String string = bigIntegerUnscaledValue.toString();
        if (iScale == 0) {
            return string;
        }
        int i2 = string.charAt(0) == '-' ? 1 : 0;
        int length = (string.length() - iScale) - i2;
        StringBuilder sb = new StringBuilder(string.length() + 2 + (length <= 0 ? (-length) + 1 : 0));
        if (length <= 0) {
            if (i2 != 0) {
                sb.append(NameUtil.HYPHEN);
            }
            sb.append('0');
            sb.append(NameUtil.PERIOD);
            while (length < 0) {
                sb.append('0');
                length++;
            }
            sb.append(string.substring(i2));
        } else if (length < string.length()) {
            sb.append(string);
            sb.insert(length + i2, NameUtil.PERIOD);
        } else {
            sb.append(string);
            if (!bigIntegerUnscaledValue.equals(BigInteger.ZERO)) {
                for (int length2 = string.length(); length2 < length; length2++) {
                    sb.append('0');
                }
            }
        }
        return sb.toString();
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, this._sign * gDurationSpecification.getSign());
    }

    public Object clone() {
        return new GDurationBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return compareDurations(this, gDurationSpecification);
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

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public boolean isValid() {
        return isValidDuration(this);
    }

    public void normalize() {
        _normalizeImpl(true);
    }

    public void setDay(int i2) {
        this._D = i2;
    }

    public void setFraction(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
    }

    public void setHour(int i2) {
        this._h = i2;
    }

    public void setMinute(int i2) {
        this._m = i2;
    }

    public void setMonth(int i2) {
        this._M = i2;
    }

    public void setSecond(int i2) {
        this._s = i2;
    }

    public final void setSign(int i2) {
        if (i2 != 1 && i2 != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i2;
    }

    public void setYear(int i2) {
        this._CY = i2;
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, (-this._sign) * gDurationSpecification.getSign());
    }

    public GDuration toGDuration() {
        return new GDuration(this);
    }

    public String toString() {
        return formatDuration(this);
    }

    public GDurationBuilder(String str) {
        this(new GDuration(str));
    }

    public GDurationBuilder(int i2, int i3, int i4, int i5, int i6, int i7, int i8, BigDecimal bigDecimal) {
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

    public GDurationBuilder(GDurationSpecification gDurationSpecification) {
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
