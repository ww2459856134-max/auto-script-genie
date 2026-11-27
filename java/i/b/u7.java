package i.b;

import android.net.Uri;
import android.text.TextUtils;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class u7 {
    final /* synthetic */ v7 a;

    public u7(v7 v7Var) {
        this.a = v7Var;
    }

    public void a(Task task, Node node, File file, String str) throws IOException {
        com.frame.y0.g(task.getName() + "-备份节点：" + node.getStepAndName());
        if (this.a.a) {
            if (str.contains("content://")) {
                Uri uri = Uri.parse(str);
                String strT = com.frame.r0.t(com.frame.v0.g(), uri);
                if (TextUtils.isEmpty(strT)) {
                    strT = "file_" + System.currentTimeMillis();
                }
                com.frame.r0.A(uri, new File(file.getAbsolutePath() + "/img", strT));
                node.arg2 = da.z() + "/img/" + strT;
                return;
            }
            File file2 = new File(str);
            File file3 = new File(file.getAbsolutePath() + "/files/", file2.getAbsolutePath());
            file3.getParentFile().mkdirs();
            com.frame.r0.a(file2, file3);
            try {
                if (str.contains(com.frame.v0.g().getPackageName())) {
                    File file4 = new File(da.z() + "/img", file2.getName());
                    File file5 = new File(str);
                    File file6 = new File(file4.getAbsolutePath(), file5.getName());
                    file6.getParentFile().mkdirs();
                    com.frame.r0.a(file5, file6);
                    node.arg2 = file4.getAbsolutePath();
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    public void b(Task task, ArrayList<ImageBox> arrayList, Node node, File file, String str) throws Exception {
        com.frame.y0.g(task.getName() + "-备份节点：" + node.getStepAndName());
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsoluteFile());
        sb.append("/img");
        String string = sb.toString();
        if (!str.startsWith("1")) {
            File file2 = new File(str);
            File file3 = new File(string + "/" + file2.getName());
            if (!file2.exists()) {
                if (TextUtils.isEmpty(node.arg1)) {
                    throw new Exception(task.getName() + ":未找到图片：" + node.getStepAndName());
                }
                return;
            }
            if (!file2.getAbsolutePath().contains(com.frame.v0.g().getPackageName())) {
                node.url = da.z() + "/img/" + file2.getName();
            }
            com.frame.r0.a(file2, file3);
            return;
        }
        ImageBox imageBoxA = b8.c().a(Long.parseLong(str));
        if (imageBoxA == null) {
            da.B().w1(node.getStepAndName() + ":节点的图集未找到，检查是否被删除。");
        }
        ImageBox imageBox = new ImageBox();
        imageBox.urls = imageBoxA.urls;
        imageBox.id = imageBoxA.id;
        imageBox.name = imageBoxA.name;
        arrayList.add(imageBox);
        List<String> list = imageBox.urls;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : list) {
            File file4 = new File(str2);
            File file5 = new File(string + "/" + file4.getName());
            if (!file4.exists()) {
                throw new Exception(task.getName() + ":未找到图片：" + node.getStepAndName());
            }
            if (file4.getAbsolutePath().contains(com.frame.v0.g().getPackageName())) {
                arrayList2.add(str2);
            } else {
                arrayList2.add(da.z() + "/img/" + file4.getName());
            }
            com.frame.r0.a(file4, file5);
        }
        imageBox.urls = arrayList2;
    }
}
