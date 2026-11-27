package org.apache.xmlbeans;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class GDateBuilder implements GDateSpecification, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final BigInteger TEN = BigInteger.valueOf(10);
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    public GDateBuilder() {
    }

    private static long _fQuotient(long j2, int i2) {
        if ((j2 < 0) == (i2 < 0)) {
            return j2 / i2;
        }
        long j3 = i2;
        return -(((j3 - j2) - 1) / j3);
    }

    private static boolean _isLeapYear(int i2) {
        return i2 % 4 == 0 && (i2 % 100 != 0 || i2 % 400 == 0);
    }

    private static int _maxDayInMonth(int i2) {
        if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            return 30;
        }
        return i2 == 2 ? 29 : 31;
    }

    private static int _maxDayInMonthFor(int i2, int i3) {
        if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
            return 30;
        }
        if (i3 == 2) {
            return _isLeapYear(i2) ? 29 : 28;
        }
        return 31;
    }

    private static int _mod(long j2, int i2, long j3) {
        return (int) (j2 - (j3 * i2));
    }

    private static int _modulo(long j2, int i2, int i3) {
        long j3 = j2 - i2;
        int i4 = i3 - i2;
        return _mod(j3, i4, _fQuotient(j3, i4)) + i2;
    }

    private void _normalizeDate() {
        int i2;
        int i3 = this._M;
        if (i3 < 1 || i3 > 12 || (i2 = this._D) < 1 || i2 > _maxDayInMonthFor(this._CY, i3)) {
            long j2 = this._M;
            this._M = _modulo(j2, 1, 13);
            this._CY += (int) _fQuotient(j2, 1, 13);
            int i4 = this._D - 1;
            this._D = 1;
            setJulianDate(getJulianDate() + i4);
        }
    }

    private long _normalizeTime() {
        long jLongValue;
        int i2;
        int i3;
        int i4;
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || (bigDecimal.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            jLongValue = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, RoundingMode.FLOOR);
            this._fs = this._fs.subtract(scale);
            jLongValue = scale.longValue();
        }
        if (jLongValue == 0 && (i2 = this._s) >= 0 && i2 <= 59 && (i3 = this._m) >= 0 && i3 <= 50 && (i4 = this._h) >= 0 && i4 <= 23) {
            return jLongValue;
        }
        long j2 = this._s + jLongValue;
        long j_fQuotient = _fQuotient(j2, 60);
        this._s = _mod(j2, 60, j_fQuotient);
        long j3 = this._m + j_fQuotient;
        long j_fQuotient2 = _fQuotient(j3, 60);
        this._m = _mod(j3, 60, j_fQuotient2);
        long j4 = this._h + j_fQuotient2;
        long j_fQuotient3 = _fQuotient(j4, 24);
        this._h = _mod(j4, 24, j_fQuotient3);
        return j_fQuotient3;
    }

    private void _normalizeTimeAndDate() {
        long j_normalizeTime = hasTime() ? _normalizeTime() : 0L;
        if (hasDay()) {
            this._D = Math.addExact(this._D, Math.toIntExact(j_normalizeTime));
        }
        if (hasDate()) {
            _normalizeDate();
            return;
        }
        if (hasMonth()) {
            int i2 = this._M;
            if (i2 < 1 || i2 > 12) {
                long j2 = i2;
                this._M = _modulo(j2, 1, 13);
                if (hasYear()) {
                    this._CY += (int) _fQuotient(j2, 1, 13);
                }
            }
        }
    }

    private void _setToFirstMoment() {
        if (!hasYear()) {
            setYear(1584);
        }
        if (!hasMonth()) {
            setMonth(1);
        }
        if (!hasDay()) {
            setDay(1);
        }
        if (hasTime()) {
            return;
        }
        setTime(0, 0, 0, GDate._zero);
    }

    static int btcForFlags(int i2) {
        int i3 = i2 & 30;
        if (i3 == 2) {
            return 18;
        }
        if (i3 == 4) {
            return 21;
        }
        if (i3 == 6) {
            return 17;
        }
        if (i3 == 8) {
            return 20;
        }
        if (i3 == 12) {
            return 19;
        }
        if (i3 == 14) {
            return 16;
        }
        if (i3 != 16) {
            return i3 != 30 ? 0 : 14;
        }
        return 15;
    }

    static int compareGDate(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        int flags = gDateSpecification.getFlags() ^ gDateSpecification2.getFlags();
        if ((flags & 31) == 0) {
            if (gDateSpecification.hasTimeZone() && (gDateSpecification2.getTimeZoneHour() != gDateSpecification.getTimeZoneHour() || gDateSpecification2.getTimeZoneMinute() != gDateSpecification.getTimeZoneMinute() || gDateSpecification2.getTimeZoneSign() != gDateSpecification.getTimeZoneSign())) {
                GDateBuilder gDateBuilder = new GDateBuilder(gDateSpecification2);
                int flags2 = gDateSpecification.getFlags() & 14;
                if ((flags2 != 0 && flags2 != 14) || !gDateSpecification.hasTime()) {
                    gDateBuilder._setToFirstMoment();
                    GDateBuilder gDateBuilder2 = new GDateBuilder(gDateSpecification);
                    gDateBuilder2._setToFirstMoment();
                    gDateSpecification = gDateBuilder2;
                }
                gDateBuilder.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
                gDateSpecification2 = gDateBuilder;
            }
            return fieldwiseCompare(gDateSpecification, gDateSpecification2);
        }
        if ((flags & 30) != 0) {
            return 2;
        }
        if (!gDateSpecification.hasTimeZone()) {
            int iCompareGDate = compareGDate(gDateSpecification2, gDateSpecification);
            if (iCompareGDate == 2) {
                return 2;
            }
            return -iCompareGDate;
        }
        GDateBuilder gDateBuilder3 = new GDateBuilder(gDateSpecification);
        if ((gDateSpecification.getFlags() & 14) == 12) {
            if (gDateSpecification.getDay() == 28 && gDateSpecification.getMonth() == 2) {
                if (gDateSpecification2.getDay() == 1 && gDateSpecification2.getMonth() == 3) {
                    gDateBuilder3.setDay(29);
                }
            } else if (gDateSpecification2.getDay() == 28 && gDateSpecification2.getMonth() == 2 && gDateSpecification.getDay() == 1 && gDateSpecification.getMonth() == 3) {
                gDateBuilder3.setMonth(2);
                gDateBuilder3.setDay(29);
            }
        }
        gDateBuilder3._setToFirstMoment();
        GDateBuilder gDateBuilder4 = new GDateBuilder(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        if (fieldwiseCompare(gDateBuilder3, gDateBuilder4) == -1) {
            return -1;
        }
        gDateBuilder4.setGDate(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(-1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        return fieldwiseCompare(gDateBuilder3, gDateBuilder4) == 1 ? 1 : 2;
    }

    static Date dateForGDate(GDateSpecification gDateSpecification) {
        long offset;
        long jJulianDateForGDate = ((julianDateForGDate(gDateSpecification) - 2440588) * 86400000) + gDateSpecification.getMillisecond() + (gDateSpecification.getSecond() * 1000) + (gDateSpecification.getMinute() * 60 * 1000) + (gDateSpecification.getHour() * 60 * 60 * 1000);
        if (gDateSpecification.hasTimeZone()) {
            jJulianDateForGDate -= ((gDateSpecification.getTimeZoneMinute() * gDateSpecification.getTimeZoneSign()) * 60) * 1000;
            offset = gDateSpecification.getTimeZoneHour() * gDateSpecification.getTimeZoneSign() * 60 * 60 * 1000;
        } else {
            offset = TimeZone.getDefault().getOffset(jJulianDateForGDate);
        }
        return new Date(jJulianDateForGDate - offset);
    }

    private static int fieldwiseCompare(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification2.getYear();
            int year2 = gDateSpecification.getYear();
            if (year2 < year) {
                return -1;
            }
            if (year2 > year) {
                return 1;
            }
        }
        if (gDateSpecification.hasMonth()) {
            int month = gDateSpecification2.getMonth();
            int month2 = gDateSpecification.getMonth();
            if (month2 < month) {
                return -1;
            }
            if (month2 > month) {
                return 1;
            }
        }
        if (gDateSpecification.hasDay()) {
            int day = gDateSpecification2.getDay();
            int day2 = gDateSpecification.getDay();
            if (day2 < day) {
                return -1;
            }
            if (day2 > day) {
                return 1;
            }
        }
        if (!gDateSpecification.hasTime()) {
            return 0;
        }
        int hour = gDateSpecification2.getHour();
        int hour2 = gDateSpecification.getHour();
        if (hour2 < hour) {
            return -1;
        }
        if (hour2 > hour) {
            return 1;
        }
        int minute = gDateSpecification2.getMinute();
        int minute2 = gDateSpecification.getMinute();
        if (minute2 < minute) {
            return -1;
        }
        if (minute2 > minute) {
            return 1;
        }
        int second = gDateSpecification2.getSecond();
        int second2 = gDateSpecification.getSecond();
        if (second2 < second) {
            return -1;
        }
        if (second2 > second) {
            return 1;
        }
        BigDecimal fraction = gDateSpecification2.getFraction();
        BigDecimal fraction2 = gDateSpecification.getFraction();
        if (fraction2 == null && fraction == null) {
            return 0;
        }
        if (fraction2 == null) {
            fraction2 = GDate._zero;
        }
        if (fraction == null) {
            fraction = GDate._zero;
        }
        return fraction2.compareTo(fraction);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        if (r5.getDay() > _maxDayInMonthFor(r5.getYear() > 0 ? r5.getYear() : r5.getYear() + 1, r5.getMonth())) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r5.getDay() > _maxDayInMonth(r5.getMonth())) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean isValidGDate(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasYear() && gDateSpecification.getYear() == 0) {
            return false;
        }
        if (gDateSpecification.hasMonth() && (gDateSpecification.getMonth() < 1 || gDateSpecification.getMonth() > 12)) {
            return false;
        }
        if (gDateSpecification.hasDay()) {
            if (gDateSpecification.getDay() >= 1 && gDateSpecification.getDay() <= 31) {
                if (gDateSpecification.getDay() > 28 && gDateSpecification.hasMonth()) {
                    if (gDateSpecification.hasYear()) {
                    }
                }
            }
            return false;
        }
        if (!gDateSpecification.hasTime() || ((gDateSpecification.getHour() >= 0 && gDateSpecification.getHour() <= 23 && gDateSpecification.getMinute() >= 0 && gDateSpecification.getMinute() <= 59 && gDateSpecification.getSecond() >= 0 && gDateSpecification.getSecond() <= 59 && gDateSpecification.getFraction().signum() >= 0 && gDateSpecification.getFraction().compareTo(GDate._one) < 0) || (gDateSpecification.getHour() == 24 && gDateSpecification.getMinute() == 0 && gDateSpecification.getSecond() == 0 && gDateSpecification.getFraction().compareTo(GDate._zero) == 0))) {
            return !gDateSpecification.hasTimeZone() || (gDateSpecification.getTimeZoneSign() == 0 && gDateSpecification.getTimeZoneHour() == 0 && gDateSpecification.getTimeZoneMinute() == 0) || ((gDateSpecification.getTimeZoneSign() == -1 || gDateSpecification.getTimeZoneSign() == 1) && gDateSpecification.getTimeZoneHour() >= 0 && gDateSpecification.getTimeZoneMinute() >= 0 && ((gDateSpecification.getTimeZoneHour() == 14 && gDateSpecification.getTimeZoneMinute() == 0) || (gDateSpecification.getTimeZoneHour() < 14 && gDateSpecification.getTimeZoneMinute() < 60)));
        }
        return false;
    }

    static int julianDateForGDate(GDateSpecification gDateSpecification) {
        if (!gDateSpecification.hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int day = gDateSpecification.getDay();
        int month = gDateSpecification.getMonth();
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        int i2 = (month - 14) / 12;
        int i3 = (((day - 32075) + ((((year + 4800) + i2) * 1461) / 4)) + ((((month - 2) - (i2 * 12)) * 367) / 12)) - (((((year + 4900) + i2) / 100) * 3) / 4);
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalStateException("date too far in the past (year allowed to -4713)");
    }

    public void addDuration(int i2, int i3, int i4, int i5, int i6, int i7, int i8, BigDecimal bigDecimal) {
        int i_maxDayInMonthFor;
        boolean z = false;
        boolean z2 = (i6 == 0 && i7 == 0 && i8 == 0 && (bigDecimal == null || bigDecimal.signum() == 0)) ? false : true;
        if (z2 && !hasTime()) {
            throw new IllegalStateException("cannot do time math without a complete time");
        }
        if (hasDay() && (i5 != 0 || z2)) {
            z = true;
        }
        if (z && !hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        if (i4 != 0 || i3 != 0) {
            if (hasDay()) {
                _normalizeDate();
            }
            long j2 = this._M + (i4 * i2);
            this._M = _modulo(j2, 1, 13);
            this._CY = this._CY + (i3 * i2) + ((int) _fQuotient(j2, 1, 13));
            if (hasDay() && this._D > (i_maxDayInMonthFor = _maxDayInMonthFor(this._CY, this._M))) {
                this._D = i_maxDayInMonthFor;
            }
        }
        long j_normalizeTime = 0;
        if (z2) {
            if (bigDecimal != null && bigDecimal.signum() != 0) {
                if (this._fs.signum() == 0 && i2 == 1) {
                    this._fs = bigDecimal;
                } else {
                    BigDecimal bigDecimal2 = this._fs;
                    this._fs = i2 == 1 ? bigDecimal2.add(bigDecimal) : bigDecimal2.subtract(bigDecimal);
                }
            }
            this._s += i8 * i2;
            this._m += i7 * i2;
            this._h += i6 * i2;
            j_normalizeTime = _normalizeTime();
        }
        if (z) {
            this._D = Math.addExact(this._D, Math.toIntExact(Math.addExact(Math.multiplyExact(i2, i5), j_normalizeTime)));
            _normalizeDate();
        }
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String canonicalString() {
        boolean z = hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear();
        if (!z && getFraction() != null && getFraction().scale() > 0) {
            z = getFraction().unscaledValue().mod(TEN).signum() == 0;
        }
        if (!z) {
            return toString();
        }
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.normalize();
        return gDateBuilder.toString();
    }

    public void clearDay() {
        this._bits &= -9;
        this._D = 0;
    }

    public void clearMonth() {
        this._bits &= -5;
        this._M = 0;
    }

    public void clearTime() {
        this._bits &= -17;
        this._h = 0;
        this._m = 0;
        this._s = 0;
        this._fs = null;
    }

    public void clearTimeZone() {
        this._bits &= -2;
        this._tzsign = 0;
        this._tzh = 0;
        this._tzm = 0;
    }

    public void clearYear() {
        this._bits &= -3;
        this._CY = 0;
    }

    public Object clone() {
        return new GDateBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int compareToGDate(GDateSpecification gDateSpecification) {
        return compareGDate(this, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getBuiltinTypeCode() {
        return btcForFlags(this._bits);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public Date getDate() {
        return dateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getFlags() {
        return this._bits;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getJulianDate() {
        return julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMillisecond() {
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || GDate._zero.equals(bigDecimal)) {
            return 0;
        }
        return this._fs.setScale(3, RoundingMode.HALF_UP).unscaledValue().intValue();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneHour() {
        return this._tzh;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneMinute() {
        return this._tzm;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneSign() {
        return this._tzsign;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getYear() {
        int i2 = this._CY;
        return i2 > 0 ? i2 : i2 - 1;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDate() {
        return (this._bits & 14) == 14;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDay() {
        return (this._bits & 8) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasMonth() {
        return (this._bits & 4) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTime() {
        return (this._bits & 16) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTimeZone() {
        return (this._bits & 1) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasYear() {
        return (this._bits & 2) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isImmutable() {
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isValid() {
        return isValidGDate(this);
    }

    public void normalize() {
        BigDecimal bigDecimal;
        if (hasDay() == hasMonth() && hasDay() == hasYear() && hasTimeZone() && hasTime()) {
            normalizeToTimeZone(0, 0, 0);
        } else {
            _normalizeTimeAndDate();
        }
        if (!hasTime() || (bigDecimal = this._fs) == null || bigDecimal.scale() <= 0) {
            return;
        }
        if (this._fs.signum() == 0) {
            this._fs = GDate._zero;
            return;
        }
        String string = this._fs.unscaledValue().toString();
        int length = string.length();
        while (length > 0 && string.charAt(length - 1) == '0') {
            length--;
        }
        if (length < string.length()) {
            BigDecimal bigDecimal2 = this._fs;
            this._fs = bigDecimal2.setScale((bigDecimal2.scale() - string.length()) + length, RoundingMode.UNNECESSARY);
        }
    }

    void normalize24h() {
        if (hasTime() && getHour() == 24) {
            _normalizeTimeAndDate();
        }
    }

    public void normalizeToTimeZone(int i2, int i3, int i4) {
        if (!(i2 == 0 && i3 == 0 && i4 == 0) && (!(i2 == -1 || i2 == 1) || i3 < 0 || i4 < 0 || (!(i3 == 14 && i4 == 0) && (i3 >= 14 || i4 >= 60)))) {
            throw new IllegalArgumentException("time zone must be between -14:00 and +14:00");
        }
        if (!hasTimeZone() || !hasTime()) {
            throw new IllegalStateException("cannot normalize time zone without both time and timezone");
        }
        if (hasDay() != hasMonth() || hasDay() != hasYear()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int i5 = this._tzsign;
        int i6 = (i2 * i3) - (this._tzh * i5);
        int i7 = (i2 * i4) - (i5 * this._tzm);
        this._tzsign = i2;
        this._tzh = i3;
        this._tzm = i4;
        addDuration(1, 0, 0, 0, i6, i7, 0, null);
    }

    public void setBuiltinTypeCode(int i2) {
        switch (i2) {
            case 14:
                return;
            case 15:
                clearYear();
                clearMonth();
                clearDay();
                return;
            case 16:
                clearTime();
                return;
            case 17:
                clearDay();
                clearTime();
                return;
            case 18:
                clearMonth();
                clearDay();
                clearTime();
                return;
            case 19:
                clearYear();
                clearTime();
                return;
            case 20:
                clearYear();
                clearMonth();
                clearTime();
                return;
            case 21:
                clearYear();
                clearDay();
                clearTime();
                return;
            default:
                throw new IllegalArgumentException("codeType must be one of SchemaType BTC_  DATE TIME related types.");
        }
    }

    public void setDate(Date date) {
        int i2;
        int offset = TimeZone.getDefault().getOffset(date.getTime());
        if (offset < 0) {
            i2 = -1;
            offset = -offset;
        } else {
            i2 = 1;
        }
        int i3 = offset / 60000;
        int i4 = i3 / 60;
        int i5 = i4 * 60;
        int i6 = i3 - i5;
        setTimeZone(i2, i4, i6);
        int i7 = i2 * (i5 + i6) * 60 * XmlValidationError.INCORRECT_ATTRIBUTE;
        BigDecimal bigDecimal = GDate._zero;
        setTime(0, 0, 0, bigDecimal);
        this._bits |= 14;
        this._CY = 1970;
        this._M = 1;
        this._D = 1;
        addGDuration(new GDuration(1, 0, 0, 0, 0, 0, 0, BigDecimal.valueOf(date.getTime() + i7, 3)));
        if (this._fs.signum() == 0) {
            this._fs = bigDecimal;
        }
    }

    public void setDay(int i2) {
        if (i2 < 1 || i2 > 31) {
            throw new IllegalArgumentException("day out of range");
        }
        this._bits |= 8;
        this._D = i2;
    }

    public void setGDate(GDateSpecification gDateSpecification) {
        this._bits = gDateSpecification.getFlags() & 31;
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        this._CY = year;
        this._M = gDateSpecification.getMonth();
        this._D = gDateSpecification.getDay();
        this._h = gDateSpecification.getHour();
        this._m = gDateSpecification.getMinute();
        this._s = gDateSpecification.getSecond();
        this._fs = gDateSpecification.getFraction();
        this._tzsign = gDateSpecification.getTimeZoneSign();
        this._tzh = gDateSpecification.getTimeZoneHour();
        this._tzm = gDateSpecification.getTimeZoneMinute();
    }

    public void setJulianDate(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("date before year -4713");
        }
        int i3 = i2 + 68569;
        int i4 = (i3 * 4) / 146097;
        int i5 = i3 - (((146097 * i4) + 3) / 4);
        int i6 = ((i5 + 1) * 4000) / 1461001;
        this._CY = i6;
        int i7 = (i5 - ((i6 * 1461) / 4)) + 31;
        int i8 = (i7 * 80) / 2447;
        this._M = i8;
        this._D = i7 - ((i8 * 2447) / 80);
        int i9 = i8 / 11;
        this._M = (i8 + 2) - (i9 * 12);
        this._CY = ((i4 - 49) * 100) + i6 + i9;
        this._bits |= 14;
    }

    public void setMonth(int i2) {
        if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("month out of range");
        }
        this._bits |= 4;
        this._M = i2;
    }

    public void setTime(int i2, int i3, int i4, BigDecimal bigDecimal) {
        if (i2 < 0 || i2 > 24) {
            throw new IllegalArgumentException("hour out of range");
        }
        if (i3 < 0 || i3 > 59) {
            throw new IllegalArgumentException("minute out of range");
        }
        if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException("second out of range");
        }
        if (bigDecimal != null && (bigDecimal.signum() < 0 || GDate._one.compareTo(bigDecimal) <= 0)) {
            throw new IllegalArgumentException("fraction out of range");
        }
        if (i2 == 24 && (i3 != 0 || i4 != 0 || (bigDecimal != null && GDate._zero.compareTo(bigDecimal) != 0))) {
            throw new IllegalArgumentException("when hour is 24, min sec and fracton must be 0");
        }
        this._bits |= 16;
        this._h = i2;
        this._m = i3;
        this._s = i4;
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
    }

    public void setTimeZone(int i2, int i3, int i4) {
        if ((i2 == 0 && i3 == 0 && i4 == 0) || ((i2 == -1 || i2 == 1) && i3 >= 0 && i4 >= 0 && ((i3 == 14 && i4 == 0) || (i3 < 14 && i4 < 60)))) {
            this._bits = 1 | this._bits;
            this._tzsign = i2;
            this._tzh = i3;
            this._tzm = i4;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("time zone out of range (-14:00 to +14:00). (");
        sb.append(i2 < 0 ? ProcessIdUtil.DEFAULT_PROCESSID : "+");
        sb.append(i3);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(i4);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public void setYear(int i2) {
        if (i2 < -292275295 || i2 > 292277265) {
            throw new IllegalArgumentException("year out of range");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("year cannot be 0");
        }
        this._bits |= 2;
        if (i2 <= 0) {
            i2++;
        }
        this._CY = i2;
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(-gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    public GDate toGDate() {
        return new GDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final String toString() {
        return GDate.formatGDate(this);
    }

    public GDateBuilder(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasTimeZone()) {
            setTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        }
        if (gDateSpecification.hasTime()) {
            setTime(gDateSpecification.getHour(), gDateSpecification.getMinute(), gDateSpecification.getSecond(), gDateSpecification.getFraction());
        }
        if (gDateSpecification.hasDay()) {
            setDay(gDateSpecification.getDay());
        }
        if (gDateSpecification.hasMonth()) {
            setMonth(gDateSpecification.getMonth());
        }
        if (gDateSpecification.hasYear()) {
            setYear(gDateSpecification.getYear());
        }
    }

    private static long _fQuotient(long j2, int i2, int i3) {
        return _fQuotient(j2 - i2, i3 - i2);
    }

    public void setTimeZone(int i2) {
        if (i2 >= -840 && i2 <= 840) {
            int iCompare = Integer.compare(i2, 0);
            int i3 = i2 * iCompare;
            int i4 = i3 / 60;
            setTimeZone(iCompare, i4, i3 - (i4 * 60));
            return;
        }
        throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + i2 + ")");
    }

    public void normalizeToTimeZone(int i2) {
        if (i2 >= -840 && i2 <= 840) {
            int iCompare = Integer.compare(i2, 0);
            int i3 = i2 * iCompare;
            int i4 = i3 / 60;
            normalizeToTimeZone(iCompare, i4, i3 - (i4 * 60));
            return;
        }
        throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + i2 + ")");
    }

    public GDateBuilder(CharSequence charSequence) {
        this(new GDate(charSequence));
    }

    public GDateBuilder(Calendar calendar) {
        this(new GDate(calendar));
    }

    public GDateBuilder(int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
        this._bits = 30;
        if (i2 != 0) {
            this._CY = i2 <= 0 ? i2 + 1 : i2;
            this._M = i3;
            this._D = i4;
            this._h = i5;
            this._m = i6;
            this._s = i7;
            this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
            if (!isValid()) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public GDateBuilder(int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal, int i8, int i9, int i10) {
        this._bits = 31;
        if (i2 != 0) {
            this._CY = i2 <= 0 ? i2 + 1 : i2;
            this._M = i3;
            this._D = i4;
            this._h = i5;
            this._m = i6;
            this._s = i7;
            this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
            this._tzsign = i8;
            this._tzh = i9;
            this._tzm = i10;
            if (!isValid()) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public GDateBuilder(Date date) {
        setDate(date);
    }
}
