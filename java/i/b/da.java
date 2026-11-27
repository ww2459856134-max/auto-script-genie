package i.b;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.auto.exceldeps.log4j.message.StructuredDataId;
import com.google.gson.Gson;
import com.s.BoxService;
import com.s.TaskService;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.FloatHandler;
import com.v.FloatHandlerRun;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.ProgressBar;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.TopTipFloatView;
import com.yl.model.AlarmTask;
import com.yl.model.AutoNotify;
import com.yl.model.FloatButtonConfig;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskConfig;
import com.yl.model.TaskSimple;
import com.yl.ui.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class da {
    public static boolean q = false;
    private static da u;
    private boolean a;
    private final h.d.g<Long, Task> b;
    private volatile t9 c;
    private long f;
    private long g;

    /* renamed from: i, reason: collision with root package name */
    private List<TaskSimple> f1390i;

    /* renamed from: j, reason: collision with root package name */
    private List<TaskSimple> f1391j;

    /* renamed from: m, reason: collision with root package name */
    private TaskConfig f1394m;

    /* renamed from: n, reason: collision with root package name */
    private long f1395n;
    public static String r = "https://api1.skyingidea.com/api_v1";
    public static String s = r + "/uploadFile2Local";
    public static String t = r + "/getScriptFile";
    public static final Object v = new Object();
    private final Object d = new Object();
    private final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    private final AtomicLong f1389h = new AtomicLong();

    /* renamed from: k, reason: collision with root package name */
    private final HashMap<String, Object> f1392k = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    public HashMap<Long, Integer> f1393l = new HashMap<>();

    /* renamed from: o, reason: collision with root package name */
    private String f1396o = StructuredDataId.RESERVED;
    private boolean p = false;

    public interface a {
        void a();

        void b();
    }

    private da() {
        List<TaskSimple> list = (List) com.frame.k0.n("taskList", List.class, TaskSimple.class);
        this.f1390i = list;
        if (list == null) {
            this.f1390i = new ArrayList();
        }
        List<TaskSimple> list2 = (List) com.frame.k0.n("deletedTaskList", List.class, TaskSimple.class);
        this.f1391j = list2;
        if (list2 == null) {
            this.f1391j = new ArrayList();
        }
        this.b = new h.d.g<>((int) (Runtime.getRuntime().maxMemory() / 10));
    }

    public static synchronized da B() {
        da daVar;
        da daVar2 = u;
        if (daVar2 != null) {
            return daVar2;
        }
        synchronized (v) {
            daVar = new da();
            u = daVar;
        }
        return daVar;
    }

    static /* synthetic */ void C0(Task task) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("循环结束错误");
        dingMsgView.h(task == null ? "循环结束后跳转任务失败，任务未找到，请查看编辑。" : "循环结束后不能跳转到当前任务，请查看编辑。");
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.f5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(Task task) {
        try {
            String string = task.toJson().toString();
            com.frame.v0.e().edit().putString("task:" + task.getId(), string).apply();
            this.b.d(Long.valueOf(task.getId()), task);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    static /* synthetic */ void F0(MediaPlayer mediaPlayer) throws IllegalStateException {
        try {
            mediaPlayer.start();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private boolean F1(JSONObject jSONObject, long j2, long j3) throws JSONException {
        boolean zG1 = G1(jSONObject, "nextTaskId", j2, j3);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("condition");
        if (jSONObjectOptJSONObject != null) {
            zG1 |= F1(jSONObjectOptJSONObject, j2, j3);
        }
        String strOptString = jSONObject.optString("arg1", null);
        if (TextUtils.isEmpty(strOptString)) {
            return zG1;
        }
        String strTrim = strOptString.trim();
        if (!strTrim.startsWith("[") || !strTrim.endsWith("]")) {
            return zG1;
        }
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            boolean zF1 = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    zF1 |= F1(jSONObjectOptJSONObject2, j2, j3);
                }
            }
            if (!zF1) {
                return zG1;
            }
            jSONObject.put("arg1", jSONArray.toString());
            return true;
        } catch (Exception unused) {
            return zG1;
        }
    }

    static /* synthetic */ void G0(String str) throws IllegalStateException, IOException, IllegalArgumentException {
        try {
            com.frame.y0.g("播放默认声音");
            AssetFileDescriptor assetFileDescriptorOpenFd = com.frame.v0.g().getAssets().openFd(str);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            mediaPlayer.prepare();
            com.frame.l1.e(new Runnable() { // from class: i.b.e4
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    da.F0(mediaPlayer);
                }
            });
        } catch (Exception unused) {
            Log.e("playAudio", "未找到资源：" + str);
        }
    }

    private boolean G1(JSONObject jSONObject, String str, long j2, long j3) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.optLong(str, 0L) != j2) {
            return false;
        }
        jSONObject.put(str, j3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(long j2, Task task) {
        synchronized (this.d) {
            if (j2 != this.f1389h.get()) {
                return;
            }
            t9 t9Var = this.c;
            i2(false);
            if (t9Var != null && !t9Var.b(2000L)) {
                com.frame.y0.o("旧任务退出超时，使用隔离资源继续切换任务");
            }
            if (j2 == this.f1389h.get()) {
                g2(task, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0() {
        try {
            try {
            } catch (JSONException e) {
                com.frame.y0.j("重启任务失败：" + e.getMessage() + "，请从主任务重新执行");
            }
            if (!U()) {
                SharedPreferences sharedPreferencesF = com.frame.v0.f();
                long j2 = sharedPreferencesF.getLong("doTaskId", 0L);
                if (j2 != 0) {
                    long j3 = sharedPreferencesF.getLong("brokenTime", 0L);
                    if (j2 != this.f || j3 != this.g) {
                        if (System.currentTimeMillis() - j3 < M().needResetOfferTimeByBrokenRun) {
                            long j4 = sharedPreferencesF.getLong("doNodeId", 0L);
                            String string = sharedPreferencesF.getString("taskRecoveryStack", null);
                            this.f = j2;
                            this.g = j3;
                            com.frame.y0.j("重启被中断的任务");
                            this.f1395n = System.currentTimeMillis();
                            if (string != null) {
                                s9 s9Var = new s9(string, j2, j4, this);
                                long j5 = s9Var.e;
                                if (j5 > 0) {
                                    this.f1395n = j5;
                                }
                                a1(s9Var.a, s9Var.b, s9Var.d, true, s9Var.f, false, s9Var.c);
                            } else {
                                Task taskL = L(j2);
                                if (taskL == null) {
                                    com.frame.y0.j("重启任务失败，未找到任务");
                                } else {
                                    com.frame.y0.o("旧版恢复记录不含父任务位置，仅恢复当前任务");
                                    b2(taskL, taskL.getNodeMap().get(Long.valueOf(j4)), true, null, false);
                                }
                            }
                            return;
                        }
                        com.frame.y0.j("重启时间超过" + (M().needResetOfferTimeByBrokenRun / 1000) + "秒");
                    }
                }
            }
        } finally {
            this.e.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0(TaskSimple taskSimple) {
        SharedPreferences sharedPreferencesE = com.frame.v0.e();
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        String string = sharedPreferencesE.getString("deletedTask:" + taskSimple.getId(), null);
        if (!TextUtils.isEmpty(string)) {
            editorEdit.putString("task:" + taskSimple.getId(), string);
        }
        editorEdit.remove("deletedTask:" + taskSimple.getId()).apply();
        P1();
        O1();
    }

    static /* synthetic */ void P0(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            intent.putExtra(SocialConstants.PARAM_TYPE, "login");
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    private boolean Q(Task task) {
        return task != null && P(task.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(long j2) {
        return j2 == 0 || j2 == this.f1389h.get();
    }

    static /* synthetic */ void S0(View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.putExtra("fromEvent", "downloadLimit");
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    private boolean T(Long l2) {
        if (l2 != null && AccountTool.d().j()) {
            if (l2.equals(AccountTool.d().c().getPid())) {
                return true;
            }
            String strF = com.frame.n0.f("subUserIds", "");
            if (TextUtils.isEmpty(strF)) {
                return false;
            }
            for (String str : strF.split(",")) {
                if (String.valueOf(l2).equals(str.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ void T0() {
        if (B().V()) {
            com.frame.n0.g("ingi11", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(Task task) {
        X1(task.getCreateUserId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(Task task) {
        X1(task.getCreateUserId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(Task task) {
        SystemClock.sleep(1000L);
        if (com.frame.a1.b().c() == null) {
            com.frame.a1.b().h();
        }
        this.p = false;
        g(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(Task task, Node node, boolean z, boolean z2, a aVar, boolean z3, int i2) throws JSONException {
        this.f1395n = System.currentTimeMillis();
        a1(task, node, z, z2, aVar, z3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(Task task) {
        SystemClock.sleep(1000L);
        if (com.frame.a1.b().c() == null) {
            com.frame.a1.b().h();
        }
        this.p = false;
        g(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(Task task) {
        int i2;
        AccessibilityNodeInfo root;
        for (int i3 = 0; i3 < 30; i3++) {
            SystemClock.sleep(o.a.f.a(1500, 5000));
            try {
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            for (String str : this.f1396o.split(",")) {
                if (U()) {
                    if (task != null && !TextUtils.isEmpty(task.getPn()) && task.getPn().contains(str)) {
                        W1();
                        this.p = false;
                        return;
                    }
                    try {
                        List<AccessibilityWindowInfo> windows = BoxService.m().getWindows();
                        for (int size = windows.size() - 1; size >= 0; size--) {
                            try {
                                root = windows.get(size).getRoot();
                            } catch (Exception e2) {
                                com.frame.k0.r(e2);
                            }
                            if (root != null && root.getPackageName() != null && String.valueOf(root.getPackageName()).contains(str)) {
                                W1();
                                this.p = false;
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        com.frame.k0.r(e3);
                    }
                    com.frame.k0.r(e);
                }
            }
        }
        this.p = false;
        if (U()) {
            g(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1(final Task task, final Node node, final boolean z, final boolean z2, final a aVar, final boolean z3, final int i2) {
        com.frame.l1.g(new Runnable() { // from class: i.b.t5
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.b1(task, node, z, z2, aVar, z3, i2);
            }
        });
    }

    private String d(long j2, long j3) {
        Task taskL = L(j2);
        if (taskL == null) {
            return null;
        }
        try {
            return e(taskL.toJson().toString(), j2, j3);
        } catch (Exception e) {
            com.frame.k0.r(e);
            return null;
        }
    }

    static /* synthetic */ void d0(t9 t9Var, Task task) {
        try {
            if (t9Var.q()) {
                B().V1(t9Var);
            }
            x7.d().b(task.getRepeatDelay());
            if (t9Var.q()) {
                B().V1(t9Var);
                t9Var.i0();
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public void b1(final Task task, final Node node, final boolean z, final boolean z2, final a aVar, final boolean z3, final int i2) throws JSONException {
        if (task == null) {
            return;
        }
        com.frame.a1.b().a();
        if (q && !AccountTool.d().m()) {
            Z1();
            return;
        }
        if (z3) {
            if (com.frame.n0.a("fWg2", true)) {
                new Thread(new Runnable() { // from class: i.b.x5
                    @Override // java.lang.Runnable
                    public final void run() {
                        da.T0();
                    }
                }).start();
                com.frame.n0.g("fWg2", false);
            }
            com.frame.n0.a("ingi11", false);
            final ea eaVar = new ea();
            if (!eaVar.d()) {
                return;
            }
            if (task.isNeedScan() && !eaVar.c()) {
                return;
            }
            if (AccountTool.d().m()) {
                AccountTool.d().A(new Runnable() { // from class: i.b.z6
                    @Override // java.lang.Runnable
                    public final void run() {
                        eaVar.y();
                    }
                });
            }
        }
        if (!AccountTool.d().j()) {
            new ea().E("请登录后再试。");
            return;
        }
        if (new l9().g(task)) {
            if (task.getCreateUserId() != null && task.getLimitUserId() != null) {
                if (!AccountTool.d().j()) {
                    com.frame.l1.e(new Runnable() { // from class: i.b.e7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.Y1();
                        }
                    });
                    return;
                }
                if (!AccountTool.d().k(task.getCreateUserId())) {
                    if (task.getLimitUserId().longValue() == -1) {
                        if (!T(task.getCreateUserId())) {
                            com.frame.l1.e(new Runnable() { // from class: i.b.u5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.c.V0(task);
                                }
                            });
                            return;
                        }
                    } else if (!AccountTool.d().k(task.getLimitUserId()) && !AccountTool.d().k(task.getCreateUserId()) && !T(task.getCreateUserId())) {
                        com.frame.l1.e(new Runnable() { // from class: i.b.v4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.X0(task);
                            }
                        });
                        return;
                    }
                }
            }
            if (task.isNeedScan() && i9.v().F()) {
                com.frame.y0.m("截图方式：无障碍截图（无需录屏授权，画面更新受系统频率限制）");
            }
            if (task.isNeedScan() && !i9.v().B()) {
                if (com.frame.w0.d()) {
                    BoxService.m().x();
                }
                i9.v().n0(new Runnable() { // from class: i.b.o4
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.Z0(task, node, z, z2, aVar, z3, i2);
                    }
                });
                i9.v().q0();
                return;
            }
            if (!AccountTool.d().m() && task.getNodeMap() != null && task.getNodeMap().size() > 50) {
                com.frame.l1.e(new Runnable() { // from class: i.b.b7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.a2();
                    }
                });
                return;
            }
            if (System.currentTimeMillis() - com.frame.k0.b() > 6048000000L && AccountTool.d().l() && AccountTool.d().c().getVipEndTime() == null) {
                return;
            }
            this.a = com.frame.n0.a("errorContinue", true);
            if (z2) {
                com.frame.y0.o("➤➤➤开始执行任务:" + task.getName());
            }
            if (!com.frame.w0.d()) {
                if (Build.VERSION.SDK_INT < 28 || !O()) {
                    com.frame.l1.e(new Runnable() { // from class: i.b.m5
                        @Override // java.lang.Runnable
                        public final void run() {
                            da.g1();
                        }
                    });
                    return;
                } else if (!y7.e()) {
                    y7.c("执行脚本", new Runnable() { // from class: i.b.n5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.d1(task, node, z, z2, aVar, z3, i2);
                        }
                    });
                    return;
                }
            }
            if (task.getCreateUserId() != null && task.getLimitTime() != null && System.currentTimeMillis() > task.getLimitTime().longValue()) {
                com.frame.l1.e(new Runnable() { // from class: i.b.g6
                    @Override // java.lang.Runnable
                    public final void run() {
                        da.i1();
                    }
                });
                return;
            }
            if (this.c != null && this.c.q() && this.c.l() != null && this.c.l().getId() == task.getId()) {
                com.frame.y0.j("此任务未执行完成，不再重复执行");
                return;
            }
            float f = M().scanNum;
            if (task.getArgumentJson() != null) {
                try {
                    JSONArray jSONArray = new JSONArray(task.getArgumentJson());
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        E1(jSONObject.optString("key"), jSONObject.optString("value"));
                    }
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
            try {
                t9 t9Var = new t9(task);
                t9Var.d0(z);
                t9Var.h0(aVar);
                this.c = t9Var;
                if (this.f1395n == 0) {
                    this.f1395n = System.currentTimeMillis();
                }
                t9Var.k0(node, i2);
                g(task);
                com.frame.l1.e(new Runnable() { // from class: i.b.c4
                    @Override // java.lang.Runnable
                    public final void run() {
                        da.j1(task, z);
                    }
                });
            } catch (Exception e2) {
                FloatToast.i("执行出错，请排查节点列表");
                com.frame.y0.l(e2);
            }
        }
    }

    private String e(String str, long j2, long j3) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("id", j3);
            G1(jSONObject, "nextTaskId", j2, j3);
            G1(jSONObject, "repeatFinishJumpTaskId", j2, j3);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("nodeMap");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(itKeys.next());
                    if (jSONObjectOptJSONObject2 != null) {
                        F1(jSONObjectOptJSONObject2, j2, j3);
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            com.frame.k0.r(e);
            return null;
        }
    }

    static /* synthetic */ void e1(View view) {
        com.permission.x0.m().a();
        com.frame.s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void f0(List list) {
        SharedPreferences.Editor editorEdit = com.frame.v0.e().edit();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove("deletedTask:" + ((TaskSimple) it.next()).getId());
        }
        editorEdit.putString("deletedTaskList", "[]").apply();
    }

    static /* synthetic */ void g1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("任务执行失败");
        dingMsgView.h("还未开启或丢失了无障碍服务，请先开启后才可执行~");
        dingMsgView.k("立即开启", new View.OnClickListener() { // from class: i.b.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                da.e1(view);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.t4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
    }

    private void g2(final Task task, final long j2) {
        com.frame.l1.g(new Runnable() { // from class: i.b.k5
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.q1(j2, task);
            }
        });
    }

    static /* synthetic */ void h0(final EditText editText, v.b bVar) {
        Runnable runnable;
        AccessibilityNodeInfo root;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (System.currentTimeMillis() - jCurrentTimeMillis < 1500) {
                    Iterator<AccessibilityWindowInfo> it = BoxService.m().getWindows().iterator();
                    while (it.hasNext()) {
                        try {
                            root = it.next().getRoot();
                        } catch (Exception e) {
                            com.frame.k0.r(e);
                        }
                        if (EditText.class.getName().equals(root.getClassName())) {
                            root.performAction(1);
                            root.performAction(32768);
                            bVar.a(null, editText.getText().toString());
                            return;
                        }
                        continue;
                    }
                }
                runnable = new Runnable() { // from class: i.b.o5
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.s0.g().o(editText);
                    }
                };
            } catch (Exception e2) {
                com.frame.k0.r(e2);
                com.frame.y0.j("---从剪切板获取内容出错---");
                bVar.a(null, null);
                runnable = new Runnable() { // from class: i.b.o5
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.s0.g().o(editText);
                    }
                };
            }
            com.frame.l1.e(runnable);
        } finally {
            com.frame.l1.e(new Runnable() { // from class: i.b.o5
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().o(editText);
                }
            });
        }
    }

    static /* synthetic */ void i1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("任务执行失败");
        dingMsgView.h("制作者对脚本做了限时操作，已经过了授权失效");
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.l5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
    }

    private void i2(boolean z) {
        t9 t9VarD = t9.d();
        if (t9VarD != null && t9VarD != this.c) {
            t9VarD.l0();
            return;
        }
        i9.v().l();
        if (this.c != null) {
            this.c.c();
            if (this.c.l() != null) {
                com.frame.y0.j("stopTask：" + this.c.l().getName());
            }
            this.c.l0();
        } else {
            com.frame.y0.j("stopTask");
            p();
        }
        if (this.c == null || this.c.l() == null) {
            return;
        }
        p();
        Task taskL = this.c.l();
        if (z) {
            try {
                if (taskL.isNeedScan()) {
                    if (M().stopScreenCapAfterFinish) {
                        i9.v().s();
                    } else {
                        i9.v().r0();
                    }
                }
            } catch (Exception e) {
                com.frame.y0.l(e);
                return;
            }
        }
        a aVarM = this.c.m();
        com.frame.l1.c(2299, new Runnable() { // from class: i.b.a5
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().a(GesturePlayFloatView.class);
            }
        }, 2000L);
        com.frame.l1.e(new Runnable() { // from class: i.b.r4
            @Override // java.lang.Runnable
            public final void run() {
                da.s1();
            }
        });
        if (aVarM != null) {
            aVarM.b();
        }
        com.frame.l1.e(new Runnable() { // from class: i.b.b6
            @Override // java.lang.Runnable
            public final void run() {
                w7.g().u();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0(t9 t9Var) throws JSONException {
        y1(t9Var, true);
    }

    static /* synthetic */ void j1(Task task, boolean z) {
        com.frame.l1.i(2299);
        com.frame.s0.g().E(GesturePlayFloatView.class);
        if (task.isShowBar()) {
            try {
                if (z) {
                    FloatHandlerRun.T().P();
                } else {
                    com.frame.s0.g().i(FloatHandler.class);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2() {
        try {
            TopTipFloatView topTipFloatViewA = TopTipFloatView.a(null, "任务完成，将要自动锁屏", null);
            final ca caVar = new ca(this, 10000L, 1000L, topTipFloatViewA);
            caVar.start();
            topTipFloatViewA.findViewById(j.b.e.c).setOnClickListener(new View.OnClickListener() { // from class: i.b.h5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    da.u1(caVar, view);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private void l(long j2) {
        List<AutoNotify> listC = l7.b().c();
        boolean z = false;
        for (int size = listC.size() - 1; size >= 0; size--) {
            AutoNotify autoNotify = listC.get(size);
            if (autoNotify != null && autoNotify.taskId == j2) {
                listC.remove(size);
                z = true;
            }
        }
        if (z) {
            l7.b().d();
        }
    }

    private void m(long j2) {
        ArrayList arrayList = new ArrayList();
        for (FloatButtonConfig floatButtonConfig : w7.g().e()) {
            if (floatButtonConfig != null && floatButtonConfig.taskId == j2) {
                arrayList.add(floatButtonConfig);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            w7.g().q((FloatButtonConfig) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(String str, long j2, long j3) throws JSONException {
        SharedPreferences sharedPreferencesE = com.frame.v0.e();
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        if (TextUtils.isEmpty(str)) {
            str = e(sharedPreferencesE.getString("task:" + j2, null), j2, j3);
        }
        if (!TextUtils.isEmpty(str)) {
            editorEdit.putString("deletedTask:" + j3, str);
        }
        editorEdit.remove("task:" + j2).apply();
        P1();
        O1();
        o(j2);
    }

    private void n(long j2) {
        List<Node> listF = k8.d().f();
        boolean z = false;
        for (int size = listF.size() - 1; size >= 0; size--) {
            Node node = listF.get(size);
            if (node != null && (node.nextId == j2 || node.nextTaskId == j2)) {
                listF.remove(size);
                z = true;
            }
        }
        if (z) {
            k8.d().i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o1(long j2, Task task, PowerManager.WakeLock wakeLock) throws JSONException {
        if (S(j2)) {
            B().b2(task, null, M().isShowHandlerWithAutoRun, new ba(this, task, wakeLock), false);
        }
    }

    private void o(long j2) {
        boolean z;
        s8.c(j2);
        l(j2);
        List<AlarmTask> listJ = i7.p().j(j2);
        if (listJ == null || listJ.isEmpty()) {
            z = false;
        } else {
            i7.p().k().removeAll(listJ);
            i7.p().D();
            z = true;
            for (AlarmTask alarmTask : listJ) {
                String str = "定时任务：" + alarmTask.name;
                i.a.l lVar = new i.a.l();
                lVar.h(alarmTask.id + "");
                lVar.h(str);
            }
        }
        if (z) {
            i7.p().e();
        }
        m(j2);
        if (J() == j2) {
            U1(0L);
        }
        if (i7.p().q() == j2) {
            i7.p().J(0L);
        }
        n(j2);
    }

    static /* synthetic */ void o0(CountDownTimer countDownTimer, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        countDownTimer.cancel();
    }

    private void p() {
        synchronized (this.d) {
            com.frame.v0.f().edit().remove("doTaskId").remove("doNodeId").remove("brokenTime").remove("taskRecoveryStack").apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(t9 t9Var, String str) {
        if (t9Var == null || t9Var == this.c) {
            h2();
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("任务失败");
            if (this.f1395n == 0) {
                dingMsgView.h(str);
            } else {
                dingMsgView.h(String.format("任务失败：耗时：<font color='#55CA9B'>%s</font>，%s", com.frame.m1.d(System.currentTimeMillis() - this.f1395n), str));
            }
            final y9 y9Var = new y9(this, 10000L, 1000L, dingMsgView);
            y9Var.start();
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.v5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    da.o0(y9Var, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1(final long j2, final Task task) throws JSONException {
        if (S(j2)) {
            com.frame.y0.o("startTaskWithLock");
            final RelativeLayout relativeLayout = null;
            if (!i7.p().v()) {
                final PowerManager.WakeLock wakeLockG = ((PowerManager) com.frame.v0.g().getSystemService("power")).isScreenOn() ? null : i7.p().G();
                com.frame.l1.g(new Runnable() { // from class: i.b.y4
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.o1(j2, task, wakeLockG);
                    }
                });
                return;
            }
            PowerManager.WakeLock wakeLockG2 = i7.p().G();
            long jQ = i7.p().q();
            if (jQ == 0) {
                B().w1("未设置解锁手势，无法解锁，自动执行任务被中断~");
                i7.p().A(wakeLockG2);
                return;
            }
            Task taskL = B().L(jQ);
            if (taskL == null || Q(taskL)) {
                B().w1("未设置解锁手势，无法解锁，自动执行任务被中断~");
                i7.p().A(wakeLockG2);
                return;
            }
            if (B().M().isAutoCover) {
                relativeLayout = (RelativeLayout) View.inflate(com.frame.v0.g(), j.b.f.d, null);
                final LottieAnimationView lottieAnimationView = (LottieAnimationView) relativeLayout.findViewById(j.b.e.a);
                lottieAnimationView.setFailureListener(new com.airbnb.lottie.g0() { // from class: i.b.r5
                    @Override // com.airbnb.lottie.g0
                    public final void a(Object obj) {
                        lottieAnimationView.setVisibility(8);
                    }
                });
                com.frame.l1.f(new Runnable() { // from class: i.b.n4
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.s0.g().D(relativeLayout);
                    }
                }, 500L);
                com.frame.l1.f(new Runnable() { // from class: i.b.f4
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.s0.g().o(relativeLayout);
                    }
                }, 8000L);
            }
            B().b2(taskL, null, M().isShowHandlerWithAutoRun, new aa(this, j2, relativeLayout, task, wakeLockG2), false);
        }
    }

    private boolean s(long j2) {
        List<TaskSimple> list = this.f1390i;
        if (list == null) {
            return false;
        }
        for (TaskSimple taskSimple : list) {
            if (taskSimple != null && taskSimple.getId() == j2) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void s1() {
        com.frame.s0.g().d(FloatHandlerRun.class);
        com.frame.s0.g().u(FloatHandler.class);
        if (com.frame.s0.g().f(ProgressBar.class) != null) {
            com.frame.s0.g().d(ProgressBar.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(View view) {
        TaskConfig taskConfig = this.f1394m;
        taskConfig.isFinishAlert = false;
        S1(taskConfig);
        com.frame.s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void u1(CountDownTimer countDownTimer, View view) {
        countDownTimer.cancel();
        com.frame.s0.g().d(TopTipFloatView.class);
    }

    private long v(long j2) {
        SharedPreferences sharedPreferencesE = com.frame.v0.e();
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (jCurrentTimeMillis != j2 && !s(jCurrentTimeMillis) && !P(jCurrentTimeMillis)) {
                if (sharedPreferencesE.contains("task:" + jCurrentTimeMillis)) {
                    continue;
                } else {
                    if (!sharedPreferencesE.contains("deletedTask:" + jCurrentTimeMillis)) {
                        return jCurrentTimeMillis;
                    }
                }
            }
            jCurrentTimeMillis++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(View view) {
        try {
            com.frame.s0.g().d(DingMsgView.class);
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("提醒");
            dingMsgView.h("是否确定不再弹出任务完成窗口");
            dingMsgView.k("确定", new View.OnClickListener() { // from class: i.b.w5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.c.u0(view2);
                }
            });
            dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.w4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public static final String x() {
        try {
            return com.frame.a1.b().e("ignorePn", com.frame.n1.b("tK4rwyns2X3pBeZHBZPp7FbRg2pHmgphMQ/2ksgB/DGnHCeMr0x2e/PLlLgIhLUNmkIaIIHckn66\nX0lNd1CuqN4JUNU5ntwzS4n+/7iYURjssb6V+/JJ4prn1T9eYniW+Tn/T2xNBPpzOuWLiVycc10T\nO5iTnIgB6FZYRaypuCVxWb1jxXfr+vCTm/6VnQ60\n"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(Task task) {
        try {
            if (this.f1394m.isFinishSound) {
                i7.p().y();
            }
            if (this.f1394m.isFinishVibrator && com.frame.n0.b("vibrator") == 0) {
                try {
                    ((Vibrator) com.frame.v0.g().getSystemService("vibrator")).vibrate(new long[]{100, 200}, -1);
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
            h();
            if (task.isShowBar()) {
                ((FloatHandlerRun) com.frame.s0.g().h(FloatHandlerRun.class)).O();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f1395n;
            com.frame.y0.n(task.getName() + "脚本执行完成，耗时：" + jCurrentTimeMillis);
            w7.g().u();
            if (!this.f1394m.isFinishAlert || k()) {
                return;
            }
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("任务完成");
            if (Build.VERSION.SDK_INT < 35 || !com.frame.b1.a()) {
                dingMsgView.h(String.format("任务耗时：<font color='#55CA9B'>%s</font>", com.frame.m1.d(jCurrentTimeMillis)));
            } else {
                dingMsgView.h(String.format("任务耗时：<font color='#55CA9B'>%s</font>，发现您设备是<font color='#F45075'>澎湃2</font>系统，这类APP仅在<font color='#F45075'>澎湃2</font>上都存在点击过快或被干扰时就会失效问题，一旦出现模拟点击失效只能重启手机了，为了避免此类问题，<font color='#F45075'>执行的时候避免碰屏幕，使用音量键来停止脚本。</font>", com.frame.m1.d(jCurrentTimeMillis)));
            }
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.b4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.z4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            TextView textView = new TextView(com.frame.v0.g());
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setText("不再提示任务完成");
            textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(15.0f), 0, com.frame.p1.c(10.0f));
            textView.setTextSize(12.0f);
            textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
            textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: i.b.y5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.x0(view);
                }
            });
            dingMsgView.m(textView);
        } catch (Exception e2) {
            com.frame.y0.l(e2);
        }
    }

    private void y1(t9 t9Var, boolean z) throws JSONException {
        if (z && t9Var.n()) {
            return;
        }
        if (this.c != t9Var) {
            t9Var.l0();
            return;
        }
        final Task taskL = t9Var.l();
        Runnable runnable = new Runnable() { // from class: i.b.q5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z0(taskL);
            }
        };
        if (j(t9Var)) {
            return;
        }
        this.f1393l.remove(Long.valueOf(taskL.getId()));
        if (z || taskL.getRepeatFinishJumpTaskId() == 0) {
            a aVarM = t9Var.m();
            if ((z || t9Var.q()) && aVarM != null) {
                if (z) {
                    t9Var.h0(null);
                    com.frame.y0.m("【结束子任务/循环】触发原返回回调，父任务已停止时不恢复");
                }
                aVarM.b();
                aVarM.a();
                t9Var.l0();
                t9Var.h0(null);
                return;
            }
            t9Var.l0();
            p();
            if (z) {
                com.frame.y0.m("【结束子任务/循环】无返回任务，结束当前执行链");
            }
            com.frame.l1.e(runnable);
            if (taskL.isNeedScan()) {
                if (M().stopScreenCapAfterFinish) {
                    i9.v().s();
                    return;
                } else {
                    i9.v().r0();
                    return;
                }
            }
            return;
        }
        final Task taskL2 = L(taskL.getRepeatFinishJumpTaskId());
        if (taskL2 == null || taskL2.getId() == taskL.getId()) {
            com.frame.y0.j(taskL.getName() + "循环执行完成，跳转任务无效，任务id:" + taskL.getRepeatFinishJumpTaskId());
            com.frame.l1.e(new Runnable() { // from class: i.b.e6
                @Override // java.lang.Runnable
                public final void run() {
                    da.C0(taskL2);
                }
            });
            h2();
            return;
        }
        com.frame.y0.g("【循环完成后跳转】「" + taskL.getName() + "」→「" + taskL2.getName() + "」：由来源任务的【循环设置】触发；即使节点已调用过目标任务，这里仍会按此设置执行。");
        a aVarM2 = t9Var.m();
        boolean zP = t9Var.p();
        t9Var.h0(null);
        t9Var.l0();
        this.f1395n = System.currentTimeMillis();
        c2(taskL2, null, zP, true, aVarM2, false);
    }

    public static File z() {
        return com.frame.v0.g().getDataDir();
    }

    public HashMap A() {
        return this.f1392k;
    }

    public void A1() {
        if (this.c != null) {
            com.frame.y0.j("pauseTask");
            this.c.l0();
        }
    }

    public void B1(final String str) {
        com.frame.l1.g(new Runnable() { // from class: i.b.i4
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IOException, IllegalArgumentException {
                da.G0(str);
            }
        });
    }

    public List<TaskSimple> C() {
        return this.f1390i;
    }

    public void C1(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            com.frame.y0.g("播放声音：" + str);
            MediaPlayer mediaPlayer = new MediaPlayer();
            if (str.contains("content://")) {
                mediaPlayer.setDataSource(com.frame.v0.g(), Uri.parse(str));
            } else {
                mediaPlayer.setDataSource(str);
            }
            mediaPlayer.setLooping(false);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("playAudio", "未找到资源：" + str);
        }
    }

    public List<TaskSimple> D(String str, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (str == null) {
            HashMap map = new HashMap();
            while (i3 < this.f1390i.size()) {
                TaskSimple taskSimple = this.f1390i.get(i3);
                if (TextUtils.isEmpty(taskSimple.getGroup())) {
                    arrayList.add(taskSimple);
                } else {
                    TaskSimple taskSimple2 = (TaskSimple) map.get(taskSimple.getGroup());
                    if (taskSimple2 == null) {
                        taskSimple2 = new TaskSimple();
                        taskSimple2.setPn("group");
                        taskSimple2.setName(taskSimple.getGroup());
                        arrayList.add(taskSimple2);
                        map.put(taskSimple.getGroup(), taskSimple2);
                        taskSimple2.setChildren(new ArrayList());
                    }
                    taskSimple.setLevel(1);
                    taskSimple2.getChildren().add(taskSimple);
                    if (taskSimple.getName().equals(taskSimple.getGroup())) {
                        taskSimple2.setDefaultTaskId(taskSimple.getId());
                    }
                }
                i3++;
            }
            for (TaskSimple taskSimple3 : map.values()) {
                taskSimple3.setChildren(K(taskSimple3.getChildren(), i2));
            }
        } else {
            while (i3 < this.f1390i.size()) {
                TaskSimple taskSimple4 = this.f1390i.get(i3);
                if (str.equals(taskSimple4.getGroup())) {
                    arrayList.add(taskSimple4);
                }
                i3++;
            }
        }
        return K(arrayList, i2);
    }

    public void D1(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (TextUtils.isEmpty(str) || "default".equals(str)) {
            B1("ding.mp3");
        } else {
            C1(str);
        }
    }

    public Set<String> E() {
        return this.f1392k.keySet();
    }

    public void E1(String str, Object obj) {
        this.f1392k.put(str, obj);
    }

    public Object F(String str) {
        return this.f1392k.get(str);
    }

    public String G(String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("${") && str.contains("}")) {
            int iIndexOf = 0;
            while (true) {
                if (!str.contains("${now}")) {
                    if (!str.contains("${utc}")) {
                        if (!str.contains("${year}")) {
                            if (!str.contains("${hour}")) {
                                if (!str.contains("${minute}")) {
                                    if (!str.contains("${second}")) {
                                        if (!str.contains("${date}")) {
                                            if (!str.contains("${month}")) {
                                                if (!str.contains("${day}")) {
                                                    if (!str.contains("${week}")) {
                                                        if (!str.contains("${time}")) {
                                                            if (!str.contains("${screenWidth}")) {
                                                                if (!str.contains("${screenHeight}")) {
                                                                    if (!str.contains("${currentPackageName}")) {
                                                                        if (!str.contains("${battery}")) {
                                                                            break;
                                                                        }
                                                                        int intProperty = ((BatteryManager) com.frame.v0.g().getSystemService("batterymanager")).getIntProperty(4);
                                                                        int iIndexOf2 = str.indexOf("${battery}") + 10;
                                                                        str = str.replace("${battery}", intProperty + "");
                                                                        iIndexOf = iIndexOf2;
                                                                    } else {
                                                                        iIndexOf = str.indexOf("${currentPackageName}") + 21;
                                                                        List<AccessibilityWindowInfo> windows = BoxService.m().getWindows();
                                                                        try {
                                                                            try {
                                                                                int size = windows.size() - 1;
                                                                                while (true) {
                                                                                    if (size < 0) {
                                                                                        break;
                                                                                    }
                                                                                    AccessibilityNodeInfo root = windows.get(size).getRoot();
                                                                                    if (root != null) {
                                                                                        str = str.replace("${currentPackageName}", ((Object) root.getPackageName()) + "");
                                                                                        break;
                                                                                    }
                                                                                    size--;
                                                                                }
                                                                            } catch (Exception e) {
                                                                                com.frame.k0.r(e);
                                                                            }
                                                                        } finally {
                                                                            str.replace("${currentPackageName}", "null");
                                                                        }
                                                                    }
                                                                } else {
                                                                    iIndexOf = str.indexOf("${screenHeight}") + 15;
                                                                    str = str.replace("${screenHeight}", com.frame.k0.c().d() + "");
                                                                }
                                                            } else {
                                                                iIndexOf = str.indexOf("${screenWidth}") + 14;
                                                                str = str.replace("${screenWidth}", com.frame.k0.c().e() + "");
                                                            }
                                                        } else {
                                                            iIndexOf = str.indexOf("${time}") + 7;
                                                            str = str.replace("${time}", com.frame.m1.b(System.currentTimeMillis(), "HH:mm:ss"));
                                                        }
                                                    } else {
                                                        iIndexOf = str.indexOf("${week}") + 7;
                                                        str = str.replace("${week}", new String[]{"日", "一", "二", "三", "四", "五", "六"}[Calendar.getInstance().get(7) - 1]);
                                                    }
                                                } else {
                                                    iIndexOf = str.indexOf("${day}") + 6;
                                                    str = str.replace("${day}", com.frame.m1.b(System.currentTimeMillis(), "dd"));
                                                }
                                            } else {
                                                iIndexOf = str.indexOf("${month}") + 8;
                                                str = str.replace("${month}", com.frame.m1.b(System.currentTimeMillis(), "MM"));
                                            }
                                        } else {
                                            iIndexOf = str.indexOf("${date}") + 7;
                                            str = str.replace("${date}", com.frame.m1.b(System.currentTimeMillis(), "yyyy-MM-dd"));
                                        }
                                    } else {
                                        iIndexOf = str.indexOf("${second}") + 9;
                                        str = str.replace("${second}", com.frame.m1.b(System.currentTimeMillis(), "ss"));
                                    }
                                } else {
                                    iIndexOf = str.indexOf("${minute}") + 9;
                                    str = str.replace("${minute}", com.frame.m1.b(System.currentTimeMillis(), "mm"));
                                }
                            } else {
                                iIndexOf = str.indexOf("${hour}") + 7;
                                str = str.replace("${hour}", com.frame.m1.b(System.currentTimeMillis(), "HH"));
                            }
                        } else {
                            iIndexOf = str.indexOf("${year}") + 7;
                            str = str.replace("${year}", com.frame.m1.b(System.currentTimeMillis(), "yyyy"));
                        }
                    } else {
                        iIndexOf = str.indexOf("${utc}") + 6;
                        str = str.replace("${utc}", System.currentTimeMillis() + "");
                    }
                } else {
                    iIndexOf = str.indexOf("${now}") + 6;
                    str = str.replace("${now}", com.frame.m1.b(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            str = I1(str, this.f1392k);
            HashSet hashSet = new HashSet();
            while (iIndexOf != -1) {
                iIndexOf = str.indexOf("$utc{", iIndexOf);
                if (iIndexOf >= 0) {
                    int iIndexOf3 = str.indexOf("}", iIndexOf);
                    iIndexOf += 5;
                    hashSet.add(str.substring(iIndexOf, iIndexOf3));
                }
            }
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    long jC = str2.length() == 19 ? com.frame.m1.c("yyyy-MM-dd HH:mm:ss", str2) : str2.length() == 20 ? com.frame.m1.c("yyyy年MM月dd日 HH:mm:ss", str2) : str2.length() == 16 ? com.frame.m1.c("yyyy-MM-dd HH:mm", str2) : str2.length() == 17 ? com.frame.m1.c("yyyy年MM月dd日 HH:mm", str2) : 0L;
                    str = str.replace("$utc{" + str2 + "}", jC + "");
                }
            }
        }
        return str;
    }

    public String H(String str) {
        return this.f1392k.get(str) + "";
    }

    public void H1(final Task task) {
        if (task == null) {
            return;
        }
        final long jIncrementAndGet = this.f1389h.incrementAndGet();
        com.frame.l1.g(new Runnable() { // from class: i.b.h4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.I0(jIncrementAndGet, task);
            }
        });
    }

    public String I(String str, String str2) {
        if (!this.f1392k.containsKey(str)) {
            return str2;
        }
        return this.f1392k.get(str) + "";
    }

    public String I1(String str, Map<String, Object> map) {
        boolean z;
        int i2;
        int iIndexOf;
        String strK1;
        for (boolean z2 = true; z2; z2 = z) {
            StringBuilder sb = new StringBuilder();
            z = false;
            int i3 = 0;
            while (i3 < str.length()) {
                if (str.charAt(i3) != '$' || (i2 = i3 + 2) >= str.length() || str.charAt(i3 + 1) != '{' || (iIndexOf = str.indexOf(125, i2)) == -1 || (strK1 = K1(str.substring(i2, iIndexOf), map)) == null) {
                    sb.append(str.charAt(i3));
                    i3++;
                } else {
                    sb.append(strK1);
                    i3 = iIndexOf + 1;
                    z = true;
                }
            }
            str = sb.toString();
        }
        return str;
    }

    public long J() {
        return com.frame.n0.d("resetPhoneAT", 0L);
    }

    public void J1() {
        this.f1392k.clear();
    }

    public List<TaskSimple> K(List<TaskSimple> list, int i2) {
        if (list == null) {
            return null;
        }
        return i2 == 2 ? (List) list.stream().sorted(new u9(this)).collect(Collectors.toList()) : i2 == -2 ? (List) list.stream().sorted(new v9(this)).collect(Collectors.toList()) : i2 == -1 ? (List) list.stream().sorted(new w9(this)).collect(Collectors.toList()) : i2 == 1 ? (List) list.stream().sorted(new x9(this)).collect(Collectors.toList()) : list;
    }

    public String K1(String str, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        return string.contains("${") ? I1(string, map) : string;
    }

    public Task L(long j2) {
        Task taskC = this.b.c(Long.valueOf(j2));
        if (taskC != null) {
            return taskC;
        }
        Task task = (Task) com.frame.k0.l("task:" + j2, Task.class);
        if (task == null) {
            return null;
        }
        this.b.d(Long.valueOf(task.getId()), task);
        return task;
    }

    public void L1() {
        if (!com.frame.w0.d()) {
            com.frame.y0.j("无障碍未开...");
        } else {
            if (U() || !this.e.compareAndSet(false, true)) {
                return;
            }
            com.frame.l1.g(new Runnable() { // from class: i.b.c6
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.K0();
                }
            });
        }
    }

    public TaskConfig M() {
        if (this.f1394m == null) {
            this.f1394m = (TaskConfig) com.frame.k0.l("taskConfig", TaskConfig.class);
        }
        if (this.f1394m == null) {
            TaskConfig taskConfig = new TaskConfig();
            this.f1394m = taskConfig;
            taskConfig.scanButtonText = com.permission.a1.g().l() ? "允许" : "立即";
        }
        return this.f1394m;
    }

    public synchronized void M1(final TaskSimple taskSimple) {
        for (int i2 = 0; i2 < this.f1391j.size(); i2++) {
            if (this.f1391j.get(i2).getId() == taskSimple.getId()) {
                TaskSimple taskSimpleRemove = this.f1391j.remove(i2);
                taskSimpleRemove.setDeletedAt(0L);
                this.f1390i.add(taskSimpleRemove);
                com.frame.l1.g(new Runnable() { // from class: i.b.e5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.M0(taskSimple);
                    }
                });
                return;
            }
        }
    }

    public t9 N() {
        return this.c;
    }

    public void N1() {
        if (this.c != null) {
            this.c.c0();
        }
    }

    public boolean O() {
        return Build.VERSION.SDK_INT >= 28 && com.bluetooth.cursor.w.q.l();
    }

    public synchronized void O1() {
        com.frame.v0.e().edit().putString("deletedTaskList", new Gson().s(new ArrayList(this.f1391j))).apply();
    }

    public synchronized boolean P(long j2) {
        Iterator<TaskSimple> it = this.f1391j.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == j2) {
                return true;
            }
        }
        return false;
    }

    public synchronized void P1() {
        com.frame.v0.e().edit().putString("taskList", new Gson().s(new ArrayList(this.f1390i))).apply();
    }

    public void Q1(t9 t9Var) {
        synchronized (this.d) {
            if (t9Var == this.c && t9Var.q() && t9Var.i() != null) {
                if (!this.a) {
                    p();
                    return;
                }
                try {
                    com.frame.v0.f().edit().putLong("doTaskId", t9Var.l().getId()).putLong("doNodeId", t9Var.i().id).putLong("brokenTime", System.currentTimeMillis()).putString("taskRecoveryStack", s9.a(t9Var, this.f1395n, this)).apply();
                } catch (JSONException e) {
                    com.frame.y0.j("保存任务恢复位置失败：" + e.getMessage());
                }
            }
        }
    }

    public boolean R(String str) {
        Iterator<TaskSimple> it = this.f1390i.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getName())) {
                return true;
            }
        }
        return false;
    }

    public void R1(Task task) {
        TaskSimple taskSimple;
        task.updateTime = System.currentTimeMillis();
        task.setScreenWith(com.frame.k0.c().e());
        task.setScreenHeight(com.frame.k0.c().d());
        z1(task);
        if (this.f1390i == null) {
            this.f1390i = new ArrayList();
        }
        TaskSimple taskSimple2 = new TaskSimple();
        taskSimple2.setId(task.getId());
        int iIndexOf = this.f1390i.indexOf(taskSimple2);
        if (iIndexOf != -1) {
            taskSimple = this.f1390i.get(iIndexOf);
        } else {
            taskSimple = new TaskSimple();
            this.f1390i.add(0, taskSimple);
        }
        taskSimple.updateTime = task.updateTime;
        taskSimple.setPn(task.getPn());
        taskSimple.setId(task.getId());
        taskSimple.setName(task.getName());
        taskSimple.setRepeatCount(task.getRepeatCount());
        taskSimple.setRepeatDelay(task.getRepeatDelay());
        taskSimple.setRepeatFinishJumpTaskId(task.getRepeatFinishJumpTaskId());
        if (!TextUtils.isEmpty(task.getGroup())) {
            taskSimple.setGroup(task.getGroup());
        }
        this.b.d(Long.valueOf(task.getId()), task);
        P1();
    }

    public void S1(TaskConfig taskConfig) {
        com.frame.v0.e().edit().putString("taskConfig", new Gson().s(taskConfig)).apply();
        this.f1394m = taskConfig;
    }

    public List<TaskSimple> T1(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f1390i.size(); i2++) {
            TaskSimple taskSimple = this.f1390i.get(i2);
            if (taskSimple != null && !TextUtils.isEmpty(taskSimple.getName()) && taskSimple.getName().contains(str)) {
                arrayList.add(taskSimple);
            }
        }
        return arrayList;
    }

    public boolean U() {
        return this.c != null && this.c.q();
    }

    public void U1(Long l2) {
        com.frame.n0.j("resetPhoneAT", l2.longValue());
    }

    public boolean V() {
        return W(true);
    }

    public void V1(t9 t9Var) {
        this.c = t9Var;
    }

    public boolean W(boolean z) {
        if (com.frame.n0.a("ingi11", false)) {
            return true;
        }
        List<TaskSimple> listC = B().C();
        String strX = x();
        for (TaskSimple taskSimple : listC) {
            try {
                for (String str : strX.split(",")) {
                    if (taskSimple.getPn() != null && taskSimple.getPn().contains(str)) {
                        com.frame.n0.g("ingi11", true);
                        return true;
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        return false;
    }

    public void W1() {
        String strD = com.frame.a1.b().d("ignoreAlert");
        if (TextUtils.isEmpty(strD)) {
            h2();
        } else {
            w1(strD);
        }
    }

    public void X1(Long l2) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("脚本创建者将此脚本限制特定用户使用，您不可用，请切换账号！或请联系脚本创建者ID:" + l2 + "（非官方开发者）！");
        dingMsgView.i("知道了", new View.OnClickListener() { // from class: i.b.d5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.l("温馨提示");
    }

    public void Y1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("请先登录后使用此脚本？");
        dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.m4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.k("去登录", new View.OnClickListener() { // from class: i.b.x4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                da.P0(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void Z1() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("已过期，请联系脚本制作者。");
        dingMsgView.i("知道了", new View.OnClickListener() { // from class: i.b.p4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.l("温馨提示");
    }

    public void a2() {
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("请APP升级会员后才能执行脚本（会员仅是APP使用权，与脚本无关）。");
            dingMsgView.k("去开通", new View.OnClickListener() { // from class: i.b.d6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    da.S0(view);
                }
            });
            dingMsgView.i("取消", new View.OnClickListener() { // from class: i.b.u4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.g(j.b.d.M0);
            dingMsgView.l("温馨提示");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b2(Task task, Node node, boolean z, a aVar, boolean z2) throws JSONException {
        c2(task, node, z, true, aVar, z2);
    }

    public void c2(Task task, Node node, boolean z, boolean z2, a aVar, boolean z3) throws JSONException {
        a1(task, node, z, z2, aVar, z3, 0);
    }

    public void e2(Task task, boolean z) {
        if (task == null) {
            return;
        }
        this.f1395n = System.currentTimeMillis();
        b2(task, null, j7.a().f(), null, z);
    }

    public void f() {
        if (M().isResetRepeatCountAfterTaskFinish) {
            this.f1393l.clear();
        }
    }

    public void f2(Task task) {
        g2(task, 0L);
    }

    public void g(final Task task) {
        if (this.p) {
            return;
        }
        if (StructuredDataId.RESERVED.equals(this.f1396o)) {
            String strX = x();
            if (strX == null) {
                com.frame.l1.g(new Runnable() { // from class: i.b.c5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.Y(task);
                    }
                });
            } else {
                this.f1396o = strX;
            }
        }
        if (StructuredDataId.RESERVED.equalsIgnoreCase(this.f1396o)) {
            com.frame.l1.g(new Runnable() { // from class: i.b.g5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.a0(task);
                }
            });
        }
        if (TextUtils.isEmpty(this.f1396o) || StructuredDataId.RESERVED.equals(this.f1396o)) {
            return;
        }
        this.p = true;
        com.frame.l1.g(new Runnable() { // from class: i.b.q4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c0(task);
            }
        });
    }

    public void h() {
        if (this.f1394m.isResetParamsAfterTaskFinish) {
            this.f1392k.clear();
        }
    }

    public void h2() {
        i2(true);
    }

    public void i() throws PendingIntent.CanceledException {
        try {
            Long lValueOf = Long.valueOf(J());
            if (lValueOf == null || lValueOf.longValue() == 0) {
                return;
            }
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) TaskService.class);
            intent.putExtra("resetPhoneAT", lValueOf);
            try {
                com.frame.i0.g(12312, intent).send();
            } catch (PendingIntent.CanceledException e) {
                com.frame.k0.r(e);
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public boolean j(final t9 t9Var) {
        com.frame.y0.o("checkRunRepeat:" + t9Var.l().getName() + "-线程:" + t9Var.q());
        if (!t9Var.q()) {
            return false;
        }
        final Task taskL = t9Var.l();
        int iIntValue = this.f1393l.getOrDefault(Long.valueOf(taskL.getId()), 0).intValue() + 1;
        if (iIntValue >= taskL.getRepeatCount() && taskL.getRepeatCount() != -1) {
            return false;
        }
        this.f1393l.put(Long.valueOf(taskL.getId()), Integer.valueOf(iIntValue));
        StringBuilder sb = new StringBuilder();
        sb.append("➤➤➤「");
        sb.append(taskL.getName());
        sb.append("」任务，循环执行:第<big><strong>");
        sb.append(iIntValue + 1);
        sb.append("</strong></big>(");
        sb.append(taskL.getRepeatCount() == -1 ? "无限" : Integer.valueOf(taskL.getRepeatCount()));
        sb.append(")次");
        com.frame.y0.m(sb.toString());
        com.frame.l1.g(new Runnable() { // from class: i.b.h6
            @Override // java.lang.Runnable
            public final void run() {
                da.d0(t9Var, taskL);
            }
        });
        return true;
    }

    public boolean k() {
        if (!com.frame.n0.a("ffinsh", true)) {
            return false;
        }
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("任务完成");
        dingMsgView.h("已完成一次录制与执行流程。");
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: i.b.b5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        com.frame.n0.g("ffinsh", false);
        return true;
    }

    public synchronized void q() {
        final ArrayList arrayList = new ArrayList(this.f1391j);
        this.f1391j.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.b.e(Long.valueOf(((TaskSimple) it.next()).getId()));
        }
        com.frame.l1.g(new Runnable() { // from class: i.b.z5
            @Override // java.lang.Runnable
            public final void run() {
                da.f0(arrayList);
            }
        });
    }

    public void r(final v.b bVar) {
        final EditText editText = new EditText(com.frame.v0.g());
        editText.setImeOptions(6);
        com.frame.s0.g().A(editText, 0, 0, 1, 1);
        editText.post(new Runnable() { // from class: i.b.i5
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.l1.g(new Runnable() { // from class: i.b.g4
                    @Override // java.lang.Runnable
                    public final void run() {
                        da.h0(editText, bVar);
                    }
                });
            }
        });
    }

    public a t(t9 t9Var) {
        return new r9(t9Var);
    }

    public void u(final t9 t9Var) {
        if (t9Var == null || t9Var.l() == null || t9Var != this.c || !t9Var.b0()) {
            return;
        }
        com.frame.y0.m("【结束子任务/循环】「" + t9Var.l().getName() + "」取消剩余节点及循环，跳过循环完成后跳转");
        this.f1393l.remove(Long.valueOf(t9Var.l().getId()));
        t9Var.l0();
        com.frame.l1.e(new Runnable() { // from class: i.b.s5
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.k0(t9Var);
            }
        });
    }

    public synchronized void v1(TaskSimple taskSimple) {
        if (taskSimple == null) {
            return;
        }
        final long id = taskSimple.getId();
        final long jV = v(id);
        final String strD = d(id, jV);
        this.b.e(Long.valueOf(id));
        this.f1390i.remove(taskSimple);
        TaskSimple taskSimple2 = (TaskSimple) new Gson().j(new Gson().s(taskSimple), TaskSimple.class);
        taskSimple2.setId(jV);
        taskSimple2.setDeletedAt(System.currentTimeMillis());
        this.f1391j.add(0, taskSimple2);
        com.frame.l1.g(new Runnable() { // from class: i.b.p5
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.n0(strD, id, jV);
            }
        });
    }

    public TaskSimple w(long j2) {
        for (TaskSimple taskSimple : this.f1390i) {
            if (taskSimple.getId() == j2) {
                return taskSimple;
            }
        }
        return null;
    }

    public void w1(final String str) {
        final t9 t9VarD = t9.d();
        com.frame.l1.e(new Runnable() { // from class: i.b.a6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q0(t9VarD, str);
            }
        });
    }

    public void x1(t9 t9Var) throws JSONException {
        if (t9Var.o()) {
            return;
        }
        y1(t9Var, false);
    }

    public List<TaskSimple> y() {
        ArrayList arrayList = new ArrayList(this.f1391j);
        arrayList.sort(new Comparator() { // from class: i.b.f6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((TaskSimple) obj2).getDeletedAt(), ((TaskSimple) obj).getDeletedAt());
            }
        });
        return arrayList;
    }

    public synchronized void z1(final Task task) {
        com.frame.l1.g(new Runnable() { // from class: i.b.j5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.E0(task);
            }
        });
    }
}
