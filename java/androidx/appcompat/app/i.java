package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
class i extends CursorAdapter {
    private final int c;
    private final int d;
    final /* synthetic */ AlertController.RecycleListView e;
    final /* synthetic */ AlertController f;
    final /* synthetic */ m g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(m mVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.g = mVar;
        this.e = recycleListView;
        this.f = alertController;
        Cursor cursor2 = getCursor();
        this.c = cursor2.getColumnIndexOrThrow(mVar.L);
        this.d = cursor2.getColumnIndexOrThrow(mVar.M);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.c));
        this.e.setItemChecked(cursor.getPosition(), cursor.getInt(this.d) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.g.b.inflate(this.f.M, viewGroup, false);
    }
}
