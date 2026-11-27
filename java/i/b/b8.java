package i.b;

import com.google.gson.Gson;
import com.yl.model.ImageBox;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b8 {
    private static b8 b;
    private List<ImageBox> a;

    public static b8 c() {
        b8 b8Var = b;
        if (b8Var != null) {
            return b8Var;
        }
        b8 b8Var2 = new b8();
        b = b8Var2;
        return b8Var2;
    }

    public ImageBox a(long j2) {
        for (ImageBox imageBox : b()) {
            if (imageBox.id == j2) {
                return imageBox;
            }
        }
        return null;
    }

    public List<ImageBox> b() {
        String strE = com.frame.n0.e("imgBox");
        if (this.a == null) {
            List<ImageBox> list = (List) new Gson().k(strE, com.google.gson.k0.a.c(List.class, ImageBox.class).e());
            this.a = list;
            if (list == null) {
                this.a = new ArrayList();
            }
        }
        return this.a;
    }

    public void d(List<ImageBox> list) {
        this.a = list;
        com.frame.n0.k("imgBox", new Gson().s(list));
    }
}
