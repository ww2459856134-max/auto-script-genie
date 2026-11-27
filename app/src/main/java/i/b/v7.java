package i.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.user.AccountTool;
import com.yl.model.AlarmTask;
import com.yl.model.FloatButtonConfig;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.io.File;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class v7 {
    private static final Charset b = StandardCharsets.UTF_8;
    private static final l.a.a.f.t.c c = l.a.a.f.t.c.NORMAL;
    private boolean a = true;

    static void b(Task task, boolean z, boolean z2, String str, Long l2, Long l3, Long l4) {
        Long createUserId = task.getCreateUserId();
        if (s8.a(task) || createUserId == null || createUserId.equals(l4)) {
            if (createUserId == null) {
                task.setCreateUserId(l4);
            }
            task.setLimitTime(l2);
            task.setCanNotShare(z);
            task.setActCode(z2);
            task.setPwd(str);
            task.setLimitUserId(l3);
        }
    }

    static void c(Task task, Long l2, long j2, boolean z, boolean z2, String str, Long l3, Long l4) {
        e(task, l2);
        g(j2, l2);
        b(task, z, z2, str, l3, l4, l2);
        task.setCreateUserId(Long.valueOf(j2));
    }

    public static void e(Task task, Long l2) {
        if (task == null) {
            throw new IllegalArgumentException("脚本不存在，无法转让");
        }
        if (l2 == null || !l2.equals(task.getCreateUserId())) {
            throw new IllegalArgumentException("【" + task.getName() + "】不是您创建的脚本，无法转让");
        }
    }

    public static void f(Task task) {
        AccountTool accountToolD = AccountTool.d();
        if (!accountToolD.j() || !accountToolD.l()) {
            throw new IllegalStateException("转让脚本仅限已登录的SVIP使用");
        }
        e(task, accountToolD.g());
    }

    private static void g(long j2, Long l2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("请输入正确的用户ID（正整数）");
        }
        if (Long.valueOf(j2).equals(l2)) {
            throw new IllegalArgumentException("不能将脚本转让给自己");
        }
    }

    private Task h(Task task) throws Exception {
        if (task == null) {
            return null;
        }
        return (Task) new Gson().j(task.toJson().toString(), Task.class);
    }

    public static void i(String str, String str2, String str3) throws l.a.a.c.b {
        l.a.a.a aVar;
        l.a.a.f.s sVar = new l.a.a.f.s();
        if (str3 == null) {
            aVar = new l.a.a.a(str2);
            sVar.v(c);
        } else {
            l.a.a.a aVar2 = new l.a.a.a(str2, str3.toCharArray());
            sVar.v(c);
            sVar.y(true);
            sVar.z(l.a.a.f.t.e.AES);
            aVar = aVar2;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            aVar.d(file, sVar);
        } else {
            aVar.a(file, sVar);
        }
        System.out.println("加密 ZIP 文件已创建: " + str2);
    }

    public static void j(String str, String str2, String str3) throws l.a.a.c.b, IllegalArgumentException {
        l.a.a.a aVar;
        l.a.a.f.s sVar = new l.a.a.f.s();
        if (str3 == null) {
            aVar = new l.a.a.a(str2);
            aVar.w(b);
            sVar.v(c);
        } else {
            l.a.a.a aVar2 = new l.a.a.a(str2, str3.toCharArray());
            aVar2.w(b);
            sVar.v(c);
            sVar.y(true);
            sVar.z(l.a.a.f.t.e.AES);
            aVar = aVar2;
        }
        for (File file : new File(str).listFiles()) {
            if (file.isFile()) {
                aVar.a(file, sVar);
            } else if (file.isDirectory()) {
                aVar.d(file, sVar);
            }
        }
        System.out.println("加密 ZIP 文件已创建: " + str2);
    }

    public static void k(List<File> list, String str, String str2) throws l.a.a.c.b, IllegalArgumentException {
        l.a.a.a aVar = str2 == null ? new l.a.a.a(str) : new l.a.a.a(str, str2.toCharArray());
        aVar.w(b);
        l.a.a.f.s sVar = new l.a.a.f.s();
        sVar.v(c);
        if (str2 != null) {
            sVar.y(true);
            sVar.z(l.a.a.f.t.e.AES);
        }
        for (File file : list) {
            if (file.isFile()) {
                aVar.a(file, sVar);
            } else if (file.isDirectory()) {
                aVar.d(file, sVar);
            }
            file.delete();
        }
        System.out.println("加密 ZIP 文件已创建: " + str);
    }

    private final File l(TaskSimple taskSimple, String str) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        ArrayList arrayList = new ArrayList();
        String str2 = da.z() + "/aiTouch/" + taskSimple.getName();
        File file2 = new File(str2);
        com.frame.r0.d(file2);
        file2.mkdirs();
        for (TaskSimple taskSimple2 : taskSimple.getChildren()) {
            Task task = (Task) com.frame.k0.l("task:" + taskSimple2.getId(), Task.class);
            if (task == null) {
                return null;
            }
            if (task.getCreateUserId() == null) {
                task.setCreateUserId(AccountTool.d().g());
            }
            task.setGroup(taskSimple2.getGroup());
            arrayList.add(r(task, str2 + "/" + taskSimple2.getName() + ".ajs"));
        }
        j(str2, file.getAbsolutePath(), v());
        com.frame.r0.d(file2);
        return file;
    }

    public static String w() {
        return com.frame.z0.d("333DD55xx^^^@").substring(1);
    }

    public static String x() {
        return com.frame.z0.d("333DD55xx^^^@").substring(28);
    }

    public static long y(String str, Long l2) throws NumberFormatException {
        String strTrim = str == null ? "" : str.trim();
        if (!strTrim.matches("[0-9]+")) {
            throw new IllegalArgumentException("请输入正确的用户ID（正整数）");
        }
        try {
            long j2 = Long.parseLong(strTrim);
            g(j2, l2);
            return j2;
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("请输入正确的用户ID（正整数）");
        }
    }

    public void d(String str) throws Exception {
        String strX = da.x();
        if (TextUtils.isEmpty(strX)) {
            return;
        }
        for (String str2 : strX.split(",")) {
            if (str != null && str.contains(str2)) {
                throw new Exception(com.frame.a1.b().e("ignoreAlert", "未知错误"));
            }
        }
    }

    public String m(String str) throws Exception {
        List<TaskSimple> listD = da.B().D(null, 0);
        String str2 = da.z() + "/aiTouch/backup_temp/";
        File file = new File(str2);
        com.frame.r0.d(file);
        file.mkdirs();
        try {
            for (TaskSimple taskSimple : listD) {
                if ("group".equals(taskSimple.getPn())) {
                    l(taskSimple, str2 + "分组_" + taskSimple.getName() + ".ajs");
                } else {
                    r(da.B().L(taskSimple.getId()), str2 + "任务-" + taskSimple.getName() + ".ajs");
                }
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            i(str2, str, null);
            return str;
        } finally {
            com.frame.r0.d(file);
        }
    }

    public File n(Task task, String str, long j2, boolean z, boolean z2, String str2, Long l2, Long l3) throws Exception {
        f(task);
        Task taskH = h(task);
        c(taskH, AccountTool.d().g(), j2, z, z2, str2, l2, l3);
        return str == null ? q(taskH) : r(taskH, str);
    }

    public File o(long j2, boolean z, boolean z2, String str, Long l2, Long l3, Long l4) throws Exception {
        return p(j2, z, z2, str, l2, l3, l4, this.a);
    }

    public File p(long j2, boolean z, boolean z2, String str, Long l2, Long l3, Long l4, boolean z3) throws Exception {
        Task task = (Task) com.frame.k0.l("task:" + j2, Task.class);
        if (task == null) {
            return null;
        }
        b(task, z, z2, str, l2, l3, l4);
        z(z3);
        return q(task);
    }

    public File q(Task task) throws Exception {
        String str = da.z() + "/aiTouch//任务-" + task.getName();
        File fileR = r(task, str + ".ajs");
        if (fileR == null) {
            return null;
        }
        File file = new File(str + ".zip");
        if (file.exists()) {
            file.delete();
        }
        try {
            i(fileR.getAbsolutePath(), file.getAbsolutePath(), null);
            return file;
        } finally {
            fileR.delete();
        }
    }

    public File r(Task task, String str) throws Exception {
        Task taskH = h(task);
        if (taskH == null) {
            return null;
        }
        if (taskH.getCreateUserId() == null) {
            taskH.setCreateUserId(AccountTool.d().g());
        }
        return t(taskH, str);
    }

    public File s(Task task, String str, boolean z, boolean z2, String str2, Long l2, Long l3, Long l4) throws Exception {
        Task taskH = h(task);
        if (taskH == null) {
            return null;
        }
        b(taskH, z, z2, str2, l2, l3, l4);
        return t(taskH, str);
    }

    public File t(Task task, String str) throws Exception {
        String strX = da.x();
        if (!TextUtils.isEmpty(strX)) {
            for (String str2 : strX.split(",")) {
                if (task != null && !TextUtils.isEmpty(task.getPn()) && task.getPn().contains(str2)) {
                    throw new Exception(com.frame.a1.b().e("ignoreAlert", "未知错误"));
                }
            }
        }
        File fileU = u(task);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        j(fileU.getAbsolutePath(), file.getAbsolutePath(), v());
        com.frame.r0.d(fileU);
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File u(Task task) throws Exception {
        int i2;
        int i3;
        String str;
        String str2;
        int i4;
        com.frame.y0.g("导出备份脚本：" + task.getName());
        u7 u7Var = new u7(this);
        File file = new File(da.z() + "/aiTouch/" + task.getId());
        if (!file.exists()) {
            file.mkdirs();
        }
        Gson gson = new Gson();
        new File(file.getAbsoluteFile() + "/img").mkdirs();
        List<AlarmTask> listJ = i7.p().j(task.getId());
        char c2 = 0;
        if (listJ != null && !listJ.isEmpty()) {
            com.frame.r0.z(new File(file.getAbsolutePath() + "/alarm.txt").getAbsolutePath(), com.frame.n1.h(gson.s(listJ), x()), false);
        }
        FloatButtonConfig floatButtonConfigF = w7.g().f(task.getId());
        if (floatButtonConfigF != null) {
            com.frame.r0.z(new File(file.getAbsolutePath() + "/floatButton.txt").getAbsolutePath(), com.frame.n1.h(gson.s(floatButtonConfigF), x()), false);
        }
        List<Node> listE = k8.d().e(task.getId());
        if (listE != null && !listE.isEmpty()) {
            com.frame.r0.z(new File(file.getAbsolutePath() + "/pageMonitor.txt").getAbsolutePath(), com.frame.n1.h(gson.s(listE), x()), false);
        }
        ArrayList<ImageBox> arrayList = new ArrayList<>();
        for (Node node : task.getNodeMap().values()) {
            int i5 = 3;
            if (node.getCondition() != null && !TextUtils.isEmpty(node.getCondition().arg1)) {
                Gson gson2 = new Gson();
                String str3 = node.getCondition().arg1;
                Type[] typeArr = new Type[1];
                typeArr[c2] = Node.class;
                List<Node> list = (List) gson2.k(str3, com.google.gson.k0.a.c(List.class, typeArr).e());
                if (list != null) {
                    for (Node node2 : list) {
                        int i6 = node2.type;
                        if (i6 == i5 || i6 == 22) {
                            char c3 = 19;
                            i4 = i5;
                            u7Var.b(task, arrayList, node2, file, node2.url);
                            i5 = i4;
                        } else {
                            if (node.type == 19) {
                                d(node.url);
                            }
                            i4 = i5;
                            i5 = i4;
                        }
                    }
                }
            }
            int i7 = i5;
            int i8 = node.type;
            if (i8 == 10) {
                if ("从文件中获取文字输入".equals(node.text) && (str2 = node.arg2) != null) {
                    u7Var.a(task, node, file, str2);
                }
            } else if (i8 == 24) {
                int i9 = node.what;
                if (i9 == i7) {
                    try {
                        u7Var.a(task, node, file, node.arg2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i9 == 1 && "2".equals(node.arg1) && (str = node.arg2) != null) {
                    u7Var.a(task, node, file, str);
                }
            } else if (i8 == 42 && node.what == 0) {
                u7Var.b(task, arrayList, node, file, node.url);
            } else if (i8 != i7) {
                int i10 = 22;
                if (i8 == 22) {
                    u7Var.b(task, arrayList, node, file, node.url);
                } else if (i8 == 23 || i8 == 34) {
                    int i11 = 19;
                    List<Node> list2 = (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
                    if (list2 != null) {
                        for (Node node3 : list2) {
                            int i12 = node3.type;
                            if (i12 == i7 || i12 == i10) {
                                i2 = i11;
                                i3 = i10;
                                u7Var.b(task, arrayList, node3, file, node3.url);
                            } else {
                                if (node.type == i11) {
                                    d(node.url);
                                }
                                i2 = i11;
                                i3 = i10;
                            }
                            i11 = i2;
                            i10 = i3;
                        }
                    }
                } else if (i8 == 19) {
                    d(node.url);
                }
            }
            c2 = 0;
        }
        String strH = com.frame.n1.h(task.toJson().toString(), x());
        File file2 = new File(file.getAbsolutePath() + "/data.txt");
        file2.createNewFile();
        com.frame.r0.z(file2.getAbsolutePath(), strH, false);
        if (!arrayList.isEmpty()) {
            com.frame.r0.z(new File(file.getAbsolutePath() + "/imgBox.txt").getAbsolutePath(), com.frame.n1.h(gson.s(arrayList), x()), false);
        }
        return file;
    }

    public String v() {
        return com.frame.z0.d("FF@ee00x#92043").substring(1);
    }

    public v7 z(boolean z) {
        this.a = z;
        return this;
    }
}
