package com.bluetooth.cursor.x;

import android.content.Context;
import androidx.preference.t;
import com.google.gson.Gson;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class c {
    private Context a;
    private List<d> b;

    public c(Context context) {
        this.a = context;
        d();
    }

    static /* synthetic */ int c(d dVar, d dVar2) {
        return -Long.compare(dVar.b(), dVar2.b());
    }

    public void a(d dVar) {
        this.b.add(dVar);
        e();
    }

    public d b(int i2) {
        if (i2 < this.b.size()) {
            return this.b.get(i2);
        }
        return null;
    }

    public void d() {
        this.b = (List) new Gson().k(t.b(this.a).getString("devices", "[]"), new b(this).e());
    }

    public void e() {
        this.b.sort(new Comparator() { // from class: com.bluetooth.cursor.x.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.c((d) obj, (d) obj2);
            }
        });
        int i2 = 0;
        while (i2 < this.b.size()) {
            int i3 = i2 + 1;
            int i4 = i3;
            while (i4 < this.b.size()) {
                if (this.b.get(i2).a().equals(this.b.get(i4).a())) {
                    this.b.remove(i4);
                    i4--;
                }
                i4++;
            }
            i2 = i3;
        }
        t.b(this.a).edit().putString("devices", new Gson().s(this.b)).apply();
    }
}
