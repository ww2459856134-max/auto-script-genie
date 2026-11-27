package i.b;

import android.text.TextUtils;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class q7 {
    public static Date a(String str, String str2) throws Exception {
        if (str == null || str.trim().length() < 1) {
            throw new Exception("参数[日期]不能为空!");
        }
        if (TextUtils.isEmpty(str2)) {
            if (str.length() > 16) {
                str2 = "yyyy-MM-dd HH:mm:ss";
            } else if (str.length() > 10) {
                str2 = "yyyy_MM_dd HH:mm";
            } else {
                str.length();
                str2 = "yyyy-MM-dd";
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(str);
    }

    public static Date b(String str) {
        try {
            String strTrim = str.trim();
            if (strTrim != null && strTrim.length() != 0) {
                if (strTrim.contains("分钟前")) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(12, -Integer.valueOf(strTrim.replace("分钟前", "")).intValue());
                    return calendar.getTime();
                }
                if (strTrim.contains("分钟后")) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(12, Integer.valueOf(strTrim.replace("分钟后", "")).intValue());
                    return calendar2.getTime();
                }
                if (strTrim.contains("小时前")) {
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.add(11, -Integer.valueOf(strTrim.replace("小时前", "")).intValue());
                    return calendar3.getTime();
                }
                if (strTrim.contains("小时后")) {
                    Calendar calendar4 = Calendar.getInstance();
                    calendar4.add(11, Integer.valueOf(strTrim.replace("小时前", "")).intValue());
                    return calendar4.getTime();
                }
                if (strTrim.contains("昨天")) {
                    Calendar calendar5 = Calendar.getInstance();
                    calendar5.add(6, -1);
                    Date dateB = b(strTrim.replace("昨天", ""));
                    calendar5.set(11, dateB.getHours());
                    calendar5.set(12, dateB.getMinutes());
                    calendar5.set(13, dateB.getSeconds());
                    return calendar5.getTime();
                }
                if (strTrim.contains("天前")) {
                    Calendar calendar6 = Calendar.getInstance();
                    calendar6.add(6, -Integer.valueOf(strTrim.replace("天前", "")).intValue());
                    return calendar6.getTime();
                }
                if (strTrim.contains("天后")) {
                    Calendar calendar7 = Calendar.getInstance();
                    calendar7.add(6, Integer.valueOf(strTrim.replace("天前", "")).intValue());
                    return calendar7.getTime();
                }
                if (strTrim.length() == 5) {
                    if (strTrim.contains(ProcessIdUtil.DEFAULT_PROCESSID)) {
                        return a(strTrim, "MM-dd");
                    }
                    if (strTrim.contains(".")) {
                        return a(strTrim, "MM.dd");
                    }
                    if (strTrim.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                        return a(strTrim, "HH:mm");
                    }
                    return null;
                }
                if (strTrim.length() == 8) {
                    return a(strTrim, "yyyyMMdd");
                }
                if (strTrim.length() == 6) {
                    if (!strTrim.contains("月") && !strTrim.contains("日")) {
                        return a(strTrim, "yyyyMM");
                    }
                    return a(strTrim, "MM月dd日");
                }
                if (strTrim.length() == 7) {
                    return a(strTrim, "yyyy-MM");
                }
                if (strTrim.length() == 10) {
                    if (strTrim.contains(ProcessIdUtil.DEFAULT_PROCESSID)) {
                        return a(strTrim, "yyyy-MM-dd");
                    }
                    if (strTrim.contains(".")) {
                        return a(strTrim, "yyyy.MM.dd");
                    }
                    return null;
                }
                if (strTrim.length() == 12) {
                    return a(strTrim, "yyyyMMddHHmm");
                }
                if (strTrim.length() == 13) {
                    return new Date(Long.parseLong(strTrim));
                }
                if (strTrim.length() == 16) {
                    return strTrim.contains(ProcessIdUtil.DEFAULT_PROCESSID) ? a(strTrim, "yyyy_MM_dd HH:mm") : a(strTrim, "yyyy/MM/dd HH:mm");
                }
                if (strTrim.length() == 19) {
                    return strTrim.contains(ProcessIdUtil.DEFAULT_PROCESSID) ? a(strTrim, "yyyy-MM-dd HH:mm:ss") : a(strTrim, "yyyy/MM/dd HH:mm:ss");
                }
                throw new IllegalArgumentException("日期长度不符合要求");
            }
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException("日期格式化错误：" + str + "：        " + e.getMessage());
        }
    }
}
