package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class x extends RecyclerView.d0 {
    private final SparseArray<View> a;
    private boolean b;
    private boolean c;

    x(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.a = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i2 = a0.a;
        sparseArray.put(i2, view.findViewById(i2));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View b(int i2) {
        View view = this.a.get(i2);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i2);
        if (viewFindViewById != null) {
            this.a.put(i2, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public void f(boolean z) {
        this.c = z;
    }
}
