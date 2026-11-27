package i.b;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.a.ScreenshotAct;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskConfig;

/* loaded from: classes.dex */
public abstract class z7 {
    private static boolean a;
    private static long b;

    public static void a() {
        TaskConfig taskConfigM = da.B().M();
        taskConfigM.hidScreenCapturePermissionTaskId = 0L;
        da.B().S1(taskConfigM);
    }

    public static Task b() {
        Task taskL;
        long j2 = da.B().M().hidScreenCapturePermissionTaskId;
        if (j2 == 0 || (taskL = da.B().L(j2)) == null || taskL.getNodeMap() == null || taskL.getNodeMap().isEmpty()) {
            return null;
        }
        return taskL;
    }

    public static boolean c() {
        return b() != null;
    }

    static /* synthetic */ void d(Task task) {
        SystemClock.sleep(700L);
        try {
            new t9(task).i0();
        } catch (Exception unused) {
            FloatToast.i("HID录屏授权脚本执行失败，请重新录制");
        }
    }

    static /* synthetic */ void e(Task task) {
        try {
            v8.m().l0();
            if (TextUtils.isEmpty(task.getName())) {
                task.setName("HID录屏授权脚本");
            }
            da.B().R1(task);
            TaskConfig taskConfigM = da.B().M();
            taskConfigM.hidScreenCapturePermissionTaskId = task.getId();
            da.B().S1(taskConfigM);
            FloatToast.i("HID录屏授权脚本已保存");
        } finally {
            a = false;
            com.frame.s0.g().d(MultiGestureRecordFloatView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
        }
    }

    static /* synthetic */ void f(MultiGestureRecordFloatView multiGestureRecordFloatView, final Task task, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        com.frame.l1.e(new Runnable() { // from class: i.b.n1
            @Override // java.lang.Runnable
            public final void run() {
                z7.e(task);
            }
        });
    }

    public static void g() {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ScreenshotAct.class);
        intent.putExtra("record_hid_permission", true);
        if (!com.frame.v0.g().k()) {
            intent.setFlags(268468224);
        }
        com.frame.v0.g().startActivity(intent);
    }

    public static boolean h() {
        final Task taskB = b();
        if (taskB == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - b < 2500) {
            return true;
        }
        b = jCurrentTimeMillis;
        com.frame.l1.g(new Runnable() { // from class: i.b.o1
            @Override // java.lang.Runnable
            public final void run() {
                z7.d(taskB);
            }
        });
        return true;
    }

    public static void i() {
        if (a) {
            FloatToast.i("正在录制录屏授权脚本");
            return;
        }
        a = true;
        FloatToast.i("请在接下来的录屏授权弹窗上点一次允许/立即开始，系统会自动保存为HID授权脚本");
        com.frame.s0.g().i(FloatHandlerRecord.class);
        com.frame.s0.g().E(GesturePlayFloatView.class);
        final Task taskK = v8.m().k();
        taskK.setName("HID录屏授权脚本");
        taskK.setShowBar(false);
        taskK.setShowToast(false);
        taskK.setNeedScan(false);
        v8.m().j0(null);
        final MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().x(MultiGestureRecordFloatView.class);
        multiGestureRecordFloatView.setCallback(new lt() { // from class: i.b.p1
            @Override // com.v.lt
            public final void a(Node node) {
                z7.f(multiGestureRecordFloatView, taskK, node);
            }
        });
    }
}
