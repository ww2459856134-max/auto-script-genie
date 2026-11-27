package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.l0.d;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final i0 b = new i0() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(com.google.gson.l0.b bVar) throws IOException {
        java.util.Date date;
        if (bVar.L() == com.google.gson.l0.c.NULL) {
            bVar.H();
            return null;
        }
        String strJ = bVar.J();
        try {
            synchronized (this) {
                date = this.a.parse(strJ);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new x("Failed parsing '" + strJ + "' as SQL Date; at path " + bVar.q(), e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.w();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        dVar.N(str);
    }

    private SqlDateTypeAdapter() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }
}
