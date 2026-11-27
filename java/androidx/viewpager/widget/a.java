package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {
    private final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public abstract void a(ViewGroup viewGroup, int i2, Object obj);

    @Deprecated
    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object obj) {
        return -1;
    }

    public CharSequence f(int i2) {
        return null;
    }

    public float g(int i2) {
        return 1.0f;
    }

    public abstract Object h(ViewGroup viewGroup, int i2);

    public abstract boolean i(View view, Object obj);

    public void j() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.a.notifyChanged();
    }

    public void k(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable m() {
        return null;
    }

    @Deprecated
    public void n(View view, int i2, Object obj) {
    }

    public void o(ViewGroup viewGroup, int i2, Object obj) {
        n(viewGroup, i2, obj);
    }

    void p(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    @Deprecated
    public void q(View view) {
    }

    public void r(ViewGroup viewGroup) {
        q(viewGroup);
    }

    public void s(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
