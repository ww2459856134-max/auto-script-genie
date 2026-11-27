package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.m;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;

/* loaded from: classes.dex */
public class g0 extends m implements SubMenu {
    private m B;
    private p C;

    public g0(Context context, m mVar, p pVar) {
        super(context);
        this.B = mVar;
        this.C = pVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public m D() {
        return this.B.D();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean F() {
        return this.B.F();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean G() {
        return this.B.G();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean H() {
        return this.B.H();
    }

    @Override // androidx.appcompat.view.menu.m
    public void R(m.a aVar) {
        this.B.R(aVar);
    }

    public Menu e0() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(p pVar) {
        return this.B.f(pVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.m
    boolean h(m mVar, MenuItem menuItem) {
        return super.h(mVar, menuItem) || this.B.h(mVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(p pVar) {
        return this.B.k(pVar);
    }

    @Override // androidx.appcompat.view.menu.m, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.V(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.Y(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.Z(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.m, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.m
    public String t() {
        p pVar = this.C;
        int itemId = pVar != null ? pVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ParameterizedMessage.ERROR_MSG_SEPARATOR + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        super.U(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        super.X(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.C.setIcon(i2);
        return this;
    }
}
