package i.b;

import android.content.SharedPreferences;
import com.yl.model.Task;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class s8 {
    public static boolean a(Task task) {
        SharedPreferences sharedPreferencesD = d();
        return (task == null || sharedPreferencesD == null || !sharedPreferencesD.getBoolean(Long.toString(task.getId()), false)) ? false : true;
    }

    public static void b(Task task, Task task2) {
        f(task2, a(task));
    }

    public static void c(long j2) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().remove(Long.toString(j2)).apply();
        }
    }

    private static SharedPreferences d() {
        com.frame.v0 v0VarG = com.frame.v0.g();
        if (v0VarG == null) {
            return null;
        }
        return v0VarG.getSharedPreferences("original_zip_import_access", 0);
    }

    static boolean e(d8 d8Var, String str, boolean z) {
        return d8Var == d8.DIRECT_SCRIPT && (z || (str != null && str.toLowerCase(Locale.ROOT).endsWith(".zip")));
    }

    static void f(Task task, boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
        if (z) {
            editorEdit.putBoolean(Long.toString(task.getId()), true);
        } else {
            editorEdit.remove(Long.toString(task.getId()));
        }
        editorEdit.apply();
    }

    static void g(Task task) {
        task.setLimitUserId(null);
        task.setLimitTime(null);
        task.setPwd(null);
        task.setActCode(false);
        task.setCanNotShare(false);
        task.setCanBackup(true);
    }
}
