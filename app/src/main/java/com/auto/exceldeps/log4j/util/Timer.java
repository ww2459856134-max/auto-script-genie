package com.auto.exceldeps.log4j.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class Timer implements Serializable, StringBuilderFormattable {
    private static long NANO_PER_HOUR = 0;
    private static long NANO_PER_MINUTE = 0;
    private static long NANO_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 9175191792439630013L;
    private long elapsedTime;
    private final int iterations;
    private final String name;
    private ThreadLocal<Long> startTime;
    private Status status;

    /* renamed from: com.auto.exceldeps.log4j.util.Timer$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$logging$log4j$util$Timer$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$org$apache$logging$log4j$util$Timer$Status = iArr;
            try {
                iArr[Status.Started.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$util$Timer$Status[Status.Paused.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$util$Timer$Status[Status.Stopped.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Status {
        Started,
        Stopped,
        Paused
    }

    static {
        long j2 = 1000000000 * 60;
        NANO_PER_MINUTE = j2;
        NANO_PER_HOUR = j2 * 60;
    }

    public Timer(String str) {
        this(str, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timer)) {
            return false;
        }
        Timer timer = (Timer) obj;
        if (this.elapsedTime != timer.elapsedTime || this.startTime != timer.startTime) {
            return false;
        }
        String str = this.name;
        if (str == null ? timer.name != null : !str.equals(timer.name)) {
            return false;
        }
        Status status = this.status;
        Status status2 = timer.status;
        return status == null ? status2 == null : status.equals(status2);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        String str;
        sb.append("Timer ");
        sb.append(this.name);
        int i2 = AnonymousClass2.$SwitchMap$org$apache$logging$log4j$util$Timer$Status[this.status.ordinal()];
        if (i2 == 1) {
            sb.append(" started");
            return;
        }
        if (i2 == 2) {
            sb.append(" paused");
            return;
        }
        if (i2 != 3) {
            sb.append(Chars.SPACE);
            sb.append(this.status);
            return;
        }
        long j2 = this.elapsedTime;
        long j3 = NANO_PER_HOUR;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        long j6 = NANO_PER_MINUTE;
        long j7 = j5 / j6;
        long j8 = j5 % j6;
        long j9 = NANO_PER_SECOND;
        long j10 = j8 / j9;
        long j11 = j8 % j9;
        String str2 = "";
        if (j4 > 0) {
            str = "" + j4 + " hours ";
        } else {
            str = "";
        }
        if (j7 > 0 || j4 > 0) {
            str = str + j7 + " minutes ";
        }
        String str3 = (str + new DecimalFormat("#0").format(j10) + NameUtil.PERIOD) + new DecimalFormat("000000000").format(j11) + " seconds";
        sb.append(" stopped. Elapsed time: ");
        sb.append(str3);
        int i3 = this.iterations;
        if (i3 > 0) {
            long j12 = this.elapsedTime / i3;
            long j13 = NANO_PER_HOUR;
            long j14 = j12 / j13;
            long j15 = j12 % j13;
            long j16 = NANO_PER_MINUTE;
            long j17 = j15 / j16;
            long j18 = j15 % j16;
            long j19 = NANO_PER_SECOND;
            long j20 = j18 / j19;
            long j21 = j18 % j19;
            long j22 = 0;
            if (j14 > 0) {
                str2 = "" + j14 + " hours ";
                j22 = 0;
            }
            if (j17 > j22 || j14 > 0) {
                str2 = str2 + j17 + " minutes ";
            }
            String str4 = (str2 + new DecimalFormat("#0").format(j20) + NameUtil.PERIOD) + new DecimalFormat("000000000").format(j21) + " seconds";
            sb.append(" Average per iteration: ");
            sb.append(str4);
        }
    }

    public long getElapsedNanoTime() {
        return this.elapsedTime;
    }

    public long getElapsedTime() {
        return this.elapsedTime / 1000000;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 29;
        Status status = this.status;
        int iHashCode2 = iHashCode + (status != null ? status.hashCode() : 0);
        long jLongValue = this.startTime.get().longValue();
        int i2 = ((iHashCode2 * 29) + ((int) (jLongValue ^ (jLongValue >>> 32)))) * 29;
        long j2 = this.elapsedTime;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    public synchronized void pause() {
        this.elapsedTime += System.nanoTime() - this.startTime.get().longValue();
        this.startTime.set(0L);
        this.status = Status.Paused;
    }

    public synchronized void resume() {
        this.startTime.set(Long.valueOf(System.nanoTime()));
        this.status = Status.Started;
    }

    public synchronized void start() {
        this.startTime.set(Long.valueOf(System.nanoTime()));
        this.elapsedTime = 0L;
        this.status = Status.Started;
    }

    public synchronized void startOrResume() {
        if (this.status == Status.Stopped) {
            start();
        } else {
            resume();
        }
    }

    public synchronized String stop() {
        this.elapsedTime += System.nanoTime() - this.startTime.get().longValue();
        this.startTime.set(0L);
        this.status = Status.Stopped;
        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        formatTo(sb);
        return sb.toString();
    }

    public Timer(String str, int i2) {
        this.startTime = new ThreadLocal<Long>() { // from class: com.auto.exceldeps.log4j.util.Timer.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Long initialValue() {
                return 0L;
            }
        };
        this.name = str;
        this.status = Status.Stopped;
        this.iterations = i2 <= 0 ? 0 : i2;
    }
}
