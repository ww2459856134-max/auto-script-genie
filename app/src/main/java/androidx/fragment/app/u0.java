package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class u0 implements LayoutInflater.Factory2 {
    final p1 c;

    u0(p1 p1Var) {
        this.c = p1Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        b2 b2VarV;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.c);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.j.c.a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(h.j.c.b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(h.j.c.c, -1);
        String string = typedArrayObtainStyledAttributes.getString(h.j.c.d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !r0.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentH0 = resourceId != -1 ? this.c.h0(resourceId) : null;
        if (fragmentH0 == null && string != null) {
            fragmentH0 = this.c.i0(string);
        }
        if (fragmentH0 == null && id != -1) {
            fragmentH0 = this.c.h0(id);
        }
        if (fragmentH0 == null) {
            fragmentH0 = this.c.q0().a(context.getClassLoader(), attributeValue);
            fragmentH0.G = true;
            fragmentH0.U = resourceId != 0 ? resourceId : id;
            fragmentH0.V = id;
            fragmentH0.W = string;
            fragmentH0.H = true;
            p1 p1Var = this.c;
            fragmentH0.M = p1Var;
            fragmentH0.O = p1Var.t0();
            fragmentH0.H0(this.c.t0().i(), attributeSet, fragmentH0.d);
            b2VarV = this.c.g(fragmentH0);
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentH0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentH0.H) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentH0.H = true;
            p1 p1Var2 = this.c;
            fragmentH0.M = p1Var2;
            fragmentH0.O = p1Var2.t0();
            fragmentH0.H0(this.c.t0().i(), attributeSet, fragmentH0.d);
            b2VarV = this.c.v(fragmentH0);
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentH0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        fragmentH0.g0 = (ViewGroup) view;
        b2VarV.m();
        b2VarV.j();
        View view2 = fragmentH0.h0;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentH0.h0.getTag() == null) {
            fragmentH0.h0.setTag(string);
        }
        fragmentH0.h0.addOnAttachStateChangeListener(new t0(this, b2VarV));
        return fragmentH0.h0;
    }
}
