package h.f.a;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable, d {
    protected boolean c;
    protected boolean d;
    protected Cursor e;
    protected Context f;
    protected int g;

    /* renamed from: h, reason: collision with root package name */
    protected a f1321h;

    /* renamed from: i, reason: collision with root package name */
    protected DataSetObserver f1322i;

    /* renamed from: j, reason: collision with root package name */
    protected e f1323j;

    public c(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    @Override // h.f.a.d
    public Cursor b() {
        return this.e;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.d = true;
        } else {
            this.d = false;
        }
        boolean z = cursor != null;
        this.e = cursor;
        this.c = z;
        this.f = context;
        this.g = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1321h = new a(this);
            this.f1322i = new b(this);
        } else {
            this.f1321h = null;
            this.f1322i = null;
        }
        if (z) {
            a aVar = this.f1321h;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1322i;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.c || (cursor = this.e) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.c) {
            return null;
        }
        this.e.moveToPosition(i2);
        if (view == null) {
            view = g(this.f, this.e, viewGroup);
        }
        e(view, this.f, this.e);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1323j == null) {
            this.f1323j = new e(this);
        }
        return this.f1323j;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.c || (cursor = this.e) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.c && (cursor = this.e) != null && cursor.moveToPosition(i2)) {
            return this.e.getLong(this.g);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.c) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.e.moveToPosition(i2)) {
            if (view == null) {
                view = h(this.f, this.e, viewGroup);
            }
            e(view, this.f, this.e);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i2);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.d || (cursor = this.e) == null || cursor.isClosed()) {
            return;
        }
        this.c = this.e.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.e;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.f1321h;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1322i;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.e = cursor;
        if (cursor != null) {
            a aVar2 = this.f1321h;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f1322i;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.g = cursor.getColumnIndexOrThrow("_id");
            this.c = true;
            notifyDataSetChanged();
        } else {
            this.g = -1;
            this.c = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
