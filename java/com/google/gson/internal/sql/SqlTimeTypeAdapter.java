package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.l0.d;
import com.google.gson.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final i0 b = new i0() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            if (aVar.d() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(com.google.gson.l0.b bVar) throws IOException {
        Time time;
        if (bVar.L() == com.google.gson.l0.c.NULL) {
            bVar.H();
            return null;
        }
        String strJ = bVar.J();
        try {
            synchronized (this) {
                time = new Time(this.a.parse(strJ).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new x("Failed parsing '" + strJ + "' as SQL Time; at path " + bVar.q(), e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Time time) throws IOException {
        String str;
        if (time == null) {
            dVar.w();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        dVar.N(str);
    }

    private SqlTimeTypeAdapter() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }
}
