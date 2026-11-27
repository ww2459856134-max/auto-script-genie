package h.p.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* loaded from: classes.dex */
class d extends Drawable.ConstantState {
    int a;
    v b;
    AnimatorSet c;
    ArrayList<Animator> d;
    h.d.b<Animator, String> e;

    public d(Context context, d dVar, Drawable.Callback callback, Resources resources) {
        if (dVar != null) {
            this.a = dVar.a;
            v vVar = dVar.b;
            if (vVar != null) {
                Drawable.ConstantState constantState = vVar.getConstantState();
                if (resources != null) {
                    this.b = (v) constantState.newDrawable(resources);
                } else {
                    this.b = (v) constantState.newDrawable();
                }
                v vVar2 = this.b;
                vVar2.mutate();
                v vVar3 = vVar2;
                this.b = vVar3;
                vVar3.setCallback(callback);
                this.b.setBounds(dVar.b.getBounds());
                this.b.h(false);
            }
            ArrayList<Animator> arrayList = dVar.d;
            if (arrayList != null) {
                int size = arrayList.size();
                this.d = new ArrayList<>(size);
                this.e = new h.d.b<>(size);
                for (int i2 = 0; i2 < size; i2++) {
                    Animator animator = dVar.d.get(i2);
                    Animator animatorClone = animator.clone();
                    String str = dVar.e.get(animator);
                    animatorClone.setTarget(this.b.d(str));
                    this.d.add(animatorClone);
                    this.e.put(animatorClone, str);
                }
                a();
            }
        }
    }

    public void a() {
        if (this.c == null) {
            this.c = new AnimatorSet();
        }
        this.c.playTogether(this.d);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
