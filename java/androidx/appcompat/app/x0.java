package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.q1;
import com.auto.exceldeps.log4j.util.Chars;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class x0 {
    private static final Class<?>[] b = {Context.class, AttributeSet.class};
    private static final int[] c = {R.attr.onClick};
    private static final String[] d = {"android.widget.", "android.view.", "android.webkit."};
    private static final h.d.i<String, Constructor<? extends View>> e = new h.d.i<>();
    private final Object[] a = new Object[2];

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || h.e.j.s0.G(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new w0(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private View r(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String str3;
        h.d.i<String, Constructor<? extends View>> iVar = e;
        Constructor<? extends View> constructor = iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i2 = 0;
            while (true) {
                String[] strArr = d;
                if (i2 >= strArr.length) {
                    return null;
                }
                View viewR = r(context, str, strArr[i2]);
                if (viewR != null) {
                    return viewR;
                }
                i2++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.A3, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(h.a.j.B3, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(h.a.j.C3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof h.a.o.e) && ((h.a.o.e) context).c() == resourceId) ? context : new h.a.o.e(context, resourceId) : context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(x0.class.getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected AppCompatAutoCompleteTextView b(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox d(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatCheckedTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText f(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton g(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView i(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar k(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatSpinner m(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatTextView n(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatToggleButton o(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View viewK;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = t(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = q1.b(context2);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = Chars.CR;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                viewK = k(context2, attributeSet);
                u(viewK, str);
                break;
            case 1:
                viewK = e(context2, attributeSet);
                u(viewK, str);
                break;
            case 2:
                viewK = i(context2, attributeSet);
                u(viewK, str);
                break;
            case 3:
                viewK = n(context2, attributeSet);
                u(viewK, str);
                break;
            case 4:
                viewK = g(context2, attributeSet);
                u(viewK, str);
                break;
            case 5:
                viewK = l(context2, attributeSet);
                u(viewK, str);
                break;
            case 6:
                viewK = m(context2, attributeSet);
                u(viewK, str);
                break;
            case 7:
                viewK = j(context2, attributeSet);
                u(viewK, str);
                break;
            case '\b':
                viewK = o(context2, attributeSet);
                u(viewK, str);
                break;
            case '\t':
                viewK = h(context2, attributeSet);
                u(viewK, str);
                break;
            case '\n':
                viewK = b(context2, attributeSet);
                u(viewK, str);
                break;
            case 11:
                viewK = d(context2, attributeSet);
                u(viewK, str);
                break;
            case '\f':
                viewK = f(context2, attributeSet);
                u(viewK, str);
                break;
            case '\r':
                viewK = c(context2, attributeSet);
                u(viewK, str);
                break;
            default:
                viewK = p(context2, str, attributeSet);
                break;
        }
        if (viewK == null && context != context2) {
            viewK = s(context2, str, attributeSet);
        }
        if (viewK != null) {
            a(viewK, attributeSet);
        }
        return viewK;
    }
}
