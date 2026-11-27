package h.e.j.q1;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class c {
    public static final c d = new c(1, null);
    public static final c e = new c(2, null);
    public static final c f;
    public static final c g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f1316h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f1317i;
    final Object a;
    private final Class<? extends h> b;
    protected final p c;

    static {
        new c(4, null);
        new c(8, null);
        new c(16, null);
        new c(32, null);
        new c(64, null);
        new c(128, null);
        new c(256, null, i.class);
        new c(512, null, i.class);
        new c(1024, null, j.class);
        new c(2048, null, j.class);
        f = new c(XMLEvent.CHANGE_PREFIX_MAPPING, null);
        g = new c(XMLEvent.ENTITY_REFERENCE, null);
        new c(16384, null);
        new c(32768, null);
        new c(WXMediaMessage.THUMB_LENGTH_LIMIT, null);
        new c(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, null, n.class);
        new c(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT, null);
        new c(524288, null);
        new c(1048576, null);
        new c(2097152, null, o.class);
        int i2 = Build.VERSION.SDK_INT;
        new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
        new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, l.class);
        f1316h = new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
        new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
        f1317i = new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
        new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
        new c(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new c(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new c(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new c(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new c(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
        new c(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, m.class);
        new c(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, k.class);
        new c(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new c(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new c(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new c(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
    }

    public c(int i2, CharSequence charSequence) {
        this(null, i2, charSequence, null, null);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
        }
        return 0;
    }

    public CharSequence b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getLabel();
        }
        return null;
    }

    public boolean c(View view, Bundle bundle) {
        h hVarNewInstance;
        if (this.c == null) {
            return false;
        }
        h hVar = null;
        Class<? extends h> cls = this.b;
        if (cls != null) {
            try {
                hVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                hVarNewInstance.a(bundle);
                hVar = hVarNewInstance;
            } catch (Exception e3) {
                e = e3;
                hVar = hVarNewInstance;
                Class<? extends h> cls2 = this.b;
                Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                return this.c.a(view, hVar);
            }
        }
        return this.c.a(view, hVar);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Object obj2 = this.a;
        return obj2 == null ? cVar.a == null : obj2.equals(cVar.a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    c(Object obj) {
        this(obj, 0, null, null, null);
    }

    private c(int i2, CharSequence charSequence, Class<? extends h> cls) {
        this(null, i2, charSequence, null, cls);
    }

    c(Object obj, int i2, CharSequence charSequence, p pVar, Class<? extends h> cls) {
        this.c = pVar;
        if (Build.VERSION.SDK_INT >= 21 && obj == null) {
            this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
        } else {
            this.a = obj;
        }
        this.b = cls;
    }
}
