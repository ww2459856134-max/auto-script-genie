package h.a.o;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class i implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] c = {MenuItem.class};
    private Object a;
    private Method b;

    public i(Object obj, String str) {
        this.a = obj;
        Class<?> cls = obj.getClass();
        try {
            this.b = cls.getMethod(str, c);
        } catch (Exception e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.b.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
            }
            this.b.invoke(this.a, menuItem);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
