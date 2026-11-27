package i.b;

import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.google.gson.Gson;
import com.s.TaskService;
import com.yl.float_ui.DingMsgView;
import com.yl.model.AlarmTask;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class i7 {
    private static i7 d;
    private List<AlarmTask> a;
    private KeyguardManager b = (KeyguardManager) com.frame.v0.g().getSystemService("keyguard");
    private PowerManager.WakeLock c;

    private i7() {
    }

    public static String g(long j2) {
        if (j2 <= 0) {
            return "0毫秒";
        }
        if (j2 >= 3600000 && j2 % 3600000 == 0) {
            return (j2 / 3600000) + "小时";
        }
        if (j2 >= 60000 && j2 % 60000 == 0) {
            return (j2 / 60000) + "分钟";
        }
        if (j2 < 1000 || j2 % 1000 != 0) {
            return j2 + "毫秒";
        }
        return (j2 / 1000) + "秒";
    }

    private long o(Calendar calendar, long j2) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        Calendar calendar3 = (Calendar) calendar.clone();
        calendar3.set(11, calendar2.get(11));
        calendar3.set(12, calendar2.get(12));
        calendar3.set(13, calendar2.get(13));
        calendar3.set(14, 0);
        return calendar3.getTimeInMillis();
    }

    public static i7 p() {
        i7 i7Var = d;
        if (i7Var != null) {
            return i7Var;
        }
        i7 i7Var2 = new i7();
        d = i7Var2;
        return i7Var2;
    }

    static /* synthetic */ void x(Task task) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("无障碍权限丢失，触发自动任务「%s」失败，请联系技术小哥~", task.getName()));
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void A(PowerManager.WakeLock wakeLock) {
        if (wakeLock != null) {
            try {
                wakeLock.release();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public void B(long j2) {
        com.frame.v0.f().edit().remove("atk:" + j2).apply();
    }

    public void C(AlarmTask alarmTask) throws NumberFormatException {
        int iA;
        String str = alarmTask.time;
        if (str == null || str.equals(l(alarmTask))) {
            try {
                iA = o.a.f.a((int) alarmTask.startTime, (int) alarmTask.endTime);
            } catch (IllegalArgumentException unused) {
                iA = (int) alarmTask.startTime;
            }
            alarmTask.time = com.frame.m1.b(iA, "HH:mm");
            b(alarmTask);
            D();
        }
    }

    public void D() {
        F(new Gson().s(this.a));
    }

    public void E(List<AlarmTask> list) {
        this.a = list;
        F(new Gson().s(list));
    }

    public void F(String str) {
        com.frame.n0.k("notify_list_data", str);
    }

    public PowerManager.WakeLock G() {
        com.frame.y0.g("解锁屏幕");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) com.frame.v0.g().getSystemService("power")).newWakeLock(268435466, "bright");
        wakeLockNewWakeLock.acquire();
        ((KeyguardManager) com.frame.v0.g().getSystemService("keyguard")).newKeyguardLock("unLock").disableKeyguard();
        this.c = wakeLockNewWakeLock;
        return wakeLockNewWakeLock;
    }

    public void H(AlarmTask alarmTask) {
        com.frame.v0.f().edit().putString("atTime:" + alarmTask.id, alarmTask.time).apply();
    }

    public void I(long j2) {
        com.frame.v0.f().edit().putInt("atk:" + j2, Calendar.getInstance().get(6)).apply();
    }

    public void J(Long l2) {
        com.frame.n0.j("unlockTaskId", l2.longValue());
    }

    public void K(AlarmTask alarmTask) {
        if (com.frame.w0.d()) {
            com.frame.k0.i("ding_alarm_start");
            da.B().e2(da.B().L(alarmTask.taskId), false);
        } else {
            final Task taskL = da.B().L(alarmTask.taskId);
            if (taskL == null) {
                return;
            }
            com.frame.l1.e(new Runnable() { // from class: i.b.g
                @Override // java.lang.Runnable
                public final void run() {
                    i7.x(taskL);
                }
            });
        }
    }

    public void a(AlarmTask alarmTask) throws NumberFormatException {
        try {
            String[] strArrSplit = alarmTask.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i2);
            calendar.set(12, i3);
            calendar.set(13, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(1, 1);
            long timeInMillis2 = calendar.getTimeInMillis();
            String str = "定时任务：" + alarmTask.name;
            i.a.l lVar = new i.a.l();
            lVar.h(alarmTask.id + "");
            lVar.c(str, alarmTask.id + "", timeInMillis, timeInMillis2, alarmTask.repeat);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b(AlarmTask alarmTask) throws NumberFormatException {
        try {
            String[] strArrSplit = alarmTask.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i2);
            calendar.set(12, i3);
            calendar.set(13, 0);
            calendar.add(6, 1);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(1, 1);
            long timeInMillis2 = calendar.getTimeInMillis();
            String str = "定时任务：" + alarmTask.name;
            i.a.l lVar = new i.a.l();
            lVar.h(alarmTask.id + "");
            lVar.c(str, alarmTask.id + "", timeInMillis, timeInMillis2, alarmTask.repeat);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void c(AlarmTask alarmTask) {
        if (alarmTask.isInterval) {
            long jF = f(alarmTask, System.currentTimeMillis() + 1);
            if (jF <= 0) {
                alarmTask.nextFireAt = 0L;
            } else {
                alarmTask.nextFireAt = jF;
                alarmTask.time = com.frame.m1.b(jF, "HH:mm:ss");
            }
            D();
        }
    }

    public synchronized void d() {
        try {
            com.frame.y0.o("检测定时任务");
            if (da.B().U()) {
                try {
                    com.frame.y0.j("已有任务在执行中：" + da.B().N().l().getName());
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
            AlarmTask alarmTaskM = p().m();
            if (alarmTaskM != null && alarmTaskM.isOpen && !t(alarmTaskM.id, Calendar.getInstance().get(6))) {
                if (alarmTaskM.name != null) {
                    com.frame.y0.g("定时开启任务：" + alarmTaskM.name);
                } else {
                    com.frame.y0.g("定时开启任务：" + alarmTaskM.id);
                }
                K(alarmTaskM);
            }
            e();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b A[PHI: r5
      0x018b: PHI (r5v14 int) = (r5v12 int), (r5v15 int) binds: [B:63:0x0189, B:59:0x0182] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        Calendar calendar;
        int i2;
        int i3;
        List<AlarmTask> list;
        ArrayList arrayList;
        long j2;
        int i4;
        int i5;
        boolean z;
        i7 i7Var = this;
        Calendar calendar2 = Calendar.getInstance();
        int i6 = calendar2.get(7);
        int i7 = calendar2.get(6);
        char c = 0;
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<AlarmTask> listK = k();
        ArrayList arrayList2 = null;
        int i8 = 0;
        boolean z2 = false;
        long j3 = Long.MAX_VALUE;
        AlarmTask alarmTask = null;
        while (i8 < listK.size()) {
            AlarmTask alarmTask2 = listK.get(i8);
            if (alarmTask2.isOpen) {
                int i9 = i6;
                boolean zT = i7Var.t(alarmTask2.id, i7);
                if (alarmTask2.isInterval) {
                    long jF = alarmTask2.nextFireAt;
                    if (jF <= jCurrentTimeMillis) {
                        jF = i7Var.f(alarmTask2, jCurrentTimeMillis);
                    }
                    if (jF <= 0) {
                        calendar = calendar2;
                        i3 = i7;
                        list = listK;
                        arrayList = arrayList2;
                        j2 = j3;
                        i2 = i9;
                    } else {
                        alarmTask2.nextFireAt = jF;
                        alarmTask2.time = com.frame.m1.b(jF, "HH:mm:ss");
                        Calendar calendar3 = calendar2;
                        if (da.B().L(alarmTask2.taskId) == null || jF <= jCurrentTimeMillis || jF >= j3) {
                            if (da.B().L(alarmTask2.taskId) == null) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(alarmTask2);
                            }
                            i3 = i7;
                        } else {
                            j3 = jF;
                            i3 = i7;
                            alarmTask = alarmTask2;
                        }
                        list = listK;
                        z2 = true;
                        i2 = i9;
                        calendar = calendar3;
                        i8++;
                        i7Var = this;
                        i6 = i2;
                        calendar2 = calendar;
                        i7 = i3;
                        listK = list;
                        c = 0;
                    }
                } else {
                    Calendar calendar4 = calendar2;
                    if (alarmTask2.isArea && !zT) {
                        String str = alarmTask2.time;
                        if (str == null || str.equals(l(alarmTask2))) {
                            i4 = i7;
                            long jCurrentTimeMillis2 = System.currentTimeMillis() % 86400000;
                            j2 = j3;
                            long j4 = alarmTask2.startTime;
                            list = listK;
                            if (j4 <= jCurrentTimeMillis2) {
                                arrayList = arrayList2;
                                if (jCurrentTimeMillis2 < alarmTask2.endTime) {
                                }
                                i3 = i4;
                                i2 = i9;
                                calendar = calendar4;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (((int) Math.max(j4, jCurrentTimeMillis2)) <= ((int) alarmTask2.endTime)) {
                                alarmTask2.time = com.frame.m1.b(o.a.f.a(r3, r4), "HH:mm");
                                a(alarmTask2);
                                z2 = true;
                            }
                            i3 = i4;
                            i2 = i9;
                            calendar = calendar4;
                        }
                        if (TextUtils.isEmpty(alarmTask2.time)) {
                            int i10 = Integer.parseInt(alarmTask2.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[c]);
                            int i11 = Integer.parseInt(alarmTask2.time.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[1]);
                            arrayList2 = arrayList;
                            j3 = j2;
                            for (Integer num : alarmTask2.repeat) {
                                int i12 = i4;
                                Calendar calendar5 = calendar4;
                                calendar5.set(7, num.intValue());
                                calendar5.set(11, i10);
                                calendar5.set(12, i11);
                                calendar5.set(13, 0);
                                long timeInMillis = calendar5.getTimeInMillis();
                                if (zT) {
                                    i5 = i9;
                                    if (i5 == num.intValue()) {
                                        Calendar calendar6 = Calendar.getInstance();
                                        int iIntValue = num.intValue();
                                        z = zT;
                                        calendar6.set(7, iIntValue);
                                        calendar6.set(11, i10);
                                        calendar6.set(12, i11);
                                        calendar6.set(13, 0);
                                        timeInMillis = calendar6.getTimeInMillis() + 604800000;
                                    }
                                    if (timeInMillis <= jCurrentTimeMillis && timeInMillis < j3) {
                                        if (da.B().L(alarmTask2.taskId) != null) {
                                            alarmTask = alarmTask2;
                                            j3 = timeInMillis;
                                        } else {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(alarmTask2);
                                        }
                                    }
                                    i9 = i5;
                                    calendar4 = calendar5;
                                    zT = z;
                                    i4 = i12;
                                } else {
                                    i5 = i9;
                                }
                                if (timeInMillis >= jCurrentTimeMillis) {
                                    z = zT;
                                }
                                if (timeInMillis <= jCurrentTimeMillis) {
                                }
                                i9 = i5;
                                calendar4 = calendar5;
                                zT = z;
                                i4 = i12;
                            }
                            i3 = i4;
                            calendar = calendar4;
                            i2 = i9;
                            i8++;
                            i7Var = this;
                            i6 = i2;
                            calendar2 = calendar;
                            i7 = i3;
                            listK = list;
                            c = 0;
                        } else {
                            i3 = i4;
                            arrayList2 = arrayList;
                            i2 = i9;
                            calendar = calendar4;
                        }
                    }
                    i4 = i7;
                    list = listK;
                    arrayList = arrayList2;
                    j2 = j3;
                    if (TextUtils.isEmpty(alarmTask2.time)) {
                    }
                }
                j3 = j2;
                i8++;
                i7Var = this;
                i6 = i2;
                calendar2 = calendar;
                i7 = i3;
                listK = list;
                c = 0;
            } else {
                calendar = calendar2;
                i2 = i6;
                i3 = i7;
                list = listK;
                arrayList = arrayList2;
                j2 = j3;
            }
            arrayList2 = arrayList;
            j3 = j2;
            i8++;
            i7Var = this;
            i6 = i2;
            calendar2 = calendar;
            i7 = i3;
            listK = list;
            c = 0;
        }
        List<AlarmTask> list2 = listK;
        ArrayList arrayList3 = arrayList2;
        long j5 = j3;
        if (arrayList3 != null) {
            list2.removeAll(arrayList3);
        }
        com.frame.j0 j0Var = new com.frame.j0();
        if (alarmTask == null) {
            com.frame.y0.g("没有下次的定时任务");
            j0Var.a(new Intent(com.frame.v0.g(), (Class<?>) TaskService.class));
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("下次定时任务：");
            sb.append(TextUtils.isEmpty(alarmTask.name) ? Long.valueOf(alarmTask.id) : alarmTask.name);
            sb.append("（");
            sb.append(com.frame.m1.b(j5, "yyyy-MM-dd HH:mm:ss"));
            sb.append("）");
            com.frame.y0.g(sb.toString());
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) TaskService.class);
            intent.putExtra("taskId", alarmTask.taskId);
            intent.putExtra("alarmId", alarmTask.id);
            intent.putExtra("pn", com.frame.v0.g().getPackageName());
            j0Var.a(intent);
            j0Var.c(j5, intent);
            if (z2) {
                p().D();
            }
        } catch (Exception e) {
            com.frame.y0.o("定时出错");
            com.frame.k0.r(e);
        }
    }

    public long f(AlarmTask alarmTask, long j2) {
        long j3 = 0;
        if (alarmTask.isInterval && alarmTask.intervalMs > 0 && alarmTask.isOpen) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            int i2 = 0;
            while (i2 < 8) {
                Calendar calendar2 = (Calendar) calendar.clone();
                calendar2.add(6, i2);
                if (u(alarmTask, calendar2.getTimeInMillis())) {
                    long jO = o(calendar2, alarmTask.startTime);
                    long jO2 = o(calendar2, alarmTask.endTime);
                    if (jO2 <= jO) {
                        continue;
                    } else {
                        long jMax = Math.max(j2, jO);
                        if (jMax >= jO2) {
                            continue;
                        } else {
                            if (jMax <= jO) {
                                return jO;
                            }
                            long j4 = alarmTask.intervalMs;
                            long j5 = jO + ((((jMax - jO) / j4) + 1) * j4);
                            if (j5 < jO2) {
                                return j5;
                            }
                        }
                    }
                }
                i2++;
                j3 = 0;
            }
        }
        return j3;
    }

    public AlarmTask h(long j2) {
        for (AlarmTask alarmTask : k()) {
            if (alarmTask.id == j2) {
                return alarmTask;
            }
        }
        return null;
    }

    public String i() {
        return com.frame.n0.f("notify_list_data", "");
    }

    public List<AlarmTask> j(long j2) {
        ArrayList arrayList = new ArrayList();
        List<AlarmTask> listK = k();
        for (int i2 = 0; i2 < listK.size(); i2++) {
            if (listK.get(i2).taskId == j2) {
                arrayList.add(listK.get(i2));
            }
        }
        return arrayList;
    }

    public List<AlarmTask> k() {
        if (this.a == null) {
            r();
        }
        return this.a;
    }

    public String l(AlarmTask alarmTask) {
        return com.frame.v0.f().getString("atTime:" + alarmTask.id, null);
    }

    public AlarmTask m() {
        String strB = com.frame.m1.b(n(), "HH:mm");
        List<AlarmTask> listK = k();
        int i2 = Calendar.getInstance().get(7);
        for (int i3 = 0; i3 < listK.size(); i3++) {
            AlarmTask alarmTask = listK.get(i3);
            if (alarmTask.isOpen) {
                List<Integer> list = alarmTask.repeat;
                if ((list != null && list.contains(Integer.valueOf(i2))) && strB.equals(alarmTask.time)) {
                    return alarmTask;
                }
            }
        }
        return null;
    }

    public long n() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 1970);
        calendar.set(2, 0);
        calendar.set(5, 1);
        return calendar.getTime().getTime();
    }

    public long q() {
        return com.frame.n0.d("unlockTaskId", 0L);
    }

    public void r() {
        try {
            String strI = i();
            if (!TextUtils.isEmpty(strI)) {
                this.a = (List) new Gson().k(strI, com.google.gson.k0.a.c(List.class, AlarmTask.class).e());
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
    }

    public void s(AlarmTask alarmTask) {
        if (alarmTask.isInterval) {
            alarmTask.isArea = false;
            long jF = f(alarmTask, System.currentTimeMillis());
            alarmTask.nextFireAt = jF;
            if (jF > 0) {
                alarmTask.time = com.frame.m1.b(jF, "HH:mm:ss");
            }
        }
    }

    public boolean t(long j2, int i2) {
        SharedPreferences sharedPreferencesF = com.frame.v0.f();
        StringBuilder sb = new StringBuilder();
        sb.append("atk:");
        sb.append(j2);
        return sharedPreferencesF.getInt(sb.toString(), 0) == i2;
    }

    public boolean u(AlarmTask alarmTask, long j2) {
        List<Integer> list;
        if (!alarmTask.isInterval || (list = alarmTask.repeat) == null || list.isEmpty()) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return alarmTask.repeat.contains(Integer.valueOf(calendar.get(7)));
    }

    public boolean v() {
        return this.b.inKeyguardRestrictedInputMode();
    }

    public final void y() {
        da.B().B1("ding.mp3");
    }

    public void z() {
        A(this.c);
    }
}
