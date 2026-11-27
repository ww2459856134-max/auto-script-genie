package com.yl.model;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.frame.k0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class AlarmTask {
    public long canEditTimeEnd;
    public long canEditTimeStart;
    public long duration;
    public long endTime;
    public long id;
    public long intervalMs;
    public boolean isArea;
    public boolean isInterval;
    public boolean isOpen;

    @Deprecated
    public boolean isSingleLoop;
    public boolean limitClose;
    public String name;
    public long nextFireAt;
    public List<Integer> repeat;
    public long startTime;
    public long taskId;
    public String time;
    public String weekStr;
    public List<String> whiteLists;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AlarmTask) && this.id == ((AlarmTask) obj).id;
    }

    public long getCrossDayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.endTime));
        int i2 = calendar.get(11);
        int i3 = calendar.get(12);
        try {
            return new SimpleDateFormat("HH:mm").parse(i2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + i3).getTime();
        } catch (Exception e) {
            k0.r(e);
            return 0L;
        }
    }

    public String getEndTimeStr() {
        return new SimpleDateFormat("HH:mm").format(Long.valueOf(this.endTime));
    }

    public String getStartTimeStr() {
        return new SimpleDateFormat("HH:mm").format(Long.valueOf(this.startTime));
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }

    public boolean isCrossDay() {
        return this.endTime >= 57600000;
    }
}
