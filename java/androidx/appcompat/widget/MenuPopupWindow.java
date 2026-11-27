package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MenuPopupWindow extends a1 implements b1 {
    private static Method j0;
    private b1 i0;

    public static class MenuDropDownListView extends p0 {
        final int H;
        final int I;
        private b1 J;
        private MenuItem K;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.H = 22;
                this.I = 21;
            } else {
                this.H = 21;
                this.I = 22;
            }
        }

        @Override // androidx.appcompat.widget.p0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.l lVar;
            int iPointToPosition;
            int i2;
            if (this.J != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    lVar = (androidx.appcompat.view.menu.l) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    lVar = (androidx.appcompat.view.menu.l) adapter;
                }
                androidx.appcompat.view.menu.p item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = iPointToPosition - headersCount) >= 0 && i2 < lVar.getCount()) {
                    item = lVar.getItem(i2);
                }
                MenuItem menuItem = this.K;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.m mVarB = lVar.b();
                    if (menuItem != null) {
                        this.J.h(mVarB, menuItem);
                    }
                    this.K = item;
                    if (item != null) {
                        this.J.b(mVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.H) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.I) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.l) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.l) adapter).b().e(false);
            return true;
        }

        public void setHoverListener(b1 b1Var) {
            this.J = b1Var;
        }

        @Override // androidx.appcompat.widget.p0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                j0 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void M(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.e0.setEnterTransition((Transition) obj);
        }
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.e0.setExitTransition((Transition) obj);
        }
    }

    public void O(b1 b1Var) {
        this.i0 = b1Var;
    }

    public void P(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.e0.setTouchModal(z);
            return;
        }
        Method method = j0;
        if (method != null) {
            try {
                method.invoke(this.e0, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.b1
    public void b(androidx.appcompat.view.menu.m mVar, MenuItem menuItem) {
        b1 b1Var = this.i0;
        if (b1Var != null) {
            b1Var.b(mVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.b1
    public void h(androidx.appcompat.view.menu.m mVar, MenuItem menuItem) {
        b1 b1Var = this.i0;
        if (b1Var != null) {
            b1Var.h(mVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.a1
    p0 r(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
