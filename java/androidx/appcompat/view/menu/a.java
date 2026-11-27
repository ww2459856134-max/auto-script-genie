package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class a implements h.e.e.a.b {
    private final int a;
    private final int b;
    private final int c;
    private CharSequence d;
    private CharSequence e;
    private Intent f;
    private char g;

    /* renamed from: i, reason: collision with root package name */
    private char f55i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f57k;

    /* renamed from: l, reason: collision with root package name */
    private Context f58l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f59m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f60n;

    /* renamed from: h, reason: collision with root package name */
    private int f54h = XMLEvent.CHANGE_PREFIX_MAPPING;

    /* renamed from: j, reason: collision with root package name */
    private int f56j = XMLEvent.CHANGE_PREFIX_MAPPING;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f61o = null;
    private PorterDuff.Mode p = null;
    private boolean q = false;
    private boolean r = false;
    private int s = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f58l = context;
        this.a = i3;
        this.b = i2;
        this.c = i5;
        this.d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f57k;
        if (drawable != null) {
            if (this.q || this.r) {
                Drawable drawableQ = androidx.core.graphics.drawable.a.q(drawable);
                this.f57k = drawableQ;
                Drawable drawableMutate = drawableQ.mutate();
                this.f57k = drawableMutate;
                if (this.q) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f61o);
                }
                if (this.r) {
                    androidx.core.graphics.drawable.a.o(this.f57k, this.p);
                }
            }
        }
    }

    @Override // h.e.e.a.b
    public h.e.j.e a() {
        return null;
    }

    @Override // h.e.e.a.b
    public h.e.e.a.b b(h.e.j.e eVar) {
        throw new UnsupportedOperationException();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    public h.e.e.a.b d(int i2) {
        throw new UnsupportedOperationException();
    }

    public h.e.e.a.b e(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    public h.e.e.a.b f(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f56j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f55i;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f59m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f57k;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f61o;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f54h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        return charSequence != null ? charSequence : this.d;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f60n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        d(i2);
        throw null;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f55i = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f57k = drawable;
        c();
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f61o = colorStateList;
        this.q = true;
        c();
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.g = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.g = c;
        this.f55i = Character.toLowerCase(c2);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        f(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.s = (this.s & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        e(view);
        throw null;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        this.f55i = Character.toLowerCase(c);
        this.f56j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public h.e.e.a.b setContentDescription(CharSequence charSequence) {
        this.f59m = charSequence;
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i2) {
        this.g = c;
        this.f54h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.d = this.f58l.getResources().getString(i2);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public h.e.e.a.b setTooltipText(CharSequence charSequence) {
        this.f60n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f57k = androidx.core.content.a.e(this.f58l, i2);
        c();
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i2, int i3) {
        this.g = c;
        this.f54h = KeyEvent.normalizeMetaState(i2);
        this.f55i = Character.toLowerCase(c2);
        this.f56j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}
