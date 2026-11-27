package h.a.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.menu.b0;
import androidx.appcompat.view.menu.v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g implements b {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<h> c = new ArrayList<>();
    final h.d.i<Menu, Menu> d = new h.d.i<>();

    public g(Context context, ActionMode.Callback callback) {
        this.b = context;
        this.a = callback;
    }

    private Menu f(Menu menu) {
        Menu menu2 = this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        b0 b0Var = new b0(this.b, (h.e.e.a.a) menu);
        this.d.put(menu, b0Var);
        return b0Var;
    }

    @Override // h.a.o.b
    public boolean a(c cVar, Menu menu) {
        return this.a.onCreateActionMode(e(cVar), f(menu));
    }

    @Override // h.a.o.b
    public boolean b(c cVar, MenuItem menuItem) {
        return this.a.onActionItemClicked(e(cVar), new v(this.b, (h.e.e.a.b) menuItem));
    }

    @Override // h.a.o.b
    public boolean c(c cVar, Menu menu) {
        return this.a.onPrepareActionMode(e(cVar), f(menu));
    }

    @Override // h.a.o.b
    public void d(c cVar) {
        this.a.onDestroyActionMode(e(cVar));
    }

    public ActionMode e(c cVar) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.c.get(i2);
            if (hVar != null && hVar.b == cVar) {
                return hVar;
            }
        }
        h hVar2 = new h(this.b, cVar);
        this.c.add(hVar2);
        return hVar2;
    }
}
