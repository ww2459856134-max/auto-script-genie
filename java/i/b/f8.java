package i.b;

import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Toast;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.google.gson.Gson;
import com.user.AccountTool;
import com.yl.model.AlarmTask;
import com.yl.model.FloatButtonConfig;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.ui.v;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class f8 {
    private static final Charset b = StandardCharsets.UTF_8;
    private Long a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean B(Task task, final File file, final e8 e8Var, final Runnable runnable, Dialog dialog, final String str) {
        if (str.equals(task.getPwd())) {
            com.frame.l1.g(new Runnable() { // from class: i.b.w1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.z(file, str, e8Var, runnable);
                }
            });
            return false;
        }
        com.frame.l1.e(new Runnable() { // from class: i.b.z1
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(com.frame.v0.g(), "提取码错误！", 0).show();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(final Task task, final File file, final e8 e8Var, final Runnable runnable) {
        try {
            v.a aVar = new v.a(com.frame.v0.g().d());
            aVar.n("温馨提示");
            aVar.f("请输入提取码");
            aVar.g(new v.b() { // from class: i.b.v1
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.B(task, file, e8Var, runnable, dialog, str);
                }
            });
            aVar.d().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private boolean F(final File file, File file2, String str, final e8 e8Var, final Runnable runnable) throws Exception {
        if (file2.isDirectory()) {
            for (File file3 : file2.listFiles()) {
                if (!F(file, file3, str, e8Var, runnable)) {
                    return false;
                }
            }
            return true;
        }
        if (!o(file2.getName())) {
            return true;
        }
        final Task taskM = m(file2.getAbsolutePath(), da.z());
        if (taskM == null) {
            throw new Exception("压缩包中的脚本格式无效：" + file2.getName());
        }
        if (taskM.getCreateUserId() != null && !AccountTool.d().k(taskM.getCreateUserId()) && !TextUtils.isEmpty(taskM.getPwd()) && !taskM.getPwd().equals(str)) {
            com.frame.l1.e(new Runnable() { // from class: i.b.y1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.D(taskM, file, e8Var, runnable);
                }
            });
            return false;
        }
        if (e8Var != null && !e8Var.a(taskM)) {
            return false;
        }
        I(taskM);
        file2.delete();
        return true;
    }

    private String G(String str) {
        return H(str, true);
    }

    private String H(String str, boolean z) {
        try {
            String string = da.z().toString();
            Matcher matcher = Pattern.compile("/storage/emulated/.{0,59}/files/Documents").matcher(str.replaceAll("\\\\/", "/"));
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strGroup = matcher.group();
                if (string.equals(strGroup)) {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strGroup));
                } else {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(string));
                }
            }
            matcher.appendTail(stringBuffer);
            String string2 = stringBuffer.toString();
            if (z) {
                string2 = string2.replaceAll("/storage/emulated/", string + "/files/storage/emulated/");
            }
            if (l8.a(string)) {
                return l8.b(string2, string);
            }
            int iIndexOf = string2.indexOf("/data/user/0/");
            int iIndexOf2 = string2.indexOf("/img/");
            return (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 - iIndexOf >= 60) ? string2 : string2.replaceAll(string2.substring(iIndexOf + 13, iIndexOf2), com.frame.v0.g().getPackageName());
        } catch (Exception e) {
            com.frame.k0.r(e);
            return str;
        }
    }

    private void I(Task task) throws IOException {
        J(task, false);
    }

    private void J(Task task, boolean z) throws IOException {
        a(task, this.a);
        da.B().R1(task);
        s8.f(task, z);
        File file = new File(da.z(), "/img/");
        File file2 = new File(file, "/files/");
        if (file2.exists()) {
            com.frame.r0.b(file2.getPath(), "/");
            com.frame.r0.d(file2);
        }
        Gson gson = new Gson();
        try {
            File file3 = new File(file.getParent() + "/alarm.txt");
            if (file3.exists()) {
                String strV = com.frame.r0.v(file3.getAbsolutePath());
                try {
                    strV = f(strV);
                } catch (Exception e) {
                    com.frame.y0.l(e);
                }
                List<AlarmTask> list = (List) gson.k(strV, com.google.gson.k0.a.c(List.class, AlarmTask.class).e());
                List<AlarmTask> listK = i7.p().k();
                for (AlarmTask alarmTask : list) {
                    if (!listK.contains(alarmTask)) {
                        listK.add(alarmTask);
                    }
                }
                i7.p().D();
                i7.p().d();
                file3.delete();
            }
        } catch (Exception e2) {
            com.frame.y0.l(e2);
        }
        try {
            File file4 = new File(file.getParent() + "/floatButton.txt");
            if (file4.exists()) {
                String strV2 = com.frame.r0.v(file4.getAbsolutePath());
                try {
                    strV2 = f(strV2);
                } catch (Exception e3) {
                    com.frame.y0.l(e3);
                }
                final FloatButtonConfig floatButtonConfig = (FloatButtonConfig) gson.j(strV2, FloatButtonConfig.class);
                com.frame.l1.e(new Runnable() { // from class: i.b.s1
                    @Override // java.lang.Runnable
                    public final void run() {
                        w7.g().a(floatButtonConfig);
                    }
                });
                file4.delete();
            }
        } catch (Exception e4) {
            com.frame.y0.l(e4);
        }
        try {
            File file5 = new File(file.getParent() + "/imgBox.txt");
            if (file5.exists()) {
                List<ImageBox> list2 = (List) gson.k(G(f(com.frame.r0.v(file5.getAbsolutePath()))), com.google.gson.k0.a.c(List.class, ImageBox.class).e());
                List<ImageBox> listB = b8.c().b();
                boolean z2 = false;
                for (ImageBox imageBox : list2) {
                    if (listB.contains(imageBox)) {
                        listB.remove(imageBox);
                        listB.add(imageBox);
                    } else {
                        listB.add(imageBox);
                    }
                    z2 = true;
                }
                if (z2) {
                    b8.c().d(listB);
                }
                file5.delete();
            }
        } catch (Exception e5) {
            com.frame.y0.l(e5);
        }
        try {
            File file6 = new File(file.getParent() + "/pageMonitor.txt");
            if (file6.exists()) {
                String strV3 = com.frame.r0.v(file6.getAbsolutePath());
                try {
                    strV3 = f(strV3);
                } catch (Exception e6) {
                    com.frame.y0.l(e6);
                }
                k8.d().f().addAll((List) gson.k(strV3, com.google.gson.k0.a.c(List.class, Node.class).e()));
                k8.d().i();
            }
        } catch (Exception e7) {
            try {
                com.frame.y0.l(e7);
            } catch (Exception e8) {
                com.frame.y0.l(e8);
            }
        }
    }

    static void a(Task task, Long l2) {
        if (l2 != null) {
            task.setCloudScriptId(l2);
        }
    }

    private String f(String str) throws Exception {
        return com.frame.n1.e(str, v7.x(), "4jso$dkm#kkd*lsdk@", v7.w());
    }

    public static void h(String str, String str2, String str3) throws l.a.a.c.b, IllegalArgumentException {
        try {
            l.a.a.a aVar = new l.a.a.a(str);
            aVar.w(b);
            if (aVar.s()) {
                aVar.x(str3.toCharArray());
            }
            aVar.n(str2);
            System.out.println("ZIP 文件已解压到: " + str2);
        } catch (l.a.a.c.b e) {
            System.err.println("解压 ZIP 文件失败");
            throw e;
        }
    }

    static Long i(d8 d8Var, Long l2) {
        if (d8Var == d8.DIRECT_SCRIPT) {
            return l2;
        }
        return null;
    }

    private boolean k(File file) {
        File file2 = new File(file, "files");
        return file2.exists() && file2.isDirectory();
    }

    private boolean n(File file) throws Exception {
        return g(file.getAbsolutePath()) == d8.LOCAL_BACKUP;
    }

    private static boolean o(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.endsWith(".ajs") || lowerCase.endsWith(".zip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean r(Task task, boolean z, Runnable runnable, Dialog dialog, String str) throws IOException {
        if (!str.equals(task.getPwd())) {
            com.frame.l1.e(new Runnable() { // from class: i.b.a2
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(com.frame.v0.g(), "提取码错误！", 0).show();
                }
            });
            return true;
        }
        J(task, z);
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final Task task, final boolean z, final Runnable runnable) {
        try {
            v.a aVar = new v.a(com.frame.v0.g().d());
            aVar.n("温馨提示");
            aVar.f("请输入提取码");
            aVar.g(new v.b() { // from class: i.b.t1
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.r(task, z, runnable, dialog, str);
                }
            });
            aVar.d().show();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Task task, boolean z, Runnable runnable) throws IOException {
        J(task, z);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(File file, String str, e8 e8Var, Runnable runnable) {
        try {
            if (F(file, file, str, e8Var, runnable)) {
                com.frame.r0.d(file);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    public boolean b(String str, Long l2, Runnable runnable) throws Exception {
        return c(str, l2, new File(str).getName(), l2 != null, runnable);
    }

    public boolean c(String str, Long l2, String str2, boolean z, final Runnable runnable) throws Exception {
        d8 d8VarG = g(str);
        final boolean zE = s8.e(d8VarG, str2, z);
        if (!zE) {
            if (AccountTool.d().h() != null) {
                new l9().s();
            } else {
                new l9().o();
            }
        }
        a8 a8Var = new a8();
        this.a = i(d8VarG, l2);
        if (d8VarG == d8.LOCAL_BACKUP) {
            return l(new File(str), runnable);
        }
        if (d8VarG == d8.SCRIPT_CONTAINER) {
            return e(str, a8Var, runnable);
        }
        if (d8VarG == d8.INVALID) {
            throw new Exception("文件不是有效的脚本或本地备份");
        }
        final Task taskM = m(str, da.z());
        if (taskM == null) {
            throw new Exception("文件不是有效的脚本或本地备份");
        }
        if (zE) {
            s8.g(taskM);
        }
        if (!zE && !a8Var.a(taskM)) {
            return false;
        }
        if (taskM.getCreateUserId() != null && !AccountTool.d().k(taskM.getCreateUserId()) && !TextUtils.isEmpty(taskM.getPwd())) {
            com.frame.l1.e(new Runnable() { // from class: i.b.x1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t(taskM, zE, runnable);
                }
            });
            return false;
        }
        int iMin = Math.min(com.frame.k0.c().e(), com.frame.k0.c().d());
        int iMax = Math.max(com.frame.k0.c().e(), com.frame.k0.c().d());
        float fMin = Math.min(taskM.getScreenWith(), taskM.getScreenHeight());
        float fMax = Math.max(taskM.getScreenWith(), taskM.getScreenHeight());
        if (iMin != fMin || iMax != fMax) {
            com.frame.l1.e(new Runnable() { // from class: i.b.u1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.c.v(taskM, zE, runnable);
                }
            });
            return true;
        }
        J(taskM, zE);
        if (runnable != null) {
            runnable.run();
        }
        return true;
    }

    public boolean d(String str, Runnable runnable) throws Exception {
        return b(str, null, runnable);
    }

    public boolean e(String str, e8 e8Var, Runnable runnable) throws Exception {
        File file = new File(new File(str).getParent(), "tempGroup");
        com.frame.r0.d(file);
        file.mkdirs();
        try {
            h(str, file.getAbsolutePath(), j());
        } catch (Exception unused) {
            h(str, file.getAbsolutePath(), "3331234");
        }
        if (!F(file, file, null, e8Var, runnable)) {
            return false;
        }
        com.frame.r0.d(file);
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    d8 g(String str) throws Exception {
        l.a.a.a aVar = new l.a.a.a(str);
        aVar.w(b);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (l.a.a.f.i iVar : aVar.p()) {
            String lowerCase = iVar.j().replace('\\', '/').toLowerCase(Locale.ROOT);
            if (h8.a(lowerCase)) {
                z = true;
            } else if ("data.txt".equals(lowerCase)) {
                z2 = true;
            } else if (!iVar.r() && o(lowerCase)) {
                z3 = true;
            }
        }
        return z ? d8.LOCAL_BACKUP : z2 ? d8.DIRECT_SCRIPT : z3 ? d8.SCRIPT_CONTAINER : d8.INVALID;
    }

    public String j() {
        return com.frame.z0.d("FF@ee00x#92043").substring(1);
    }

    public boolean l(File file, Runnable runnable) throws Exception {
        if (!file.getAbsolutePath().endsWith(".zip") && !file.getAbsolutePath().endsWith(".ajs")) {
            throw new Exception("请选择正确的备份文件");
        }
        if (!n(file)) {
            return d(file.getAbsolutePath(), runnable);
        }
        File file2 = new File(da.z() + "/aiTouch/backup_temp/");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            try {
                try {
                    h(file.getAbsolutePath(), file2.getParentFile().getAbsolutePath(), j());
                } catch (Exception e) {
                    throw new Exception(file2.getName() + "：" + e.getMessage());
                }
            } catch (Exception unused) {
                h(file.getAbsolutePath(), file2.getParentFile().getAbsolutePath(), "3331234");
            }
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                throw new Exception("备份文件中没有可恢复的脚本");
            }
            for (File file3 : fileArrListFiles) {
                c(file3.getAbsolutePath(), null, null, false, null);
            }
            if (runnable != null) {
                runnable.run();
            }
            com.frame.r0.d(file2);
            return true;
        } finally {
            com.frame.r0.d(file2);
        }
    }

    public Task m(final String str, File file) throws Exception {
        try {
            try {
                h(str, file.getAbsolutePath(), j());
            } catch (Exception unused) {
                h(str, file.getAbsolutePath(), "3331234");
            }
        } catch (Exception e) {
            com.frame.l1.e(new Runnable() { // from class: i.b.b2
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(com.frame.v0.g(), str + ParameterizedMessage.ERROR_MSG_SEPARATOR + e.getMessage(), 1).show();
                }
            });
            com.frame.y0.j(str + ParameterizedMessage.ERROR_MSG_SEPARATOR + e.getMessage());
        }
        File file2 = new File(file + "/data.txt");
        if (!file2.exists()) {
            return null;
        }
        Task task = (Task) new Gson().j(H(f(com.frame.r0.v(file2.getAbsolutePath())), k(file)), Task.class);
        file2.delete();
        return task;
    }
}
