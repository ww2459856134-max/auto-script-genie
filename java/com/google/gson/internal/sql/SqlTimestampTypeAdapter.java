package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.l0.d;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final i0 b = new i0() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            if (aVar.d() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.m(Date.class));
            }
            return null;
        }
    };
    private final TypeAdapter<Date> a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(com.google.gson.l0.b bVar) throws IOException {
        Date dateB = this.a.b(bVar);
        if (dateB != null) {
            return new Timestamp(dateB.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Timestamp timestamp) throws IOException {
        this.a.d(dVar, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.a = typeAdapter;
    }
}
