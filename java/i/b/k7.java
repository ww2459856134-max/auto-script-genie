package i.b;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class k7 {
    private Set<String> a;

    private void f(Set<String> set) {
        this.a = new TreeSet(set);
        com.frame.v0.e().edit().putString("lastFile", new Gson().s(this.a)).apply();
    }

    public void a(String str) {
        Set<String> setC = c();
        setC.add(str);
        f(setC);
    }

    public void b() {
        this.a = new TreeSet();
        com.frame.v0.e().edit().remove("lastFile").apply();
    }

    public Set<String> c() {
        TreeSet treeSet = (TreeSet) com.frame.k0.n("lastFile", TreeSet.class, String.class);
        if (treeSet == null) {
            treeSet = new TreeSet();
        }
        this.a = treeSet;
        return treeSet;
    }

    public ArrayList<String> d() throws UnsupportedEncodingException {
        String strDecode;
        ArrayList<String> arrayList = new ArrayList<>();
        Set<String> setC = this.a;
        if (setC == null) {
            setC = c();
        }
        for (String str : setC) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("content://")) {
                    strDecode = com.frame.r0.t(com.frame.v0.g(), Uri.parse(str));
                } else {
                    try {
                        strDecode = URLDecoder.decode(str.substring(str.lastIndexOf("/") + 1), StandardCharsets.UTF_8.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (!TextUtils.isEmpty(strDecode)) {
                    arrayList.add(strDecode);
                }
            }
        }
        return arrayList;
    }

    public void e(String str) {
        Set<String> setC = c();
        setC.remove(str);
        f(setC);
    }
}
