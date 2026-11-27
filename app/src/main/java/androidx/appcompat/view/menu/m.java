package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import h.e.j.t0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class m implements h.e.e.a.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private a e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f83m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f84n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f85o;
    View p;
    private p x;
    private boolean z;

    /* renamed from: l, reason: collision with root package name */
    private int f82l = 0;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<p> v = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<z>> w = new CopyOnWriteArrayList<>();
    private boolean y = false;
    private ArrayList<p> f = new ArrayList<>();
    private ArrayList<p> g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f78h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<p> f79i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<p> f80j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f81k = true;

    public interface a {
        boolean a(m mVar, MenuItem menuItem);

        void b(m mVar);
    }

    public interface b {
        boolean d(p pVar);
    }

    public m(Context context) {
        this.a = context;
        this.b = context.getResources();
        b0(true);
    }

    private static int B(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.f.size()) {
            return;
        }
        this.f.remove(i2);
        if (z) {
            K(true);
        }
    }

    private void W(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.p = view;
            this.f84n = null;
            this.f85o = null;
        } else {
            if (i2 > 0) {
                this.f84n = resourcesC.getText(i2);
            } else if (charSequence != null) {
                this.f84n = charSequence;
            }
            if (i3 > 0) {
                this.f85o = androidx.core.content.a.e(u(), i3);
            } else if (drawable != null) {
                this.f85o = drawable;
            }
            this.p = null;
        }
        K(false);
    }

    private void b0(boolean z) {
        this.d = z && this.b.getConfiguration().keyboard != 1 && t0.e(ViewConfiguration.get(this.a), this.a);
    }

    private p g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new p(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<z>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<z> next = it.next();
            z zVar = next.get();
            if (zVar == null) {
                this.w.remove(next);
            } else {
                zVar.d(z);
            }
        }
        c0();
    }

    private boolean j(g0 g0Var, z zVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean zK = zVar != null ? zVar.k(g0Var) : false;
        Iterator<WeakReference<z>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<z> next = it.next();
            z zVar2 = next.get();
            if (zVar2 == null) {
                this.w.remove(next);
            } else if (!zK) {
                zK = zVar2.k(g0Var);
            }
        }
        return zK;
    }

    private static int n(ArrayList<p> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.t;
    }

    Resources C() {
        return this.b;
    }

    public m D() {
        return this;
    }

    public ArrayList<p> E() {
        if (!this.f78h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.f.get(i2);
            if (pVar.isVisible()) {
                this.g.add(pVar);
            }
        }
        this.f78h = false;
        this.f81k = true;
        return this.g;
    }

    public boolean F() {
        return this.y;
    }

    boolean G() {
        return this.c;
    }

    public boolean H() {
        return this.d;
    }

    void I(p pVar) {
        this.f81k = true;
        K(true);
    }

    void J(p pVar) {
        this.f78h = true;
        K(true);
    }

    public void K(boolean z) {
        if (this.q) {
            this.r = true;
            if (z) {
                this.s = true;
                return;
            }
            return;
        }
        if (z) {
            this.f78h = true;
            this.f81k = true;
        }
        i(z);
    }

    public boolean L(MenuItem menuItem, int i2) {
        return M(menuItem, null, i2);
    }

    public boolean M(MenuItem menuItem, z zVar, int i2) {
        p pVar = (p) menuItem;
        if (pVar == null || !pVar.isEnabled()) {
            return false;
        }
        boolean zK = pVar.k();
        h.e.j.e eVarA = pVar.a();
        boolean z = eVarA != null && eVarA.a();
        if (pVar.j()) {
            zK |= pVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (pVar.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!pVar.hasSubMenu()) {
                pVar.x(new g0(u(), this, pVar));
            }
            g0 g0Var = (g0) pVar.getSubMenu();
            if (z) {
                eVarA.f(g0Var);
            }
            zK |= j(g0Var, zVar);
            if (!zK) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void O(z zVar) {
        Iterator<WeakReference<z>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<z> next = it.next();
            z zVar2 = next.get();
            if (zVar2 == null || zVar2 == zVar) {
                this.w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((g0) item.getSubMenu()).P(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((g0) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.e = aVar;
    }

    public m S(int i2) {
        this.f82l = i2;
        return this;
    }

    void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        d0();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.f.get(i2);
            if (pVar.getGroupId() == groupId && pVar.m() && pVar.isCheckable()) {
                pVar.s(pVar == menuItem);
            }
        }
        c0();
    }

    protected m U(int i2) {
        W(0, null, i2, null, null);
        return this;
    }

    protected m V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    protected m X(int i2) {
        W(i2, null, 0, null, null);
        return this;
    }

    protected m Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    protected m Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int iB = B(i4);
        p pVarG = g(i2, i3, i4, iB, charSequence, this.f82l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f83m;
        if (contextMenuInfo != null) {
            pVarG.v(contextMenuInfo);
        }
        ArrayList<p> arrayList = this.f;
        arrayList.add(n(arrayList, iB), pVarG);
        K(true);
        return pVarG;
    }

    public void a0(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(z zVar) {
        c(zVar, this.a);
    }

    public void c(z zVar, Context context) {
        this.w.add(new WeakReference<>(zVar));
        zVar.h(context, this);
        this.f81k = true;
    }

    public void c0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            K(this.s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        p pVar = this.x;
        if (pVar != null) {
            f(pVar);
        }
        this.f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f85o = null;
        this.f84n = null;
        this.p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    public final void e(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator<WeakReference<z>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<z> next = it.next();
            z zVar = next.get();
            if (zVar == null) {
                this.w.remove(next);
            } else {
                zVar.b(this, z);
            }
        }
        this.u = false;
    }

    public boolean f(p pVar) {
        boolean zF = false;
        if (!this.w.isEmpty() && this.x == pVar) {
            d0();
            Iterator<WeakReference<z>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<z> next = it.next();
                z zVar = next.get();
                if (zVar == null) {
                    this.w.remove(next);
                } else {
                    zF = zVar.f(this, pVar);
                    if (zF) {
                        break;
                    }
                }
            }
            c0();
            if (zF) {
                this.x = null;
            }
        }
        return zF;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = this.f.get(i3);
            if (pVar.getItemId() == i2) {
                return pVar;
            }
            if (pVar.hasSubMenu() && (menuItemFindItem = pVar.getSubMenu().findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f.get(i2);
    }

    boolean h(m mVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(mVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return p(i2, keyEvent) != null;
    }

    public boolean k(p pVar) {
        boolean zC = false;
        if (this.w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<z>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<z> next = it.next();
            z zVar = next.get();
            if (zVar == null) {
                this.w.remove(next);
            } else {
                zC = zVar.c(this, pVar);
                if (zC) {
                    break;
                }
            }
        }
        c0();
        if (zC) {
            this.x = pVar;
        }
        return zC;
    }

    public int l(int i2) {
        return m(i2, 0);
    }

    public int m(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int o(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    p p(int i2, KeyEvent keyEvent) {
        ArrayList<p> arrayList = this.v;
        arrayList.clear();
        q(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zG = G();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = arrayList.get(i3);
            char alphabeticShortcut = zG ? pVar.getAlphabeticShortcut() : pVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zG && alphabeticShortcut == '\b' && i2 == 67))) {
                return pVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return L(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        p pVarP = p(i2, keyEvent);
        boolean zL = pVarP != null ? L(pVarP, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return zL;
    }

    void q(List<p> list, int i2, KeyEvent keyEvent) {
        boolean zG = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f.size();
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = this.f.get(i3);
                if (pVar.hasSubMenu()) {
                    ((m) pVar.getSubMenu()).q(list, i2, keyEvent);
                }
                char alphabeticShortcut = zG ? pVar.getAlphabeticShortcut() : pVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zG ? pVar.getAlphabeticModifiers() : pVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zG && alphabeticShortcut == '\b' && i2 == 67)) && pVar.isEnabled()) {
                        list.add(pVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<p> arrayListE = E();
        if (this.f81k) {
            Iterator<WeakReference<z>> it = this.w.iterator();
            boolean zE = false;
            while (it.hasNext()) {
                WeakReference<z> next = it.next();
                z zVar = next.get();
                if (zVar == null) {
                    this.w.remove(next);
                } else {
                    zE |= zVar.e();
                }
            }
            if (zE) {
                this.f79i.clear();
                this.f80j.clear();
                int size = arrayListE.size();
                for (int i2 = 0; i2 < size; i2++) {
                    p pVar = arrayListE.get(i2);
                    if (pVar.l()) {
                        this.f79i.add(pVar);
                    } else {
                        this.f80j.add(pVar);
                    }
                }
            } else {
                this.f79i.clear();
                this.f80j.clear();
                this.f80j.addAll(E());
            }
            this.f81k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int iL = l(i2);
        if (iL >= 0) {
            int size = this.f.size() - iL;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f.get(iL).getGroupId() != i2) {
                    break;
                }
                N(iL, false);
                i3 = i4;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        N(o(i2), true);
    }

    public ArrayList<p> s() {
        r();
        return this.f79i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = this.f.get(i3);
            if (pVar.getGroupId() == i2) {
                pVar.t(z2);
                pVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = this.f.get(i3);
            if (pVar.getGroupId() == i2) {
                pVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = this.f.get(i3);
            if (pVar.getGroupId() == i2 && pVar.y(z)) {
                z2 = true;
            }
        }
        if (z2) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.a;
    }

    public p v() {
        return this.x;
    }

    public Drawable w() {
        return this.f85o;
    }

    public CharSequence x() {
        return this.f84n;
    }

    public View y() {
        return this.p;
    }

    public ArrayList<p> z() {
        r();
        return this.f80j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        p pVar = (p) a(i2, i3, i4, charSequence);
        g0 g0Var = new g0(this.a, this, pVar);
        pVar.x(g0Var);
        return g0Var;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.b.getString(i5));
    }
}
