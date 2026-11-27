package com.frame;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public abstract class m1 {
    public static final String a(String str) {
        return b(System.currentTimeMillis(), str);
    }

    public static final String b(long j2, String str) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static final long c(String str, String str2) {
        try {
            return new SimpleDateFormat(str).parse(str2).getTime();
        } catch (Exception e) {
            k0.r(e);
            return 0L;
        }
    }

    public static String d(long j2) {
        int i2 = (int) (j2 / 3600000);
        int i3 = ((int) (j2 % 3600000)) / 60000;
        int i4 = ((int) (j2 % 60000)) / XmlValidationError.INCORRECT_ATTRIBUTE;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i2);
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        }
        sb.append(String.format("%02d", Integer.valueOf(i3)));
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(String.format("%02d", Integer.valueOf(i4)));
        return sb.toString();
    }

    public static final long e(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str).getTime();
    }
}
