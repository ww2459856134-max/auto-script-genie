package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class w0 implements View.OnClickListener {
    private final View c;
    private final String d;
    private Method e;
    private Context f;

    public w0(View view, String str) {
        this.c = view;
        this.d = str;
    }

    private void a(Context context) {
        String str;
        Method method;
        while (context != null) {
            try {
                if (!context.isRestricted() && (method = context.getClass().getMethod(this.d, View.class)) != null) {
                    this.e = method;
                    this.f = context;
                    return;
                }
            } catch (NoSuchMethodException unused) {
            }
            context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
        }
        int id = this.c.getId();
        if (id == -1) {
            str = "";
        } else {
            str = " with id '" + this.c.getContext().getResources().getResourceEntryName(id) + "'";
        }
        throw new IllegalStateException("Could not find method " + this.d + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.c.getClass() + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.e == null) {
            a(this.c.getContext());
        }
        try {
            this.e.invoke(this.f, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
